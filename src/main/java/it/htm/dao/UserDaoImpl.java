package it.htm.dao;

import it.htm.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public User getUserByName(String name) {
        return (User) em.createQuery("SELECT u FROM User u WHERE u.name =:name").setParameter("name", name).getSingleResult();
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getUsersByProject(Project project) {
        List<UserProject> userProjects = em.createQuery("SELECT up FROM UserProject up WHERE up.project =:project").setParameter("project", project).getResultList();
        List<User> users = new ArrayList<>();
        for(UserProject userProject : userProjects)
            users.add(em.find(User.class, userProject.getUser().getUserId()));
        return users;
    }

    @Override
    public void insertUser() {
        User user = new User();
        user.setName("Vincenzo Santucci");
        user.setRate(3.5);
        user.setEmail("vincenzo.santucci1@gmail.com");
        List<Skill> skills = new ArrayList<>();
        Skill skill = new Skill("Java");
        Skill skill2 = new Skill("Python");
        skills.add(skill);
        skills.add(skill2);
        user.setSkills(skills);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        User user2 = new User();
        user2.setName("Simone Sbraga");
        user2.setRate(3);
        user2.setEmail("sbraga.simone@libero.it");
        List<Skill> skills2 = new ArrayList<>();
        Skill skill21 = new Skill("C");
        Skill skill22 = new Skill("PHP");
        skills2.add(skill21);
        skills2.add(skill22);
        user2.setSkills(skills2);
        em.getTransaction().begin();
        em.persist(user2);
        em.getTransaction().commit();

        User user3 = new User();
        user3.setName("Valerio Ponza");
        user3.setRate(2);
        user3.setEmail("valerio.b.ponza@gmail.com");
        List<Skill> skills3 = new ArrayList<>();
        Skill skill31 = new Skill("Spring");
        Skill skill32 = new Skill("Javascript");
        Skill skill33 = new Skill("AngularJS");
        skills3.add(skill31);
        skills3.add(skill32);
        skills3.add(skill33);
        user3.setSkills(skills3);
        em.getTransaction().begin();
        em.persist(user3);
        em.getTransaction().commit();

        User user4 = new User();
        user4.setName("Andrea Maino");
        user4.setRate(4.5);
        user4.setEmail("maino.and@gmail.com");
        List<Skill> skills4 = new ArrayList<>();
        Skill skill41 = new Skill("Data Analyst");
        Skill skill42 = new Skill("Business Analytics");
        skills4.add(skill41);
        skills4.add(skill42);
        user4.setSkills(skills4);
        em.getTransaction().begin();
        em.persist(user4);
        em.getTransaction().commit();

        User user5 = new User();
        user5.setName("Axel Naike Zamatei");
        user5.setRate(3.5);
        user5.setEmail("axelnaike@hotmail.it");
        List<Skill> skills5 = new ArrayList<>();
        Skill skill51 = new Skill("NodeJS");
        Skill skill52 = new Skill("AWS");
        skills5.add(skill51);
        skills5.add(skill52);
        user5.setSkills(skills5);
        em.getTransaction().begin();
        em.persist(user5);
        em.getTransaction().commit();

        Project project = new Project();
        project.setName("progetto");
        project.setDescription("descrizione progetto");
        project.setBudget(1000);
        project.setState("SLICING");

        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();

        System.out.println(((Project)em.createQuery("SELECT p FROM Project p where p.name =:nome").setParameter("nome", project.getName()).getSingleResult()).getProjectId());

        UserProject up = new UserProject();
        up.setProject(project);
        up.setUser(user);
        up.setRole("Owner");

        em.getTransaction().begin();
        em.persist(up);
        em.getTransaction().commit();

        /*

        up = new UserProject();
        up.setProject(project);
        up.setUser(user2);
        up.setRole("Slicer");

        em.getTransaction().begin();
        em.persist(up);
        em.getTransaction().commit();

        List<Component> components = new ArrayList<>();

        Component component = new Component();
        component.setName("Back-end");
        component.setDescription("description back-end");
        components.add(component);

        Slicing a = new Slicing();
        a.setDescription("Implementazione dio cane");
        a.setComponent(component);
        a.setUser(user);
        List<Task> tasks = new ArrayList<>();
        Task t = new Task();
        t.setDescription("implementazione dio cane task");
        t.setProject(project);
        t.setSlicing(a);
        t.setState(false);
        tasks.add(t);
        a.setTasks(tasks);
        List<Slicing> slicingList = new ArrayList<>();
        slicingList.add(a);
        component.setSlicing(slicingList);


        Component component1 = new Component();
        component1.setName("Front-end");
        component1.setDescription("description front-end");
        components.add(component1);

        List<Architecture> architectures = new ArrayList<>();

        Architecture architecture = new Architecture();
        architecture.setComponents(components);
        architecture.setUser(user);

        architectures.add(architecture);

        project.setArchitectures(architectures);

        em.getTransaction().begin();
        em.merge(project);
        em.getTransaction().commit();
        */
    }


}
