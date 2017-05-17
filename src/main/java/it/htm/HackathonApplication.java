package it.htm;

import it.htm.dao.UserDao;
import it.htm.dao.UserDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class HackathonApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackathonApplication.class, args);
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.insertUser();
	}


}
