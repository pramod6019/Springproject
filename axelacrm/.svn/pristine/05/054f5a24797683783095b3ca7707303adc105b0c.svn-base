package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaComp;

public interface CompRepository extends JpaRepository<AxelaComp, Integer> {

	AxelaComp findByCompId(int compId);

	@Query("SELECT "
			+ "a.compName,"
			+ "a.compModuleActivity,"
			+ "a.compModuleCustomer,"
			+ "a.compModulePm,"
			+ "a.compModuleMarketing,"
			+ "a.compModuleSales,"
			+ "a.compModuleService,"
			+ "a.compModulePos,"
			+ "a.compModuleInventory,"
			+ "a.compModuleInvoice,"
			+ "a.compModuleAccounting,"
			+ "a.compModuleProduction,"
			+ "a.compModuleAsset,"
			+ "a.compModuleHcm,"
			+ "a.compModulePayroll,"
			+ "a.compModuleSocial,"
			+ "a.compModuleWebsite,"
			+ "a.compModuleProductcatalogue,"
			+ "a.compModulePortal,"
			+ "a.compEmailEnable,"
			+ "a.compSmsEnable,"
			+ "a.compModuleHelpdesk,"
			+ "a.compBranchCount,"
			+ "a.compFranchiseeCount"
			+ " FROM AxelaComp a"
			+ " WHERE a.compId=:compId")
	public List<Object[]> findAllModule(@Param("compId") int compId);

	@Query("SELECT "
			+ "b.compBranchCount,"
			+ " (SELECT COUNT(a.branchId)"
			+ " FROM AxelaBranch a"
			+ " WHERE a.branchActive = '1') AS activeBranchCount"
			+ " FROM AxelaComp b"
			+ " GROUP BY b.compId")
	public List<Object[]> findByCompBranchCount();

	@Query("SELECT "
			+ " compFranchiseeCount"
			+ " FROM AxelaComp comp"
			+ " GROUP BY comp.compId")
	public int findByFranchiseeCount();

	@Query("SELECT "
			+ " compBranchCount"
			+ " FROM AxelaComp comp")
	public int findByBranchCount();

	// StrSql = "SELECT comp_businesstype_id"
	// + " from " + compdb(comp_id) + "axela_comp";
	@Query(" SELECT comp.compBusinesstypeId "
			+ " from "
			+ " AxelaComp comp")
	List<Integer> findCompanyTypeId();

}
