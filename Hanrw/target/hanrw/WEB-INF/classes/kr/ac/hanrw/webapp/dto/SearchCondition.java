package kr.ac.hanrw.webapp.dto;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 8.
 * Time: 오후 9:09
 * To change this template use File | Settings | File Templates.
 */
public class SearchCondition {
    private String column;
    private String queryString;
    private int limitStart = 0;
    private int limitEnd = 0;

    public String getColumn() {

        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart = limitStart;
    }

    public int getLimitEnd() {
        return limitEnd;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd = limitEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchCondition that = (SearchCondition) o;

        if (limitEnd != that.limitEnd) return false;
        if (limitStart != that.limitStart) return false;
        if (!column.equals(that.column)) return false;
        if (!queryString.equals(that.queryString)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = column.hashCode();
        result = 31 * result + queryString.hashCode();
        result = 31 * result + limitStart;
        result = 31 * result + limitEnd;
        return result;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "column='" + column + '\'' +
                ", queryString='" + queryString + '\'' +
                ", limitStart=" + limitStart +
                ", limitEnd=" + limitEnd +
                '}';
    }
}
