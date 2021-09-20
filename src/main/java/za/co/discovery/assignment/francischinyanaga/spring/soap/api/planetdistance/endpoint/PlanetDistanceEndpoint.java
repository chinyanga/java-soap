package za.co.discovery.assignment.francischinyanaga.spring.soap.api.planetdistance.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import za.co.discovery.assignment.francischinyanaga.services.PlanetDistanceService;
import za.co.discovery.assignment.francischinyanaga.spring.soap.api.planetdistance.Acknowledgement;
import za.co.discovery.assignment.francischinyanaga.spring.soap.api.planetdistance.DistanceRequest;

@Endpoint
public class PlanetDistanceEndpoint {

	private static final String NAMESPACE = "http://www.discovery.co.za/assignment/francischinyanaga/spring/soap/api/planetDistance";
	@Autowired
	private  PlanetDistanceService service;

	@PayloadRoot(namespace = NAMESPACE, localPart = "DistanceRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload DistanceRequest request) {
		return service.calculateDistance(request);
	}

}