package cn.mrpei.bean;

public class Page {
    // 总条数
    private int totalNumber;
    // 当前页数
    private int currentPage;
    // 总页数
    private int totalPage;
    // 每页显示条数
    private int pageNumber;

    public Page() {
        this.currentPage = 1;
        this.pageNumber = 8;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
