package com.phanvu.model.dao;

import java.sql.Connection;
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

	/*
	 * public NhanVien findOne(int id) { String sql =
	 * "SELECT * FROM NhanVien WHERE maNV = ?"; NhanVien nv = new NhanVien(); try {
	 * java.sql.PreparedStatement st = cnn.prepareStatement(sql); st.setInt(1, id);
	 * ResultSet rs = st.executeQuery(); while(rs.next()) {
	 * nv.setMaNV(rs.getInt("maNV")); nv.setFullName(rs.getString("fullName"));
	 * nv.setAge(rs.getInt("age")); nv.setGioiTinh(rs.getBoolean("gioiTinh"));
	 * nv.setNgaySinh(rs.getString("ngaySinh"));
	 * nv.setAddress(rs.getString("address")); nv.setEmail(rs.getString("email"));
	 * nv.setPhone(rs.getString("phone"));
	 * nv.setPhongBan(rs.getString("tenPhongBan"));
	 * nv.setChucVu(rs.getString("tenChucVu"));
	 * 
	 * return nv; } } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * return null; }
	 */

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

	public boolean delete(int id) {
		String sql = "DELETE FROM NhanVien WHERE maNV=?";
		try {
			java.sql.PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * public boolean update(NhanVien nv) { String sql =
	 * "UPDATE NhanVien SET fullName=?, age=?, " +
	 * "gioiTinh=?, address=?, phone=?, emai=?, maPB=?, maChucVu=?," +
	 * " WHERE maNV=?"; try { java.sql.PreparedStatement ps =
	 * cnn.prepareStatement(sql); ps.setString(1, nv.getFullName()); ps.setInt(2,
	 * nv.getAge()); ps.setBoolean(3, nv.getGioiTinh()); ps.setString(4,
	 * nv.getAddress()); ps.setString(5, nv.getPhone()); ps.setString(6,
	 * nv.getEmail()); ps.setInt(7, nv.getMaPB()); ps.setInt(8, nv.getMaChucVu());
	 * ps.setInt(9, nv.getMaNV()); ps.executeUpdate(); } catch (SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); return false; } return
	 * true; }
	 */

	/*
	 * public List<NhanVien> search(String key){ List<NhanVien> results = new
	 * ArrayList<NhanVien>(); String sql =
	 * "SELECT * FROM NhanViens WHERE lastname LIKE '%" + key.toLowerCase() + "%'";
	 * try { //java.sql.PreparedStatement preparedStatement =
	 * cnn.prepareStatement(sql); //preparedStatement.setNString(1, key); Statement
	 * st = cnn.createStatement(); ResultSet rs = st.executeQuery(sql);
	 * while(rs.next()) { NhanVien nv = new NhanVien();
	 * nv.setMaNV(rs.getInt("maNV")); nv.setFullName(rs.getString("fullName"));
	 * nv.setAge(rs.getInt("age")); nv.setGioiTinh(rs.getBoolean("gioiTinh"));
	 * nv.setNgaySinh(rs.getString("ngaySinh"));
	 * nv.setAddress(rs.getString("address")); nv.setEmail(rs.getString("email"));
	 * nv.setPhone(rs.getString("phone")); nv.setMaPB(rs.getInt("maPB"));
	 * nv.setMaChucVu(rs.getInt("maChucVu")); } } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return results; }
	 */
}