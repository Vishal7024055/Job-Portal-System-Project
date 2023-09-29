package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.user;

public class UserDao {
	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	public boolean addUser(user u) {
		boolean f= false;
		try {
			String sql="insert into user(name,qualificationl,email,password,role)values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getQualification());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, "user");
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
	public user Login(String em, String ps) {
		user u=null;
		try {
			
			String Sql="select * from user where email=? and password=? ";
			PreparedStatement Ps=con.prepareStatement(Sql);
			Ps.setString(1, em);
			Ps.setString(2, ps);
			ResultSet rs=Ps.executeQuery();
			while(rs.next()) {
				u=new user();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setQualification(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setRole(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
}
	
	
	
	public boolean updateUser(user u) {
		boolean f= false;
		try {
			String sql="update user set name=?,qualificationl=?,email=?,password=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getQualification());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getId());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
	
	
	
}