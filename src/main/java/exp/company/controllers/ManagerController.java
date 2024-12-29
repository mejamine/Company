package exp.company.controllers;
import exp.company.entities.Employee;
import exp.company.entities.Manager;
import exp.company.entities.Team;
import exp.company.services.ManagerServices;
import exp.company.services.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerServices managerServices;

    @Autowired
    private TeamServices teamServices;

    @GetMapping("/add/{id}")
    public String addManager(@PathVariable Long id, Model m) {
        m.addAttribute("team" ,teamServices.getTeam(id));
        m.addAttribute("manager",new Manager());
        return "manager/add";
    }

    @PostMapping("/save/{id}")
    public String save(@ModelAttribute Manager manager, @PathVariable Long id, Model model) {
        try {
            Team team = teamServices.getTeam(id);
            if (team == null) {
                return "team/add" + id;
            }
            Manager existingManager = null;
            if (manager.getManager_id() != null) {
                existingManager = managerServices.getManager(manager.getManager_id());
            }
            if (existingManager != null) {
                existingManager.setName(manager.getName());
                existingManager.setLast_name(manager.getLast_name());
                managerServices.addManager(existingManager);
            } else {
                List<Employee> employees = team.getEmployees();
                manager.getTeams().add(team);
                team.getManagers().add(manager);
                for (Employee employee : employees) {
                    manager.getEmployees().add(employee);
                    employee.getManagers().add(manager);
                }
                managerServices.addManager(manager);
            }
            return "redirect:/team/view/" + id;
        } catch (DataIntegrityViolationException e) {
            return "manager/add" + id;
        }
    }

    @GetMapping("/delete/{id}/{eid}")
    public String deleteManager(@PathVariable Long id,@PathVariable Long eid, Model m) {
        managerServices.removeManager(eid);
        return "redirect:/team/view/"+id;
    }
    @GetMapping("/update/{id}/{eid}")
    public String updateManager(@PathVariable Long id,@PathVariable Long eid, Model m) {
        m.addAttribute("team" ,teamServices.getTeam(id));
        m.addAttribute("manager",managerServices.getManager(eid));
        return "manager/add";
    }
}
