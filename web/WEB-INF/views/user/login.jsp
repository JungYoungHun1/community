<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div class="flex-container flex-center flex-direction-column">
    <h1>로그인</h1>
    <div>${requestScope.msg}</div>
    <form action="/user/login" method="post" id="login-frm">
        <div><label>id : <input type="text" name="uid" <%--value="${requestScope.tryLogin.uid}"--%> value="ju39001"></label></div>
        <div><label>password : <input type="password" name="upw" value="ju@13657213"></label></div>
        <div>
            <input type="submit" value="LOGIN">
        </div>
    </form>
    <div><a href="/user/join">join</a></div>
</div>





