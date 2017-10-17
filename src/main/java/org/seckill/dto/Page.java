package org.seckill.dto;

import java.util.Arrays;
import java.util.List;

public class Page<T> {
    //当前页数
    private int pageNum = 1;
    //limit
    private int limit = 10;
    // 上一页
    private int prevPage = 1;
    //下一页
    private int nextPage = 1;
    //总页数
    private int totalPages = 1;
    // 总行数
    private long totalRows = 0L;
    // 数据源
    private List<T> rows;
    // 是否是第一页
    private boolean isFirstPage = false;
    // 是否是最后一页
    private boolean isLastPage = false;
    // 是否含有上一页
    private boolean hasPrevPage = false;
    // 是否含有下一页
    private boolean hasNextPage = false;

    private int navPages = 8;
    private int[] navPageNums;

    public Page() {
    }

    public Page(long total, int page, int limit, List<T> rows) {
        this.init(total, page, limit, rows);
    }

    private void init(long total, int pageNum, int limit, List<T> rows) {
        this.totalRows = total;
        this.limit = limit;
        this.totalPages = (int) ((this.totalRows - 1L) / (long) this.limit + 1L);
        if (pageNum < 1) {
            this.pageNum = 1;
        } else if (pageNum > this.totalPages) {
            this.pageNum = this.totalPages;
        } else {
            this.pageNum = pageNum;
        }
        this.rows = rows;
        this.calcNavigatePageNumbers();
        this.judgePageBoudary();
    }

    /**
     * 根据totalpage，将页面划分成1234的形式
     */
    private void calcNavigatePageNumbers() {
        int i;
        if (this.totalPages <= this.navPages) {
            this.navPageNums = new int[this.totalPages];

            for (i = 0; i < this.totalPages; ++i) {
                this.navPageNums[i] = i + 1;
            }
        } else {
            this.navPageNums = new int[this.navPages];
            i = this.pageNum - this.navPages / 2;
            int endNum = this.pageNum + this.navPages / 2;
            if (i < 1) {
                i = 1;

                for (i = 0; i < this.navPages; ++i) {
                    this.navPageNums[i] = i++;
                }
            } else if (endNum > this.totalPages) {
                endNum = this.totalPages;

                for (i = this.navPages - 1; i >= 0; --i) {
                    this.navPageNums[i] = endNum--;
                }
            } else {
                for (i = 0; i < this.navPages; ++i) {
                    this.navPageNums[i] = i++;
                }
            }
        }
    }

    /**
     * 得到当前页面的上一页与下一页
     */
    private void judgePageBoudary() {
        this.isFirstPage = this.pageNum == 1;
        this.isLastPage = this.pageNum == this.totalPages && this.pageNum != 1;
        this.hasPrevPage = this.pageNum != 1;
        this.hasNextPage = this.pageNum != this.totalPages;
        if (this.hasNextPage) {
            this.nextPage = this.pageNum + 1;
        }

        if (this.hasPrevPage) {
            this.prevPage = this.pageNum - 1;
        }

    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public boolean isHasPrevPage() {
        return hasPrevPage;
    }

    public void setHasPrevPage(boolean hasPrevPage) {
        this.hasPrevPage = hasPrevPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getNavPages() {
        return navPages;
    }

    public void setNavPages(int navPages) {
        this.navPages = navPages;
    }

    public int[] getNavPageNums() {
        return navPageNums;
    }

    public void setNavPageNums(int[] navPageNums) {
        this.navPageNums = navPageNums;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Page)) {
            return false;
        } else {
            Page<?> other = (Page) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPageNum() != other.getPageNum()) {
                return false;
            } else if (this.getLimit() != other.getLimit()) {
                return false;
            } else if (this.getPrevPage() != other.getPrevPage()) {
                return false;
            } else if (this.getNextPage() != other.getNextPage()) {
                return false;
            } else if (this.getTotalPages() != other.getTotalPages()) {
                return false;
            } else if (this.getTotalRows() != other.getTotalRows()) {
                return false;
            } else {
                label62:
                {
                    Object thisRows = this.getRows();
                    Object otherRows = other.getRows();
                    if (thisRows == null) {
                        if (otherRows == null) {
                            break label62;
                        }
                    } else if (thisRows.equals(otherRows)) {
                        break label62;
                    }

                    return false;
                }

                if (this.isFirstPage() != other.isFirstPage()) {
                    return false;
                } else if (this.isLastPage() != other.isLastPage()) {
                    return false;
                } else if (this.isHasPrevPage() != other.isHasPrevPage()) {
                    return false;
                } else if (this.isHasNextPage() != other.isHasNextPage()) {
                    return false;
                } else if (this.getNavPages() != other.getNavPages()) {
                    return false;
                } else {
                    return Arrays.equals(this.getNavPageNums(), other.getNavPageNums());
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Page;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getPageNum();
        result = result * 59 + this.getLimit();
        result = result * 59 + this.getPrevPage();
        result = result * 59 + this.getNextPage();
        result = result * 59 + this.getTotalPages();
        long totalRows = this.getTotalRows();
        result = result * 59 + (int) (totalRows >>> 32 ^ totalRows);
        Object rows = this.getRows();
        result = result * 59 + (rows == null ? 43 : rows.hashCode());
        result = result * 59 + (this.isFirstPage() ? 79 : 97);
        result = result * 59 + (this.isLastPage() ? 79 : 97);
        result = result * 59 + (this.isHasPrevPage() ? 79 : 97);
        result = result * 59 + (this.isHasNextPage() ? 79 : 97);
        result = result * 59 + this.getNavPages();
        result = result * 59 + Arrays.hashCode(this.getNavPageNums());
        return result;
    }

    @Override
    public String toString() {
        return "Page(pageNum=" + this.getPageNum() + ", limit=" + this.getLimit() + ", prevPage=" + this.getPrevPage() + ", nextPage=" + this.getNextPage() + ", totalPages=" + this.getTotalPages() + ", totalRows=" + this.getTotalRows() + ", rows=" + this.getRows() + ", isFirstPage=" + this.isFirstPage() + ", isLastPage=" + this.isLastPage() + ", hasPrevPage=" + this.isHasPrevPage() + ", hasNextPage=" + this.isHasNextPage() + ", navPages=" + this.getNavPages() + ", navPageNums=" + Arrays.toString(this.getNavPageNums()) + ")";
    }
}
