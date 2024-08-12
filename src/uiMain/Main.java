/**
 * Este módulo pertenece al paquete 'uiMain' y contiene la clase 'Main'.
 * 
 * Proporciona la funcionalidad para mostrar el menú principal de la aplicación.
 * 
 * Permite al usuario navegar entre las diferentes opciones del sistema.
 * 
 * AUTORES: - Sebastian Estrada Villa
 *          - Valentina Luján Robledo
 *          - Santiago Ochoa Quintero
 */

package uiMain;

import java.util.Scanner;
 
import baseDatos.Cargar;
 
 
/**
  * La clase 'Main' gestiona el menú principal de la aplicación.
  * 
  * Proporciona métodos para mostrar el menú y manejar las selecciones del usuario.
  */
 
public class Main {
     
    static Scanner sc = new Scanner(System.in);
     
     
    /**
      * Método principal para gestionar el menú de la aplicación.
      * 
      * Permite al usuario navegar entre las diferentes opciones del sistema.
      * 
      * @param args Argumentos de la línea de comandos
      */
 
    public static void main(String[] args) {
 
        Cargar.cargar();
 
        int opcion;
         
        do{
            System.out.println("\nMenú principal Delicia Fresca\n");
            System.out.println("Ingrese el número de la opción que desea utilizar");
            System.out.println("1. Envio pedidos");
            System.out.println("2. Pago de nomina");
            System.out.println("3. Proveer tiendas");
            System.out.println("4. Devoluciones de productos");
            System.out.println("5. Evaluación operación");
            System.out.println("6. Salir\n");
            System.out.print("> ");
            opcion = sc.nextInt();
 
 
            switch(opcion){
 
                case 1:
 
                    EnvioPedidos.envioPedidos();
                    break;
 
 
                case 2:
 
                    PagoDeNomina.pagoDeNomina();
                    break;
 
 
                case 3:
 
                    ProveerTiendas.proveerTiendas();
                    break;
 
 
                case 4:
 
                    DevolucionDeProductos.devolucionDeProductos();
                    break;
 
 
                case 5:
                    EvaluacionOperacion.evaluacionOperacion();
                    break;
 
 
                case 6:
 
                    Cargar.guardar();
 
                    System.out.println("Gracias por visitarnos");
                    System.out.println("Vuelva pronto");
 
                    break;
                    
                     
                default: // Si ingresa un número diferente al de las opciones mencionadas
                    System.out.println("\nDigitó una opción incorrecta");
                     
            }
 
 
        } while(opcion != 6);
     
    }
}