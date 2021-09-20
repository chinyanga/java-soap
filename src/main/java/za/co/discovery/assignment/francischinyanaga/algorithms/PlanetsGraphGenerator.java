package za.co.discovery.assignment.francischinyanaga.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import za.co.discovery.assignment.francischinyanaga.models.Planet;

public class PlanetsGraphGenerator {

	public Graph generatePlanetsGraph(List<Planet> planets) {
		System.out.println(planets.size());

		// create nodes
		final Map<String, Node> nodeMapList = createNodes(planets);
		System.out.println(nodeMapList);

		// add destination
		final Map<String, Node> nodeListWithDistinations = addNodesDistinations(nodeMapList, planets);

		// add nodes to graph
		final Graph graph = createGraph(nodeListWithDistinations);

		Node orgNode = nodeMapList.get("A");
		for (Node n : graph.getNodes()) {
			for (Map.Entry<Node, Double> adjacentNodes : n.getAdjacentNodes().entrySet()) {
				if (adjacentNodes.getKey() != null) {
					System.out.println(adjacentNodes.getValue() + "\t");
				}
			}
		}
        try {
		// Graph g =
		ShortestDistanceCalculator.calculateShortestPathFromSource(graph,orgNode );
        }catch(Exception e) {
        	System.out.println(e);
        }

		return graph;

	}

	// create nodes
	public Map<String, Node> createNodes(List<Planet> planets) {
		System.out.println("=========creting nodes=========");
		Map<String, Node> nodeMapList = new HashMap<>();
		Node node = new Node("");
		for (Planet p : planets) {
			// System.out.println(p.getOriginPlanetLetter()+"\t"+p.getOriginPlanetName()+"\t"+p.getDistanceBetweenPlanets());
			node = new Node(p.getOriginPlanetLetter());
			if (!nodeMapList.containsKey(p.getOriginPlanetLetter())) {
				nodeMapList.put(p.getOriginPlanetLetter(), node);
			}
		}
		return nodeMapList;
	}

	// add destination to nodes
	public Map<String, Node> addNodesDistinations(Map<String, Node> nodeMapList, List<Planet> planets) {
		Map<String, Node> nodeMapListWithDistinations = new HashMap<>();
		for (Planet p : planets) {
			if (nodeMapList.containsKey(p.getOriginPlanetLetter())) {
				Node nd = nodeMapList.get(p.getOriginPlanetLetter());
				nd.addDestination(nodeMapList.get(p.getDistinationPlanetLetter()), p.getDistanceBetweenPlanets());
				nodeMapListWithDistinations.put(p.getOriginPlanetLetter(), nd);
			}
		}
		return nodeMapListWithDistinations;
	}

	// create graph
	public Graph createGraph(Map<String, Node> nodeListWithDistinations) {
		System.out.println("=========creting graph=========");
		Graph graph = new Graph();
		for (Map.Entry<String, Node> nodeList : nodeListWithDistinations.entrySet()) {
			if (nodeList.getValue() != null) {
				graph.addNode(nodeList.getValue());
			}
		}
		return graph;
	}

}
