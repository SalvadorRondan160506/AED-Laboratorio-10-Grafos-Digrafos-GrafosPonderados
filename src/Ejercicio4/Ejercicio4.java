import graph.GraphAnalyzer;
import graph.GraphLink;

public class Ejercicio4 {
    public static void main(String[] args) {

        GraphLink<String> grafo1 = new GraphLink<>();

        grafo1.insertVertex("A");
        grafo1.insertVertex("B");
        grafo1.insertVertex("C");
        grafo1.insertVertex("D");

        grafo1.insertEdge("A", "B");
        grafo1.insertEdge("B", "C");
        grafo1.insertEdge("C", "D");

        GraphLink<String> grafo2 = new GraphLink<>();

        grafo2.insertVertex("W");
        grafo2.insertVertex("X");
        grafo2.insertVertex("Y");
        grafo2.insertVertex("Z");

        grafo2.insertEdge("W", "X");
        grafo2.insertEdge("X", "Y");
        grafo2.insertEdge("Y", "Z");

        GraphAnalyzer<String> analyzer = new GraphAnalyzer<>();

        System.out.println("GRAFO 1:");
        System.out.println(grafo1);

        System.out.println("GRAFO 2:");
        System.out.println(grafo2);

        System.out.println("Grafo 1 es conexo:");
        System.out.println(analyzer.isConexo(grafo1));

        System.out.println("Grafo 1 es plano:");
        System.out.println(analyzer.isPlano(grafo1));

        System.out.println("Grafo 1 y Grafo 2 son isomorfos:");
        System.out.println(analyzer.isIsomorfo(grafo1, grafo2));

        System.out.println("Grafo 1 es autocomplementario:");
        System.out.println(analyzer.isAutoComplementario(grafo1));
    }
}