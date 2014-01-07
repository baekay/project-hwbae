<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/static/js/user/login.js"></script>
<%--
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>복지대학교</title>
    <link rel="stylesheet" type="text/css" href="<c:out value='${pageContext.request.contextPath}'/>/static/css/layout.css" />
    <link rel="stylesheet" type="text/css" href="<c:out value='${pageContext.request.contextPath}'/>/static/css/reset.css" />
    <link rel="stylesheet" type="text/css" href="<c:out value='${pageContext.request.contextPath}'/>/static/css/common.css" />
    <script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/static/js/lib/jquery-1.8.2.js"></script>
    <script>
        var CONTEXT_PATH="<c:out value="${pageContext.request.contextPath}"></c:out>";
    </script>
    <script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/static/js/lib/hanrw_js_common_core.js"></script>
    <script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/static/js/lib/hanrw_js_common_mask.js"></script>
    <script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/static/js/hanrw.js"></script>
    <script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/static/js/hanrw.user.js"></script>
    <script type="text/javascript" src="<c:out value='${pageContext.request.contextPath}'/>/static/js/user/login.js"></script>
</head>

<body>
<div class="container">
--%>
    <!--본문 시작-->
    <div class="login">
        <!--
        <div class="logo">
        </div>
        -->
        <form class="login-form" id="loginForm">
            아이디 <input name="id" id="id" type="text" value="" maxlength="20" />
            비밀번호 <input name="pswd" id="pswd" type="password" value="" maxlength="50" />
            <input name="login" id="login" type="button" value="로그인" />
        </form>
        <div class="usb"></div>
    </div>
<%--
</body>
</html>
--%>