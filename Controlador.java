/**
 * Controla los datos.
 * @author Jimena Hernandez/21199
 * @version 08/04/2022
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de Datos
 * HDT7
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {
/**
* Main del programa.
**/ 
private static Vista vista = new Vista();
    public static void main(String[] args) throws IOException {
        BinaryTree<ComparableAssociation<String,String>> dictionary = new BinaryTree<ComparableAssociation<String,String>>();
		ComparableAssociation<String, String> association;
        ArrayList<ComparableAssociation<String,String>> di_ordenado;

         //propiedades
         int opcion;
         int lenguaje;
         String archivoenglish = "diccionarioenglish.txt";
         String archivofrench = "diccionariofrench.txt";
         
         vista.inicio();

        lenguaje = vista.menuidioma();
        if (lenguaje == 1){
         //LECTURA
            try{
                String line = "";
                Scanner reader = new Scanner(new File(archivoenglish));
                while(reader.hasNextLine()){
                    line = reader.nextLine();
                    String[] parts = line.split(", ");
                    String key = parts[0].replace("(","").toLowerCase();
                    String value = parts[1].replace(")","").toLowerCase();
                    association= new ComparableAssociation<String,String>(key, value);
                    dictionary.addValue(association); //Se agregan datos al tree
                }
            }catch(Exception e){
                    System.out.println("El archivo no ha sido encontrado");
            }
        }else if(lenguaje== 2){
            try{
                String line = "";
                Scanner reader = new Scanner(new File(archivofrench));
                while(reader.hasNextLine()){
                    line = reader.nextLine();
                    String[] parts = line.split(", ");
                    String key = parts[0].replace("(","").toLowerCase();
                    String value = parts[1].replace(")","").toLowerCase();
                    association= new ComparableAssociation<String,String>(key, value);
                    dictionary.addValue(association); //Se agregan datos al tree
                }
            }catch(Exception e){
                    System.out.println("El archivo no ha sido encontrado");
            }
        }
    opcion = vista.menu(); //se llama la opción

        while(opcion != 7){
            switch(opcion){
                case 1: //Ordenar In order
			    di_ordenado =  dictionary.inOrder(dictionary.getRoot());
			    vista.mensaje("\n Diccionario ordenado in order\n");
			    for(int i=0; i<di_ordenado.size(); i++){
				    System.out.println("("+di_ordenado.get(i).getKey()+", "+di_ordenado.get(i).getValue()+")");
			    }
                di_ordenado.clear();
                break;
                case 2: //Agregar palabra
                    String nuevaP = "";
                    String nuevaT= "";
                    if (lenguaje==1) {
                        nuevaP = vista.getPalabraNueva();
                        nuevaT = vista.getTradNueva();
                    }else if(lenguaje == 2){
                        nuevaP = vista.getPalabraNuevafrenc();
                        nuevaT = vista.getTradNueva();
                    }
                association= new ComparableAssociation<String,String>(nuevaP.toLowerCase(), nuevaT.toLowerCase());
                dictionary.addValue(association); //Se agregan datos al tree
                vista.mensaje("\nSu palabra se agrego exitosamente al diccionario!!!");
                di_ordenado =  dictionary.inOrder(dictionary.getRoot());
			    vista.mensaje("\n Diccionario actualizado in order:\n");
			    for(int i=0; i<di_ordenado.size(); i++){
				    vista.mensaje("("+di_ordenado.get(i).getKey()+", "+di_ordenado.get(i).getValue()+")");
                    vista.mensaje("\n");
			    }
                di_ordenado.clear();
                break;
                case 3: //Eliminar
                    String viejat = "";
                    String nuevat = "";
                    if (lenguaje==1) {
                        viejat = vista.getPalabra().toLowerCase();
                        nuevat = vista.getTradcambio().toLowerCase();
                    }else if (lenguaje == 2){
                        viejat = vista.getPalabrafrench().toLowerCase();
                        nuevat = vista.getTradcambio().toLowerCase();
                    }
                association= new ComparableAssociation<String,String>(viejat, nuevat);
                dictionary.delete(association); //Se eliminan datos del tree
                vista.mensaje("\nSu palabra se ha eliminado exitosamente del diccionario!!!");
                di_ordenado =  dictionary.inOrder(dictionary.getRoot());
                vista.mensaje("\n Diccionario actualizado in order:\n");
			    for(int i=0; i<di_ordenado.size(); i++){
				    vista.mensaje("("+di_ordenado.get(i).getKey()+", "+di_ordenado.get(i).getValue()+")");
                    vista.mensaje("\n");
			    }
                di_ordenado.clear();
                break;
                case 4://Editar
                    String poriginal = "";
                    String tanterior = "";
                    if (lenguaje==1) {
                        poriginal = vista.getPalabracambio().toLowerCase();
                        tanterior = vista.getTradcambio().toLowerCase();
                    }else if (lenguaje == 2){
                        poriginal = vista.getPalabracambiofrench().toLowerCase();
                        tanterior = vista.getTradcambio().toLowerCase();
                    }
                    String tnueva = vista.getTradNueva();
                    association= new ComparableAssociation<String,String>(poriginal.toLowerCase(), tanterior.toLowerCase());
                    dictionary.delete(association); //Se eliminan datos del tree
                    association= new ComparableAssociation<String,String>(poriginal.toLowerCase(), tnueva.toLowerCase());
                    dictionary.addValue(association); //Se agregan datos del tree
                    vista.mensaje("\nSu palabra se ha editado exitosamente del diccionario!!!");
                    di_ordenado =  dictionary.inOrder(dictionary.getRoot());
                    vista.mensaje("\n Diccionario actualizado in order:\n");
                    for(int i=0; i<di_ordenado.size(); i++){
                        vista.mensaje("("+di_ordenado.get(i).getKey()+", "+di_ordenado.get(i).getValue()+")");
                        vista.mensaje("\n");
                    }
                    di_ordenado.clear();
                break;
                case 5: // Traducir
                di_ordenado =  dictionary.inOrder(dictionary.getRoot());
                if (lenguaje==1) {
                    try {
                        ArrayList<String> temp = new ArrayList<String>();
                        String traduc = "";
                        Scanner translator = new Scanner(new File("traduccionenglish.txt"));
                        String div = translator.nextLine();
                        String[] divpalabras = div.split(" ");

                        vista.mensaje("\nFrase a traducir:\t");
                        System.out.println(div);

                        for (int i = 0; i < divpalabras.length; i++) {
                            temp.add("*" + divpalabras[i] + "*");
                            for (int j = 0; j < di_ordenado.size(); j++) {
                                if (divpalabras[i].equalsIgnoreCase(di_ordenado.get(j).getKey())) {
                                    temp.set(i, "" + di_ordenado.get(j).getValue() + "");
                                }
                            }
                        }
                        for (int i = 0; i < temp.size(); i++) {
                            traduc += temp.get(i) + " ";
                        }
                        vista.mensaje("\nFrase traducida:\t");
                        System.out.println(traduc);
                    } catch (Exception e) {
                        System.out.println("El archivo a traducir no existe,por favor verifique que esté en la carpeta");
                    }
                }else if(lenguaje==2){
                    try {
                        ArrayList<String> temp = new ArrayList<String>();
                        String traduc = "";
                        Scanner translator = new Scanner(new File("traduccionfrench.txt"));
                        String div = translator.nextLine();
                        String[] divpalabras = div.split(" ");

                        vista.mensaje("\nFrase a traducir:\t");
                        System.out.println(div);

                        for (int i = 0; i < divpalabras.length; i++) {
                            temp.add("*" + divpalabras[i] + "*");
                            for (int j = 0; j < di_ordenado.size(); j++) {
                                if (divpalabras[i].equalsIgnoreCase(di_ordenado.get(j).getKey())) {
                                    temp.set(i, "" + di_ordenado.get(j).getValue() + "");
                                }
                            }
                        }
                        for (int i = 0; i < temp.size(); i++) {
                            traduc += temp.get(i) + " ";
                        }
                        vista.mensaje("\nFrase traducida:\t");
                        System.out.println(traduc);
                    } catch (Exception e) {
                        System.out.println("El archivo a traducir no existe,por favor verifique que esté en la carpeta");
                    }
                }
                di_ordenado.clear();
                break;
                case 6:
                vista.mensaje("\nsaliendo...");
                System.exit(0);
                break;

                //Se le avisa al usuario que no esta ingresando una opción correcta
            default: vista.mensaje("-Opción invalida, porfavor ingrese una opción valida-");   break;
            }
            opcion = vista.menu();
        }
    }
}
