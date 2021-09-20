package za.co.discovery.assignment.francischinyanaga.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Node {
    
    private String name;
    
    private List<Node> shortestPath = new LinkedList<>();
    
    private Double distance = Double.MAX_VALUE;
    
    Map<Node, Double> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, double d) {
        adjacentNodes.put(destination, d);
    }
 
    public Node(String name) {
        this.name = name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double i) {
		this.distance = i;
	}

	public Map<Node, Double> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<Node, Double> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
}
