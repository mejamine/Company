package exp.company.services;
import exp.company.entities.Manager;
import java.util.List;

public interface ManagerServices {
    public void addManager(Manager manager);
    public void removeManager(Long id);
    public Manager getManager(Long id);
    public List<Manager> getAllManagers();
    public void updateManager(Manager manager);
}
