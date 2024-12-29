package exp.company.controllers;
import exp.company.entities.Employee;
import exp.company.entities.Team;
import exp.company.repositories.EmployeeRepository;
import exp.company.services.EmployeeServices;
import exp.company.services.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamServices teamServices;

    @Autowired
    private EmployeeServices employeeServices;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public String getAllTeamss(Model m) {
        List<Team> teams = teamServices.getAllTeams();
        m.addAttribute("teams", teams);
        return "team/index";
    }
    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable Long id, Model m) {
        List<Employee> employees = employeeServices.getEmployeeByTeam(teamServices.getTeam(id));
        employeeRepository.deleteAll(employees);
        teamServices.removeTeam(id);
        return "redirect:/team/all";
    }
    @PostMapping("/save")
    public String saveTeam(@ModelAttribute Team team, Model m) {
        try {
            teamServices.addTeam(team);
            return "redirect:/team/all";
        } catch (DataIntegrityViolationException e) {
            return "team/add";
        }
    }
    @GetMapping("/update/{id}")
    public String updateTeam(@PathVariable Long id, Model m) {
        m.addAttribute("team",teamServices.getTeam(id));
        return "team/add";
    }
    @GetMapping("/add")
    public String formulaire(Model m) {
        m.addAttribute("team",new Team());
        return "team/add";
    }
    @GetMapping("/view/{id}")
    public String viewTeam(@PathVariable Long id, Model m ) {
        m.addAttribute("team",teamServices.getTeam(id));
        m.addAttribute("employees",employeeServices.getEmployeeByTeam(teamServices.getTeam(id)));
        m.addAttribute("managers",teamServices.getManagers(id));
        return "team/view";
    }
}
