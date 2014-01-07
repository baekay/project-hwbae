package kr.ac.hanrw.webapp.common;

import kr.ac.hanrw.webapp.dto.AccessToken;
import kr.ac.hanrw.webapp.dto.User;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created with IntelliJ IDEA.
 * User: itwise
 * Date: 13. 9. 11
 * Time: 오후 4:24
 * To change this template use File | Settings | File Templates.
 */
public class AccessTokenHandlerTest {
    @Test
    public void testGenerate() throws Exception {

//        String strTimestamp = DateFormatUtils.format(timestamp, "yyyyMMddHHMMSS");
        User user = new User();
        user.setUserId("yhlee");
        user.setTelNo("0105555");
        user.setRoleId("ADMIN");
        user.setEmail("yhlee@gamil.com");

        AccessToken ac = AccessTokenHandler.generate(user);
        System.out.println(ac.getAccessToken());

        User decUser = AccessTokenHandler.parseAccessToken(ac);
        assertThat(user.getEmail(), is(decUser.getEmail()));
        assertThat(user.getUserId(),is(decUser.getUserId()));
        assertThat(user.getRoleId(), is(decUser.getRoleId()));
        assertThat(user.getTelNo(), is(decUser.getTelNo()));
    }
}
