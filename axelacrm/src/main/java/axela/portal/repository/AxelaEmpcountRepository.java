package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import axela.portal.model.AxelaEmpcount;

public interface AxelaEmpcountRepository extends JpaRepository<AxelaEmpcount, Long> {

	List<AxelaEmpcount> findAll();
}
