package edu.cumt.phyExperiment.entity;

/**
 * 通知、公告
 */
public class Announcement {
    /**
     * 公告内容
     */
    private String content;

    public Announcement() {}

    public Announcement(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "content='" + content + '\'' +
                '}';
    }
}
