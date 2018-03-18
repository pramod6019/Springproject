package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaTitle;
@Repository
public interface AxelaTitleRepository extends JpaRepository<AxelaTitle, Integer>
{
	public List<AxelaTitle> findAll();

	public List<AxelaTitle> findByTitleId(int parseInt);
}
