<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--미디어플레이어-->
<div class="board">
    <div class="board-box-voice">
        <div class="big-img-voice">
        </div>
        <div class="player">
        </div>
        <input type="button" name="file-down" id="file-down" value="음성파일 다운로드" />
    </div>
</div>
<!--텍스트창-->
<div class="text-input">
    <textarea name="text-change" id="text-change" cols="1" rows="">현재 음성에 대한 텍스트</textarea>
</div>
<!-- 게시판 작업 버튼 들어가는 단 -->
<div class="list-works">
    <form class="frmWorks">
        <input type="button" name="view-list" id="view-list" value="목록" />
        <input type="button" name="do" id="do" value="작업" />
        <input type="button" name="delete" id="delete" value="삭제" />
    </form>
</div>