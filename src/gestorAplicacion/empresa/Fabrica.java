package gestorAplicacion.empresa;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.empleados.Operario;
import gestorAplicacion.externo.CuentaBancaria;
import gestorAplicacion.externo.Persona;

public class Fabrica implements Serializable{
    //ATRIBUTOS
    // De instancia
    private static final long serialVersionUID = 1728394; // Versión del serializado asociada a esta clase
    private ArrayList<Producto> listaProductos;
    static private ArrayList<Tienda> listaTienda;
    private CuentaBancaria cuentaBancaria;
    private Operario operario;


    //CONSTRUCTORES
    // Constructor - Si el Operario ya existe
    public Fabrica(ArrayList<Producto> listaProductos, ArrayList<Tienda> listaTienda,CuentaBancaria cuentaBancaria, Operario operario) {
        
        this.listaProductos = listaProductos;
        this.listaTienda = listaTienda;
        this.cuentaBancaria = cuentaBancaria;
        this.operario = operario;
    }

    // Constructor - Si el operario NO existe
    public Fabrica(ArrayList<Producto> listaProductos, ArrayList<Tienda> listaTienda,CuentaBancaria cuentaBancaria) {
        
        this.listaProductos = listaProductos;
        this.listaTienda = listaTienda;
        this.cuentaBancaria = cuentaBancaria;
    }

    // Constructor que no recibe parametros
    public Fabrica(){}


    // MÉTODOS
    //Muestra los productos disponibles en la fábrica
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

    // Muestra las tiendas disponibles
    public static String mostrarTienda() {
        
        String mensaje = "";
		int numero = 1;
		
        //se recorre la lista para obtener la información de las tiendas:
		for(Tienda tienda:listaTienda) {
			mensaje += numero + ". " + tienda.getNombre() + "-PRODUCTOS: " + tienda.cantidadProductos() + "\n";
			numero++;
            if(numero == listaTienda.size());
            mensaje +="\n";
		}

		return mensaje;
    }

    // Permite seleccionar una de las tiendas disponibles
    public static Tienda seleccionarTienda(int indice) {
        
        Tienda tienda = listaTienda.get(indice - 1);
		
        return tienda;
	}

    // Descuenta el valor del producto devuelto de la cuenta de la fabrica
    public double descontarDinero(Producto productoDevuelto){
        
        double total = productoDevuelto.getValor();
        CuentaBancaria cuentaFabrica = getCuentaBancaria();
        cuentaFabrica.disminuirSaldo(total); 
        
        return total;
    }


    public String mostrarEmpleados(ArrayList<Persona> trabajadores) {
        
        String mensaje = "";
        int numero = 1;
        
        for (Persona i: trabajadores) {
            mensaje += "\n" + "Trabajador "+ numero + i.toString();  //Uso de ligadura dinámica
            numero++;               
        }

        return mensaje;
    }

    // Crea una lista con cierta cantidad de un mismo producto
    public ArrayList<Producto> cantidadProductos(Producto producto, int cantidad) {
       
        ArrayList<Producto> productosRequeridos = new ArrayList<>();
        
        for (int i = 0; i < cantidad; i++) {
            productosRequeridos.add(producto);
        }
        
        return productosRequeridos;
    }

    // Busca en las facturas quienes son los trabajadores involucrados en los envios. Se verifica que no se le haya pagado antes (Trabajo mayor a 0)
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

    //Define el mensaje a imprimir cuando se llame al objeto Fabrica     
    @Override   
    public String toString() {
        return "Fábrica Delicia Fresca";
    }


    // GETTERS Y SETTERS
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
