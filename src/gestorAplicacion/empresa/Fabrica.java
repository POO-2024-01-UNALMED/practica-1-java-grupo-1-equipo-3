/**
 * Este módulo pertenece al paquete 'gestorAplicacion.empresa' y contiene la clase 'Fabrica'. Esta clase es 
 * la encargada de gestionar la producción y el inventario de la fábrica, aquí es donde se da la fabricación 
 * de los productos y su posterior distribución en las diferentes tiendas. 
 * 
 * Esta clase resulta fundamental para el funcionamiento del sistema, ya que es usada por todas las funcionalidades,
 * excepto la de evaluación de operación
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo, 
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


package gestorAplicacion.empresa;

import java.io.Serializable;
import java.util.ArrayList;
 
import gestorAplicacion.empleados.Operario;
import gestorAplicacion.externo.CuentaBancaria;
import gestorAplicacion.externo.Persona;
 
 
/**
  * La clase 'Fabrica' representa una fábrica dentro de la empresa. 
  * Contiene una lista de productos, una lista de tiendas, una cuenta bancaria y un operario.
  * 
  * Proporciona métodos para gestionar estos elementos, como mostrar productos, tiendas y empleados,
  * así como realizar operaciones financieras y seleccionar elementos específicos.
  * 
  * Funcionalidades en las que se usa: 
  *       - Proveer tiendas
  *       - Envio pedidos
  *       - Devolución de productos
  *       - Pago de nomina
  */
 
public class Fabrica implements Serializable{
     
     //ATRIBUTOS-------------------------------------------------------------------------------------------------------------
     
     // De clase 
     private static final long serialVersionUID = 1L; // Versión del serializado asociada a esta clase
 
     // De instancia
     private ArrayList<Producto> listaProductos;
     private ArrayList<Tienda> listaTienda;
     private CuentaBancaria cuentaBancaria;
     private Operario operario;
 
 
     //CONSTRUCTORES----------------------------------------------------------------------------------------------------------------
 
     /**
      * Constructor para cuando el operario ya existe
      *
      * @param listaProductos La lista de productos que maneja la fábrica.
      * 
      * @param listaTienda La lista de tiendas asociadas a la fábrica.
      * 
      * @param cuentaBancaria La cuenta bancaria asociada a la fábrica.
      * 
      * @param operario El operario asignado a la fábrica.
      */
 
     public Fabrica(ArrayList<Producto> listaProductos, ArrayList<Tienda> listaTienda,CuentaBancaria cuentaBancaria, Operario operario) {
         
         // Se llama al otro constructor que recibe estos parametros
         this(listaProductos, listaTienda, cuentaBancaria);
         // Se define el atributo que no esta en el otro constructor
         this.operario = operario;
     }
 
 
     /**
      * Este constructor se usa cuando no hay un operario asignado a la fábrica.
      *
      * @param listaProductos La lista de productos que maneja la fábrica.
      * 
      * @param listaTienda La lista de tiendas asociadas a la fábrica.
      * 
      * @param cuentaBancaria La cuenta bancaria asociada a la fábrica.
      */
 
     public Fabrica(ArrayList<Producto> listaProductos, ArrayList<Tienda> listaTienda,CuentaBancaria cuentaBancaria) {
         
         this.listaProductos = listaProductos;
         this.listaTienda = listaTienda;
         this.cuentaBancaria = cuentaBancaria;
     }
 
 
     /**
      * Constructor sin parámetros que inicializa una nueva instancia de Fabrica.
      * 
      * Este constructor crea una fábrica sin productos, tiendas, cuenta bancaria ni operario.
      */
 
     public Fabrica(){}
 
 
 
     // MÉTODOS--------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
 
     /**
      * Muestra los productos disponibles en la fábrica.
      * 
      * @return Una cadena de texto con información sobre los productos disponibles en la fábrica, 
      *         incluyendo número, nombre, peso, precio y categoría de cada producto.
      * 
      * Funcionalidades en las que se usa: Proveer tiendas
      */
 
     public String mostrarProductos() {
         
         String mensaje = "\nNÚMERO-PRODUCTO-PESO-PRECIO-CATEGORIA\n";
         int numero = 1;
         
         //se recorre la lista para obtener la información de cada producto disponible:
         for(Producto producto:listaProductos) {
             mensaje += numero + ". " + producto.getNombre() + " - " + producto.getPeso() + " - " + producto.getCostoProduccion() + " - " + producto.getCategoria() + "\n";
             numero++;
         }
 
         return mensaje;
     }
 
 
 
     /**
      * Muestra las tiendas disponibles.
      * 
      * @return Una cadena de texto con información sobre las tiendas disponibles, incluyendo número, 
      *         nombre y cantidad de productos de cada tienda.
      * 
      * Funcionalidades en las que se usa: Envio pedidos, Proveer tiendas
      */
 
     public String mostrarTiendas() {
         
         String mensaje = "";
         int numero = 1;
         
         //se recorre la lista para obtener la información de las tiendas:
         for(Tienda tienda:listaTienda) {
             mensaje += numero +". "+tienda.getNombre()+"-Productos: "+tienda.cantidadProductos() + "\n"; //se almacenan todos lo nombres de las tiendas en un string
             numero++;
             if(numero == listaTienda.size());
             mensaje+="\n";
         }
 
         return mensaje;
     }
 
 
 
