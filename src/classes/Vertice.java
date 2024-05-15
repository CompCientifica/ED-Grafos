package classes;
import java.util.*;

public class Vertice<T> {
  private T valor;

  public Vertice(T valor) {
    this.valor = valor;
  }

  public T getValor() {
    return valor;
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj)
      return true;
    if(obj == null || getClass() != obj.getClass())
      return false;
    Vertice<?> vertice = (Vertice<?>) obj;
    return Objects.equals(valor, vertice.valor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valor);
  }

  @Override
  public String toString() {
    return valor.toString();
  }

}
