package com.phanvu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phanvu.mode.bo.NhanVienBO;
import com.phanvu.model.bean.ChucVu;
import com.phanvu.model.bean.NhanVien;
import com.phanvu.model.bean.PhongBan;

/**
 * Servlet implementation class ThemNhanVienController
 */
@WebServlet("/ThemNhanVien")
public class ThemNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NhanVien nv = new NhanVien();
		ChucVu cv = new ChucVu();
		cv.setMaChucVu(1);
		PhongBan pb = new PhongBan();
		pb.setMaPB(1);

		nv.setFullName("Phan Văn Vũ");
		nv.setAge(21);
		nv.setEmail("asd");
		nv.setAddress("GL");
		nv.setGioiTinh(true);
		nv.setNgaySinh("ádaddadd");
		nv.setPhone("123432554");
		nv.setChucVu(cv);
		nv.setPhongBan(pb);
		NhanVienBO nvBO = new NhanVienBO();
		nvBO.themNhanVien(nv);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
