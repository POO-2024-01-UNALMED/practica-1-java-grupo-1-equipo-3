/**
 * Este módulo pertenece al paquete 'gestorAplicacion.empresa' y contiene la clase 'Factura' que representa las 
 * transacciones de compra en la empresa. Esta clase es la encargada de registrar la información importante
 * acerca de las ventas y gestionar las devoluciones de productos.
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo,
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


package gestorAplicacion.empresa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
import gestorAplicacion.empleados.Operario;
import gestorAplicacion.externo.Cliente;
import gestorAplicacion.externo.Parejas;
import gestorAplicacion.externo.Transporte;
 
 
/**
  * La clase 'Factura' representa una factura de compra dentro del supermercado.
  * 
  * Contiene información sobre la tienda, el cliente, el transporte, la fecha, la identificación de la compra,
  * el total de la factura, el operario responsable y la lista de productos comprados.
  * 
  * Proporciona métodos para calcular el total de la factura, las ganancias por periodo, y obtener resúmenes de facturas y productos.
  * 
  * Funcionalidades en las que se usa:
  *      - Evaluacion operacion
  *      - Devolucion de productos
  */
 
public class Factura implements Serializable{
     
    // ATRIBUTOS-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     
    // De clase
    private static final long serialVersionUID = 1L; // Versión del serializado asociado a esta clase
    private static ArrayList<Factura> listaFacturas = new ArrayList<>();
    private static int facturasCreadas = 0;
    private static ArrayList<Parejas<String, Moda>> infoAtributos = new ArrayList<>();
 
    // De instancia
    private Tienda tienda;
    private Cliente cliente;
    private Transporte transporte;
    private int fecha;
    private int identificacionCompra;
    private double total;
    private Operario operario;
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
 
 
    //CONSTRUCTORES-----------------------------------------------------------------------------------------------------------------------------
 
    /**
      * Constructor que inicializa una nueva instancia de Factura con todos los parámetros especificados.
      *
      * @param tienda La tienda asociada a la factura.
      * 
      * @param cliente El cliente que realizó la compra.
      * 
      * @param transporte El transporte utilizado para la entrega.
      * 
      * @param listaProductos La lista de productos comprados.
      * 
      * @param fecha La fecha de la compra (representada como un entero).
      * 
      * @param operario El operario que procesó la compra.
      */
 
    public Factura(Tienda tienda, Cliente cliente, Transporte transporte, ArrayList<Producto> listaProductos, int fecha, Operario operario) {
        
        this.tienda = tienda;
        this.cliente = cliente;
        this.transporte = transporte;
        this.listaProductos = listaProductos;
        this.fecha = fecha;
        this.operario = operario;
 
        infoAtributos.add(new Parejas<>("tienda", tienda));
        infoAtributos.add(new Parejas<>("transporte", transporte));
        infoAtributos.add(new Parejas<>("cliente", cliente));
         
        this.total = calcularTotal();
        this.identificacionCompra = ++facturasCreadas;
        listaFacturas.add(this);
    }
 
 
    /**
      * Constructor sin parámetros que inicializa una nueva instancia de Factura.
      * 
      * Este constructor crea una factura vacía sin información inicial.
      */
 
    public Factura(){}
 
 
 
    // MÉTODOS---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
 
    /**
      * Calcula el precio total de la factura sumando los precios de los productos y el valor del envío.
      * 
      * @return El total de la factura incluyendo el costo de los productos y el envío.
      */
 
    public double calcularTotal() {
         
        double totalCompra = 0;
         
        for(int i=0; i<listaProductos.size(); i++){
             
            double precioProducto = listaProductos.get(i).getValor();
            totalCompra += precioProducto;
        }
 
        return totalCompra + valorEnvio();
    }
 
 
 
    /**
      * Calcula la tarifa de envío de una factura dependiendo del tipo de transporte seleccionado.
      * 
      * @return El costo del envío basado en el tipo de transporte.
      */
 
    public double valorEnvio() {
         
        return transporte.getTipo().getPrecioEnvio_COP();
    }
 
 
 
