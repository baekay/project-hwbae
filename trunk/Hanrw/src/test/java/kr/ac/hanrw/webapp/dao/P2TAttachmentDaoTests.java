package kr.ac.hanrw.webapp.dao;

import kr.ac.hanrw.webapp.dto.P2TAttachment;
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
public class P2TAttachmentDaoTests extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private P2TAttachmentDao attachmentDao;

    @Autowired
    private DataSource dataSource;

    @Before
    public void setEnv() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("delete from p2t_attachment;");
        //jdbcTemplate.update("alter table p2t_attachment auto_increment = 1;");
    }


    @Test
    public void testInsertImage() {

        P2TAttachment attachment = new P2TAttachment();
        MockMultipartFile mf;

        try {
            mf = new MockMultipartFile("P2TAttachmentFile", this.getClass().getClassLoader().getResourceAsStream("test_image.png"));
            attachment.setImageContents(mf.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("failed to file read");
        }

        attachment.setFileName("sample file name");
        attachment.setImageType("image/png");

        attachmentDao.insertImage(attachment);

        P2TAttachment insertedImage = attachmentDao.getImageBy(attachment.getImageId());

        Assert.assertEquals(attachment.getImageId(), insertedImage.getImageId());
        Assert.assertEquals(insertedImage.getImageContents().length, attachment.getImageContents().length);

    }


    @Test
    public void testGetImageById() {
        P2TAttachment attachment = new P2TAttachment();
        MockMultipartFile mf;

        try {
            mf = new MockMultipartFile("P2TAttachmentFile", this.getClass().getClassLoader().getResourceAsStream("test_image.png"));
            attachment.setImageContents(mf.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("failed to file read");
        }

        attachment.setFileName("sample file name2");
        attachment.setImageType("image/png");

        attachmentDao.insertImage(attachment);

        P2TAttachment insertedImage = attachmentDao.getImageBy(attachment.getImageId());

        Assert.assertEquals(attachment.getImageId(), insertedImage.getImageId());
        Assert.assertNotNull(insertedImage.getImageContents());
    }

    @Test
    public void testDeleteP2TAttachment() {

    }
}
