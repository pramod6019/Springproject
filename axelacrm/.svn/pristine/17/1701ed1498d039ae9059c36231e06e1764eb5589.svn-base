package axela.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicketHistory;
@Repository
public interface HelpDeskTickethistoryRepository extends JpaRepository<AxelaHelpDeskTicketHistory, Integer> {

	List<AxelaHelpDeskTicketHistory> findByhistoryTicketId(int historyTicketId);

}
