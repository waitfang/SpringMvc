package com.springmvc.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.websocket.Session; 
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class BaseDAO <T, T1 extends Serializable> {
	
	 private JdbcTemplate jdbcTemplate =new JdbcTemplate();   
	 private DataSource ds; 
	 public BaseDAO() { 
		// ds = GetDataSource();
		// jdbcTemplate.setDataSource(conn);
	 } 
		
	 public JdbcTemplate getJdbcTemplate() {   
         jdbcTemplate =new JdbcTemplate(GetDataSource()); 
        return jdbcTemplate;  
	 }  
	
	 // DataSource
	 private static DriverManagerDataSource GetDataSource() { 
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		dataSource.setUsername("system");
		dataSource.setPassword("sa");
		//JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		//List list = jdbcTemplate.queryForList("select * from COMESITE ");
		//System.out.println(list );
        return dataSource;
    }
	
	 //这个是测试数据连接是否正常
	 private static Connection getConn() {
        Connection conn = null;
        DataSource ds = null;
        try {
            InitialContext ctx = new InitialContext();
            Context ctx2 = (Context) ctx.lookup("java:comp/env");
            ds = (DataSource) ctx2.lookup("jdbcoracle");//名称和连接池设定一致
            conn = ds.getConnection();
        } catch (Exception ex) { 
            ex.printStackTrace();
        }
        return conn;
    }
 
}
