package axela.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesOpprDoc;

@Repository
public interface SalesOpprDocRepository extends JpaRepository<AxelaSalesOpprDoc, Integer> {

	@Query(value = "SELECT doc FROM AxelaSalesOpprDoc doc WHERE  doc.docOpprId=:opprId")
	AxelaSalesOpprDoc findDoc(@Param("opprId") int opprId);

	@Query(value = "SELECT COUNT(doc) FROM AxelaSalesOpprDoc doc WHERE  doc.docOpprId=:opprId")
	int findDocCount(@Param("opprId") int opprId);

}
