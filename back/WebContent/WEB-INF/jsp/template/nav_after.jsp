<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav>
	<ul>
		<li><a href="/home">Home</a></li>
		<li><a href="/explore">Explore</a></li>
		<li><a href="/artist">Artist</a></li>
		<li><a href="/mypage">@${current_user.nm}</a></li>	<!-- sessionScope 쓰면 더 상세히 함 -->
		<li><a href="/logout">Log out</a></li>
	</ul>
</nav>