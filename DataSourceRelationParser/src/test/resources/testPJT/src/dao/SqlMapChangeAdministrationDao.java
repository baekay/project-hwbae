/*
 * COPYRIGHT (c) Samsung Fire & Marine Insurance 2005
 * This software is the proprietary information of
 * Samsung Fire & Marine Insurance.
 *
 * Revision History(Created on 2009. 10. 14)
 * =========================================================
 * Author   Date          Description
 * ---------------------------------------------------------
 * HaeBong Lee      2009. 10. 14.  1st Version
 * ---------------------------------------------------------
 */
package sfmi.component.squad.itquality.dao.sqlmap;

import java.util.HashMap;

import sfmi.common.page.PageList;
import sfmi.component.squad.itquality.dao.ChangeAdministrationDao;
import sfmi.component.squad.itquality.dao.SqlMapDaoTemplateExt;
import sfmi.component.squad.itqualitybdt.ChangeAdministration;

import com.ibatis.dao.client.DaoManager;

/**
 * 변화관리 Dao
 *
 * @sfmi.title 변화관리 Dao
 * @sfmi.portal-id ehee.chae
 * @sfmi.developer 채은희
 */

@SuppressWarnings("unchecked")
public class SqlMapChangeAdministrationDao extends SqlMapDaoTemplateExt implements ChangeAdministrationDao {
    public SqlMapChangeAdministrationDao(DaoManager daoManager) {
        super(daoManager);
    }
    
    /* (non-Javadoc)
     * @see sfmi.component.squad.itquality.dao.ChangeAdministrationDao#readChangeAdministrationList(java.util.HashMap)
     */
    public PageList readChangeAdministrationList(HashMap<String, String> searchMap) {
        String radioSearch = searchMap.get("radioSearch");
        
        if ("master".equals(radioSearch)) {
            return readResultListAsPageList(searchMap, "selectChangeAdministrationMasterListCount", "selectChangeAdministrationMasterList");
        }else {
            return readResultListAsPageList(searchMap, "selectChangeAdministrationHistoryListCount", "selectChangeAdministrationHistoryList");
        }
        
    }
    
    /* (non-Javadoc)
     * @see sfmi.component.squad.itquality.dao.ChangeAdministrationDao#createChangeAdministration(sfmi.component.squad.itqualitybdt.ChangeAdministration)
     */
    public void createChangeAdministration(ChangeAdministration changeAdministration) {
        String chrgTrgtYn = changeAdministration.getChrgTrgtYn();

        if ( "Y".equals(chrgTrgtYn) ){          //변경대상 여부가 Y 일때
            insert("createChangeAdministration80tbY", changeAdministration);                
            insert("createChangeAdministration81tbY", changeAdministration);
        } else {        
            insert("createChangeAdministration81tbN", changeAdministration);
        }

    }    
    
    /* (non-Javadoc)
     * @see sfmi.component.squad.itquality.dao.ChangeAdministrationDao#readChangeAdministration(sfmi.component.squad.itqualitybdt.ChangeAdministration)
     */
    public ChangeAdministration readChangeAdministration(ChangeAdministration changeAdministration) {
        
        String radioSearch = changeAdministration.getRadioSearch();

        if ( "master".equals(radioSearch) ){          //변경대상 여부가 Y 일때
            return (ChangeAdministration) queryForObject("selectChangeAdministrationMaster", changeAdministration);
        } else {
           return (ChangeAdministration) queryForObject("selectChangeAdministrationHistory", changeAdministration);
        }
    }
    
    /* (non-Javadoc)
     * @see sfmi.component.squad.itquality.dao.ChangeAdministrationDao#updateChangeAdministration(sfmi.component.squad.itqualitybdt.ChangeAdministration)
     */
    public void updateChangeAdministration(ChangeAdministration changeAdministration) {        

        update("updateChangeAdministration80tb", changeAdministration);  
        update("mergeChangeAdministration", changeAdministration);

    }
    
    /* (non-Javadoc)
     * @see sfmi.component.squad.itquality.dao.ChangeAdministrationDao#deleteChangeAdministration(sfmi.component.squad.itqualitybdt.ChangeAdministration)
     */
    public void deleteChangeAdministration(ChangeAdministration changeAdministration) {
        delete("deleteChangeAdministration", changeAdministration);
    }    
    
    /* (non-Javadoc)
     * @see sfmi.component.squad.itquality.dao.ChangeAdministrationDao#readChangeAdministrationNoRegList(java.util.HashMap)
     */
    public PageList readChangeAdministrationNoRegList(HashMap<String, String> searchMap) {
        return readResultListAsPageList(searchMap, "selectChangeAdministrationNoRegListCount", "selectChangeAdministrationNoRegList");
    }    
}
