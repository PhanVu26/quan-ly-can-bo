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
 * Servlet implementation class UpdatePB
 */
@WebServlet("/UpdatePB")
public class UpdatePB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/updatePB.jsp");
		PhongBanBO pbBO = new PhongBanBO();
		
		PhongBan pb = pbBO.findOne(Integer.parseInt(request.getParameter("maPB")));
		request.setAttribute("phongban", pb);
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PhongBan pb = new PhongBan();
		pb.setMaPB(Integer.parseInt(request.getParameter("maPB")));
		pb.setTenPB(request.getParameter("tenPB"));
		
		PhongBanBO pbBO = new PhongBanBO();
		
		if(pbBO.updatePB(pb)) {
			RequestDispatcher rd = request.getRequestDispatcher("listPB");
			rd.forward(request, response);
		}
		
		
	}

}
