package gov.nasa.robotexplorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class RobotExplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotExplorerApplication.class, args);
	}
}
