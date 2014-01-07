package kr.ac.hanrw.webapp.dao;

import kr.ac.hanrw.webapp.dto.Attachment;
import kr.ac.hanrw.webapp.dto.Board;
import kr.ac.hanrw.webapp.dto.BoardSearchCondition;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: yhlee
 * Date: 13. 9. 15.
 * Time: 오전 1:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TransactionConfiguration
@Transactional
public class BoardDaoTests extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    protected BoardDao boardDao = null;

    @Autowired
    protected DataSource dataSource = null;

    final static File testImageFile = new File("src\\test\\resources\\test_image.png");
    FileInputStream fis = null;

    @Before
    public void setEnv() throws IOException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("DELETE FROM board_attachment");
        jdbcTemplate.update("DELETE FROM board_master");
        jdbcTemplate.execute("DELETE FROM p2t_job_prc");
        jdbcTemplate.execute("DELETE FROM p2t_job_req");
        jdbcTemplate.execute("DELETE FROM v2t_job_prc");
        jdbcTemplate.execute("DELETE FROM v2t_job_req");
        jdbcTemplate.update("DELETE FROM user_master");


    }

    @Test
    public void testInsertBoard() throws Exception {

        jdbcTemplate.execute("INSERT user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO) VALUE('yhlee','yonghee','','',CURRENT_TIMESTAMP,'ADMIN','') ");

        Board board = new Board();
        board.setMenuId("MNU03");
        board.setSubject("subject01");
        board.setUserId("yhlee");
        board.setContext("context..context");

        boardDao.insertBoard(board);
        System.out.println("BOARD inserted: " + board.getArticleId());
        assertNotNull(board.getArticleId());
//        assertThat(1, is(board.getArticleId()));

        Map resultMap = jdbcTemplate.queryForMap("select  MENU_ID ,USER_ID ,ARTICLE_ID ,PARENT_ARTICLE_ID ,SUBJECT ,CONTEXT ,REPLY_YN ,CREATE_TIME from board_master where article_id='" + board.getArticleId() + "'");

        assertThat("yhlee", is(board.getUserId()));


        jdbcTemplate.execute("INSERT user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO) VALUE('yhlee1','yonghee','','',CURRENT_TIMESTAMP,'ADMIN','') ");

        Board board1 = new Board();
        board1.setMenuId("MNU03");
        board1.setSubject("subject01");
        board1.setUserId("yhlee1");
        board1.setContext("context..context");

        boardDao.insertBoard(board1);
        System.out.println(board1.getArticleId());
        assertNotNull(board1.getArticleId());

        Map resultMap1 = jdbcTemplate.queryForMap("select  MENU_ID ,USER_ID ,ARTICLE_ID ,PARENT_ARTICLE_ID ,SUBJECT ,CONTEXT ,REPLY_YN ,CREATE_TIME from board_master where article_id='" + board1.getArticleId() + "'");

        assertThat("yhlee1", is(board1.getUserId()));


    }

    @Test
    public void testInsertAttachments() throws Exception {
        jdbcTemplate.execute("INSERT user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO) VALUE('yhlee','yonghee','','',CURRENT_TIMESTAMP,'ADMIN','') ");

        Board board = new Board();
        board.setMenuId("MNU03");
        board.setSubject("subject01");
        board.setUserId("yhlee");
        board.setContext("context..context");

        boardDao.insertBoard(board);
        Integer articleId = board.getArticleId();

        List<Attachment> attachmentList = new ArrayList<Attachment>();

        for (int i = 0; i < 3; i++) {
            Attachment attachment = new Attachment();
            attachment.setArticleId(articleId);
            attachment.setFileNameSrc("file_name_src:" + i);
            attachment.setFilePath("file_path:" + i);
            attachment.setFileData(FileUtils.readFileToByteArray(testImageFile));
            attachmentList.add(attachment);
        }

        boardDao.insertAttachments(articleId,attachmentList);

        int insertedCnt = jdbcTemplate.queryForInt("SELECT count(*) FROM board_attachment");
        assertThat(insertedCnt, is(3));

    }

    @Test
    public void testGetBoardById() throws Exception {
        /*
        insert into user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)
        value ('yhlee','이용희','password','email',CURRENT_TIMESTAMP,'USER','010000');
        insert into board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)
        value('MNU01','yhlee',1,null ,'subject.....','내용',false ,CURRENT_TIMESTAMP);
        insert into board_attachment(FILE_ID, FILE_NAME_SRC, FILE_NAME_SAVED, FILE_PATH, CREATE_TIME, ARTICLE_ID)
        value(1,'img_01.jpg','img_saved_01.jpg','/usr/home/path',CURRENT_TIMESTAMP,1);
        insert into board_attachment(FILE_ID, FILE_NAME_SRC, FILE_NAME_SAVED, FILE_PATH, CREATE_TIME, ARTICLE_ID)
        value(2,'img_02.jpg','img_saved_01.jpg','/usr/home/path',CURRENT_TIMESTAMP,1);
        */

        // FK가 걸려있어 사용자 등록을 먼저 함
        jdbcTemplate.execute("INSERT INTO user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "        VALUE ('yhlee','이용희','password','email',CURRENT_TIMESTAMP,'USER','010000');");
        jdbcTemplate.execute("INSERT INTO user_master (USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "  VALUE ('bosu', '깁보수', 'password', 'email', CURRENT_TIMESTAMP, 'USER', '010000');\n");

        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',1,null ,'subject.....','내용',FALSE ,CURRENT_TIMESTAMP);");

        //원글 1번에 대한 첨부파일 2건 등록
        jdbcTemplate.update("INSERT INTO board_attachment(FILE_ID, FILE_NAME_SRC, FILE_NAME_SAVED, FILE_PATH, CREATE_TIME, ARTICLE_ID,FILE_DATA)\n" +
                "        VALUE(1,'img_01.jpg','img_saved_01.jpg','/usr/home/path',CURRENT_TIMESTAMP,1,?);", (Object)testImageFile);
        jdbcTemplate.update("INSERT INTO board_attachment(FILE_ID, FILE_NAME_SRC, FILE_NAME_SAVED, FILE_PATH, CREATE_TIME, ARTICLE_ID,FILE_DATA)\n" +
                "        VALUE(2,'img_02.jpg','img_saved_01.jpg','/usr/home/path',CURRENT_TIMESTAMP,1,?);", (Object)testImageFile);


        //원글 2번 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'bosu', 2, null, 'subject.....', '내용', FALSE, CURRENT_TIMESTAMP);");
        //원글 3번 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 3, null, 'subject.....', '내용', FALSE, CURRENT_TIMESTAMP);\n");

        //원글 2번에 대한 답글 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 4, 2, 'subject.....', '내용', TRUE , CURRENT_TIMESTAMP);");
        //원글 2번에 대한 답글 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 5, 2, 'subject.....', '내용', TRUE , CURRENT_TIMESTAMP);");

        int articleId = 1;
        Board board = boardDao.getBoardById(articleId);
        //1번 글은 답글은 없고 첨부만 두건 있음
        assertNotNull(board);
        String authorName = board.getUser().getUserName();
        assertThat("이용희", is(board.getUser().getUserName()));
        assertThat(board.getAttachmentList().size(), is(2));
        System.out.println("reply count:" + board.getReplies().size());
        assertThat(board.getReplies().size(), is(0));
        assertThat("img_saved_01.jpg", is(board.getAttachmentList().get(1).getFileNameSaved()));

        articleId = 2; // 2번 글은 답글이 2개 있고 첨부가 없음
        board = boardDao.getBoardById(articleId);
        assertThat(board.getReplies().size(), is(2));
        assertThat(board.getAttachmentList().size(), is(0));

        articleId = 5; // 답글도 조회가 가능해야 함
        board = boardDao.getBoardById(articleId);
        assertNotNull(board);
        assertThat(board.isReply(), is(true));


    }

    @Test
    public void testGetBoardList() throws Exception {

        // FK가 걸려있어 사용자 등록을 먼저 함
        jdbcTemplate.execute("INSERT INTO user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "        VALUE ('yhlee','이용희','password','email',CURRENT_TIMESTAMP,'USER','010000');");
        jdbcTemplate.execute("INSERT INTO user_master (USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "  VALUE ('bosu', '깁보수', 'password', 'email', CURRENT_TIMESTAMP, 'USER', '010000');\n");

        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',1,null ,'subject.....','내용',FALSE ,CURRENT_TIMESTAMP);");
        //원글 1번에 대한 첨부파일 2건 등록
        jdbcTemplate.update("INSERT INTO board_attachment(FILE_ID, FILE_NAME_SRC, FILE_NAME_SAVED, FILE_PATH, CREATE_TIME, ARTICLE_ID,FILE_DATA)\n" +
                "        VALUE(1,'img_01.jpg','img_saved_01.jpg','/usr/home/path',CURRENT_TIMESTAMP,1,?);", (Object)testImageFile);
        jdbcTemplate.update("INSERT INTO board_attachment(FILE_ID, FILE_NAME_SRC, FILE_NAME_SAVED, FILE_PATH, CREATE_TIME, ARTICLE_ID,FILE_DATA)\n" +
                "        VALUE(2,'img_02.jpg','img_saved_01.jpg','/usr/home/path',CURRENT_TIMESTAMP,1,?);", (Object)testImageFile);

        //원글 2번 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'bosu', 2, null, 'subject.....', '내용', FALSE, CURRENT_TIMESTAMP);");
        //원글 3번 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 3, null, 'subject.....', '내용', FALSE, CURRENT_TIMESTAMP);\n");

        //원글 2번에 대한 답글 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 4, 2, 'subject.....', '내용', TRUE , CURRENT_TIMESTAMP);");
        //원글 2번에 대한 답글 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 5, 2, 'subject.....', '내용', TRUE , CURRENT_TIMESTAMP);");

        List<Board> boardList = boardDao.getBoardListByCondition("MNU01", new BoardSearchCondition());
        assertNotNull(boardList);
        assertThat(boardList.size(), is(3));
        assertThat(boardList.get(1).getReplyCnt(), is(2));
        assertThat(boardList.get(0).getReplyCnt(), is(0));

        //제목 검석을 위한 게시물 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 6, null, '검색용게시물', '내용', FALSE, CURRENT_TIMESTAMP);\n");

        BoardSearchCondition cond = new BoardSearchCondition();
        cond.setColumn("subject");
        cond.setQstr("검색");
        boardList = boardDao.getBoardListByCondition("MNU01", cond);
        assertNotNull(boardList);
        assertThat(boardList.size(), is(1));
        assertThat(boardList.get(0).getReplyCnt(), is(0));

        //검색에서 답글은 검색하지 않고 메인글만 검색한다.
        // 이용희가 쓴 메인글은 모두 3건
        cond.setColumn("name");
        cond.setQstr("용희");
        boardList = boardDao.getBoardListByCondition("MNU01", cond);
        assertNotNull(boardList);
        assertThat(boardList.size(), is(3));
        assertThat(boardList.get(0).getReplyCnt(), is(0));

        //limit 조건 테스트
        cond = null;
        cond = new BoardSearchCondition();
        cond.setLimitStart(2);
        cond.setLimitStart(4);
        boardList = boardDao.getBoardListByCondition("MNU01", cond);
        assertNotNull(boardList);
        assertThat(boardList.size(), is(3));

    }

    @Test
    public void testGetBoardTotalCntByCondition() throws Exception {
        jdbcTemplate.execute("INSERT INTO user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "        VALUE ('yhlee','이용희','password','email',CURRENT_TIMESTAMP,'USER','010000');");
        jdbcTemplate.execute("INSERT INTO user_master (USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "  VALUE ('bosu', '깁보수', 'password', 'email', CURRENT_TIMESTAMP, 'USER', '010000');\n");

        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',1,null ,'subject.....','내용',FALSE ,CURRENT_TIMESTAMP);");
        //원글 1번에 대한 첨부파일 2건 등록
        jdbcTemplate.update("INSERT INTO board_attachment(FILE_ID, FILE_NAME_SRC, FILE_NAME_SAVED, FILE_PATH, CREATE_TIME, ARTICLE_ID,FILE_DATA)\n" +
                "        VALUE(1,'img_01.jpg','img_saved_01.jpg','/usr/home/path',CURRENT_TIMESTAMP,1,?);", (Object)testImageFile);
        jdbcTemplate.update("INSERT INTO board_attachment(FILE_ID, FILE_NAME_SRC, FILE_NAME_SAVED, FILE_PATH, CREATE_TIME, ARTICLE_ID,FILE_DATA)\n" +
                "        VALUE(2,'img_02.jpg','img_saved_01.jpg','/usr/home/path',CURRENT_TIMESTAMP,1,?);", (Object)testImageFile);
        //원글 2번 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'bosu', 2, null, 'subject.....', '내용', FALSE, CURRENT_TIMESTAMP);");
        //원글 3번 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 3, null, 'subject.....', '내용', FALSE, CURRENT_TIMESTAMP);\n");

        //원글 2번에 대한 답글 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 4, 2, 'subject.....', '내용', TRUE , CURRENT_TIMESTAMP);");
        //원글 2번에 대한 답글 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 5, 2, 'subject.....', '내용', TRUE , CURRENT_TIMESTAMP);");

        BoardSearchCondition cond = new BoardSearchCondition();
        cond.setColumn("id");
        cond.setQstr("yhlee");

        //사용자아이디가 yhlee이고 답글이 아닌 글의 갯수는 2개
        int tCnt = boardDao.getBoardTotalCntByCondition("MNU01", cond);
        assertThat(tCnt, is(2));


    }

    @Test
    public void testGetReplyListByCondition() throws Exception {
        jdbcTemplate.execute("INSERT INTO user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "        VALUE ('yhlee','이용희','password','email',CURRENT_TIMESTAMP,'USER','010000');");
        jdbcTemplate.execute("INSERT INTO user_master (USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "  VALUE ('bosu', '깁보수', 'password', 'email', CURRENT_TIMESTAMP, 'USER', '010000');\n");

        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',1,null ,'subject.....','내용',FALSE ,CURRENT_TIMESTAMP);");

        //원글 2번 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'bosu', 2, null, 'subject.....', '내용', FALSE, CURRENT_TIMESTAMP);");
        //2번에 답글
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 3, 2, 'subject.....', '내용', TRUE, CURRENT_TIMESTAMP);\n");

        //2번에 답글
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 4, 2, 'subject..AA...', '내용', TRUE, CURRENT_TIMESTAMP);\n");

        //원글 2번에 대한 답글 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 5, 2, 'subject.....', '내용', TRUE , CURRENT_TIMESTAMP);");
        //답글 4번에 대한 답글 등록
        jdbcTemplate.execute("INSERT INTO board_master (MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "  VALUE ('MNU01', 'yhlee', 6, 4, 'subject.....', '내용', TRUE , CURRENT_TIMESTAMP);");

        List<Board> replyList = boardDao.getReplyListByCondition(2, new BoardSearchCondition());
        assertNotNull(replyList);
        assertThat(replyList.size(), is(3));

        replyList = boardDao.getReplyListByCondition(4, new BoardSearchCondition());
        assertNotNull(replyList);
        assertThat(replyList.size(), is(1));

        BoardSearchCondition cond = new BoardSearchCondition();
        cond.setColumn("subject");
        cond.setQstr("AA");
        replyList = boardDao.getReplyListByCondition(2, cond);
        assertNotNull(replyList);
        assertThat(replyList.size(), is(1));

    }

    @Test
    public void testUpdateBoard() throws Exception {
        jdbcTemplate.execute("INSERT INTO user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "        VALUE ('yhlee','이용희','password','email',CURRENT_TIMESTAMP,'USER','010000');");
        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',1,null ,'subject','내용1',FALSE ,CURRENT_TIMESTAMP);");


        Board board = new Board();
        board.setArticleId(1);
        board.setSubject("changedSub");
        board.setContext("수정");

        boardDao.updateBoard(board);

        Board cBoard = boardDao.getBoardById(1);
        assertNotNull(cBoard);
        assertThat(cBoard.getSubject(), is("changedSub"));

    }

    @Test
    public void testDeleteById() throws Exception {

        jdbcTemplate.execute("INSERT INTO user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "        VALUE ('yhlee','이용희','password','email',CURRENT_TIMESTAMP,'USER','010000');");
        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',1,null ,'subject','내용1',FALSE ,CURRENT_TIMESTAMP);");
        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',2,null ,'subject','내용1',FALSE ,CURRENT_TIMESTAMP);");
        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',3,null ,'subject','내용1',FALSE ,CURRENT_TIMESTAMP);");

        boardDao.deleteById(2);
        int cnt = boardDao.getBoardTotalCntByCondition("MNU01", new BoardSearchCondition());
        assertThat(cnt, is(2));

    }

    @Test
    public void testReplyCntById() throws Exception {
        jdbcTemplate.execute("INSERT INTO user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "        VALUE ('yhlee','이용희','password','email',CURRENT_TIMESTAMP,'USER','010000');");
        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',1,null ,'subject','내용1',FALSE ,CURRENT_TIMESTAMP);");
        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',2,null ,'subject','내용1',FALSE ,CURRENT_TIMESTAMP);");
        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',3,null ,'subject','내용1',FALSE ,CURRENT_TIMESTAMP);");

        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',4,2 ,'subject','내용1',TRUE ,CURRENT_TIMESTAMP);");

        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',5,2 ,'subject','내용1',TRUE ,CURRENT_TIMESTAMP);");

        int rCnt = boardDao.getReplyCntById(2);
        assertThat(rCnt, is(2));

        rCnt = boardDao.getReplyCntById(1);
        assertThat(rCnt, is(0));


    }

    @Test
    public void testDeleteByList() throws Exception {
        jdbcTemplate.execute("INSERT INTO user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "        VALUE ('yhlee','이용희','password','email',CURRENT_TIMESTAMP,'USER','010000');");
        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',1,null ,'subject','내용1',FALSE ,CURRENT_TIMESTAMP);");
        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',2,null ,'subject','내용1',FALSE ,CURRENT_TIMESTAMP);");
        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',3,null ,'subject','내용1',FALSE ,CURRENT_TIMESTAMP);");

        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',4,null ,'subject','내용1',FALSE ,CURRENT_TIMESTAMP);");

        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',5,null,'subject','내용1',FALSE ,CURRENT_TIMESTAMP);");

        int totCnt = boardDao.getBoardTotalCntByCondition("MNU01", new BoardSearchCondition());
        assertThat(totCnt, is(5));

        List<Integer> articleIds = new ArrayList<Integer>();
        articleIds.add(1);
        articleIds.add(3);
        articleIds.add(5);

        boardDao.deleteByList(articleIds);

        totCnt = boardDao.getBoardTotalCntByCondition("MNU01", new BoardSearchCondition());
        assertThat(totCnt, is(2));


    }
}
