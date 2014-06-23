/*
 * COPYRIGHT (c) Samsung Fire & Marine Insurance 2005
 * This software is the proprietary information of
 * Samsung Fire & Marine Insurance.
 *
 * Revision History(Created on 2010. 01. 27)
 * =========================================================
 * Author          Date            Description
 * ---------------------------------------------------------
 * TaeSung Kwon    2010. 01. 27    1st Version
 * ---------------------------------------------------------
 */
package sfmi.component.squad.itquality.dao.sqlmap;

import java.util.HashMap;

import sfmi.common.page.PageList;
import sfmi.component.squad.itquality.dao.ProjectDataQualityResultDao;
import sfmi.component.squad.itquality.dao.SqlMapDaoTemplateExt;
import sfmi.component.squad.itqualitybdt.DataQualityDefect;

import com.ibatis.dao.client.DaoManager;

/**
 * 데이터품질 결과 Dao
 *
 * @sfmi.title 데이터품질 결과 Dao
 * @sfmi.portal-id jk420.kim
 * @sfmi.developer 권태성
 */
public class SqlMapProjectDataQualityResultDao extends SqlMapDaoTemplateExt implements ProjectDataQualityResultDao{

	/**
     * @param daoManager
     */
    public SqlMapProjectDataQualityResultDao(DaoManager daoManager) {
        super(daoManager);
    }

    /* (non-Javadoc)
     * @see sfmi.component.squad.itquality.dao.ProjectDataQualityResultDao#readProjectDataQualityResultList(java.util.HashMap)
     */
    public PageList readProjectDataQualityResultList(HashMap<String, String> searchMap){
    	return readResultListAsPageList(searchMap,"selectProjectDataQualityResultListCount" ,"selectProjectDataQualityResultList");
    }

    /* (non-Javadoc)
     * @see sfmi.component.squad.itquality.dao.ProjectDataQualityResultDao#readProjectDataQualityResult(java.util.HashMap)
     */
    public DataQualityDefect readProjectDataQualityResult(HashMap<String, String> searchMap){
    	return (DataQualityDefect) queryForObject("selectProjectDataQualityResult", searchMap);
    }
}