    /**
      * Obtiene una lista de facturas en un periodo específico.
      * 
      * @param inicio Fecha de inicio del periodo.
      * 
      * @param fin Fecha de fin del periodo.
      * 
      * @return Una lista de facturas dentro del periodo especificado.
      * 
      * Funcionalidades en las que se usa: Evaluacion operacion
      */
 
    public static ArrayList<Factura> facturasPorPeriodo(int inicio, int fin) {
         
        ArrayList<Factura> facturasPeriodo = new ArrayList<Factura>();
         
        for(Factura factura: listaFacturas){
             
            if(factura.fecha >= inicio && factura.fecha <= fin)
                facturasPeriodo.add(factura); 
        }
 
        return facturasPeriodo; 
    }
 
 
    /**
      * Obtiene las ganancias de cada fecha dentro del periodo ingresado como parámetro.
      * 
      * @param inicio Fecha de inicio del periodo.
      * 
      * @param fin Fecha de fin del periodo.
      * 
      * @return Una lista de Parejas <fecha, ganancias> con las ganancias por día dentro del periodo especificado.
      * 
      * Funcionalidades en las que se usa: Evaluacion operacion
      */
 
    public static ArrayList<Parejas<Integer, Double>> gananciasPorDia(int inicio, int fin) {
         
        ArrayList<Integer> dias = listaFechas(inicio, fin);
        ArrayList<Factura> facturas = facturasPorPeriodo(inicio, fin);
        ArrayList<Parejas<Integer, Double>> gananciasPorDia = new ArrayList<>();
 
        for (int dia : dias) {
             
            gananciasPorDia.add(new Parejas<>(dia, 0.0));
        }
 
        for (Parejas<Integer, Double> par : gananciasPorDia) {
             
            int fecha = par.getKey();
             
            for (Factura factura : facturas) {
 
                if (factura.fecha == fecha) {
                    double contador = par.getValue();
                    par.setValue(contador + factura.getTotal());
                }
            }
        }
        return gananciasPorDia;
    }
 
 
 
    /**
      * Obtiene las ganancias de cada fecha en el ArrayList ingresado como parámetro.
      * 
      * @param fechas Una lista de fechas específicas.
      * 
      * @return Una lista de Parejas <fecha, ganancias> con las ganancias por día para las fechas especificadas.
      * 
      * Funcionalidades en las que se usa: Evaluacion operacion
      */
 
    public static ArrayList<Parejas<Integer, Double>> gananciasPorDia(ArrayList<Integer> fechas) {
         
        return gananciasPorDia(Collections.min(fechas), Collections.max(fechas)); // encontrar la fecha maxima y minima para poder usar el metodo definido anteriormente
    }
 
 
 
    /**
      * Obtiene las ganancias totales a partir de las ganancias por día.
      * 
      * @param gananciasPorDia Lista de Parejas <fecha, ganancias> con las ganancias por día.
      * 
      * @return El total de las ganancias.
      * 
      * Funcionalidades en las que se usa: Evaluacion operacion
      */
 
    public static double ganancias(ArrayList<Parejas<Integer, Double>> gananciasPorDia) {
         
        double ganancias = 0.0;
         
        for (Parejas<Integer, Double> par : gananciasPorDia) {
             
            ganancias += par.getValue();
        }
         
        return ganancias;
    }
 
 
 
    /**
      * Obtiene el promedio de ganancias por día a partir de una lista de ganancias por día.
      * 
      * @param gananciasPorDia Lista de Parejas <fecha, ganancias> con las ganancias por día.
      * 
      * @return El promedio de las ganancias por día.
      * 
      * Funcionalidades en las que se usa: Evaluacion operacion
      */
 
    public static double promedioPorDia(ArrayList<Parejas<Integer, Double>> gananciasPorDia) {
         
        return ganancias(gananciasPorDia) / gananciasPorDia.size();
    }
 
 
 
    /**
      * Obtiene el porcentaje de aumento de ganancias de cada fecha respecto a la fecha anterior.
      * 
      * @param gananciasPorDia Lista de Parejas <fecha, ganancias> con las ganancias por día.
      * 
      * @return Una lista de pares <fecha, porcentaje de aumento> con el porcentaje de aumento de ganancias por día.
      * 
      * Funcionalidades en las que se usa: Evaluacion operacion
      */
 
