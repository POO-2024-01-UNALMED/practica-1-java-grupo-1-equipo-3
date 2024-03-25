package gestorAplicacion.externo;

import java.util.ArrayList;

public class Persona {
    // ATRIBUTOS
    // De clase
    private static int totalPersonas;
    private static  ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
    private static final int SALARIO = 1500000; 
    

    // De instancia
     private String nombre;
     private int edad;
     private int identificacion;
     private CuentaBancaria cuentaBancaria;
     private int trabajado;
     private double minimoMeta;
	 private ArrayList<Boolean> cumplimientoMetas = new ArrayList<Boolean>();
     

     // CONSTRUCTORES
     // Constructor
     public Persona(String nombre, int edad, int identificacion, CuentaBancaria cuentaBancaria) {
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

     // Constructor que no recibe parametros
     public Persona(){}
     

     //MÉTODOS
     // Método para realizar pagos
     public void recibirPagos(int cantidad) {}
 

     // GETTERS Y SETTERS
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

     public void setMinimoMeta(int minimoMeta){
        this.minimoMeta = minimoMeta;
     }

     public ArrayList<Boolean> getCumplimientoMetas(){
        return cumplimientoMetas;
     }

     public void setCumplimientoMetas(ArrayList<Boolean> cumplimientoMetas){
        this.cumplimientoMetas = cumplimientoMetas;
     }
}
