package lista_circular_enlazada;

//Clase nodo
public class Nodo {

  //Variables
  private String Valor;
  private Nodo NodoSiguiente;

  //Constructor
  public Nodo() {
    //Inicializamos
    this.Valor = null;
    this.NodoSiguiente = null;
  }

  //Getters y setters
  public String getValor() {
    return Valor;
  }

  public Nodo getNodoSiguiente() {
    return NodoSiguiente;
  }

  public void setNodoSiguiente(Nodo NodoSiguiente) {
    this.NodoSiguiente = NodoSiguiente;
  }

  public void setValor(String valor) {
    this.Valor = valor;
  }
}
