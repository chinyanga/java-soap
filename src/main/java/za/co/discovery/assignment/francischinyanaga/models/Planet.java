package za.co.discovery.assignment.francischinyanaga.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity
@Table(name="planets")
public class Planet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String originPlanetName;
	
	private String originPlanetLetter;
	
	private String distinationPlanetName;
	
	private String distinationPlanetLetter;
	
	private double distanceBetweenPlanets;

	public Planet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Planet(Long id, String originPlanetName, String originPlanetLetter, String distinationPlanetName,
			String distinationPlanetLetter, double distanceBetweenPlanets) {
		super();
		this.id = id;
		this.originPlanetName = originPlanetName;
		this.originPlanetLetter = originPlanetLetter;
		this.distinationPlanetName = distinationPlanetName;
		this.distinationPlanetLetter = distinationPlanetLetter;
		this.distanceBetweenPlanets = distanceBetweenPlanets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginPlanetName() {
		return originPlanetName;
	}

	public void setOriginPlanetName(String originPlanetName) {
		this.originPlanetName = originPlanetName;
	}

	public String getOriginPlanetLetter() {
		return originPlanetLetter;
	}

	public void setOriginPlanetLetter(String originPlanetLetter) {
		this.originPlanetLetter = originPlanetLetter;
	}

	public String getDistinationPlanetName() {
		return distinationPlanetName;
	}

	public void setDistinationPlanetName(String distinationPlanetName) {
		this.distinationPlanetName = distinationPlanetName;
	}

	public String getDistinationPlanetLetter() {
		return distinationPlanetLetter;
	}

	public void setDistinationPlanetLetter(String distinationPlanetLetter) {
		this.distinationPlanetLetter = distinationPlanetLetter;
	}

	public double getDistanceBetweenPlanets() {
		return distanceBetweenPlanets;
	}

	public void setDistanceBetweenPlanets(double distanceBetweenPlanets) {
		this.distanceBetweenPlanets = distanceBetweenPlanets;
	}
	
}
