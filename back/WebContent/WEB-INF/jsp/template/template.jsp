<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stocker - ${page}</title>

<link rel="stylesheet" href="/css/common.css">
<link rel="stylesheet" href="/css/${page}.css">

</head>
<body>
	<div id="wrap">
		<header>
			<h1><a href="/">Stocker</a></h1>
			<jsp:include page="./nav_${sessionScope.current_user != null ? 'after' : 'before'}.jsp"/>
		</header>
		<main>
			<jsp:include page="../${page}.jsp"/>
		</main>
	</div>
</body>
</html>