package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceJcDoc;
@Repository
public interface ServiceJcDocRepository extends JpaRepository<AxelaServiceJcDoc, Integer> {

	@Query("SELECT serviceJcDoc.docId,"
			+ " COALESCE(OCTET_LENGTH(serviceJcDoc.docData), 0) AS docData,"
			+ " serviceJcDoc.docValue,"
			+ " serviceJcDoc.docTitle,"
			+ " serviceJcDoc.docRemarks "
			+ " FROM AxelaServiceJcDoc serviceJcDoc "
			+ " WHERE serviceJcDoc.docJcId =:jcId ")
	List<Object[]> findJobCardDocs(@Param("jcId") int jcId);

}
