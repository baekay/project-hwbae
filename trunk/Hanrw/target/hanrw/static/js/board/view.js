$(document).ready(function(){

    $("#btnEdit").bind('click',function(){
        var articleId = $("#articleId").val();
        window.location.href=CONTEXT_PATH + '/view/board/update/' + articleId +'?' + hanrwjs.mkSearchConditionParam() ; ;

    });
    $("#btnReply").bind('click',function(){
        var articleId = $("#articleId").val();
        window.location.href=CONTEXT_PATH + '/view/board/'+BOARD_ID+'/reply/' + articleId + '?' + hanrwjs.mkSearchConditionParam() ;
    });

    $("#btnList").bind('click',function(){
        var strParam = hanrwjs.mkSearchConditionParam();
        window.location.href=CONTEXT_PATH + '/view/board/'+BOARD_ID+ '/list?' + strParam;
    });





});