    public static ArrayList<Parejas<Integer, Double>> porcentajeDeAumento(ArrayList<Parejas<Integer, Double>> gananciasPorDia) {
         
        ArrayList<Integer> fechas = new ArrayList<>();
         
        for (Parejas<Integer, Double> par : gananciasPorDia) {
             
            fechas.add(par.getKey());
        }
         
        Collections.sort(fechas);
        ArrayList<Parejas<Integer, Double>> porcentajeDeAumento = new ArrayList<>();
         
        for(int i = 1; i < fechas.size(); i++){
             
            double gananciaFecha = obtenerValor(gananciasPorDia, fechas.get(i));
            double gananciaFechaAnterior = obtenerValor(gananciasPorDia, fechas.get(i - 1));
            double porcentaje = ((gananciaFecha - gananciaFechaAnterior) / gananciaFechaAnterior) * 100;
            porcentajeDeAumento.add(new Parejas<>(fechas.get(i), porcentaje));
        }
        return porcentajeDeAumento;
    }
 
 
 
    /**
      * Método para encontrar los valores de la clave y valor de un objeto de tipo Parejas cuando la clave es un entero.
      * 
      * @param lista Lista de Parejas <clave, valor>.
      * 
      * @param clave Clave a buscar en la lista.
      * 
      * @return El valor correspondiente a la clave especificada.
      */
 
    public static double obtenerValor(ArrayList<Parejas<Integer, Double>> lista, int clave) {
         
        for (Parejas<Integer, Double> par : lista) {
             
            if (par.getKey() == clave) {
                return par.getValue();
            }
        }
        return 0.0;
    }
 
 
 
    /**
      * Obtiene el elemento más común en una lista de elementos.
      * 
      * Si varios elementos tienen la misma frecuencia, el método devuelve el primero que se encuentra al recorrer la lista.
      * 
      * @param lista Lista de elementos genéricos.
      * 
      * @return El elemento más común en la lista.
      * 
      * Funcionalidades en las que se usa: Evaluacion operacion
      */
 
    public static <T> T masComun(List<T> lista) {
         
        ArrayList<Parejas<T, Integer>> map = new ArrayList<>();
         
        for (T t : lista) {
             
            boolean buscar = false;
            
            for (Parejas<T, Integer> par : map) {
                 
                if (par.getKey().equals(t)) {
                    par.setValue(par.getValue() + 1);
                    buscar = true;
                    break;
                }
            }
            if (!buscar) {   
                map.add(new Parejas<>(t, 1));
            }
        }
        Parejas<T, Integer> max = null;
         
        for (Parejas<T, Integer> e : map) {
             
            if (max == null || e.getValue() > max.getValue()) // Si cumple una o la otra
                max = e;
        }
        return max.getKey();
    }
 
 
 
    /**
      * Obtiene la moda de un atributo específico de las facturas en un periodo específico.
      * 
      * @param inicio Fecha de inicio del periodo.
      * 
      * @param fin Fecha de fin del periodo.
      * 
      * @param atributo Nombre del atributo a analizar.
      * 
      * @return La moda del atributo especificado en el periodo especificado.
      * 
      * Funcionalidades en las que se usa: Evaluacion operacion
      */
 
    public static Moda moda(int inicio, int fin, String atributo) {
         
        ArrayList<Factura> facturas = Factura.facturasPorPeriodo(inicio, fin);
        ArrayList<Moda> objetos = new ArrayList<>();
         
        for (Factura factura : facturas) {
             
            objetos.add(obtenerValor(factura.getAtributos(), atributo));
        }
        return Factura.masComun(objetos);
    }
 
 
 
    /**
      * Método para encontrar los valores de la clave y valor de un objeto de tipo Parejas cuando la clave es un String.
      * 
      * @param lista Lista de Parejas <clave, valor>.
      * 
      * @param clave Clave a buscar en la lista.
      * 
      * @return El valor correspondiente a la clave especificada.
      */
 
