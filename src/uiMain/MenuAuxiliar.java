/**
 * Este módulo pertenece al paquete 'uiMain' y contiene la clase 'MenuAuxiliar'.
 * 
 * Proporciona la funcionalidad para mostrar menús auxiliares en la aplicación.
 * 
 * Permite al usuario seleccionar opciones dentro de submenús y manejar entradas con límites.
 * 
 * AUTORES: - Sebastian Estrada Villa
 *          - Valentina Luján Robledo
 *          - Santiago Ochoa Quintero
 */

package uiMain;

import java.util.Scanner;


/**
  * La clase 'MenuAuxiliar' gestiona la creación y manejo de menús auxiliares.
  * 
  * Proporciona métodos para mostrar opciones y manejar la entrada del usuario.
  */

public class MenuAuxiliar {
    
    //ATRIBUTOS ---------------------------------------------------------------------------------------------------
    
    // De instancia
    private String[] opciones;
    private int numOpciones;
    private String enunciado;
    private String opcionDefault;


    // CONSTRUCTORES ------------------------------------------------------------------------------------------------
    
    /**
      * Constructor que recibe el enunciado y las opciones del menú.
      * 
      * @param enunciado Título del menú
      * 
      * @param opciones Opciones del menú
      */

    public MenuAuxiliar(String enunciado, String[] opciones){
        
        this.opciones = opciones;
        numOpciones = opciones.length;
        this.enunciado = enunciado;
        opcionDefault = "Cancelar";
    }


    /**
      * Constructor que recibe el enunciado, las opciones del menú y la opción por defecto.
      * 
      * @param enunciado Título del menú
      * 
      * @param opciones Opciones del menú
      * 
      * @param opcionDefault Opción por defecto
      */

    public MenuAuxiliar(String enunciado, String[] opciones, String opcionDefault){
        
        this.opciones = opciones;
        numOpciones = opciones.length;
        this.enunciado = enunciado;
        this.opcionDefault = opcionDefault;
    }



    // MÉTODOS ----------------------------------------------------------------------------------------------------------------------


    /**
      * Muestra el menú y maneja la entrada del usuario.
      * 
      * @return La opción seleccionada por el usuario
      */
    @SuppressWarnings("resource")
	public int mostrar(){

        System.out.println(enunciado + "\n");

        for(int i = 0; i < numOpciones; i++){
            
            System.out.println((i + 1) + ". " + opciones[i]);

        }
        
        System.out.println("0. " +  opcionDefault);

        Scanner sc = new Scanner(System.in);

        System.out.print("> ");

        int input = sc.nextInt();

        while(input < 0 || input > numOpciones){

            System.out.println("El valor ingresado no es válido. Ingreselo nuevamente por favor.");
            System.out.print("> ");
            input = sc.nextInt();
        }

        return input;

    }



    /**
      * Muestra el menú y maneja la entrada del usuario, retornando la opción como cadena.
      * 
      * @return La opción seleccionada por el usuario como cadena en mayúsculas
      */
    @SuppressWarnings("resource")
	public String mostrarReturnString(){

        System.out.println(enunciado + "\n");

        for(int i = 0; i < numOpciones; i++){
            
            System.out.println((i + 1) + ". " + opciones[i]);
            
        }

        System.out.println("0. Cancelar");

        Scanner sc = new Scanner(System.in);

        System.out.print("> ");

        int input = sc.nextInt();

        while(input < 0 || input > numOpciones){

            System.out.println("El valor ingresado no es válido. Ingreselo nuevamente por favor.");
            System.out.print("> ");
            input = sc.nextInt();
        }

        if(input == 0){
            return "Volver al inicio".toUpperCase();
        }

        return opciones[input - 1].toUpperCase();

    }



    /**
      * Permite ingresar un valor dentro de los límites especificados.
      * 
      * @param limite1 Límite inferior
      * 
      * @param limite2 Límite superior
      * 
      * @return El valor ingresado por el usuario dentro de los límites
      */
    
    @SuppressWarnings("resource")
	public static int ingresarConLimites(int limite1, int limite2){

        System.out.print("\n> ");

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        while(input < limite1 || input > limite2){

            System.out.println("El valor ingresado no es válido. Inténtelo nuevamente por favor");
            System.out.print("\n> ");
            input = sc.nextInt();
        }

        return input;
    }
}
