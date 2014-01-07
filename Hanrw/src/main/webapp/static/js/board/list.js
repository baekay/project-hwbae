/**
 * Created with IntelliJ IDEA.
 * User: 용이
 * Date: 13. 9. 22
 * Time: 오전 2:00
 * To change this template use File | Settings | File Templates.
 */
$(document).ready(function(e){
    $( "#write" ).click(function(){
            window.location.href = CONTEXT_PATH + '/view/board/' + BOARD_ID + '/write?' + hanrwjs.mkSearchConditionParam()  ;
        }
    );

    $("#btnDelete").click(function(){
        var selected = new Array();
        $('input:checked').each(function() {
            selected.push($(this).attr('name'));
        });

        if ( selected.length == 0) {
            alert("삭제할 게시물이 없습니다.");
            return;
        }
        if (!confirm(selected.length + "건의 게시물을 삭제하시겠습니까?")){
            return;
        }

        var token = $.cookie("access_token");

        var headers = {
            "Accept": "application/json",
            "Content-Type": "application/json",
            "access_token" : token
        };
        var callbackHandler = {"postHandle" : deletePostHandle, "errorHandle" : deleteErrorHandle };

        hanrwjs.sendRequest(CONTEXT_PATH + "/app/board/delete", selected, callbackHandler, "POST", headers);
    });

    $("#btnSearch").click(function(){
        var qStr = $("#query").val();
        if ( hanrwjs.StringUtils.hasText(qStr)){
           var url = CONTEXT_PATH + '/view/board/' + BOARD_ID + '/list?column=subject&qstr='+qStr;
           window.location.href = url;
        }

        return false;

    });
})

function deletePostHandle(result){
//        alert("삭제하였습니다.\n");
    window.location.reload();
}

function deleteErrorHandle(error) {
    alert("저장중 오류가 발생하였습니다.\n" + JSON.stringify(error));
}

function gotoDetailView(articleId) {

    var strParam = hanrwjs.mkSearchConditionParam();
    window.location.href = CONTEXT_PATH + '/view/board/' + articleId + '?' + strParam;

}



