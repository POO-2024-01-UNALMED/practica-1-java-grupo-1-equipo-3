/**
 * Este módulo pertenece al paquete 'gestorAplicacion.empleados' y contiene  la clase 'Transportador', que hereda 
 * de la clase 'Persona' y define las características y comportamientos del transportador que es el trabajador 
 * encargado de transportar productos en determinados transportes.
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo, 
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


package gestorAplicacion.empleados;

import java.util.ArrayList;
import java.util.List;
 
import gestorAplicacion.empresa.Fabrica;
import gestorAplicacion.externo.CuentaBancaria;
import gestorAplicacion.externo.Persona;
import gestorAplicacion.externo.Transporte;
 
 
/**
  * La clase 'Transportador' representa a un empleado transportador en la empresa, que tiene metas de rendimiento 
  * y puede pertenecer a una fábrica y tener un transporte asignado.
  * 
  * Funcionalidades en las que se usa: 
  * 		- Pago de nomina
  */
 
public class Transportador extends Persona{
     
    // ATRIBUTOS---------------------------------------------------------------------------------------------------------------------------------
     
    // De clase
    private static ArrayList<Meta> metas = new ArrayList<Meta>(List.of(
        new Meta("Facil",4,10000),
        new Meta("intermedio",7,15000),
        new Meta("Dificil",10,20000))); //Crear una lista inmutable
    private static ArrayList<Transportador> listaTransportadores = new ArrayList<Transportador>();
     
    // De instancia
    private Transporte transporte;
    private Fabrica fabrica;
 
 
    // CONSTRUCTORES---------------------------------------------------------------------------------------------------------------------------------------
 
    /**
      * Constructor que recibe todos los parámetros.
      * 
      * @param nombre Nombre del transportador
      * 
      * @param edad Edad del transportador
      * 
      * @param identificacion Identificación del transportador
      * 
      * @param cuentaBancaria Cuenta bancaria del transportador
      * 
      * @param transporte Transporte asignado al transportador
      */
 
    public Transportador(String nombre, int edad, int identificacion, CuentaBancaria cuentaBancaria,Transporte transporte) {
         
        super(nombre, edad, identificacion, cuentaBancaria);
        this.transporte = transporte;
        listaTransportadores.add(this);
    }
 
 
    /**
      * Constructor sin parámetros.
      */
 
    public Transportador() {}
     
 
 
    // MÉTODOS---------------------------------------------------------------------------------------------------------------------------------------------------
 
 
    /**
      * Realiza el pago de salario a un objeto de tipo transportador.
      * 
      * Este método esta sobre escrito de la clase Persona.
      * 
      * Se disminuye el saldo de la cuenta bancaria de la fábrica en el monto especificado
      * y se incrementa el saldo de la cuenta bancaria del transportador en el mismo monto.
      * 
      * @param pago Monto del salario a pagar
      * 
      * Funcionalidades en las que se usa: Pago de nomina
      */
 
    @Override
    public void recibirPagos(double pago) {
         
        fabrica.getCuentaBancaria().disminuirSaldo(pago);
        super.getCuentaBancaria().incrementarSaldo(pago);
    }
     
 
 
    /**
      * Devuelve una representación en cadena del objeto Transportador.
      * 
      * @return Una cadena de texto con información sobre el transportador, incluyendo su nombre, edad,
      * 		   identificación y el tipo de transporte asignado.
      */
     
    @Override
    public String toString() {
         
        return "\n"
        + "Nombre: 			" + getNombre() + "\n"
        + "Edad: 			" + getEdad() + "\n"
        + "Cedula:			" + getIdentificacion() + "\n"
        + "Transporte:	    " + getTransporte().getTipo() + "\n";
         
    }
     
 
     
    // GETTERS Y SETTERS-------------------------------------------------------------------------------------------------------------------------------
     
     
    public static ArrayList<Meta> getMetas(){
         
        return metas;
    }
 
 
    public static void setMetas(ArrayList<Meta> metas){
         
        Transportador.metas = metas;
    }
 
 
    public static ArrayList<Transportador> getListaTransportadores() {
         
        return listaTransportadores;
    }
 
 
    public static void setListaTransportadores(ArrayList<Transportador> listaTransportadores) {
         
        Transportador.listaTransportadores = listaTransportadores;
    }
 
 
    public Transporte getTransporte() {
         
        return transporte;
    }
 
 
    public void setTransporte(Transporte transporte) {
        
        this.transporte = transporte;
    }
 
 
    public Fabrica getFabrica() {
         
        return fabrica;
    }
 
 
    public void setFabrica(Fabrica fabrica) {
         
        this.fabrica = fabrica;
    }
}
