package com.phanvu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phanvu.mode.bo.NhanVienBO;
import com.phanvu.mode.bo.PhongBanBO;
import com.phanvu.model.bean.NhanVien;
import com.phanvu.model.bean.PhongBan;

/**
 * Servlet implementation class listNVController
 */
@WebServlet("/listNV")
public class listNVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listNVController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/danhSachNV.jsp");
		NhanVienBO nvBO = new NhanVienBO();
		PhongBanBO pbBO = new PhongBanBO();
		List<NhanVien> listNv = nvBO.getAll();
		List<PhongBan> listPB = pbBO.getAll();
		request.setAttribute("listNV", listNv);
		request.setAttribute("listPB", listPB);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
