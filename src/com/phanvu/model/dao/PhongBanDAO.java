package com.phanvu.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.phanvu.model.bean.ChucVu;
import com.phanvu.model.bean.NhanVien;
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
	
	public boolean updatePB(PhongBan pb) {
		String sql =
				 "UPDATE phongban SET tenPB=? WHERE maPB=?";
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, pb.getTenPB()); 
			preparedStatement.setInt(2, pb.getMaPB()); 
			
	        preparedStatement.executeUpdate(); 
	        return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public PhongBan findOne(int maPB) {
		String sql = "SELECT * FROM phongban WHERE maPB = ?";
		PhongBan pb = new PhongBan();
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setInt(1, maPB);
			ResultSet rs = prst.executeQuery();
			while(rs.next()) {
				
				pb.setMaPB(rs.getInt("maPB"));
				pb.setTenPB(rs.getString("tenPB"));
				
				return pb;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return pb;
	}
}
