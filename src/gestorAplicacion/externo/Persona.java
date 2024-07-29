/**
 * Este módulo pertenece al paquete 'gestorAplicacion.externo' y contiene la clase abstracta 'Persona' que 
 * representa una persona con sus atributos y métodos para su manipulación.
 * 
 * Esta clase representa la clase base para 'Operario', 'Transportador' y 'Vendedor'.
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo,
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


package gestorAplicacion.externo;

import java.io.Serializable;
import java.util.ArrayList;
 
 
/**
  * La clase abstracta `Persona` representa una persona dentro de la empresa. 
  * 
  * Esta proporciona atributos y métodos para la creación de los diferentes empleados de la empresa.
  * 
  * Contiene información sobre el nombre, edad, identificación, cuenta bancaria, trabajado, y cumplimiento de metas.
  * 
  * Funcionalidades en las que se usa:
  *      - Pago de nomina
  */
 
public abstract class Persona implements Serializable{
     
    // ATRIBUTOS ----------------------------------------------------------------------------------------------------------------------------
     
    // De clase
    protected static final long serialVersionUID = 1L; // Versión del serializado asociada a esta clase
    protected static int totalPersonas;
    protected static  ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
    protected static final int SALARIO = 50000; 
     
    // De instancia
    protected String nombre;
    protected int edad;
    protected int identificacion;
    protected CuentaBancaria cuentaBancaria;
    protected int trabajado;
    protected double minimoMeta;
    protected ArrayList<Boolean> cumplimientoMetas = new ArrayList<Boolean>();
      
 
    // CONSTRUCTORES -------------------------------------------------------------------------------------------------------------------------------------
     
    /**
      * Constructor que recibe todos los parámetros.
      * 
      * @param nombre Nombre de la persona
      * 
      * @param edad Edad de la persona
      * 
      * @param identificacion Identificación de la persona
      * 
      * @param cuentaBancaria Cuenta bancaria de la persona
      */
 
    protected Persona(String nombre, int edad, int identificacion, CuentaBancaria cuentaBancaria) {
        // Constructor con protected por ser una clase abstracta
        this.nombre = nombre;
        this.edad = edad;
        this.identificacion = identificacion;
        this.cuentaBancaria = cuentaBancaria;
        this.trabajado = 0;
        this.minimoMeta = 0;
        this.cumplimientoMetas.add(false);
        this.cumplimientoMetas.add(false);
        listaPersonas.add(this);
        totalPersonas++;
    }
     
 
    /**
      * Constructor que no recibe parámetros.
      */
 
    protected Persona(){}
      
 
 
    //MÉTODOS -----------------------------------------------------------------------------------------------------------------------------
 
 
    /**
      * Método abstracto para realizar pagos.
      * 
      * @param pago Monto del pago a realizar
      * 
      * Funcionalidades en las que se usa: Su implementación en las clases 'Operario',
      * 'Transportador' y 'Vendedor' es usada en la funcionalidad Pago de nomina
      */
 
    public abstract void recibirPagos(double pago); // Método abstracto
  
 
 
    // GETTERS Y SETTERS----------------------------------------------------------------------------------------------------------------------------
 
 
    public static int getTotalPersonas() {
 
        return totalPersonas;
    }
 
 
    public static void setTotalPersonas(int totalPersonas) {
 
        Persona.totalPersonas = totalPersonas;
    }
 
     
    public static ArrayList<Persona> getListaPersonas(){
 
        return listaPersonas;
    }
 
 
    public static void setListaPersonas(ArrayList<Persona> listaPersonas){
 
        Persona.listaPersonas = listaPersonas;
    }
 
 
    // Para este atributo solo se crea get debido a que es una constante
    public static int getSalario(){
 
        return SALARIO; 
    }
 
 
    public String getNombre() {
 
        return nombre;
    }
 
  
    public void setNombre(String nombre) {
         
        this.nombre = nombre;
    }
 
  
    public int getEdad() {
     
        return edad;
    }
 
  
    public void setEdad(int edad) {
         
        this.edad = edad;
    }
 
 
    public int getIdentificacion() {
         
        return identificacion;
    }
 
 
    public void setIdentificacion(int identificacion) {
         
        this.identificacion = identificacion;
    }
 
  
    public CuentaBancaria getCuentaBancaria() {
         
        return cuentaBancaria;
    }
 
  
    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
         
        this.cuentaBancaria = cuentaBancaria;
    }
 
 
    public int getTrabajado(){
         
        return trabajado;
    }
 
 
    public void setTrabajado(int trabajado){
         
        this.trabajado = trabajado;
    }
 
 
    public double getMinimoMeta(){
         
        return minimoMeta;
    }
 
 
    public void setMinimoMeta(double d){
         
        this.minimoMeta = d;
    }
 
 
    public ArrayList<Boolean> getCumplimientoMetas(){
         
        return cumplimientoMetas;
    }
 
 
    public void setCumplimientoMetas(ArrayList<Boolean> cumplimientoMetas){
         
        this.cumplimientoMetas = cumplimientoMetas;
    }
}
