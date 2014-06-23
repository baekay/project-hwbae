/*
 * COPYRIGHT (c) Samsung Fire & Marine Insurance 2005
 * This software is the proprietary information of
 * Samsung Fire & Marine Insurance.
 *
 * Revision History(Created on 2009. 9. 11.)
 * =========================================================
 * Author   Date          Description
 * ---------------------------------------------------------
 *
 * ---------------------------------------------------------
 */
package sfmi.component.squad.itquality.dao.sqlmap;

import java.util.List;
import java.util.Map;

import sfmi.component.squad.itquality.dao.McmKpiMgrDao;
import sfmi.component.squad.itquality.dao.SqlMapDaoTemplateExt;
import sfmi.component.squad.itqualitybdt.McmKpi;

import com.ibatis.dao.client.DaoManager;

/**
 * MCM KPI 관리 Dao
 *
 * @sfmi.title MCM KPI 관리 Dao
 * @sfmi.portal-id jk420.kim
 * @sfmi.developer 이해봉
 */
@SuppressWarnings("unchecked")
public class SqlMapMcmKpiMgrDao extends SqlMapDaoTemplateExt implements McmKpiMgrDao {

	private static final String PERFCOMPARE_UP = "up";
	private static final String PERFCOMPARE_DOWN = "down";
	private static final String PERFORMCHANGE_TRS = "perTime";
	private static final String PERFORMCHANGE_SEQ = "perSeq";

    /**
     * @param daoManager
     */
    public SqlMapMcmKpiMgrDao(DaoManager daoManager) {
        super(daoManager);
    }

    /* (non-Javadoc)
     * @see sfmi.component.squad.itquality.dao.McmKpiMgrDao#dataInitList()
     */
    public List<String> dataInitList() {
        return queryForList("selectMcmDataInitList", null);
    }

    /* (non-Javadoc)
     * @see sfmi.component.squad.itquality.dao.McmKpiMgrDao#getMcmKpiList(java.util.Map)
     */
    public List<McmKpi> readMcmKpiList(Map<String, String> searchMap) {
        setOperator(searchMap);
        setSelectValue(searchMap);
        return queryForList("selectMcmKpiListWithCnt", searchMap);
    }

    /* (non-Javadoc)
     * @see sfmi.component.squad.itquality.dao.McmKpiMgrDao#getMcmKpiInfo(java.util.Map)
     */
    public McmKpi readMcmKpiInfo(Map<String, String> searchMap) {
        return (McmKpi) queryForObject("selectMcmKpi", searchMap);
    }

    /**
     * 조회 연산자 설정
     *
     * @param searchMap
     */
    private void setOperator(Map<String, String> searchMap) {
        String perfCompareOperator = "=";

        String perfCompare = searchMap.get("perfCompare");
		if (PERFCOMPARE_UP.equals(perfCompare)) {
            perfCompareOperator = "<";
        } else if (PERFCOMPARE_DOWN.equals(perfCompare)) {
            perfCompareOperator = ">";
        }

        searchMap.put("perfCompareOperator", perfCompareOperator);
    }

    /**
     * 조회 대상 컬럼 설정.
     *
     * @param searchMap
     */
    private void setSelectValue(Map<String, String> searchMap) {
        String performChangeOperator = "RATIO_ETOE_TIME(%)";

        String performChange = searchMap.get("performChange");
		if (PERFORMCHANGE_TRS.equals(performChange)) {
            performChangeOperator = "RATIO_ETOE_TIME(%)";
        } else if (PERFORMCHANGE_SEQ.equals(performChange)) {
            performChangeOperator = "RATIO_TOT_SEQ(%)";
        }

        searchMap.put("performChangeOperator", performChangeOperator);
    }
}
