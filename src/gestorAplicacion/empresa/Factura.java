package gestorAplicacion.empresa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gestorAplicacion.empleados.Operario;
import gestorAplicacion.externo.Cliente;
import gestorAplicacion.externo.Parejas;
import gestorAplicacion.externo.Transporte;


public class Factura implements Serializable{
    // ATRIBUTOS
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


    //COSNTRUCTOR
    // Constructor que recibe todos los parametros
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

    // Constructor sin parametros
    public Factura(){}


    // MÉTODOS
    // Calcula el precio de la factura sumando los precios de los productos y el valor del envío
    public double calcularTotal() {
        
        double totalCompra = 0;
        
        for(int i=0; i<listaProductos.size(); i++){
            
            double precioProducto = listaProductos.get(i).getValor();
            totalCompra += precioProducto;
        }

        return totalCompra + valorEnvio();
    }

    // Este método calcula la tarife de envío de una factura dependiendo del tipo de transporte seleccionado
    public double valorEnvio() {
        
        return transporte.getTipo().getPrecioEnvio_COP();
    }

    // Obtiene una lista de facturas en un periodo especifico
    public static ArrayList<Factura> facturasPorPeriodo(int inicio, int fin) {
        
        ArrayList<Factura> facturasPeriodo = new ArrayList<Factura>();
        
        for(Factura factura: listaFacturas){
            
            if(factura.fecha >= inicio && factura.fecha <= fin)
                facturasPeriodo.add(factura); 
        }

        return facturasPeriodo; 
    }

    // Obtiene las ganancias de cada fecha dentro del periodo ingresado como parámetro
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


    // Obtiene las ganancias de cada fecha en el ArrayList ingresado como parámetro
    public static ArrayList<Parejas<Integer, Double>> gananciasPorDia(ArrayList<Integer> fechas) {
        
        return gananciasPorDia(Collections.min(fechas), Collections.max(fechas)); // encontrar la fecha maxima y minima para poder usar el metodo definido anteriormente
    }

    // Obtiene las ganancias totales a partir de las ganancias por día
    public static double ganancias(ArrayList<Parejas<Integer, Double>> gananciasPorDia) {
        
        double ganancias = 0.0;
        
        for (Parejas<Integer, Double> par : gananciasPorDia) {
            
            ganancias += par.getValue();
        }
        return ganancias;
    }

    // Obtiene el promedio de ganancias por día a partir de un diccionario que contiene estas ganancias por día
    public static double promedioPorDia(ArrayList<Parejas<Integer, Double>> gananciasPorDia) {
        
        return ganancias(gananciasPorDia) / gananciasPorDia.size();
    }

    // Obtiene el porcentaje de aumento de ganancias de cada fecha respecto a la fecha anterior
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

    // Método para encontrar los valores de la clave y valor de un objeto de tipo Parejas cuando la clave es un entero
    private static double obtenerValor(ArrayList<Parejas<Integer, Double>> lista, int clave) {
        
        for (Parejas<Integer, Double> par : lista) {
            
            if (par.getKey() == clave) {
                return par.getValue();
            }
        }
        return 0.0;
    }

    // Obtiene el elemento más común en una lista de elementos 
    private static <T> T masComun(List<T> lista) {
        
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

    // Obtiene la moda de un atributo específico de las facturas en un periodo especifico
    public static Moda moda(int inicio, int fin, String atributo) {
        
        ArrayList<Factura> facturas = Factura.facturasPorPeriodo(inicio, fin);
        ArrayList<Moda> objetos = new ArrayList<>();
        
        for (Factura factura : facturas) {
            
            objetos.add(obtenerValor(factura.getAtributos(), atributo));
        }
        return Factura.masComun(objetos);
    }

    // Método para encontrar los valores de la clave y valor de un objeto de tipo Parejas cuando la clave es un String
    private static Moda obtenerValor(ArrayList<Parejas<String, Moda>> lista, String clave) {
        
        for (Parejas<String, Moda> par : lista) {
            
            if (par.getKey().equals(clave)) {
                return par.getValue();
            }
        }
        return null;
    }

    // Muestra información de los clientes en las facturas que han sido creadas
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

    // Permite al usuario seleccionar una de las facturas existentes
    public static Factura seleccionarFactura(int opcion) {

		return listaFacturas.get(opcion-1);
    }

    // Obtiene los productos presentes en una factura
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

    // devuelve una lista de fechas sin repetir de las facturas existentes en la listaFacturas en un periodo determinado
    public static ArrayList<Integer> listaFechas(int inicio, int fin){

        ArrayList<Integer> listaFechas = new ArrayList<Integer>();
        
        for(Factura factura: listaFacturas){
            
            if(factura.fecha >= inicio && factura.fecha <= fin && !listaFechas.contains(factura.fecha)) //La fecha no debe existir anteriormente para ser agregada a la lista 
                listaFechas.add(factura.fecha);
        }
        return listaFechas;
    }

    // devuelve una lista de fechas sin repetir de las facturas existentes en la listaFacturas (Sin reestricción de fechas)
    public static ArrayList<Integer> listaFechas(){

        ArrayList<Integer> listaFechas = new ArrayList<Integer>();
    
        for(Factura factura: listaFacturas){
            if(!listaFechas.contains(factura.fecha))
                listaFechas.add(factura.fecha);
        }
        return listaFechas;
    }

    // Obtiene la fecha más pequeña en la lista de fechas
    public static int getFechaMin(){

        return Collections.min(listaFechas());
    }

    // Obtiene la fecha más grande en la lista de fechas
    public static int getFechaMax(){

        return Collections.max(listaFechas());
    }

    // Obtiene el producto seleccionado por el cliente para devolver a la tienda
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

    // Definir el mensaje a escribir cuando se imprima un objeto de tipo Factura
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


    // GETTTERS Y SETTERS 
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
