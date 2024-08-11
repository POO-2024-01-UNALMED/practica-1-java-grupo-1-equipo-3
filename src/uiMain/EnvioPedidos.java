/**
 * Este módulo pertenece al paquete 'uiMain' y contiene la clase 'ProveerTiendas'.
 * 
 * Proporciona la funcionalidad para gestionar el suministro de productos a las tiendas.
 * 
 * Permite seleccionar tiendas, productos, y tipos de transporte para realizar el suministro.
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo, 
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import baseDatos.Cargar;
import gestorAplicacion.empresa.Producto;
import gestorAplicacion.empresa.Tienda;
import gestorAplicacion.externo.Parejas;
import gestorAplicacion.externo.TipoTransporte;
import gestorAplicacion.externo.Transporte;
 
 
 /**
  * La clase 'ProveerTiendas' gestiona el suministro de productos a las tiendas.
  * 
  * Proporciona métodos para seleccionar tiendas, productos, y tipos de transporte, y realizar el suministro.
  */
 
public class ProveerTiendas {
    
     
      public static void proveerTiendas() {
 
         // Atributos a usar
         int x = 1; // Para manejar el menu
         int eleccion = 1;
         int escanerInt = 1;
         int y = 1; // Para manejar el menu
         int eleccion2 = 1;
         int escanerInt2 = 1;
         int z = 1; // Para manejar el menu
         int eleccion3 = 1;
         int escanerInt3 = 1;
 
         Scanner escaner1 = new Scanner(System.in);
         Scanner escaner2 = new Scanner(System.in);
 
         Boolean interruptor = true;
         Tienda tiendaSeleccionada = null;
         Producto productoSeleccionado = null;
         Transporte transporteSeleccionado=null;
         ArrayList<Producto> listaDeProductos;
 
         // Manejo de opciones
         while (interruptor) {
 
            switch (eleccion) {
                 
                  case 0: {
 
                     interruptor = false;
                     break;
                 }
 
 
                 case 1:
 
                     // Visto en pantalla
                     System.out.println("\n");
                     System.out.println("Proveer tiendas - Apartado de tiendas");
                     System.out.println("\n0. Volver al menu anterior\n");
                     System.out.print(Cargar.fabrica.mostrarTiendas());
                     // Seleccionar tienda
                     System.out.print("Seleccione la tienda a la que desea enviar: ");
                     // Entero seleccionado
                     x = escaner1.nextInt();
 
 
                     while (interruptor) {
                         // Se establece el intervalo en el que estan las tiendas
                        if (x == 0) {
 
                           eleccion = 0;
                           break;
                        }
 
                        if (x > 0 && x <= Cargar.fabrica.getListaTienda().size()) {
 
                           tiendaSeleccionada = Cargar.fabrica.getListaTienda().get(x - 1);
                           eleccion = 2;
                           break;
 
                        } else if (x != 0) {
 
                           System.out.print("Por favor seleccione una tienda dentro del rango: ");
                           x = escaner1.nextInt();
 
                        }
                     }
 
                     break;

                  case 2:
                     System.out.println("");

                     



                     break;
 
 
            }
 
         }
 
   }
 }
