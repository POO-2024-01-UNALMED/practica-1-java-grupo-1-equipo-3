/**
 * Este módulo pertenece al paquete 'gestorAplicacion.externo' y contiene la clase 'Cliente' que representa a los clientes que compran productos 
 * en las diferentes tiendas. 
 * 
 * Esta clase implementa la interfaz 'Moda'.
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo, 
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


package gestorAplicacion.externo;

import java.io.Serializable;
import java.util.ArrayList;
 
import gestorAplicacion.empresa.Moda;
import gestorAplicacion.empresa.Producto;
 
 
/**
  * La clase 'Cliente' representa un cliente de la empresa.
  * 
  * Contiene información sobre el nombre, dirección, cuenta bancaria y los productos adquiridos por el cliente.
  * 
  * Proporciona métodos para gestionar estos atributos y para mostrar y seleccionar clientes.
  * 
  * Funcionalidades en las que se usa:
  *      - Envio pedidos
  */
 
public class Cliente implements Moda, Serializable {
     
    // ATRIBUTOS ----------------------------------------------------------------------------------------------------------------------------------------------------
     
    // De clase 
    private static final long serialVersionUID = 1L; // Versión del serializado asociada a esta clase
    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
     
    // De instancia
    private String nombre; 
    private String direccion;
    private CuentaBancaria cuentaBancaria;
    private ArrayList<Producto> productos = new ArrayList<Producto>();
 
 
    // CONSTRUCTORES ------------------------------------------------------------------------------------------------------------------------------------------------------------
 
    /**
      * Constructor que recibe todos los parámetros.
      * 
      * @param nombre Nombre del cliente
      * 
      * @param direccion Dirección del cliente
      * 
      * @param cuentaBancaria Cuenta bancaria del cliente
      */
 
    public Cliente(String nombre, String direccion, CuentaBancaria cuentaBancaria) {
         
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentaBancaria = cuentaBancaria;
        listaClientes.add(this);
    }
 
 
    /**
      * Constructor sin parámetros.
      */
 
    public Cliente() {}
 
 
 
    // MÉTODOS ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     
 
    /**
      * Muestra todos los objetos de tipo Cliente que han sido creados.
      * 
      * @return Una cadena de texto con información sobre todos los clientes creados.
      * 
      * Funcionalidades en las que se usa: Envio pedidos
      */
 
    public static String mostrarClientes() {
         
        String mensaje = "";
        int numero = 1;
         
        for(Cliente cliente:listaClientes) {
            if (!mensaje.contains(cliente.getNombre())){
            mensaje += numero + ". " + cliente +"\n"; 
            numero++;
            }
        }
         
        return mensaje;
    }
 
 
 
    /**
      * Permite que se elija alguno de los objetos tipo Cliente que han sido creados para interactuar con él.
      * 
      * @param indice Índice del cliente a seleccionar (indice - 1).
      * 
      * @return El cliente seleccionado correspondiente al índice proporcionado, o null si el índice no es válido.
      */
 
    public static Cliente seleccionarCliente(int indice) {
         
        if (indice-1 >= 0 && indice <= listaClientes.size()) {
            return listaClientes.get(indice);
        } else {
            return null;
        }
    }
 
 
 
    /**
      * Genera una representación en cadena del objeto Cliente.
      * 
      * @return Una cadena de texto con la información del cliente, incluyendo nombre y dirección.
      */
 
    public String toString() {
         
        return this.getNombre() + " Dirección: " + this.getDireccion();
    }
 
 
 
    // GETTERS Y SETTERS -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     
     
    public String getNombre() { // De la interfaz Moda
         
        return nombre;
    }
 
     
    public void setNombre(String nombre) {
         
        this.nombre = nombre;
    }
 
     
    public String getDireccion() {
         
        return direccion;
    }
 
     
    public void setDireccion(String direccion) {
         
        this.direccion = direccion;
    }
 
     
    public CuentaBancaria getCuentaBancaria() {
         
        return cuentaBancaria;
    }
     
     
    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
         
        this.cuentaBancaria = cuentaBancaria;
    }
 
     
    public ArrayList<Producto> getProductos() {
         
        if (productos == null) {
             
            productos = new ArrayList<Producto>();
        }
 
        return productos;
    }
     
 
    public void setProductos(ArrayList<Producto> productos) {
         
        this.productos = productos;
    }
 
     
    public static ArrayList<Cliente> getListaClientes() {
         
        return listaClientes;
    }
 
     
    public static void setListaClientes(ArrayList<Cliente> listaClientes) {
        
        Cliente.listaClientes = listaClientes;
    }
}
 