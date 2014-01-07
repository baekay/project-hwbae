var NEW = 3;
var EDIT = 2;
var VIEW = 1;
var USER_OBJ = null; // 현재 표시중인 사용자 정보.
var USER_LIST = null;

var roleOptNames = ["관리자", "코디", "사용자"];
var roleOptValues = ["ADMIN", "COORD", "USER"];

function PAGING() {
    $("#pageNaviEls>tr").remove();
    // 총 페이지수 조사.
    var curPage = CRR_PAGE;

    var totCnt = TOTAL_CNT;

    var viewItemCnt = PAGE_SIZE;

    var pageCount = parseInt(totCnt/viewItemCnt) + 1;

    var htmlLayout = '<tr>';
    if ( curPage > 5) {
        htmlLayout = htmlLayout + '<td class = "pgL"><a href="javascript:gotoPage(' + (curPage-1) + ')" class="pn">&laquo;이전</a></td>';
    }

    var loopStartNum = curPage -2;

    if ( pageCount <= 5)
    {
        loopStartNum = 1;
    }

    if ( loopStartNum <= 0) {
        loopStartNum = 1;
    }

    var loopEndNum = curPage + 2;
    if ( curPage < 3 ) {
        loopEndNum = 5;
    }
    if ( loopEndNum > pageCount)
    {
        loopEndNum = pageCount;
    }


    for(var i=loopStartNum;i <= loopEndNum;i++) {
        if ( i == curPage) {
            htmlLayout = htmlLayout + '<td class="on"><a href="#">' + i +'</a></td>';
        }else {
            htmlLayout = htmlLayout + '<td><a href="javascript:gotoPage(' + i + ')">' + i +'</a></td>';
        }
    }

    if ( loopEndNum < pageCount) {
        htmlLayout = htmlLayout + '<td class="pgR"><a href="javascript:gotoPage(' + (loopEndNum+1) + ')" class="pn">다음 &raquo;</a> </td>';
    }

    htmlLayout = htmlLayout + '</tr>';

    $("#pageNaviEls").append(htmlLayout);

}

function gotoPage(curPage) {
    SEARCH_CONDITION.page = curPage;
    CRR_PAGE = curPage;
    getP2TTotalCnt();
    getP2TList();
}

/**
 * 초기화.
 */
$(document).ready(function(){
    SEARCH_CONDITION.page = CRR_PAGE;
    SEARCH_CONDITION.pageSize = PAGE_SIZE;
    // 회원정보 요청
    getUserList(SEARCH_CONDITION);
    // 회원등급 셀렉트박스
    hanrwjs.addSelectItem("roleId", roleOptNames, roleOptValues);
    // 초기모드
    changeViewMode(NEW);
    // 버튼이벤트
    $("#add-member").click(function(){
        changeViewMode(NEW);
    });

    $("#search_btn").click(function(){
        var qstr = $("#query").val();
        var column = $(":input:radio[name=column]:checked").val();
        SEARCH_CONDITION.column = column;
        SEARCH_CONDITION.qstr = qstr;

        getUserListTotalCnt();
        getUserList();
    });

    $("#delete-member").click(function(){
        var ids = new Array();
        var idsStr = "";
        $("input[name='select']:checked").each(function(){
            ids.push(this.value);
        });

        if(confirm("정말 삭제하시겠습니까??")) {
            for(var idx= 0, len = ids.length; idx < len; idx++){
                idsStr += "'" + ids[idx] + "'" + ((idx < len-1) ? "," : "");
            }
            deleteUser(idsStr);
        }
    });
});


/**
 * 선택된 사용자 삭제.
 * @param ids
 */
function deleteUser(ids) {
    var url = API_URL + "/user/delete";
    var message = "userIDs=" + ids;
    var method = "GET";
    var headers = {
        "Accept": "application/json",
        "Content-Type": "application/json",
        "access_token" : USER.getToken()
    };
    var callbackHandler = {"postHandle" : deleteUserHandler, "errorHandle" : deleteUserErrHandler };
    hanrwjs.sendRequest(url, message, callbackHandler, method, headers);
}

function deleteUserHandler(data) {
    alert("삭제되었습니다.");
    CRR_PAGE = 1;
    getUserListTotalCnt();
    getUserList();
}

function deleteUserErrHandler(data) {
    alert("사용자 삭제를 실패하였습니다.\n");
}
/**
 * 총 사용자수 요청
 */
