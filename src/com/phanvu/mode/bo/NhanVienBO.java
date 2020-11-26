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

	public NhanVien findOne(int maNV) {
		return nvDAO.findOne(maNV);
	}

	public boolean delete(int maNV) {
		return nvDAO.delete(maNV);
	}

	public boolean updateNV(NhanVien nv) {
		return nvDAO.updateNV(nv);
		
	}
}
