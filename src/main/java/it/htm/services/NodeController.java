package it.htm.services;

import it.htm.dao.ComponentDaoImpl;
import it.htm.dao.ProjectDaoImpl;
import it.htm.dao.UserDaoImpl;
import it.htm.dao.UserProjectDaoImpl;
import it.htm.dto.*;
import it.htm.entity.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class NodeController {

    private UserDTO createUserDTO(Project project, User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getName());
        userDTO.setMail(user.getEmail());
        userDTO.setRate(user.getRate());
        UserProjectDaoImpl userProjectDao = new UserProjectDaoImpl();
        userDTO.setRole(userProjectDao.getRoleOfUser(project, user));
        List<SkillDTO> skillsDTO = new ArrayList<>();
        for (Skill skill : user.getSkills())
            skillsDTO.add(createSkillDTO(skill));
        userDTO.setSkills(skillsDTO);
        return userDTO;
    }

    private SkillDTO createSkillDTO(Skill skill) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setName(skill.getName());
        return skillDTO;
    }

    private ProjectDTO createProjectDTO(Project project, List<UserDTO> users, List<ArchitectureDTO> architectures) {
        ProjectDTO pDTO = new ProjectDTO();
        pDTO.setBudget(project.getBudget());
        pDTO.setDescription(project.getDescription());
        pDTO.setName(project.getName());
        pDTO.setState(project.getState());
        pDTO.setUsers(users);
        return pDTO;
    }

    private ArchitectureDTO createArchitectureDTO(Architecture architecture) {
        ArchitectureDTO architectureDTO = new ArchitectureDTO();
        ComponentDaoImpl componentDao = new ComponentDaoImpl();
        List<Component> components = componentDao.retrieveComponentByArchId(architecture.getId());
        List<ComponentDTO> componentsDTO = new ArrayList<>();
        for(Component component : components)
            componentsDTO.add(new ComponentDTO(component.getName(), component.getDescription()));
        architectureDTO.setComponents(componentsDTO);
        return architectureDTO;
    }

    @RequestMapping(value="/beleaf/projects/architecture")
    public List<ProjectDTO> getAllNewProjects() {
        List<ProjectDTO> toReturn = new ArrayList<>();
        ProjectDaoImpl projectDao = new ProjectDaoImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        List<Project> projects = projectDao.getAllNewProjects();
        List<UserDTO> users = new ArrayList<>();
        for(Project p : projects) {
            User projectOwner = userDao.getUserById(p.getProjectId());
            users.add(createUserDTO(p, projectOwner));
            toReturn.add(createProjectDTO(p, users, null));
        }
        return toReturn;
    }

    @RequestMapping(value="/beleaf/projects/slicing")
    public List<ProjectDTO> getAllSlicingProjects(){
        List<ProjectDTO> toReturn = new ArrayList<>();
        ProjectDaoImpl projectDao = new ProjectDaoImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        List<Project> projects = projectDao.getAllSlicingProjects();
        List<UserDTO> usersDTO = new ArrayList<>();
        List<ArchitectureDTO> architecture = new ArrayList<>();
        for(Project p : projects) {
            List<User> users = userDao.getUsersByProject(p);
            for(User user : users)
                usersDTO.add(createUserDTO(p, user));
            architecture.add(createArchitectureDTO(p.getArchitectures().get(0)));
            toReturn.add(createProjectDTO(p, usersDTO, architecture));
        }
        return toReturn;
    }

    @RequestMapping(value="/beleaf/projects/architecture/proposal/{id}", method = RequestMethod.POST)
    public ResponseEntity<BasicDTO> insertProposal(@RequestBody ArchitectureDTO architectureDTO, @PathVariable(value="id") String id){
        /*Architecture a = new Architecture();
        User u = new User();
        u.setName(architectureDTO.getUserDTO().getUsername());
        u.setPassword(architectureDTO.getUserDTO().getPassword());
        u.setEmail(architectureDTO.getUserDTO().getMail());
        u.setRate(architectureDTO.getUserDTO().getRate());
        a.setUser(u);
        a.setDescription(architectureDTO.getDescription());
        ProjectDaoImpl projectDao = new ProjectDaoImpl();
        Project p = projectDao.retrieveProjectById(id);
        List<Architecture> architectures = p.getArchitectures();
        architectures.add(a);
        p.setArchitectures(architectures);

        return new ResponseEntity<BasicDTO>(new BasicDTO(), HttpStatus.OK);*/
        return null;
    }

    @RequestMapping(value="/beleaf/projects/slicing/proposal/{id}", method = RequestMethod.POST)
    public ResponseEntity<BasicDTO> insertProposal(@RequestBody SlicingDTO slicingDTO, @PathVariable(value="id") String id){
        return null;
    }
}
