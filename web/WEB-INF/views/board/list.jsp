<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="my" uri="tld/MyCustomJstlTag.tld" %>


<div>
    <c:if test="${sessionScope.loginUser != null}">
        <a href="/board/write?icategory=${requestScope.icategory}">글쓰기</a>
    </c:if>
    <h1>보드 리스트</h1>
    <div>
        <c:choose>
            <c:when test="${fn:length(requestScope.list)==0}">
                글이 없습니다.
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>no</th>
                        <th>title</th>
                        <th>hits</th>
                        <th>writer</th>
                        <th>reg date</th>
                    </tr>
                    <c:forEach items="${requestScope.list}" var="item">
                        <tr class="record" data-iboard="${item.iboard}">
                            <td>${item.iboard}</td>
                            <td><c:out value="${item.title}"></c:out></td>
                            <td>${item.hits}</td>
<%--                            <c:set var="profileImg" value="/res/img/defaultProfile.png"/>--%>
<%--                            <c:if test="${item.profileimg != null}">--%>
<%--                                <c:set var="profileImg" value="/images/user/${item.iuser}/${item.profileimg}"/>--%>
<%--                            </c:if>--%>
<%--                            <td class="m-r-20">${item.writernm} <div class=" circular--img circular--size40"><img src="${profileImg}"></div></td>--%>
                            <td class="m-r-20"> <my:profileImg idVal="profile-view"
                                                                               classVal="circular--img wh-30"
                                                                               iuser="${item.iuser}"
                                                                               profileImgVal="${item.profileimg}"/>${item.writernm}</td>
                            <td>${item.rdt}</td>
                        </tr>
                    </c:forEach>

                </table>
            </c:otherwise>
        </c:choose>
    </div>
</div>


