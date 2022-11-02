package lista_circular_enlazada;

//Clase principal
public class Principal {

  //Método main
  public static void main(String[] args) {
    //Creamos lista
    Lista lista = new Lista();
    lista.ingresarNuevoDato("Perro");
    lista.ingresarNuevoDato("Gato");
    lista.ingresarNuevoDato("Gallina");
    lista.ingresarNuevoDato("Burro");
    lista.ingresarNuevoDato("Vaca");
    lista.ingresarNuevoDato("Caballo");
    System.out.println("\n la lista es: " + lista.obtenerLista());
    //Agregar datos manualmente
    for (int index = 0; index < 3; index++) {
      lista.ingresarNuevoDato();
    }
    //Buscar datos
    for (int index = 0; index < 3; index++) {
      lista.buscarDato();
    }
    //Modificar datos
    for (int index = 0; index < 3; index++) {
      lista.modificarDato();
    }
    //Eliminar datos
    for (int index = 0; index < 3; index++) {
      lista.eliminarDato();
    }
  }
}
