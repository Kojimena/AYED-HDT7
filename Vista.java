/**
 * Permite ingresar y mostrar datos.
 * @author Jimena Hernandez/21199
 * @version 08/04/2022
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de Datos
 * HDT7
 */


//LIBRERIAS
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {
    
    //PROPIEDADES
    private static Scanner scan = new Scanner(System.in);
    private  int opcion;

    /**
     * Método para imprimir un mensaje
     * @param mensaje Mensaje a imprimir
     */
    public void mensaje(String mensaje){
        System.out.print(mensaje);
    }

    /**
     * Bienvenida
     */
    public void inicio(){
        System.out.println("\n DICCIONARIO  ");
    }

    /**
    * Despliega el menú de opciones para el usuario. Luego, recibe la opción elegida por el usuario y la devuelve.
    * @return La opción elegida por el usuario
    */
    public int menu(){
        mensaje("\n" +"Ingrese la opcion a realizar ");
        mensaje("\n1. Recorrer diccionario *in order* ");
        mensaje("\n2. Agregar palabra al diccionario ");
        mensaje("\n3. Eliminar palabra del diccionario ");
        mensaje("\n4. Procesar archivo para traducirlo");
        mensaje("\n5. Salir del programa");

        mensaje("\nSeleccion: ");
        try {
            opcion = scan.nextInt();
            
        } catch (InputMismatchException e) {
            mensaje("Porfavor, ingrese una opcion valida");
            opcion = scan.nextInt();
        }
		scan.nextLine();
		return opcion;
    }

    /**
     * Getter de la palabra a editar o eliminar.
     */
    public String getPalabra(){

        mensaje("\nIngrese la palabra en ingles que desea editar o eliminar\n");

        return scan.nextLine();
    }

    public String getPalabraNueva(){

        mensaje("\nIngrese la palabra en ingles que quiere agregar\n");

        return scan.nextLine();
    }

    public String getTradNueva(){

        mensaje("\nIngrese el nuevo significado en español de la palabra agregada\n");

        return scan.nextLine();
    }

    public String getPalabracambio(){

        mensaje("\nIngrese la palabra en ingles a la que le quiere cambiar el valor\n");

        return scan.nextLine();
    }

    public String getTradcambio(){

        mensaje("\nIngrese el significado en español de la palabra anterior\n");

        return scan.nextLine();
    }



}