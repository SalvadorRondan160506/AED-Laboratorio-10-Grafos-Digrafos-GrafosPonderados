package graph;

import java.util.ArrayList;

public interface Graph<E> {

    void insertVertex(E vertex);

    void insertEdge(E origin, E destination);

    void removeVertex(E vertex);

    void removeEdge(E origin, E destination);

    boolean searchVertex(E vertex);

    boolean searchEdge(E origin, E destination);

    ArrayList<E> adjacentVertices(E vertex);
}