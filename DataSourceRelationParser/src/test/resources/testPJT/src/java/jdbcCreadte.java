/*
 * COPYRIGHT (c) Samsung Fire & Marine Insurance 2005
 * This software is the proprietary information of
 * Samsung Fire & Marine Insurance.
 *
 * Revision History(Created on 2006. 1. 12)
 * =============================================================================
 * Author   Date          Description
 * -----------------------------------------------------------------------------
 * 김경수   2009. 05. 25    최초추가
 * -----------------------------------------------------------------------------
 */
package sfmi.xdbatch.uw.crpoint.processor.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import sfmi.framework.batch.processor.jdbc.SfmiSimpleJdbcDaoSupport;
import sfmi.framework.batch.util.SqlFinder;
import sfmi.xdbatch.uw.crpoint.item.CreateCRPointItem;
import sfmi.xdbatch.uw.crpoint.processor.dao.CreateCRPointDao;
import sfmi.xdbatch.uw.crpoint.util.SqlUtil;
import sfmi.xdbatch.uw.uwcommonbatch.util.Util;

/**
*@sfmi.title        C/R point 고객만족 판매 데이타를 이용하여 point를 발생시킨다.
*@sfmi.developer    김경수 
*@sfmi.portal-id    kskim77
*/
public class JdbcCreateCRPointDao extends SfmiSimpleJdbcDaoSupport implements CreateCRPointDao {

	
	SqlUtil.PUCRDC_CR0001_SQL_CONFIG = "ABCDEFGSFADSFASDAS.xml";
	
    /*public List<CreateCRPointItem> getCRPtargetList(String workDate) {
        String sql = SqlFinder.getSql(SqlUtil.PUCRDC_CR0001_SQL_CONFIG, "selectCRPTargerList");
        ParameterizedRowMapper<CreateCRPointItem> rowMapper = new ParameterizedRowMapper<CreateCRPointItem>(){
            public CreateCRPointItem mapRow(ResultSet rs, int rowNum) throws SQLException{
                CreateCRPointItem item = new CreateCRPointItem();
                item.setPlcyNo(rs.getString("plcyNo"));
                item.setSeqNum(rs.getString("seqNum"));
                item.setAgrmDate(rs.getString("agrmDate"));
                item.setHndlClerk(rs.getString("hndlClerk"));
                item.setHndlDept(rs.getString("hndlDept"));
                item.setHndlJijum(rs.getString("hndlJijum"));
                item.setOccurRoute(rs.getString("occurRoute"));
                item.setUsedCd(rs.getString("usedCd"));
                item.setTerCls(rs.getString("terCls"));
                item.setCheckDate(rs.getString("checkDate"));
                item.setSlfSignVltYnCy(Util.checkNull(rs.getString("slfSignVltYnCy"),"0"));//자필(청)
                item.setInformYn(Util.checkNull(rs.getString("informYn"),"0"));//자필 (상품)
                item.setClauAcptVltYn(Util.checkNull(rs.getString("clauAcptVltYn"),"0"));//약관
                item.setAgrmCopyVltYn(Util.checkNull(rs.getString("agrmCopyVltYn"),"0"));//청약서
                item.setPrdExplVltYn(Util.checkNull(rs.getString("prdExplVltYn"),"0"));//상품설명
                item.setPrddetail1yn(Util.checkNull(rs.getString("prddetail1yn"),"0"));
                item.setPrddetail2yn(Util.checkNull(rs.getString("prddetail2yn"),"0"));
                item.setPrddetail3yn(Util.checkNull(rs.getString("prddetail3yn"),"0"));
                item.setPrddetail4yn(Util.checkNull(rs.getString("prddetail4yn"),"0"));
                item.setNowHealthVltYn(Util.checkNull(rs.getString("nowHealthVltYn"),"0"));//고지-현재건강
                item.setJobCodeVltYn(Util.checkNull(rs.getString("detailJobVltYn"),"0"));//고지-직업
                item.setNoCheckReason(rs.getString("noCheckReason"));
                item.setContorId(rs.getString("contorId"));
                item.setPibojaId(rs.getString("pibojaId"));
                item.setPrdCode(rs.getString("prdCode"));
                item.setEndoInputTm(rs.getString("endoInputTm")); //수납일         
                return item;
            }
        };
        return getSimpleJdbcTemplate().query(sql, rowMapper, workDate);
    }*/
    
