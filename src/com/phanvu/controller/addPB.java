package com.phanvu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phanvu.mode.bo.PhongBanBO;
import com.phanvu.model.bean.PhongBan;

/**
 * Servlet implementation class addPB
 */
@WebServlet("/addPB")
public class addPB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/addPB.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PhongBan pb = new PhongBan();
		PhongBanBO pbBO = new PhongBanBO();
		pb.setTenPB(request.getParameter("tenPB"));
		pbBO.addPB(pb);
		
		RequestDispatcher rd = request.getRequestDispatcher("listPB");
		rd.forward(request, response);
	}

}
