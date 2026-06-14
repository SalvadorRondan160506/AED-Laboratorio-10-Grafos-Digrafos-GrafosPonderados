package graph;

public class GraphAnalyzer<E> {

    public boolean isConexo(GraphLink<E> graph) {
        return graph.isConexo();
    }

    public boolean isPlano(GraphLink<E> graph) {
        int vertices = graph.countVertices();
        int aristas = graph.countEdges();

        if (vertices < 3) {
            return true;
        }

        return aristas <= (3 * vertices - 6);
    }

    public boolean isIsomorfo(GraphLink<E> graph1, GraphLink<E> graph2) {
        return graph1.countVertices() == graph2.countVertices()
                && graph1.countEdges() == graph2.countEdges();
    }

    public boolean isAutoComplementario(GraphLink<E> graph) {
        int vertices = graph.countVertices();
        int aristas = graph.countEdges();

        int totalAristasPosibles = (vertices * (vertices - 1)) / 2;
        int complemento = totalAristasPosibles - aristas;

        return aristas == complemento;
    }
}