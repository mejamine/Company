package exp.company.services;
import exp.company.entities.Task;
import java.util.List;

public interface TaskServices {
    public void addTask(Task task);
    public void removeTask(Long id);
    public Task getTask(Long id);
    public List<Task> getAllTasks();
    public void updateTask(Task task);
}
