/*
 * COPYRIGHT (c) Samsung Fire & Marine Insurance 2005
 * This software is the proprietary information of 
 * Samsung Fire & Marine Insurance.
 * 
 * Revision History(Created on 2010. 2. 25.)
 * =========================================================
 * Author             Date                   Description
 * ---------------------------------------------------------
 * Hyunjun Park       2010. 2. 25.                1st Version
 * ---------------------------------------------------------
 */
package sfmi.component.squad.itqualitybdt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ǰ�� KPI ���ú��� ���� �� ���� ���� BDT
 * 
 * @sfmi.title ǰ�� KPI ���ú��� ���� �� ���� ���� BDT
 * @sfmi.portal-id jk420.kim
 * @sfmi.developer ������
 */
public class QualityKpiDashBoardConfigInfo implements Serializable {
    private static final long serialVersionUID = -5579027929502644907L;
   
    private String qiClsCd;             // Ȱ�� ǰ����ǥ�з��ڵ�
    private String qiClsName;           // Ȱ�� ǰ����ǥ�з��ڵ� ��
    private int chartWidth;             // ���� �� ��Ʈ �ʺ�
    private int chartHeight;            // ���� �� ����
    private String inquireColumnSQL;    // ���� �� �ϴ� ������ �׸� ��ȸ SQL
    private String dataInquireSQL;      // ���� �� �ϴ� ������ ��ȸ SQL
    private String inputClerk;          // �Է���
    private String inputDttm;           // �Է��Ͻ�
    private String standardYm;          // ���س��
    
    // ���� �� ��Ʈ�� �����ϴ� ��Ʈ ���� ���
    List<QualityKpiOverallViewChart> chartInfoList = new ArrayList<QualityKpiOverallViewChart>();
    
    // �� ���� �信 ���ϴ� ǰ�� ��ǥ ���
    List<QualityIndicator> qiList = new ArrayList<QualityIndicator>();
    /**
     * @return the qiClsCd
     */
    public String getQiClsCd() {
        return qiClsCd;
    }
    /**
     * @param qiClsCd the qiClsCd to set
     */
    public void setQiClsCd(String qiClsCd) {
        this.qiClsCd = qiClsCd;
    }
    /**
     * @return the qiClsName
     */
    public String getQiClsName() {
        return qiClsName;
    }
    /**
     * @param qiClsName the qiClsName to set
     */
    public void setQiClsName(String qiClsName) {
        this.qiClsName = qiClsName;
    }
    /**
     * @return the chartWidth
     */
    public int getChartWidth() {
        return chartWidth;
    }
    /**
     * @param chartWidth the chartWidth to set
     */
    public void setChartWidth(int chartWidth) {
        this.chartWidth = chartWidth;
    }
    /**
     * @return the chartHeight
     */
    public int getChartHeight() {
        return chartHeight;
    }
    /**
     * @param chartHeight the chartHeight to set
     */
    public void setChartHeight(int chartHeight) {
        this.chartHeight = chartHeight;
    }
    /**
     * @return the inquireColumnSQL
     */
    public String getInquireColumnSQL() {
        return inquireColumnSQL;
    }
    /**
     * @param inquireColumnSQL the inquireColumnSQL to set
     */
    public void setInquireColumnSQL(String inquireColumnSQL) {
        this.inquireColumnSQL = inquireColumnSQL;
    }
    /**
     * @return the dataInquireSQL
     */
    public String getDataInquireSQL() {
        return dataInquireSQL;
    }
    /**
     * @param dataInquireSQL the dataInquireSQL to set
     */
    public void setDataInquireSQL(String dataInquireSQL) {
        this.dataInquireSQL = dataInquireSQL;
    }
    /**
     * @return the inputClerk
     */
    public String getInputClerk() {
        return inputClerk;
    }
    /**
     * @param inputClerk the inputClerk to set
     */
    public void setInputClerk(String inputClerk) {
        this.inputClerk = inputClerk;
    }
    /**
     * @return the inputDttm
     */
    public String getInputDttm() {
        return inputDttm;
    }
    /**
     * @param inputDttm the inputDttm to set
     */
    public void setInputDttm(String inputDttm) {
        this.inputDttm = inputDttm;
    }
    /**
     * @return the chartInfoList
     */
    public List<QualityKpiOverallViewChart> getChartInfoList() {
        return chartInfoList;
    }
    /**
     * @param chartInfoList the chartInfoList to set
     */
    public void setChartInfoList(List<QualityKpiOverallViewChart> chartInfoList) {
        this.chartInfoList = chartInfoList;
    }
    /**
     * @return the qiList
     */
    public List<QualityIndicator> getQiList() {
        return qiList;
    }
    /**
     * @param qiList the qiList to set
     */
    public void setQiList(List<QualityIndicator> qiList) {
        this.qiList = qiList;
    }
    /**
     * @return the standardYm
     */
    public String getStandardYm() {
        return standardYm;
    }
    /**
     * @param standardYm the standardYm to set
     */
    public void setStandardYm(String standardYm) {
        this.standardYm = standardYm;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("QualityKpiDashBoardConfigInfo [chartHeight=");
        builder.append(chartHeight);
        builder.append(", chartInfoList=");
        builder.append(chartInfoList);
        builder.append(", chartWidth=");
        builder.append(chartWidth);
        builder.append(", dataInquireSQL=");
        builder.append(dataInquireSQL);
        builder.append(", inputClerk=");
        builder.append(inputClerk);
        builder.append(", inputDttm=");
        builder.append(inputDttm);
        builder.append(", standardYm=");
        builder.append(standardYm);
        builder.append(", inquireColumnSQL=");
        builder.append(inquireColumnSQL);
        builder.append(", qiClsCd=");
        builder.append(qiClsCd);
        builder.append(", qiClsName=");
        builder.append(qiClsName);
        builder.append(", qiList=");
        builder.append(qiList);
        builder.append("]");
        return builder.toString();
    }
}
