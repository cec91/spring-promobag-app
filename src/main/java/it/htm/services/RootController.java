package it.htm.services;

import it.htm.dao.*;
import it.htm.dto.*;
import it.htm.entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RootController {

    @RequestMapping(value = "/beleaf/saveproject/", method = RequestMethod.POST)

    public ResponseEntity<BasicDTO> saveProject(@RequestBody ProjectDTO projectDTO) {
        ProjectDaoImpl projectDao = new ProjectDaoImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.getUserByName(projectDTO.getUsers().get(0).getUsername());
        projectDao.saveProject(user, projectDTO.getName(), projectDTO.getDescription(), projectDTO.getBudget());
        BasicDTO basicDTO = new BasicDTO();
        basicDTO.setMessage("200 OK");
        return new ResponseEntity<BasicDTO>(basicDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/beleaf/checkforproposal/architecture/{id_project}/", method = RequestMethod.GET)
    public ResponseEntity<List<ArchitectureDTO>> checkForProposal(@PathVariable(value = "id_project") int id_project) {
        ProjectDaoImpl projectDao = new ProjectDaoImpl();
        ComponentDaoImpl componentDao = new ComponentDaoImpl();
        List<Architecture> archs = projectDao.retrieveArchByProjectId(id_project);
        List<ArchitectureDTO> toreturn = new ArrayList<>();
        for (Architecture a : archs) {
            ArchitectureDTO toadd = new ArchitectureDTO();
            ArrayList<ComponentDTO> y = new ArrayList<>();
            List<Component> x = componentDao.retrieveComponentByArchId(a.getId());
            for (Component c : x) {
                ComponentDTO z = new ComponentDTO();
                z.setName(c.getName());
                z.setDescription(c.getDescription());
                y.add(z);
            }
            toadd.setComponents(y);
            toadd.setUser(a.getUser());
            //toadd.setProjectId(id_project);
            toreturn.add(toadd);
        }
        return new ResponseEntity<List<ArchitectureDTO>>(toreturn, HttpStatus.OK);
    }

    @RequestMapping(value = "/beleaf/checkforproposal/slicing/{id_project}/", method = RequestMethod.GET)
    public ResponseEntity<HashMap<Integer, List<SlicingDTO>>> checkForProposalSlicing(@PathVariable(value = "id_project") int id_project) {
        ProjectDaoImpl projectDao = new ProjectDaoImpl();
        Project p = projectDao.retrieveProjectById(id_project);
        Architecture a = p.getArchitectures().get(0);
        ComponentDaoImpl componentDao = new ComponentDaoImpl();
        List<Component> components = componentDao.retrieveComponentByArchId(a.getId());
        SlicingDaoImpl slicingDao = new SlicingDaoImpl();
        HashMap<Integer, List<SlicingDTO>> toreturn = new HashMap<>();
        TaskDaoImpl taskDao = new TaskDaoImpl();
        for (Component c : components) {
            List<Slicing> s = slicingDao.retrieveSlicingByCompId(c.getComponentId());
            List<SlicingDTO> slicingDTOList = new ArrayList<>();
            for (Slicing slicing : s) {
                SlicingDTO sdto = new SlicingDTO();
                sdto.setDescription(slicing.getDescription());
                sdto.setId(slicing.getSlicingId());
                sdto.setUser_id(slicing.getUser().getUserId());
                ComponentDTO cdto = new ComponentDTO();
                cdto.setName(c.getName());
                cdto.setDescription(c.getDescription());
                sdto.setComponent(cdto);
                ArrayList<TaskDTO> listaditask = new ArrayList<>();
                //sdto.setTasks(taskDao.retrieveTaskBySlicingId(slicing.getSlicingId()));
                for (Task t : taskDao.retrieveTaskBySlicingId(slicing.getSlicingId())) {
                    TaskDTO taskDTO = new TaskDTO();
                    taskDTO.setDescription(t.getDescription());
                    taskDTO.setExecution(t.isState());
                    taskDTO.setRetribution(t.getRetribution());
                    taskDTO.setId(t.getTaskId());
                    List<SkillDTO> skills = new ArrayList<>();
                    for (Skill sk : t.getSkills()) {
                        SkillDTO skdto = new SkillDTO();
                        skdto.setName(sk.getName());
                        skills.add(skdto);
                    }
                    taskDTO.setSkills(skills);
                    listaditask.add(taskDTO);
                }
                sdto.setTasks(listaditask);
                slicingDTOList.add(sdto);
            }
            toreturn.put(c.getComponentId(), slicingDTOList);
        }
        return new ResponseEntity<HashMap<Integer, List<SlicingDTO>>>(toreturn, HttpStatus.OK);


    }


}
