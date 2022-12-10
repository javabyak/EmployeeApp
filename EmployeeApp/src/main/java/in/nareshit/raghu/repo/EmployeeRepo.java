package in.nareshit.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.raghu.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
