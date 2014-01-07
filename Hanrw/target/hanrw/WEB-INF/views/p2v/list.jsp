<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--게시판 시작-->
<div class="board">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="board-box">
        <colgroup>
            <col width="50" />
            <col width="100" />
            <col width="500" />
            <col width="100" />
            <col width="100" />
            <col width="100" />
        </colgroup>
        <tbody>
        <tr>
            <td colspan="6" class="board-line" style="height:3px;">
            </td>
        </tr>
        <tr align="center" class="bg-color" height="20">
            <td class="p11">선택</td>
            <td class="p11">시간</td>
            <td class="p11">제목</td>
            <td class="p11">요청자</td>
            <td class="p11">작업자</td>
            <td class="p11">작업상태</td>
        </tr>
        <tr>
            <td colspan="6" class="board-line"></td>
        </tr>
        <tr class="board-row">
            <td class="p11"><form><input name="select" type="checkbox" disabled="disabled" value="" /></form></td>
            <td class="p11">0000-00-00</td>
            <td class="board-list"><span class="aaa"><a href="<c:out value='${pageContext.request.contextPath}'/>/view/p2v/view?menuId=<c:out value='${pageContext.request.getParameter("menuId")}'/>&userId=<c:out value='${pageContext.request.getParameter("userId")}'/>">딸에게 보내는 심리학 편지</a></span></td>
            <td class="p11"><a href="">홍길동</a></td>
            <td class="p11"><a href="">심청</a></td>
            <td class="p11 color-grey">확인전</td>
        </tr>
        <tr>
            <td colspan="6" class="board-line"></td>
        </tr>
        </tbody>
    </table>
</div>
<!-- 게시판 작업 버튼 들어가는 단 -->
<div class="list-works">
    <form class="frmWorks">
        <input type="button" name="delete_request" id="delete" value="요청 삭제" />
    </form>
</div>
<!-- 게시판 목록 페이지  -->
<div class="prev-next">
    <table summary="페이지 네비게이션" class="Pnavi" align="center">
        <tbody>
        <tr>
            <td class="pgL">
                <a href="#" class="pn">&laquo; 이전</a>
            </td>
            <td class="on">
                <a href="#">1</a>
            </td>
            <td>
                <a href="#">2</a>
            </td>
            <td class="pgR">
                <a href="#">다음 &raquo;</a>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<!-- 게시판 목록 검색 -->
<div class="list-search">
    <form class="frm-search">
        <input type="text" name="search" id="query"/>
        <a href=""><input name="btn_search" type="button" value="검색" id="search_btn"/></a>
    </form>
</div>