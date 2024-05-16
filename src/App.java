import classes.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        //Grafo não euleriano
        Graph<String> g = new Graph<>();
        g.addVertice("A");
        g.addVertice("B");
        g.addVertice("C");
        g.addVertice("D");
        g.addAresta("A", "B", 2.5);
        g.addAresta("A", "C", 1.8);
        g.addAresta("B", "C", 3.2);
        g.addAresta("B", "D", 2.0);
        g.addAresta("C", "D", 2.7);

        if (!g.eEuleriano()) {
            System.out.println("O grafo não é euleriano");
            g.imprimirMenorCaminhoDijkstra("A","D");
            System.out.print("\n");
        } else {
            System.out.println("O grafo possui um caminho euleriano:");
            g.printEulerTour();
            System.out.print("\n");
        }

        //Grafo Euleriano
        Graph<String> g2 = new Graph<>();
        g2.addVertice("A");
        g2.addVertice("B");
        g2.addVertice("C");
        g2.addVertice("D");
        g2.addAresta("A", "B", 3.2);
        g2.addAresta("B", "C", 4.2);
        g2.addAresta("C", "D", 5.2);
        g2.addAresta("D", "A", 6.2);

        if (!g2.eEuleriano()) {
            g2.imprimirMenorCaminhoDijkstra("A", "D");
            System.out.println("O grafo não é euleriano");
            System.out.print("\n");
        } else {
            System.out.println("O grafo possui um caminho euleriano:");
            g2.printEulerTour();
            System.out.print("\n");
        }

    }
}
