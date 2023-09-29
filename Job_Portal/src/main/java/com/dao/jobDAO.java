package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.entity.jobs;
import com.entity.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

public class jobDAO {
	private Connection con;

	public jobDAO(Connection con) {
		super();
		this.con = con;
	}

	public boolean addjob(jobs j) {
		boolean f = false;
		try {
			String sql = "insert into jobs(title,description,category,status,location)values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<jobs> getAlljobs() {
		List<jobs> list = new ArrayList<jobs>();
		jobs j = null;
		try {
			String sql = "select * from jobs order by id desc";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				j = new jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");
				list.add(j);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<jobs> getAlljobsForUser() {
		List<jobs> list = new ArrayList<jobs>();
		jobs j = null;
		try {
			String sql = "select * from jobs where status=? order by id desc";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				j = new jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");
				list.add(j);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	

	public jobs getJobById(int id) {

		jobs j = null;
		try {
			String sql = "select * from jobs where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				j = new jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7) + "");

			}

		} catch (SQLException ex) {
		}
		return j;
	}

	public boolean updateJob(jobs j) {

		boolean f = false;
		try {
			String sql = "update jobs set title=?,description=?,category=?,status=?,location=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			ps.setInt(6, j.getId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public boolean deleteJob(int id) {
		boolean f = false;
		try {
			String sql="delete from jobs where id=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<jobs> getjobsORlocationAndCate(String category, String location){
		List<jobs>list=new ArrayList<jobs>();
		jobs j =null;
		try {
			String sql="select * from jobs where category=? or location=? order by id desc";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, category);
			ps.setString(2, location);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				j=new jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getString(7));
				list.add(j);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<jobs> getjobsANDlocationAndCate(String category, String location){
		List<jobs>list=new ArrayList<jobs>();
		jobs j =null;
		try {
			String sql="select * from jobs where category=? and location=? order by id desc";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, category);
			ps.setString(2, location);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				j=new jobs();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getString(7));
				list.add(j);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		
	}
	


