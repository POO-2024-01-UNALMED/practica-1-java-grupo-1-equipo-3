package gestorAplicacion.externo;

import java.util.ArrayList;

import gestorAplicacion.empresa.Moda;
import gestorAplicacion.empresa.Producto;


public class Cliente implements Moda {
    // ATRIBUTOS 
    // De clase 
    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
    // De instancia
    private String nombre; 
    private String direccion;
    private CuentaBancaria cuentaBancaria;
    private ArrayList<Producto> productos;


    // CONSTRUCTORES
    // Constructor que recibe todos los parametros
    public Cliente(String nombre, String direccion, CuentaBancaria cuentaBancaria) {
        
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentaBancaria = cuentaBancaria;
        listaClientes.add(this);
    }

    // Constructor sin parametros
	public Cliente() {}


    // MÉTODOS
    // Muestra todos los objetos de tipo Cliente que han sido creados
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

    // Permite que se elija alguno de los objetos tipo Cliente que han sido creados para interactuar con el 
    public static Cliente seleccionarCliente(int indice) {
        
        if (indice-1 >= 0 && indice <= listaClientes.size()) {
            return listaClientes.get(indice);
        } else {
            return null;
        }
    }

    // definición de lo que se mostrará al imprimir un objeto de tipo Cliente
    public String toString() {
		
        return this.getNombre() + " Dirección: " + this.getDireccion();
	}


    // GETTERS Y SETTERS
    public String getNombre() {
		
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
