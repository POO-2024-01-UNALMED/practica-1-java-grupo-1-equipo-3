/**
 * Este módulo pertenece al paquete 'gestorAplicacion.empleados' y contiene  la clase 'Vendedor', que hereda 
 * de la clase 'Persona' y define las características y comportamientos del vendedor que es el trabajador 
 * encargado de realizar las ventas en alguna de las tiendas disponibles
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo, 
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


package gestorAplicacion.empleados;

import java.util.ArrayList;
import java.util.List;
 
import gestorAplicacion.externo.CuentaBancaria;
import gestorAplicacion.externo.Persona;
import gestorAplicacion.empresa.Tienda;
 
 
/**
  * La clase 'Vendedor' representa a un empleado vendedor en la empresa, que tiene metas de rendimiento 
  * y pertenece a una tienda.
  * 
  * Funcionalidades en las que se usa: 
  *      - Pago de nomina
  */
 
public class Vendedor extends Persona {
     
    // ATRIBUTOS--------------------------------------------------------------------------------------------------------------------------
     
    // De clase
    private static ArrayList<Meta> metas = new ArrayList<Meta>(List.of(
        new Meta("Facil",6,12000),
        new Meta("intermedio",9,18000),
        new Meta("Dificil",12,25000))); //Crear una lista inmutable 
     
    // De instancia
    private Tienda tienda;
 
 
    //CONSTRUCTORES
 
    /**
      * Constructor que recibe todos los parámetros.
      * 
      * @param nombre Nombre del vendedor
      * 
      * @param edad Edad del vendedor
      * 
      * @param identificacion Identificación del vendedor
      * 
      * @param cuentaBancaria Cuenta bancaria del vendedor
      * 
      * @param tienda Tienda a la que pertenece el vendedor
      */
 
    public Vendedor(String nombre, int edad, int identificacion, CuentaBancaria cuentaBancaria,Tienda tienda) {
         
        super(nombre, edad, identificacion, cuentaBancaria);
        this.tienda=tienda;
    }
     
 
    /**
      * Constructor para cuando no haya una tienda asociada.
      * 
      * @param nombre Nombre del vendedor
      * 
      * @param edad Edad del vendedor
      * 
      * @param identificacion Identificación del vendedor
      * 
      * @param cuentaBancaria Cuenta bancaria del vendedor
      */
 
    public Vendedor(String nombre, int edad, int identificacion, CuentaBancaria cuentaBancaria) {
         
        super(nombre, edad, identificacion, cuentaBancaria);
    }
 
 
    /**
      * Constructor que no recibe parámetros.
      */
 
    public Vendedor() {}
 
 
 
    // MÉTODOS------------------------------------------------------------------------------------------------------------------------------------------------
 
 
    /**
      * Realiza el pago de salario a un objeto de tipo vendedor.
      * 
      * Este método esta sobre escrito de la clase Persona.
      * 
      * Se disminuye el saldo de la cuenta bancaria de la tienda en el monto especificado
      * y se incrementa el saldo de la cuenta bancaria del vendedor en el mismo monto.
      * 
      * @param pago Monto del salario a pagar
      * 
      * Funcionalidades en las que se usa: Pago de nomina
      */
 
    @Override
    public void recibirPagos(double pago){
 
        tienda.getCuentaBancaria().disminuirSaldo(pago);
        super.getCuentaBancaria().incrementarSaldo(pago);
    }
 
 
 
    /**
      * Devuelve una representación en cadena del objeto Vendedor.
      * 
      * @return Una cadena de texto con información sobre el vendedor, incluyendo su nombre, edad,
      *         identificación y el nombre de la tienda a la que pertenece.
      */
 
    public String toString() {
 
        return "\n"
        + "Nombre:             " + getNombre() + "\n"
        + "Edad:               " + getEdad() + "\n"
        + "Cedula:             " + getIdentificacion() + "\n"
        + "Tienda:             " + getTienda().getNombre() + "\n";
    }
 
 
 
    //GETTERS Y SETTERS----------------------------------------------------------------------------------------------------------------------
     
     
    public static ArrayList<Meta> getMetas(){
         
        return metas;
    }
 
 
    public static void setMetas(ArrayList<Meta> metas){
         
        Vendedor.metas = metas;
    }
     
     
    public Tienda getTienda() {
         
        return tienda;
    }
     
     
    public void setTienda(Tienda tienda) {
         
        this.tienda = tienda;
    }
}
