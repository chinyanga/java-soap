package za.co.discovery.assignment.francischinyanaga.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class ShortestDistanceCalculator {

	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
		source.setDistance(0.0);

		Set<Node> settledNodes = new HashSet<>();
		Set<Node> unsettledNodes = new HashSet<>();

		unsettledNodes.add(source);
		System.out.println(unsettledNodes.size());
		while (unsettledNodes.size() != 0) {
			Node currentNode = getLowestDistanceNode(unsettledNodes);
			unsettledNodes.remove(currentNode);
			if (currentNode != null) {
				for (Entry<Node, Double> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
					Node adjacentNode = adjacencyPair.getKey();
					Double edgeWeight = adjacencyPair.getValue();
					if (!settledNodes.contains(adjacentNode)) {
						calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
						unsettledNodes.add(adjacentNode);
					}
				}

				settledNodes.add(currentNode);
			}
		}
		return graph;
	}

	private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
		Node lowestDistanceNode = null;
		double lowestDistance = Double.MAX_VALUE;

		for (Node node : unsettledNodes) {
			if (node != null) {
				double nodeDistance = node.getDistance();
				if (nodeDistance < lowestDistance) {
					lowestDistance = nodeDistance;
					lowestDistanceNode = node;
				}
			}
		}
		return lowestDistanceNode;
	}

	private static void calculateMinimumDistance(Node evaluationNode, Double edgeWeight, Node sourceNode) {
		Double sourceDistance = sourceNode.getDistance();
		if (sourceNode != null && evaluationNode != null) {
			if (sourceDistance + edgeWeight < evaluationNode.getDistance()) {
				evaluationNode.setDistance(sourceDistance + edgeWeight);
				LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
				shortestPath.add(sourceNode);
				evaluationNode.setShortestPath(shortestPath);
			} 
		}
	}

}
