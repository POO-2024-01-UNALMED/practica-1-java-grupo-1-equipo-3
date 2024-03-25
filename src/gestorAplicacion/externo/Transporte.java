package gestorAplicacion.externo;

import java.util.ArrayList;

import gestorAplicacion.empleados.Transportador;
import gestorAplicacion.empresa.Producto;
import gestorAplicacion.empresa.Tienda;
import gestorAplicacion.externo.TipoTransporte;

public class Transporte {
    // ATRIBUTOS 
    // De instancia
    private TipoTransporte tipo;
    private double capacidad;
    private double costo;
    private Transportador transportador;
    private ArrayList<TipoTransporte> transportes;
    private double precioTransporte;
    private Tienda tienda;
    private ArrayList<Producto> listaProductos;


    // CONSTRCUTORES
    public Transporte(TipoTransporte tipo, Double capacidad, double costo, Transportador transportador) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.costo = costo;
        this.transportador = transportador;
    }


    //MÉTODOS
    // Lleva los productos al transporte seleccionado y asigna la tienda a la que se enviarán
    public void suministrarProducto(Tienda tienda, ArrayList<Producto> listaProductos){
        this.setTienda(tienda);
        this.setListaProductos(listaProductos);
    }

    //muestra todos los tipos de transporte, su precio y su capacidad
    public static void MostrarTipoTransporte(String[] args) {
        TipoTransporte[] transportes = TipoTransporte.values();
        for (int i = 0; i < transportes.length; i++) {
            System.out.println(transportes[i]);
        }

    }
    //metodo para nombre, precio y capacidad de algún tipo de transporte
    public String TipoTransporte(TipoTransporte transporte) {
        String mensaje = ("Tipo de transporte: " + transporte.name() + 
                          "Precio: " + transporte.getPrecioEnvio_COP() + 
                          "Capacidad máxima: " + transporte.getCapacidad_KG());
        return mensaje;
    }

    // Cambia el valor del envio a 0
    public static Transporte enviarGratis(Transporte transporte){
        transporte.getTipo().setPrecioEnvio_COP(0);
        return transporte;
    }

    // Guarda el valor del precio de envío en la variable precioTransporte
    public void recordarPrecioTransporte(){
        precioTransporte = this.getTipo().getPrecioEnvio_COP();
    }

    // Guarda en precioEnvio el valor que esta en precioTransporte
    public void reestablecerPrecioTransporte(){
        this.getTipo().setPrecioEnvio_COP(precioTransporte);
    }
    

    // GETTERS Y SETTERS
     public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }
    
    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }
    
    public double getCosto() {
        return costo;
    }

    public void setCosto (double costo) {
        this.costo = costo;
    }

    public Transportador getTransportador() {
        return transportador;
    }

    public void setTransportador(Transportador transportador) {
        this.transportador = transportador;
    }

    public ArrayList<TipoTransporte> getTransportes() {
        return transportes;
    }

    public void setTransportes(ArrayList<TipoTransporte> transportes) {
        this.transportes = transportes;
    }

    public double getPrecioTransporte() {
        return precioTransporte;
    }

    public void setPrecioTransporte(double precioTransporte) {
        this.precioTransporte = precioTransporte;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }


}
