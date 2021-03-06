package com.stocker.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stocker.dao.ArticleDao;
import com.stocker.dto.ArticleDto;

@WebServlet("/home")
public class P_home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Dto는 속성에 가깝고, Dao는 기능에 가깝다
		List<ArticleDto> list = ArticleDao.selectAll();
		
		request.setAttribute("list", list);
		request.setAttribute("page", "home");
		String jsp = "/WEB-INF/jsp/template/template.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

}
