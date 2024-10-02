package org.barajas.ies;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;


public class GestionDeFicheros {
	
	//ALERRANDRO HERON FERREIRA
	
	 /* BLOQUE DE METODOS NECESARIOS, EL CODIGO DE ESTA CLASE ES EXACTAMENTE EL VISTO Y APROBADO EN CLASE
	  * CON CAMBIOS FUNDAMENTALES COMO EL 
	  * -CATCH QUE NO DEVUELVE LOS ERRORES DEL SISTEMA
	  * -LA CREACIÓN Y ELIMINACIÓN DE FICHEROS EN CASO DE QUE YA EXISTEN
	  * ESO ES PARA UNA EJECUCIÓN ININTERRUMPIDA
	  * 
	  * 
	  * HE TENIDO QUE MODIFICAR TODOS LOS CODIGOS PARA:
	  * -NO MOSTRAR EL ERROR EN CASO DE CACTH
	  * -TAMBIEN SE BORRAN ARCHIVOS EN CASO DE QUE YA EXISTEN, SOLO PARA QUE PUEDA
	  * SEGUIR LA EJECUCIÓN EN CASO DE ERRORES...
	  * */

	
	
    // CREAR FICHERO - MODIFICADO PARA NO EXEPCIONES Y QUE SI EXISTE SE CREA DIRECTAMENTE PARA UNA EJECUCIÓN LIMPA
	protected boolean crearFichero(String nombre) {
	    boolean creado = false;
	    Path ruta = Paths.get(nombre);
	    try {
	        if (Files.exists(ruta)) {
	            System.out.println("El fichero ya existe. Se procederá a eliminarlo.");
	            Files.delete(ruta);  // Elimina el fichero, pero solo en caso de si existente
	            System.out.println("Fichero eliminado correctamente.");
	        }
	        Path fichero = Files.createFile(ruta);  // Crea nuevo fichero
	        System.out.println("Creado el fichero " + fichero);
	        creado = true;
	    } catch (IOException e) {
	        System.err.println("No se ha podido crear el fichero.");
	      //se ha borrado el packtracer.. asi no se muestra el cach, si no el sysout
	    }
	    return creado;
	}//CREARFICHERO
	
	
	
	// CREAR DIRECTORIO
	protected boolean crearDirectorio(String nombre) {
	    boolean creado = false;
	    Path ruta = Paths.get(nombre);
	    try {
	        if (Files.exists(ruta)) {
	            System.out.println("El directorio ya existe. Se procederá a eliminarlo.");
	            Files.delete(ruta);  // Elimina el directorio existente
	            System.out.println("Directorio eliminado correctamente.");
	        }
	        Path directorio = Files.createDirectory(ruta);  // Crea el nuevo directorio
	        System.out.println("Creado el directorio " + directorio);
	        creado = true;
	    } catch (IOException e) {
	        System.err.println("No se ha podido crear el directorio.");
	      //se ha borrado el packtracer.. asi no se muestra el cach, si no el sysout
	    }
	    return creado;
	}//CREARDIR...


	// COPIAR FICHERO
	/*este metodo esta hecho por ia y adaptado por mi, no consegui originar el :
	 * boolean copiado = false;
    Path original = Paths.get(origen);
    Path copia = Paths.get(destino);
    try {
        if (!Files.exists(original)) {
            System.out.println("El fichero de origen no existe. Creando uno nuevo.");
            Files.createFile(original);  // Si no existe el fichero original, se crea uno nuevo
            System.out.println("Fichero de origen creado: " + original);
        }
         Files.copy(original, copia);  // Copia el fichero original al destino
        copiado = true;
        System.out.println("Se ha copiado el fichero " + original + " en " + copia);
    } catch (IOException e) {
    
    resumiendo
     se crea uno nuevo, y si el fichero de destino existe, se elimina 
     automáticamente antes de realizar la copia.
	  */
	protected boolean copiar(String origen, String destino) {
	    boolean copiado = false;
	    Path original = Paths.get(origen);
	    Path copia = Paths.get(destino);

	    try {
	        // VERIFICA SI EXISTE EL FICHERO DE ORIGEN
	        if (!Files.exists(original)) {
	            System.out.println("El fichero de origen no existe. Creando uno nuevo.");
	            Files.createFile(original);  // Si no existe el fichero original, se crea uno nuevo
	            System.out.println("Fichero de origen creado: " + original);
	        }

	        // VERIFICA SI EXISTE EL FICHERO DE DESTINO
	        if (Files.exists(copia)) {
	            System.out.println("El fichero de destino ya existe. Eliminándolo.");
	            Files.delete(copia);  // Elimina el fichero de destino
	            System.out.println("Fichero de destino eliminado correctamente.");
	        }

	        // SE COPIA EL FICHERO
	        Files.copy(original, copia);  // Copia el fichero original al destino
	        copiado = true;
	        System.out.println("Se ha copiado el fichero " + original + " en " + copia);
	    } catch (IOException e) {
	        System.out.println("No se ha podido copiar el fichero.");
	        // Se ha eliminado el stack trace para no mostrar detalles del error
	    }

	    return copiado;
	}//COPIAR


	// MOVER FICHERO
	/*si el fichero de destino ya existe, se elimina antes de mover el fichero original*/
	protected boolean mover(String origen, String destino) {
	    boolean movido = false;
	    Path original = Paths.get(origen);
	    Path copia = Paths.get(destino);
	    try {
	        if (Files.exists(copia)) {
	            System.out.println("El fichero de destino ya existe. Se procederá a eliminarlo.");
	            Files.delete(copia);  // Elimina el fichero de destino si ya existe
	            System.out.println("Fichero de destino eliminado correctamente.");
	        }
	        Files.move(original, copia, StandardCopyOption.REPLACE_EXISTING);  // Mueve el fichero
	        movido = true;
	        System.out.println("Se ha movido el fichero " + original + " a " + copia);
	    } catch (IOException e) {
	        System.err.println("No se ha podido mover el fichero.");
	        //se ha borrado el packtracer.. asi no se muestra el cach, si no el sysout
	    }
	    return movido;
	}//MOVER

	
	
	// ELIMINAR FICHERO O DIRECTORIO - NOS PIDE QUE ESCRIBAMOS EL NOMBRE DEL FICHERO A ELIMINAR
	protected boolean eliminar(String nombre) {
	    boolean eliminado = false;
	    File fichero = new File(nombre);
	    Scanner scanner = new Scanner(System.in);

	    if (fichero.exists()) {
	        System.out.print("El fichero o directorio \"" + fichero + "\" existe. Para eliminarlo, ingrese el nombre exacto y presione ENTER: ");
	        String nombreUsuario = scanner.nextLine(); // Leer el nombre ingresado por el usuario

	        if (nombreUsuario.equals(nombre)) { // Comprobar si el nombre ingresado coincide
	            if (fichero.delete()) {
	                System.out.println("Eliminado el fichero o directorio " + fichero);
	                eliminado = true;
	            } else {
	                System.out.println("No se ha podido eliminar el fichero o directorio.");
	            }
	        } else {
	            System.out.println("El nombre ingresado no coincide. No se eliminará el fichero o directorio.");
	        }
	    } else {
	        System.out.println("El fichero o directorio " + nombre + " no existe.");
	    }
	    
	    return eliminado;
	}

}
