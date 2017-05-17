package it.htm.services;

import it.htm.dao.TaskDaoImpl;
import it.htm.dto.SkillDTO;
import it.htm.dto.TaskDTO;
import it.htm.entity.Skill;
import it.htm.entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class LeafController {


    @RequestMapping(value="/beleaf/tasks/all", method= RequestMethod.GET)
    public ResponseEntity<ArrayList<TaskDTO>> retrieveTasks(){
        TaskDaoImpl taskDao = new TaskDaoImpl();
        ArrayList<Task> tasks = (ArrayList<Task>) taskDao.retrieveTasks();
        ArrayList<TaskDTO> taskDTOs = new ArrayList<>();

        for(Task t : tasks){
            TaskDTO tdto = new TaskDTO();
            if(!t.isState()) {

                tdto.setId(t.getTaskId());
                tdto.setRetribution(t.getRetribution());
                tdto.setDescription(t.getDescription());
                ArrayList<SkillDTO>  lsdto = new ArrayList<>();
                for (Skill s : t.getSkills()){
                    SkillDTO skdto = new SkillDTO();
                    skdto.setName(s.getName());
                    lsdto.add(skdto);
                }
                tdto.setSkills(lsdto);

            }
            taskDTOs.add(tdto);

        }
        return new ResponseEntity<ArrayList<TaskDTO>>(taskDTOs, HttpStatus.OK);
    }

    @RequestMapping(value= "beleaf/task/completed/{id_task}" , method= RequestMethod.POST)
    public void UpdateTaskState(@PathVariable(value="id_task") int id_task){
        TaskDaoImpl taskDao = new TaskDaoImpl();
        Task t = taskDao.getTaskById(id_task);
        t.setState(true);
        taskDao.updateState(t);

    }
}
