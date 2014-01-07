<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="str" uri="http://jakarta.apache.org/taglibs/string-1.1" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script type="text/javascript" src="<c:url value="/static/js/board/write.js"></c:url>"></script>
<!--게시판 시작-->
<script>
    $(document).ready(function () {
        var viewMode = '<c:out value="${viewMode}"></c:out>';
        if (!hanrwjs.StringUtils.isEmpty(viewMode) && viewMode == 'updateView') {
            $("#subject").val('<c:out value="${board.subject}"></c:out>');
            <%--$("#context").html('<str:replace replace="~n" newlineToken="~n" with="<br/>">${board.context}</str:replace>')--%>
            $("#writerName").val('<c:out value="${board.user.userName}"></c:out>');
            $("#userId").val('<c:out value="${board.userId}"></c:out>');
            var cTime = '<fmt:formatDate pattern="yyyy-MM-dd" value="${board.createTime}"/>';
            $("#createTime").val(cTime);
        }
    });
</script>
<form id="boardWriteForm"  method="post" enctype="multipart/form-data">
<div class="board">
    <table width="100%" border="0" cellspacing="0" cellpadding="10" class="board-box">
        <colgroup>
            <col width="80"/>
            <col width="770"/>
            <col width="80"/>
            <col width="70"/>
        </colgroup>
        <tbody>
        <tr>
            <td colspan="4" class="board-line" style="height:3px;">
                <%--<spring:bind path="loginUser.userId">
                    <input type="hidden"  id="userId" name="${status.expression}" value="${status.value}"/>
                </spring:bind>--%>
                <%--<input type="hidden"  id="userId" name="loginUser.userId" value="${loginUser.userId}"/>--%>
                <input type="hidden"  id="userId" name="userId" value="${loginUser.userId}"/>
                <c:if test="${not empty viewMode && viewMode =='updateView'}">
                    <spring:bind path="board.articleId">
                        <input type="hidden" id="articleId" name="${status.expression}" value="${status.value}">
                    </spring:bind>
                    <spring:bind path="board.parentArticleId">
                        <input type="hidden" id="parentArticleId" name="${status.expression}" value="${status.value}">
                    </spring:bind>
                    <spring:bind path="board.isReply">
                        <input type="hidden" id="isReply" name="${status.expression}" value="${status.value}">
                    </spring:bind>
                    <input type="hidden" id="replyCnt" name="board.replyCnt" value="<c:out value="${board.replyCnt}"></c:out>">

                </c:if>
                <c:if test="${not empty viewMode && viewMode =='replyView'}">
                    <spring:bind path="board.parentArticleId">
                        <input type="hidden" id="parentArticleId" name="${status.expression}" value="${status.value}">
                    </spring:bind>
                    <spring:bind path="board.isReply">
                        <input type="hidden" id="isReply" name="${status.expression}" value="true">
                    </spring:bind>
                </c:if>
                    <%--<spring:bind path="condition.curPage">
                    <c:if test="${not empty status.value}">
                        <input type="hidden" id="curPage" name="${status.expression}" value="${status.value}">">
                        </c:if>
                    </spring:bind>
                    <spring:bind path="condition.qstr">
                        <c:if test="${not empty status.value}">
                          <input type="hidden" id="qstr" name="${status.expression}" value="${status.value}">">
                        </c:if>
                    </spring:bind>--%>
                    <c:if test="${not empty condition.curPage}">
                        <input type="hidden" id="curPage" name="condition.curPage" value="${condition.curPage}">">
                    </c:if>
                    <c:if test="${not empty condition.qstr}">
                        <input type="hidden" id="curPage" name="condition.qstr" value="${condition.qstr}">">
                    </c:if>
            </td>
        </tr>
        <tr align="left" class="bg-color" height="40">
            <td colspan="4" class="p11"><b>게시글 제목:</b>&nbsp
                <spring:bind path="board.subject">
                    <input size="140" id="subject" name="${status.expression}" path="subject" type="text" value="${status.value}"/>
                </spring:bind>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="board-line"></td>
        </tr>
        <tr class="board-row">
            <td colspan="2" class="board-list"></td>
            <td class="board-list"><span id="createTime"></span></td>
            <spring:bind path="loginUser.userName">
                <td class="p11"><a href=""><span id="writerName">${status.value}</span></a></td>
            </spring:bind>
        </tr>
        <tr>
            <td colspan="4" class="board-line"></td>
        </tr>
        <tr class="board-row">
            <td colspan="4" height="400" class="board-text">
                <spring:bind path="board.context">
                    <textarea id="context" name="${status.expression}" cols="130" rows="30"><c:if test="${not empty viewMode && viewMode =='updateView'}">${status.value}</c:if></textarea>
                </spring:bind>

            </td>
        </tr>
        <tr>
            <td colspan="4" class="board-line"></td>
        </tr>
        <tr class="board-row bg-color">
            <td class="bg-color">
                <div class="board-list file-name"><span><b>첨부파일 :</b></span></div>
            </td>
            <td colspan="3" class="board-list">
                <table id="fileAdd" border="0">
                    <tr><td><input type="file"  id="btnFileAdd_0" name="files"/></td></tr>
                    <%--<tr><td><input type="file" name="files"/></td></tr>--%>
                </table>

                <!--
                <div class="file-name">
                    <span>&#8226;첨부파아ㅣㅑㅐㅓ도랴다너ㅏ오패아도ㅓ호하이나저도ㅑㅐㅏ러호ㅑ애긴제목테스트일01.jpg</span>
                    <input type="button" name="file-dlt" id="file-dlt1" value="첨부삭제"/>
                </div>
                <div class="file-name">
                    <span>&#8226;줄바꾸기 테스트 .............첨부파일02.jpg</span>
                    <input type="button" name="file-dlt" id="file-dlt2" value="첨부삭제"/>
                </div>
                <div class="file-name">
                    <span>&#8226;첨부파일03.jpg</span>
                    <input type="button" name="file-dlt" id="file-dlt3" value="첨부삭제"/>
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
</form>
<!-- 게시판 작업 버튼 들어가는 단 -->
<div class="list-works">
    <form class="frmWorks">
        <input type="button" name="file-add" id="btnAttach" value="파일추가"/>

        <input type="button" name="view-list" id="btnCancle" value="취소"/>
        <c:choose>
            <c:when test="${viewMode !=null && viewMode=='updateView'}">
                <input type="button" name="edit" id="btnUpdate" value="수정"/>
            </c:when>
            <c:when test="${viewMode !=null && viewMode=='replyView'}">
                <input type="button" name="edit" id="btnReply" value="등록"/>
            </c:when>
            <c:otherwise>
                <input type="button" name="edit" id="btnWrite" value="저장"/>
           </c:otherwise>
        </c:choose>
        <%--<input type="button" name="answer" id="answer" value="답변" />--%>
        <!--
        <input type="button" name="delete_request" id="delete" value="삭제" />
        <input type="button" name="write" id="write" value="저장" />-->
    </form>
</div>