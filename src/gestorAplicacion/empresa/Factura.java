package gestorAplicacion.empresa;

import java.util.Map.Entry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gestorAplicacion.empleados.Operario;
import gestorAplicacion.externo.Cliente;
import gestorAplicacion.externo.Transporte;


public class Factura implements Serializable{
    // ATRIBUTOS
    // De clase
    private static final long serialVersionUID = 1897543L; // Versión del serializado asociado a esta clase
    private static ArrayList<Factura> listaFacturas = new ArrayList<>();
    private static int facturasCreadas = 0;
    private static HashMap<String, Moda> infoAtributos = new HashMap<String,Moda>();

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

        infoAtributos.put("tienda", tienda);
        infoAtributos.put("transporte", transporte);
        infoAtributos.put("cliente", cliente);
        
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
            totalCompra+=precioProducto;
        }

        return totalCompra + valorEnvio();
    }

    // Este método calcula la tarife de envío de una factura dependiendo del tipo de transporte seleccionado
    public double valorEnvio() {
       
        double precioEnvio = transporte.getTipo().precioEnvio_COP;
        
        return precioEnvio;
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
    public static HashMap<Integer, Double> gananciasPorDia(int inicio, int fin){

        ArrayList<Integer> dias = listaFechas(inicio, fin);
        ArrayList<Factura> facturas = facturasPorPeriodo(inicio, fin); 
        HashMap<Integer, Double> gananciasPorDia = new HashMap<Integer, Double>();

        for(int dia: dias){
            gananciasPorDia.put(dia, 0.0);
        }

        // Se itera sobre un set que contiene todas las claves (días)
        for(int fecha: gananciasPorDia.keySet()){
            for(Factura factura: facturas){
                if(factura.fecha == fecha){
                    double contador = gananciasPorDia.get(fecha);
                    gananciasPorDia.put(fecha, contador + factura.getTotal());
                }
            }
        } 

        return gananciasPorDia;
    }

    // Obtiene las ganancias de cada fecha en el ArrayList ingresado como parámetro
    public static HashMap<Integer, Double> gananciasPorDia(ArrayList<Integer> fechas){
    
        int fecha1 = Collections.min(fechas); // Encontrar la fecha más pequeña y la más grande para definir el periodo en que se evaluará 
        int fecha2 = Collections.max(fechas);

        return gananciasPorDia(fecha1, fecha2);
    }

    // Obtiene las ganancias totales a partir de las ganancias por día
    public static double ganancias(HashMap<Integer, Double> gananciasPorDia) {
        
        double ganancias = 0.0;
        
        for(int fecha: gananciasPorDia.keySet()){
            ganancias += gananciasPorDia.get(fecha);
        }

        return ganancias;
    }

    // Obtiene el promedio de ganancias por día a partir de un diccionario que contiene estas ganancias por día
    public static double promedioPorDia(HashMap<Integer, Double> gananciasPorDia) {

        double promedio = ganancias(gananciasPorDia) / gananciasPorDia.size();
        
        return promedio;
    }

    // Obtiene el porcentaje de aumento de ganancias de cada fecha respecto a la fecha anterior
    public static HashMap<Integer, Double> porcentajeDeAumento(HashMap<Integer, Double> gananciasPorDia){

        ArrayList<Integer> fechas = new ArrayList<Integer>(gananciasPorDia.keySet()); // set que contiene todas las claves (días)
        Collections.sort(fechas); // Ordenar de manera ascendente
        HashMap<Integer, Double> porcentajeDeAumento = new HashMap<Integer, Double>(); // Aquí se guardará el aumento para cada fecha
    
        for(int i = 1; i < fechas.size(); i++){
            double gananciaFecha = gananciasPorDia.get(fechas.get(i));
            double gananciaFechaAnterior = gananciasPorDia.get(fechas.get(i - 1));
            double porcentaje = ((gananciaFecha - gananciaFechaAnterior) / gananciaFechaAnterior) * 100;
            porcentajeDeAumento.put(fechas.get(i), porcentaje);
        }
       
        return porcentajeDeAumento;
    }

    // Obtiene el elemento más común en una lista de elementos 
    private static <T> T masComun(List<T> list) { // T indica que los elementos son genéricos
        
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Entry<T, Integer> max = null;

        for (Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }

    // Obtiene la moda de un atributo específico de las facturas en un periodo especifico
    public static Moda moda(int inicio, int fin, String atributo){

        ArrayList<Factura> facturas = Factura.facturasPorPeriodo(inicio, fin);
        ArrayList<Moda> objetos = new ArrayList<Moda>(); 
    
        for(Factura factura: facturas){
            objetos.add(factura.getAtributos().get(atributo));
        }
    
        return Factura.masComun(objetos);
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
		
        Factura factura = listaFacturas.get(opcion-1);

		return factura;
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
    public static int minFecha(){

        return Collections.min(listaFechas());
    }

    // Obtiene la fecha más grande en la lista de fechas
    public static int maxFecha(){

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

    public HashMap<String, Moda> getAtributos(){

        return infoAtributos;
    }

    public static HashMap<String, Moda> getInfoAtributos(){
        
        return infoAtributos;
    }

    public static void setInfoAtributos(HashMap<String, Moda> infoAtributos) {
        
        Factura.infoAtributos = infoAtributos;
    }
}
