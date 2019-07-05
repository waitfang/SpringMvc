package com.springmvc.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.springmvc.model.LoginMode;
import com.springmvc.model.BaseMode;

public class LoginDao<T> extends BaseDAO<T, Serializable> {

	
	 public List SELECT(T t) {		
		StringBuilder sb = new StringBuilder();
		sb.append("	select * from COMESITE "); 
//		List<Object> queryParams = new ArrayList<Object>(); 
	    List objbean = 	this.findAll(sb);
		return objbean;
	}
	   
	  public List findAll(StringBuilder sb){  
	        List<Map<String, Object>>  objList =  this.getJdbcTemplate().queryForList(sb.toString());  
	        System.out.println("objList.size: "+objList.size());  
	        System.out.println("objList: "+objList);  
	        return objList; 
	  }
	     
}
