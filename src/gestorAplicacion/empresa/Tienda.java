package gestorAplicacion.empresa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import gestorAplicacion.empleados.Operario;
import gestorAplicacion.empleados.Vendedor;
import gestorAplicacion.externo.Cliente;
import gestorAplicacion.externo.CuentaBancaria;
import gestorAplicacion.externo.Parejas;
import gestorAplicacion.externo.TipoTransporte;
import gestorAplicacion.externo.Transporte;


public class Tienda implements Moda, Serializable{
    // ATRIBUTOS
    // De clase
    private static final long serialVersionUID = 1L; // Versión del serializado asociada a esta clase
    private static int numTiendas = 0; 

    // De instancia
    private String nombre;
    private Vendedor vendedor;
    private CuentaBancaria cuentaBancaria;
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    private ArrayList<Parejas<Producto, Integer>> cantidadProductos = new ArrayList<>();
    private ArrayList<Parejas<String, Integer>> cantidadPorCategoria = new ArrayList<>() {{
        add(new Parejas<>("frutas y verduras", new Random().nextInt(51) + 50));
        add(new Parejas<>("panaderia", new Random().nextInt(51) + 50));
        add(new Parejas<>("salsas y mermeladas", new Random().nextInt(51) + 50));
        add(new Parejas<>("bebidas", new Random().nextInt(51) + 50));
    }};
    private ArrayList<Parejas<String, Integer>> productosPorCategoria = new ArrayList<>();
    private ArrayList<Producto> productosDevueltos = new ArrayList<>();


    // CONSTRUCTORES
    // Constructor que recibe todos los parametros
    public Tienda(String nombre, Vendedor vendedor, CuentaBancaria cuentaBancaria) {
        
        this.nombre = nombre;
        this.vendedor = vendedor;
        this.cuentaBancaria = cuentaBancaria;
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
        
        cantidadProductos = new ArrayList<>();
        
        String mensaje = "";
        
        // Agregar los valores al diccionario y su respectiva cantidad
        for (Producto producto : listaProductos) {
            
            boolean buscar = false;
            
            for (Parejas<Producto, Integer> par : cantidadProductos) {
                
                if (par.getKey().equals(producto)) {
                    par.setValue(par.getValue() + 1);
                    buscar = true;
                    break;
                }
            }
            if (!buscar) {
                cantidadProductos.add(new Parejas<>(producto, 1));
            }
        }

        // Generar el String con cada producto y su cantidad
        for (Parejas<Producto, Integer> par : cantidadProductos) {
            mensaje += "\n" + par.getKey().getNombre() + ": " + par.getValue() + " ";
        }

        return mensaje;
    }

    // Método que permite hacer la venta de un producto eliminandolo de la lista de productos y reducir la cantidad en 1 en cantidadProductos
    public void venderProducto(Producto producto) {
        
        if (listaProductos.contains(producto)) {
            listaProductos.remove(producto);
            
            for (Parejas<Producto, Integer> par : cantidadProductos) {
                
                if (par.getKey().equals(producto)) {
                    if (par.getValue() > 1) {
                        par.setValue(par.getValue() - 1);
                    } else {
                        cantidadProductos.remove(par);
                    }
                    break;
                }
            }
        }
    }

    // Permite elegir el transporte teniendo en cuenta el peso del producto
    public void elegirTransporte(Producto producto) {
        
        for (TipoTransporte tipo : TipoTransporte.values()) {
            if (tipo.getCapacidad_KG() <= producto.getPeso()) {
                tipo.toString();
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
        productosPorCategoria.clear();
        productosPorCategoria.add(new Parejas<>("frutas y verduras", 0));
        productosPorCategoria.add(new Parejas<>("panaderia", 0));
        productosPorCategoria.add(new Parejas<>("salsas y mermeladas", 0));
        productosPorCategoria.add(new Parejas<>("bebidas", 0));
        
        for(Producto producto:listaProductos){
            
            for (Parejas<String, Integer> par : productosPorCategoria) {
                
                if (par.getKey().equals(producto.getCategoria())) {
                    par.setValue(par.getValue() + 1);
                }
            }
        }

        for (Parejas<String, Integer> par : productosPorCategoria) {
            for (Parejas<String, Integer> categoria : cantidadPorCategoria) {
                if (categoria.getKey().equals(par.getKey())) {
                    mensaje += par.getKey() + " " + par.getValue() + "/" + categoria.getValue() + " ";
                }
            }
        }
    
        return mensaje;
    } 

    // Muestra un texto con la cantidad de productos vendidos
    public String cantidadProductosVentas() {
        
        cantidadProductos = new ArrayList<>();
        String mensaje = "";
        int numero = 1;
        
        for (Producto producto : listaProductos) {
            
            boolean buscar = false;
            
            for (Parejas<Producto, Integer> par : cantidadProductos) {
                
                if (par.getKey().equals(producto)) {
                    par.setValue(par.getValue() + 1);
                    buscar = true;
                    break;
                }
            }

            if (!buscar) {
                cantidadProductos.add(new Parejas<>(producto, 1));
            }
        }

        // Generar el texto con la cantidad de cada producto
        for(Parejas<Producto, Integer> par : cantidadProductos){
            if (!mensaje.contains(par.getKey().getNombre())){              
                mensaje+="\n" + numero + ". " + par.getKey().getNombre() + ": " + par.getValue() + " ";
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

    public String getNombre() { //De la interfaz Moda
        
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
        
        if (listaProductos == null) {

            listaProductos = new ArrayList<>();
        }

        return listaProductos;
    }
    
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        
        this.listaProductos = listaProductos;
    }

    public ArrayList<Parejas<Producto, Integer>> getCantidadProductos() {
       
        return cantidadProductos;
    }

    public void setCantidadProductos(ArrayList<Parejas<Producto, Integer>> cantidadProductos) {
        
        this.cantidadProductos = cantidadProductos;
    }

    public ArrayList<Parejas<String, Integer>> getCantidadPorCategoria() {
        
        return cantidadPorCategoria;
    }

    public void setCantidadPorCategoria(ArrayList<Parejas<String, Integer>> cantidadPorCategoria) {
        
        this.cantidadPorCategoria = cantidadPorCategoria;
    }

    public ArrayList<Parejas<String, Integer>> getProductosPorCategoria() {
        
        return productosPorCategoria;
    }

    public void setProductosPorCategoria(ArrayList<Parejas<String, Integer>> productosPorCategoria) {
        
        this.productosPorCategoria = productosPorCategoria;
    }
    
    public ArrayList<Producto> getProductosDevueltos() {
        
        return productosDevueltos;
    }

    public void setProductosDevueltos(ArrayList<Producto> productosDevueltos) {
        
        this.productosDevueltos = productosDevueltos;
    }
}
