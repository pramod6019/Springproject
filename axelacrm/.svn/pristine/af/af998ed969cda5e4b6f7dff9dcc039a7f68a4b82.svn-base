package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaBranch;
@Repository
public interface EnquiryBranchRepository extends JpaRepository<AxelaBranch, Integer> {



	List<AxelaBranch> findByBranchActiveOrderByBranchName(int parseInt);

}
