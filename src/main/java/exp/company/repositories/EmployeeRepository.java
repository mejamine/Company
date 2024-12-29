package exp.company.repositories;
import exp.company.entities.Employee;
import exp.company.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.team = :team")
    public List<Employee> getEmployeeByTeam(@Param("team") Team team);
}
