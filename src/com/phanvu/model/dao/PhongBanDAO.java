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
}
