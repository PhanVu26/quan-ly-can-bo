package com.phanvu.mode.bo;

import java.util.List;

import com.phanvu.model.bean.NhanVien;
import com.phanvu.model.dao.NhanVienDAO;

public class NhanVienBO {
	NhanVienDAO nvDAO = new NhanVienDAO();
	public List<NhanVien> getAll(){
		return nvDAO.getAllNhanViens();
	}
	
	public boolean themNhanVien(NhanVien nv) {
		return nvDAO.insert(nv);
	}
}