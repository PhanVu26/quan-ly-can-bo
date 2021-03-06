package com.phanvu.mode.bo;

import java.util.List;

import com.phanvu.model.bean.PhongBan;
import com.phanvu.model.dao.PhongBanDAO;

public class PhongBanBO {
	PhongBanDAO pbDAO = new PhongBanDAO();
	
	public List<PhongBan> getAll(){
		return pbDAO.getAll();
	}

	public boolean addPB(PhongBan pb) {
		return pbDAO.insert(pb);
	}

	public boolean delete(int maPB) {
		return pbDAO.delete(maPB);
	}

	public boolean updatePB(PhongBan pb) {
		return pbDAO.updatePB(pb);
	}

	public PhongBan findOne(int maPB) {
		return pbDAO.findOne(maPB);
	}
}