     /**
      * Permite seleccionar una de las tiendas disponibles.
      * 
      * @param indice Índice de la tienda a seleccionar (indice - 1).
      * 
      * @return La tienda seleccionada correspondiente al índice proporcionado.
      * 
      * Funcionalidades en las que se usa: Envio pedidos.
      */
 
     public Tienda seleccionarTienda(int indice) {
         
         return listaTienda.get(indice - 1);
     }
 
 
     
     /**
      * Descuenta el valor del producto devuelto de la cuenta de la fábrica.
      * 
      * @param productoDevuelto Producto que fue devuelto.
      * 
      * @return El monto descontado de la cuenta de la fábrica por el producto devuelto.
      * 
      * Funcionalidades en las que se usa: Devolucion de productos
      */
 
     public double descontarDinero(Producto productoDevuelto){
         
         double total = productoDevuelto.getValor();
         CuentaBancaria cuentaFabrica = this.getCuentaBancaria();
         cuentaFabrica.disminuirSaldo(total); 
         
         return total;
     }
 
 
 
     /**
      * Muestra información de los empleados en una lista de trabajadores.
      * 
      * @param trabajadores Lista de trabajadores a mostrar.
      * 
      * @return Una cadena de texto con información sobre cada trabajador en la lista.
      * 
      * Funcionalidades en las que se usa: Pago de nomina
      */
 
     public static String mostrarEmpleados(ArrayList<Persona> trabajadores) {
         
         String mensaje = "";
         int numero = 1;
         
         for (Persona i: trabajadores) {
             mensaje += "\n" + "Trabajador "+ numero + i.toString();  //Uso de ligadura dinámica
             numero++;               
         }
 
         return mensaje;
     }
 
 
 
     /**
      * Crea una lista con cierta cantidad de un mismo producto.
      * 
      * @param cantidad Cantidad de productos a crear.
      * 
      * @param producto Producto a replicar en la lista.
      * 
      * @return Una lista de productos con la cantidad especificada.
      * 
      * Funcionalidades en las que se usa: Proveer tiendas
      */
 
     public ArrayList<Producto> cantidadProductos(int cantidad, Producto producto) {
        
         ArrayList<Producto> productos = new ArrayList<>();
         
         for (int i = 0; i < cantidad; i++) {
             productos.add(producto);
         }
         
         return productos;
     }
 
 
 
     /**
      * Busca en las facturas los trabajadores involucrados en los envíos. 
      * Verifica que no se les haya pagado antes (Trabajo mayor a 0).
      * 
      * @param listaFacturas Lista de facturas a revisar.
      * 
      * @param tipo Tipo de trabajador (1: Operario, 2: Transportador, 3: Vendedor).
      * 
      * @return Una lista de personas que son trabajadores involucrados en los envíos.
      * 
      * Funcionalidades en las que se usa: Pago de nomina
      */
 
     public static ArrayList<Persona> TrabajadoresInvolucrados(ArrayList<Factura> listaFacturas, int tipo){
         
         ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
         
         for (Factura factura: listaFacturas){
             if(tipo==1){
                 if (!listaPersonas.contains(factura.getOperario()) && factura.getOperario().getTrabajado()>0 ){
                     listaPersonas.add(factura.getOperario());
                 }
 
             }else if(tipo==2){
                 if (!listaPersonas.contains(factura.getTransporte().getTransportador()) && factura.getTransporte().getTransportador().getTrabajado()>0 ){
                     listaPersonas.add(factura.getTransporte().getTransportador());
                 }
                     
             }else if(tipo==3){
                 if (!listaPersonas.contains(factura.getTienda().getVendedor()) && factura.getTienda().getVendedor().getTrabajado()>0){
                     listaPersonas.add(factura.getTienda().getVendedor());
                 }
             }
         }
         return listaPersonas;
     }
 
 
 
     /**
      * Devuelve una representación en cadena del objeto Fabrica.
      * 
      * @return Una cadena de texto con la información "Fábrica Delicia Fresca".
      */
     
     @Override   
     public String toString() {
         return "Fábrica Delicia Fresca";
     }
 
 
 
     // GETTERS Y SETTERS---------------------------------------------------------------------------------------------------------------------------------------------------
     
     
     public ArrayList<Producto> getListaProductos() {
         
         return listaProductos;
     }
 
     
     public void setListaProductos(ArrayList<Producto> listaProductos) {
         
         this.listaProductos = listaProductos;
     }
 
 
     public ArrayList<Tienda> getListaTienda() {
         
         return listaTienda;
     }
 
 
     public void setListaTienda(ArrayList<Tienda> listaTienda) {
         
         this.listaTienda = listaTienda;
     }
 
 
     public CuentaBancaria getCuentaBancaria() {
         
         return cuentaBancaria;
     }
 
 
     public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
         
         this.cuentaBancaria = cuentaBancaria;
     }
 
 
     public Operario getOperario() {
         
         return operario;
     }
 
 
     public void setOperario(Operario operario) {
         
         this.operario = operario;
     }
}
