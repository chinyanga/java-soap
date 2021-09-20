package za.co.discovery.assignment.francischinyanaga.models;

public class DistanceResponse {

	private String originPlanetName;
	
	private String originPlanetLetter;
	
	private String distinationPlanetName;
	
	private String distinationPlanetLetter;
	
	private String route;
	
	private Long distanceBetweenPlanets;

	public DistanceResponse() {

	}

	public DistanceResponse(String originPlanetName, String originPlanetLetter, String distinationPlanetName,
			String distinationPlanetLetter, String route, Long distanceBetweenPlanets) {
		super();
		this.originPlanetName = originPlanetName;
		this.originPlanetLetter = originPlanetLetter;
		this.distinationPlanetName = distinationPlanetName;
		this.distinationPlanetLetter = distinationPlanetLetter;
		this.route = route;
		this.distanceBetweenPlanets = distanceBetweenPlanets;
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

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Long getDistanceBetweenPlanets() {
		return distanceBetweenPlanets;
	}

	public void setDistanceBetweenPlanets(Long distanceBetweenPlanets) {
		this.distanceBetweenPlanets = distanceBetweenPlanets;
	}
		
}
