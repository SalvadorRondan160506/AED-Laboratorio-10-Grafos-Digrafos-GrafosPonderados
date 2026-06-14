package graph;

import listlinked.ListLinked;
import java.util.*;

public class GraphLink<E> {

    private ListLinked<AdjList<E>> graph;

    public GraphLink() {
        graph = new ListLinked<>();
    }

    public void insertVertex(E data) {
        if (!searchVertex(data)) {
            graph.addLast(new AdjList<>(new Vertex<>(data)));
        }
    }

    private AdjList<E> findVertex(E data) {
        for (int i = 0; i < graph.size(); i++) {
            AdjList<E> adj = graph.get(i);

            if (adj.getVertex().getData().equals(data)) {
                return adj;
            }
        }

        return null;
    }

    public boolean searchVertex(E data) {
        return findVertex(data) != null;
    }

    public void insertEdge(E origin, E destination) {
        insertEdgeWeight(origin, destination, 1);
    }

    public void insertEdgeWeight(E origin, E destination, int weight) {
        AdjList<E> v1 = findVertex(origin);
        AdjList<E> v2 = findVertex(destination);

        if (v1 == null || v2 == null) {
            System.out.println("Uno de los vertices no existe.");
            return;
        }

        if (!searchEdge(origin, destination)) {
            v1.getEdges().addLast(new Edge<>(v2.getVertex(), weight));
            v2.getEdges().addLast(new Edge<>(v1.getVertex(), weight));
        }
    }

    public boolean searchEdge(E origin, E destination) {
        AdjList<E> v1 = findVertex(origin);

        if (v1 == null) return false;

        for (int i = 0; i < v1.getEdges().size(); i++) {
            Edge<E> edge = v1.getEdges().get(i);

            if (edge.getDestination().getData().equals(destination)) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<E> shortPath(E origin, E destination) {
        ArrayList<E> path = new ArrayList<>();

        HashMap<E, Integer> distance = new HashMap<>();
        HashMap<E, E> previous = new HashMap<>();
        HashSet<E> visited = new HashSet<>();

        for (int i = 0; i < graph.size(); i++) {
            E vertex = graph.get(i).getVertex().getData();
            distance.put(vertex, Integer.MAX_VALUE);
            previous.put(vertex, null);
        }

        distance.put(origin, 0);

        while (visited.size() < graph.size()) {
            E current = getMinDistanceVertex(distance, visited);

            if (current == null) break;

            visited.add(current);

            AdjList<E> adj = findVertex(current);

            for (int i = 0; i < adj.getEdges().size(); i++) {
                Edge<E> edge = adj.getEdges().get(i);
                E neighbor = edge.getDestination().getData();

                if (!visited.contains(neighbor)) {
                    int newDistance = distance.get(current) + edge.getWeight();

                    if (newDistance < distance.get(neighbor)) {
                        distance.put(neighbor, newDistance);
                        previous.put(neighbor, current);
                    }
                }
            }
        }

        E current = destination;

        while (current != null) {
            path.add(0, current);
            current = previous.get(current);
        }

        return path;
    }

    private E getMinDistanceVertex(HashMap<E, Integer> distance, HashSet<E> visited) {
        E minVertex = null;
        int minDistance = Integer.MAX_VALUE;

        for (E vertex : distance.keySet()) {
            if (!visited.contains(vertex) && distance.get(vertex) < minDistance) {
                minDistance = distance.get(vertex);
                minVertex = vertex;
            }
        }

        return minVertex;
    }

    public boolean isConexo() {
        if (graph.size() == 0) return true;

        HashSet<E> visited = new HashSet<>();
        Queue<E> queue = new LinkedList<>();

        E start = graph.get(0).getVertex().getData();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            E current = queue.poll();
            AdjList<E> adj = findVertex(current);

            for (int i = 0; i < adj.getEdges().size(); i++) {
                E neighbor = adj.getEdges().get(i).getDestination().getData();

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return visited.size() == graph.size();
    }

    public Stack<E> Dijkstra(E origin, E destination) {
        ArrayList<E> path = shortPath(origin, destination);
        Stack<E> stack = new Stack<>();

        for (E vertex : path) {
            stack.push(vertex);
        }

        return stack;
    }

    public void removeVertex(E data) {
        AdjList<E> vertex = findVertex(data);

        if (vertex == null) return;

        for (int i = 0; i < graph.size(); i++) {
            AdjList<E> adj = graph.get(i);
            removeEdgeFromList(adj, data);
        }

        graph.remove(vertex);
    }

    public void removeEdge(E origin, E destination) {
        AdjList<E> v1 = findVertex(origin);
        AdjList<E> v2 = findVertex(destination);

        if (v1 == null || v2 == null) return;

        removeEdgeFromList(v1, destination);
        removeEdgeFromList(v2, origin);
    }

    private void removeEdgeFromList(AdjList<E> adj, E destination) {
        for (int i = 0; i < adj.getEdges().size(); i++) {
            Edge<E> edge = adj.getEdges().get(i);

            if (edge.getDestination().getData().equals(destination)) {
                adj.getEdges().remove(edge);
                return;
            }
        }
    }

    public ArrayList<E> adjacentVertices(E data) {
        ArrayList<E> list = new ArrayList<>();
        AdjList<E> adj = findVertex(data);

        if (adj == null) return list;

        for (int i = 0; i < adj.getEdges().size(); i++) {
            list.add(adj.getEdges().get(i).getDestination().getData());
        }

        return list;
    }

    public int countVertices() {
        return graph.size();
    }

    public int countEdges() {
        int count = 0;

        for (int i = 0; i < graph.size(); i++) {
            count += graph.get(i).getEdges().size();
        }

        return count / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < graph.size(); i++) {
            AdjList<E> adj = graph.get(i);

            sb.append(adj.getVertex()).append(" -> ");

            for (int j = 0; j < adj.getEdges().size(); j++) {
                sb.append(adj.getEdges().get(j)).append(" ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}