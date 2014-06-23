/*
 * COPYRIGHT (c) Samsung Fire & Marine Insurance 2005
 * This software is the proprietary information of
 * Samsung Fire & Marine Insurance.
 *
 * Revision History(Created on 2009. 11. 26)
 * =========================================================
 * Author            Date          Description
 * ---------------------------------------------------------
 * YunKul Lee       2009. 11. 26. 1st Version
 * ---------------------------------------------------------
 */
package sfmi.component.squad.itqualitybdt;

import java.io.Serializable;

/**
 * �μ��׽�Ʈ
 *
 * @sfmi.title �μ��׽�Ʈ
 * @sfmi.portal-id jk420.kim
 * @sfmi.developer ������
 */
public class AcceptTest implements Serializable {

    private static final long serialVersionUID = -7700007643431785942L;

    private String srNo;                // SR ��ȣ
    private String srSubNo;             // SR SUB ������
    private String subSrId;             // SUB SR ID
    private String srDocuTitle;         // SR ��
    private String endReqDate;          // �Ϸ��û��
    private String srStatus;            // SR �ϷῩ�� (�Ϸ�/������)
    private String exctWhol;            // �����Ѱ�
    private String testRslt;            // �׽�Ʈ���
    private String testType;            // �׽�ƮŸ��
    /**
     * @return the srNo
     */
    public String getSrNo() {
        return srNo;
    }
    /**
     * @param srNo the srNo to set
     */
    public void setSrNo(String srNo) {
        this.srNo = srNo;
    }
    /**
     * @return the srSubNo
     */
    public String getSrSubNo() {
        return srSubNo;
    }
    /**
     * @param srSubNo the srSubNo to set
     */
    public void setSrSubNo(String srSubNo) {
        this.srSubNo = srSubNo;
    }
    /**
     * @return the subSrId
     */
    public String getSubSrId() {
        return subSrId;
    }
    /**
     * @param subSrId the subSrId to set
     */
    public void setSubSrId(String subSrId) {
        this.subSrId = subSrId;
    }
    /**
     * @return the srDocuTitle
     */
    public String getSrDocuTitle() {
        return srDocuTitle;
    }
    /**
     * @param srDocuTitle the srDocuTitle to set
     */
    public void setSrDocuTitle(String srDocuTitle) {
        this.srDocuTitle = srDocuTitle;
    }
    /**
     * @return the endReqDate
     */
    public String getEndReqDate() {
        return endReqDate;
    }
    /**
     * @param endReqDate the endReqDate to set
     */
    public void setEndReqDate(String endReqDate) {
        this.endReqDate = endReqDate;
    }
    /**
     * @return the srStatus
     */
    public String getSrStatus() {
        return srStatus;
    }
    /**
     * @param srStatus the srStatus to set
     */
    public void setSrStatus(String srStatus) {
        this.srStatus = srStatus;
    }
    /**
     * @return the exctWhol
     */
    public String getExctWhol() {
        return exctWhol;
    }
    /**
     * @param exctWhol the exctWhol to set
     */
    public void setExctWhol(String exctWhol) {
        this.exctWhol = exctWhol;
    }
    /**
     * @return the testRslt
     */
    public String getTestRslt() {
        return testRslt;
    }
    /**
     * @param testRslt the testRslt to set
     */
    public void setTestRslt(String testRslt) {
        this.testRslt = testRslt;
    }
    /**
     * @return the testType
     */
    public String getTestType() {
        return testType;
    }
    /**
     * @param testType the testType to set
     */
    public void setTestType(String testType) {
        this.testType = testType;
    }
}
