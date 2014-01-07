<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--게시판 단 시작-->
<div class="board">
    <!--미디어플레이어-->
    <div class="board-box-voice">
        <div class="big-img-voice">
        </div>
        <div class="player">
        </div>
        <input type="button" name="file-down" id="file-down" value="음성파일 다운로드" />
    </div>
    <!--텍스트창-->
    <div class="text-input">
        <textarea name="text-change" id="text-change" cols="1" rows="">텍스트를 입력하세요.</textarea>
    </div>
    <!--게시판 단 끝-->
</div>
<!-- 게시판 작업 버튼 들어가는 단 -->
<div class="list-works">
    <form class="frmWorks">
        <input type="button" name="view-list" id="view-list" value="목록" />
        <input type="button" name="save-cmplt" id="save-cmplt" value="작업완료" />
        <input type="button" name="save-temp" id="save-temp" value="임시저장" />
    </form>
</div>
<!--게시판 작업 버튼 단 끝-->
