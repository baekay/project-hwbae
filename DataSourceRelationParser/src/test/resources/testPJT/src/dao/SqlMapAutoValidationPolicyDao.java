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
 * 품질자동검증정책 Dao
 *
 * @sfmi.title 품질자동검증정책 Dao
 * @sfmi.portal-id jk420.kim
 * @sfmi.developer 이해봉
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
		 * 개별 품질자동검증정책 별 아이템 매핑
		 */
		itemMap = new HashMap<String, String>();
		// 수행여부
		itemMap.put("수행여부", "Q1001");
		// 어플리케이션 구조
		itemMap.put("차세대", "Q1101");
		itemMap.put("비차세대", "Q1102");
		// 형상서버유형
		itemMap.put("CC", "Q1201");
		itemMap.put("SVN", "Q1202");
		// 컴포넌트유형
		itemMap.put("온라인", "Q1301");
		itemMap.put("배치", "Q1302");
		// 확장자
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
		 * 품질자동검증정책 유형코드 매핑
		 */
		codeMap = new HashMap<String, String>();
		codeMap.put("CI", "Q0901");
		codeMap.put("ILM메타", "Q0902");
		codeMap.put("배치쉘", "Q0903");
		codeMap.put("UDB", "Q0904");
		codeMap.put("ORACLE", "Q0905");
		codeMap.put("보안취약성", "Q0906");
		codeMap.put("원장변경통제", "Q0907");
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
		// DB에서 전체 품질자동검증정책 아이템을 얻어옴
		List<AutoValidationPolicyItem> allAutoValidationPolicyItems = queryForList("selectAutoValidationPolicyList", null);

		// 각 품질 속성별로 나눠 저장할 리스트 초기화
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForCI = new ArrayList<AutoValidationPolicyItem>();
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForILM = new ArrayList<AutoValidationPolicyItem>();
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForBatch = new ArrayList<AutoValidationPolicyItem>();
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForUDB = new ArrayList<AutoValidationPolicyItem>();
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForOracle = new ArrayList<AutoValidationPolicyItem>();
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForSecurity = new ArrayList<AutoValidationPolicyItem>();
		List<AutoValidationPolicyItem> allAutoValidationPolicyItemsForLedger = new ArrayList<AutoValidationPolicyItem>();

		// 각 품질 속성별 리스트로 아이템을 모음
/*		for(AutoValidationPolicyItem item : allAutoValidationPolicyItems) {
			if ( item.getQtyClsCodeVal() != null && codeMap.get("CI").equals(item.getQtyClsCodeVal())) {
				allAutoValidationPolicyItemsForCI.add(item);
			} else if ( item.getQtyClsCodeVal() != null && codeMap.get("ILM메타").equals(item.getQtyClsCodeVal())) {
				allAutoValidationPolicyItemsForILM.add(item);
			} else if ( item.getQtyClsCodeVal() != null && codeMap.get("배치쉘").equals(item.getQtyClsCodeVal())) {
				allAutoValidationPolicyItemsForBatch.add(item);
			} else if ( item.getQtyClsCodeVal() != null && codeMap.get("UDB").equals(item.getQtyClsCodeVal())) {
				allAutoValidationPolicyItemsForUDB.add(item);
			} else if ( item.getQtyClsCodeVal() != null && codeMap.get("ORACLE").equals(item.getQtyClsCodeVal())) {
				allAutoValidationPolicyItemsForOracle.add(item);
			} else if ( item.getQtyClsCodeVal() != null && codeMap.get("보안취약성").equals(item.getQtyClsCodeVal())) {
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
			codeMapILM = codeMap.get("ILM메타");
			codeMapBATCH = codeMap.get("배치쉘");
			codeMapUDB = codeMap.get("UDB");
			codeMapORACLE = codeMap.get("ORACLE");
			codeMapSECURITY = codeMap.get("보안취약성");
			codeMapLEDGER = codeMap.get("원장변경통제");

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

		// 코드표준-CI용 품질자동검증정책 생성
		AutoValidationPolicy ciPolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForCI);
		// 코드표준-ILM메타용 품질자동검증정책 생성
		AutoValidationPolicy ilmMetaPolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForILM);
		// 코드표준-배치쉘용 품질자동검증정책 생성
		AutoValidationPolicy batchShellPolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForBatch);
		// SQL표준-UDB용 품질자동검증정책 생성
		AutoValidationPolicy udbPolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForUDB);
		// SQL표준-ORACLE용 품질자동검증정책 생성
		AutoValidationPolicy oraclePolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForOracle);
		// 보안취약성 품질자동검증정책 생성
		AutoValidationPolicy securityPolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForSecurity);
        // 원장변경통제 품질자동검증정책 생성
        AutoValidationPolicy ledgerPolicy = makeAutoValidationPolicy(allAutoValidationPolicyItemsForLedger);

		// 전체 정책 리스트를 만들어서 리턴
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
			if (i==ItqualityConstants.ZERO_INTEGER) { // 한번만 품질구분코드값을 설정
				autoValidationPolicy.setQtyClsCodeVal(item.getQtyClsCodeVal());
				i++;
			}
			// 22개 품질자동검증정책 영역에 해당하는 정책 아이템을 가져와서 적절한 곳에 저장
			// 수행여부
			itemMapValidation = itemMap.get("수행여부");
			itemMapNextGeneration = itemMap.get("차세대");
			itemMapNonNextGeneration = itemMap.get("비차세대");
			itemMapClearCase = itemMap.get("CC");
			itemMapSubVersion = itemMap.get("SVN");
			itemMapOnline = itemMap.get("온라인");
			itemMapBatch = itemMap.get("배치");

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
            if ("1".equals(autoValidationTarget.getVersionAsNumber())) { //CC: 파일의 버전이 1일 때 수행.
                return true;
            } else {
                return false;
            }
        } else if (CmServerType.SVN.equals(autoValidationTarget.getCmServerType())) { //SVN: ILM에 메타정보가 없는 경우 버전 1로 보고 수행
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