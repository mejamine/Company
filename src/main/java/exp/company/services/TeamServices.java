package exp.company.services;
import exp.company.entities.Manager;
import exp.company.entities.Team;

import java.util.List;

public interface TeamServices {
    public void addTeam(Team team);
    public void removeTeam(Long id);
    public Team getTeam(Long id);
    public List<Team> getAllTeams();
    public void updateTeam(Team team);
    public List<Manager> getManagers(Long id);
}
