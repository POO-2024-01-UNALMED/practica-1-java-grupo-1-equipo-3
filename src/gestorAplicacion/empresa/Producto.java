package gestorAplicacion.empresa;

import java.io.Serializable;
import java.util.ArrayList;


public class Producto implements Serializable{
    // ATRIBUTOS
    // De clase
    private static final long serialVersionUID = 12457078L; // Versión del serializado asociada a esta clase
    private static int numProductos = 0;
    private static ArrayList<Producto> listaProductos = new ArrayList<>();

    // De instancia
    private String nombre;
    private String descripcion;
    private double valor;
    private double peso;
    private double tamano;
    private double costoProduccion;
    private String categoria;
    private boolean devuelto;


    // CONSTRUCTORES
    // Constructor con todos los parametros
    public Producto(String nombre, String descripcion, double valor, double peso, double tamano, double costoProduccion, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.peso = peso;
        this.tamano = tamano;
        this.costoProduccion = costoProduccion;
        this.categoria = categoria.toLowerCase(); //Pone todo el String en letras minusculas
        numProductos++;
        listaProductos.add(this); // Agregar este producto a la lista de productos
        this.devuelto = false;
    }

    // Constructor para los parametros nombre, valor, peso, tamano, categoria
    public Producto(String nombre, double valor, double peso, double tamano, String categoria){
        this(nombre, "Sin descripción", valor, peso, tamano, 10.0, categoria);
    }

    // Constructor sin parametros 
    public Producto(){}


    // MÉTODOS
    // Método para crear el mensaje que se mostrará al imprimir la clase
    @Override
    public String toString() {
        return "\n"
        + "Nombre:               " + nombre + "\n"
        + "Descripción:          " + descripcion + "\n"
        + "Valor:                " + valor + "\n"
        + "Peso:                 " + peso + "\n"
        + "Tamaño:               " + tamano + "\n"
        + "Costo de produccion:  " + costoProduccion + "\n";
    }


    // GETTERS Y SETTERS
    public int getNumProductos() {
        
        return numProductos;
    }

    public void setNumProductos(int numProductos) {
        
        Producto.numProductos = numProductos;
    }

    public static ArrayList<Producto> getListaProductos() {
        
        return listaProductos;
    }

    public static void setListaProductos(ArrayList<Producto> listaProductos) {
        
        Producto.listaProductos = listaProductos;
    }

    public String getNombre() {
        
        return nombre;
    }

    public void setNombre(String nombre) {
        
        this.nombre = nombre;
    }

    public String getDescripcion() {
        
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        
        this.descripcion = descripcion;
    }

    public double getValor() {
        
        return valor;
    }

    public void setValor(double valor) {
        
        this.valor = valor;
    }

    public double getPeso() {
        
        return peso;
    }

    public void setPeso(double peso) {
        
        this.peso = peso;
    }

    public double getTamano() {
        
        return tamano;
    }

    public void setTamano(double tamano) {
        
        this.tamano = tamano;
    }

    public double getCostoProduccion() {
        
        return costoProduccion;
    }

    public void setCostoProduccion(double costoProduccion) {
        
        this.costoProduccion = costoProduccion;
    }

    public String getCategoria() {
        
        return categoria;
    }

    public void setCategoria(String categoria) {
        
        this.categoria = categoria;
    }

    public boolean isDevuelto() {
        
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        
        this.devuelto = devuelto;
    }
}
