package exp.company.services;

import exp.company.entities.Employee;
import exp.company.entities.Team;

import java.util.List;

public interface EmployeeServices {
    public void addEmployee(Employee employee);
    public void removeEmployee(Long id);
    public Employee getEmployee(Long id);
    public List<Employee> getAllEmployees();
    public void updateEmployee(Employee employee);
    public List<Employee> getEmployeeByTeam(Team team);
}
