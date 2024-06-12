package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import baseDatos.Cargar;
import gestorAplicacion.empresa.Producto;
import gestorAplicacion.empresa.Tienda;
import gestorAplicacion.externo.TipoTransporte;
import gestorAplicacion.externo.Transporte;

public class ProveerTiendas {
    public static void proveerTiendas() {

        // Atributos a usar
        int x = 1; // Para manejar el menu
        int eleccion = 1;
        int escanerInt = 1;

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
                    System.out.println("Abastecer tiendas - Apartado de tiendas");
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

                    System.out.println("\nAbastecer tiendas - Apartado de productos");
                    System.out.print("\nLa capacidad de productos por categoria para esta tienda es la siguiente: \n");
                    System.out.println(tiendaSeleccionada.productosPorCategoria());
                    System.out.println("\n0. Regresar al menu anterior");
                    System.out.println(Cargar.fabrica.mostrarProductos());
                    System.out.print("Seleccione el producto que desea enviar: ");

                    while (x != 0) {
                        escanerInt = escaner2.nextInt();
                        // Se establece el intervalo en el que estan los productos

                        if (escanerInt == 0) {

                            eleccion = 1;
                            break;
                        }

                        if (escanerInt > 0 && escanerInt <= Cargar.fabrica.getListaProductos().size()) {
                            
                            productoSeleccionado = Cargar.fabrica.getListaProductos().get(escanerInt - 1);
                            eleccion = 3;
                            break;

                        } else {

                            System.out.print("Por favor seleccione un producto dentro del rango: ");
                        }
                    }

                    break;


                case 3: // Cantidad de productos

                    System.out.print("\nEscriba la cantidad de productos que desea abastecer: ");
                    int productoEnTiendaPorCategoria = tiendaSeleccionada.getProductosPorCategoria().get(productoSeleccionado.getCategoria());
                    int productosMaximosEnTiendaPorCategoria = tiendaSeleccionada.getCantidadPorCategoria().get(productoSeleccionado.getCategoria());
                    
                    while (true) {
                        
                        escanerInt = escaner2.nextInt();
                        
                        if (escanerInt == 0){
                            
                            eleccion =1;
                            break;
                        }

                        //Se hace con el fin de evitar que intente mandar mas productos de los que soporta la tienda por la respectiva categoria
                        else if (escanerInt < 0 || escanerInt <= productosMaximosEnTiendaPorCategoria - productoEnTiendaPorCategoria) {
                            
                            eleccion = 4;
                            break;

                        } else {
                            
                            System.out.print("Por favor seleccione una cantidad en el limite de la tienda por categoria: ");
                        }
                    }

                    break;

                    
                case 4: // seleccionar tipo de transporte
                    
                    int PesoTotalProductos = escanerInt * ((int) Math.round(productoSeleccionado.getPeso()));
                    System.out.println("\n\nSeleccione en que medio de transporte quiere enviar este producto");
                    System.out.println(
                            "\nAdvertencia: Los tipos de transporte han sido filtrados de manera que solo puede seleccionar los que puedan soportar el peso de su producto.");

                    System.out.println("0. Regresar al menu anterior");

                    // TipoTransporte tipoTransportes;
                    ArrayList<TipoTransporte> listaTransFiltrada = new ArrayList<TipoTransporte>();
                    listaTransFiltrada = TipoTransporte.transporteSegunCarga(PesoTotalProductos);
                    // System.out.printlnLoad.tipoTransportes.mostrarTipoTransporteSegunCarga(productoSeleccionado));
                    System.out.println(TipoTransporte.mostrarTransporteSegunCarga(listaTransFiltrada));
                    System.out.println("Seleccione el número del tipo de transporte: ");
                    System.out.print("> ");

                    while(true){

                    int numTransporteSeleccionado = escaner2.nextInt();
                    
                    if (numTransporteSeleccionado == 0) {
                        
                        eleccion = 2;
                        break;
                    }

                    if (numTransporteSeleccionado > listaTransFiltrada.size() || numTransporteSeleccionado < 0) {
                        
                        System.out
                                .print("Número de transporte inválido, por favor seleccione un producto en la lista \n> ");
                    }

                    else {
                        
                        transporteSeleccionado = TipoTransporte.seleccionarTransporte(listaTransFiltrada,
                                numTransporteSeleccionado);
                        System.out.print("Ha seleccionado el transporte #" + (numTransporteSeleccionado)
                                + "\nLa tienda se abastecera por: " + transporteSeleccionado.getTipo().getNombre());
                        eleccion = 5;
                        break;
                    }}

                    break;


                case 5:

                    listaDeProductos = Cargar.fabrica.cantidadProductos(escanerInt, productoSeleccionado); // meter los productos en el camion
                    transporteSeleccionado.suministrarProducto(tiendaSeleccionada, listaDeProductos); // Se descargan los productos en la tienda,  luego de comprobar que sea la tienda correcta

                    if (transporteSeleccionado.getTienda().equals(tiendaSeleccionada) == true) {
                        
                        tiendaSeleccionada.descargarProducto(transporteSeleccionado);
                        System.out
                                .println("\nEl producto fue enviado con exito ahora la tienda tiene \nPRODUCTOS: "
                                        + tiendaSeleccionada.cantidadProductos());

                    } else {

                        System.out.println("El envio no se pudo realizar a esa tienda");
                    }

                    // Ciclo final para ver si sale o se reinicia la funcionalidad
                    System.out.println("\n0.Volver al menu principal" + "\n" + "1. Realizar más abastecimientos");
                    System.out.print("> ");

                    while (true) {

                        escanerInt = escaner2.nextInt();
                        
                        if (escanerInt == 0) {
                            
                            eleccion = 0;
                            break;

                        } else if (escanerInt == 1) {
                            
                            eleccion = 1;
                            break;

                        } else {
                            
                            System.out.println("Seleccione una de las opciones disponibles: ");
                        }
                    }
                    break;
            }

        }

    }
}
