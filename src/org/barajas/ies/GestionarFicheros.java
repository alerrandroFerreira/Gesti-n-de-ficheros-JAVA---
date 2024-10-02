package org.barajas.ies;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class GestionarFicheros {

	 GestionDeFicheros gestorDeFicheros = new GestionDeFicheros();

    // Método auxiliar para esperar la opción del usuario y volver al menú
    private void finOpcion() {
        System.out.println("*** Pulse ENTER para volver al menú ... ***");
        Scanner sc = new Scanner(System.in);
        try {
            sc.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    /**
     * Método para mostrar el menú de opciones, este hace referencia a lo que sería el 
     * menu de cases
     */
    protected int menu() {
        int opcion;
        System.out.println("*** ########## GESTIÓN DE FICHEROS ########## ***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("1. Crear directorio \"src/main/recursos/practica\" ");
        System.out.println("2. Crear fichero \"src/main/recursos/practica/fichero.txt\" ");
        System.out.println("3. Copiar fichero \"src/main/recursos/practica/fichero.txt\" ");
        System.out.println("4. Crear directorio \"src/main/recursos/practica/copias\" ");
        System.out.println("5. Mover fichero de copia a \"src/main/recursos/practica/copias\" ");
        System.out.println("6. Eliminar fichero de copia en \"src/main/recursos/practica/copias\" ");
        System.out.println("7. Eliminar directorio \"src/main/recursos/practica/copias\" ");
        System.out.println("0. Terminar programa");

        Scanner sc = new Scanner(System.in);
        opcion = sc.nextInt();
        return opcion;
    }

    // Método para arrancar el programa
    protected void arrancarPrograma() {
        int opcion = 0;
        do {
            opcion = menu();

            switch (opcion) {
                case 1:
                	/*admito que la semantica del case no supe realizarla solo,
                	 * https://imaginaformacion.com/tutoriales/que-es-switch-en-java-ejemplos*/
                    // Crear directorio "src/main/recursos/practica"
                    if (gestorDeFicheros.crearDirectorio("src/main/recursos/practica")) {
                        System.out.println("Directorio creado con éxito.");
                    } else {//en caso de que no se pueda realizar el crear
                        System.out.println("Error al crear el directorio.");
                    }
                    finOpcion();
                    break;
                case 2:
                    // Crear fichero "src/main/recursos/practica/fichero.txt"
                	if (gestorDeFicheros.crearFichero("src/main/recursos/practica/fichero.txt")) {
                        System.out.println("Fichero creado con éxito.");
                    } else {//en caso de que no se pueda realizar el crear el fichero
                        System.out.println("No se ha podido crear el fichero.");
                    }
                    finOpcion();
                    break;
                case 3:
                    // Copiar fichero "src/main/recursos/practica/fichero.txt"
                    if (gestorDeFicheros.copiar("src/main/recursos/practica/fichero.txt", "src/main/recursos/practica/ficheroCopia.txt")) {
                        System.out.println("Fichero copiado con éxito.");
                    } else {/*en caso de que no se pueda copiar, el metodo copiar se ha modificado en este .java, 
                    pero sigue ejecutandose bien, el camio se da que no enseña un err, si no que un out, por que considero que si 
                    este paso no funciona se puede repetir en la misma seccion para el funcionamiento del resto*/
                        System.out.println("No se ha podido copiar el fichero.");
                    }
                    finOpcion();
                    break;
                case 4:
                    // Crear directorio "src/main/recursos/practica/copias"
                    if (gestorDeFicheros.crearDirectorio("src/main/recursos/practica/copias")) {
                        System.out.println("Directorio creado con éxito.");
                    } else {//en caso de que no se pueda realizar el metodo crear directorio
                        System.out.println("Error al crear el directorio.");
                    }
                    finOpcion();
                    break;
                case 5:
                    // Mover fichero de copia a "src/main/recursos/practica/copias"
                    if (gestorDeFicheros.mover("src/main/recursos/practica/ficheroCopia.txt", "src/main/recursos/practica/copias/ficheroCopia.txt")) {
                        System.out.println("Fichero movido con éxito.");
                    } else {//en caso de que no se pueda realizar el mover
                        System.out.println("Error al mover el fichero.");
                    }
                    finOpcion();
                    break;
                case 6:
                    // Eliminar fichero de copia en "src/main/recursos/practica/copias"
                    if (gestorDeFicheros.eliminar("src/main/recursos/practica/copias/ficheroCopia.txt")) {
                        System.out.println("Fichero eliminado con éxito.");
                    } else {//en caso de que no se pueda realizar el eliminar
                        System.out.println("No se ha podido eliminar el fichero.");
                    }
                    finOpcion();
                    break;
                case 7:
                    // Eliminar directorio "src/main/recursos/practica/copias"
                    if (gestorDeFicheros.eliminar("src/main/recursos/practica/copias")) {
                        System.out.println("Directorio eliminado con éxito.");
                    } else {//en caso de que no se pueda realizar el eliminar dir
                        System.out.println("No se ha podido eliminar el directorio.");
                    }
                    finOpcion();
                    break;
                case 0:
                    // Terminar programa
                    break;
                default:
                    System.out.println("Opción no válida.");
                    finOpcion();
            }
        } while (opcion != 0);

        System.out.println("*** ########## GESTIÓN DE FICHEROS ########## ***");
        System.out.println("*** ------------ FIN DEL PROGRAMA ----------- ***");
    }

    public static void main(String[] args) {
        GestionarFicheros gestor = new GestionarFicheros();
        gestor.arrancarPrograma();
    }
}
