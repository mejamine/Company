package exp.company.repositories;
import exp.company.entities.Manager;
import exp.company.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT m FROM Manager m JOIN m.teams g WHERE g.team_id = :id")
    List<Manager> findManagersByTeamId(@Param("id") Long id);
}
