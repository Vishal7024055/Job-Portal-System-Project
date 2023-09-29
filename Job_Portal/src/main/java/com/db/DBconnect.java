package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	private static Connection con;
	public static Connection getcon() {
		
		try {
			if(con==null) {
				con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/job_portal", "root", "Vishal@123");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	
	
}
