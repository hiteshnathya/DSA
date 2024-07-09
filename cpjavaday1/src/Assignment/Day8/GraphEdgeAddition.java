package Assignment.Day8;

import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjacencyList;
    private Set<Integer> visited;
    private Set<Integer> recursionStack;

    public Graph() {
        adjacencyList = new HashMap<>();
        visited = new HashSet<>();
        recursionStack = new HashSet<>();
    }

    public void addNode(int node) {
        adjacencyList.put(node, new ArrayList<>());
        System.out.println("Added node " + node);
    }

    public boolean addEdge(int source, int destination) {
        System.out.println("Trying to add edge from " + source + " to " + destination);
        if (hasCycle(source, destination)) {
            System.out.println("Edge not added, cycle detected");
            return false; // cycle detected, edge not added
        }
        adjacencyList.get(source).add(destination);
        System.out.println("Edge added successfully from " + source + " to " + destination);
        return true; // edge added successfully
    }

    private boolean hasCycle(int source, int destination) {
        System.out.println("Checking for cycle from " + source);
        visited.add(source);
        recursionStack.add(source);

        for (int neighbor : adjacencyList.get(source)) {
            System.out.println("Visiting neighbor " + neighbor);
            if (!visited.contains(neighbor)) {
                if (hasCycle(neighbor, destination)) {
                    return true;
                }
            } else if (recursionStack.contains(neighbor)) {
                System.out.println("Cycle detected at node " + neighbor);
                return true; // cycle detected
            }
        }

        recursionStack.remove(source);
        return false; // no cycle detected
    }

    public void printGraph() {
        System.out.println("Graph:");
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

public class GraphEdgeAddition{
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        // try to add an edge that would create a cycle
        if (!graph.addEdge(5, 1)) {
            System.out.println("Edge not added, cycle detected");
        }

        graph.printGraph();
    }
}