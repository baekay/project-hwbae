package kr.ac.hanrw.webapp.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: 용이
 * Date: 13. 9. 21
 * Time: 오후 9:50
 * To change this template use File | Settings | File Templates.
 */
public class BoardSearchCondition implements Serializable {

    private String column;
    private String qstr;
    Integer limitStart;
    Integer limitEnd;
    Integer curPage;
    Integer reqPage;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getQstr() {
        return qstr;
    }

    public void setQstr(String qstr) {
        this.qstr = qstr;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart = limitStart;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd = limitEnd;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getReqPage() {
        return reqPage;
    }

    public void setReqPage(Integer reqPage) {
        this.reqPage = reqPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardSearchCondition that = (BoardSearchCondition) o;

        if (!column.equals(that.column)) return false;
        if (!curPage.equals(that.curPage)) return false;
        if (!limitEnd.equals(that.limitEnd)) return false;
        if (!limitStart.equals(that.limitStart)) return false;
        if (!qstr.equals(that.qstr)) return false;
        if (!reqPage.equals(that.reqPage)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = column.hashCode();
        result = 31 * result + qstr.hashCode();
        result = 31 * result + limitStart.hashCode();
        result = 31 * result + limitEnd.hashCode();
        result = 31 * result + curPage.hashCode();
        result = 31 * result + reqPage.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BoardSearchCondition{" +
                "column='" + column + '\'' +
                ", qstr='" + qstr + '\'' +
                ", limitStart=" + limitStart +
                ", limitEnd=" + limitEnd +
                ", curPage=" + curPage +
                ", reqPage=" + reqPage +
                '}';
    }
}
