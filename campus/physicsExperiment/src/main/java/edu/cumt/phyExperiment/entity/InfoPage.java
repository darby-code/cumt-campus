package edu.cumt.phyExperiment.entity;

import java.util.List;

/**
 * 显示的信息页面
 */
public class InfoPage {
    /**
     * 当前页
     */
    private Integer currentPage;
    /**
     * 每页显示记录数量
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 每页显示的数据
     */
    private List<?> dataPerPage;
    /**
     * 开始数据
     */
    private Integer start;

    public InfoPage() {}

    public InfoPage(Integer currentPage, Integer pageSize, Integer totalPage
            , List<?> dataPerPage, Integer start) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.dataPerPage = dataPerPage;
        this.start = start;
    }

    /*****************Getter和Setter以及toString方法*************************/
    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<?> getDataPerPage() {
        return dataPerPage;
    }

    public void setDataPerPage(List<?> dataPerPage) {
        this.dataPerPage = dataPerPage;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "InfoPage{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", dataPerPage=" + dataPerPage +
                ", start=" + start +
                '}' + "\n";
    }
}
