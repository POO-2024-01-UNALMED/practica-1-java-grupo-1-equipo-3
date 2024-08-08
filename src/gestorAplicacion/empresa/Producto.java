/**
 * Este módulo pertenece al paquete 'gestorAplicacion.empresa' y contiene clases relacionadas con los productos
 * y su gestión dentro de la empresa. Incluye la clase 'Producto' que representa un producto con sus atributos
 * y métodos para su manipulación.
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo, Santiago Ochoa Quintero,
 * Luis David Ramirez Gonzales, Simón Vasquez Uribe
 */


package gestorAplicacion.empresa;

import java.io.Serializable;
import java.util.ArrayList;
 
 
/**
  * La clase 'Producto' representa un producto dentro de la empresa.
  * 
  * Contiene información sobre el nombre, descripción, valor, peso, tamaño, costo de producción, categoría
  * y estado de devolución del producto.
  * 
  * Proporciona métodos para gestionar estos atributos y para generar una representación en cadena del producto.
  */
 
public class Producto implements Serializable{
     
    // ATRIBUTOS----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     
    // De clase
    private static final long serialVersionUID = 1L; // Versión del serializado asociada a esta clase
    private static int numProductos = 0;
    private static ArrayList<Producto> listaProductos = new ArrayList<>();
 
    // De instancia
    private String nombre;
    private String descripcion;
    private double valor;
    public double peso;
    private double tamano;
    private double costoProduccion;
    private String categoria;
    private boolean devuelto;
 
 
    // CONSTRUCTORES-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
    /**
      * Constructor con todos los parámetros.
      * 
      * @param nombre Nombre del producto
      *
      * @param descripcion Descripción del producto
      * 
      * @param valor Valor del producto
      * 
      * @param peso Peso del producto
      * 
      * @param tamano Tamaño del producto
      * 
      * @param costoProduccion Costo de producción del producto
      * 
      * @param categoria Categoría del producto
      */
 
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
 
 
    /**
      * Constructor para los parámetros nombre, valor, peso, tamaño y categoría.
      * 
      *
      * @param nombre Nombre del producto
      * 
      * @param valor Valor del producto
      * 
      * @param peso Peso del producto
      * 
      * @param tamano Tamaño del producto
      * 
      * @param categoria Categoría del producto
      */
 
    public Producto(String nombre, double valor, double peso, double tamano, String categoria){
        this(nombre, "Sin descripción", valor, peso, tamano, 5.000, categoria);
    }
 
 
    /**
      * Constructor sin parámetros.
      */
 
    public Producto(){}
 
 
 
    // MÉTODOS-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
    /**
      * Genera una representación en cadena del objeto Producto.
      * 
      * @return Una cadena de texto con la información del producto, incluyendo nombre, descripción,
      *         valor, peso, tamaño y costo de producción.
      */
 
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
 
 
 
    // GETTERS Y SETTERS--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     
     
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
