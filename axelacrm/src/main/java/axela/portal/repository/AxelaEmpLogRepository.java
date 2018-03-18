package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import axela.portal.model.AxelaEmpUser;

public interface AxelaEmpLogRepository extends JpaRepository<AxelaEmpUser, Long> {

}
