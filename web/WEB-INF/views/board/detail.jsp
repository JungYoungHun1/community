<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="tld/MyCustomJstlTag.tld" %>
<div class="p10">
<c:if test="${sessionScope.loginUser.iuser == requestScope.data.iuser}">
    <div>
        <button id="btnMod" data-iboard="${param.iboard}">수정</button>
        <button id="btnDel" data-iboard="${param.iboard}" data-icategory="${data.icategory}">삭제</button>
    </div>
</c:if>
    <div id="data" data-icategory="${data.icategory}" data-iboard="${data.iboard}" data-iuser="${sessionScope.loginUser.iuser}"></div>

<div>카테고리 : ${requestScope.data.nm}</div>
<div>조회수 : ${requestScope.data.hits}</div>
<div>등록일시 : ${requestScope.data.rdt}</div>
<div class="m-r-20">글쓴이 : ${requestScope.data.writernm} <my:profileImg classVal="circular--img wh-30" iuser="${requestScope.data.iuser}" imgIdVal="header-profileimg" profileImgVal="${requestScope.data.profileimg}"/></div>
<div>제목 : ${requestScope.data.title}</div>
<div>내용 : ${requestScope.data.ctnt}</div>
<div>
    <c:if test="${requestScope.prev.previboard > 0}">
        <a href="/board/detail?iboard=${requestScope.prev.previboard}"><input type="button" value="이전글"></a>
    </c:if>
    <c:if test="${requestScope.prev.nextiboard > 0}">
        <a href="/board/detail?iboard=${requestScope.prev.nextiboard}"><input type="button" value="다음글"></a>
    </c:if>
</div>
<c:if test="${sessionScope.loginUser != null}">
    <div class="m-t-20">
        <form id="cmtFrm">
            <input type="text" name ="ctnt">
            <input type="button" id="btn_submit" value="댓글달기">
    </form>
    </div>
</c:if>
<div class="m-t-20" id="cmt_list">댓글 리스트</div>
</div>