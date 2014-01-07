<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<tr class="board-row" id='r<c:out value="${replyItem.articleId}"/>' >
    <td class="p11">
        <form>
            <c:choose>
                <c:when test="${replyItem.replyCnt == 0 && ( loginUser.roleId eq 'ADMIN' || replyItem.userId eq loginUser.userId ) }">
                    <input type="checkbox" tabindex="-1" id='item_<c:out value="${replyItem.articleId}"/>' name="<c:out value="${replyItem.articleId}"/>"/>
                </c:when>
                <c:otherwise>
                    <input type="checkbox" tabindex="-1" disabled="true" id='item_<c:out value="${replyItem.articleId}"/>' name="<c:out value="${replyItem.articleId}"/>"/>
                </c:otherwise>
            </c:choose>
        </form>
    </td>
    <td class="p11"><a href="javascript:;"><span><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${replyItem.createTime}"/></span></a></td>
    <td class="board-list"><span class="aaa"><a href="javascript:gotoDetailView(<c:out value='${replyItem.articleId}'/>)"><c:out value="${level}"/> └<c:out value="${replyItem.subject}"/> </a></span></td>
    <%--<td class="board-list"><span class="aaa"><a href="javascript:gotoDetailView(<c:out value='${board.articleId}'/>)"><c:out value="${level}"/> └<c:out value="${board.subject}"/> </a></span></td>--%>
    <td class="p11"><a href="javascript:;"><c:out value="${replyItem.user.userName}"/></a></td>
</tr>
<c:if test="${fn:length(replyItem.replies) gt 0}">
    <c:set var="level" value="${level}　" scope="request"/>
    <c:forEach var="subReply" items="${replyItem.replies}">
        <c:set var="replyItem" value="${subReply}" scope="request" />
        <jsp:include page="reply.jsp" />
    </c:forEach>
</c:if>
