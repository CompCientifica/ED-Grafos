package classes;
import java.util.*;
public class Graph<T> {
  private List<Vertice<T>> vertices;
  private List<Aresta<T>> arestas;

  //Construtor
  public Graph() {
    vertices = new ArrayList<>();
    arestas = new ArrayList<>();
  }

  //Adiciona um vértice ao grafo
  public void addVertice(T valor) {
    Vertice<T> vertice = new Vertice<>(valor);
    if(!vertices.contains(vertice))
      vertices.add(vertice);
  }

  //Adiciona uma aresta ao grafo
  public void addAresta(T origemValor, T destinoValor, double peso) {
    Vertice<T> origem = null;
    Vertice<T> destino = null;

    for(Vertice<T> v : vertices) {
      if (v.getValor().equals(origemValor))
        origem = v;
      if(v.getValor().equals(destinoValor))
        destino = v;
    }

    if(origem != null && destino != null)
      arestas.add(new Aresta<>(origem, destino, peso));
  }

  public void percorrerGrafo() {
    for (Aresta<T> aresta : arestas) {
      System.out.println(aresta.getOrigem() + " -> " + aresta.getDestino() + " (Peso: " + aresta.getPeso() + ")");
    }
  }

  //Função para verificar se todos os vértices têm grau par(Maneira de se verificar se um grafo é conexo)
  private boolean eConexo() {
    int oddDegreeCount = 0;
    for(Vertice<T> v : vertices) {
      int degree = 0;
      for(Aresta<T> a : arestas) {
        if (a.getOrigem().equals(v) || a.getDestino().equals(v))
          degree++;
      }
      if(degree % 2 != 0)
        oddDegreeCount++;
    }
    return (oddDegreeCount == 0 || oddDegreeCount == 2);
  }

  //Função para verificar se o grafo é euleriano
  public boolean eEuleriano() {
    if(!eConexo())
      return false;

    for (Vertice<T> v : vertices) {
      int degree = 0;
      for(Aresta<T> a : arestas) {
        if(a.getOrigem().equals(v) || a.getDestino().equals(v))
          degree++;
      }
      if (degree % 2 != 0)
        return false;
    }

    return true;
  }

  //Função para imprimir o caminho euleriano(Algorítmo de Fleury)
  public void printEulerTour() {
    if (!eEuleriano()) {
      System.out.println("O grafo não é euleriano");
      return;
    }

    Stack<Vertice<T>> stack = new Stack<>();
    List<Aresta<T>> tempArestas = new ArrayList<>(arestas);

    Vertice<T> startVertex = vertices.get(0);

    stack.push(startVertex);
    while (!stack.isEmpty()) {
      Vertice<T> currentVertex = stack.peek();
      boolean hasNext = false;
      for (Aresta<T> a : tempArestas) {
        if(a.getOrigem().equals(currentVertex)) {
          hasNext = true;
          Vertice<T> nextVertex = a.getDestino();
          stack.push(nextVertex);
          tempArestas.remove(a);
          break;
        }
      }
      if(!hasNext) {
        stack.pop();
        System.out.print(currentVertex + " ");
      }
    }
    System.out.println();
  }
}
