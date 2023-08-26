/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umariana.proyecto;
//librerias usadas
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import mundo.Alumno;

/**
 *
 * @author esney
 */
public class Proyecto {
    /** quiero aclarar que mi codigo esta documentado a manera que yo entiendo por lo que no especifique del todo los procesos,
    *   ademas es facil uwu
    */
    
    public static void main (String [] args){
        Scanner lector = new Scanner (System.in); 
        //el array que de los alumnos
        ArrayList<Alumno> misAlumnos = new ArrayList<>();
        //leer archivo usado para leer los alumnos del txt
        leerArchivo (misAlumnos);
       //bandera 
        boolean activo = true;
        
        do{  
            //metodo del menu parte1
           menu();
           int opcion = lector.nextInt();
           //next line para que haga los espaciados 
           lector.nextLine();     
            switch (opcion) {
                //agrega el nuevo alumno
                case 1:
                    //caso uno donde se agregan los alumnos con sus datos
                    insertarAlumno(misAlumnos, lector);
                    //la escritura de archivos para que se guarde en el txt lo que se registro del alumno
                    escribirArchivo(misAlumnos);
                    break;                   
                case 2:
                    //caso dos que permite eliminar alumnos con el metodo usando sus parametros
                    eliminarAlumno(misAlumnos, lector);
                    //la escritura de archivos para que se en el txt los datos del alumno
                    escribirArchivo(misAlumnos);
                break;
                case 3:
                    //caso tres hace que los datos del alumno sean modificados y guardados
                    modificarAlumno (misAlumnos, lector);
                    //la escritura de archivos para que se en el txt los datos del alumno
                    escribirArchivo(misAlumnos);
                    break;       
                case 4:
                    //caso cuatro hace que los datos del alumno sean mostrados por los parametros y el metodo
                    consultarAlumno (misAlumnos, lector);
                    //la escritura de archivos para que se en el txt los datos del alumno
                    escribirArchivo(misAlumnos);
                    break;                    
                case 5:                
                    //despedida para el usuario + creditos y tales uwu
                    System.out.println("Gracias por usar nuestro sistemaaa :3 ");
                    System.out.println("Creditos para esneyder pro estrato 5  ");
                    //bandera para que se termine el bucle 
                    activo = false;
                    break;
                default:
                    //si se ingresa un numero fuera del rango de 1-6 
                    System.out.println("|--------------------------------------|"); 
                    System.out.println("|   Selecciona una lista del menuuu    |");
                    System.out.println("|--------------------------------------|"); 
                    break;
            }       
        }
        while (activo);
    }
    /**
     * iniciamos con el metodo que controlara el menu y sus opciones
     */
    public static void menu (){
        //menu bien estetico y unico en su clase
        System.out.println("----------------------------------------"); 
        System.out.println("|                 Menu                  |");
        System.out.println("|         1. Insertar alumno            |");
        System.out.println("|         2. Eliminar alumno            |");
        System.out.println("|         3. Modificar alumno           |");
        System.out.println("|         4. Consultar alumno           |");
        System.out.println("|         5. Terminar programa          |");
        System.out.println("|---------------------------------------|"); 
    }
    //caso 1
    /**
     * metodo numero uno para ingresar los datos del alumno
     * @param misAlumnos
     * @param lector 
     */
    public static void insertarAlumno(ArrayList<Alumno> misAlumnos,Scanner lector ){
            System.out.println("|      Ingresa el nombre del alumno     |");
            String nombre = lector.nextLine();                    
            System.out.println("|      Ingresa el apellido del alumno   |");
            String apellido = lector.nextLine();                    
            System.out.println("|      Ingresa el correo del alumno     |");
            String correo = lector.nextLine();                   
            System.out.println("|      Ingresa el celular del alumno    |");
            //cambiaamos a float la cedula y el celular pq salia error al ingresar varios numeros
            float celular = lector.nextFloat();                   
            System.out.println("|      Ingresa la cedula del alumno     |");
            float cedula = lector.nextFloat();                 
            System.out.println("|      Ingresa el semestre del alumno   |");
            int semestre = lector.nextInt();
            //se guarda aqui el alumno y sus datos
            Alumno a = new Alumno();
            a.setNombre(nombre);
            a.setApellido(apellido);
            a.setCorreo(correo);
            a.setCelular(celular);
            a.setCedula(cedula);          
            a.setSemestre(semestre);
            misAlumnos.add(a);
        
    }
    //caso 2
    /**
     * creacion del metodo para eiminar un alumno con sus datos y tales, algo simple
     * @param misAlumnos 
     * @param lector 
     */
    public static void eliminarAlumno (ArrayList<Alumno> misAlumnos, Scanner lector){
        //esta condicion la veremos en los demas casos para complementar y hacerlo mejor
        //si no hay alumnos registreados abre este if pero si si hay alumnos no abre y te manda al else
        if (misAlumnos.isEmpty()){
            System.out.println("|---------------------------------------|");                                            
            System.out.println("|    Aun no hay alumnos registrados.    |");
            System.out.println("|---------------------------------------|");                    
        }else{
            //pide que busquemos al alumno por cedula mas facil asi
            System.out.println("Ingresa la cedula del alumno a eliminar:");
            int cedulaDelete = lector.nextInt();
            //si hay alumnoi con esa cedula ingresa al for  e inicia con la bandera esta
            boolean alumnoEncontrado = false; 
            for (Alumno alumno : misAlumnos) {
                if (alumno.getCedula() == cedulaDelete) {
                    alumnoEncontrado = true;
                    //hace que el alumno sea eliminado del registro
                    misAlumnos.remove(alumno);
                    System.out.println("----------------------------------------"); 
                    System.out.println("    El alumno ha sido eliminado         ");
                    System.out.println("----------------------------------------");
                    break; 
                }
            }
        }
    }
    //caso 3
    /**
     * creamos el metodo que modifica los datos del alumno para asi 
     * @param misAlumnos
     * @param lector 
     */
    public static void modificarAlumno (ArrayList<Alumno> misAlumnos, Scanner lector){
        //este if verifica si no hay datos en los reportes saldra una exception o algo asi
       if (misAlumnos.isEmpty()){
            System.out.println("Aun no hay alumnos registrados.");
        }else{
           //se busca al alumno por su cedula para mejor usabilidad
           System.out.println("Ingresa la cedula del alumno a modificar.");
           float cedulaModificar = lector.nextFloat();
           //corrobora al alumno con esa cedula se activa
           boolean alumnoEncontrado = false; 
           
           for (Alumno alumno : misAlumnos) {
               if (alumno.getCedula() == cedulaModificar) {
                   //si se encuentra alumno entra
                   alumnoEncontrado = true; 
                   lector.nextLine();
                   // se modifica la info del alumno
                   System.out.println("Ingrese el nuevo nombre:");
                   String nuevoNombre = lector.nextLine();
                   System.out.println("Ingrese el nuevo apellido:");
                   String nuevoApellido = lector.nextLine();
                   System.out.println("Ingresa el nuevo correo");
                   String nuevoCorreo = lector.nextLine();
                   System.out.println("Ingresa el nuevo celular");
                   float nuevoCelular = lector.nextFloat();
                   System.out.println("Ingresa la nueva cedula");
                   float nuevoCedula = lector.nextFloat();
                   System.out.println("Ingresa el nuevo semestre");
                   int nuevoSemestre = lector.nextInt();
                   
                   //se actualiza la info del alumno
                   alumno.setNombre(nuevoNombre);
                   alumno.setApellido(nuevoApellido);
                   alumno.setCorreo(nuevoCorreo);
                   alumno.setCelular(nuevoCelular);
                   alumno.setCedula(nuevoCedula);
                   alumno.setSemestre(nuevoSemestre);
                   System.out.println("----------------------------------------"); 
                   System.out.println(" La informacion del alumno se modifico. ");
                   System.out.println("----------------------------------------");                             
                   break;
               }
           }
       }         
    }
//caso 4
    public static void consultarAlumno(ArrayList<Alumno> misAlumnos, Scanner lector){
        // muestra el alumno con sus datos con un for pero primero va un if que indica si no hay registros
        //if que revisa si no hay alumnos
        if (misAlumnos.isEmpty()){
            System.out.println("|---------------------------------------|");                    
            System.out.println("|    Aun no hay alumnos registrados.    |");
            System.out.println("|---------------------------------------|");                    
            
        }else{    
            System.out.println("|---------------------------------------|");                    
            System.out.println("|Esta es la lista de alumnos registrados|");  
            System.out.println("|---------------------------------------|");                               
            for (Alumno alumno : misAlumnos){
                System.out.println("|---------------------------------------|");                    
                System.out.println("|             Nombre: " + alumno.getNombre());
                System.out.println("|             Apellido: "+ alumno.getApellido());
                System.out.println("|             Correo: "+ alumno.getCorreo());
                System.out.println("|             Celular: "+ alumno.getCelular());
                System.out.println("|             Cedula: "+ alumno.getCedula());
                System.out.println("|             Semestre: "+ alumno.getSemestre());
                System.out.println("|---------------------------------------|"); 
            }  
        }
    }
    /**
     * este metodo hace que sea posible la escritura de archivos, o sea que los datos del alumno  se guarden en el txt
     * @param misAlumnos 
     */
    public static void escribirArchivo(ArrayList<Alumno> misAlumnos){      
        try {
            //los datos se almacenaran en la ruta que esta aqui en este metodo file
            File archivo = new File("./data/miReporte.txt");
            PrintWriter pluma = new PrintWriter (archivo);            
            for (Alumno alumno : misAlumnos) {
                String alumnoData = alumno.getNombre() + "," + alumno.getApellido() + ","
                        + alumno.getCorreo() + "," + alumno.getCelular() + ","
                        + alumno.getCedula() + "," + alumno.getSemestre();
                pluma.println(alumnoData);
            }
            pluma.close();
            System.out.println("|---------------------------------------|"); 
            System.out.println("|Datos de alumnos guardados exitosamente|");
            System.out.println("|---------------------------------------|"); 

        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }        
    }
    /**
     * metodo que hace que funcione la lectura de archivos, haciendo que se pueda indicar el txt
     * @param misAlumnos 
     */
    public static void leerArchivo(ArrayList<Alumno> misAlumnos){
        try {                        
            //agarra la ruta del txt. tiqui
            File archivo = new File("./data/miReporte.txt");
            FileReader fr = new FileReader (archivo);
            BufferedReader lector = new BufferedReader(fr);            
            String linea;
            //usamos el split con un array para que haga las separaciones usando la coma y tales
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                String Nombre = datos[0];
                String Apellido = datos[1];
                String Correo = datos[2];
                float Celular = Float.parseFloat(datos[3]);
                float Cedula = Float.parseFloat(datos[4]);
                int Semestre = Integer.parseInt(datos[5]);    
                //aca se guardaran los datos de los alumnos
                Alumno alumno = new Alumno (Nombre, Apellido, Correo, Celular, Cedula, Semestre);
                misAlumnos.add(alumno);
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
    //FINALIZADDOOOOOOOOOOOOOOOOO AMEEEEEEEEEEEN, MESTRESE LO SUFICIENTE ESTE PRIMER CORTE.
      
