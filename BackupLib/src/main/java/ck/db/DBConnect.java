package ck.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
    String url = DBConfig.getURL();     
    String username = DBConfig.getUsername();
    String password = DBConfig.getPassword();
	
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
	
    static {
	try { 
	    Class.forName( DBConfig.getDriver());
	} catch (ClassNotFoundException e1) { 
	    e1.printStackTrace(); 
	    System.out.println("cannot load the database driver!"); 
	}  		
    }
	
    public void open() {				
	try{   
	    conn =DriverManager.getConnection(url,username,password); 
	}catch(Exception e){  
	    e.printStackTrace();
	    System.out.println("fail to connect to database!"); 
	}
		
	try {
	    stmt = conn.createStatement(); 
	}catch (SQLException e) {
	    e.printStackTrace();
	    System.out.println("cannot create database statement!"); 
	}
    }
	
    public void close() {
	try {
	    if (rs != null) {
		rs.close();
	    }
	    if (stmt != null) {
		stmt.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    System.out.println("database cannot be closed  !");
	}
    }
	
    public  int update(String sql) {	
	try {
	    return stmt.executeUpdate(sql);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return -1;
    }
	
    public  ResultSet query(String sql) {
	try {
	    rs = stmt.executeQuery(sql);
	} catch (SQLException e) {
	    e.printStackTrace();
	}		
	return rs;
    }
	
    public void finalize() {
	close();
    }
}
