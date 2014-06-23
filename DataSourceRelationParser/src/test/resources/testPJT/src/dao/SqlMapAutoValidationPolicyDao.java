/*
 * COPYRIGHT (c) Samsung Fire & Marine Insurance 2005
 * This software is the proprietary information of
 * Samsung Fire & Marine Insurance.
 *
 * Revision History(Created on 2009. 11. 16)
 * =========================================================
 * Author          Date            Description
 * ---------------------------------------------------------
 * HaeBong Lee     2009. 11. 16    1st Version
 * ---------------------------------------------------------
 */
package sfmi.component.squad.itquality.dao.sqlmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sfmi.component.squad.itquality.dao.AutoValidationPolicyDao;
import sfmi.component.squad.itquality.dao.SqlMapDaoTemplateExt;
import sfmi.component.squad.itqualitybdt.AutoValidationPolicy;
import sfmi.component.squad.itqualitybdt.AutoValidationPolicyItem;
import sfmi.component.squad.itqualitybdt.AutoValidationTarget;
import sfmi.component.squad.itqualitybdt.enums.CmServerType;
import sfmi.component.squad.itqualitycommon.ItqualityConstants;

import com.ibatis.dao.client.DaoManager;

/**
 * ǰ���ڵ�������å Dao
 *
 * @sfmi.title ǰ���ڵ�������å Dao
 * @sfmi.portal-id jk420.kim
 * @sfmi.developer ���غ�
 */
public class SqlMapAutoValidationPolicyDao extends SqlMapDaoTemplateExt implements AutoValidationPolicyDao {

	private Map<String, String> itemMap;
	private Map<String, String> codeMap;


	/**
	 * @param daoManager
	 */
	public SqlMapAutoValidationPolicyDao(DaoManager daoManager) {
		super(daoManager);
		/**
		 * ���� ǰ���ڵ�������å �� ������ ����
		 */
		itemMap = new HashMap<String, String>();
		// ���࿩��
		itemMap.put("���࿩��", "Q1001");
		// ���ø����̼� ����
		itemMap.put("������", "Q1101");
		itemMap.put("��������", "Q1102");
		// ���󼭹�����
		itemMap.put("CC", "Q1201");
		itemMap.put("SVN", "Q1202");
		// ������Ʈ����
		itemMap.put("�¶���", "Q1301");
		itemMap.put("��ġ", "Q1302");
		// Ȯ����
		itemMap.put(".java", "Q1401");	// setJavaExt()
		itemMap.put(".jsp", "Q1402");
		itemMap.put(".html", "Q1403");
		itemMap.put(".js", "Q1404");
		itemMap.put(".asp", "Q1405");
		itemMap.put(".inc", "Q1406");
		itemMap.put(".xml", "Q1407");
		itemMap.put(".properties", "Q1408");
		itemMap.put(".sh", "Q1409");
		itemMap.put(".pc", "Q1410");
		itemMap.put(".c", "Q1411");
		itemMap.put(".sql", "Q1412");
		itemMap.put(".cob", "Q1413");
		itemMap.put("JCL", "Q1414");
		itemMap.put("ABAB", "Q1415");

		/**
		 * ǰ���ڵ�������å �����ڵ� ����
		 */
		codeMap = new HashMap<String, String>();
		codeMap.put("CI", "Q0901");
		codeMap.put("ILM��Ÿ", "Q0902");
		codeMap.put("��ġ��", "Q0903");
		codeMap.put("UDB", "Q0904");
		codeMap.put("ORACLE", "Q0905");
		codeMap.put("������༺", "Q0906");
		codeMap.put("���庯������", "Q0907");
	}

	/* (non-Javadoc)
	 * @see sfmi.component.squad.itquality.dao.AutoValidationPolicyDao#createAutoValidationPolicy(java.util.List)
	 */
	public void createAutoValidationPolicy(List<AutoValidationPolicyItem> autoValidationPolicyItemList) {
        for(AutoValidationPolicyItem autoValidationPolicyItem : autoValidationPolicyItemList)
            insert("createAutoValidationPolicy", autoValidationPolicyItem);
	}

