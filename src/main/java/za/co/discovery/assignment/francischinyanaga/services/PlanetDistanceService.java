package za.co.discovery.assignment.francischinyanaga.services;

import org.springframework.stereotype.Service;

import za.co.discovery.assignment.francischinyanaga.algorithms.Graph;
import za.co.discovery.assignment.francischinyanaga.algorithms.Node;
import za.co.discovery.assignment.francischinyanaga.algorithms.PlanetsGraphGenerator;
import za.co.discovery.assignment.francischinyanaga.spring.soap.api.planetdistance.Acknowledgement;
import za.co.discovery.assignment.francischinyanaga.spring.soap.api.planetdistance.DistanceRequest;

@Service
public class PlanetDistanceService {

	public PlanetServiceImpl planetService;

	PlanetDistanceService(PlanetServiceImpl planetService) {
		this.planetService = planetService;
	}

	public Acknowledgement calculateDistance(DistanceRequest request) {
		Acknowledgement response = new Acknowledgement();
		PlanetsGraphGenerator planetG = new PlanetsGraphGenerator();
		Graph graph = planetG.generatePlanetsGraph(planetService.getAllPlanets());
		double distance = 0.0;
		for (Node node : graph.getNodes()) {
			System.out.println(node.getName() + "\t" + "\t" + node.getDistance() + "\t");
			if (node.getName().trim().equalsIgnoreCase(request.getDistinationPlanet().trim())) {
				distance = node.getDistance();
				break;
			}
		}
		response.setDistance((double) distance);
		response.setRoute("");
		response.setDistinationPlanet("A");
		response.setDistinationPlanet(request.getDistinationPlanet());
		return response;
	}
}
