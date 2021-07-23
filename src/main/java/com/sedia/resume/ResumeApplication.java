package com.sedia.resume;

import com.sedia.resume.utils.EncryptUtils;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
//test db
import java.sql.*;
//test db

@SpringBootApplication
@Slf4j
@EnableEncryptableProperties
@MapperScan(basePackages = "com.sedia.resume.repository")
public class ResumeApplication implements CommandLineRunner {

    @Autowired
    EncryptUtils encryptUtils;
    
//  //test db
//    // JDBC driver name and database URL
//    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
//    static final String DB_URL = "jdbc:mysql://localhost/resume?serverTimezone=UTC";
//    //  Database credentials
//    static final String USER = "root";
//    static final String PASS = "12345678";
//  //test db
    public static void main(String[] args) {
//    	
//    	//test db
//    	Connection conn = null;
//    	Statement stmt = null;
//    	
//    	
//    	try{
//    	      //STEP 2: Register JDBC driver
//    	      Class.forName("com.mysql.cj.jdbc.Driver");
//
//    	      //STEP 3: Open a connection
//    	      System.out.println("Connecting to a selected database...");
//    	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
//    	      System.out.println("Connected database successfully...");
//    	      
//    	      //STEP 4: Execute a query
//    	      System.out.println("Printing records from the table...");
//    	      stmt = conn.createStatement();
//    	      
//    	      String sql = "SELECT * FROM address";
//    	      ResultSet rs = stmt.executeQuery(sql);
//    	      ResultSetMetaData rsmd = rs.getMetaData();
//    	      int columnsNumber = rsmd.getColumnCount();
//    	      while (rs.next()) {
//    	          for (int i = 1; i <= columnsNumber; i++) {
//    	              if (i > 1) System.out.print(",  ");
//    	              String columnValue = rs.getString(i);
//    	              System.out.print(columnValue + " " + rsmd.getColumnName(i));
//    	          }
//    	          System.out.println("");
//    	      }
//
//    	      //    	      String sql = "INSERT INTO address " +
////    	                   "VALUES (1000, 'test', '12345678')";
////    	      stmt.executeUpdate(sql);
//    	   
//    	   }catch(SQLException se){
//    	      //Handle errors for JDBC
//    	      se.printStackTrace();
//    	   }catch(Exception e){
//    	      //Handle errors for Class.forName
//    	      e.printStackTrace();
//    	   }finally{
//    	      //finally block used to close resources
//    	      try{
//    	         if(stmt!=null)
//    	            conn.close();
//    	      }catch(SQLException se){
//    	      }// do nothing
//    	      try{
//    	         if(conn!=null)
//    	            conn.close();
//    	      }catch(SQLException se){
//    	         se.printStackTrace();
//    	      }//end finally try
//    	   }//end try
//    	   System.out.println("Goodbye!");
//    	 //test db
//    	   
        SpringApplication.run(ResumeApplication.class, args);
        
        
    }

    // properties 加密 https://zhuanlan.zhihu.com/p/136828364
    @Override
    public void run(String... args) {

        String row = ""; // 要加密的字串

        Optional.of(row).filter(StringUtils::isNotEmpty).map(encryptUtils::encrypt)
                .ifPresent(result -> log.info("Encrypt result: {}", result));
    }
}
