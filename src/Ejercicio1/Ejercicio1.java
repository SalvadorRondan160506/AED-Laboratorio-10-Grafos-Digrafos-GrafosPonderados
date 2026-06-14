package Ejercicio1;

import graph.GraphLink;
import java.util.ArrayList;
import java.util.Stack;

public class Ejercicio1 {
    public static void main(String[] args) {

        GraphLink<String> g = new GraphLink<>();

        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");
        g.insertVertex("E");

        g.insertEdgeWeight("A", "B", 4);
        g.insertEdgeWeight("A", "C", 2);
        g.insertEdgeWeight("B", "D", 5);
        g.insertEdgeWeight("C", "D", 1);
        g.insertEdgeWeight("D", "E", 3);

        System.out.println("GRAFO PONDERADO:");
        System.out.println(g);

        System.out.println("Es conexo: " + g.isConexo());

        ArrayList<String> camino = g.shortPath("A", "E");
        System.out.println("Camino mas corto A-E:");
        System.out.println(camino);

        Stack<String> ruta = g.Dijkstra("A", "E");
        System.out.println("Ruta usando Dijkstra:");
        System.out.println(ruta);
    }
}