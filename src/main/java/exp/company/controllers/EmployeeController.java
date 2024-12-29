package exp.company.controllers;

import exp.company.entities.Employee;
import exp.company.entities.Team;
import exp.company.services.EmployeeServices;
import exp.company.services.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeService;

    @Autowired
    private TeamServices teamService;

    @GetMapping("/add/{id}")
    public String formulaire(@PathVariable Long id, Model m) {
        m.addAttribute("employee", new Employee());
        m.addAttribute("team" ,teamService.getTeam(id));
        return   "/employee/add";
    }

    @PostMapping("/save/{id}")
    public String save(@ModelAttribute Employee employee, @PathVariable Long id, Model model) {
        try{
            Team team = teamService.getTeam(id);
            employee.setTeam(team);
            employeeService.addEmployee(employee);
            return "redirect:/team/view/"+id;
        }catch(DataIntegrityViolationException e) {
            return "redirect:/employee/add/"+id;
        }

    }
    @GetMapping("/update/{id}/{eid}")
    public String updateEmployee(@PathVariable Long id,@PathVariable Long eid, Model m) {
        m.addAttribute("team" ,teamService.getTeam(id));
        m.addAttribute("employee",employeeService.getEmployee(eid));
        return "employee/add";
    }
    @GetMapping("/delete/{id}/{eid}")
    public String deleteEmployee(@PathVariable Long id,@PathVariable Long eid, Model m) {
        employeeService.removeEmployee(eid);
        return "redirect:/team/view/"+id;
    }
}
