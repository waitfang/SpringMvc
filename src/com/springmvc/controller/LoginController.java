package com.springmvc.controller;
 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.springmvc.dao.LoginDao;
import com.springmvc.model.LoginMode;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 

@Controller
public class LoginController extends BaseController { 
	LoginDao objLoginDao=  new LoginDao();
	
	@RequestMapping("/webPage/demo/login")
    public ModelAndView login(HttpServletRequest request) {
//      String path = request.getParameter("path") + "";
        ModelAndView mav = new ModelAndView();
        mav.addObject("txtMasge", "login");
        LoginMode objLoginMode = new LoginMode();
        objLoginMode.setCOLUMN1(123);
        List objList = objLoginDao.SELECT(objLoginMode);
        mav.addObject("data", objList); 
        logger.error("wait test log");
//        mav.setViewName("/mode/login");
//      System.out.println("path: "+request.getParameter("path"));  
        return mav;
    }
 

	@RequestMapping("/webPage/demo/index")
    public ModelAndView index(HttpServletRequest request) {
//      String path = request.getParameter("path") + "";
        ModelAndView mav = new ModelAndView();
        mav.addObject("txtMasge", "index");
        LoginMode objLoginMode = new LoginMode();
        objLoginMode.setCOLUMN1(123);
        List objList = objLoginDao.SELECT(objLoginMode);
        mav.addObject("data", objList); 
        logger.error("wait test log");
        mav.setViewName("/webPage/demo/conndb");
//      System.out.println("path: "+request.getParameter("path"));  
        return mav;
    }
	
    @RequestMapping("/webPage/demo/ajaxList")
	public @ResponseBody List<LoginMode> ajaxList(LoginMode objLoginMode) throws Exception
	{  
    	try {
    		System.out.println("ajaxList_Request:"+objLoginMode.getNAME());//request.getParameter("NAME"));
			//LoginMode objLoginMode = new LoginMode();
			//objLoginMode.setNAME(request.getParameter("NAME"));
			List objList = objLoginDao.SELECT(objLoginMode); 
//			String JSONdate= JSON.toJSONString(objList);
//			Return °∞redirect:url°±÷ÿ∂®œÚ
			return objList;
    	}catch(Exception ex) {
    		logger.error("ajaxList:"+ex.toString());
    	}
		return null;
	}
 
}
