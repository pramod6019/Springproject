package axela.portal.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.helpdesk.model.AxelaHelpDeskTicketCat;
import axela.helpdesk.model.AxelaHelpDeskTicketType;
import axela.inventory.model.AxelaInventoryGroup;
import axela.inventory.model.AxelaInventoryItemOption;
import axela.portal.model.AxelaAccDelstatus;
import axela.portal.model.AxelaAccWfDoc;
import axela.portal.model.AxelaActivityStatus;
import axela.portal.model.AxelaActivityType;
import axela.portal.model.AxelaCustomerGroup;
import axela.portal.model.AxelaEmp;
import axela.portal.model.AxelaFinanceComp;
import axela.portal.model.AxelaModuleAccess;
import axela.portal.model.AxelaSalesCrmday;
import axela.portal.model.AxelaSalesOpprBrochure;
import axela.portal.model.AxelaSalesOpprDestination;
import axela.portal.model.AxelaSalesOpprStage;
import axela.portal.model.AxelaSob;
import axela.portal.model.AxelaSoe;
import axela.portal.model.AxelaTitle;
import axela.sales.model.AxelaSalesCampaignType;
import axela.sales.model.AxelaSalesOpprFollowupDesc;
import axela.sales.model.AxelaSalesOpprPriority;
import axela.service.model.AxelaServiceContractAssetBrand;
import axela.service.model.AxelaServiceContractAssetType;
import axela.service.model.AxelaServiceContractServiceType;
import axela.service.model.AxelaServiceContractType;
import axela.service.model.AxelaServiceJcCat;
import axela.service.model.AxelaServiceJcType;
//import axela.customer.model.AxelaCustomer;

@Repository
@Transactional(readOnly = false)
public class PortalFilterImpl extends Connect {

	@PersistenceContext
	EntityManager em;
	// EntityTransaction updateoperation = null;
	public static String totalCount = "0";
	String countSql = "";