    public static Moda obtenerValor(ArrayList<Parejas<String, Moda>> lista, String clave) {
         
        for (Parejas<String, Moda> par : lista) {
             
            if (par.getKey().equals(clave)) {
                return par.getValue();
            }
        }
        return null;
    }
 
 
 
    /**
      * Muestra información de las facturas que han sido creadas.
      * 
      * @return Una cadena de texto con información sobre cada factura, incluyendo el cliente y la 
      *         identificación de compra.
      * 
      * Funcionalidades en las que se usa: Devolucion de productos
      */
 
    public static String mostrarFacturas() {
         
        String mensaje = "";
        int numero = 1;
     
        for(Factura factura:listaFacturas) {
             
            mensaje += numero +". " + "Cliente: " + factura.getCliente().getNombre()+ 
            " Identificación de compra" + factura.getIdentificacionCompra() + "\n"; 
            numero++;
        }
         
        return mensaje;
    }
 
 
 
    /**
      * Permite al usuario seleccionar una de las facturas existentes para realizar una devolución.
      * 
      * @param opcion Número de la factura a seleccionar (opcion - 1).
      * 
      * @return La factura seleccionada correspondiente al número especificado.
      * 
      * Funcionalidades en las que se usa: Devolucion de productos
      */
 
    public static Factura seleccionarFactura(int opcion) {
 
        return listaFacturas.get(opcion-1);
    }
 
 
 
    /**
      * Obtiene los productos presentes en una factura.
      * 
      * @param productos Lista de productos en la factura.
      * 
      * @return Una cadena de texto con información sobre los productos en la factura, incluyendo nombre 
      *         y si han sido devueltos.
      * 
      * Funcionalidades en las que se usa: Devolución de productos
      */
 
    public static String mostrarProductosFactura(ArrayList<Producto> productos) {
         
        String mensaje="";
        int numero = 1;
 
        //se recorre la lista para obtener cada nombre de las facturas disponibles:
        for(Producto producto:productos) {
             
            if (producto.isDevuelto()){
                 mensaje += numero + ". Producto: " + producto.getNombre() + " (Devuelto)"+"\n"; //se especifica que el producto ya ha sido devuelto
                 numero++;
            }
            else {
                mensaje += numero + ". Producto: " + producto.getNombre() + "\n"; 
                numero++;                
            }
        }
        return mensaje;
    }
 
 
 
    /**
      * Devuelve una lista de fechas sin repetir de las facturas existentes en la listaFacturas en un periodo determinado.
      * 
      * @param inicio Fecha de inicio del periodo.
      * 
      * @param fin Fecha de fin del periodo.
      * 
      * @return Una lista de fechas sin repetir dentro del periodo especificado.
      * 
      * Funcionalidades en las que se usa: Evaluacion operacion
      */
 
    public static ArrayList<Integer> listaFechas(int inicio, int fin){
 
        ArrayList<Integer> listaFechas = new ArrayList<Integer>();
         
        for(Factura factura: listaFacturas){
             
            if(factura.fecha >= inicio && factura.fecha <= fin && !listaFechas.contains(factura.fecha)) //La fecha no debe existir anteriormente para ser agregada a la lista 
                listaFechas.add(factura.fecha);
        }
        return listaFechas;
    }
 
 
 
    /**
      * Devuelve una lista de fechas sin repetir de las facturas existentes en la listaFacturas (Sin restricción de fechas).
      * 
      * @return Una lista de fechas sin repetir de todas las facturas.
      * 
      * Funcionalidades en las que se usa: Evaluacion operacion
      */
 
    public static ArrayList<Integer> listaFechas(){
 
        ArrayList<Integer> listaFechas = new ArrayList<Integer>();
     
        for(Factura factura: listaFacturas){
            if(!listaFechas.contains(factura.fecha))
                listaFechas.add(factura.fecha);
        }
        return listaFechas;
    }
 
 
 
    /**
      * Obtiene la fecha más pequeña en la lista de fechas.
      * 
      * @return La fecha mínima en la lista de fechas.
      * 
      * Funcionalidades en las que se usa: Evaluacion operacion
      */
 
    public static int getFechaMin(){
 
        return Collections.min(listaFechas());
    }
 
 
 
