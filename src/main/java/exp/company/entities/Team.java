package exp.company.entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long team_id;

    @Column(unique=true)
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Employee> employees;

    @ManyToMany(mappedBy = "teams")
    private Set<Manager> managers = new HashSet<>();

    public Long getTeam_id() {
        return team_id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Set<Manager> getManagers() {
        return managers;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setManagers(Set<Manager> managers) {
        this.managers = managers;
    }
}
