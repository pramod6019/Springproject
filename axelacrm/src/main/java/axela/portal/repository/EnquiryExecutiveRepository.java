package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaEmp;
@Repository
public interface EnquiryExecutiveRepository extends JpaRepository<AxelaEmp, Integer> {

	//List<AxelaEmp> findByEmpBranchIdGroupByEmpIdOrderByEmpName(int parseInt);

	List<AxelaEmp> findByEmpBranchIdOrderByEmpName(int parseInt);

}
