<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="content">
	<c:forEach var="article" items="${list}">	<!-- ${list} 변수명이 아니라 키값 -->
	
		<div class="item" data-id="${article.id}">
			<img 
				alt="Open modal - ${article.title}"
				src="/images/${article.file_nm}">
			<div>
				<strong>${article.title}</strong>
				<small>${article.author_nm}</small>
			</div>
		</div>
	</c:forEach>	<!-- items는 반복문을 돌 수 있음 var은 변수 선언 -->

</section>

<article id="modal" class="hide">
	<div id="modal_inner"></div>
</article>

<script type="text/javascript" src="/js/modal.js"></script>