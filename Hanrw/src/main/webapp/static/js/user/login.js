var USER = new User();

$(document).ready(function(){
    // 쿠키에 저장된 사용자 정보셋팅
    var cookieUser = new User();
    var cookieUserStr = $.cookie("loginUser");

	$("#id").focus();

    if (cookieUserStr) {
        cookieUser.setAllDataFromJsonString($.cookie("loginUser"));
        // 로그인상태 확인
        if (cookieUser.isLogin()) {
            USER = cookieUser;
            $.cookie("access_token", USER.getToken(), { path : "/"});
            $(location).attr("href", WEB_URL + "/p2t/list?menuId=MNU01");
            return;
        }
    }

	$(document).keyup(function(e){
		if(e.keyCode == 13) {
			$("#loginForm").submit();
		}
	});

    // 이벤트등록
    //$("#login").click(function(){ doLogin(); });
	$("#login").click(function(){
		$("#loginForm").submit();
	});

	$("#loginForm").submit(function(e){
		e.preventDefault();
		doLogin();
		//alert("submit!");
	});

});


/**
 * 사용자 로그인 요청
 */
function doLogin() {
    var loginId = $("#id").val();

	if ( hanrwjs.StringUtils.isEmpty(loginId)) {
		alert("로그인 아이디를 입력하세요!");
		$("#id").focus();
		return false;
	}

    var loginPw = $("#pswd").val();
	if ( hanrwjs.StringUtils.isEmpty(loginPw)) {
		alert("패스워드를 입력하세요!");
		$("#pswd").focus();
		return false;
	}

    USER.doLogin(loginId, loginPw, reqHandler, errHandler);

}

function reqHandler(resData) {
    // 사용자 정보 요청
    getUser(JSON.parse(resData).accessToken, $("#id").val());
}

function errHandler(resData) {
    alert("로그인 정보가 잘못되었습니다.");
}

/**
 * 사용자 정보 요청
 */
function getUser(accessToken, loginId) {
    USER.requestUserInfo(accessToken, loginId, getUserPostHandler, getUserErrorHandler);

}

function getUserPostHandler(data){
    if (data) {
        data = JSON.parse(data);
        USER.setId(data.userId);
        USER.setName(data.userName);
        USER.setRole(data.roleId);
        USER.setTelno(data.telNo);
        USER.setEmail(data.email);
        $.cookie("loginUser", USER.getAllDataToJsonString(), { path : "/" });
        $.cookie("access_token", USER.getToken(), { path : "/"});
        $(location).attr("href", WEB_URL + "/p2t/list?menuId=MNU01");

    } else {
        alert("사용자 정보를 요청하지 못하였습니다.");
    }

}

function getUserErrorHandler(data) {
    alert("사용자 정보 요청을 실패하였습니다." /*+ JSON.stringify(data)*/);
}