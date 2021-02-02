package com.stocker.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stocker.dao.ArticleDao;
import com.stocker.dto.ArticleDto;

@WebServlet("/article")
public class Article extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getParameter("id")로 전달 된 pk 값으로 seleck
		String id = request.getParameter("id");
		ArticleDto dto = ArticleDao.select(Integer.parseInt(id));
		
		//TODO ArticleDto 객체를 json으로 변환하여 response.getWrtier().print()
//		String json = "{\"title\": \"" + dto.getTitle() + "\"}";
//		response.getWriter().print(json);
		

		//maven jackson library 사용
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(dto);
		response.setContentType("application/json");	//파일을 읽기전 미리 json 파일이라고 알려준다
		response.getWriter().print(json);
	}

}
