package com.siwanper.common.model;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页数据模型
 */
public class PageModel<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 总条数
     */
    private long total;
    /**
     * 当前分页下标
     */
    private int pageNumber;
    /**
     * 每个分页条数
     */
    private int pageSize;
    /**
     * 当前分页每条的数据
     */
    private List<T> rows;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 每个分页条数 < pageSize
     */
    private int size;

    public PageModel() {
    }

    public PageModel(List<T> list){
        if (list instanceof Page){
            Page page = (Page) list;
            this.total = page.getTotal();
            this.pageNumber = page.getPageNum();
            this.pageSize= page.getPageSize();
            this.pages = page.getPages();
            this.size = page.size();
            ArrayList<T> rows = new ArrayList<>();
            for (T t : list) {
                rows.add(t);
            }
            this.rows = rows;
        }
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        ArrayList<T> array = new ArrayList<>();
        for (T t : rows) {
            array.add(t);
        }
        this.rows = array;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageModel{" +
                "total=" + total +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", rows=" + rows.toString() +
                ", pages=" + pages +
                ", size=" + size +
                '}';
    }
}
