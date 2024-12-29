package exp.company.services;
import exp.company.entities.Task;
import exp.company.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServicesImplementations implements TaskServices {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void removeTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.save(task);
    }
}