	/* (non-Javadoc)
	 * @see sfmi.component.squad.itquality.dao.AutoValidationPolicyDao#getAutoValidationPolicy(java.util.HashMap)
	 */
	@SuppressWarnings("unchecked")
	public AutoValidationPolicy readAutoValidationPolicy(HashMap<String, String> searchMap) {
		List<AutoValidationPolicyItem> autoValidationPolicyItems = queryForList("selectAutoValidationPolicy", searchMap);
		return makeAutoValidationPolicy(autoValidationPolicyItems);
	}

	/* (non-Javadoc)
	 * @see sfmi.component.squad.itquality.dao.AutoValidationPolicyDao#getAutoValidationPolicyList()
	 */
	@SuppressWarnings("unchecked")
	public List<AutoValidationPolicy> readAutoValidationPolicyList() {
		// DB���� ��ü ǰ���ڵ�������å �������� ����
		List<AutoValidationPolicyItem> allAutoValidationPolicyItems = queryForList("selectAutoValidationPolicyList", null);

		// �� ǰ�� �Ӽ����� ���� ������ ����Ʈ �ʱ�ȭ
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForCI = new ArrayList<AutoValidationPolicyItem>();
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForILM = new ArrayList<AutoValidationPolicyItem>();
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForBatch = new ArrayList<AutoValidationPolicyItem>();
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForUDB = new ArrayList<AutoValidationPolicyItem>();
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForOracle = new ArrayList<AutoValidationPolicyItem>();
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForSecurity = new ArrayList<AutoValidationPolicyItem>();
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForLedger = new ArrayList<AutoValidationPolicyItem>();

		// �� ǰ�� �Ӽ��� ����Ʈ�� �������� ����
/*		for(AutoValidationPolicyItem item : allAutoValidationPolicyItems) {
			if ( item.getQtyClsCodeVal() != null && codeMap.get("CI").equals(item.getQtyClsCodeVal())) {
				allAutoValidationPolicyItemsForCI.add(item);
			} else if ( item.getQtyClsCodeVal() != null && codeMap.get("ILM��Ÿ").equals(item.getQtyClsCodeVal())) {
				allAutoValidationPolicyItemsForILM.add(item);
			} else if ( item.getQtyClsCodeVal() != null && codeMap.get("��ġ��").equals(item.getQtyClsCodeVal())) {
				allAutoValidationPolicyItemsForBatch.add(item);
			} else if ( item.getQtyClsCodeVal() != null && codeMap.get("UDB").equals(item.getQtyClsCodeVal())) {
				allAutoValidationPolicyItemsForUDB.add(item);
			} else if ( item.getQtyClsCodeVal() != null && codeMap.get("ORACLE").equals(item.getQtyClsCodeVal())) {
				allAutoValidationPolicyItemsForOracle.add(item);
			} else if ( item.getQtyClsCodeVal() != null && codeMap.get("������༺").equals(item.getQtyClsCodeVal())) {
				allAutoValidationPolicyItemsForSecurity.add(item);
			}
		}*/

		String codeMapCI = "";
		String codeMapILM = "";
		String codeMapBATCH = "";
		String codeMapUDB = "";
		String codeMapORACLE = "";
		String codeMapSECURITY = "";
		String codeMapLEDGER = "";

		for(AutoValidationPolicyItem item : allAutoValidationPolicyItems) {
			codeMapCI = codeMap.get("CI");
			codeMapILM = codeMap.get("ILM��Ÿ");
			codeMapBATCH = codeMap.get("��ġ��");
			codeMapUDB = codeMap.get("UDB");
			codeMapORACLE = codeMap.get("ORACLE");
			codeMapSECURITY = codeMap.get("������༺");
			codeMapLEDGER = codeMap.get("���庯������");

			if ( codeMapCI.equals(item.getQtyClsCodeVal()))
				allAutoValidationPolicyItemsForCI.add(item);

			if ( codeMapILM.equals(item.getQtyClsCodeVal()))
				allAutoValidationPolicyItemsForILM.add(item);

			if ( codeMapBATCH.equals(item.getQtyClsCodeVal()))
				allAutoValidationPolicyItemsForBatch.add(item);

			if ( codeMapUDB.equals(item.getQtyClsCodeVal()))
				allAutoValidationPolicyItemsForUDB.add(item);

			if ( codeMapORACLE.equals(item.getQtyClsCodeVal()))
				allAutoValidationPolicyItemsForOracle.add(item);

			if ( codeMapSECURITY.equals(item.getQtyClsCodeVal()))
				allAutoValidationPolicyItemsForSecurity.add(item);

            if ( codeMapLEDGER.equals(item.getQtyClsCodeVal()))
                allAutoValidationPolicyItemsForLedger.add(item);
		}

		// �ڵ�ǥ��-CI�� ǰ���ڵ�������å ����
		AutoValidationPolicy ciPolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForCI);
		// �ڵ�ǥ��-ILM��Ÿ�� ǰ���ڵ�������å ����
		AutoValidationPolicy ilmMetaPolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForILM);
		// �ڵ�ǥ��-��ġ���� ǰ���ڵ�������å ����
		AutoValidationPolicy batchShellPolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForBatch);
		// SQLǥ��-UDB�� ǰ���ڵ�������å ����
		AutoValidationPolicy udbPolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForUDB);
		// SQLǥ��-ORACLE�� ǰ���ڵ�������å ����
		AutoValidationPolicy oraclePolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForOracle);
		// ������༺ ǰ���ڵ�������å ����
		AutoValidationPolicy securityPolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForSecurity);
        // ���庯������ ǰ���ڵ�������å ����
        AutoValidationPolicy ledgerPolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForLedger);

		// ��ü ��å ����Ʈ�� ���� ����
		List<AutoValidationPolicy> autoValidationPolicies = new ArrayList<AutoValidationPolicy>();
		autoValidationPolicies.add(ciPolicy);
		autoValidationPolicies.add(ilmMetaPolicy);
		autoValidationPolicies.add(batchShellPolicy);
		autoValidationPolicies.add(udbPolicy);
		autoValidationPolicies.add(oraclePolicy);
		autoValidationPolicies.add(securityPolicy);
		autoValidationPolicies.add(ledgerPolicy);

		return (List<AutoValidationPolicy>)autoValidationPolicies;
	}

	/**
	 * @param autoValidationPolicyItems
	 * @return
	 */
	private AutoValidationPolicy makeAutoValidationPolicy(List<AutoValidationPolicyItem> autoValidationPolicyItems) {
		AutoValidationPolicy autoValidationPolicy = new AutoValidationPolicy();
		int i = 0;

		String itemMapValidation = "";
		String itemMapNextGeneration = "";
		String itemMapNonNextGeneration = "";
		String itemMapClearCase = "";
		String itemMapSubVersion = "";
		String itemMapOnline = "";
		String itemMapBatch = "";

		for (AutoValidationPolicyItem item : autoValidationPolicyItems) {
			if (i==ItqualityConstants.ZERO_INTEGER) { // �ѹ��� ǰ�������ڵ尪�� ����
				autoValidationPolicy.setQtyClsCodeVal(item.getQtyClsCodeVal());
				i++;
			}
			// 22�� ǰ���ڵ�������å ������ �ش��ϴ� ��å �������� �����ͼ� ������ ���� ����
			// ���࿩��
			itemMapValidation = itemMap.get("���࿩��");
			itemMapNextGeneration = itemMap.get("������");
			itemMapNonNextGeneration = itemMap.get("��������");
			itemMapClearCase = itemMap.get("CC");
			itemMapSubVersion = itemMap.get("SVN");
			itemMapOnline = itemMap.get("�¶���");
			itemMapBatch = itemMap.get("��ġ");

			if (itemMapValidation.equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setValidationExecution(item);

			if (itemMapNextGeneration.equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setNextGeneration(item);

			if (itemMapNonNextGeneration.equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setNonNextGeneration(item);

			if (itemMapClearCase.equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setClearCase(item);

			if (itemMapSubVersion.equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setSubVersion(item);

			if (itemMapOnline.equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setOnline(item);

			if (itemMapBatch.equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setBatch(item);

/*			if (itemMap.get(".java").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setJavaExt(item);
			else if (itemMap.get(".java").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setJavaExt(item);

			if (itemMap.get(".jsp").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setJspExt(item);
			else if (itemMap.get(".jsp").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setJspExt(item);

			if (itemMap.get(".html").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setHtmlExt(item);
			else if (itemMap.get(".html").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setHtmlExt(item);

			if (itemMap.get(".js").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setJsExt(item);
			else if (itemMap.get(".js").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setJsExt(item);

			if (itemMap.get(".asp").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setAspExt(item);
			else if (itemMap.get(".asp").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setAspExt(item);

			if (itemMap.get(".inc").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setIncExt(item);
			else if (itemMap.get(".inc").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setIncExt(item);

			if (itemMap.get(".xml").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setXmlExt(item);
			else if (itemMap.get(".xml").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setXmlExt(item);

			if (itemMap.get(".properties").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setProptExt(item);
			else if (itemMap.get(".properties").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setProptExt(item);

			if (itemMap.get(".sh").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setShExt(item);
			else if (itemMap.get(".sh").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setShExt(item);

			if (itemMap.get(".pc").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setPcExt(item);
			else if (itemMap.get(".pc").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setPcExt(item);

			if (itemMap.get(".c").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setcExt(item);
			else if (itemMap.get(".c").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setcExt(item);

			if (itemMap.get(".sql").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setSqlExt(item);
			else if (itemMap.get(".sql").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setSqlExt(item);

			if (itemMap.get(".cob").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setCobExt(item);
			else if (itemMap.get(".cob").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setCobExt(item);

			if (itemMap.get("JCL").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setJclExt(item);
			else if (itemMap.get("JCL").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setJclExt(item);

			if (itemMap.get("ABAB").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setAbabExt(item);
			else if (itemMap.get("ABAB").equals(item.getPlcyClsCodeVal()))
				autoValidationPolicy.setAbabExt(item);*/
		}
		return autoValidationPolicy;
	}

    /* (non-Javadoc)
     * @see sfmi.component.squad.itquality.dao.AutoValidationPolicyDao#isLedgerCtrl(AutoValidationTarget autoValidationTarget)
     */
    @SuppressWarnings("unchecked")
    public boolean isLedgerCtrl(AutoValidationTarget autoValidationTarget) {
        int cnt = ((Integer)queryForObject("selectLedgerCtrlFromSR", autoValidationTarget)).intValue();
        if( cnt>0 )
            return true;
        else
            return false;
    }

    /* (non-Javadoc)
     * @see sfmi.component.squad.itquality.dao.AutoValidationPolicyDao#isCustomerSecurityCheckTarget(AutoValidationTarget autoValidationTarget)
     */
    @SuppressWarnings("unchecked")
    public boolean isCustomerSecurityCheckTarget(AutoValidationTarget autoValidationTarget) {
        if (CmServerType.CC.equals(autoValidationTarget.getCmServerType())) {
            if ("1".equals(autoValidationTarget.getVersionAsNumber())) { //CC: ������ ������ 1�� �� ����.
                return true;
            } else {
                return false;
            }
        } else if (CmServerType.SVN.equals(autoValidationTarget.getCmServerType())) { //SVN: ILM�� ��Ÿ������ ���� ��� ���� 1�� ���� ����
            int meteCnt = ((Integer)queryForObject("selectCustomerSecurityCheckTargetFromILM", autoValidationTarget)).intValue();
            if (meteCnt == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}