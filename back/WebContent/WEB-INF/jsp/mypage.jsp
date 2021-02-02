<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section id="content">
	<h2>My page</h2>
	<p class="err-msg">${err_msg}</p>
	<form action="/mypage" method="post">
		<div><input type="email" name="email" value="${current_user.email}" readonly></div>
		<div><input type="text" name="nm" value="${current_user.nm}" autocomplete="off" required></div>
		<input type="submit" value="Update">
	</form>
	<a href="/delete">Delete Account</a>
</section>