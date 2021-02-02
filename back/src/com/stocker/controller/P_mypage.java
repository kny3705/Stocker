package com.stocker.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stocker.dao.UserDao;
import com.stocker.model.User;

@WebServlet("/mypage")
public class P_mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "mypage");
		String jsp = "/WEB-INF/jsp/template/template.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User current = (User) request.getSession().getAttribute("current_user");
		
		User dto = new User();
		dto.setId(current.getId());
		dto.setNm(request.getParameter("nm"));
		
		if(UserDao.update(dto) == 1) {
			current.setNm(request.getParameter("nm"));
		}
		
		response.sendRedirect("/mypage");
	}

}
