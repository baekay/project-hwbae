package kr.ac.hanrw.webapp.controller;

import kr.ac.hanrw.webapp.dto.Board;
import kr.ac.hanrw.webapp.dto.BoardSearchCondition;
import kr.ac.hanrw.webapp.service.BoardService;
import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created with IntelliJ IDEA.
 * User: yhlee
 * Date: 13. 9. 20.
 * Time: 오후 12:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class BoardControllerTests extends AbstractTransactionalJUnit4SpringContextTests {

    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BoardService boardService;

    //yhlee 유저에 대한 토큰
    public static final String accessToken = "JMb0sityENhMB7FhgTlw3UET5CrCtvmKXeI7nubrtdPK0NuQaGTyb4B2AP6wc+ml";

    final static File testImageFile = new File("src\\test\\resources\\test_image.png");
    FileInputStream fis = null;

    @Before
    public void setup() throws IOException {

        fis = FileUtils.openInputStream(testImageFile);

        this.mockMvc = webAppContextSetup(this.wac).build();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("DELETE FROM board_attachment");
        jdbcTemplate.execute("DELETE FROM board_master");
        jdbcTemplate.execute("DELETE FROM p2t_job_prc");
        jdbcTemplate.execute("DELETE FROM p2t_job_req");
        jdbcTemplate.execute("DELETE FROM v2t_job_prc");
        jdbcTemplate.execute("DELETE FROM v2t_job_req");

        jdbcTemplate.update("DELETE FROM user_master");

        jdbcTemplate.execute("INSERT INTO user_master(USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "        VALUE ('yhlee','이용희','password','email',CURRENT_TIMESTAMP,'USER','010000');");
        jdbcTemplate.execute("INSERT INTO user_master (USER_ID, USER_NAME, PASSWORD, EMAIL, JOIN_DATE, ROLE_ID, TELNO)\n" +
                "  VALUE ('bosu', '깁보수', 'password', 'email', CURRENT_TIMESTAMP, 'USER', '010000');\n");

        // 원글 하나 등록
        jdbcTemplate.execute("INSERT INTO board_master(MENU_ID, USER_ID, ARTICLE_ID, PARENT_ARTICLE_ID, SUBJECT, CONTEXT, REPLY_YN, CREATE_TIME)\n" +
                "        VALUE('MNU01','yhlee',1,null ,'subject.....','내용',FALSE ,CURRENT_TIMESTAMP);");

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


    }

    @Test
    public void testGetBoardList() throws Exception {

        MvcResult result = mockMvc.perform(get("/app/board/MNU01/list")
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        req.setMethod("GET");
                        req.setRequestURI("/app/board/MNU01/list");
                        req.addHeader("access_token", accessToken);
                        return req;
                    }
                }))
                .andExpect(status().isOk())
                .andReturn();

        String rstStr = result.getResponse().getContentAsString();
        assertNotNull(rstStr);

        List<Board> boardList;
        ObjectMapper mapper = new ObjectMapper();
        boardList = mapper.readValue(rstStr.getBytes("UTF-8"), new TypeReference<List<Board>>() {
        });
        assertNotNull(boardList);
        assertThat(boardList.size(), is(3));


    }

    @Test
    public void testGetBoardListByCondition() throws Exception {

        MvcResult result = mockMvc.perform(get("/app/board/MNU01/list")
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        req.addParameter("column", "id");
                        req.addParameter("qstr", "bosu");
                        req.setMethod("GET");
                        req.setRequestURI("/app/board/MNU01/list");
                        req.addHeader("access_token", accessToken);
                        return req;
                    }
                }))
                .andExpect(status().isOk())
                .andReturn();

        String rstStr = result.getResponse().getContentAsString();
        assertNotNull(rstStr);

        List<Board> boardList;
        ObjectMapper mapper = new ObjectMapper();
        boardList = mapper.readValue(rstStr.getBytes("UTF-8"), new TypeReference<List<Board>>() {
        });
        assertNotNull(boardList);
        assertThat(boardList.size(), is(1));

        result = mockMvc.perform(get("/app/board/MNU01/list")
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        req.addParameter("limistStart", "1");
                        req.addParameter("limistEnd", "10");
                        req.setMethod("GET");
                        req.setRequestURI("/app/board/MNU01/list");
                        req.addHeader("access_token", accessToken);
                        return req;
                    }
                }))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        rstStr = result.getResponse().getContentAsString();
        assertNotNull(rstStr);

        boardList = mapper.readValue(rstStr.getBytes("UTF-8"), new TypeReference<List<Board>>() {
        });
        assertNotNull(boardList);
        assertThat(boardList.size(), is(3));


    }


    @Test
    public void testWrite() throws Exception {

        final String boardStr = "{\n" +
                "    \"subject\":\"subsubsubsub\",\n" +
                "    \"userId\":\"yhlee\",\n" +
                "    \"context\":\"blah blah\",\n" +
                "    \"isReply\":false" +
                "}";

//        ObjectMapper mapper = new ObjectMapper();
//        Board board = mapper.readValue(boardStr.getBytes(), Board.class);
//        assertNotNull(board);

        int totCntB = boardService.getTotalCountByCondition("MNU01", new BoardSearchCondition());

        MvcResult result = mockMvc.perform(post("/app/board/MNU01/regist")
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        try {
                            req.setMethod("POST");
                            req.setRequestURI("/app/board/MNU01/regist");
                            req.addHeader("access_token", accessToken);
                            req.addHeader("Content-Type", "application/json");
                            req.addHeader("Content-Length", boardStr.getBytes("UTF-8").length);
                            req.setContent(boardStr.getBytes("UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        return req;
                    }
                }))
                .andExpect(status().isOk())
                .andReturn();

        int totCntA = boardService.getTotalCountByCondition("MNU01", new BoardSearchCondition());
        assertThat(totCntA, is(totCntB + 1));

        String returnBoard = result.getResponse().getContentAsString();
        assertNotNull(returnBoard);

        ObjectMapper mapper = new ObjectMapper();
        Board insertedBoard = mapper.readValue(returnBoard.getBytes("UTF-8"), Board.class);
        assertNotNull(insertedBoard);

        assertThat(insertedBoard.getArticleId(), not(is(0)));
        System.out.println(insertedBoard);
    }

    @Test
    public void testView() throws Exception {

        MvcResult result = mockMvc.perform(get("/app/board/3")
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        req.setMethod("GET");
                        req.setRequestURI("/app/board/3");
                        req.addHeader("access_token", accessToken);
                        return req;
                    }
                }))
                .andExpect(status().isOk())
                .andReturn();

        String rstBoard = result.getResponse().getContentAsString();
        assertNotNull(rstBoard);
        ObjectMapper mapper = new ObjectMapper();

        Board board = mapper.readValue(rstBoard.getBytes("UTF-8"), Board.class);
        assertNotNull(board);

        assertThat(board.getArticleId(), not(0));

    }

    @Test
    public void testUpdate() throws Exception {

        Board board = new Board();
        board.setUserId("yhlee");
        board.setMenuId("MNU02");
        board.setContext("context1");
        board.setSubject("subject1");
        boardService.registBoard("MNU02",board);

        int articleId = board.getArticleId();

        board.setContext("context2");
        board.setSubject("subject2");


        ObjectMapper mapper = new ObjectMapper();
        final String boardStr =mapper.writeValueAsString(board);

        mockMvc.perform(post("/app/board/update")
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        try {
                            req.setMethod("POST");
                            req.setRequestURI("/app/board/update");
                            req.addHeader("access_token", accessToken);
                            req.addHeader("Content-Type", "application/json");
                            req.addHeader("Content-Length", boardStr.getBytes("UTF-8").length);
                            req.setContent(boardStr.getBytes("UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        return req;
                    }
                }))
                .andExpect(status().isOk());


        Board newBoard = boardService.getBoardDetailById(articleId);
        assertThat(newBoard.getSubject(), is("subject2"));
        assertThat(newBoard.getContext(), is("context2"));

    }


    @Test
    public void testDelete() throws Exception {
        int cnt = jdbcTemplate.queryForInt("select count(*) from board_master where article_id=3");
        assertThat(cnt, is(1));

        mockMvc.perform(post("/app/board/delete/3")
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        req.setMethod("POST");
                        req.setRequestURI("/app/board/delete/3");
                        req.addHeader("access_token", accessToken);
                        req.addHeader("Content-Type", "application/json");
                        return req;
                    }
                }))
                .andExpect(status().isOk());

        cnt = jdbcTemplate.queryForInt("select count(*) from board_master where article_id=3");
        assertThat(cnt, is(0));

    }

    @Test
    public void testDeleteUnAuth() throws Exception {
        int cnt = jdbcTemplate.queryForInt("select count(*) from board_master where article_id=2");
        assertThat(cnt, is(1));

        mockMvc.perform(post("/app/board/delete/2")
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        req.setMethod("POST");
                        req.setRequestURI("/app/board/delete/2");
                        req.addHeader("access_token", accessToken);
                        req.addHeader("Content-Type", "application/json");
                        return req;
                    }
                }))
                .andExpect(status().isUnauthorized());

        cnt = jdbcTemplate.queryForInt("select count(*) from board_master where article_id=2");
        assertThat(cnt, is(1));

    }

    @Test
    public void testDeleteDataInigException() throws Exception {
        /*
        final int testArticleId = 1;

        int cnt = jdbcTemplate.queryForInt("select count(*) from board_master where article_id=" + testArticleId + ";");
        assertThat(cnt, is(1));

        mockMvc.perform(post("/app/board/delete/" + testArticleId)
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        req.setMethod("POST");
                        req.setRequestURI("/app/board/delete/" + testArticleId);
                        req.addHeader("access_token", accessToken);
                        req.addHeader("Content-Type", "application/json");
                        return req;
                    }
                }))
                .andExpect(status().isBadRequest());

        cnt = jdbcTemplate.queryForInt("select count(*) from board_master where article_id=" + testArticleId + ";");
        assertThat(cnt, is(1));*/

    }

    @Test
    public void testGetListView() throws Exception {

        mockMvc.perform(get("/view/board/MNU01/list"))
                .andExpect(status().isMovedTemporarily());

        mockMvc.perform(get("/view/board/MNU01/list")
                    .cookie(new Cookie("access_token", URLEncoder.encode(accessToken,"UTF-8"))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("boardId"))
                .andExpect(view().name(is("board/list")));


    }
}
