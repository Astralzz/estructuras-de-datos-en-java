package lista_circular_enlazada;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//Clase principal
public class Principal {

  static Scanner Entrada = new Scanner(System.in);

  //Cuerpo
  public static void programa() {
    //Lista
    Lista lista = null;

    do {
      try {
        //Escogemos opc
        int opc = menu();
        System.out.println("OPTION = " + opc);

        //Crear lista
        if (opc == 1) {
          //Creamos lista
          lista = new Lista();
          System.out.println("ÉXITO, La lista se creo correctamente");
          opc = -1;
        }

        //Verificamos
        if (lista != null || opc == 10) {
          //Opciones
          switch (opc) {
            case 2: //Agregar dato manualmente
              lista.ingresarNuevoDato();
              break;
            case 3: //Agregar dato manualmente
              String cadena = cadenaAleatoria();
              lista.ingresarNuevoDato(cadena);
              break;
            case 4:
              break;
            case 5:
              break;
            case 6:
              break;
            case 7:
              break;
            case 8: //Ver lista
              System.out.println("\nLa lista es:" + lista.obtenerLista());
              break;
            case 9:
              break;
            case 10: //Salir
              System.out.println("\nAsta luego =)");
              //Salimos
              System.exit(0);
              break;
            default:
              break;
          }
        } else {
          System.out.println("ERROR, Aun no as creado una lista");
        }
        //Error
      } catch (Exception e) {
        //Mensaje de error
        System.out.println(
          "ERROR, Dato invalido -> " + e.getLocalizedMessage()
        );
        //Iniciamos scanner
        Entrada = new Scanner(System.in);
      }
    } while (true);
  }

  //Menu
  public static int menu() {
    int n = 0;
    do {
      //Mensaje
      System.out.println(
        """

          MENU PRINCIPAL
          1. Crear nueva lista circular enlazada
          2. Agregar dato manualmente
          3. Agregar dato aleatorio
          4. Buscar dato 
          5. Modificar dato
          6. intercambiar datos
          7. Eliminar dato
          8. Ver lista
          9. Vaciar lista
          10. Salir
          """
      );
      n = Entrada.nextInt();

      //Verificamos
      if (n < 1 || n > 10) {
        System.out.println("ERROR, Opción no valida");
      }
    } while (n < 1 || n > 10);

    return n;
  }

  //Cadena aleatoria
  public static String cadenaAleatoria() {
    //Arreglo de nombres
    String[] nombres = {
      "Maria",
      "Pedro",
      "Lucas",
      "Jose",
      "Marta",
      "Karla",
      "Pedro",
      "Enrique",
      "Manuel",
      "Sofia",
      "Jesus",
      "Daniel",
      "Elias",
      "Erik",
      "Monica",
      "Rosa",
      "Doris",
      "Carlos",
    };
    //Escojamos un numero aleatorio con el rango del arreglo
    int i = noAleatorio(0, nombres.length - 1);
    //Retornamos
    return nombres[i];
  }

  //Numero aleatorio
  public static int noAleatorio(int max, int min) {
    // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
    return ThreadLocalRandom.current().nextInt(max, min + 1);
  }

  //Método main
  public static void main(String[] args) {
    programa();
  }
}
//  //Creamos lista ed
//  Lista lista = new Lista();
//  lista.ingresarNuevoDato("Perro");
//  lista.ingresarNuevoDato("Gato");
//  lista.ingresarNuevoDato("Gallina");
//  lista.ingresarNuevoDato("Burro");
//  lista.ingresarNuevoDato("Vaca");
//  lista.ingresarNuevoDato("Caballo");
//  System.out.println("\n la lista es: " + lista.obtenerLista());
//  //Agregar datos manualmente
//  for (int index = 0; index < 3; index++) {
//    lista.ingresarNuevoDato();
//  }
//  //Buscar datos
//  for (int index = 0; index < 3; index++) {
//    lista.buscarDato();
//  }
//  //Modificar datos
//  for (int index = 0; index < 3; index++) {
//    lista.modificarDato();
//  }
//  //Eliminar datos
//  for (int index = 0; index < 3; index++) {
//    lista.eliminarDato();
//  }
