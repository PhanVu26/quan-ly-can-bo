package com.phanvu.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.phanvu.model.bean.PhongBan;

public class PhongBanDAO extends AbstractDAO{
	Connection con = getConnection();
	
	public List<PhongBan> getAll(){
		List<PhongBan> listPhongBan = new ArrayList<PhongBan>();
		String sql = "SELECT * FROM phongban";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				PhongBan pb = new PhongBan();
				pb.setMaPB(rs.getInt("maPB"));
				pb.setTenPB(rs.getString("tenPB"));
				listPhongBan.add(pb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPhongBan;
	}
	
	public boolean insert(PhongBan pb) { 
		String sql = "INSERT INTO phongban(tenPB) values(?)"; 
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, pb.getTenPB()); 
	        preparedStatement.executeUpdate(); 
		} catch (SQLException e) { // TODO
			  e.printStackTrace(); 
			  return false; 
		} return true;
	}

	public boolean delete(int mapb) {
		String sql = "DELETE FROM phongban WHERE mapb=?";
		try {
			java.sql.PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, mapb);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
