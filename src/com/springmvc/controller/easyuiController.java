package com.springmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.dao.LoginDao;
import com.springmvc.model.LoginMode;

@Controller
public class easyuiController extends BaseController { 
	LoginDao objLoginDao=  new LoginDao();
	
	@RequestMapping("/webPage/demo/easyui")
	public @ResponseBody List<LoginMode> ajaxList(LoginMode objLoginMode) throws Exception
	{  
    	try {
    		System.out.println("ajaxList_Request:"+objLoginMode.getNAME());  
			List objList = objLoginDao.SELECT(objLoginMode);  
			return objList;
    	}catch(Exception ex) {
    		logger.error("ajaxList:"+ex.toString());
    	}
		return null;
	}
	 

}
