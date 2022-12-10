package in.nareshit.raghu.service;

import java.util.List;

import in.nareshit.raghu.entity.Employee;

public interface IEmployeeService {
    public Integer registerEmp(Employee emp);
    public List<Employee> fetchEmployeeData();
    public void removeEmpById(Integer id);
    public Employee getEmpdataBYId(Integer id);
    public String UpdateEmpdata(Employee emp);
}
