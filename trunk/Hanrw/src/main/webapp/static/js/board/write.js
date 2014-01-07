/**
 *
 * Created with IntelliJ IDEA.
 * User: yhlee
 * Date: 13. 9. 22.
 * Time: 오후 2:11
 * To change this template use File | Settings | File Templates.
 */


$(document).ready(function () {

    $("#boardWriteForm").submit(function (e) {
        var userId = $("#userId").val() || "";
        var subject = $("#subject").val() || "";
        var context = $("#context").val() || "";

        if (subject.isEmpty()) {
            alert("제목을 입력하세요~!");
            $("#subject").focus();
            e.preventDefault();
            return false;
        }

        if (context.isEmpty()) {
            alert("내용을 입력하세요!");
            $("#context").focus();
            e.preventDefault();
            return false;
        }

        if ($.browser.msie) {
            var fileIndex = $('#fileAdd tr').children().length;

            for ( var i=0 ; i < fileIndex ; i++)  {


                var filepath = document.getElementById("btnFileAdd_"+i).value;
                if (hanrwjs.StringUtils.isEmpty(filepath) )
                {
                    continue;
                }
//                alert(filepath);
                var myFSO = new ActiveXObject("Scripting.FileSystemObject");
                var thefile = myFSO.getFile(filepath);
                var size = thefile.size;

                if ( size > 1024*1024*2 ) {
                    alert("[" + filepath + "] 첨부파일의 사이즈가 2Mb를 초과하여 저장할 수 없습니다.");
                    e.preventDefault();
                    return false;
                }


            }
        } else {
            $('input[type="file"]').each(function(i) {

                var files = $(this).get(0).files;
                for (var j=0; file = files[j]; j++) {
                    var size = file.size;
                    if ( size > 1024*1024*2) {
                        alert("[" + file.name + "] 첨부파일의 사이즈가 2Mb를 초과하여 저장할 수 없습니다.");
                        e.preventDefault();
                        return false;
                    }
                }
            });
        }



        /**/
    });

    $("#btnWrite").bind('click', function () {
//        $("#boardWriteForm").action = "/view/board/" + BOARD_ID + "/write";
        $("#boardWriteForm").attr('action',CONTEXT_PATH+"/view/board/" + BOARD_ID + "/write")
        $("#boardWriteForm").submit();
    });

    /* 업데이트 수행 함수 */
    $("#btnUpdate").bind('click', function () {
        if (!confirm("수정하시겠습니까?")) {
            return;
        }

        var board = {};
        board.userId = $("#userId").val();
        board.articleId = $("#articleId").val();
        board.subject = $("#subject").val();
        board.context = $("#context").val();

//        alert(JSON.stringify(board));
        var token = $.cookie("access_token");

        var headers = {
            "Accept": "application/json",
            "Content-Type": "application/json",
            "access_token": token
        };
        var callbackHandler = {"postHandle": boardWritePostHandle, "errorHandle": boardWriteErrorHandle };

        hanrwjs.sendRequest(CONTEXT_PATH + "/app/board/update", board, callbackHandler, "POST", headers);


//        alert(token);
    });

    /* 답글 수행 함수 */
    $("#btnReply").bind('click', function () {
        if (!confirm("답글을 등록하시겠습니까?")) {
            return;
        }

        $("#isReply").val("true");
//        $("#boardWriteForm").action = "/view/board/" + BOARD_ID + "/write";
        $("#boardWriteForm").attr('action',CONTEXT_PATH+"/view/board/" + BOARD_ID + "/write")
        $("#boardWriteForm").submit();

        /*
        var board = {};
        board.parentArticleId = $("#parentArticleId").val();
        board.userId = $("#userId").val();
        board.isReply = true;
        board.subject = $("#subject").val();
        board.context = $("#context").val();

        var token = $.cookie("access_token");

        var headers = {
            "Accept": "application/json",
            "Content-Type": "application/json",
            "access_token": token
        };
        var callbackHandler = {"postHandle": boardWritePostHandle, "errorHandle": boardWriteErrorHandle };
        var reqUrl = CONTEXT_PATH + "/app/board/" + BOARD_ID + "/regist?" + hanrwjs.mkSearchConditionParam();
        hanrwjs.sendRequest(reqUrl, board, callbackHandler, "POST", headers);
        */


//        alert(token);
    });

    $("#btnCancle").bind('click', function () {
        if (confirm("작성을 취소하시겠습니까?")) {

//           alert(strParam);
            window.location.href = CONTEXT_PATH + '/view/board/' + BOARD_ID + '/list?' + hanrwjs.mkSearchConditionParam();
        }
    });

    /* $("#btnFileAdd_0").bind ( 'change',function(e){
     var fileIndex = $('#fileAdd tr').children().length;
     if(this.files[0].size > 1024*1024*2)
     {
     alert("파일 사이즈는 2Mb 를 넘을 수 없습니다.");
     $("#btnFileAdd_0").reset();
     $('#fileAdd').append(
     '<tr><td><input type="file" class="addFileInput" id="btnFileAdd_0" name="files"/></td></tr>');

     }
     })*/

    $("#btnAttach").click(function () {
        var fileIndex = $('#fileAdd tr').children().length;
        $('#fileAdd').append(
            '<tr><td><input type="file" class="addFileInput" id="btnFileAdd_' + fileIndex + '" name="files"/></td></tr>');

        /* $("#btnFileAdd_" + fileIndex).bind ( 'change',function(){
         if(this.files[0].size > 1024*1024*2)
         {
         alert("파일 사이즈는 2Mb 를 넘을 수 없습니다.");
         $("#btnFileAdd_0").remove();
         $('#fileAdd').append(
         '<tr><td><input type="file" class="addFileInput" id="btnFileAdd_0" name="files"/></td></tr>');

         }
         })*/

    });
});


function boardWritePostHandle(result) {
    alert("성공적으로 저장하였습니다.\n");
    var board = JSON.parse(result);
    var articleId = board.articleId;
    window.location.href = CONTEXT_PATH + '/view/board/' + articleId;
}

function boardWriteErrorHandle(error) {
    alert("저장중 오류가 발생하였습니다.\n" + JSON.stringify(error));
}

