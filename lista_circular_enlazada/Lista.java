package lista_circular_enlazada;

//Importaciones
import java.util.Scanner;

//Clase lista
public class Lista {

  //Variables
  private Scanner Entrada;
  private Nodo PrimerNodo;
  private Nodo UltimoNodo;

  //Constructor
  public Lista() {
    //Inicializamos
    this.UltimoNodo = null;
    this.PrimerNodo = null;

    //Iniciamos Scanner
    this.Entrada = new Scanner(System.in);
  }

  //Ingresar nuevo
  public void ingresarNuevoDato() {
    //Creamos un objeto
    Nodo NuevoNodo = new Nodo();

    //Pedimos datos
    System.out.println("\nIngresa el nuevo dato para la lista:");
    String dato = Entrada.nextLine();

    //Guardamos datos
    NuevoNodo.setValor(dato);

    //Insertamos
    insertarDatos(NuevoNodo);

    //Mostramos resultado
    System.out.println(
      "\nÉXITO, El valor " + dato + " se a agregado correctamente en la lista"
    );
    System.out.println("\nlista: " + obtenerLista(dato));
  }

  //Ingresar nuevo
  public void ingresarNuevoDato(String dato) {
    //Creamos un objeto
    Nodo NuevoNodo = new Nodo();

    //Guardamos datos
    NuevoNodo.setValor(dato);

    //Insertamos
    insertarDatos(NuevoNodo);

    //Mostramos resultado
    System.out.println(
      "\nÉXITO, El valor " + dato + " se a agregado correctamente en la lista"
    );
    System.out.println("\nlista: " + obtenerLista(dato));
  }

  //Insertar nodo
  private void insertarDatos(Nodo NuevoNodo) {
    //Si es el primer nodo
    if (this.PrimerNodo == null) {
      //Damos valor al primero y al ultimo
      this.PrimerNodo = NuevoNodo;
      this.UltimoNodo = NuevoNodo;
      //Damos valor siguiente
      this.PrimerNodo.setNodoSiguiente(NuevoNodo);
      //Retornamos
      return;
    }

    //Actualizamos ultimo nodo
    this.UltimoNodo.setNodoSiguiente(NuevoNodo);
    //Actualizamos nodo siguiente
    NuevoNodo.setNodoSiguiente(this.PrimerNodo);
    //Actualizamos ultimo
    this.UltimoNodo = NuevoNodo;
  }

  //Ingresar dato a buscar
  public void buscarDato() {
    //Pedimos dato a buscar
    System.out.println("\nIngresa el dato que deseas buscar en la lista:");
    String dato = Entrada.nextLine();

    //Buscamos
    int Pos = buscarDato(dato);

    //Si se encontró el dato
    if (Pos != -1) {
      //Mostramos
      System.out.println(
        "\nÉXITO, El dato " +
        dato +
        " se encuentra en la posición " +
        Pos +
        " de la lista"
      );
      System.out.println("\nlista: " + obtenerLista());
      return;
    }

    //No encontrado
    System.out.println("\nEl dato " + dato + " no se encuentra en la lista");
  }

  //Buscar dato
  private int buscarDato(String dato) {
    //Creamos nodo actual
    Nodo NodoActual = new Nodo();
    //Damos el primer nodo
    NodoActual = this.PrimerNodo;
    //Posición
    int Posición = 0;

    //Verificamos que la lista tenga nodos
    if (this.PrimerNodo != null) {
      //Recorremos
      do {
        //Buscamos
        if (NodoActual.getValor().equals(dato)) {
          return Posición;
        }
        //Actualizamos nodo al siguiente
        NodoActual = NodoActual.getNodoSiguiente();
        //Actualizamos posición
        Posición++;
        //Verificamos
      } while (NodoActual != this.PrimerNodo);

      //Retornamos
      return -1;
    }

    //Retornamos
    return -1;
  }

  //Ingresar dato a buscar para modificar
  public void modificarDato() {
    //Verificamos que la lista tenga nodos
    if (this.PrimerNodo != null) {
      //Pedimos dato a buscar
      System.out.println("\n" + obtenerLista());
      System.out.println("Ingresa el dato que deseas intercambiar:");
      String dato = Entrada.nextLine();

      //Buscamos
      String NuevoDato = modificarDato(dato);
      //Si se encontró el dato
      if (NuevoDato != null) {
        //Mostramos
        System.out.println(
          "\nÉXITO, Se modifico el dato " +
          dato +
          " por " +
          NuevoDato +
          " en la lista"
        );
        System.out.println("\nlista Nueva: " + obtenerLista());
        return;
      }

      //No encontrado
      System.out.println("\nEl dato " + dato + " no se encuentra en la lista");
      return;
    }

    //Es vacía
    System.out.println("\nERROR, La lista esta vacía");
  }

