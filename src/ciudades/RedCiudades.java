package ciudades;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class RedCiudades {

    public static void main(String[] args) {

        Graph<String, DefaultWeightedEdge> grafo =
                new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        grafo.addVertex("Arequipa");
        grafo.addVertex("Cusco");
        grafo.addVertex("Puno");
        grafo.addVertex("Tacna");
        grafo.addVertex("Moquegua");

        agregarCarretera(grafo, "Arequipa", "Cusco", 510);
        agregarCarretera(grafo, "Arequipa", "Moquegua", 230);
        agregarCarretera(grafo, "Moquegua", "Tacna", 160);
        agregarCarretera(grafo, "Cusco", "Puno", 390);
        agregarCarretera(grafo, "Puno", "Tacna", 420);

        System.out.println("LISTA DE CIUDADES:");
        System.out.println(grafo.vertexSet());

        System.out.println("\nCARRETERAS REGISTRADAS:");

        for (DefaultWeightedEdge edge : grafo.edgeSet()) {
            System.out.println(
                    grafo.getEdgeSource(edge)
                            + " - "
                            + grafo.getEdgeTarget(edge)
                            + " : "
                            + grafo.getEdgeWeight(edge)
                            + " km"
            );
        }

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra =
                new DijkstraShortestPath<>(grafo);

        GraphPath<String, DefaultWeightedEdge> camino =
                dijkstra.getPath("Arequipa", "Tacna");

        System.out.println("\nCAMINO MAS CORTO DE AREQUIPA A TACNA:");
        System.out.println(camino.getVertexList());

        System.out.println("COSTO TOTAL:");
        System.out.println(camino.getWeight() + " km");
    }

    public static void agregarCarretera(
            Graph<String, DefaultWeightedEdge> grafo,
            String origen,
            String destino,
            double distancia) {

        DefaultWeightedEdge edge = grafo.addEdge(origen, destino);
        grafo.setEdgeWeight(edge, distancia);
    }
}