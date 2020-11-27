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
 * Servlet implementation class SearchNV
 */
@WebServlet("/SearchNV")
public class SearchNV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NhanVienBO nvBO = new NhanVienBO();
		int maPB = Integer.parseInt(request.getParameter("phongBan"));
		String key = request.getParameter("keySearch");
		List<NhanVien> listNV;
		
		if(key.equals("")) {
			if(maPB == -1) {
				listNV = nvBO.getAll();
			}
			else {
				listNV = nvBO.searchNV(maPB);
			}
		} else {
			listNV = nvBO.findNVByName(key);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/danhSachNV.jsp");
		
		PhongBanBO pbBO = new PhongBanBO();
		List<PhongBan> listPB = pbBO.getAll();
		
		request.setAttribute("listNV", listNV);
		request.setAttribute("listPB", listPB);
		
		rd.forward(request, response);
	}

}
