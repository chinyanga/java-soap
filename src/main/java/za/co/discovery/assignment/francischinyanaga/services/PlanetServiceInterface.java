package za.co.discovery.assignment.francischinyanaga.services;

import java.util.List;

import za.co.discovery.assignment.francischinyanaga.models.Planet;

public interface PlanetServiceInterface {
	
	public Planet getPlanetById(long id);
	public List<Planet> getAllPlanets();
	public List<Planet> savePlanets(List<Planet> planets);
	public Planet addPlanet(Planet planet);
	public boolean updatePlanet(Planet planet);
	public boolean deletePlanetById(long id);
}
