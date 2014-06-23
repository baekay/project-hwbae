/*
 * COPYRIGHT (c) Samsung Fire & Marine Insurance 2005
 * This software is the proprietary information of 
 * Samsung Fire & Marine Insurance.
 * 
 * Revision History(Created on 2009. 10. 12)
 * =========================================================
 * Author             Date                   Description
 * ---------------------------------------------------------
 * Seungkwon Kim      2009. 10. 12                1st Version
 * ---------------------------------------------------------
 */
package sfmi.component.squad.itqualitybdt;

import java.util.ArrayList;
import java.util.List;

/**
 * SQL ���� ������ ���� ���� ���� BDT
 *
 * @sfmi.title SQL ���� ������ ���� ���� ���� BDT
 * @sfmi.portal-id jk420.kim
 * @sfmi.developer ��±�
 */
public class SqlDefinitionPattern {
	private List<String> startPatternList;
	private List<String> endPatternList;
	
	public SqlDefinitionPattern() {
		initStartPatternList();
		initEndPatternList();
	}
	
	/**
	 * SQL ���� ���� �ʱ�ȭ 
	 */
	private void initStartPatternList() {
		startPatternList = new ArrayList<String>();
		/*startPatternList.add("<select id=");
		startPatternList.add("<insert id=");
		startPatternList.add("<update id=");
		startPatternList.add("<delete id=");*/
		
		startPatternList.add("<select ");
        startPatternList.add("<insert ");
        startPatternList.add("<update ");
        startPatternList.add("<delete ");
        startPatternList.add("<statement ");
	}

	/**
	 * SQL ���� ���� �ʱ�ȭ
	 */
	private void initEndPatternList() {
		endPatternList = new ArrayList<String>();
		endPatternList.add("</select>");
		endPatternList.add("</insert>");
		endPatternList.add("</update>");
		endPatternList.add("</delete>");
		endPatternList.add("</statement>");
	}

	/**
	 * @return the startPatternList
	 */
	public List<String> getStartPatternList() {
		return startPatternList;
	}

	/**
	 * @param startPatternList the startPatternList to set
	 */
	public void setStartPatternList(List<String> startPatternList) {
		this.startPatternList = startPatternList;
	}

	/**
	 * @return the endPatternList
	 */
	public List<String> getEndPatternList() {
		return endPatternList;
	}

	/**
	 * @param endPatternList the endPatternList to set
	 */
	public void setEndPatternList(List<String> endPatternList) {
		this.endPatternList = endPatternList;
	}

}
