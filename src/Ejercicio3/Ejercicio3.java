import graph.GraphLink;

public class Ejercicio3 {
    public static void main(String[] args) {

        GraphLink<String> g = new GraphLink<>();

        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");

        g.insertEdge("A", "B");
        g.insertEdge("A", "C");
        g.insertEdge("B", "D");

        System.out.println("GRAFO:");
        System.out.println(g);

        System.out.println("Buscar vertice A:");
        System.out.println(g.searchVertex("A"));

        System.out.println("Buscar arista A-B:");
        System.out.println(g.searchEdge("A", "B"));

        System.out.println("Vertices adyacentes de A:");
        System.out.println(g.adjacentVertices("A"));

        g.removeEdge("A", "B");

        System.out.println("GRAFO DESPUES DE ELIMINAR ARISTA A-B:");
        System.out.println(g);

        g.removeVertex("C");

        System.out.println("GRAFO DESPUES DE ELIMINAR VERTICE C:");
        System.out.println(g);
    }
}