	public List<AxelaSoe> findSoe(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		List<AxelaSoe> listData = new ArrayList<AxelaSoe>();
		String strSql = "SELECT NEW AxelaSoe(soe.soeId, "
				+ " soe.soeName )";

		sqlJoin += " FROM AxelaSoe  soe "
				+ " WHERE 1=1 "
				+ strSearch;

		countSql = "SELECT COUNT(DISTINCT soe.soeId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ strSearch
					+ " GROUP BY soe.soeId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaSoe.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaSob> findSob(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		List<AxelaSob> listData = new ArrayList<AxelaSob>();
		String strSql = "SELECT NEW AxelaSob(sob.sobId, "
				+ " sob.sobName )";

		sqlJoin += " FROM AxelaSob  sob "
				+ " WHERE 1=1 "
				+ strSearch;

		countSql = "SELECT COUNT(DISTINCT sob.sobId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ strSearch
					+ " GROUP BY sob.sobId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaSob.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaSalesCampaignType> findAllCampaignType(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaSalesCampaignType> listData = new ArrayList<AxelaSalesCampaignType>();
		String strSql = "SELECT NEW AxelaSalesCampaignType("
				+ " type.camptypeId,"
				+ " type.camptypeDesc,"
				+ " type.camptypeEntryId,"
				+ " type.camptypeEntryDate,"
				+ " type.camptypeModifiedId,"
				+ " type.camptypeModifiedDate)";

		sqlJoin += " FROM AxelaSalesCampaignType type"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT type.camptypeId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY type.camptypeId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaSalesCampaignType.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaServiceContractAssetBrand> findAllAssetBrand(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceContractAssetBrand> listData = new ArrayList<AxelaServiceContractAssetBrand>();

		String strSql = "SELECT NEW AxelaServiceContractAssetBrand("
				+ " brand.assetbrandId,"
				+ " brand.assetbrandName,"
				+ " brand.assetbrandEntryId,"
				+ " brand.assetbrandEntryDate,"
				+ " brand.assetbrandModifiedId,"
				+ " brand.assetbrandModifiedDate)";

		sqlJoin += " FROM AxelaServiceContractAssetBrand brand"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT brand.assetbrandId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY brand.assetbrandId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaServiceContractAssetBrand.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaServiceContractAssetType> findAllAssetType(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceContractAssetType> listData = new ArrayList<AxelaServiceContractAssetType>();

		String strSql = "SELECT NEW AxelaServiceContractAssetType("
				+ " type.contractassettypeId,"
				+ " type.contractassettypeName,"
				+ " type.contractassettypeEntryId,"
				+ " type.contractassettypeEntryDate,"
				+ " type.contractassettypeModifiedId ,"
				+ " type.contractassettypeModifiedDate)";

		sqlJoin += " FROM AxelaServiceContractAssetType type"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT type.contractassettypeId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY type.contractassettypeId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaServiceContractAssetType.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}
	public List<AxelaActivityStatus> findActivityStatusDetail(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		List<AxelaActivityStatus> listData = new ArrayList<AxelaActivityStatus>();
		String strSql = "SELECT NEW AxelaActivityStatus(status.statusId, "
				+ " status.statusDesc )";

		sqlJoin += " FROM AxelaActivityStatus  status "
				+ " WHERE 1=1 "
				+ strSearch;

		countSql = "SELECT COUNT(DISTINCT status.statusId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ strSearch
					+ " GROUP BY status.statusId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaActivityStatus.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaCustomerGroup> findAllGroup(String strSearch, String strOrderBy, int page, int perPage) {

		String sqlJoin = "";
		String countSql = "";
		List<AxelaCustomerGroup> listData = new ArrayList<AxelaCustomerGroup>();
		String strSql = "SELECT NEW AxelaCustomerGroup("
				+ " groups.groupId,"
				+ " groups.groupDesc,"
				+ " groups.groupEntryId,"
				+ " groups.groupEntryDate,"
				+ " groups.groupModifiedId,"
				+ " groups.groupModifiedDate)";

		sqlJoin += " FROM AxelaCustomerGroup groups"
				+ " WHERE 1=1 "
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT groups.groupId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";

		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY groups.groupId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaCustomerGroup.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaTitle> findAllTitle(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaTitle> listData = new ArrayList<AxelaTitle>();
		String strSql = "SELECT NEW AxelaTitle("
				+ " title.titleId,"
				+ " title.titleGender,"
				+ " title.titleDesc,"
				+ " title.titleRank,"
				+ " title.titleEntryId,"
				+ " title.titleEntryDate,"
				+ " title.titleModifiedId,"
				+ " title.titleModifiedDate)";

		sqlJoin += " FROM AxelaTitle title"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT title.titleId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY title.titleId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaTitle.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaActivityType> findActivitytype(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaActivityType> listData = new ArrayList<AxelaActivityType>();
		String strSql = "SELECT NEW AxelaActivityType("
				+ " type.activitytypeId,"
				+ " type.activitytypeDesc,"
				+ " type.activitytypeName,"
				+ " type.activitytypeRank)";

		sqlJoin += " FROM AxelaActivityType type"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT type.activitytypeId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY type.activitytypeId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaActivityType.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaSalesOpprDestination> findDestination(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaSalesOpprDestination> listData = new ArrayList<AxelaSalesOpprDestination>();
		String strSql = "SELECT NEW AxelaSalesOpprDestination("
				+ " destination.destinationId,"
				+ " destination.destinationName)";

		sqlJoin += " FROM AxelaSalesOpprDestination destination"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT destination.destinationId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY destination.destinationId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaSalesOpprDestination.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaAccDelstatus> findDelstatus(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaAccDelstatus> listData = new ArrayList<AxelaAccDelstatus>();
		String strSql = "SELECT NEW AxelaAccDelstatus("
				+ " delstatus.delstatusId,"
				+ " delstatus.delstatusName,"
				+ " delstatus.delstatusRank)";

		sqlJoin += " FROM AxelaAccDelstatus delstatus"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT  delstatus.delstatusId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY  delstatus.delstatusId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaAccDelstatus.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaFinanceComp> findfincompName(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaFinanceComp> listData = new ArrayList<AxelaFinanceComp>();
		String strSql = "SELECT NEW AxelaFinanceComp("
				+ " comp.fincompId,"
				+ " comp.fincompName)";

		sqlJoin += " FROM AxelaFinanceComp comp"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT  comp.fincompId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY  comp.fincompId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaFinanceComp.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaServiceContractType> findAllContractType(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceContractType> listData = new ArrayList<AxelaServiceContractType>();

		String strSql = "SELECT NEW AxelaServiceContractType("
				+ " type.contracttypeId,"
				+ " type.contracttypeName,"
				+ " type.contracttypeEntryId,"
				+ " type.contracttypeEntryDate,"
				+ " type.contracttypeModifiedId ,"
				+ " type.contracttypeModifiedDate)";

		sqlJoin += " FROM AxelaServiceContractType type"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT type.contracttypeId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY type.contracttypeId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaServiceContractType.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaHelpDeskTicketType> findAllTicketType(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaHelpDeskTicketType> listData = new ArrayList<AxelaHelpDeskTicketType>();

		String strSql = "SELECT NEW AxelaHelpDeskTicketType("
				+ " type.tickettypeId,"
				+ " type.tickettypeName,"
				+ " type.tickettypeEntryId,"
				+ " type.tickettypeEntryDate,"
				+ " type.tickettypeModifiedId ,"
				+ " type.tickettypeModifiedDate)";

		sqlJoin += " FROM AxelaHelpDeskTicketType type"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT type.tickettypeId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY type.tickettypeId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaHelpDeskTicketType.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaSalesOpprFollowupDesc> findFolloeupDescription(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaSalesOpprFollowupDesc> listDate = new ArrayList<AxelaSalesOpprFollowupDesc>();
		String strSql = "SELECT NEW AxelaSalesOpprFollowupDesc("
				+ " follow.followupdescId,"
				+ " follow.followupdescName)";

		sqlJoin += " FROM AxelaSalesOpprFollowupDesc follow"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT follow.followupdescId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY follow.followupdescId "
					+ strOrderBy;
			listDate = em.createQuery(strSql, AxelaSalesOpprFollowupDesc.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listDate;
	}

	public List<AxelaInventoryGroup> findItemGroup(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaInventoryGroup> listData = new ArrayList<AxelaInventoryGroup>();
		String strSql = "SELECT New AxelaInventoryGroup("
				+ " group.groupId,"
				+ " group.groupActive, "
				+ " group.groupName )";

		sqlJoin += " FROM AxelaInventoryGroup group "
				+ " WHERE 1=1 "
				+ strSearch;

		// countSql = " SELECT COUNT(DISTINCT  group.groupId ) " + sqlJoin;
		totalCount = "1";// em.createQuery(countSql).getResultList().get(0) + "";
		// if (!totalCount.equals("0")) {
		strSql += sqlJoin
				+ " GROUP BY  group.groupId "
				+ strOrderBy;
		listData = em.createQuery(strSql, AxelaInventoryGroup.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		// }
		em.close();
		return listData;
	}

	public List<AxelaInventoryItemOption> findInventoryItemOption(String strSearch) {
		// SELECT option_group_id FROM " + compdb(comp_id) + "axela_inventory_item_option"
		// // + " WHERE option_group_id = " + group_id + "";
		String sqlJoin = "";
		String countSql = "";
		List<AxelaInventoryItemOption> listData = new ArrayList<AxelaInventoryItemOption>();
		String strSql = " SELECT  "
				+ " option.optionGroupId, "
				+ " option.optionItemId ";

		sqlJoin += " FROM AxelaInventoryItemOption option "
				+ " WHERE 1=1 "
				+ strSearch;

		strSql += sqlJoin;
		listData = em.createQuery(strSql, AxelaInventoryItemOption.class).getResultList();
		em.close();
		return listData;
	}

	public List<AxelaSalesOpprStage> findStage(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		TypedQuery<AxelaSalesOpprStage> typedQuery = null;
		String strSql = "SELECT NEW AxelaSalesOpprStage("
				+ " stage.stageId, "
				+ " stage.stageName,"
				+ " stage.stageProbability )";

		sqlJoin += " FROM AxelaSalesOpprStage stage"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT stage.stageId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY stage.stageId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaSalesOpprStage.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage);
		}
		em.close();
		return typedQuery.getResultList();
	}

	public List<AxelaSalesOpprPriority> findPriorityopprDetail(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		TypedQuery<AxelaSalesOpprPriority> typedQuery = null;
		String strSql = "SELECT NEW AxelaSalesOpprPriority("
				+ " priority.priorityopprId, "
				+ " priority.priorityopprName)";

		sqlJoin += " FROM AxelaSalesOpprPriority priority"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT priority.priorityopprId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY priority.priorityopprId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaSalesOpprPriority.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage);
		}
		em.close();
		return typedQuery.getResultList();
	}

	public List<AxelaSalesOpprBrochure> findBoucherDetail(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaSalesOpprBrochure> listdata = new ArrayList<AxelaSalesOpprBrochure>();
		String strSql = " SELECT NEW AxelaSalesOpprBrochure( "
				+ " COALESCE( brochure.brochureId,'') As brochureId, "
				+ " COALESCE(OCTET_LENGTH( brochure.brochureData), '') AS brochureLengthData, "
				+ "  brochure.brochureTitle, "
				+ "  brochure.brochureBranchId, "
				+ "  brochure.brochureValue, "
				+ "  brochure.brochureItemId, "
				+ "  COALESCE(item.itemModelId,'0') AS itemModelId, "
				+ "  COALESCE(item.itemName,'General') AS itemName, "
				+ "  COALESCE(item.axelaInventoryItemModel.modelName,'General') As modelName, "
				+ "  COALESCE(item.axelaInventoryItemModel.modelName,'') AS modelOrder ) ";

		sqlJoin += " FROM AxelaSalesOpprBrochure brochure "
				+ " LEFT JOIN brochure.axelaInventoryItem item"// on item_id= brochure_item_id"
				+ " LEFT JOIN item.axelaInventoryItemModel "// on model_id= item_model_id"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT brochure.brochureId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY brochure.brochureId "
					+ strOrderBy;
			listdata = em.createQuery(strSql, AxelaSalesOpprBrochure.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listdata;
	}

	public List<AxelaSalesCrmday> findCrmdays(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		TypedQuery<AxelaSalesCrmday> typedQuery = null;
		String strSql = " SELECT NEW AxelaSalesCrmday( "
				+ " crmday.crmdaysId,"
				+ " crmday.crmdaysActive, "
				+ " crmday.crmdaysDaycount, "
				+ " crmday.crmdaysDesc, "
				+ " crmday.crmdaysLostfollowup,"
				+ " crmday.axelaSalesCrmType.crmtypeName "
				+ " crmday.crmdaysExeType ) ";
		// SqlJoin = " FROM " + compdb(comp_id) + "axela_sales_crmdays"
		// // + " INNER JOIN " + compdb(comp_id) + "axela_branch on branch_id = crmdays_branch_id"
		// + " INNER JOIN axela_sales_crm_type ON crmtype_id = crmdays_crmtype_id"
		// + " WHERE 1 =1";

		sqlJoin += " FROM AxelaSalesCrmday crmday "
				+ " INNER JOIN crmday.axelaSalesCrmType "
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT crmday.crmdaysId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY crmday.crmdaysId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaSalesCrmday.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage);
		}
		em.close();
		return typedQuery.getResultList();
	}

	public List<AxelaServiceContractServiceType> findAllContractServiceType(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceContractServiceType> typedQuery = new ArrayList<AxelaServiceContractServiceType>();
		String strSql = "SELECT NEW AxelaServiceContractServiceType("
				+ " type.servicetypeId,"
				+ " type.servicetypeEntryDate,"
				+ " type.servicetypeEntryId,"
				+ " type.servicetypeModifiedDate,"
				+ " type.servicetypeModifiedId,"
				+ " type.servicetypeName)";

		sqlJoin += " FROM AxelaServiceContractServiceType type"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT type.servicetypeId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY type.servicetypeId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaServiceContractServiceType.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return typedQuery;
	}

	public List<AxelaAccWfDoc> findWfDocs(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		TypedQuery<AxelaAccWfDoc> typedQuery = null;
		String strSql = "SELECT NEW AxelaAccWfDoc ( "
				+ " doc.docId, "
				+ " doc.docDaynos, "
				+ " doc.docEffective, "
				+ " doc.docWfTitle )";

		sqlJoin += " FROM AxelaAccWfDoc doc"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT doc.docId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY doc.docId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaAccWfDoc.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage);
		}
		em.close();
		return typedQuery.getResultList();
	}

	public List<AxelaServiceJcCat> findAllJcCategory(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceJcCat> typedQuery = new ArrayList<AxelaServiceJcCat>();

		String strSql = "SELECT NEW AxelaServiceJcCat("
				+ " jccat.jccatId,"
				+ " jccat.jccatEntryDate,"
				+ " jccat.jccatEntryId,"
				+ " jccat.jccatModifiedDate,"
				+ " jccat.jccatModifiedId,"
				+ " jccat.jccatName)";

		sqlJoin += " FROM AxelaServiceJcCat jccat"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT jccat.jccatId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY jccat.jccatId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaServiceJcCat.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return typedQuery;
	}

	public List<AxelaServiceJcType> findAllJcType(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceJcType> typedQuery = new ArrayList<AxelaServiceJcType>();

		String strSql = "SELECT NEW AxelaServiceJcType("
				+ " type.jctypeId,"
				+ " type.jctypeEntryDate,"
				+ " type.jctypeEntryId,"
				+ " type.jctypeModifiedDate,"
				+ " type.jctypeModifiedId,"
				+ " type.jctypeName)";

		sqlJoin += " FROM AxelaServiceJcType type"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT type.jctypeId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY type.jctypeId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaServiceJcType.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return typedQuery;
	}

	public List<AxelaHelpDeskTicketCat> findAllTicketCategory(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaHelpDeskTicketCat> typedQuery = new ArrayList<AxelaHelpDeskTicketCat>();

		String strSql = "SELECT NEW AxelaHelpDeskTicketCat("
				+ " cat.ticketcatId,"
				+ " cat.ticketcatEntryDate,"
				+ " cat.ticketcatEntryId,"
				+ " cat.ticketcatModifiedDate,"
				+ " cat.ticketcatModifiedId,"
				+ " cat.ticketcatName)";

		sqlJoin += " FROM AxelaHelpDeskTicketCat cat"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT cat.ticketcatId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY cat.ticketcatId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaHelpDeskTicketCat.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return typedQuery;
	}

	public int updatePriority(int delstatusRank, int tempRank, String entityName, String fieldName) {
		String sqlJoin = "";
		String countSql = "";
		Query query = null;
		String strSql = " UPDATE "
				+ entityName
				+ " SET "
				+ fieldName
				+ " = "
				+ delstatusRank +
				" WHERE " +
				fieldName
				+ " = "
				+ tempRank;

		query = em.createQuery(strSql);
		int updateCount = query.executeUpdate();
		return updateCount;
	}

	public int updatePriorityById(int delstatusRank, int tempRank, String IdField, int priorityopprId, String entityName, String fieldName) {
		String sqlJoin = "";
		String countSql = "";
		Query query = null;
		String strSql = " UPDATE "
				+ entityName
				+ " SET "
				+ fieldName
				+ " = "
				+ tempRank
				+ " WHERE "
				+ fieldName
				+ " = "
				+ delstatusRank
				+ " AND "
				+ IdField
				+ " = "
				+ priorityopprId;

		query = em.createQuery(strSql);
		int updateCount = query.executeUpdate();
		return updateCount;
	}

	// access rights impl
	public List<AxelaModuleAccess> findAllAccessRights(int empId, String modSearch) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaModuleAccess> list = new ArrayList<AxelaModuleAccess>();

		String strSql = "SELECT NEW AxelaModuleAccess("
				+ " moduleaccess.accessId,"
				+ " moduleaccess.accessModuleId,"
				+ " module.moduleName,"
				+ " moduleaccess.accessRank,"
				+ " moduleaccess.accessName,"
				+ " COALESCE(empAccess.empaccessAccessId,0),"
				+ " businesstype.businesstypeName)";

		strSql += " FROM AxelaModuleAccess moduleaccess"
				+ " JOIN moduleaccess.axelaModule module"
				+ " LEFT JOIN moduleaccess.axelaEmpAccess empAccess ON (empAccess.empaccessEmpId=" + empId + ")"
				+ " ,AxelaComp comp"
				+ " LEFT JOIN comp.axelaBusinessType businesstype"
				+ " WHERE 1=1"
				+ modSearch
				+ " GROUP BY moduleaccess.accessId"
				+ " ORDER BY module.moduleRank, moduleaccess.accessRank, moduleaccess.accessId";

		System.out.println("strSql==============" + strSql);

		list = em.createQuery(strSql, AxelaModuleAccess.class).getResultList();
		em.close();
		return list;
	}

	public Object[] findModulesAccess(String strSearch) {
		Object[] typedQuery = null;

		String strSql = "SELECT " + strSearch + " FROM AxelaComp comp";

		typedQuery = em.createQuery(strSql, Object[].class).getSingleResult();
		em.close();
		return typedQuery;
	}

	// executive landing page
	public List<Object[]> findAllExecutiveStatus1(String strSearch) {
		String sqlJoin = "";
		String countSql = "";
		List<Object[]> typedQuery = null;

		String strSql = "SELECT COUNT(DISTINCT empBranch.empId),"
				+ " COUNT(DISTINCT CASE WHEN emp.empActive = 1 THEN emp.empId END),"
				+ " COUNT(DISTINCT CASE WHEN emp.empActive = 0 then emp.empId END)";

		strSql += " FROM AxelaEmp emp"
				+ " LEFT JOIN emp.axelaEmpBranch empBranch"
				+ " LEFT JOIN empBranch.axelaBranch branch"
				+ " WHERE 1=1"
				+ " AND emp.empBranchId=0"
				+ " AND empBranch.empId!=1"
				+ strSearch;
		System.out.println("strSql==============" + strSql);
		typedQuery = em.createQuery(strSql, Object[].class).getResultList();
		em.close();
		return typedQuery;
	}
	public List<Object[]> findAllExecutiveStatus2(String strSearch) {
		String sqlJoin = "";
		String countSql = "";
		List<Object[]> typedQuery = null;

		String strSql = "SELECT COUNT(DISTINCT emp.empId),"
				+ " SUM(CASE WHEN emp.empActive = 1 THEN 1 ELSE 0 END),"
				+ " SUM(case when emp.empActive = 0 THEN 1 ELSE 0 END)";

		strSql += " FROM AxelaEmp emp"
				+ " JOIN emp.axelaBranch branch"
				+ " WHERE 1=1"
				+ " AND emp.empBranchId!=0"
				+ "AND emp.empId!=1"
				+ strSearch;
		System.out.println("strSql==============" + strSql);
		typedQuery = em.createQuery(strSql, Object[].class).getResultList();
		em.close();
		return typedQuery;
	}

	// executive landing page
	public List<Object[]> findAllExecutiveSummary1() {
		String sqlJoin = "";
		String countSql = "";
		List<Object[]> typedQuery = null;

		String strSql = "SELECT emp.empId,"
				+ " CONCAT(emp.empName,' (',emp.empRefNo,')') AS empName,"
				+ " 'All Branches' AS branchName,"
				+ " 1 AS rank";

		strSql += " FROM AxelaEmp emp"
				+ " WHERE 1=1"
				+ " AND emp.empActive=0"
				+ " AND emp.empId!=1"
				+ " AND emp.empAllBranches=1";
		System.out.println("strSql==============" + strSql);
		typedQuery = em.createQuery(strSql, Object[].class).getResultList();
		em.close();
		return typedQuery;
	}

	public List<Object[]> findAllExecutiveSummary2(String strSearch) {
		String sqlJoin = "";
		String countSql = "";
		List<Object[]> typedQuery = null;

		String strSql =
				"SELECT COALESCE(emp.empId,0),"
						+ " CONCAT(emp.empName,' (',emp.empRefNo,')') AS empName,"
						+ " COALESCE('Head Office','') AS branchName,"
						+ " 2 AS rank";

		strSql += " FROM AxelaEmp emp"
				+ " JOIN emp.axelaEmpBranch empBranch"
				+ " JOIN empBranch.axelaBranch branch"
				+ " WHERE 1=1"
				+ " AND emp.empBranchId=0"
				+ " AND empBranch.empId!=1"
				+ " AND emp.empId=1"
				+ strSearch;
		System.out.println("strSql==============" + strSql);
		typedQuery = em.createQuery(strSql, Object[].class).getResultList();
		em.close();
		return typedQuery;
	}

	public List<Object[]> findAllExecutiveSummary3(String strSearch) {
		String sqlJoin = "";
		String countSql = "";
		List<Object[]> typedQuery = null;

		String strSql =
				"SELECT emp.empId,"
						+ " CONCAT(emp.empName,' (',emp.empRefNo,')') AS empName,"
						+ " branch.branchName,"
						+ " 3 AS rank";

		strSql += " FROM AxelaEmp emp"
				+ " JOIN emp.axelaBranch branch"
				+ " WHERE 1=1"
				+ " AND emp.empBranchId!=0"
				+ " AND emp.empId!=1"
				+ " AND emp.empActive=1"
				+ strSearch;
		System.out.println("strSql==============" + strSql);
		typedQuery = em.createQuery(strSql, Object[].class).getResultList();
		em.close();
		return typedQuery;
	}

	public List<Object[]> findAllBranchType(String branchAccess) {
		String sqlJoin = "";
		String countSql = "";
		List<Object[]> listData = new ArrayList<Object[]>();

		String strSql =
				"SELECT branchType.branchtypeId,"
						+ " branchType.branchtypeName";

		strSql += " FROM AxelaBranchType branchType"
				+ " JOIN branchType.axelaBranch branch"
				+ " WHERE 1=1"
				+ " AND branch.branchActive = 1"
				+ branchAccess
				+ " GROUP BY branchType.branchtypeId"
				+ " ORDER by branchType.branchtypeName";
		System.out.println("strSql==============" + strSql);
		listData = em.createQuery(strSql, Object[].class).getResultList();
		em.close();
		return listData;
	}

	public List<Object[]> populateBranches(String strSearch) {
		String sqlJoin = "";
		String countSql = "";
		List<Object[]> listData = new ArrayList<Object[]>();

		String strSql =
				"SELECT branch.branchId,"
						+ " branch.branchName";

		strSql += " FROM AxelaBranch branch"
				+ " WHERE 1=1"
				+ " AND branch.branchActive = 1"
				+ strSearch
				+ " GROUP BY branch.branchId "
				+ " ORDER BY branch.branchId, branch.branchName ";
		System.out.println("strSql==============" + strSql);
		listData = em.createQuery(strSql, Object[].class).getResultList();
		em.close();
		return listData;

	}

	public List<Object[]> findByIdAndName(String branchIds) {
		String query = "SELECT branch.branchId,branch.branchName,branch.branchCode"
				+ " FROM AxelaBranch branch"
				+ " WHERE branch.branchId IN (" + branchIds + ")";
		List list = em.createQuery(query).getResultList();
		return list;
	}

	public List<Object[]> findAllEmpByIdAndName(String exeIds) {

		String query = "SELECT emp.empId,emp.empName,emp.empRefNo"
				+ " FROM AxelaEmp emp"
				+ " WHERE emp.empActive = '1'"
				+ " AND emp.empId IN (" + exeIds + ")";
		List list = em.createQuery(query).getResultList();
		return list;
	}

	// executive summary
	public AxelaEmp findExecutiveSummary(String empId) {
		String sqlJoin = "";
		String countSql = "";
		AxelaEmp listData = new AxelaEmp();
		System.out.println("33333333333333333333333333333");
		String strSql = "SELECT NEW AxelaEmp("
				+ " emp.empId,"
				+ " emp.empName,"
				+ " emp.empRefNo,"
				+ " emp.empSex,"
				+ " emp.empDob,"
				+ " emp.empMobile1,"
				+ " emp.empEmail1,"
				+ " emp.empStatus,"
				+ " emp.empAddress,"
				+ " emp.empPin,"
				+ " emp.empMarried,"
				+ " jobtitle.jobtitleDesc,"
				+ " city.cityName,"
				+ " state.stateName,"
				+ " country.countryName)";

		strSql += " FROM AxelaEmp emp"
				+ " JOIN emp.axelaJobtitle jobtitle"
				+ " JOIN emp.axelaCity city"
				+ " JOIN city.axelaState state"
				+ " JOIN state.axelaCountry country"
				+ " WHERE 1=1"
				+ " AND emp.empId=" + empId;

		System.out.println("44444444444");
		System.out.println("strSql==============" + strSql);
		listData = em.createQuery(strSql, AxelaEmp.class).getSingleResult();
		em.close();
		return listData;

	}

	public List<Object[]> executiveSummaryReportingExes(String empId) {
		String sqlJoin = "";
		String countSql = "";
		List<Object[]> listData = new ArrayList<Object[]>();
		String strSql = "SELECT ( SELECT"
				+ " concat(emp.empName,' (',"
				+ " emp.empRefNo, ')')"
				+ " From AxelaEmp "
				+ " WHERE emp.empId=empExe.empexeId),"
				+ " empExe.empexeId,"
				+ " empExe.empexeEmpId"
				+ " FROM AxelaEmp emp"
				+ " JOIN emp.axelaEmpExe empExe"
				+ " WHERE 1=1"
				+ " AND emp.empId=" + empId;
		System.out.println("strSql==============" + strSql);
		listData = em.createQuery(strSql, Object[].class).getResultList();
		em.close();
		return listData;

	}

}
