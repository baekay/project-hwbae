/*
 * COPYRIGHT (c) Samsung Fire & Marine Insurance 2005
 * This software is the proprietary information of
 * Samsung Fire & Marine Insurance.
 *
 * Revision History(Created on 2010. 02. 12.)
 * =========================================================
 * Author            Date                Description
 * ---------------------------------------------------------
 * Hyunjun Park       2010. 02. 12.        1st Version
 * ---------------------------------------------------------
 */
package sfmi.component.squad.itquality.dao.sqlmap;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

//import sfmi.component.squad.itqualitybdt.QualityKpiExecHistory;
import sfmi.component.squad.itqualitybdt.QualityStatisticInfo;

/**
 * 품질통계 데이터 수집기 DAO
 *
 * @sfmi.title 품질통계 데이터 수집기 DAO
 * @sfmi.portal-id jeungsik.kim
 * @sfmi.developer 김정식
 */
public class QualityStatisticDataCollectDao extends QualityKpiJdbcTemplateDao
{
    private static Log logger = LogFactory.getLog(QualityStatisticDataCollectDao.class);

    /**
     * 품질통계 데이터 수집 쿼리를 이용하여 통계 데이터를 수집
     *
     * @param sttcDataCollectSql
     */
    public void readQualityStatisticData(String sttcDataCollectSql)
    {
        if (logger.isDebugEnabled())
        {
            logger.debug("품질통계 수집 SQL : " + sttcDataCollectSql);
        }
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        jt.setQueryTimeout(0);
        jt.update(sttcDataCollectSql);
    }

    /**
     * 기준일 조회
     *
     * @param baseDateSql
     * @return
     */
    public String readBaseDt(String baseDateSql)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String sql = "SELECT " + baseDateSql + " FROM DUAL";
        return (String) jt.queryForObject(sql, String.class);
    }

    /**
     * 기준일에 해당하는  품질통계 데이터를 모두 삭제
     *
     * @param qsTableName
     * @param baseDate
     */
    public void deleteQualityStatisticDataByBaseDt(String qsTableName, String baseDate)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String sql = "DELETE FROM " + qsTableName + " WHERE BASE_DT = ? ";
        jt.update(sql, new Object[] {baseDate});
    }
    
    /**
     * 작업일에 해당하는  품질통계 데이터를 모두 삭제
     *
     * @param qsTableName
     * @param baseDate
     */
    public void deleteQualityStatisticDataByWorkYm(String qsTableName, String baseDate)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String sql = "DELETE FROM " + qsTableName + " WHERE WORK_YM = ? ";
        jt.update(sql, new Object[] {baseDate});
    }    

    /**
     * 품질통계 정보 테이블 생성 여부 값 업데이트
     *
     * @param qsInfo
     */
    public void updateCreateTableYn(QualityStatisticInfo qsInfo)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String sql = "UPDATE DPQA41TB SET TBL_CREATE_YN = ? WHERE QI_ID = ? ";
        jt.update(sql, new Object[] {qsInfo.getTblCreateYn(),qsInfo.getQiId()});
    }

    /**
     * 이기종 DB로 부터 수집한 통계 데이터를 통계 테이블에 저장한다.
     *
     * @param sql
     * @param dataList
     */
    public void createQualityStatisticData(String sql, final List<List<String>> dataList)
    {
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        jt.setQueryTimeout(0);
        jt.batchUpdate(sql, new BatchPreparedStatementSetter() 
        {
            /**
             * createQualityStatisticData 내부 메서드
             *
             * @param paeparedStatement
             * @param int
             */
        	public void setValues(PreparedStatement ps, int i) throws SQLException 
            {
                List<String> data = dataList.get(i);
                int index = 1;
                for (String value : data) 
                {
                    ps.setString(index, value);
                    index++;
                }
            }
            /**
             * createQualityStatisticData 내부 멧서드
             *
             * @param void
             */
            public int getBatchSize()
            {
                return dataList.size();
            }
        });
    }
}
