var User = function() {
    var token = null;
    var id = null;
    var role = null;
    var name = null;
    var email = null;
    var telno = null;
    var password = null;

    /**
     * 멤버변수를 JSON 문자열로반환 (주로 쿠키저장에 사용)
     */
    this.getAllDataToJsonString = function() {
        var obj = {};
        obj.id = id;
        obj.role = role;
        obj.token = token;
        obj.name = name;
        obj.email = email;
        obj.telno = telno;
        obj.password = password;

        return JSON.stringify(obj);
    };
    /**
     * 멤버변수를 JSON 문자열에 저장된 데이타로 복원 (주로 쿠키복원에 사용)
     */
    this.setAllDataFromJsonString = function (str) {
        try {
            var obj = JSON.parse(str);
            id = obj.id;
            token = obj.token;
            name = obj.name;
            email = obj.email;
            role = obj.role;
            telno = obj.telno;
            password = obj.password;

        } catch(e) {
            alert("사용자 정보가 잘못되었습니다.");
            return null;
        }
    };
    /**
     * 사용자정보 초기화
     */
    this.initUser = function() {
        token = null;
        id = null;
        name = null;
        role = null;
        email=null;
        telno = null;
        password = null;
    };
    this.requestUserInfo = function(accessToken, userId, getHandler, errorHandler) {
        this.initUser();
        token = accessToken;

        var headers = {
            "Accept": "application/json",
            "Content-Type": "application/json",
            "access_token" : token
        };
        var callbackHandler = {"postHandle" : getHandler, "errorHandle" : errorHandler };

        hanrwjs.sendRequest(API_URL + "/user/" + userId, {}, callbackHandler, "GET", headers);

    };

    /**
     * 사용자 목록요청
     * @param getHandler
     * @param errHandler
     * @param page
     * @param pageSize
     * @param column
     * @param qstr
     */
    this.getUserList = function(getHandler, errHandler, page, pageSize, column, qstr) {
        var headers = {
            "Accept": "application/json",
            "Content-Type": "application/json",
            "access_token" : token
        };
        var data = "page=" + (page || 1) + "&pageSize=" + (pageSize || 10) + "&column=" + (column||"") + "&qstr=" + (qstr||"");
        var callbackHandler = {"postHandle" : getHandler, "errorHandle" : errHandler };
        hanrwjs.sendRequest(API_URL + "/user/list", data, callbackHandler, "GET", headers);

    };
    /**
     * 총 사용자 수 요청
     * @param getHandler
     * @param errHandler
     * @param page
     * @param pageSize
     * @param column
     * @param qstr
     */
    this.getUserTotalCnt = function(getHandler, errHandler, column, qstr) {
        var headers = {
            "Accept": "application/json",
            "Content-Type": "application/json",
            "access_token" : token
        };
        var data = "column=" + (column||"") + "&qstr=" + (qstr||"");
        var callbackHandler = {"postHandle" : getHandler, "errorHandle" : errHandler };
        hanrwjs.sendRequest(API_URL + "/user/list/total", data, callbackHandler, "GET", headers);

    };
    /**
     * 로그인 상태 반환
     * @return 로그인 상태
     */
    this.isLogin = function() {
        if (token) return true;
        else return false;
    };

    /**
     * 로그인
     */
    this.doLogin = function(loginId, loginPw, postHandler, errorHandler) {
        this.initUser();
        var loginData = {"userId" : loginId, "password" : loginPw};
        var callbackHandler = {"postHandle" : postHandler, "errorHandle" : errorHandler };
        hanrwjs.sendRequest(API_URL + "/user/login", loginData, callbackHandler);
    };

    this.doRegist = function(adminAccessToken, postHandler, errorHandler) {
        var userData = { "userId" : id, "password" : password, "userName" : name, "roleId" : role, "email" : email, "telNo" : telno };
        var callbackHandler = {"postHandle" : postHandler, "errorHandle" : errorHandler};
        hanrwjs.sendRequest(API_URL + "/user/regist", userData, callbackHandler, "POST", {"access_token" : adminAccessToken});
    };

    this.doUpdate = function(adminAccessToken, postHandler, errorHandler) {
        var userData = { "userId" : id, "password" : password, "userName" : name, "roleId" : role, "email" : email, "telNo" : telno };
        var callbackHandler = {"postHandle" : postHandler, "errorHandle" : errorHandler};
        hanrwjs.sendRequest(API_URL + "/user/update", userData, callbackHandler, "POST", {"access_token" : adminAccessToken});
    };

    /**
     * 로그아웃
     */
    this.doLogout = function() {
        this.initUser();
    };


    // getter / setter
    this.getToken = function() {
        return token;
    };
    this.getId = function() {
        return id;
    };
    this.setId = function(val) {
        id = val;
    };
    this.getPassword = function() {
        return password;
    };
    this.setPassword = function(val) {
        password = val;
    }
    this.getName = function() {
        return name;
    };
    this.setName = function(val) {
        name = val;
    };
    this.getEmail = function() {
        return email;
    };
    this.setEmail = function(val) {
        email = val;
    };
    this.getRole = function() {
        return role;
    };
    this.setRole = function(val) {
        role = val;
    };
    this.getTelno = function() {
        return telno;
    };
    this.setTelno = function(val) {
        telno = val;
    };
};