    public List<CreateCRPointItem> getCRpoint(String checkRoute, String checkDate) {
        String sql = SqlFinder.getSql(SqlUtil.PUCRDC_CR0001_SQL_CONFIG, "selectCRpoint");
        ParameterizedRowMapper<CreateCRPointItem> rowMapper = new ParameterizedRowMapper<CreateCRPointItem>(){
            public CreateCRPointItem mapRow(ResultSet rs, int rowNum) throws SQLException{
                CreateCRPointItem item = new CreateCRPointItem();
                item.setCRPoint(Util.checkNull(rs.getString("crpoint"),"0"));
                item.setOffenseType(Util.checkNull(rs.getString("vltType")));
                item.setOffenseMatter(Util.checkNull(rs.getString("detlVltType")));             
                return item;
            }
        };
        return getSimpleJdbcTemplate().query(sql, rowMapper,  checkRoute, checkDate, checkDate);
    }

    public Map<String, Object> isCRpoint(String plcyNo) {
        String sql = SqlFinder.getSql(SqlUtil.PUCRDC_CR0001_SQL_CONFIG, "isCRpoint");
        return getSimpleJdbcTemplate().queryForMap(sql, plcyNo);
    }

    public int deleteCRpoint(String checkRoute, String checkDate, String occurSeq) {
        String sql = SqlFinder.getSql(SqlUtil.PUCRDC_CR0001_SQL_CONFIG, "deleteCRpoint");
        return getSimpleJdbcTemplate().update(sql, checkRoute, checkDate, occurSeq);
    }
    

    public String getCaptain(String deptCd, String baseDate) {
        String sql = SqlFinder.getSql(SqlUtil.PUCRDC_CR0001_SQL_CONFIG, "selectCaptain");
        String result = getSimpleJdbcTemplate().queryForString(sql, deptCd, baseDate, baseDate);
        return (result != null ? result.trim() : "");
    }

    public int getMaxSeq(String checkRoute, String workDate) {
        String sql = SqlFinder.getSql(SqlUtil.PUCRDC_CR0001_SQL_CONFIG, "selectMaxSeq");
        return getSimpleJdbcTemplate().queryForInt(sql, checkRoute, workDate);
    }

    public String getSamePlcyNo(String plcyNo) {
        String sql = SqlFinder.getSql(SqlUtil.PUCRDC_CR0001_SQL_CONFIG, "selectSamePlcyNo");
        String result = getSimpleJdbcTemplate().queryForString(sql, plcyNo);
        return (result != null ? result.trim() : "");
    }

    public void updateEndDate(String plcyNo) {
        String sql = SqlFinder.getSql(SqlUtil.PUCRDC_CR0001_SQL_CONFIG, "updateEndDate");
        getSimpleJdbcTemplate().update(sql, plcyNo);
    }

    public void updateValidDate(String plcyNo, String checkRoute) {
        String sql = SqlFinder.getSql(SqlUtil.PUCRDC_CR0001_SQL_CONFIG, "updateValidDate");
        getSimpleJdbcTemplate().update(sql, plcyNo, checkRoute);
    }

    public int createCRpoint(CreateCRPointItem item) {
        String sql = SqlFinder.getSql(SqlUtil.PUCRDC_CR0001_SQL_CONFIG, "insertCRpoint");
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(item);  
        
        return getSimpleJdbcTemplate().update(sql, paramSource);
    }
    
}
