package com.phanvu.model.bean;

public class NhanVien {
	private int maNV;
	private String fullName;
	private int age;
	private boolean gioiTinh;
	private String ngaySinh;
	private String address;
	private String phone;
	private String email;
	private ChucVu chucVu;
	private PhongBan phongBan;
	
	public NhanVien() {
		
	}
	
	public boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ChucVu getChucVu() {
		return chucVu;
	}
	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}
	public PhongBan getPhongBan() {
		return phongBan;
	}
	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}
	
	
}
