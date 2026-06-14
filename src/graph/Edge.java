package graph;

public class Edge<E> {
    private Vertex<E> destination;
    private int weight;

    public Edge(Vertex<E> destination) {
        this(destination, 1);
    }

    public Edge(Vertex<E> destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex<E> getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return destination.toString() + "(" + weight + ")";
    }
}