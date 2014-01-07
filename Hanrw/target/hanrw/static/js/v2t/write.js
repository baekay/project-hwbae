var AUDIO_LIST = new Array();
var AUDIO_IDS = null;
var V2T = null;
var CRR_IDX = 0;
var ADO_CNT = 0;

/**
 * 초기작업.
 */
$(document).ready(function(){
    getV2TAudioList(REQ_ID);
    getV2T(REQ_ID);

    $("#view-list").click(function(){ $(location).attr("href", WEB_URL + "/v2t/list?menuId=" + MENUID)});
    $("#save-temp").click(function() { updateReq("R"); });
    $("#save-cmplt").click(function() { updateReq("C"); });
});


/**
 * 변환작업 상태 변경 및 텍스트 저장
 * @param mode
 */
function updateReq(mode) {
    V2T.status = mode;
    V2T.context = $("#text-change").val();
    var url = "";
    if (hanrwjs.StringUtils.isEmpty(V2T.prcUserId)) {
        // processV2T
        url = API_URL + "/v2t/process";

    } else {
        // updateV2T
        url = API_URL + "/v2t/update";
    }
    var message = V2T;
    var method = "POST";
    var headers = {
        "Accept": "application/json",
        "Content-Type": "application/json",
        "access_token" : USER.getToken()
    };
    var callbackHandler = {"postHandle" : function(data) { alert("등록성공"); getV2T(V2T.reqId); }, "errorHandle" : function(data) { alert("등록실패!");} };
    hanrwjs.sendRequest(url, message, callbackHandler, method, headers);

}

/**
 * 작업요청 이미지 아이디 목록 조회
 */
function getV2TAudioList(reqId) {
    var url = API_URL + "/v2t/audio/list/"+reqId;
    var message = {};
    var method = "GET";
    var headers = {
        "Accept": "application/json",
        "Content-Type": "application/json",
        "access_token" : USER.getToken()
    };
    var callbackHandler = {"postHandle" : getV2TAudioListHandler, "errorHandle" : getV2TAudioListErrHandler };
    hanrwjs.sendRequest(url, message, callbackHandler, method, headers);
}


/**
 * 작업요청 목록 조회 성공, 요청사항이 여러 오디오파일로 늘어날것을 대비해 리스트를 받아온다.
 * @param data
 */
function getV2TAudioListHandler(data) {
    AUDIO_IDS = JSON.parse(data);
    ADO_CNT = AUDIO_IDS.length;

    if (ADO_CNT > 0) {
        setDownloadLink();
    }
}

/**
 * 작업요청 목록 조회 실패
 * @param data
 */
function getV2TAudioListErrHandler(data) {
    alert("요청상세 정보를 불러오지 못하였습니다.\n");
}


/**
 * 작업요청 이미지 아이디 목록 조회
 */
function getV2T(reqId) {
    var url = API_URL + "/v2t/"+reqId;
    var message = {};
    var method = "GET";
    var headers = {
        "Accept": "application/json",
        "Content-Type": "application/json",
        "access_token" : USER.getToken()
    };
    var callbackHandler = {"postHandle" : getV2THandler, "errorHandle" : getV2TErrHandler };
    hanrwjs.sendRequest(url, message, callbackHandler, method, headers);
}


function getV2THandler(data) {
    V2T = JSON.parse(data);
    var text = V2T.context || "";
    $("#text-change").text(text);
}

function getV2TErrHandler(data) {
    alert("조회실패");
}

/*
function prevAudio() {
    if (CRR_IDX == 0) {
        alert("첫번째 오디오 입니다.");
    } else {
        $("#mainAudioEl").attr("src", AUDIO_LIST[--CRR_IDX].src);
        chgPage();
    }
}

function nextAudio() {
    if (CRR_IDX == (ADO_CNT - 1)) {
        alert("마지막 오디오 입니다.");
    } else {
        $("#mainAudioEl").attr("src", AUDIO_LIST[++CRR_IDX].src);
        chgPage();
    }
}
*/

function setDownloadLink() {
    $("#file-down").attr("href", API_URL + "/v2t/audio/download/" + AUDIO_IDS[CRR_IDX]).attr("target", "_blank");
}