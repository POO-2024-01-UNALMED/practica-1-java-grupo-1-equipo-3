/**
 * Este módulo pertenece al paquete 'gestorAplicacion.externo' y contiene la clase 'Transporte' que representa un transporte 
 * con sus atributos y métodos para su manipulación.
 * 
 * Esta clase gestiona el transporte de productos, representando los diferentes medios de transporte que se pueden utilizar 
 * para realizar el transporte de los productos. 
 * 
 * Esta clase implementa la interfaz 'Moda'.
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo, 
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


package gestorAplicacion.externo;

import java.io.Serializable;
import java.util.ArrayList;
 
import gestorAplicacion.empleados.Transportador;
import gestorAplicacion.empresa.Moda;
import gestorAplicacion.empresa.Producto;
import gestorAplicacion.empresa.Tienda;
 
 
/**
  * La clase 'Transporte' representa un medio de transporte dentro de la empresa.
  * 
  * Contiene información sobre el tipo de transporte, su capacidad, costo, transportador asignado, y los productos transportados.
  * 
  * Proporciona métodos para gestionar estos atributos y para realizar operaciones como suministrar productos,
  * mostrar tipos de transporte y enviar productos gratis.
  * 
  * Funcionalidades en las que se usa:
  *      - Envio pedidos
  *      - Proveer tiendas
  */
 
public class Transporte implements Moda, Serializable{
     
    // ATRIBUTOS ------------------------------------------------------------------------------------------------------------------------------------------
     
    // De clase 
    private static final long serialVersionUID = 1L; // Versión del serializado asociada a esta clase
 
    // De instancia
    private TipoTransporte tipo;
    private double capacidad;
    private double costo;
    private Transportador transportador;
    private ArrayList<TipoTransporte> transportes;
    private double precioTransporte;
    private Tienda tienda;
    private ArrayList<Producto> listaProductos;
 
 
    // CONSTRUCTOR -------------------------------------------------------------------------------------------------------------------------------------------------
 
    /**
      * Constructor que recibe todos los parámetros.
      * 
      * @param tipo Tipo de transporte
      * 
      * @param capacidad Capacidad de carga del transporte
      * 
      * @param costo Costo del transporte
      * 
      * @param transportador Transportador asignado al transporte
      */
 
    public Transporte(TipoTransporte tipo, Double capacidad, double costo, Transportador transportador) {
         
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.costo = costo;
        this.transportador = transportador;
    }
 
 
 
    //MÉTODOS --------------------------------------------------------------------------------------------------------------------------------------------------
     
 
    /**
      * Lleva los productos al transporte seleccionado y asigna la tienda a la que se enviarán.
      * 
      * @param tienda Tienda a la que se enviarán los productos
      * 
      * @param listaProductos Lista de productos a transportar
      * 
      * Funcionalidades en las que se usa: Proveer tiendas
      */
 
    public void suministrarProducto(Tienda tienda, ArrayList<Producto> listaProductos){
         
        this.setTienda(tienda);
        this.setListaProductos(listaProductos);
    }
 
 
 
    /**
      * Muestra todos los tipos de transporte, su precio y su capacidad.
      * 
      * @param args Argumentos de la línea de comandos
      * 
      * Funcionalidades en las que se usa: Proveer tiendas
      * 
      */
 
    public static void MostrarTipoTransporte(String[] args) {
         
        TipoTransporte[] transportes = TipoTransporte.values();
         
        for (int i = 0; i < transportes.length; i++) {
            System.out.println(transportes[i]);
        }
 
    }
 
 
     
    /**
      * Genera una cadena de texto con el nombre, precio y capacidad de un tipo de transporte.
      * 
      * @param transporte Tipo de transporte a mostrar
      * 
      * @return Una cadena de texto con la información del tipo de transporte
      */
 
    public String TipoTransporte(TipoTransporte transporte) {
         
        String mensaje = ("Tipo de transporte: " + transporte.name() + 
                           "Precio: " + transporte.getPrecioEnvio_COP() + 
                           "Capacidad máxima: " + transporte.getCapacidad_KG());
         
        return mensaje;
    }
 
 
 
    /**
      * Cambia el valor del envío a 0.
      * 
      * @param transporte Transporte al que se le cambiará el precio del envío
      * 
      * @return El objeto transporte con el precio del envío cambiado a 0
      * 
      * Funcionalidades en las que se usa: Envio pedidos
      */
 
    public static Transporte enviarGratis(Transporte transporte){
         
        transporte.getTipo().setPrecioEnvio_COP(0);
         
        return transporte;
    }
 
 
 
    /**
      * Guarda el valor del precio de envío en la variable precioTransporte.
      * 
      * Funcionalidades en las que se usa: Envio pedidos
      */
 
    public void recordarPrecioTransporte(){
         
        precioTransporte = this.getTipo().getPrecioEnvio_COP();
    }
 
 
 
    /**
      * Guarda en precioEnvio el valor que está en precioTransporte.
      * 
      * Funcionalidades en las que se usa: Envio pedidos
      */
 
    public void reestablecerPrecioTransporte(){
         
        this.getTipo().setPrecioEnvio_COP(precioTransporte);
    }
     
 
 
    // GETTERS Y SETTERS ----------------------------------------------------------------------------------------------------------
 
 
    public TipoTransporte getTipo() {
         
        return tipo;
    }
 
 
    public void setTipo(TipoTransporte tipo) {
         
        this.tipo = tipo;
    }
 
     
    public Double getCapacidad() {
        
        return capacidad;
    }
 
 
    public void setCapacidad(Double capacidad) {
         
        this.capacidad = capacidad;
    }
 
     
    public double getCosto() {
         
        return costo;
    }
 
 
    public void setCosto (double costo) {
        
        this.costo = costo;
    }
 
 
    public Transportador getTransportador() {
         
        return transportador;
    }
 
 
    public void setTransportador(Transportador transportador) {
         
        this.transportador = transportador;
    }
 
 
    public ArrayList<TipoTransporte> getTransportes() {
         
        return transportes;
    }
 
 
    public void setTransportes(ArrayList<TipoTransporte> transportes) {
         
        this.transportes = transportes;
    }
 
 
    public double getPrecioTransporte() {
         
        return precioTransporte;
    }
 
 
    public void setPrecioTransporte(double precioTransporte) {
         
        this.precioTransporte = precioTransporte;
    }
 
 
    public Tienda getTienda() {
        
        return tienda;
    }
 
 
    public void setTienda(Tienda tienda) {
         
        this.tienda = tienda;
    }
 
 
    public ArrayList<Producto> getListaProductos() {
         
        return listaProductos;
    }
 
 
    public void setListaProductos(ArrayList<Producto> listaProductos) {
         
        this.listaProductos = listaProductos;
    }
 
 
    public String getNombre(){ //De la interfaz Moda
         
        return tipo.getNombre();
    }
}
