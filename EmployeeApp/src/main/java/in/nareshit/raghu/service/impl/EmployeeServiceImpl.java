package in.nareshit.raghu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.repo.EmployeeRepo;
import in.nareshit.raghu.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepo repo;

	@Override
	public Integer registerEmp(Employee emp) {

		return repo.save(emp).getId();
	}

	@Override
	public List<Employee> fetchEmployeeData() {
	
		return repo.findAll();
	}
	@Override
	public void removeEmpById(Integer id) {
	    repo.deleteById(id);
		
	}

	@Override
	public Employee getEmpdataBYId(Integer id) {
		   Optional<Employee> emp=repo.findById(id);
		   if(emp.isPresent())
			   return emp.get();
		   else {
			   //TODO: exception throws
			   return null;
		   }
	}
	@Override
	public String UpdateEmpdata(Employee emp) {
		    
		     return  repo.save(emp).getId()+":: edited sucessefully";
		
	}
}
