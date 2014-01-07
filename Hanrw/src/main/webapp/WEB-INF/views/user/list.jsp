<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="<c:url value='/static/js/user/list.js'></c:url>"></script>
<!--게시판 시작-->
<div class="board">
    <!--회원리스트-->
    <table width="500" border="0" cellspacing="0" cellpadding="0" class="board-box-members">
        <colgroup>
            <col width="10%" />
            <col width="15%" />
            <col width="20%" />
            <col width="15%" />
            <col width="15%" />
            <col width="25%" />
        </colgroup>
        <thead>
        <tr>
            <td colspan="6" class="board-line" style="height:3px;">
            </td>
        </tr>
        <tr align="center" class="bg-color" height="20">
            <td class="p11">선택</td>
            <td class="p11">권한</td>
            <td class="p11">아이디</td>
            <td class="p11">이름</td>
            <td class="p11">전화번호</td>
        </tr>
        <tr>
            <td colspan="6" class="board-line"></td>
        </tr>
        </thead>
        <tbody id="userListEls">
        </tbody>
    </table>



    <!--회원정보-->
    <table width="500" border="0" cellspacing="0" cellpadding="0" class="board-members-info">
        <colgroup>
            <col width="30%" />
            <col width="70%" />
        </colgroup>
        <tbody>
        <tr align="center" class="bg-color" height="50">
            <td colspan="2" class="p11">회원정보</td>
        </tr>
        <tr>
            <td colspan="6" class="board-line"></td>
        </tr>
        <tr align="center" class="board-row" style="height:50px;">
            <td class="p11">아이디</td>
            <td class="p11 board-list"><input id="userId" type="text" value=""/></td>
        </tr>
        <tr align="center" class="board-row" height="30">
            <td class="p11">이름</td>
            <td class="p11 board-list"><input id="userName" type="text" value=""/></td>
        </tr>
        <tr align="center" class="board-row" style="height:50px;">
            <td class="p11">권한</td>
            <td class="p11 board-list">
                <select id="roleId">
                </select>
            </td>
        </tr>
        <!--
        <tr align="center" class="board-row" style="height:50px;"">
        <td class="p11">소속</td>
        <td class="p11 board-list"><input type="text" value="복지대"/></td>
        </tr>
        -->
        <tr align="center" class="board-row" style="height:50px;">
            <td class="p11">전자우편</td>
            <td class="p11 board-list"><input type="text" id="email" value=""/></td>
        </tr>
        <tr align="center" class="board-row" style="height:50px;">
            <td class="p11">전화번호</td>
            <td class="p11 board-list"><input type="text" id="telNo" value=""/></td>
        </tr>

        <!-- 수정/등록 일때만 보임 -->
        <tr id="newPasswordEl" align="center" class="board-row" style="height:50px;">
            <td class="p11">비밀번호</td>
            <td class="p11 board-list"><input type="password" id="newPassword" value=""/></td>
        </tr>
        <tr id="newPasswordConfirmEl" align="center" class="board-row" style="height:50px;">
            <td class="p11">비밀번호 확인</td>
            <td class="p11 board-list"><input type="password" id="newPasswordConfirm" value=""/></td>
        </tr>

        <tr>
            <td colspan="2" class="board-line"></td>
        </tr>
        <tr class="bg-color" height="47">
            <td colspan="2">
                <form class="frmWorks">
                    <input type="button" name="edit-info" id="edit-info" value="등록 완료" />
                </form>
            </td>
        </tr>
        </tbody>
    </table>



</div>

<!-- 게시판 작업 버튼 들어가는 단 -->
<div class="list-works">
    <form class="frmWorks">
        <input type="button" name="add-member" id="add-member" value="회원 추가" />
        <input type="button" name="delete-member" id="delete-member" value="선택 삭제" />
    </form>
</div>
<!-- 게시판 목록 검색 -->
<div class="list-search">
    <input type="radio" name="column" value="name" checked="checked"/>이름&nbsp;&nbsp;
    <input type="radio" name="column" value="id" />아이디&nbsp;&nbsp;
    <input type="text" name="search" id="query"/>
    <input name="btn_search" type="button" value="검색" id="search_btn" />
</div>