package com.phanvu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phanvu.mode.bo.ChucVuBO;
import com.phanvu.mode.bo.NhanVienBO;
import com.phanvu.mode.bo.PhongBanBO;
import com.phanvu.model.bean.ChucVu;
import com.phanvu.model.bean.NhanVien;
import com.phanvu.model.bean.PhongBan;

/**
 * Servlet implementation class UpdateNhanVien
 */
@WebServlet("/UpdateNhanVien")
public class UpdateNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/updateNV.jsp");
		ChucVuBO cvBO = new ChucVuBO();
		PhongBanBO pbBO = new PhongBanBO();
		NhanVienBO nvBO = new NhanVienBO();
		
		List<PhongBan> listPB = pbBO.getAll();
		List<ChucVu> listCV = cvBO.getAll();
		NhanVien nv = nvBO.findOne(Integer.parseInt(request.getParameter("maNV")));
		
		request.setAttribute("nhanVien", nv);
		request.setAttribute("listPB", listPB);
		request.setAttribute("listCV", listCV);
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		NhanVien nv = new NhanVien();
		ChucVu cv = new ChucVu();
		cv.setMaChucVu(Integer.parseInt(request.getParameter("chucVu")));
		PhongBan pb = new PhongBan();
		pb.setMaPB(Integer.parseInt(request.getParameter("phongBan")));

		nv.setMaNV(Integer.parseInt(request.getParameter("maNV")));
		nv.setFullName(request.getParameter("fullName"));
		nv.setAge(Integer.parseInt(request.getParameter("age")));
		nv.setEmail(request.getParameter("email"));
		nv.setAddress(request.getParameter("address"));
		nv.setGioiTinh((request.getParameter("gioiTinh").equals("1")));
		nv.setNgaySinh(request.getParameter("ngaySinh"));
		nv.setPhone(request.getParameter("phone"));
		nv.setChucVu(cv);
		nv.setPhongBan(pb);
		NhanVienBO nvBO = new NhanVienBO();
		
		nvBO.updateNV(nv);
		
		RequestDispatcher rd = request.getRequestDispatcher("listNV");
		rd.forward(request, response);
	}

}
