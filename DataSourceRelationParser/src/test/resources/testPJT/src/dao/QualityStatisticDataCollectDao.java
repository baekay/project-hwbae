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
 * ǰ����� ������ ������ DAO
 *
 * @sfmi.title ǰ����� ������ ������ DAO
 * @sfmi.portal-id jeungsik.kim
 * @sfmi.developer ������
 */
public class QualityStatisticDataCollectDao extends QualityKpiJdbcTemplateDao
{
    private static Log logger = LogFactory.getLog(QualityStatisticDataCollectDao.class);

    /**
     * ǰ����� ������ ���� ������ �̿��Ͽ� ��� �����͸� ����
     *
     * @param sttcDataCollectSql
     */
    public void readQualityStatisticData(String sttcDataCollectSql)
    {
        if (logger.isDebugEnabled())
        {
            logger.debug("ǰ����� ���� SQL : " + sttcDataCollectSql);
        }
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        jt.setQueryTimeout(0);
        jt.update(sttcDataCollectSql);
    }

    /**
     * ������ ��ȸ
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
     * �����Ͽ� �ش��ϴ�  ǰ����� �����͸� ��� ����
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
     * �۾��Ͽ� �ش��ϴ�  ǰ����� �����͸� ��� ����
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
     * ǰ����� ���� ���̺� ���� ���� �� ������Ʈ
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
     * �̱��� DB�� ���� ������ ��� �����͸� ��� ���̺� �����Ѵ�.
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
             * createQualityStatisticData ���� �޼���
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
             * createQualityStatisticData ���� �伭��
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
