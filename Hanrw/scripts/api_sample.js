/**
 * Created with IntelliJ IDEA.
 * User: yhlee
 * Date: 13. 9. 17.
 * Time: 오후 9:04
 * To change this template use File | Settings | File Templates.
 */

{
    [
        {
            "articleId":5, // 게시글의 아이디
            "user": // 글 작성자의 정보 객체가 들어있음
            {
                "userId":"yhlee",
                "userName":"이용희"
            },
            "subject":"공지사항 필독하세요",
            "context":"게시판 내용이 들어갑니다. 어쩌구저쩌구",
            "isReply":"false", // 조회한 내용이 답글이면 true , 아니면 false
            "createTime":"2013-09-20",
            "replyCnt":2, // 답글 갯수
            "replies": // 답글이 List로 nested되어 있음
                [
                    {
                        "articleId":3,
                        "user": // 글 작성자의 정보 객체가 들어있음
                        {
                            "userId":"yhlee",
                            "userName":"이용희"
                        },
                        "subject":"공지사항 필독하세요",
                        "context":"게시판 내용이 들어갑니다. 어쩌구저쩌구",
                        "isReply":true, // 조회한 내용이 답글이면 true , 아니면 false
                        "parentArticleId" : 5,
                        "createTime":"2013-09-20",
                        "replies": [] // 답글에 답글이 있으면 계속 중첩된 자료구조를 가짐

                    } ,
                    {
                        "articleId":5,
                        "user": // 글 작성자의 정보 객체가 들어있음
                        {
                            "userId":"yhlee",
                            "userName":"이용희"
                        },
                        "subject":"공지사항 필독하세요",
                        "context":"게시판 내용이 들어갑니다. 어쩌구저쩌구",
                        "isReply":true, // 조회한 내용이 답글이면 true , 아니면 false
                        "parentArticleId" : 5,
                        "createTime":"2013-09-20",
                        "replies": [] // 답글에 답글이 있으면 계속 중첩된 자료구조를 가짐

                    }

                ]
        },
        {
            "articleId":4, // 게시글의 아이디
            "user": // 글 작성자의 정보 객체가 들어있음
            {
                "userId":"bosu",
                "userName":"김보수"
            },
            "subject":"공지사항 필독하세요2",
            "context":"게시판 내용이 들어갑니다. 어쩌구저쩌구",
            "isReply":"false", // 조회한 내용이 답글이면 true , 아니면 false
            "createTime":"2013-09-20",
            "replyCnt":0, // 답글 갯수
            "replies": [] // 답글이 없을 경우 비어있는 List 객체가 옴
        }

    ]
}

/*
 <id property="articleId" column="ARTICLE_ID"/>
 <result property="menuId" column="MENU_ID"/>
 <result property="userId" column="author_id"/>
 <result property="subject" column="SUBJECT"/>
 <result property="context" column="CONTEXT"/>
 <result property="isReply" column="REPLY_YN"/>
 <result property="createTime" column="CREATE_TIME"/>
 <association property="user" resultMap="oathUser"/>
 <collection property="attachmentList" resultMap="attachment" notNullColumn="FILE_ID"/>
 <collection property="replies" resultMap="replyItem" notNullColumn="REPLY_ARTICLE_ID"/>

 <resultMap id="attachment" type="Attachment">
 <id property="fileId" column="FILE_ID"/>
 <result property="fileNameSrc" column="FILE_NAME_SRC"/>
 <result property="fileNameSaved" column="FILE_NAME_SAVED"/>
 <result property="filePath" column="FILE_PATH"/>
 <result property="createTime" column="CREATE_TIME"/>
 <result property="articleId" column="articleId"/>
 </resultMap>
 */




var reqMsg =
{
    "articleId":3,
    "menuId":"MNU02",
    "user":{"userId":"yhlee","userName":"이용희"},
    "subject":"공지사항 필독하세요2",
    "context":"게시판 내용이 들어갑니다. 어쩌구저쩌구",
    "isReply":"false", // 조회한 내용이 답글이면 true , 아니면 false
    "createTime":"2013-09-20",
    "replyCnt":0, // 답글 갯수
    "attachmentList":[
                        {
                            "fileId":2,
                            "fileNameSrc":"img_01.jpg", // 업로드하기전 원본 파일명
                            "fileNameSaved":"000099188.jpg",// 시스템에 Unique한 이름으로 변경후 파일명
                            "filePath" : "/attacment/MNU01/0000009918.jpg",
                            "createTime" : "2013-09-23"
                        },
                        {
                            "fileId":3,
                            "fileNameSrc":"img_02.jpg", // 업로드하기전 원본 파일명
                            "fileNameSaved":"000099188.jpg",// 시스템에 Unique한 이름으로 변경후 파일명
                            "filePath" : "/attacment/MNU01/0000009918.jpg",
                            "createTime" : "2013-09-23"
                        }

                     ],
    "replies": [] // 답글이 없을 경우 비어있는 List 객체가 옴, 답글이 있는 경우 "게시판 목록 검색 API 참조"
}
