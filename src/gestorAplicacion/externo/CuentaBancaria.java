package gestorAplicacion.externo;
import java.io.Serializable;

import gestorAplicacion.empleados.Operario;
import gestorAplicacion.empleados.Transportador;
import gestorAplicacion.empleados.Vendedor;

public class CuentaBancaria implements Serializable {
    // ATRIBUTOS
    // De instancia
    private static final long serialVersionUID = 1525353L; // Versión del serializado asociada a esta clase 
    private int numeroCuenta;
    private int saldo;
    

    // CONSTRUCTOR
    public CuentaBancaria(int numeroCuenta, int saldo) {
        
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
    

    // MÉTODOS
    // Método para incrementar el saldo de la cuenta
    public void incrementarSaldo(double cantidad) {
        
        saldo += cantidad;
    }
    
    // Método para disminuir el saldo de la cuenta
    public void disminuirSaldo(double cantidad) {
        
        saldo -= cantidad;
    }
    
    // Método estático para calcular el pago de los empleados
    public static int calcularPago(Persona persona){
        
        int trabajo = persona.getTrabajado();
        int salario = Persona.getSalario();
        int total = 0;     

        //Diferentes pagos según el salario para cada uno de los tipos
        if (persona instanceof Operario){
            total =+ (salario + 150000)*trabajo;
        }
        else if (persona instanceof Vendedor){
            total =+ (salario + 200000)*trabajo;
        }
        else if(persona instanceof Transportador){
            total =+ (salario + 100000)*trabajo;
        }

        return total;
    }

    // Método para devolver dinero
    public void devolverDinero(double cantidad, Cliente cliente){

        CuentaBancaria cuenta = cliente.getCuentaBancaria();
        cuenta.incrementarSaldo(cantidad);
    }
    

    // GETTERS Y SETTERS
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
