package graph;

public class Vertex<E> {
    private E data;

    public Vertex(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public String toString() {
        return data.toString();
    }
}