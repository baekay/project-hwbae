<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
    var REQ_ID = "<c:out value="${pageContext.request.getParameter('reqId')}" ></c:out>";
</script>
<script type="text/javascript" src="<c:url value="/static/js/p2t/write.js"></c:url>"></script>
<!--이미지갤러리-->
<div class="board">
    <div class="board-box-img">
        <div class="big-img">
            <a href="" id="imgLinkEl"><img id="mainImgEl" src=""/></a>
        </div>
        <div class="img-list" style="background-color:white">
            <div style="height:20px"></div>
            <div class="arrow-left" style="color:#202020"><a href="javascript:prevImage()">&#8249;</a></div>
            <div class="small-imgs">
                <a href="javascript:prevImage()">[이전]</a>&nbsp;<li id="nums">1/2</li>&nbsp;<a href="javascript:nextImage()">[다음]</a>
                <!--
                <li><a href="javascript:showImage()"><img src=""/></a></li>
                <li><a href="javascript:showImage()"><img src=""/></a></li>
                <li><a href="javascript:showImage()"><img src=""/></a></li>
                <li><a href="javascript:showImage()"><img src=""/></a></li>
                <li><a href="javascript:showImage()"><img src=""/></a></li>
                <li><a href="javascript:showImage()"><img src=""/></a></li>
                <li><a href="javascript:showImage()"><img src=""/></a></li>
                -->
            </div>
            <div class="arrow-right" style="color:#202020"><a href="javascript:nextImage()">&#8250;</a></div>
        </div>
    </div>
</div>
<!--텍스트창-->
<div class="text-input">
    <textarea name="text-change" id="text-change" cols="1" rows=""></textarea>
</div>
<!-- 게시판 작업 버튼 들어가는 단 -->
<div class="list-works">
    <form class="frmWorks">
        <input type="button" name="view-list" id="view-list" value="목록" />
        <input type="button" name="save-cmplt" id="save-cmplt" value="작업완료" />
        <input type="button" name="save-temp" id="save-temp" value="작업중" />
    </form>
</div>