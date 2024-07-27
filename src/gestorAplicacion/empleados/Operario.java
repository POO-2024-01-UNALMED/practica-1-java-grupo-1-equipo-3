/**
 * Este módulo pertenece al paquete 'gestorAplicacion.empleados' y contiene  la clase 'Operario', que hereda 
 * de la clase 'Persona' y define las características y comportamientos del operario que es el trabajador 
 * encargado de supervisar y controlar la producción de los diferentes productos en la fábrica.
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
 
 
 /**
  * La clase 'Operario' representa a un empleado operario en la empresa, que tiene metas de rendimiento y puede 
  * pertenecer a una fábrica.
  * 
  * Funcionalidades en las que se usa: 
  *      - Pago de nomina
  */
 
 public class Operario extends Persona {
     
     // ATRIBUTOS----------------------------------------------------------------------------------------------------------------------------------
     
     // De clase
     private static ArrayList<Meta> meta = new ArrayList<Meta>(List.of(
         new Meta("Facil",4,5000),
         new Meta("intermedio",7,10000),
         new Meta("Dificil",10,15000))); //Crear una lista inmutable con las metas de un objeto de tipo operario
     
     //De instancia
     private Fabrica fabrica;
 
 
     //CONSTRUCTORES-----------------------------------------------------------------------------------------------------------------------------------------
 
     /**
      * Constructor para cuando la fábrica ya existe.
      * 
      * @param nombre Nombre del operario
      * 
      * @param edad Edad del operario
      * 
      * @param identificacion Identificación del operario
      * 
      * @param cuentaBancaria Cuenta bancaria del operario
      * 
      * @param fabrica Fábrica a la que pertenece el operario
      */
 
     public Operario(String nombre, int edad, int identificacion, CuentaBancaria cuentaBancaria, Fabrica fabrica) {
        
         super(nombre, edad, identificacion, cuentaBancaria);
         this.fabrica = fabrica;
     }
 
 
     /**
      * Constructor para cuando la fábrica NO existe.
      * 
      * @param nombre Nombre del operario
      * 
      * @param edad Edad del operario
      * 
      * @param identificacion Identificación del operario
      * 
      * @param cuentaBancaria Cuenta bancaria del operario
      */
 
     public Operario(String nombre, int edad, int identificacion, CuentaBancaria cuentaBancaria) {
         
         super(nombre, edad, identificacion, cuentaBancaria);
     }
 
 
     /**
      * Constructor que no recibe parámetros.
      */
 
     public Operario(){}
 
 
 
     // MÉTODOS------------------------------------------------------------------------------------------------------------------------------------------------
 
 
     /**
      * Realiza el pago de salario a un objeto de tipo operario.
      * 
      * Este método esta sobre escrito de la clase Persona.
      * 
      * Se disminuye el saldo de la cuenta bancaria de la fábrica en el monto especificado
      * y se incrementa el saldo de la cuenta bancaria del operario en el mismo monto.
      * 
      * @param pago Monto del salario a pagar
      * 
      * Funcionalidades en las que se usa: Pago de nomina
      */
 
     @Override
     public void recibirPagos(double pago) {
         
         fabrica.getCuentaBancaria().disminuirSaldo(pago);
         this.getCuentaBancaria().incrementarSaldo(pago);   
     }
 
 
 
     /**
      * Devuelve una representación en cadena del objeto Operario.
      * 
      * @return Una cadena de texto con información sobre el operario, incluyendo su nombre, edad, 
      *         identificación y la fábrica a la que pertenece.
      */
     
     @Override
     public String toString() {
         
         return "\n" 
         + "Nombre:              " + getNombre() + "\n"
         + "Edad:                " + getEdad() + "\n"
         + "Identificación:      " + getIdentificacion() + "\n"
         + "Fabrica:             " + getFabrica() + "\n";
     }
 
 
 
     // GETTERS Y SETTERS--------------------------------------------------------------------------------------------------------------------------------------
     
     
     public static ArrayList<Meta> getMetasOperario(){
         
         return meta;
     }
 
 
     public static void setMetasOperario(ArrayList<Meta> meta){
         
         Operario.meta = meta;
     }
     
 
     public Fabrica getFabrica() {
         
         return fabrica;
     }
 
 
     public void setFabrica(Fabrica fabrica) {
         
         this.fabrica = fabrica;
     }
 }