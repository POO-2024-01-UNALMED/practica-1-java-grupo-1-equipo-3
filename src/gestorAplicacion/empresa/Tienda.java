package gestorAplicacion.empresa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import gestorAplicacion.empleados.Operario;
import gestorAplicacion.empleados.Vendedor;
import gestorAplicacion.externo.Cliente;
import gestorAplicacion.externo.CuentaBancaria;
import gestorAplicacion.externo.TipoTransporte;
import gestorAplicacion.externo.Transporte;


public class Tienda {
    // ATRIBUTOS
    // De clase
    private static int numTiendas = 0; 

    // De instancia
    private String nombre;
    private Vendedor vendedor;
    private CuentaBancaria cuentaBancaria;
    private ArrayList<Producto> listaProductos;
    private HashMap<Producto, Integer> cantidadProductos;
    private Map<String, Integer> cantidadPorCategoria = new HashMap<String, Integer>() {{
        put("frutas y verduras", (int) (new Random().nextInt(51) + 50));
        put("panaderia", (int) (new Random().nextInt(51) + 50));
        put("salsas y mermeladas", (int) (new Random().nextInt(51) + 50));
        put("bebidas", (int) (new Random().nextInt(51) + 50));}}; //Número aleatorio entre 50 y 100 (Incluidos)
    private Map<String, Integer> productosPorCategoria;
    private ArrayList<Producto> productosDevueltos = new ArrayList<Producto>();


    // CONSTRUCTORES
    // Constructor que recibe todos los parametros
    public Tienda(String nombre, Vendedor vendedor, CuentaBancaria cuentaBancaria) {
        
        this.nombre = nombre;
        this.vendedor = vendedor;
        this.cuentaBancaria = cuentaBancaria;
        this.cantidadProductos = new HashMap<Producto, Integer>();
        productosPorCategoria = new HashMap<String, Integer>();
        numTiendas++;
    }

    // Constructor sin parametros
    public Tienda() {}


    // MÉTODOS
    // Muestra los productos disponibles en la tienda
    public String mostrarProductos() {
        
        String mensaje = "";
        
        for (int i = 0; i < listaProductos.size(); i++) {
            mensaje += "\n" + (1 + i) + listaProductos.get(i).toString() + "\n";
        }
        
        return mensaje;
    }

    // Permite ver los productos que hay en la tienda y la cantidad que hay
    public String cantidadProductos() {
        
        cantidadProductos = new HashMap<Producto, Integer>();
        
        String mensaje = "";
        
        // Agregar los valores al diccionario y su respectiva cantidad
        for (int i = 0; i < listaProductos.size(); i++) {
            if (cantidadProductos.containsKey(listaProductos.get(i))) {
                cantidadProductos.put(listaProductos.get(i),cantidadProductos.get(listaProductos.get(i)) + 1);
            } else {
                cantidadProductos.put(listaProductos.get(i), 1);
            }
        }

        // Generar el String con cada producto y su cantidad
        for (Map.Entry<Producto, Integer> entrada : cantidadProductos.entrySet()) {
            mensaje += "\n" + entrada.getKey().getNombre() + ": " + entrada.getValue() + " ";
        }

        return mensaje;
    }

    // Método que permite hacer la venta de un producto eliminandolo de la lista de productos y reducir la cantidad en 1 en cantidadProductos
    public void venderProducto(Producto producto) {
        
        if (listaProductos.contains(producto)) {
            listaProductos.remove(producto);
            
            if (cantidadProductos.get(producto) > 1) {
                cantidadProductos.put(producto, cantidadProductos.get(producto) - 1);
            } else {
                cantidadProductos.remove(producto);
            }
        }
    }

    // Permite elegir el transporte teniendo en cuenta el peso del producto
    public void elegirTransporte(Producto producto) {
        
        for (int i = 0; i < TipoTransporte.values().length; i++) {
            if (TipoTransporte.values()[i].getCapacidad_KG() <= producto.getPeso()) {
                TipoTransporte.values()[i].toString();
            }
        }
    }

    // Permite descontar una unidad a las cantidades de los productos, añadir trabajo a los trabajadores involucrados con la venta, y crear la factura de la venta
    public Factura enviarPedido(ArrayList<Producto> listaProductosPedidos, Transporte transporte, Cliente cliente, int fecha, Operario operario) {
        // Vendedor
        this.getVendedor().setTrabajado(this.getVendedor().getTrabajado() + 1);
        this.getVendedor().setMinimoMeta(this.getVendedor().getMinimoMeta()+listaProductosPedidos.size());
        
        // Transportador
        transporte.getTransportador().setTrabajado(transporte.getTransportador().getTrabajado() + 1);
        for(int i=0; i<listaProductosPedidos.size(); i++){
            transporte.getTransportador().setMinimoMeta(transporte.getTransportador().getMinimoMeta()+listaProductosPedidos.get(i).getPeso());
        }

        // Operario
        operario.setTrabajado(operario.getTrabajado() + 1);
        operario.setMinimoMeta(operario.getMinimoMeta() + listaProductosPedidos.size());

        for(int i=0; i<listaProductosPedidos.size(); i++){
            cliente.getProductos().add(listaProductosPedidos.get(i));
        }

        //Creación de la factura
        Factura factura = new Factura(this, cliente, transporte, listaProductosPedidos, fecha, operario);
        
        return factura;
    }

