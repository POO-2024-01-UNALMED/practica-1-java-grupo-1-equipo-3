package uiMain;

import java.util.Scanner;

import baseDatos.Cargar;
import gestorAplicacion.empresa.Factura;
import gestorAplicacion.empresa.Producto;
import gestorAplicacion.externo.Cliente;

public class DevolucionDeProductos {
    public static void devolucionDeProductos() {

        //Atributos a usar
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Factura facturaSeleccionada = null;
        Producto productoSeleccionado = null;
        boolean condicion = true;
        boolean condicion1 = true;
        boolean condicion2 = true;
        boolean condicion3 = true;
        int eleccion = 1;

        // Manejo de opciones
        while (condicion) {

            switch (eleccion) {

                case 0:
                    
                    condicion = false;
                    break;
                

                case 1:

                    while (condicion1) {
                        String facturas = Factura.mostrarFacturas(); // se almacenan las facturas guardadas en la clase Factura dentro de un String
                        System.out.println("\nPor favor seleccione el número que le corresponda\n" + "a la factura para realizar la devoluciónn\n");
                        System.out.println("0. Volver al menu principal");
                        System.out.println(facturas); // se muestran las facturas en pantalla
                        System.out.println("Digite su opcion: ");
                        System.out.print("--------------------------------------------------------------------");
                        int op = sc.nextInt(); // el usuario ingresa la opción selccionada

                        if (op == 0) { // Volver al menú principal
                            
                            eleccion = 0;
                            condicion1 = false;
                            condicion2 = false;
                            condicion3 = false;
                            break;

                        } else if ((op > 0) && (op <= Factura.getListaFacturas().size())) {

                            facturaSeleccionada = Factura.seleccionarFactura(op);
                            System.out.println("Seleccionó la factura con la opcion número: " + op);
                            eleccion = 2;
                            break;

                        } else {
                            
                            System.out.println("El número que ha ingresado no esta entre las opciones disponibles");
                        }

                    }


                case 2:

                    while (condicion2) {

                        // En este ciclo se revisa si en la factura ya estan todos los productos devueltos
                        // Si estan todos devueltos se le informa al usuario y se le pide ingresar el número de otra factura

                        int contadorDevoluciones = 0; // Conteo de los productos que ya han sido devueltos
                        
                        for (Producto producto : facturaSeleccionada.getListaProductos()) {
                            
                            if (producto.isDevuelto()) {
                                contadorDevoluciones++;
                            }
                        }

                        if (contadorDevoluciones >= facturaSeleccionada.getListaProductos().size()) {
                            System.out.println("En la factura que seleccionó ya se han devuelto todos los productos\n" +
                                    "Por favor digite el Número de otra factura\n");
                            
                            eleccion = 1; // Se vuelve al caso 1 para muestre las facturas de nuevo
                            break;
                        }

                        String productosFactura = Factura.mostrarProductosFactura(facturaSeleccionada.getListaProductos()); // Se guardan los productos de la factura en un string

                        System.out.println("\nPor favor seleccione el número que le corresponda\n" + "a el producto para realizar la devolución\n");
                        System.out.println("0. Volver al menu principal");
                        System.out.println(productosFactura); // se muestran los productos de la factura 
                        System.out.println("Digite su opcion: ");
                        System.out.print("> ");
                        int op2 = sc.nextInt(); // el usuario ingresa la opción selccionada
                        System.out.println("");

                        productoSeleccionado = facturaSeleccionada.seleccionarProductoDevolver(op2);
                        
                        if (op2 == 0) {
                            
                            eleccion = 0;
                            condicion2 = false;
                            condicion3 = false;
                            break;
                            }

                            else if ((op2 > 0) && (op2 <= facturaSeleccionada.getListaProductos().size()) && (!productoSeleccionado.isDevuelto())) {

                                Boolean devolver = true;
                                productoSeleccionado.setDevuelto(devolver);
                                System.out.println("Seleccionó el producto con la opcion número: " + op2);

                                // temporizador para hacer la eliminación del producto
                                try {
                                    
                                    Thread.sleep(500); // Espera medio segundo
                                
                                } catch (InterruptedException e) {
                                    
                                    e.printStackTrace();
                                }

                                System.out.println("Se esta realizando devolución, por favor espere");
                                
                                try {
                                    
                                    Thread.sleep(1000); // Espera 1 segundo
                                
                                } catch (InterruptedException e) {
                                    
                                    e.printStackTrace();
                                }

                                double total = Cargar.fabrica.descontarDinero(productoSeleccionado);

                                Cliente cliente = facturaSeleccionada.getTienda().devolverProducto(facturaSeleccionada, productoSeleccionado);

                                cliente.getCuentaBancaria().devolverDinero(total, cliente);

                                cliente.getProductos().remove(productoSeleccionado); // se elimina el producto que compró el cliente

                                System.out.println("El producto ha sido devuelto");
                                
                                try {
                                    
                                    Thread.sleep(750);

                                } catch (InterruptedException e) {
                                    
                                    e.printStackTrace();
                                }

                                eleccion = 3; // para que entre al ultimo caso
                                break;
                                
                            } else {
                                System.out.println(
                                        "La opcion elegida no es válida o el producto que intenta devolver ya ha sido devuelto");
                            }
                           
                        }
                        break;

                case 3:

                    while (condicion3) {

                        System.out.println("¿Desea hacer otra devolucion o volver al menu principal?\n");
                        System.out.println("0. Volver al menu principal");
                        System.out.println("1. Realizar otra devolución");
                        System.out.print("> ");

                        int opcion = sc2.nextInt();

                        if (opcion == 0) {
                            
                            eleccion = 0;
                            condicion = false;
                            break;

                        } else if (opcion == 1) {
                            
                            eleccion = 1;
                            break;

                        } else {
                            System.out.println("La opcion elegida no es válida ");
                        }
                    }
                    break;

            }
        }

    }
}
