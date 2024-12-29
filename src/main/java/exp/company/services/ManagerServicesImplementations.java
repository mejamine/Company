package exp.company.services;
import exp.company.entities.Manager;
import exp.company.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ManagerServicesImplementations implements ManagerServices {

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public void addManager(Manager manager) {
        managerRepository.save(manager);
    }

    @Override
    public void removeManager(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    public Manager getManager(Long id) {
        return managerRepository.findById(id).get();
    }

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public void updateManager(Manager manager) {
        managerRepository.save(manager);
    }
}
