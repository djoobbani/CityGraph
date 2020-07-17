package com.mastercard.codechallenge.citygraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.validation.constraints.NotBlank;

public class CityGraph {

	private Map<String, Set<String>> cityGraphs = new HashMap<>();

	public void addAdjacentNeighborCities(@NotBlank String cityA, @NotBlank String cityB) {
		cityA = cityA.trim().toLowerCase();
		cityB = cityB.trim().toLowerCase();

		Set<String> directConnectionsA = this.cityGraphs.getOrDefault(cityA, new HashSet<String>());
		directConnectionsA.add(cityB);
		this.cityGraphs.put(cityA, directConnectionsA);

		Set<String> directConnectionsB = this.cityGraphs.getOrDefault(cityB, new HashSet<String>());
		directConnectionsB.add(cityA);
		this.cityGraphs.put(cityB, directConnectionsB);
	}

	public boolean areCitiesConnected(@NotBlank String cityA, @NotBlank String cityB) {
		cityA = cityA.trim().toLowerCase();
		cityB = cityB.trim().toLowerCase();

		if (this.cityGraphs.size() < 1) {
			return false;
		}

		if (!this.cityGraphs.containsKey(cityA) && !this.cityGraphs.containsKey(cityB)) {
			return false;
		}

		Set<String> visitedNodes = new HashSet<>();
		Stack<String> stack = new Stack<>();
		stack.push(cityA);

		while (!stack.isEmpty()) {
			String currentCityNode = stack.pop();
			visitedNodes.add(currentCityNode);

			if (currentCityNode.equals(cityB)) {
				return true;
			}

			for (String neighbor : this.cityGraphs.get(currentCityNode)) {
				if (!visitedNodes.contains(neighbor)) {
					stack.push(neighbor);
				}
			}
		}

		return false;
	}

}