    // Permite que la tienda reciba los productos enviados en el transporte
    public void descargarProducto(Transporte transporte) {
        
        while (transporte.getListaProductos().size() > 0) {
            listaProductos.add(transporte.getListaProductos().remove(0));
        }

        transporte.getTransportador().setTrabajado(transporte.getTransportador().getTrabajado() + 1); // Agregar 1 al trabajo realizado por el transportador 
    }

    // Permite ver la cantidad de productos por categoria que tiene cada tienda, y la cantidad maxima que puede tener
    public String productosPorCategoria(){
        
        String mensaje = "";
        productosPorCategoria.put("frutas y verduras",0);
        productosPorCategoria.put("panaderia",0);
        productosPorCategoria.put("salsas y mermeladas",0);
        productosPorCategoria.put("bebidas",0);
        
        for(Producto producto:listaProductos){
            if(productosPorCategoria.containsKey(producto.getCategoria())){
                productosPorCategoria.put(producto.getCategoria(),productosPorCategoria.get(producto.getCategoria())+1);
            }
        }

        mensaje += "Frutas y verduras " + productosPorCategoria.get("frutas y verduras")+"/"+cantidadPorCategoria.get("frutas y verduras") +"  ";
        mensaje += "Panaderia " + productosPorCategoria.get("panaderia")+"/"+cantidadPorCategoria.get("panaderia")+"  ";
        mensaje += "Salsas y mermeladas " + productosPorCategoria.get("salsas y mermeladas")+"/"+cantidadPorCategoria.get("salsas y mermeladas")+"  ";
        mensaje += "Bebidas " + productosPorCategoria.get("bebidas")+"/"+cantidadPorCategoria.get("bebidas") +"  ";
        
        return mensaje;
    } 

    // Muestra un texto con la cantidad de productos vendidos
    public String cantidadProductosVentas() {
        
        cantidadProductos = new HashMap<Producto, Integer>();
        String mensaje = "";
        int numero = 1;
        
        for (int i = 0; i < listaProductos.size(); i++) {
            if (cantidadProductos.containsKey(listaProductos.get(i))) {
                cantidadProductos.put(listaProductos.get(i),
                        cantidadProductos.get(listaProductos.get(i)) + 1);
            } else {
                cantidadProductos.put(listaProductos.get(i), 1);
            }
        }

        // Generar el texto con la cantidad de cada producto
        for(Producto producto:listaProductos){
            if (!mensaje.contains(producto.getNombre())){              
                mensaje+="\n" + numero + ". " + producto.getNombre() + ": " + cantidadProductos.get(producto) + " ";
                numero++;
            }
        }

        return mensaje;
    }

    //Devuelve el producto seleccionado, agregandolo a la lista donde se almacenan las devoluciones de la tienda y retorna al cliente al que se le hizo la devolución
    public Cliente devolverProducto(Factura factura, Producto producto) {

        productosDevueltos.add(producto); // se duevuelve el producto, agregandolo a la lista productosDevueltos

        return factura.getCliente();
    }


    // GETTERS Y SETTERS
    public static int getNumTiendas() {
        
        return numTiendas;
    }

    public static void setNumTiendas(int numTiendas) {
        
        Tienda.numTiendas = numTiendas;
    }

    public String getNombre() {
        
        return nombre;
    }

    public void setNombre(String nombre) {
        
        this.nombre = nombre;
    }

    public Vendedor getVendedor() {
        
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        
        this.vendedor = vendedor;
    }

    public CuentaBancaria getCuentaBancaria() {
        
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        
        this.cuentaBancaria = cuentaBancaria;
    }

    public ArrayList<Producto> getListaProductos() {
        
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        
        this.listaProductos = listaProductos;
    }

    public HashMap<Producto, Integer> getCantidadProductos() {
        
        return cantidadProductos;
    }

    public void setCantidadProductos(HashMap<Producto, Integer> listaCantidadProductos) {
        
        this.cantidadProductos = listaCantidadProductos;
    }

    public Map<String, Integer> getCantidadPorCategoria(){
        
        return cantidadPorCategoria;
    }

    public void setCantidadPorCategoria(Map<String, Integer> cantidadPorCategoria){
        
        this.cantidadPorCategoria = cantidadPorCategoria;
    }

    public Map<String, Integer> getProductosPorCategoria(){
        
        return productosPorCategoria;
    }

    public void setProductosPorCategoria(Map<String, Integer> productosPorCategoria){
        
        this.productosPorCategoria = productosPorCategoria;
    }

    public ArrayList<Producto> getProductosDevueltos() {
        
        return productosDevueltos;
    }

    public void setProductosDevueltos(ArrayList<Producto> productosDevueltos) {
        
        this.productosDevueltos = productosDevueltos;
    }
}
