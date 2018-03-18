package axela.customer.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.customer.model.AxelaCustomerContact;

@Repository
public interface CustomerContactReposiitory extends JpaRepository<AxelaCustomerContact, Integer> {

	@Query("SELECT"
			+ " COUNT(a.contactCustomerId)"
			+ " FROM AxelaCustomerContact a"
			+ " WHERE a.contactCustomerId=:customerId")
	public int findById(@Param("customerId") int customerId);

	@Transactional
	@Modifying
	@Query("DELETE"
			+ " FROM AxelaCustomerContact a"
			+ " WHERE a.contactCustomerId=:customerId")
	public void deleteById(@Param("customerId") int customerId);

	@Query("SELECT"
			+ " a"
			+ " FROM AxelaCustomerContact a"
			+ " WHERE a.contactId=:contactId")
	public AxelaCustomerContact findByContactId(@Param("contactId") int contactId);

	@Query("SELECT a FROM AxelaCustomerContact a"
			+ " WHERE a.contactId=:contactId")
	public AxelaCustomerContact findByCustomerContactId(@Param("contactId") int contactId);

	@Query("SELECT a FROM AxelaCustomerContact a"
			+ " WHERE a.contactCustomerId=:contactCustomerId")
	public List<AxelaCustomerContact> findContact(@Param("contactCustomerId") int contactCustomerId);

	@Query("SELECT"
			+ " a.contactId,"
			+ " CONCAT(a.axelaTitle.titleDesc,' ',a.contactFname,' ',a.contactLname) as contactName,"
			+ " a.contactEmail1,"
			+ " a.contactEmail2,"
			+ " a.contactMobile1,"
			+ " a.contactMobile2,"
			+ " a.contactAddress"
			+ " FROM AxelaCustomerContact a"
			+ " INNER JOIN a.axelaHelpDeskTicket b"
			+ " INNER JOIN b.axelaHelpDeskTicketQueue"
			+ " INNER JOIN b.axelaHelpDeskTicketStatus"
			+ " INNER JOIN b.axelaHelpDeskTicketPriority"
			+ " INNER JOIN b.axelaEmp"
			+ " INNER JOIN a.axelaTitle"
			+ " WHERE b.ticketId=:ticketId")
	public List<Object[]> findByTicket(@Param("ticketId") int ticketId);

	@Query("SELECT"
			+ " a.contactId"
			+ " FROM AxelaCustomerContact a"
			+ " WHERE a.contactPhone1=:contactPhone1 OR a.contactPhone2=:contactPhone1")
	public String[] findContactPhone(@Param("contactPhone1") String contactPhone1);

	@Query("SELECT"
			+ " a.contactId"
			+ " FROM AxelaCustomerContact a"
			+ " WHERE a.contactEmail1=:contactEmail1 OR a.contactEmail2=:contactEmail1")
	public String[] findContactEmail(@Param("contactEmail1") String contactEmail1);

	@Query("SELECT a.axelaCustomers.customerId,"
			+ " a.contactId,"
			+ " a.axelaCustomers.customerName,"
			+ " CONCAT(a.axelaTitle.titleDesc, ' ', a.contactFname, ' ', a.contactLname) as contactName,"
			+ " a.contactEmail1,"
			+ " a.contactMobile1 "
			+ " FROM AxelaCustomerContact a"
			+ " INNER JOIN a.axelaTitle "
			+ " INNER JOIN a.axelaCustomers"
			+ " where a.contactId =:contractContactId")
	public List<Object[]> populateByContactDetails(@Param("contractContactId") int contractContactId);

	@Query("SELECT"
			+ " contact.contactId,"
			+ " CONCAT(contact.axelaTitle.titleDesc, ' ', contact.contactFname, ' ', contact.contactLname) AS contactName"
			+ " FROM AxelaCustomerContact contact"
			+ " INNER JOIN contact.axelaTitle "
			+ " where contact.contactCustomerId=:contractCustomerId")
	public List<Object[]> findByContactIdAndName(@Param("contractCustomerId") int contractCustomerId);

}