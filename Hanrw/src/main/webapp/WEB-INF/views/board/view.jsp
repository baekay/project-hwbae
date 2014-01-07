<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="str" uri="http://jakarta.apache.org/taglibs/string-1.1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--<% pageContext.setAttribute("NL", "\n"); %>--%>

<script type="text/javascript" src="<c:url value="/static/js/board/view.js"></c:url>"></script>
<!--게시판 시작-->
<div class="board">
    <table width="100%" border="0" cellspacing="0" cellpadding="10" class="board-box">
        <colgroup>
            <col width="80" />
            <col width="770" />
            <col width="80" />
            <col width="70" />
        </colgroup>
        <tbody>
        <tr>
            <td colspan="4" class="board-line" style="height:3px;">
                <input type="hidden" id="articleId" value="<c:out value="${board.articleId}"></c:out>">
                <input type="hidden" id="parentArticleId" value="<c:out value="${board.parentArticleId}"></c:out>">
                <input type="hidden" id="userId" value="<c:out value="${board.userId}"></c:out> ">
                <input type="hidden" id="isReply" value="<c:out value="${board.reply}"></c:out> ">
                <input type="hidden" id="replyCnt" value="<c:out value="${board.replyCnt}"></c:out> ">
                <c:if test="${not empty condition.curPage}">
                    <input type="hidden" id="curPage" value="<c:out value="${condition.curPage}"></c:out>">
                </c:if>
                <c:if test="${not empty condition.qstr}">
                    <input type="hidden" id="qstr" value="<c:out value="${condition.qstr}"></c:out>">
                </c:if>
            </td>
        </tr>
        <tr align="left" class="bg-color" height="40">
            <td colspan="4" class="p11"><b><c:out value="${board.subject}"></c:out></b></td>
        </tr>
        <tr>
            <td colspan="4" class="board-line"></td>
        </tr>
        <tr class="board-row">
            <td colspan="2" class="board-list"></td>
            <td class="board-list"><fmt:formatDate pattern="yyyy-MM-dd" value="${board.createTime}"/></td>
            <td class="p11"><a href=""><c:out value="${board.user.userName}"></c:out></a></td>
        </tr>
        <tr>
            <td colspan="4" class="board-line"></td>
        </tr>
        <tr class="board-row">
            <td colspan="4" height="400" class="board-text"><str:replace replace="~n" newlineToken="~n" with="<br/>">${board.context}</str:replace></td>
        </tr>
        <tr>
            <td colspan="4" class="board-line"></td>
        </tr>
        <tr class="board-row bg-color">
            <td class="bg-color">
                <div class="board-list file-name"><span><b>첨부파일 :</b></span></div>
            </td>
            <td colspan="3" class="board-list">
                <c:if test="${fn:length(board.attachmentList) gt 0}">
                    <c:forEach items="${board.attachmentList}" var="attachment">
                        <div class="file-name">
                            <span><a href="<c:url value="/view/board/attachment/${attachment.fileId}"></c:url>">${attachment.fileNameSrc}</a></span>
                            <%--<input type="button" name="file-dlt" id="file-dlt" value="첨부삭제" />--%>
                        </div>
                    </c:forEach>
                </c:if>
                <!--
                <div class="file-name">
                    <span>&#8226;첨부파아ㅣㅑㅐㅓ도랴다너ㅏ오패아도ㅓ호하이나저도ㅑㅐㅏ러호ㅑ애긴제목테스트일01.jpg</span>
                    <input type="button" name="file-dlt" id="file-dlt" value="첨부삭제" />
                </div>
                <div class="file-name">
                    <span>&#8226;줄바꾸기 테스트 .............첨부파일02.jpg</span>
                    <input type="button" name="file-dlt" id="file-dlt" value="첨부삭제" />
                </div>
                <div class="file-name">
                    <span>&#8226;첨부파일03.jpg</span>
                    <input type="button" name="file-dlt" id="file-dlt" value="첨부삭제" />
                </div>
                -->
            </td>
        </tr>
        <tr>
            <td colspan="4" class="board-line"></td>
        </tr>
        </tbody>
    </table>
</div>
<!-- 게시판 작업 버튼 들어가는 단 -->
<div class="list-works">
    <form class="frmWorks">
        <%--<input type="button" name="file-add" id="btnAttach" value="파일추가" />--%>

        <input type="button" name="view-list" id="btnList" value="목록" />
        <c:if test="${loginUser.userId == 'ADMIN' || board.userId == loginUser.userId}">
            <input type="button" name="edit" id="btnEdit" value="수정" />
        </c:if>
        <input type="button" name="answer" id="btnReply" value="답변" />
        <!--
        <input type="button" name="delete_request" id="delete" value="삭제" />
        <input type="button" name="write" id="write" value="저장" />-->
    </form>
</div>