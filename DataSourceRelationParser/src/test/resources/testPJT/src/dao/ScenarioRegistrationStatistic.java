/*
 * COPYRIGHT (c) Samsung Fire & Marine Insurance 2005
 * This software is the proprietary information of 
 * Samsung Fire & Marine Insurance.
 * 
 * Revision History(Created on 2010. 1. 19.)
 * =========================================================
 * Author             Date                   Description
 * ---------------------------------------------------------
 * HaeBong Lee        2010. 1. 19.           1st Version
 * ---------------------------------------------------------
 */

package sfmi.component.squad.itqualitybdt;

import java.io.Serializable;

/**
 * �ó����� ��� ��Ȳ BDT
 * 
 * @sfmi.title �ó����� ��� ��Ȳ BDT
 * @sfmi.portal-id jk420.kim
 * @sfmi.developer ���غ�
 */

public class ScenarioRegistrationStatistic implements Serializable{

	private static final long serialVersionUID = 5253477461346908290L;

	private String systemId;	// �ý��۹�ȣ
	private String systemNm;	// �ý��۸�
	private int scnrioCnt;		// �ó������Ǽ�
	private int totalCnt;		// ���ܺ��հ�Ǽ�
	private int inputCnt;		// �Է����Ǽ�
	private int attCnt;			// ÷�����Ǽ�
	private int qtpCnt;			// QTP�Ǽ�
	private int lrCnt;			// LR�Ǽ�
	private int reCnt;			// ����Ǽ�
	private double reRate;		// �ó�����������
	/**
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}
	/**
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	/**
	 * @return the systemNm
	 */
	public String getSystemNm() {
		return systemNm;
	}
	/**
	 * @param systemNm the systemNm to set
	 */
	public void setSystemNm(String systemNm) {
		this.systemNm = systemNm;
	}
	/**
	 * @return the scnrioCnt
	 */
	public int getScnrioCnt() {
		return scnrioCnt;
	}
	/**
	 * @param scnrioCnt the scnrioCnt to set
	 */
	public void setScnrioCnt(int scnrioCnt) {
		this.scnrioCnt = scnrioCnt;
	}
	/**
	 * @return the totalCnt
	 */
	public int getTotalCnt() {
		return totalCnt;
	}
	/**
	 * @param totalCnt the totalCnt to set
	 */
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	/**
	 * @return the inputCnt
	 */
	public int getInputCnt() {
		return inputCnt;
	}
	/**
	 * @param inputCnt the inputCnt to set
	 */
	public void setInputCnt(int inputCnt) {
		this.inputCnt = inputCnt;
	}
	/**
	 * @return the attCnt
	 */
	public int getAttCnt() {
		return attCnt;
	}
	/**
	 * @param attCnt the attCnt to set
	 */
	public void setAttCnt(int attCnt) {
		this.attCnt = attCnt;
	}
	/**
	 * @return the qtpCnt
	 */
	public int getQtpCnt() {
		return qtpCnt;
	}
	/**
	 * @param qtpCnt the qtpCnt to set
	 */
	public void setQtpCnt(int qtpCnt) {
		this.qtpCnt = qtpCnt;
	}
	/**
	 * @return the lrCnt
	 */
	public int getLrCnt() {
		return lrCnt;
	}
	/**
	 * @param lrCnt the lrCnt to set
	 */
	public void setLrCnt(int lrCnt) {
		this.lrCnt = lrCnt;
	}
	/**
     * @return the reCnt
     */
    public int getReCnt() {
        return reCnt;
    }
    /**
     * @param reCnt the reCnt to set
     */
    public void setReCnt(int reCnt) {
        this.reCnt = reCnt;
    }
    /**
	 * @return the reRate
	 */
	public double getReRate() {
		return reRate;
	}
	/**
	 * @param reRate the reRate to set
	 */
	public void setReRate(double reRate) {
		this.reRate = reRate;
	}
}
