package kr.ac.hanrw.webapp.dao;

import kr.ac.hanrw.webapp.dto.SearchCondition;
import kr.ac.hanrw.webapp.dto.User;
import org.junit.Assert;
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


/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 9
 * Time: 오후 3:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TransactionConfiguration
@Transactional
public class UserDaoTests extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    protected UserDao userDao = null;

    @Autowired
    protected DataSource dataSource = null;

    @Before
    public void setEnv() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("DELETE FROM user_master WHERE user_id = 'testid%'");
    }

    @Test
    public void testRegistUser() throws Exception {
        // 사용자 추가
        User user = new User();
        user.setUserId("testid");
        user.setUserName("테스터");
        user.setEmail("testid@hanrw.ac.kr");
        user.setTelNo("02-123-1234");
        user.setPassword("12345");
        user.setRoleId("USER");
        userDao.insertUser(user);

        // 사용자 조회
        User user2 = userDao.getUserBy("testid");

        // 테스트
        Assert.assertEquals(user.getUserId(), user2.getUserId());
        Assert.assertEquals(user.getEmail(), user2.getEmail());
        Assert.assertEquals(user.getTelNo(), user2.getTelNo());
        Assert.assertNotSame(user.getPassword(), user2.getPassword());
        Assert.assertEquals(user.getRoleId(), user2.getRoleId());
    } // end of method

    @Test
    public void testLoginUser() throws Exception {
        // 사용자 추가
        User user = new User();
        user.setUserId("testid");
        user.setUserName("테스터");
        user.setEmail("testid@hanrw.ac.kr");
        user.setTelNo("02-123-1234");
        user.setPassword("1234");
        user.setRoleId("USER");
        userDao.insertUser(user);

        User user2 = new User();
        user2.setUserId("testid");
        user2.setPassword("12344");
        boolean isLogin = userDao.loginUser(user2);
        Assert.assertFalse(isLogin);

        user2.setPassword("1234");
        isLogin = userDao.loginUser(user2);
        Assert.assertTrue(isLogin);

    }

    @Test
    public void testGetUserList() throws Exception {
        // 사용자 추가
        User user = new User();
        user.setUserId("testid");
        user.setUserName("테스터");
        user.setEmail("testid@hanrw.ac.kr");
        user.setTelNo("02-123-1234");
        user.setPassword("12345");
        user.setRoleId("USER");
        userDao.insertUser(user);

        user.setUserId("testid2");
        user.setUserName("테스터2");
        user.setEmail("testid2@hanrw.ac.kr");
        user.setTelNo("02-123-1234");
        user.setPassword("12345");
        user.setRoleId("USER");
        userDao.insertUser(user);

        user.setUserId("testid3");
        user.setUserName("테스터3");
        user.setEmail("testid3@hanrw.ac.kr");
        user.setTelNo("02-123-1234");
        user.setPassword("12345");
        user.setRoleId("USER");
        userDao.insertUser(user);

        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setColumn("id");
        searchCondition.setQueryString("testid%");
        List<User> userList = userDao.getUserList(searchCondition);
        Assert.assertEquals(3, userList.size());

        searchCondition.setColumn("id");
        searchCondition.setQueryString("testid3");
        userList = userDao.getUserList(searchCondition);
        user = userDao.getUserBy("testid3");
        User user2 = userList.get(0);
        Assert.assertEquals(1, userList.size());
        Assert.assertEquals(user, user2);
    }

    @Test
    public void testUpdateUser() throws Exception {
        // 사용자 추가
        User user = new User();
        user.setUserId("testid");
        user.setUserName("테스터");
        user.setEmail("testid@hanrw.ac.kr");
        user.setTelNo("02-123-1234");
        user.setPassword("12345");
        user.setRoleId("USER");
        userDao.insertUser(user);

        User user2 = userDao.getUserBy("testid");
        Assert.assertEquals("testid@hanrw.ac.kr", user2.getEmail());

        // 사용자 정보 업데이트
        user.setEmail("modifiedEmail@hanrw.ac.kr");
        userDao.updateUser(user);

        user2 = userDao.getUserBy("testid");
        Assert.assertEquals("modifiedEmail@hanrw.ac.kr", user2.getEmail());
    }

    @Test
    public void testDeleteUser() throws Exception {
        // 사용자 추가
        User user = new User();
        user.setUserId("testid");
        user.setUserName("테스터");
        user.setEmail("testid@hanrw.ac.kr");
        user.setTelNo("02-123-1234");
        user.setPassword("12345");
        user.setRoleId("USER");
        userDao.insertUser(user);

        user = null;
        user = userDao.getUserBy("testid");
        User user2 = userDao.getUserBy(user.getUserId());
        Assert.assertSame(user, user2);

        userDao.deleteUser(user.getUserId());
        user = userDao.getUserBy(user.getUserId());

        Assert.assertNotSame(user, user2);
        Assert.assertNull(user);

    }
}
