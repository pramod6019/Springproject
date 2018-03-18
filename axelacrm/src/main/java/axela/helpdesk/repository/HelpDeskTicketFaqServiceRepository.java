package axela.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import axela.helpdesk.model.AxelaHelpDeskTicketFaqService;
import axela.portal.model.AxelaBranch;

public interface HelpDeskTicketFaqServiceRepository extends JpaRepository<AxelaHelpDeskTicketFaqService, Integer> {

	public interface CatagoriesFilterRepository {
		// public List<AxelaHelpDeskTicketFaqService> findAllCatagories(String branchAccess);
		public List<AxelaBranch> findAllByBranch(String branchAccess);

	}

}
