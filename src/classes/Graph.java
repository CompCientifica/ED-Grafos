package classes;

import java.util.ArrayList;

public class Graph<T> {
  private ArrayList<Vertice<T>> vertices;
  private ArrayList<Edge<T>> edges;

  public Graph() {
    this.vertices = new ArrayList<Vertice<T>>();
    this.edges = new ArrayList<Edge<T>>();
  }

  public Vertice<T> getVertice(T data) {
    Vertice<T> vertice = null;
    for (int i = 0; i < this.vertices.size(); i++) {
      Vertice<T> currentVertice = this.vertices.get(i);
      if (currentVertice.getData().equals(data)) {
        vertice = currentVertice;
        break;
      }
    }
    return vertice;
  }

  public void addVertice(T data) {
    Vertice<T> newVertice = new Vertice<T>(data);
    this.vertices.add(newVertice);
  }

  public void addEdge(Double weight, T dataStart, T dataEnd) {
    Vertice<T> start = this.getVertice(dataStart);
    Vertice<T> end = this.getVertice(dataEnd);
    Edge<T> edge = new Edge<T>(weight, start, end);

    start.addEdgeOut(edge);
    start.addEdgeIn(edge);
    this.edges.add(edge);
  }

  public void depthSearch() {
    ArrayList<Vertice<T>> foundVertices = new ArrayList<Vertice<T>>();
    ArrayList<Vertice<T>> verticesQueue = new ArrayList<Vertice<T>>();
    Vertice<T> currentVertice = this.vertices.get(0);

    foundVertices.add(currentVertice);
    System.out.println(currentVertice.getData());
    verticesQueue.add(currentVertice);

    while(verticesQueue.size() > 0) {
      Vertice<T> visitedVertice = verticesQueue.get(0);
      for(int i = 0; i < visitedVertice.getEdgesOut().size();i++) {
        Vertice<T> nextVertice = visitedVertice.getEdgesOut().get(i).getEnd();
        if(!foundVertices.contains(nextVertice)) {
          foundVertices.add(nextVertice);
          System.out.println(nextVertice.getData());
          verticesQueue.add(nextVertice);
        }
      }
      verticesQueue.remove(0);
    }
  }

  public boolean hasEulerianPath() {
    // Verifica se o grafo está vazio
    if (vertices.isEmpty()) return false;

    // Conta o número de vértices de grau ímpar
    int oddDegreeVertices = 0;
    for (Vertice<T> vertice : vertices) {
      int degree = vertice.getDegree();
      if (degree % 2 != 0) {
        oddDegreeVertices++;
      }
    }

    // Se houver mais de dois vértices de grau ímpar, não pode haver caminho euleriano
    if (oddDegreeVertices > 2) return false;

    // Se houver zero ou dois vértices de grau ímpar, o grafo pode ter um caminho euleriano
    return oddDegreeVertices == 0 || oddDegreeVertices == 2;
  }

}
