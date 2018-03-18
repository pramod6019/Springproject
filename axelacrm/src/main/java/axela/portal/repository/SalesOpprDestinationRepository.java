package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaSalesOpprDestination;

@Repository
public interface SalesOpprDestinationRepository extends JpaRepository<AxelaSalesOpprDestination, Integer> {
	public List<AxelaSalesOpprDestination> findAll();

	public AxelaSalesOpprDestination findByDestinationId(int parseInt);

	public List<AxelaSalesOpprDestination> findByDestinationName(String destinationName);

	@Query("SELECT destination.destinationId,destination.destinationName FROM AxelaSalesOpprDestination destination WHERE 1=1 AND destination.destinationId !=:destinationId AND destination.destinationName=:destinationName")
	public List<AxelaSalesOpprDestination> findDestinationName(@Param("destinationId") int destinationId, @Param("destinationName") String destinationName);

}
