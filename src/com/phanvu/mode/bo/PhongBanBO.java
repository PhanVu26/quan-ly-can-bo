package com.phanvu.mode.bo;

import java.util.List;

import com.phanvu.model.bean.PhongBan;
import com.phanvu.model.dao.PhongBanDAO;

public class PhongBanBO {
	PhongBanDAO pbDAO = new PhongBanDAO();
	
	public List<PhongBan> getAll(){
		return pbDAO.getAll();
	}
}
