package kr.ac.hanrw.webapp.utils;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created with IntelliJ IDEA.
 * User: itwise
 * Date: 13. 9. 11
 * Time: 오후 4:38
 * To change this template use File | Settings | File Templates.
 */
public class CryptoHelperTest {
    @Test
    public void testEncrypt() throws Exception {
        String word = "mynameisyonghee";

        String encWord = CryptoHelper.encrypt(word);
        System.out.println(encWord);


        String decWord = CryptoHelper.decrypt(encWord);

        assertThat(word, is(decWord));

    }

    @Test
    public void testDecrypt() throws Exception {

    }
}
