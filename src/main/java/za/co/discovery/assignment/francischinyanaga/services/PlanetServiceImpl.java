package za.co.discovery.assignment.francischinyanaga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.discovery.assignment.francischinyanaga.algorithms.ExcelReader;
import za.co.discovery.assignment.francischinyanaga.models.Planet;
import za.co.discovery.assignment.francischinyanaga.repository.PlanetRepository;

@Service
public class PlanetServiceImpl implements PlanetServiceInterface{

	@Autowired
	private PlanetRepository repository;

    @Override
    public Planet getPlanetById(long id) {
        return this.repository.findById(id).get();
    }
    
    @Override
    public List<Planet> savePlanets(List<Planet> planets) {
       return repository.saveAll(planets);
    }

    @Override
    public List<Planet> getAllPlanets() {
       return repository.findAll();
    }

    @Override
    public Planet addPlanet(Planet planet) {
        try {
            return this.repository.save(planet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean updatePlanet(Planet planet) {
        try {
            this.repository.save(planet);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePlanetById(long id) {
        try {
            this.repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

	public void ReadPlanetsFromExcelAndSaveToDb() {
		List<Planet> planets = ExcelReader.readPlanetsFromExcelFile("Data.xlsx");
		savePlanets(planets);
		
	}
}
