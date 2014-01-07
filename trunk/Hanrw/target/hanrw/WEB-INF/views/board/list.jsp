<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script type="text/javascript" src="<c:url value="/static/js/board/list.js"></c:url>"></script>
<!--게시판 시작-->
<script>

    $(document).ready(function () {
        makePageNavi();
    });

    function makePageNavi() {
        var curPage = 1;
        <c:if test="${not empty condition.curPage}">
        curPage = <c:out value="${condition.curPage}"></c:out>;
        </c:if>
        var totCnt = 0;
        <c:if test="${not empty totalCount}">
        totCnt = <c:out value="${totalCount}"></c:out>;
        </c:if>
        var viewItemCnt = 10;
        var pageCount = parseInt(totCnt / viewItemCnt) + 1;

        var htmlLayout = '<tr>';
        if (curPage >= 5 || (curPage > 3 && pageCount > 5)) {
            htmlLayout = htmlLayout + '<td class = "pgL"><a href="javascript:gotoPage(' + (curPage - 1) + ')" class="pn">&laquo;이전</a></td>';
        }

        var loopStartNum = curPage - 2;

        if (pageCount <= 5) {
            loopStartNum = 1;
        }

        if (loopStartNum <= 0) {
            loopStartNum = 1;
        }

        var loopEndNum = curPage + 2;
        if (curPage < 3) {
            loopEndNum = 5;
        }
        if (loopEndNum > pageCount) {
            loopEndNum = pageCount;
        }


        for (var i = loopStartNum; i <= loopEndNum; i++) {
            if (i == curPage) {
                htmlLayout = htmlLayout + '<td class="on"><a href="#">' + i + '</a></td>';
            } else {
                htmlLayout = htmlLayout + '<td><a href="javascript:gotoPage(' + i + ')">' + i + '</a></td>';
            }
        }

        if (loopEndNum < pageCount) {
            htmlLayout = htmlLayout + '<td class="pgR"><a href="javascript:gotoPage(' + (loopEndNum + 1) + ')" class="pn">다음 &raquo;</a> </td>';
        }

        htmlLayout = htmlLayout + '</tr>';

        $("#pageNavi tbody").append(htmlLayout);
    }

    function gotoPage(curPage) {
        var listUrl = CONTEXT_PATH + '/view/board/<c:out value="${boardId}"></c:out>/list?curPage=' + curPage;

        <c:if test="${not empty condition.qstr}">
        listUrl = listUrl + '&column=subject&qstr=<c:out value="${condition.qstr}"></c:out>';
        </c:if>

        window.location.href = listUrl;
//        alert(listUrl);
    }
</script>
<div class="board">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="board-box">
        <colgroup>
            <col width="50"/>
            <col width="200"/>
            <col width="600"/>
            <col width="150"/>
        </colgroup>
        <tbody>
        <tr>
            <td colspan="4" class="board-line" style="height:3px;">
                <c:if test="${not empty condition.curPage}">
                    <input type="hidden" id="curPage" value="<c:out value="${condition.curPage}"></c:out>">
                </c:if>
                <c:if test="${not empty condition.qstr}">
                    <input type="hidden" id="qstr" value="<c:out value="${condition.qstr}"></c:out>">
                </c:if>
            </td>
        </tr>
        <tr align="center" class="bg-color" height="20">
            <td class="p11">선택</td>
            <td class="p11">시간</td>
            <td class="p11">제목</td>
            <td class="p11">작성자</td>
        </tr>
        <tr>
            <td colspan="4" class="board-line"></td>
        </tr>
        <c:forEach var="board" items="${boardList}">
            <tr class="board-row" id='r<c:out value="${board.articleId}"/>'>
                <td class="p11">
                    <form>
                        <c:choose>
                            <c:when test="${board.replyCnt == 0 && ( loginUser.roleId eq 'ADMIN' || board.userId eq loginUser.userId ) }">
                                <input tabindex="-1" type="checkbox" id='item_<c:out value="${board.articleId}"/>'
                                       name="<c:out value="${board.articleId}"/>"/>
                            </c:when>
                            <c:otherwise>
                                <input tabindex="-1" type="checkbox" disabled="true" id='item_<c:out value="${board.articleId}"/>'
                                       name="<c:out value="${board.articleId}"/>"/>
                            </c:otherwise>
                        </c:choose>

                    </form>
                </td>                                                                 <!--생성일 -->
                <td class="p11"><a href="javascript:;"><span><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.createTime}"/></span></a> </td>
                    <%--<td class="board-list"><span class="aaa"><a href="<c:out value='${pageContext.request.contextPath}'/>/view/board/<c:out value='${board.articleId}'/>"><c:out value="${board.subject}"/> </a></span></td>--%>
                <td class="board-list"><span class="aaa"><a
                        href="javascript:gotoDetailView(<c:out value='${board.articleId}'/>)"><c:out
                        value="${board.subject}"/> </a></span></td>
                <td class="p11"><a href="javascript:;"><c:out value="${board.user.userName}"/></a></td>
            </tr>
            <c:if test="${board.replyCnt > 0}">
                <c:set var="level" value="　" scope="request"/>
                <c:forEach var="subReplyItem" items="${board.replies}">
                    <c:set var="replyItem" value="${subReplyItem}" scope="request"/>
                    <jsp:include page="reply.jsp"/>
                </c:forEach>
            </c:if>
        </c:forEach>
        <tr>
            <td colspan="4" class="board-line"></td>
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
        <input type="button" name="delete_request" id="btnDelete" value="선택 삭제"/>
        <input type="button" name="write" id="write" value="글 작성"/>
    </form>
</div>
<!-- 게시판 목록?? 페이지 -->
<div class="prev-next">
    <table summary="페이지 네비게이션" class="Pnavi" id="pageNavi" align="center">
        <tbody>
        <%--<tr>
            <td class="pgL">
                <a href="#" class="pn">&laquo; 이전</a>
            </td>
            <td class="on">
                <a href="#">1</a>
            </td>
            <td>
                <a href="#">2</a>
            </td>
            <td>
                <a href="#">2</a>
            </td>

            <td class="pgR">
                <a href="#">다음 &raquo;</a>
            </td>
        </tr>--%>
        </tbody>
    </table>
</div>
<!--. 게시판 목록 검색 -->
<div class="list-search">
    <form class="frm-search">
        <input type="text" name="search"
               value='<c:if test="${not empty condition.qstr}"><c:out value="${condition.qstr}"></c:out></c:if>'
               id="query"/>
        <a href=""><input name="btn_search" type="button" value="검색" id="btnSearch"/></a>
    </form>
</div>
