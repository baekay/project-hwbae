/*
 * COPYRIGHT (c) Samsung Fire & Marine Insurance 2005
 * This software is the proprietary information of
 * Samsung Fire & Marine Insurance.
 *
 * Revision History(Created on 2010. 02. 12.)
 * =========================================================
 * Author       Date            Description
 * ---------------------------------------------------------
 * Hyunjun Park   2010. 02. 12.    1st Version
 * ---------------------------------------------------------
 */
package sfmi.component.squad.itquality.dao.sqlmap;

import org.springframework.jdbc.core.JdbcTemplate;

import sfmi.component.squad.itqualitybdt.QualityIndicator;
import sfmi.component.squad.itqualitybdt.QualityIndicatorCalculate;
//import sfmi.component.squad.itqualitybdt.QualityKpiExecHistory;

/**
 * ǰ����ǥ ���� DAO
 *
 * @sfmi.title ǰ����ǥ ���� DAO
 * @sfmi.portal-id jeungsik.kim
 * @sfmi.developer ������
 */
public class QualityKpiIndicatorCalcDao extends QualityKpiJdbcTemplateDao
{

    /**
     * ��ǥ ���� ��� ������ ����
     * @param sttcDataCollectSql
     */
    public void readQualityKpiCalcData(String sttcDataCollectSql)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        jt.update(sttcDataCollectSql);
    }

    /**
     * int Ÿ�� ��ǥ ��� �׸� ���� ���� ��� ��ȸ
     *
     * @param calcItemSQL
     * @return
     */
    public int readIntQualityIndicatorItemCalResult(String calcItemSQL)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        return jt.queryForInt(calcItemSQL);
    }

    /**
     * double Ÿ�� ��ǥ ��� �׸� ���� ���� ��� ��ȸ
     *
     * @param calcItemSQL
     * @param string
     * @return
     */
    public double readDoubleQualityIndicatorItemCalResult(String calcItemSQL)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        return (Double) jt.queryForObject(calcItemSQL, Double.class);
    }

    /**
     * ǰ�� KPI ��ǥ ��� ��� �� ��ȸ
     *
     * @param qualityIndicatorCalculate
     * @param qualityIndicatorFrm
     * @param baseDateSQL
     */
    public double readQualityKpiValue(QualityIndicatorCalculate qualityIndicatorCalculate, String qualityIndicatorFrm)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        qualityIndicatorFrm = "NVL(ROUND(" + qualityIndicatorFrm + "," + qualityIndicatorCalculate.getVldCipher()+"),0)";
        String sql = " SELECT " + qualityIndicatorFrm + " FROM DUAL";
        return (Double) jt.queryForObject(sql, Double.class);
    }

    /**
     * ǰ�� KPI ��ǥ ��� ��� �� ����
     *
     * @param qualityIndicator
     * @param kpiValue
     * @param baseDate
     */
    public void createQualityKpiData(QualityIndicator qualityIndicator, String kpiValue, String baseDate)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String sql = " INSERT INTO DPQA60TB(QI_ID, QI_VAL, BASE_DT) VALUES (?, ?, ?) ";
        jt.update(sql,new Object[] {qualityIndicator.getQiId(), kpiValue, baseDate});
    }

    /**
     * �����Ͽ� �ش��ϴ� ��ǥ ���� ��� �����͸� ��� ����
     *
     * @param qiTableName
     * @param baseDate
     */
    public void deleteQualitIndicatorCalDataByBaseDt(String qiTableName, String baseDate)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String sql = "DELETE FROM " + qiTableName + " WHERE BASE_DT = ? ";
        jt.update(sql, new Object[] {baseDate});
    }
    
    /**
     * �۾��Ͽ� �ش��ϴ� ��ǥ ���� ��� �����͸� ��� ����
     *
     * @param qiTableName
     * @param baseDate
     */
    public void deleteQualitIndicatorCalDataByWorkYm(String qiTableName, String baseDate)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String sql = "DELETE FROM " + qiTableName + " WHERE WORK_YM = ? ";
        jt.update(sql, new Object[] {baseDate});
    }    

    /**
     * ǰ����ǥ��������
     *
     * @param qiId
     * @param baseDate
     */
    public void deleteQualityIndicator(String qiId, String baseDate)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String sql = "DELETE FROM DPQA60TB WHERE QI_ID = ? AND BASE_DT = ? ";
        jt.update(sql, new Object[] {qiId, baseDate});
    }

    /**
     * ǰ����ǥ ���� ���  ���̺� ���� ���� �� ������Ʈ
     *
     * @param qualityIndicatorCalculate
     */
    public void updateCreateTableYn(QualityIndicatorCalculate qualityIndicatorCalculate)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String sql = "UPDATE DPQA62TB SET TBL_CREATE_YN = ? WHERE QI_ID = ? ";
        jt.update(sql, new Object[] {qualityIndicatorCalculate.getTblCreateYn(),qualityIndicatorCalculate.getQiId()});
    }
}