    /**
      * Obtiene la fecha más grande en la lista de fechas.
      * 
      * @return La fecha máxima en la lista de fechas.
      * 
      * Funcionalidades en las que se usa: Evaluacion operacion
      */
 
    public static int getFechaMax(){
 
        return Collections.max(listaFechas());
    }
 
 
 
    /**
      * Obtiene el producto seleccionado por el cliente para devolver a la tienda.
      * 
      * @param opcion Número del producto a devolver (1-based).
      * 
      * @return El producto seleccionado correspondiente al número especificado, o null si el número no es válido.
      * 
      * Funcionalidades en las que se usa: Devolucion de productos
      */
 
    public Producto seleccionarProductoDevolver(int opcion) {
         
        Producto producto; 
         
        if ((0< opcion)&& (opcion<=listaProductos.size())){ // Valida que la opción ingresada sea válida
            producto = listaProductos.get(opcion-1);
        }
        else{ //Para que no salga un error si el indice ingresado no es válido
            producto = null;
        }
        return producto;
    }
 
 
 
    /**
      * Devuelve una representación en cadena del objeto Factura.
      * 
      * @return Una cadena de texto con información detallada sobre los productos en la factura,
      *         el tipo de transporte, la tarifa de envío y el total a pagar.
      */
 
    public String toString(){
 
        String textoProductos = "";
         
        for(int i=0; i<listaProductos.size(); i++){
             
            textoProductos += "Nombre del producto: " + listaProductos.get(i).getNombre() + " - Precio del producto: "+ listaProductos.get(i).getValor()+"\n";
        }
 
        return  textoProductos
        + "Tipo de transporte:        " + transporte.getTipo().name() + "\n"
        + "Tarifa de envio:           " + valorEnvio() + "\n"
        + "Total a pagar:             " + total;  
 
    }
 
 
 
    // GETTTERS Y SETTERS ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     
     
    public Tienda getTienda() {
        
        return tienda;
    }
 
 
    public void setTienda(Tienda tienda) {
         
        this.tienda = tienda;
    }
 
 
    public Cliente getCliente() {
         
        return cliente;
    }
 
 
    public void setCliente(Cliente cliente) {
         
        this.cliente = cliente;
    }
 
 
    public Transporte getTransporte() {
         
        return transporte;
    }
 
 
    public void setTransporte(Transporte transporte) {
         
        this.transporte = transporte;
    }
 
 
    public int getFecha() {
         
        return fecha;
    }
 
 
    public void setFecha(int fecha) {
         
        this.fecha = fecha;
    }
 
 
    public int getIdentificacionCompra() {
         
        return identificacionCompra;
    }
 
 
    public void setIdentificacionCompra(int identificacionCompra) {
         
        this.identificacionCompra = identificacionCompra;
    }
 
 
    public double getTotal() {
         
        return total;
    }
 
 
    public void setTotal(double total) {
         
        this.total = total;
    }
 
 
    public ArrayList<Producto> getListaProductos() {
        
        return listaProductos;
    }
 
 
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        
        this.listaProductos = listaProductos;
    }
 
 
    public static ArrayList<Factura> getListaFacturas() {
        
        return listaFacturas;
    }
 
 
    public static void setListaFacturas(ArrayList<Factura> listaFacturas) {
        
        Factura.listaFacturas = listaFacturas;
    }
 
 
    public static int getFacturasCreadas() {
         
        return facturasCreadas;
    }
 
 
    public static void setFacturasCreadas(int facturasCreadas) {
         
        Factura.facturasCreadas = facturasCreadas;
    }
 
 
    public Operario getOperario(){
         
        return this.operario;
    }
 
 
    public void setOperario(Operario operario) {
         
        this.operario = operario;
    }
 
 
    public ArrayList<Parejas<String, Moda>> getAtributos() {
         
        return infoAtributos;
    }
 
 
    public static ArrayList<Parejas<String, Moda>> getInfoAtributos(){
         
        return infoAtributos;
    }
 
 
    public static void setInfoAtributos(ArrayList<Parejas<String, Moda>> infoAtributos) {
        
        Factura.infoAtributos = infoAtributos;
    }
}
