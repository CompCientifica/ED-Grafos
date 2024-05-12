package classes;

public class Edge<T> {
  // TODO: Add necessary fields (Maybe weight, distance...)
  private Double weight;
  private Vertice<T> start;
  private Vertice<T> end;

  public Edge(Double weight, Vertice<T> start, Vertice<T> end) {
    this.weight = weight;
    this.start = start;
    this.end = end;
  }

    public Double getWeight() {
      return this.weight;
    }

    public void setWeight(Double weight) {
      this.weight = weight;
    }

    public Vertice<T> getStart() {
      return this.start;
    }

    public void setStart(Vertice<T> vertice) {
      this.start = vertice;
    }

    public Vertice<T> getEnd() {
      return this.end;
    }

    public void setEnd(Vertice<T> vertice) {
      this.end = vertice;
    }
}
