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
 * 품질지표 계산기 DAO
 *
 * @sfmi.title 품질지표 계산기 DAO
 * @sfmi.portal-id jeungsik.kim
 * @sfmi.developer 김정식
 */
public class QualityKpiIndicatorCalcDao extends QualityKpiJdbcTemplateDao
{

    /**
     * 지표 계산용 통계 데이터 수집
     * @param sttcDataCollectSql
     */
    public void readQualityKpiCalcData(String sttcDataCollectSql)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        jt.update(sttcDataCollectSql);
    }

    /**
     * int 타입 지표 계산 항목 쿼리 수행 결과 조회
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
     * double 타입 지표 계산 항목 쿼리 수행 결과 조회
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
     * 품질 KPI 지표 계산 결과 값 조회
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
     * 품질 KPI 지표 계산 결과 값 저장
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
     * 기준일에 해당하는 지표 계산용 통계 데이터를 모두 삭제
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
     * 작업일에 해당하는 지표 계산용 통계 데이터를 모두 삭제
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
     * 품질지표정보삭제
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
     * 품질지표 계산용 통계  테이블 생성 여부 값 업데이트
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
