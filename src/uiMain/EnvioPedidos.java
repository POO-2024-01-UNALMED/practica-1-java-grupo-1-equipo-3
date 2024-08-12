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
                // seleccionar la tienda

                System.out.println("\n");
                System.out.println("Su pedido se enviará desde alguna de estas tiendas, por favor seleccione una:");
                System.out.println("0. Volver al menu principal");
                System.out.print(Cargar.fabrica.mostrarTiendas());

                // Seleccionar tienda
                System.out.println("Seleccione la tienda desde la que desea enviar: ");

                // Entero seleccionado
                System.out.print("> ");
                int numTiendaSeleccionada = sc.nextInt();
                
                if (numTiendaSeleccionada == 0) { // Volver al menú principal
                    
                    eleccion = 0;
                    break;

                }

                else if (numTiendaSeleccionada > Cargar.fabrica.getListaTienda().size() || numTiendaSeleccionada < 0) { // Una condición o la otra (ó) - Cuando el numero ingresado esta por fuera del rango
                    
                    System.out.println("Número de tienda inválido, por favor seleccione una tienda en la lista");
                    eleccion = 2;
                    break;

                } else { // Número ingresado es válido

                    tiendaSeleccionada = Cargar.fabrica.getListaTienda().get(numTiendaSeleccionada - 1);
                    System.out.println("Has seleccionado la tienda: " + numTiendaSeleccionada);
                    eleccion = 3;

                }
               break;



               case 3: 
               // seleccionar el producto

               System.out.println("¿Cuantos productos deseas comprar de esta tienda? \n Máximo 5 productos por cliente");
               int cuantos = sc.nextInt();
               
               if (cuantos > 5 || cuantos < 0){ // Número fuera del rango entre 0 y 5
                   
                   System.out.println("No es válido, elija un numero menor o igual a 5");
                   eleccion = 3;
                   break;

               }

               if (cuantos > tiendaSeleccionada.getListaProductos().size()){ // Se quieren comprar más productos de los que estan disponibles
                   
                   System.out.println("***La tienda de la que quieres comprar solo tiene " + tiendaSeleccionada.getListaProductos().size() +
                   ". Entonces te dejaremos comprar " + tiendaSeleccionada.getListaProductos().size() + " productos.");
                   
                   cuantos = tiendaSeleccionada.getListaProductos().size();

               }

               if (cuantos <= 5 && cuantos > 0){ // Número dentro del rango de 0 a 5 (Rango permitido)
               
                   for (int i = 0; i < cuantos; i++){
                   
                   System.out.println("\nSeleccione el producto que desea enviarle al cliente");
                   System.out.println("0. Regresar al menu principal");
                   System.out.println(tiendaSeleccionada.cantidadProductosVentas());
                   System.out.print("> ");
                   numProductoSeleccionado = sc.nextInt(); // Se pregunta al usuario
                   // Se establece el intervalo en el que estan los productos

                   if (numProductoSeleccionado == 0) { // Volver al menú anterior 
                       
                       eleccion = 0;
                       break;

                   }

                   if (numProductoSeleccionado > tiendaSeleccionada.getListaProductos().size() || numProductoSeleccionado < 0) { // Una condición o la otra (ó) - Cuando el numero ingresado esta por fuera del rango
                       
                       System.out.println("Número de producto inválido, por favor seleccione un producto en la lista");
                       cuantos++;

                   } else { // El número ingresado es válido

                       productoSeleccionado = tiendaSeleccionada.getListaProductos().get(numProductoSeleccionado - 1);
                       System.out.print("Ha seleccionado el producto # " + numProductoSeleccionado + " Nombre del producto: " + productoSeleccionado.getNombre());
                       listaProductosPedidos.add(productoSeleccionado);
                       tiendaSeleccionada.venderProducto(productoSeleccionado);
                       PesoTotalProductos += productoSeleccionado.getPeso();
                       eleccion = 4;

                   }

               }
               break;
           }

                     break;



               case 4: 
               break;

      

               case 5: 
                             
                  break;


   }
  }
}
}