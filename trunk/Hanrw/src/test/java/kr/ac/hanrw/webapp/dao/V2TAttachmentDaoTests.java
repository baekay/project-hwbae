package kr.ac.hanrw.webapp.dao;

import kr.ac.hanrw.webapp.dto.V2TAttachment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 24
 * Time: 오전 11:11
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TransactionConfiguration
@Transactional
public class V2TAttachmentDaoTests extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private V2TAttachmentDao attachmentDao;

    @Autowired
    private DataSource dataSource;

    @Before
    public void setEnv() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("delete from v2t_attachment;");
        //jdbcTemplate.update("alter table v2t_attachment auto_increment = 1;");
    }


    @Test
    public void testInsertAudio() {

        V2TAttachment attachment = new V2TAttachment();
        MockMultipartFile mf;

        try {
            mf = new MockMultipartFile("V2TAttachmentFile", this.getClass().getClassLoader().getResourceAsStream("test_audio.mp3"));
            attachment.setAudioContents(mf.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("failed to file read");
        }

        attachment.setFileName("sample file name");
        attachment.setAudioType("audio/mp4");

        attachmentDao.insertAudio(attachment);

        V2TAttachment insertedAudio = attachmentDao.getAudioBy(attachment.getAudioId());

        Assert.assertEquals(attachment.getAudioId(), insertedAudio.getAudioId());
        Assert.assertEquals(insertedAudio.getAudioContents().length, attachment.getAudioContents().length);

    }


    @Test
    public void testGetAudioById() {
        V2TAttachment attachment = new V2TAttachment();
        MockMultipartFile mf;

        try {
            mf = new MockMultipartFile("V2TAttachmentFile", this.getClass().getClassLoader().getResourceAsStream("test_audio.mp3"));
            attachment.setAudioContents(mf.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("failed to file read");
        }

        attachment.setFileName("sample file name2");
        attachment.setAudioType("audio/png");

        attachmentDao.insertAudio(attachment);

        V2TAttachment insertedAudio = attachmentDao.getAudioBy(attachment.getAudioId());

        Assert.assertEquals(attachment.getAudioId(), insertedAudio.getAudioId());
        Assert.assertNotNull(insertedAudio.getAudioContents());
    }

    @Test
    public void testDeleteV2TAttachment() {

    }
}
