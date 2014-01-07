package kr.ac.hanrw.webapp.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 23
 * Time: 오후 6:25
 * To change this template use File | Settings | File Templates.
 */
public class V2T implements Serializable {
    private int reqId;
    private String reqUserId;
    private String reqUserName;
    private String prcUserId;
    private String prcUserName;
    private String subject;
    private String context;
    private char status;
    private Date startTime;
    private Date reqTime;
    private Date modTime;

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public String getReqUserId() {
        return reqUserId;
    }

    public void setReqUserId(String reqUserId) {
        this.reqUserId = reqUserId;
    }

    public String getReqUserName() {
        return reqUserName;
    }

    public void setReqUserName(String reqUserName) {
        this.reqUserName = reqUserName;
    }

    public String getPrcUserId() {
        return prcUserId;
    }

    public void setPrcUserId(String prcUserId) {
        this.prcUserId = prcUserId;
    }

    public String getPrcUserName() {
        return prcUserName;
    }

    public void setPrcUserName(String prcUserName) {
        this.prcUserName = prcUserName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getReqTime() {
        return reqTime;
    }

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    public Date getModTime() {
        return modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }

    @Override
    public String toString() {
        return "V2T{" +
                "reqId=" + reqId +
                ", reqUserId='" + reqUserId + '\'' +
                ", reqUserName='" + reqUserName + '\'' +
                ", prcUserId='" + prcUserId + '\'' +
                ", prcUserName='" + prcUserName + '\'' +
                ", subject='" + subject + '\'' +
                ", context='" + context + '\'' +
                ", status=" + status +
                ", startTime=" + startTime +
                ", reqTime=" + reqTime +
                ", modTime=" + modTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof V2T)) return false;

        V2T v2T = (V2T) o;

        if (reqId != v2T.reqId) return false;
        if (status != v2T.status) return false;
        if (context != null ? !context.equals(v2T.context) : v2T.context != null) return false;
        if (modTime != null ? !modTime.equals(v2T.modTime) : v2T.modTime != null) return false;
        if (prcUserId != null ? !prcUserId.equals(v2T.prcUserId) : v2T.prcUserId != null) return false;
        if (prcUserName != null ? !prcUserName.equals(v2T.prcUserName) : v2T.prcUserName != null) return false;
        if (reqTime != null ? !reqTime.equals(v2T.reqTime) : v2T.reqTime != null) return false;
        if (reqUserId != null ? !reqUserId.equals(v2T.reqUserId) : v2T.reqUserId != null) return false;
        if (reqUserName != null ? !reqUserName.equals(v2T.reqUserName) : v2T.reqUserName != null) return false;
        if (startTime != null ? !startTime.equals(v2T.startTime) : v2T.startTime != null) return false;
        if (subject != null ? !subject.equals(v2T.subject) : v2T.subject != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reqId;
        result = 31 * result + (reqUserId != null ? reqUserId.hashCode() : 0);
        result = 31 * result + (reqUserName != null ? reqUserName.hashCode() : 0);
        result = 31 * result + (prcUserId != null ? prcUserId.hashCode() : 0);
        result = 31 * result + (prcUserName != null ? prcUserName.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + (int) status;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (reqTime != null ? reqTime.hashCode() : 0);
        result = 31 * result + (modTime != null ? modTime.hashCode() : 0);
        return result;
    }
}
