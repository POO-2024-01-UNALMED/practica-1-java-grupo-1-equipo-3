/**
 * Este módulo pertenece al paquete 'gestorAplicacion.externo' y contiene la clase 'CuentaBancaria' que representa una cuenta bancaria 
 * con sus atributos y métodos para su manipulación.
 * 
 * Esta clase representa una cuenta bancaria en la que se gestionan las transacciones financieras, incluyendo acciones como realizar 
 * los pagos y devoluciones de dinero, tanto para las cuentas bancarias de los clientes como para las cuentas bancarias de los empleados
 * y la empresa. 
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo, 
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


package gestorAplicacion.externo;

import java.io.Serializable;
 
import gestorAplicacion.empleados.Operario;
import gestorAplicacion.empleados.Transportador;
import gestorAplicacion.empleados.Vendedor;
 
 
/**
  * La clase 'CuentaBancaria' representa una cuenta bancaria dentro de la empresa.
  * 
  * Contiene información sobre el número de cuenta y el saldo.
  * 
  * Proporciona métodos para gestionar estos atributos y realizar operaciones como incrementar y disminuir el saldo,
  * calcular el pago de empleados y devolver dinero a los clientes.
  * 
  * Funcionalidades en las que se usa:
  *      - Pago de nomina
  *      - Devolucion de productos
  */
 
public class CuentaBancaria implements Serializable {
     
    // ATRIBUTOS -----------------------------------------------------------------------------------------------------------------------------------------------------------
     
    // De instancia
    private static final long serialVersionUID = 1L; // Versión del serializado asociada a esta clase 
    private int numeroCuenta;
    private int saldo;
     
 
    // CONSTRUCTOR --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
    /**
      * Constructor que recibe el número de cuenta y el saldo inicial.
      * 
      * @param numeroCuenta Número de la cuenta bancaria
      * 
      * @param saldo Saldo inicial de la cuenta bancaria
      */
 
    public CuentaBancaria(int numeroCuenta, int saldo) {
         
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
     
 
 
    // MÉTODOS -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     
 
    /**
      * Incrementa el saldo de la cuenta bancaria.
      * 
      * @param cantidad Cantidad a incrementar en el saldo de la cuenta.
      */
 
    public void incrementarSaldo(double cantidad) {
         
        saldo += cantidad;
    }
     
 
 
    /**
      * Disminuye el saldo de la cuenta bancaria.
      * 
      * @param cantidad Cantidad a disminuir del saldo de la cuenta.
      */
 
    public void disminuirSaldo(double cantidad) {
         
        saldo -= cantidad;
    }
 
 
     
    /**
      * Calcula el pago de los empleados basado en el trabajo realizado.
      * 
      * @param persona Persona (empleado) para la cual se va a calcular el pago.
      * 
      * @return El monto total a pagar al empleado basado en su tipo y trabajo realizado.
      * 
      * Funcionalidades en las que se usa: Pago de nomina
      */
 
    public static int calcularPago(Persona persona){
         
        int trabajo = persona.getTrabajado();
        int salario = Persona.getSalario();
        int total = 0;     
 
        //Diferentes pagos según el salario para cada uno de los tipos
        if (persona instanceof Operario){
            total =+ (salario + 15000)*trabajo;
        }
        else if (persona instanceof Vendedor){
            total =+ (salario + 20000)*trabajo;
        }
        else if(persona instanceof Transportador){
            total =+ (salario + 10000)*trabajo;
        }
 
        return total;
    }
 
 
 
    /**
      * Devuelve dinero a un cliente incrementando el saldo de su cuenta bancaria.
      * 
      * @param cantidad Cantidad de dinero a devolver.
      * 
      * @param cliente Cliente al cual se le va a devolver el dinero.
      * 
      * Funcionalidades en las que se usa: Devolucion de productos
      */
 
    public void devolverDinero(double cantidad, Cliente cliente){
 
        cliente.getCuentaBancaria().incrementarSaldo(cantidad);
    }
     
 
 
    // GETTERS Y SETTERS --------------------------------------------------------------------------------------------------------------------------------------
     
 
    public int getNumeroCuenta() {
 
        return numeroCuenta;
    }
     
 
    public void setNumeroCuenta(int numeroCuenta) {
 
        this.numeroCuenta = numeroCuenta;
    }
 
     
    public int getSaldo() {
 
        return saldo;
    }
 
     
    public void setSaldo(int saldo) {
 
        this.saldo = saldo;
    }
}
