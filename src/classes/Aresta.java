package classes;

public class Aresta<T> {
  private Vertice<T> origem;
  private Vertice<T> destino;
  private double peso;

  public Aresta(Vertice<T> origem, Vertice<T> destino, double peso) {
    this.origem = origem;
    this.destino = destino;
    this.peso = peso;
  }

  public Vertice<T> getOrigem() {
    return origem;
  }

  public Vertice<T> getDestino() {
    return destino;
  }

  public double getPeso() {
    return peso;
  }
}
