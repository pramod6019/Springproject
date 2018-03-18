package axela.portal.model;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<AxelaTax, Integer> {
	@Query("SELECT a.taxName FROM AxelaTax a WHERE a.taxName=:taxName")
	public List<AxelaTax> findByTaxName(@Param("taxName") String taxName);

	@Query("SELECT taxId, taxName"
			+ " FROM AxelaTax"
			+ " GROUP BY taxId"
			+ " ORDER BY taxName")
	public List<Object[]> findByTaxIdTaxName();

	@Query("SELECT count(a.taxValue)"
			+ " FROM AxelaTax a"
			+ " WHERE a.taxId =:contractTaxId")
	public String findTaxValue(@Param("contractTaxId") int contractTaxId);

	@Query("SELECT tax.taxId,tax.taxName FROM AxelaTax tax WHERE tax.taxId=:taxId AND tax.taxName=:taxName")
	public List<AxelaTax> findTaxName(@Param("taxId") int taxId, @Param("taxName") String taxName);

	public AxelaTax findByTaxId(int parseInt);

}
