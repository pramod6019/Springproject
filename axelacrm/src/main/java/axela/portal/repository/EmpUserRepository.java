package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaEmpUser;

@Repository
public interface EmpUserRepository extends JpaRepository<AxelaEmpUser, Integer> {

}