function getUserListTotalCnt() {
    USER.getUserTotalCnt(getUserTotalCntGetHandler, getUserListErrHandler, SEARCH_CONDITION.page, SEARCH_CONDITION.pageSize, SEARCH_CONDITION.column, SEARCH_CONDITION.qstr);
}

function getUserTotalCntGetHandler(data) {
    TOTAL_CNT = data;
    PAGING();
}

/**
 * 사용자목록 요청
 * @param SEARCH_CONDITION
 */
function getUserList() {
    USER.getUserList(getUserListGetHandler, getUserListErrHandler, SEARCH_CONDITION.page, SEARCH_CONDITION.pageSize, SEARCH_CONDITION.column, SEARCH_CONDITION.qstr);
}
/**
 * 사용자 정보목록 요청후 성공일 경우 호출되는 콜백
 * @param jsonStr
 */
function getUserListGetHandler(jsonStr) {
    try {
        USER_LIST = JSON.parse(jsonStr);
        makeUserListEls();
    } catch (e) {
        alert("회원목록정보 변환중 오류가 발생하였습니다.\n" + e.message);
    }
}

/**
 * 사용자 정보목록 요청후 실패시 호출되는 콜백
 * @param data
 */
function getUserListErrHandler(data) {
    alert("사용자 목록을 불러오지 못하였습니다.");
}

// UI 관련 스크립트
/**
 * 사용자 목록 구성
 */
function makeUserListEls() {
    $("#userListEls").empty();

    $(USER_LIST).each(function(idx) {
        $("#userListEls").append(""+
            "<tr class=\"board-row\" id=\"USER_LISTEl_"+ idx +"\">"+
            "   <td class=\"p11\"><input name=\"select\" type=\"checkbox\" value=\""+USER_LIST[idx].userId+"\"/></td>"+
            "   <td class=\"p11\" name=\"roleIdEl\">"+ USER_LIST[idx].roleId +"</td>"+
            "   <td class=\"p11\"><span class=\"aaa\"><a href=\"javascript:setUserInfoReset("+idx+")\"  name=\"userIdEl\">"+ USER_LIST[idx].userId +"</a></span></td>"+
            "   <td class=\"p11\" name=\"userNameEl\">"+ USER_LIST[idx].userName +"</td>"+
            "   <td class=\"p11\" name=\"telNoEl\">"+ USER_LIST[idx].telNo +"</td>"+
            "</tr>"+
            "<tr>"+
            "   <td colspan=\"6\" class=\"board-line\"></td>"+
            "</tr>"
        );
    });
}

/**
 * 사용자 정보구성
 * @param idx
 */
function setUserInfoReset(idx) {
    // 사용자 정보 모드를 보기/수정으로 변경
    changeViewMode(EDIT);

    USER_OBJ = USER_LIST[idx];

    if (USER_OBJ) {
        $("#userId").val(USER_OBJ.userId);
        $("#userName").val(USER_OBJ.userName);
        $("#telNo").val(USER_OBJ.telNo);
        $("#email").val(USER_OBJ.email);
        hanrwjs.selectOption("roleId", USER_OBJ.roleId);
    } else {
        alert("사용자 정보가 없습니다.");
    }

}

/**
 * 오른쪽 사용자정보가 단순 보기일때와, 신규/수정 상태일때에 따른 UI를 변화시킨다.
 * @param mode 작업모드를 나타내며, 디폴트는 VIEW 이다.
 */
function changeViewMode(mode) {
    switch(mode) {
        case NEW :
            clearInputEls();
            $("#newPasswordEl").show();
            $("#newPasswordConfirmEl").show();
            $("#edit-info").show();
            $("#edit-info").val("등록 완료");
            $("#edit-info").unbind("click", editBtnHandler);
            $("#edit-info").unbind("click", writeBtnHandler);
            $("#edit-info").bind("click", writeBtnHandler);
            break;
        // 수정과 보기는 버튼의 구성이 같다.
        case VIEW :
        case EDIT :
        default :
            $("#newPasswordEl").show();
            $("#newPasswordConfirmEl").show();
            $("#edit-info").show();
            $("#edit-info").val("수정 완료");
            $("#edit-info").unbind("click", writeBtnHandler);
            $("#edit-info").unbind("click", editBtnHandler);
            $("#edit-info").bind("click", editBtnHandler);
            break;
    } // end of switch.
}

