import classes.*;

public class App {
    public static void main(String[] args) throws Exception {
        Graph<String> graph = new Graph<String>();
        graph.addVertice("Paulo");
        graph.addVertice("Lorenzo");
        graph.addVertice("Cleuza");
        graph.addVertice("Kleber");
        graph.addVertice("Claudio");

        graph.addEdge(2.0, "Paulo", "Lorenzo");
        graph.addEdge(3.0, "Lorenzo", "Kleber");
        graph.addEdge(1.0, "Kleber", "Cleuza");
        graph.addEdge(1.0, "Paulo", "Cleuza");
        graph.addEdge(2.0, "Claudio", "Lorenzo");
        graph.addEdge(2.0, "Claudio", "Paulo");

        graph.depthSearch();
    }
}
