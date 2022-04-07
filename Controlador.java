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
         String archivo = "/Users/jime/Desktop/HDT7/diccionario.txt";
         
 
         vista.inicio();
         
         opcion = vista.menu(); //se llama la opción

         //LECTURA
        try{
			String line = "";
			Scanner reader = new Scanner(new File(archivo));	
			while(reader.hasNextLine()){
				line = reader.nextLine();
				String[] parts = line.split(", ");
                String key = parts[0].replace("(","");
                String value = parts[1].replace(")","");
                association= new ComparableAssociation<String,String>(key, value);
                dictionary.addValue(association); //Se agregan datos al tree
            }
        }catch(Exception e){
			    System.out.println("El archivo no ha sido encontrado");
		}

        while(opcion != 5){
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
                String nuevaP = vista.getPalabraNueva();
                String nuevaT= vista.getTradNueva();
                association= new ComparableAssociation<String,String>(nuevaP, nuevaT);
                dictionary.addValue(association); //Se agregan datos al tree
                vista.mensaje("\nSu palabra se agrego exitosamente al arbol!!!");
                di_ordenado =  dictionary.inOrder(dictionary.getRoot());
			    vista.mensaje("\n Diccionario actualizado in order:\n");
			    for(int i=0; i<di_ordenado.size(); i++){
				vista.mensaje("("+di_ordenado.get(i).getKey()+", "+di_ordenado.get(i).getValue()+")");
			    }
                di_ordenado.clear();

                break;
                case 3: //Cambiar valor
                
                break;
                case 4: // Traducir
                break;

                //Se le avisa al usuario que no esta ingresando una opción correcta
            default: vista.mensaje("-Opcion invalida, porfavor ingrese una opción valida-");   break;
            }
            opcion = vista.menu();
        }
    }
}
