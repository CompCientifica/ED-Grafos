package classes;

import java.util.ArrayList;

public class Vertice<T> {
  private T data;
  private ArrayList<Edge<T>> edgesIn;
  private ArrayList<Edge<T>> edgesOut;

  public Vertice(T data) {
    this.data = data;
    this.edgesIn = new ArrayList<Edge<T>>();
    this.edgesOut = new ArrayList<Edge<T>>();
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public ArrayList<Edge<T>> getEdgesIn() {
    return this.edgesIn;
  }

  public void setEdgesIn(ArrayList<Edge<T>> edgesIn) {
    this.edgesIn = edgesIn;
  }

  public void addEdgeIn(Edge<T> edge) {
    this.edgesIn.add(edge);
  }
  
  public ArrayList<Edge<T>> getEdgesOut() {
    return this.edgesOut;
  }
  
  public void setEdgesOut(ArrayList<Edge<T>> edgesOut) {
    this.edgesOut = edgesOut;
  }

  public void addEdgeOut(Edge<T> edge) {
    this.edgesOut.add(edge);
  }
}
