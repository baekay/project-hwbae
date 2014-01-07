<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="<c:url value='/static/js/v2t/list.js'></c:url>"></script>
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
        <thead>
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
        <tr>
            <td colspan="6" class="board-line"></td>
        </tr>
        </thead>
        <tbody id="v2tListEls">
        </tbody>
    </table>
</div>
<!-- 게시판 작업 버튼 들어가는 단 -->
<div class="list-works">
    <!--
    <form class="frmWorks">
        <input type="button" name="delete_request" id="delete" value="요청 삭제" />
    </form>
    -->
</div>
<!-- 게시판 목록 페이지  -->
<div class="prev-next">
    <table summary="페이지 네비게이션" class="Pnavi" align="center">
        <tbody id="pageNaviEls">
        </tbody>
    </table>
</div>
<!-- 게시판 목록 검색 -->
<div class="list-search">
    <input type="radio" name="column" value="title" checked="checked" />제목&nbsp;&nbsp;
    <input type="radio" name="column" value="id" />아이디&nbsp;&nbsp;
    <input type="text" name="search" id="query"/>
    <input name="btn_search" type="button" value="검색" id="search_btn" />
</div>