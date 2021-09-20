package za.co.discovery.assignment.francischinyanaga.spring.rest.api.planetdistance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.discovery.assignment.francischinyanaga.algorithms.Graph;
import za.co.discovery.assignment.francischinyanaga.algorithms.Node;
import za.co.discovery.assignment.francischinyanaga.algorithms.PlanetsGraphGenerator;
import za.co.discovery.assignment.francischinyanaga.models.Planet;
import za.co.discovery.assignment.francischinyanaga.services.PlanetServiceImpl;

@RestController
@RequestMapping("/rest/api/planets")
public class PlanetController {
	
	@Autowired
	public PlanetServiceImpl planetService;
	
	
	@PostMapping("/addPlanets")
	public List<Planet> addPlanets(@RequestBody List<Planet> planets){
		return planetService.savePlanets(planets);
	}
	
	@GetMapping("/getAllPlanets")
	public List<Planet> findAllPlanets(){
		PlanetsGraphGenerator planetG = new PlanetsGraphGenerator();
		Graph graph = planetG.generatePlanetsGraph(planetService.getAllPlanets());
		for(Node node: graph.getNodes()) {			
			System.out.println(node.getName()+"\t"+"\t"+node.getDistance()+"\t");
		}
		return planetService.getAllPlanets();
	}
	
	@GetMapping("/getPlanetById/{id}")
	public Planet getPlanetById(@PathVariable Long id){
		return planetService.getPlanetById(id);
	}
	
	@PutMapping("/updatePlanet")
	public boolean updateplanet(@RequestBody Planet planet){
		return planetService.updatePlanet(planet);
	}
	
	@PostMapping("/addPlanet")
	public Planet addPlanet(@RequestBody Planet planet){
		return planetService.addPlanet(planet);
	}
	
	@DeleteMapping("/deletePlanet/{id}")
	public boolean deletePlanet(@PathVariable Long id){
		return planetService.deletePlanetById(id);
	}

}
