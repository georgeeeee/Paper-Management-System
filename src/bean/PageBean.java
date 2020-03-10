package bean;

/**
 * Created by GeorgeYang on 2017/12/26.
 */

/**
 *存储页面信息的JavaBean。其中存有变量
 * currentPage（当前页数）
 * recordPerPage（每页记录行数）
 * totalRecord（记录总行数）
 * totalPage（总页数）
 */
public class PageBean {

    private int currentPage;        //当前页数
    private int recordPerPage;      //每页的数据行数
    private int totalRecord;        //数据总行数
    private int totalPage;          //总页数

    /**获取currentPage值*/
    public int getCurrentPage() {
        return currentPage;
    }

    /**设置currentPage值*/
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**获取recordPerPage值*/
    public int getRecordPerPage() {
        return recordPerPage;
    }

    /**设置recordPerPage值*/
    public void setRecordPerPage(int recordPerPage) {
        this.recordPerPage = recordPerPage;
    }

    /**获取totalRecord值*/
    public int getTotalRecord() {
        return totalRecord;
    }

    /**设置totalRecord值*/
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    /**获取totalPage值，totalPage等于：记录总数/每页记录 + 1*/
    public int getTotalPage(){
        return totalRecord / recordPerPage + 1;
    }
}
