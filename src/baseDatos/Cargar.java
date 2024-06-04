package baseDatos;
import java.util.ArrayList;
import java.util.HashMap;

import gestorAplicacion.empleados.Transportador;
import gestorAplicacion.empleados.Vendedor;
import gestorAplicacion.empresa.Fabrica;
import gestorAplicacion.empresa.Factura;
import gestorAplicacion.empresa.Moda;
import gestorAplicacion.empresa.Producto;
import gestorAplicacion.empresa.Tienda;
import gestorAplicacion.externo.Cliente;
import gestorAplicacion.externo.Transporte;
public class Cargar {
    public static ArrayList<Producto> catalogo = new ArrayList<Producto>();
    public static ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
    public static ArrayList<Factura> facturas = new ArrayList<Factura>();
    public static ArrayList<Transportador> transportadores = new ArrayList<Transportador>();
    public static HashMap<String, Moda> infoAtributos = new HashMap<String,Moda>();
    public static Fabrica fabrica;
    public static Transporte transporteAbastecer;


    public static void guardar(){

        facturas = Factura.getListaFacturas();
        
        clientes = Cliente.getListaClientes();
        
        catalogo = Producto.getListaProductos();
        
        transportadores = Transportador.getListaTransportadores();
        
        infoAtributos = Factura.getInfoAtributos();
  

        Serializador.guardarTiendas();
        
        Serializador.guardarCatalogo();
        
        Serializador.guardarFabrica();
        
        Serializador.guardarFacturas();
        
        Serializador.guardarTransporte();
        
        Serializador.guardarVendedores();
        
        Serializador.guardarClientes();
        
        Serializador.guardarTransportadores();
        
        Serializador.guardarAtributos();
    }
  

    public static void cargar(){
  
        try{
  
        tiendas =  Deserializador.cargarTiendas();
        
        catalogo = Deserializador.cargarCatalogo();
        
        fabrica = Deserializador.cargarFabrica();
        
        clientes = Deserializador.cargarClientes();
        
        transporteAbastecer = Deserializador.cargarTransporte();
        
        vendedores =  Deserializador.cargarVendedores();
        
        facturas =  Deserializador.cargarFacturas();
        
        transportadores = Deserializador.cargarTransportadores();
         
        infoAtributos = Deserializador.cargaAtributos();
  

        Factura.setListaFacturas(facturas);
        
        Cliente.setListaClientes(clientes);
        
        Producto.setListaProductos(catalogo);
        
        Transportador.setListaTransportadores(transportadores);
        
        Factura.setInfoAtributos(infoAtributos);
  

        }catch(Exception e){
          
            System.out.println("Ha ocurrido un error en la deserialización");
            
            e.printStackTrace();
        }
      }
}
