package axela.portal.repository;

import java.util.List;

import axela.portal.model.AxelaEmp;
import axela.portal.model.AxelaEmpExe;

public interface Session_Repository {
	public AxelaEmp findId(String emp_id, String comp_id);
	public AxelaEmpExe findExeId(String emp_id, String comp_id);
	public List<Object[]> findAll(String emp_id, String comp_id);

}
