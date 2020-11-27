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

public class NhanVienDAO extends AbstractDAO {
	Connection cnn = getConnection();


	public NhanVien findOne(int maNV) {
		String sql = "SELECT * FROM ((nhanvien" + " INNER JOIN phongban ON nhanvien.maPB = phongban.maPB)"
				+ " INNER JOIN chucvu ON nhanvien.maChucVu = chucvu.maChucVu) WHERE maNV = ?";
		NhanVien nv = new NhanVien();
		PhongBan phongBan = new PhongBan();
		ChucVu chucVu = new ChucVu();
		try {
			PreparedStatement prst = cnn.prepareStatement(sql);
			prst.setInt(1, maNV);
			ResultSet rs = prst.executeQuery();
			while(rs.next()) {
				
				phongBan.setMaPB(rs.getInt("maPB"));
				phongBan.setTenPB(rs.getString("tenPB"));

				chucVu.setMaChucVu(rs.getInt("maChucVu"));
				chucVu.setTenChucVu(rs.getString("tenChucVu"));

				nv.setMaNV(rs.getInt("maNV"));
				nv.setFullName(rs.getString("fullName"));
				nv.setAge(rs.getInt("age"));
				nv.setGioiTinh(rs.getBoolean("gioiTinh"));
				nv.setNgaySinh(rs.getString("ngaySinh"));
				nv.setAddress(rs.getString("address"));
				nv.setEmail(rs.getString("email"));
				nv.setPhone(rs.getString("phone"));
				nv.setPhongBan(phongBan);
				nv.setChucVu(chucVu);
				
				return nv;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return nv;
	}
	public List<NhanVien> getAllNhanViens() {
		List<NhanVien> results = new ArrayList<NhanVien>();
		String sql = "SELECT * FROM ((nhanvien" + " INNER JOIN phongban ON nhanvien.maPB = phongban.maPB)"
				+ " INNER JOIN chucvu ON nhanvien.maChucVu = chucvu.maChucVu)";
		try {
			Statement st = cnn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				PhongBan phongBan = new PhongBan();
				ChucVu chucVu = new ChucVu();

				phongBan.setMaPB(rs.getInt("maPB"));
				phongBan.setTenPB(rs.getString("tenPB"));

				chucVu.setMaChucVu(rs.getInt("maChucVu"));
				chucVu.setTenChucVu(rs.getString("tenChucVu"));

				nv.setMaNV(rs.getInt("maNV"));
				nv.setFullName(rs.getString("fullName"));
				nv.setAge(rs.getInt("age"));
				nv.setGioiTinh(rs.getBoolean("gioiTinh"));
				nv.setNgaySinh(rs.getString("ngaySinh"));
				nv.setAddress(rs.getString("address"));
				nv.setEmail(rs.getString("email"));
				nv.setPhone(rs.getString("phone"));
				nv.setPhongBan(phongBan);
				nv.setChucVu(chucVu);
				results.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public boolean insert(NhanVien nv) { 
		String sql = "INSERT INTO nhanvien(fullName,age,"
					+ "gioiTinh, ngaySinh, address, phone,"
					+ "email, maPB, maChucVu) values(?,?,?,?,?,?,?,?,?)"; 
		try {
			java.sql.PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setString(1, nv.getFullName()); 
			preparedStatement.setInt(2,nv.getAge()); 
			preparedStatement.setBoolean(3, nv.getGioiTinh());
			preparedStatement.setString(4, nv.getNgaySinh());
			preparedStatement.setString(5, nv.getAddress());
	        preparedStatement.setString(6, nv.getPhone()); 
	        preparedStatement.setString(7, nv.getEmail());
	        preparedStatement.setInt(8, nv.getPhongBan().getMaPB());	  
	        preparedStatement.setInt(9, nv.getChucVu().getMaChucVu());
	        preparedStatement.executeUpdate(); 
		} catch (SQLException e) { // TODO
			  e.printStackTrace(); 
			  return false; 
		} return true;
	}

	public boolean delete(int maNV) {
		String sql = "DELETE FROM NhanVien WHERE maNV=?";
		try {
			java.sql.PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, maNV);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean updateNV(NhanVien nv) {
		String sql =
				 "UPDATE nhanvien SET fullName=?, age=?, " +
				 "gioiTinh=?, ngaySinh= ?, address=?, phone=?, email=?, maPB=?, maChucVu=? " +
				 " WHERE maNV=?";
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setString(1, nv.getFullName()); 
			preparedStatement.setInt(2,nv.getAge()); 
			preparedStatement.setBoolean(3, nv.getGioiTinh());
			preparedStatement.setString(4, nv.getNgaySinh());
			preparedStatement.setString(5, nv.getAddress());
	        preparedStatement.setString(6, nv.getPhone()); 
	        preparedStatement.setString(7, nv.getEmail());
	        preparedStatement.setInt(8, nv.getPhongBan().getMaPB());	  
	        preparedStatement.setInt(9, nv.getChucVu().getMaChucVu());
	        preparedStatement.setInt(10, nv.getMaNV());
	        preparedStatement.executeUpdate(); 
	        return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<NhanVien> findNVByPb(int maPB){
		List<NhanVien> listNV = new ArrayList<NhanVien>();
		String sql = "SELECT * FROM ((nhanvien" + " INNER JOIN phongban ON nhanvien.maPB = phongban.maPB)"
				+ " INNER JOIN chucvu ON nhanvien.maChucVu = chucvu.maChucVu) WHERE nhanvien.maPB = ?";
		try {
			PreparedStatement prst = cnn.prepareStatement(sql);
			prst.setInt(1, maPB);
			ResultSet rs = prst.executeQuery();
			while(rs.next()) {
				NhanVien nv = new NhanVien();
				PhongBan phongBan = new PhongBan();
				ChucVu chucVu = new ChucVu();

				phongBan.setMaPB(rs.getInt("maPB"));
				phongBan.setTenPB(rs.getString("tenPB"));

				chucVu.setMaChucVu(rs.getInt("maChucVu"));
				chucVu.setTenChucVu(rs.getString("tenChucVu"));

				nv.setMaNV(rs.getInt("maNV"));
				nv.setFullName(rs.getString("fullName"));
				nv.setAge(rs.getInt("age"));
				nv.setGioiTinh(rs.getBoolean("gioiTinh"));
				nv.setNgaySinh(rs.getString("ngaySinh"));
				nv.setAddress(rs.getString("address"));
				nv.setEmail(rs.getString("email"));
				nv.setPhone(rs.getString("phone"));
				nv.setPhongBan(phongBan);
				nv.setChucVu(chucVu);
				listNV.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return listNV;
	}
	
	public List<NhanVien> search(String key){
		List<NhanVien> listNV = new ArrayList<NhanVien>();
		String sql = "SELECT * FROM ((nhanvien" + " INNER JOIN phongban ON nhanvien.maPB = phongban.maPB)"
				+ " INNER JOIN chucvu ON nhanvien.maChucVu = chucvu.maChucVu) "
				+ "WHERE nhanvien.fullName LIKE '%" + key.toLowerCase() + "%'";
		try {
			Statement st = cnn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				NhanVien nv = new NhanVien();
				PhongBan phongBan = new PhongBan();
				ChucVu chucVu = new ChucVu();

				phongBan.setMaPB(rs.getInt("maPB"));
				phongBan.setTenPB(rs.getString("tenPB"));

				chucVu.setMaChucVu(rs.getInt("maChucVu"));
				chucVu.setTenChucVu(rs.getString("tenChucVu"));

				nv.setMaNV(rs.getInt("maNV"));
				nv.setFullName(rs.getString("fullName"));
				nv.setAge(rs.getInt("age"));
				nv.setGioiTinh(rs.getBoolean("gioiTinh"));
				nv.setNgaySinh(rs.getString("ngaySinh"));
				nv.setAddress(rs.getString("address"));
				nv.setEmail(rs.getString("email"));
				nv.setPhone(rs.getString("phone"));
				nv.setPhongBan(phongBan);
				nv.setChucVu(chucVu);
				listNV.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return listNV;
	}
}
