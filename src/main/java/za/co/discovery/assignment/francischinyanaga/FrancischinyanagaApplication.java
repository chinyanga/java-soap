package za.co.discovery.assignment.francischinyanaga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import za.co.discovery.assignment.francischinyanaga.models.Planet;
import za.co.discovery.assignment.francischinyanaga.services.PlanetServiceImpl;

@SpringBootApplication
public class FrancischinyanagaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrancischinyanagaApplication.class, args);
	}

}
