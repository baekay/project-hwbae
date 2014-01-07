var IMAGE_LIST = new Array();
var IMAGE_IDS = null;
var P2T = null;
var CRR_IDX = 0;
var IMG_CNT = 0;

/**
 * 초기작업.
 */
$(document).ready(function(){
    getP2TImageList(REQ_ID);
    getP2T(REQ_ID);

    $("#view-list").click(function(){ $(location).attr("href", WEB_URL + "/p2t/list?menuId=" + MENUID)});
    $("#save-temp").click(function() { updateReq("R"); });
    $("#save-cmplt").click(function() { updateReq("C"); });
});


/**
 * 변환작업 상태 변경 및 텍스트 저장
 * @param mode
 */
function updateReq(mode) {
    P2T.status = mode;
    P2T.context = $("#text-change").val();
    var url = "";
    if (hanrwjs.StringUtils.isEmpty(P2T.prcUserId)) {
        // processP2T
        url = API_URL + "/p2t/process";

    } else {
        // updateP2T
        url = API_URL + "/p2t/update";
    }
    var message = P2T;
    var method = "POST";
    var headers = {
        "Accept": "application/json",
        "Content-Type": "application/json",
        "access_token" : USER.getToken()
    };
    var callbackHandler = {"postHandle" : function(data) { alert("등록성공"); getP2T(P2T.reqId); }, "errorHandle" : function(data) { alert("등록실패!");} };
    hanrwjs.sendRequest(url, message, callbackHandler, method, headers);

}

/**
 * 작업요청 이미지 아이디 목록 조회
 */
function getP2TImageList(reqId) {
    var url = API_URL + "/p2t/image/list/"+reqId;
    var message = {};
    var method = "GET";
    var headers = {
        "Accept": "application/json",
        "Content-Type": "application/json",
        "access_token" : USER.getToken()
    };
    var callbackHandler = {"postHandle" : getP2TImageListHandler, "errorHandle" : getP2TImageListErrHandler };
    hanrwjs.sendRequest(url, message, callbackHandler, method, headers);
}


/**
 * 작업요청 목록 조회 성공
 * @param data
 */
function getP2TImageListHandler(data) {
    IMAGE_IDS = JSON.parse(data);
    IMG_CNT = IMAGE_IDS.length;

    $(IMAGE_IDS).each(function(idx) {
       var image = new Image();
       image.src = API_URL + "/p2t/image/" + IMAGE_IDS[idx];
       IMAGE_LIST.push(image);
    });

    if (IMG_CNT > 0) {
        $("#mainImgEl").attr("src", IMAGE_LIST[0].src);
        chgPage();
    }
}

/**
 * 작업요청 목록 조회 실패
 * @param data
 */
function getP2TImageListErrHandler(data) {
    alert("요청상세 정보를 불러오지 못하였습니다.\n");
}


/**
 * 작업요청 이미지 아이디 목록 조회
 */
function getP2T(reqId) {
    var url = API_URL + "/p2t/"+reqId;
    var message = {};
    var method = "GET";
    var headers = {
        "Accept": "application/json",
        "Content-Type": "application/json",
        "access_token" : USER.getToken()
    };
    var callbackHandler = {"postHandle" : getP2THandler, "errorHandle" : getP2TErrHandler };
    hanrwjs.sendRequest(url, message, callbackHandler, method, headers);
}


function getP2THandler(data) {
    P2T = JSON.parse(data);
    var text = P2T.context || "";
    $("#text-change").text(text);
}

function getP2TErrHandler(data) {
    alert("조회실패");
}

function prevImage() {
    if (CRR_IDX == 0) {
        alert("첫번째 이미지 입니다.");
    } else {
        $("#mainImgEl").attr("src", IMAGE_LIST[--CRR_IDX].src);
        chgPage();
    }
}

function nextImage() {
    if (CRR_IDX == (IMG_CNT - 1)) {
        alert("마지막 이미지 입니다.");
    } else {
        $("#mainImgEl").attr("src", IMAGE_LIST[++CRR_IDX].src);
        chgPage();
    }
}

function chgPage() {
    $("#imgLinkEl").attr("href", API_URL + "/p2t/image/download/" + IMAGE_IDS[CRR_IDX]).attr("target", "_blank");
    $("#nums").text((CRR_IDX+1) + "/" + (IMG_CNT));
}