package com.phanvu.mode.bo;

import java.util.List;

import com.phanvu.model.bean.ChucVu;
import com.phanvu.model.dao.ChucVuDAO;

public class ChucVuBO {
ChucVuDAO pbDAO = new ChucVuDAO();
	
	public List<ChucVu> getAll(){
		return pbDAO.getAll();
	}
}
