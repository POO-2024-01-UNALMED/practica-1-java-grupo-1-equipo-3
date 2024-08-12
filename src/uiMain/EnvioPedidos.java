/**
 * Este módulo pertenece al paquete 'uiMain' y contiene la clase 'EnvioPedidos'.
 * 
 * Proporciona la funcionalidad para gestionar el envío de pedidos desde las tiendas a los clientes.
 * 
 * Permite seleccionar un cliente, una tienda, productos a enviar, y el transporte para realizar el envío.
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo, 
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


package uiMain;

import java.util.Scanner;
import java.util.ArrayList;
 
import baseDatos.Cargar;
import gestorAplicacion.empresa.Tienda;
import gestorAplicacion.externo.Cliente;
import gestorAplicacion.externo.TipoTransporte;
import gestorAplicacion.externo.Transporte;
import gestorAplicacion.empresa.Producto;
 
 
/**
  * La clase 'EnvioPedidos' gestiona el envío de pedidos desde las tiendas a los clientes.
  * 
  * Proporciona un método principal que guía al usuario a través del proceso de seleccionar un cliente,
  * una tienda, productos a enviar, y el transporte para realizar el envío.
  */
 
public class EnvioPedidos  {

   public static void envioPedidos() { 

   // Atributos a usar
   int x = 1; // para manejar el menu
   int eleccion = 1; 
   int numProductoSeleccionado = 1;
   Scanner sc = new Scanner(System.in);
   Scanner sc2 = new Scanner(System.in);

   Boolean interruptor = true; // Para manejar el ciclo while
   Cliente clienteSeleccionado = null;
   Tienda tiendaSeleccionada = null;
   Producto productoSeleccionado = null;
   Transporte transporteSeleccionado = null;
   TipoTransporte tipoTransportes = null;
   int PesoTotalProductos = 0;
   int numEnvioGratis=0;
   ArrayList<Producto> listaProductosPedidos = new ArrayList<Producto>();
 
         // Manejo de opciones
         while (interruptor) {
 
            switch (eleccion) {
                 
               case 0:
               interruptor = false;
               System.out.println("Has vuelto al menú anterior");
               break;


               case 1: // Seleccionar cliente
                    
               System.out.print("\nSeleccione el cliente al que desea enviar: \n");
               System.out.println("0. Volver al menu anterior \n");
               System.out.println(Cliente.mostrarClientes());

               // Entero seleccionado
               System.out.print("> ");
               int numClienteSeleccionado = sc.nextInt(); // Pregunta al usuario
               
               if (numClienteSeleccionado == 0) { // Volver al menú anterior
                   
                   eleccion = 0;
                   break;

               }

               if (numClienteSeleccionado > Cliente.getListaClientes().size()) { // Número de cliente mayor a la cantidad de clientes registrados

                   System.out.println("Número de cliente inválido, por favor seleccione un cliente en la lista");
                   eleccion = 1;
                   break;

               } else {

                   clienteSeleccionado = Cliente.getListaClientes().get(numClienteSeleccionado - 1);
                   System.out.print("Has seleccionado al cliente #" + numClienteSeleccionado + "\nEl cliente es: "
                           + clienteSeleccionado.getNombre());
                   eleccion = 2;

               }


               break;
 
 
               case 2: 
               break;



               case 3: 
                     break;



               case 4: 
               break;

      

               case 5: 
                             
                  break;


   }
  }
}
}