  //Modificar dato
  private String modificarDato(String dato) {
    //Creamos nodo actual
    Nodo NodoActual = new Nodo();
    //Damos el primer nodo
    NodoActual = this.PrimerNodo;

    //Recorremos
    do {
      //Comparamos
      if (NodoActual.getValor().equals(dato)) {
        //Modificamos
        System.out.println(
          "\n¿Que valor deseas poner en lugar de " + dato + "?:"
        );
        NodoActual.setValor(Entrada.nextLine());
        return NodoActual.getValor();
      }
      //Actualizamos nodo al siguiente
      NodoActual = NodoActual.getNodoSiguiente();
      //Verificamos
    } while (NodoActual != this.PrimerNodo);

    //No encontrado
    return null;
  }

  //Ingresar dato a buscar para eliminar
  public void eliminarDato() {
    //Verificamos que la lista tenga nodos
    if (this.PrimerNodo != null) {
      //Pedimos dato a buscar
      System.out.println("\n" + obtenerLista());
      System.out.println("Ingresa el dato que deseas eliminar:");
      String dato = Entrada.nextLine();

      //Buscamos
      Boolean Resultado = eliminarDato(dato);
      //Si se encontró el dato
      if (Resultado) {
        //Mostramos
        System.out.println(
          "\nÉXITO, Se elimino el dato " + dato + " de la lista"
        );
        System.out.println("\nlista Nueva: " + obtenerLista());
        return;
      }

      //No encontrado
      System.out.println("\nEl dato " + dato + " no se encuentra en la lista");
      return;
    }

    //Es vacía
    System.out.println("\nERROR, La lista esta vacía");
  }

  //eliminar dato
  private boolean eliminarDato(String dato) {
    //Creamos nodo actual
    Nodo NodoActual = new Nodo();
    //Damos el primer nodo
    NodoActual = this.PrimerNodo;
    //Creamos nodo para el dato anterior
    Nodo NodoAnterior = null;

    //Recorremos
    do {
      //Comparamos
      if (NodoActual.getValor().equals(dato)) {
        //Si el valor a eliminar es el primero
        if (NodoActual == this.PrimerNodo) {
          //Si el ultimo nodo es nulo solo queda un elemento
          if (this.PrimerNodo.getValor() == this.UltimoNodo.getValor()) {
            //Eliminamos
            this.UltimoNodo = null;
            this.PrimerNodo = null;
            //Retornamos
            return true;
          }
          //Ponemos el valor de primero el dato siguiente
          this.PrimerNodo = this.PrimerNodo.getNodoSiguiente();
          //Ponemos el ultimo valor como el primero
          this.UltimoNodo.setNodoSiguiente(this.PrimerNodo);
          //Si el valor a eliminar es el ultimo
        } else if (NodoActual == this.UltimoNodo) {
          //Asignamos el valor del primer nodo al nodo anterior
          NodoAnterior.setNodoSiguiente(this.PrimerNodo);
          //El valor del ultimo sera el nodo anterior
          this.UltimoNodo = NodoAnterior;
          //Si esta entre medio
        } else {
          //Intercambiamos
          NodoAnterior.setNodoSiguiente(NodoActual.getNodoSiguiente());
        }
        return true;
      }
      //Actualizamos nodo anterior al actual
      NodoAnterior = NodoActual;
      //Actualizamos nodo al siguiente
      NodoActual = NodoActual.getNodoSiguiente();
      //Verificamos
    } while (NodoActual != this.PrimerNodo);

    //No encontrado
    return false;
  }

  //Obtener lista
  public String obtenerLista() {
    //Creamos nodo actual
    Nodo NodoActual = new Nodo();
    //Damos el primer nodo
    NodoActual = this.PrimerNodo;

    //Verificamos que la lista tenga nodos
    if (this.PrimerNodo != null) {
      //Respuesta
      String Respuesta = "\n";

      //Recorremos
      do {
        //Agregamos valor
        Respuesta += "[" + NodoActual.getValor() + "] ";
        //Actualizamos nodo al siguiente
        NodoActual = NodoActual.getNodoSiguiente();
      } while (NodoActual != this.PrimerNodo);

      //Retornamos
      return Respuesta;
    }

    //Retornamos
    return "\nLa lista esta vacía";
  }

  //Obtener lista señalada
  public String obtenerLista(String dato) {
    //Creamos nodo actual
    Nodo NodoActual = new Nodo();
    //Damos el primer nodo
    NodoActual = this.PrimerNodo;

    //Verificamos que la lista tenga nodos
    if (this.PrimerNodo != null) {
      //Respuesta
      String Respuesta = "\n";

      //Recorremos
      do {
        //Comparamos
        if (NodoActual.getValor().equals(dato)) {
          //Agregamos valor señalado
          Respuesta += ">" + NodoActual.getValor() + "< ";
        } else {
          //Agregamos valor
          Respuesta += "[" + NodoActual.getValor() + "] ";
        }
        //Actualizamos nodo al siguiente
        NodoActual = NodoActual.getNodoSiguiente();
      } while (NodoActual != this.PrimerNodo);

      //Retornamos
      return Respuesta;
    }

    //Retornamos
    return "\nLa lista esta vacía";
  }
}
