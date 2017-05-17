package it.htm.dao;

import it.htm.entity.Task;

import java.util.List;

/**
 * Created by vincenzo on 27/11/16.
 */
public interface TaskDao {
    public List<Task> retrieveTaskBySlicingId(int id);
    public List<Task> retrieveTasks();
    public Task getTaskById(int id);
    public void updateState(Task t);
}
