var V2T_LIST = null;
var tabIndex=6;

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
    getV2TTotalCnt();
    getV2TList();
}

/**
 * 초기작업.
 */
$(document).ready(function(){
    SEARCH_CONDITION.page = CRR_PAGE;
    SEARCH_CONDITION.pageSize = PAGE_SIZE;

    getV2TTotalCnt();

    getV2TList();

    $("#search_btn").click(function(){
        var qstr = $("#query").val();
        var column = $(":input:radio[name=column]:checked").val();
        SEARCH_CONDITION.column = column;
        SEARCH_CONDITION.qstr = qstr;
        SEARCH_CONDITION.page = 1;
        CRR_PAGE = 1;
        var qstr = $("#query").val();
        var column = $(":input:radio[name=column]:checked").val();

        getV2TTotalCnt();
        getV2TList();
    });
});

/**
 * 총 게시물수 요청
 */
function getV2TTotalCnt() {
    var url = API_URL + "/v2t/list/total" + SEARCH_CONDITION.makeQuery();
    var message = {};
    var method = "GET";
    var headers = {
        "Accept": "application/json",
        "Content-Type": "application/json",
        "access_token" : USER.getToken()
    };
    var callbackHandler = {"postHandle" : getV2TTotalCntHandler, "errorHandle" : getV2TListErrHandler };
    hanrwjs.sendRequest(url, message, callbackHandler, method, headers);
}

/**
 * 총 게시물수 요청 성공
 * @param data
 */
function getV2TTotalCntHandler(data) {
    TOTAL_CNT = data;
    PAGING();
}

/**
 * 작업요청 목록 조회
 */
function getV2TList() {
    var url = API_URL + "/v2t/list" + SEARCH_CONDITION.makeQuery();
    var message = {};
    var method = "GET";
    var headers = {
        "Accept": "application/json",
        "Content-Type": "application/json",
        "access_token" : USER.getToken()
    };
    var callbackHandler = {"postHandle" : getV2TListHandler, "errorHandle" : getV2TListErrHandler };
    hanrwjs.sendRequest(url, message, callbackHandler, method, headers);
}

/**
 * 작업요청 목록 조회 성공
 * @param data
 */
function getV2TListHandler(data) {
    V2T_LIST = JSON.parse(data);
    addV2TEls();
}

/**
 * 작업요청 목록 조회 실패
 * @param data
 */
function getV2TListErrHandler(data) {
    alert("작업요청 목록을 불러오지 못하였습니다.\n" + JSON.stringify(data));
}

/**
 * 서버로부터 받아온 정보를 이용하여 리스트를 채운다.
 * @param V2T_LIST
 */
function addV2TEls() {
    $("#v2tListEls>tr").remove();
    var v2t = null;
    var statusTag = null;
    var date = null;
    var dateStr = "";

    $(V2T_LIST).each(function(idx) {
        v2t = V2T_LIST[idx];
        statusTag = getStatusText(v2t.status);
        date = new Date(v2t.reqTime);

        $("#v2tListEls").append(""+
            "<tr class='board-row'>"+
            "<td class='p11'><form><input tabindex='-1' name='select' type='checkbox' disabled='disabled' value='"+ v2t.reqId +"' /></form></td>"+
            "<td class='p11'><span tabindex='" + (++tabIndex) +"'><a href='javascript:;'> "+date.format("yyyy-mm-dd")+"</a></span></td>"+
            "<td class='board-list'><span tabindex='" + (++tabIndex) +"' class='aaa'><a href='javascript:viewReq("+ v2t.reqId +")'>"+ v2t.subject +"</a></span></td>"+
            "<td class='p11'><span tabindex='" + (++tabIndex) +"'>"+ v2t.reqUserName +"</span></td>"+
            "<td class='p11'><span tabindex='" + (++tabIndex) +"'>"+ ((v2t.prcUserName) ? v2t.prcUserName : "없음") +"</span></td>"+
	        getStatusText(v2t.status) +
            "</tr>"+
            "<tr>"+
            "<td colspan='6' class='board-line'></td>"+
            "</tr>"
        );
    });
}

/**
 * 현재 작업상태 코드를 표시가능한 태그로 반환하다.
 * @param status
 * @returns {string}
 */
function getStatusText(status) {
    var statusText = "";

    if (status == "U") statusText = "<td class='p11 color-gray'><span tabindex='" + (++tabIndex) + "'><a href='javascript:;'>확인전</a></span></td>";
    else if (status =="R") statusText = "<td class='p11 color-green'><span tabindex='" + (++tabIndex) + "'><a href='javascript:;'>진행중</a></span></td>";
    else if (status =="C") statusText = "<td class='p11 color-blue'><span tabindex='" + (++tabIndex) + "'><a href='javascript:;'>완료</a></span></td>";
    else statusText = "<td class='p11 color-gray'><span tabindex='" + (++tabIndex) + "'><a href='javascript:;'>확인전</a></span></td>";
    return statusText;
}

/**
 * 보기화면으로 이동
 * @param reqId
 */
function viewReq(reqId) {
    if (reqId > 0)
        $(location).attr("href", CONTEXT_PATH + "/view/v2t/write?menuId="+ MENUID + "&reqId=" + reqId);
    else
        alert("작업요청을 확인할 수 없습니다. (존재하지 않는 요청입니다)");
}