package edu.cumt.phyExperiment.dao;

/**
 *  公告
 */
public interface AnnouncementDao {

    /**
     * 查询公告内容
     * @return
     */
    String queryAnnouncement();

    /**
     * 修改公告内容
     * @param announcement
     * @return
     */
    int modifyAnnouncement(String announcement);
}
