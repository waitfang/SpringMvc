package com.springmvc.controller; 

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.ApkMode;
import com.springmvc.model.LoginMode;

import brut.androlib.ApkDecoder; 
 
@Controller
public class apkController  extends BaseController { 
	
	private String DecodePath = "";//解压目录
	private String javaPath="powershell  java";//powershell  java的位置 ,记得设置环境变量，
	private String apktool;//apktool_2.4.0
	private String ApkPath;//apk设定目录。
	private Process process;
	private String apkFile ="";//apk完整路径
	private List<String> ReturnList = new ArrayList<String>();//返回值
	
	//签名相关
	private String keyPath =  ""; //用于签名的密钥库的路径，打包的时候生成的密钥  
	private String keyAlias = "";//使用密钥库里面密钥的别名 打包的时候写的是什么，这里就填什么。   
	private String keyStorepass = "";//密钥库完整性的口令  
	private String keypass = "";  //密钥的口令
    
	private String pApkName="";
	private String signedApkPath="";//打包签名后新的apk。
	private String versions = "";
	private String mApkName="";
	
	@RequestMapping("/webPage/demo/apk")
    public ModelAndView apk(HttpServletRequest request) { 
        ModelAndView mav = new ModelAndView(); 
        this.DecodeApk();
        return mav;
    }
	
	@RequestMapping("/webPage/demo/ajaxapk")
	public @ResponseBody List<String> ajaxapk(ApkMode objApkMode) throws Exception
	{  
    	try { 
    		ReturnList = new ArrayList<String>();
    		ReturnList.add("1");//预设成功。
    		
    		String ApkName = objApkMode.getApkpath(),
    		serverapkpath =  objApkMode.getServerapkpath()+"\\",
    		pversions =  objApkMode.getVersions(),
    		//签名相关，没有签名apk，无法安装的/
    		pkey0jks =  objApkMode.getKey0jks(),
    		pkeyAlias =  objApkMode.getKeyAlias(),
    		pkeypass =  objApkMode.getKeypass(),
    		pkeyStorepass =  objApkMode.getKeyStorepass();
    		
    		pApkName = ApkName;
    		ApkPath = serverapkpath;
    		apkFile = ApkPath+ApkName;//apk完整目录
    		versions = pversions;//新写入的内容。 
    		mApkName =  pApkName.replace(".apk", "\\");//中间多一层apk名称的文件夹。
    		
    		keyPath =  ApkPath+pkey0jks;
    		keyAlias =  pkeyAlias;
    		keyStorepass = pkeyStorepass;
    		keypass = pkeypass;
    		
    		
    		
    		this.DecodeApk();
    		  
    		ReturnList.add(signedApkPath);//最终成功后的apk
    		
			return ReturnList;
    	}catch(Exception ex) {
    		logger.error("ajaxapk:"+ex.toString());
    		ReturnList.add("0");//失败
    	}
		return ReturnList;
	}
	  
	
	/*
	 * 功能说明。获取apk，并解压到myapp目录
	 * */
	private void DecodeApk() { 
		try { 
			String command ="powershell.exe 'C:Pathtofilescript.ps'";
			process = Runtime.getRuntime().exec(command); 
			//java的位置,如果你有环境变量，可以直接写java 
			//javaPath="powershell  java"; 
			//APK 和解压包都是放WebContent目录的
			//ApkPath = request.getSession().getServletContext().getRealPath("WEB-INF/lib");  
			apktool  =getWebInfPath()+"lib\\apktool_2.4.0.jar"; //jar 放在WEB-INF目录下面lib的路径
			DecodePath = ApkPath+ mApkName+"myapp\\" ;//解压目录
			
			//解压apk文件包
            String unPackageCmd = javaPath+" -jar " + apktool + " d -f -o " + DecodePath + " " + apkFile;
            System.out.println("1.正在执行解压:" + unPackageCmd);
            process = Runtime.getRuntime().exec(unPackageCmd);
            if (process.waitFor() != 0) {
                System.out.println("解压失败，过程终止");
                return;
            }
            process.getOutputStream().close(); 
            System.out.println("解压成功"); 
            
            JsonData();//解压成功后，写入数据。
            
            CreatAPK();//重新打包apk。
		}catch(Exception ex) {
			 ex.toString();
			 ReturnList.add(0, "0"); 
		}
	}
	
