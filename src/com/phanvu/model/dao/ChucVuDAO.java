package com.phanvu.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.phanvu.model.bean.ChucVu;

public class ChucVuDAO extends AbstractDAO{
	Connection con = getConnection();
	
	public List<ChucVu> getAll(){
		List<ChucVu> listChucVu = new ArrayList<ChucVu>();
		String sql = "SELECT * FROM chucvu";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				ChucVu cv = new ChucVu();
				cv.setMaChucVu(rs.getInt("maChucVu"));
				cv.setTenChucVu(rs.getString("tenChucVu"));
				listChucVu.add(cv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listChucVu;
	}
}
