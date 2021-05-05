package edu.cumt.phyExperiment.dao;

import edu.cumt.phyExperiment.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;

public class AnnouncementTest extends BaseTest {
    @Autowired
    AnnouncementDao announcementDao;

    @Test
    public void queryAnnouncement() {
        String content = announcementDao.queryAnnouncement();
        System.out.println(content);
    }

    @Test
    public void modifyAnnouncement() {
        String original = announcementDao.queryAnnouncement();
        announcementDao.modifyAnnouncement("test");
        System.out.println(announcementDao.queryAnnouncement());
        announcementDao.modifyAnnouncement(original);
    }
}