function writeBtnHandler() {
    var newUserId = $("#userId").val();
    var newUserName = $("#userName").val();
    var newUserTelNo = $("#telNo").val();
    var newPassword = $("#newPassword").val();
    var newPasswordConfirm = $("#newPasswordConfirm").val();
    var newRoleId = $("#roleId :selected").val();
    var newEmail = $("#email").val();

    if (hanrwjs.StringUtils.isEmpty(newUserId)) {
        alert("아이디는 필수 입력사항입니다.");
        $("#userId").focus();
        return;
    }
    if (!(hanrwjs.StringUtils.isEmpty(newPassword) && hanrwjs.StringUtils.isEmpty(newPasswordConfirm))) {
        if (newPassword != newPasswordConfirm) {
            alert("비밀번호가 일치하지 않습니다.");
            $("#newPassword").val("").focus();
            $("#newConfirmPassword").val("");
            return;
        }
    }
    if (hanrwjs.StringUtils.isEmpty(newUserName) || SPECIAL_CHAR_PATTERN.test(newUserName)) {
        alert("사용자 이름에 공백이나 특수문자는 올 수 없습니다.")
        $("#userName").focus();
        return;
    }

    if (newRoleId == "ADMIN") {
        if(!confirm("새로 추가되는 사용자를 운영자로 등록하시겠습니까?")) {
            alert("사용자에 의해 등록이 취소되었습니다.");
            $("#roleId").focus();
            return;
        }
    }

    // 사용자 등록.
    var newUser = new User();
    newUser.setId(newUserId);
    newUser.setName(newUserName);
    newUser.setRole(newRoleId);
    newUser.setTelno(newUserTelNo);
    newUser.setEmail(newEmail);
    newUser.setPassword(newPassword);
    newUser.doRegist(USER.getToken(), postHandler, errHandler);
}


function editBtnHandler() {
    var newUserId = $("#userId").val();
    var newUserName = $("#userName").val();
    var newUserTelNo = $("#telNo").val();
    var newPassword = $("#newPassword").val();
    var newPasswordConfirm = $("#newPasswordConfirm").val();
    var newRoleId = $("#roleId :selected").val();
    var newEmail = $("#email").val();
    if (USER_OBJ.userId == newUserId &&
        USER_OBJ.userName == newUserName &&
        USER_OBJ.telNo == newUserTelNo &&
        USER_OBJ.roleId == newRoleId &&
        USER_OBJ.email == newEmail &&
        hanrwjs.StringUtils.isEmpty(newPassword) &&
        hanrwjs.StringUtils.isEmpty(newPasswordConfirm)){

        alert("변경된 정보가 없습니다.");
        $("#userName").focus();
        return;
    }
    if (USER_OBJ.userId != newUserId) {
        alert("사용자 아이디는 변경할 수 없습니다");
        $("#userId").focus();
        return;
    }
    if (!(hanrwjs.StringUtils.isEmpty(newPassword) && hanrwjs.StringUtils.isEmpty(newPasswordConfirm))) {
        if (newPassword != newPasswordConfirm) {
            alert("새로운 비밀번호가 일치하지 않습니다.");
            $("#newPassword").val("").focus();
            $("#newConfirmPassword").val("");
            return;
        }
    }
    if (hanrwjs.StringUtils.isEmpty(newUserName) || SPECIAL_CHAR_PATTERN.test(newUserName)) {
        alert("사용자 이름에 공백이나 특수문자는 올 수 없습니다.")
        $("#userName").focus();
        return;
    }

    if (USER_OBJ.roleId != "ADMIN" && newRoleId == "ADMIN") {
        if(!confirm("현재 사용자를 운영자로 변경하시겠습니까?")) {
            alert("사용자에 의해 등록이 취소되었습니다.");
            $("#roleId").focus();
            return;
        }
    }
    // 사용자 수정.
    var updateUser = new User();
    updateUser.setId(newUserId);
    updateUser.setName(newUserName);
    updateUser.setRole(newRoleId);
    updateUser.setTelno(newUserTelNo);
    updateUser.setEmail(newEmail);
    if (!(hanrwjs.StringUtils.isEmpty(newPassword) && hanrwjs.StringUtils.isEmpty(newPasswordConfirm))) {
        if(newPassword == newPasswordConfirm)
            updateUser.setPassword(newPassword);
    }

    updateUser.doUpdate(USER.getToken(), postHandler, errHandler);
}

function postHandler(data) {
    alert("요청완료");
    getUserList(1,10);
}
function errHandler(data) {
    alert("요청실패\n"+JSON.stringify(data));
}

/**
 * 사용자 정보 입력폼 리셋
 */
function clearInputEls() {
    $("input[type=text]").val("");
    $("input[type=password]").val("");
    hanrwjs.selectOption("roleId", "USER");
}