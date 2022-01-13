<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="tld/MyCustomJstlTag.tld" %>

<c:if test="${sessionScope.loginUser.iuser == requestScope.data.iuser}">
    <div>
        <button id="btnMod" data-iboard="${param.iboard}">수정</button>
        <button id="btnDel" data-iboard="${param.iboard}" data-icategory="${data.icategory}">삭제</button>
    </div>
</c:if>

<div>카테고리 : ${requestScope.data.nm}</div>
<div>조회수 : ${requestScope.data.hits}</div>
<div>등록일시 : ${requestScope.data.rdt}</div>
<div class="m-r-20">글쓴이 : ${requestScope.data.writernm} <my:profileImg classVal="circular--img wh-30" iuser="${requestScope.data.iuser}" imgIdVal="header-profileimg" profileImgVal="${requestScope.data.profileimg}"/></div>
<div>제목 : ${requestScope.data.title}</div>
<div>내용 : ${requestScope.data.ctnt}</div>

