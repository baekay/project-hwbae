/*
 * COPYRIGHT (c) Samsung Fire & Marine Insurance 2005
 * This software is the proprietary information of
 * Samsung Fire & Marine Insurance.
 *
 * Revision History(Created on 2009. 10. 15)
 * =========================================================
 * Author   Date          Description
 * ---------------------------------------------------------
 * Taesung Kwon     2009. 12. 4        1st Version
 * ---------------------------------------------------------
 */
package sfmi.component.squad.itqualitybdt;

import java.io.Serializable;

/**
 * �����ͼҽ� �������� BDT
 *
 * @sfmi.title DatasourceConnInfo.java
 * @sfmi.portal-id jk420.kim
 * @sfmi.developer ���¼�
 */
public class DatasourceConnInfo implements Serializable {

	private static final long serialVersionUID = 4314103497229602003L;

	private String dsNm;		//Datasource��
	private String mngCls;		//�����
	private String mngClsNm;	//����и�
	private String dbCls;		//DB����
	private String dbClsNm;		//DB���и�
	private String jdbcUrl;		//URL
	private String driverCls;	//DriverClass
	private String connId;		//ID
	private String connPwd;		//Password
	private String schemaNm;	//Schma��
	private String inputClerk;  //�Է��ڸ�
	private String keyDsNm;		//������ ���� Ű��
	private String keyMngCls;	//������ ���� Ű��

	public DatasourceConnInfo(){
	}

	/**
	 * @return the dsNm
	 */
	public String getDsNm() {
		return dsNm;
	}


	/**
	 * @param dsNm the dsNm to set
	 */
	public void setDsNm(String dsNm) {
		this.dsNm = dsNm;
	}

	/**
	 * @return the mngCls
	 */
	public String getMngCls() {
		return mngCls;
	}

	/**
	 * @param mngCls the mngCls to set
	 */
	public void setMngCls(String mngCls) {
		this.mngCls = mngCls;
	}

	/**
	 * @return the mngClsNm
	 */
	public String getMngClsNm() {
		return mngClsNm;
	}

	/**
	 * @param mngClsNm the mngClsNm to set
	 */
	public void setMngClsNm(String mngClsNm) {
		this.mngClsNm = mngClsNm;
	}

	/**
	 * @return the dbCls
	 */
	public String getDbCls() {
		return dbCls;
	}

	/**
	 * @param dbCls the dbCls to set
	 */
	public void setDbCls(String dbCls) {
		this.dbCls = dbCls;
	}

	/**
	 * @return the jdbcUrl
	 */
	public String getJdbcUrl() {
		return jdbcUrl;
	}

	/**
	 * @param jdbcUrl the jdbcUrl to set
	 */
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	/**
	 * @return the driverCls
	 */
	public String getDriverCls() {
		return driverCls;
	}

	/**
	 * @param driverCls the driverCls to set
	 */
	public void setDriverCls(String driverCls) {
		this.driverCls = driverCls;
	}

	/**
	 * @return the connId
	 */
	public String getConnId() {
		return connId;
	}

	/**
	 * @param connId the connId to set
	 */
	public void setConnId(String connId) {
		this.connId = connId;
	}

	/**
	 * @return the connPwd
	 */
	public String getConnPwd() {
		return connPwd;
	}

	/**
	 * @param connPwd the connPwd to set
	 */
	public void setConnPwd(String connPwd) {
		this.connPwd = connPwd;
	}

	/**
	 * @return the schemaNm
	 */
	public String getSchemaNm() {
		return schemaNm;
	}

	/**
	 * @param schemaNm the schemaNm to set
	 */
	public void setSchemaNm(String schemaNm) {
		this.schemaNm = schemaNm;
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
	 * @return the keyDsNm
	 */
	public String getKeyDsNm() {
		return keyDsNm;
	}

	/**
	 * @param keyDsNm the keyDsNm to set
	 */
	public void setKeyDsNm(String keyDsNm) {
		this.keyDsNm = keyDsNm;
	}

	/**
	 * @return the keyMngCls
	 */
	public String getKeyMngCls() {
		return keyMngCls;
	}

	/**
	 * @param keyMngCls the keyMngCls to set
	 */
	public void setKeyMngCls(String keyMngCls) {
		this.keyMngCls = keyMngCls;
	}

	/**
	 * @return the dbClsNm
	 */
	public String getDbClsNm() {
		return dbClsNm;
	}

	/**
	 * @param dbClsNm the dbClsNm to set
	 */
	public void setDbClsNm(String dbClsNm) {
		this.dbClsNm = dbClsNm;
	}


}