	/*
	 * JsonData.json 写入数据
	 * */
	private void JsonData(){
	    //2----内容修改，这里是在assets文件夹里面写入信息
        OutputStreamWriter osw = null;
        try {
            String targetFilePath =  DecodePath + "assets";
            File wfile = new File(targetFilePath);
            if (!wfile.exists()) {
                wfile.mkdirs();
            }
            wfile = new File(wfile, "JsonData.json");
            String content = "这里是解压以后，新写入的内容";
            content ="{\"Versions\":\""+versions+"\"}"; //要用json对象，需要jar，暂时先用string了。
            System.out.println("2.正在执行写入：" + content);
            osw = new OutputStreamWriter(new FileOutputStream(wfile));
            osw.write(content, 0, content.length());
            osw.flush();
            System.out.println("写入文件新内容成功");
        } catch (Exception e) {
        	ReturnList.add(0, "0"); 
            e.printStackTrace();
            System.out.println("写入文件信息出错，过程终止");
            return;
        } finally {
            try {
                osw.close();
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }  
	}

	
	/*
	 * 功能说明：修改后的资源，重新打包
	 * **/
	private void CreatAPK() {
		 try {
			 	String NewAppPath = ApkPath+ mApkName +"NewApp\\" +pApkName;//解压目录
	            String packageCmd =javaPath+" -jar " + apktool + " b -o  " + NewAppPath + " " + DecodePath;
	            System.out.println("3.正在重新打包apk：" + packageCmd);
	            process = Runtime.getRuntime().exec(packageCmd);
	            if (process.waitFor() != 0) {
	                System.out.println("打包失败，过程终止");
	                return;
	            }
	            System.out.println("打包成功");
	            
	            //没有签名，无法安装
	            String jarsignerPath = "powershell  jarsigner";
//	            //用于签名的密钥库的路径，打包的时候生成的密钥
//	            String keyPath =  ApkPath+"key0.jks";
//	            //密钥库完整性的口令
//	            String keyStorepass = "123456";
//	            //使用密钥库里面密钥的别名
//	            String keyAlias = "key0";//打包的时候写的是什么，这里就填什么。
//	            //密钥的口令
//	            String keypass = "123456"; 
	            String singAPK = pApkName.replace(".apk", "")+"_signed.apk";//签名之后的apk名称。
	            //签名以后apk的
	            signedApkPath =  ApkPath+ mApkName+"NewApp\\" +singAPK;
	            
	            String signCmd = jarsignerPath + " -keystore " + keyPath + " -storepass " + keyStorepass + " -signedjar " + signedApkPath + " " + NewAppPath + " -keypass " + keypass + " " + keyAlias;
	            System.out.println("4.正在签名apk：" + signCmd);
	            process = Runtime.getRuntime().exec(signCmd);
	            if (process.waitFor() != 0) {
	            	ReturnList.add(0, "0"); 
	                System.out.println("签名失败。。。");
	                return;
	            }
	            System.out.println("签名成功"); 
	
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	}
	
	
	 /** 
     * 获取WEB-INF目录下面lib的路径 
     * @return 
     */  
    public String getWebInfPath()  
    {  
        //file:/D:/JavaWeb/.metadata/.me_tcat/webapps/TestBeanUtils/WEB-INF/classes/   
        String path=Thread.currentThread().getContextClassLoader().getResource("").toString();  
        path=path.replace('/', '\\'); // 将/换成\  
        path=path.replace("file:", ""); //去掉file:  
        path=path.replace("classes\\", ""); //去掉class\  
        path=path.substring(1); //去掉第一个\,如 \D:\JavaWeb...   
        return path;  
    }  
 
    /*
     * 功能说明：读取目录下的所有文件
     * **/
	@RequestMapping("/webPage/demo/GetFileList")
    public @ResponseBody List<ApkMode> GetFileList(HttpServletRequest request) {
		String strServerAPKPath =  request.getParameter("ServerAPKPath") ;
    	File file = new File(strServerAPKPath);
    	File[] fileList = file.listFiles();
    	List<ApkMode> ReturnFileList = new ArrayList<ApkMode>();//返回值
    	ApkMode objApkMode = new ApkMode();
    	String FileName = "";
    	for(int i=0;i<fileList.length;i++) {
    		objApkMode = new ApkMode();
    		FileName = fileList[i].getName();
    		//只读加密文件和apk文件
    		if(FileName.toUpperCase().indexOf(".JKS") !=-1 || FileName.toUpperCase().indexOf(".APK") != -1) {
    			objApkMode.setFileName(FileName);
    			ReturnFileList.add(objApkMode);
    		}
    	}
    	return ReturnFileList;
    }
    
}
