/**
 * Este módulo pertenece al paquete 'gestorAplicacion.empresa' y contiene clases relacionadas con las tiendas
 * y su gestión dentro de la empresa. Incluye la clase 'Tienda' que representa una tienda con sus atributos
 * y métodos para su manipulación. 
 * 
 * Esta clase representa la tienda donde se gestiona el inventario y se  realizan las ventas de los productos. 
 * 
 * Esta clase implementa la interfaz 'Moda'.
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo,
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


package gestorAplicacion.empresa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
 
import gestorAplicacion.empleados.Operario;
import gestorAplicacion.empleados.Vendedor;
import gestorAplicacion.externo.Cliente;
import gestorAplicacion.externo.CuentaBancaria;
import gestorAplicacion.externo.Parejas;
import gestorAplicacion.externo.Transporte;
 
 
 /**
  * La clase 'Tienda' representa una tienda dentro de la empresa.
  * 
  * Contiene información sobre el nombre, el vendedor, la cuenta bancaria, las listas de productos y sus cantidades.
  * 
  * Proporciona métodos para gestionar estos atributos y realizar operaciones como mostrar productos, vender productos,
  * enviar pedidos y manejar devoluciones.
  * 
  * Funcionalidades en las que se usa:
  *      - Envio pedidos
  *      - Proveer tiendas
  *      - Devolucion de productos
  */
 
public class Tienda implements Moda, Serializable{
     
     // ATRIBUTOS--------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
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
 
 
     // CONSTRUCTORES------------------------------------------------------------------------------------------------------------------------------------------------------------
     
     /**
      * Constructor que recibe todos los parámetros.
      * 
      * @param nombre Nombre de la tienda
      * 
      * @param vendedor Vendedor asociado a la tienda
      * 
      * @param cuentaBancaria Cuenta bancaria de la tienda
      */
 
    public Tienda(String nombre, Vendedor vendedor, CuentaBancaria cuentaBancaria) {
         
        this.nombre = nombre;
        this.vendedor = vendedor;
        this.cuentaBancaria = cuentaBancaria;
        numTiendas++;
    }
 
 
     /**
      * Constructor sin parámetros.
      */
 
    public Tienda() {}
 
 
 
     // MÉTODOS-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
 
     /**
      * Muestra los productos disponibles en la tienda.
      * 
      * @return Una cadena de texto con la información de los productos disponibles en la tienda.
      * 
      *  Funcionalidades en las que se usa: Envio pedidos.
      */
 
    public String mostrarProductos() {
         
        String mensaje = "";
         
        for (int i = 0; i < listaProductos.size(); i++) {
             
            mensaje += "\n" + (1 + i) + listaProductos.get(i).toString() + "\n";
        }
         
        return mensaje;
    }
 
 
 
    /**
      * Permite ver los productos que hay en la tienda y su cantidad.
      * 
      * @return Una cadena de texto con la cantidad de cada producto disponible en la tienda.
      * 
      * Funcionalidades en las que se usa: Proveer tiendas.
      */
 
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
 
 
 
     /**
      * Método que permite hacer la venta de un producto, eliminándolo de la lista de productos
      * y reduciendo la cantidad en 1 en cantidadProductos.
      * 
      * @param producto Producto a vender.
      * 
      * Funcionalidades en las que se usa: Envio pedidos, Proveer tiendas.
      */
 
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
 
 
 
     /**
      * Permite descontar una unidad a las cantidades de los productos, añadir trabajo a los trabajadores
      * involucrados con la venta, y crear la factura de la venta.
      * 
      * @param listaProductosPedidos Lista de productos pedidos.
      * 
      * @param transporte Transporte utilizado para el envío.
      * 
      * @param cliente Cliente que realiza el pedido.
      * 
      * @param fecha Fecha del pedido.
      * 
      * @param operario Operario responsable del pedido.
      * 
      * @return La factura generada para el pedido.
      * 
      * Funcionalidades en las que se usa: Envio pedidos
      */
 
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
 
 
 
     /**
      * Permite que la tienda reciba los productos enviados en el transporte.
      * 
      * @param transporte Transporte utilizado para el envío.
      * 
      * Funcionalidades en las que se usa: Proveer tiendas
      */
 
    public void descargarProducto(Transporte transporte) {
         
        while (transporte.getListaProductos().size() > 0) {
            listaProductos.add(transporte.getListaProductos().remove(0));
        }
 
        transporte.getTransportador().setTrabajado(transporte.getTransportador().getTrabajado() + 1); // Agregar 1 al trabajo realizado por el transportador 
    }
 
 
 
     /**
      * Permite ver la cantidad de productos por categoría que tiene cada tienda, y la cantidad máxima que puede tener.
      * 
      * @return Una cadena de texto con la cantidad de productos por categoría en la tienda.
      * 
      * Funcionalidades en las que se usa: Proveer tiendas
      */
 
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
 
 
 
     /**
      * Muestra un texto con la cantidad de productos vendidos.
      * 
      * @return Una cadena de texto con la cantidad de cada producto vendido.
      * 
      * Funcionalidades en las que se usa: Envio pedidos
      */
 
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
 
 
 
     /**
      * Devuelve el producto seleccionado, agregándolo a la lista donde se almacenan las devoluciones de la tienda
      * y retorna al cliente al que se le hizo la devolución.
      * 
      * @param factura Factura asociada a la devolución.
      * 
      * @param producto Producto a devolver.
      * 
      * @return El cliente al que se le hizo la devolución.
      * 
      * Funcionalidades en las que se usa: Devolucion de productos
      */
 
    public Cliente devolverProducto(Factura factura, Producto producto) {
 
        productosDevueltos.add(producto); // se duevuelve el producto, agregandolo a la lista productosDevueltos
        return factura.getCliente();
    }
 
 
 
     // GETTERS Y SETTERS-------------------------------------------------------------------------------------------------------------------------------------------------------
     
     
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
