package gestorAplicacion.empresa;

import java.util.ArrayList;

public class Producto {
    // Atributos de instancia
    private String nombre;
    private String categoria;
    private String descripcion;
    private double valor;
    private double peso;
    private double tamano;
    private double costoProduccion;
    private int numProductos;

    // Atributos de clase
    private static ArrayList<Producto> listaProductos = new ArrayList<>();

    // Constructor
    public Producto(String nombre, String categoria, String descripcion, double valor, double peso, double tamano, double costoProduccion, int numProductos) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.valor = valor;
        this.peso = peso;
        this.tamano = tamano;
        this.costoProduccion = costoProduccion;
        this.numProductos = numProductos;
        listaProductos.add(this); // Agregar este producto a la lista de productos
    }

    // Método para descontar el producto cuando es comprado
    public void productoComprado() {
        numProductos--;
        if (numProductos == 0) {
            listaProductos.remove(this);
        }
    }

    // Método para agregar una cantidad específica de productos
    public void agregarCantidad(int cantidad) {
        numProductos += cantidad;
    }

    // Método para obtener un resumen de las ventas del producto en un periodo determinado
    public static String resumenProductos(int inicioPeriodo, int finPeriodo) {
        StringBuilder resumen = new StringBuilder();
        resumen.append("Resumen de ventas del producto en el periodo ");
        resumen.append(inicioPeriodo);
        resumen.append(" - ");
        resumen.append(finPeriodo);
        resumen.append(":\n");

        for (Producto producto : listaProductos) {
            resumen.append("Producto: ");
            resumen.append(producto.nombre);
            resumen.append(", Categoría: ");
            resumen.append(producto.categoria);
            resumen.append(", Num. de productos vendidos: ");
            //obtener el número de productos vendidos ???
            resumen.append("Número total de productos disponibles: ");
            resumen.append(producto.numProductos);
            resumen.append("\n");
        }

        return resumen.toString();
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public int getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }

    public static ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public static void setListaProductos(ArrayList<Producto> listaProductos) {
        Producto.listaProductos = listaProductos;
    }
}
