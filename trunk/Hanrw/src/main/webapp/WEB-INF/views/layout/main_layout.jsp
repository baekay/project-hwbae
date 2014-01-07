<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>복지대학교</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/css/layout.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/css/reset.css' />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/css/common.css' />"/>
    <script type="text/javascript">
        var CONTEXT_PATH="<c:out value="${pageContext.request.contextPath}"></c:out>";
    </script>
    <script type="text/javascript" src="<c:url value='/static/js/lib/jquery-1.8.2.js' />"></script>
    <script type="text/javascript" src="<c:url value='/static/js/lib/hanrw_js_common_core.js' />"></script>
    <script type="text/javascript" src="<c:url value='/static/js/lib/hanrw_js_common_mask.js' />"></script>
    <script type="text/javascript" src="<c:url value='/static/js/hanrw.js' />"></script>
    <script type="text/javascript" src="<c:url value='/static/js/hanrw.user.js'/>"></script>
    <script type="text/javascript">

        var MENUID = "<c:out value='${pageContext.request.getParameter("menuId")}'></c:out>";
        var BOARD_ID="<c:out value="${boardId}"></c:out>";

        /*
         * 현재 로그인중인 사용자 정보 구성.
         */
        var USER = new User();
        var userStr = $.cookie("loginUser");

        if (userStr) {
            userStr = decodeURIComponent(userStr);
            USER.setAllDataFromJsonString(userStr);
        } else {
            /* '13.09.25 로그인 화면을 기본레이아웃에 포함하면서 제거됨
            alert("사용자 정보가 없습니다.");
            $(location).attr("href", WEB_URL + "/user/login");
            */
        }

        // 비인가회원이 접근했을 경우.
        if (!hanrwjs.StringUtils.isEmpty(MENUID)) {
            if (!USER.isLogin()) {
                alert("로그인 후 사용하세요.");
                $(location).attr("href", WEB_URL + "/user/login");
            }
        }


        // 회원관리는 관리자 이외의 회원은 접근할 수 없음
        if (USER.getRole() != "ADMIN" && MENUID == "MNU06") {
            alert("관리자 이외의 회원은 접근할 수 없습니다.");
            $(location).attr("href", WEB_URL + "/p2t/list?menuId=MNU01");
        }


        /**
         * 초기화 작업.
         */
        $(document).ready(function(){
            if (USER.isLogin()) {
                // 사용자 정보 및 로그아웃 버튼 표시
                var logoutEl =  "<span tabindex='-1'><b>"+ USER.getName() +"</b>님 반갑습니다.</span> (<a tabindex='-1' href='javascript:logout();'>로그아웃</a>)<br /><br />";
                $("#logout").html(logoutEl);
            };
        });

        /**
         * 로그아웃
         */
        function logout() {
            USER.initUser();
            //USER = null;
            $.cookie("loginUser", null, { path : "/" });
            $.cookie("access_token", null, { path : "/" });
            $(location).attr("href", WEB_URL + "/user/login");
        }
    </script>

</head>
<body>

<div class="container">
    <div style="padding:20px 20px 0px 0px;">
        1. 시작장애인용 원격교육지원센터는 시작장애대학생만 이용하실 수 있습니다.<br />
        2. 회원가입 및 상담 안내는 031-610-4725 한국복지대학교 원격교육지원센터로 문의하시기 바랍니다.<br />
        3. 시각장애 원격 교육지원은 매년 학기초 지원대상자로 선정된 학생에게만 지원할 수 있습니다.<br />
    </div>
    <div class="header">
        <!-- start -->
        <a tabindex="-1" href="<c:url value='/view/user/login' />"><img src="<c:url value='/static/img/logo.jpg' />" alt="한국복지대학교" name="logo" width="298" height="52" id="logo" style="display:block;" /></a>
        <!-- end .header -->
    </div>
    <div id="logout" class="nav" style="text-align:right;font-size:9pt">
    </div>
    <div class="nav">
        <ul>
            <li class="nav_200<c:if test="${pageContext.request.getParameter('menuId') == 'MNU01'}"><c:out value=' on_200'/></c:if>"><a href="<c:url value='/view/p2t/list?menuId=MNU01'/>"><span tabindex="1">사진변환텍스트</span> </a></li>
            <li class="nav_200<c:if test="${pageContext.request.getParameter('menuId') == 'MNU02'}"><c:out value=' on_200'/></c:if>"><a href="<c:url value='/view/v2t/list?menuId=MNU02' />"><span tabindex='2'>음성변환텍스트</span></a></li>
            <li class="nav_150<c:if test="${boardId == 'MNU03'}"><c:out value=' on_150'/></c:if>"><a href="<c:url value='/view/board/MNU03/list'/>"><span tabindex='3'>보고서</span></a></li>
            <li class="nav_150<c:if test="${boardId == 'MNU04'}"><c:out value=' on_150'/></c:if>"><a href="<c:url value='/view/board/MNU04/list'/>"><span tabindex='4'>화상대독</span></a></li>
            <li class="nav_150<c:if test="${boardId == 'MNU05'}"><c:out value=' on_150'/></c:if>"><a href="<c:url value='/view/board/MNU05/list'/>"><span tabindex='5'>자유게시판</span></a></li>
            <li class="nav_150<c:if test="${pageContext.request.getParameter('menuId') == 'MNU06'}"><c:out value=' on_150'/></c:if>"><a href="<c:url value='/view/user?menuId=MNU06' />"><span tabindex='6'>회원관리</span></a></li>
        </ul>
        <!-- end .nav -->
    </div>
    <div class="content">
        <t:insertAttribute name="content" />
    </div>
    <div class="footer">
        <p style="padding:0px 20px 5px 20px;">
            국립)한국복지대학교<br />
            (459-717)<br />
            경기도 평택시 삼남로 283 / tel. 031-610-4725 / fax. 031-610-4772<br />
            e-mail. <a href="mailto:akich@knuw.ac.kr">mailto:akich@knuw.ac.kr</a><br />
        </p>
        <!-- end .footer -->
    </div>
    <!-- end .container -->
</div>
</body>
</html>