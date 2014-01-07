package kr.ac.hanrw.webapp.service;

import kr.ac.hanrw.webapp.dto.Board;
import kr.ac.hanrw.webapp.dto.BoardSearchCondition;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


/**
 * Created with IntelliJ IDEA.
 * User: yhlee
 * Date: 13. 9. 18.
 * Time: 오전 12:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TransactionConfiguration
@Transactional
public class BoardServiceImplTests extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired private DataSource dataSource;
    @Autowired private BoardService boardService;

    @Before
    public void setUp() throws Exception {
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
    public void testRegistBoard() throws Exception {

    }

    @Test
    public void testGetBoardDetailById() throws Exception {

    }

    @Test
    public void testGetBoardListByCondtion() throws Exception {

        jdbcTemplate.execute("INSERT INTO user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "        VALUE ('yhlee','이용희','password','email',CURRENT_TIMESTAMP,'USER','010000');");
        jdbcTemplate.execute("INSERT INTO user_master (USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "  VALUE ('bosu', '깁보수', 'password', 'email', CURRENT_TIMESTAMP, 'USER', '010000');\n");

        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU02','yhlee',1,null ,'SA','CA',FALSE ,CURRENT_TIMESTAMP);");
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU02','yhlee',2,null ,'SB','CB',FALSE ,CURRENT_TIMESTAMP);");
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU02','yhlee',3,null ,'SC','CC',FALSE ,CURRENT_TIMESTAMP);");
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU02','yhlee',5,2 ,'SBR','CBR',TRUE ,CURRENT_TIMESTAMP);");
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU02','yhlee',6,null ,'SD','CD',FALSE ,CURRENT_TIMESTAMP);");
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU02','yhlee',7,2 ,'SBR2','SBR2',TRUE ,CURRENT_TIMESTAMP);");
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU02','yhlee',8,5 ,'SBRR','SBRR',TRUE ,CURRENT_TIMESTAMP);");


        List<Board> boards = boardService.getBoardListByCondition("MNU02", new BoardSearchCondition());
        assertNotNull(boards);

        // 원글 갯수만 나옴
        assertThat(boards.size(), is(4));

        //2번 게시물에 댓글이 2개 달려있음
        assertThat(boards.get(2).getReplies().size(),is(2));
        assertNotNull(boards.get(2).getReplies().get(1).getReplies());

        //2번 개시물의 두번째 답글에 답글이 하나 들려있음
        assertThat(boards.get(2).getReplies().get(1).getReplies().size(),is(1));
    }

    @Test
    public void testUpdateBoard() throws Exception {

    }

    @Test
    public void testDeleteBoardById() throws Exception {

    }
}
