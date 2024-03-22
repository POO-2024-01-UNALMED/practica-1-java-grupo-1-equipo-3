package gestorAplicacion.empleados;

import gestorAplicacion.empresa.Fabrica;
//import gestorAplicacion.externo.CuentaBancaria;
import gestorAplicacion.externo.Persona;

public class Operario extends Persona {
    // Atributos de instancia
    private Meta meta;
    private Fabrica fabrica;
    private double produccion;

    // Atributo de clase y final
    private static final double SALARIO = 1500000;

    // Constructor para cuando la fabrica ya existe
    public Operario(String nombre, int edad, int numeroCuenta, int saldo, int identificacion, double minimo, double valorEsperado, double comision, Fabrica fabrica) {
        super(nombre, edad, numeroCuenta, saldo, identificacion);
        this.meta = new Meta(minimo, valorEsperado, comision);
        this.fabrica = fabrica;
        this.produccion = 0.0;
    }

    // Constructor para cuando la fabrica NO existe
    public Operario(String nombre, int edad, int numeroCuenta, int saldo, int identificacion, double minimo, double valorEsperado, double comision) {
        super(nombre, edad, numeroCuenta, saldo, identificacion);
        this.meta = new Meta(minimo, valorEsperado, comision);
        this.produccion = 0.0;
    }

    // Método
    public void pagoSalario(int horasTrabajadas) {
        
    }

    // Getters y setters
    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Fabrica getFabrica() {
        return fabrica;
    }

    public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    public double getProduccion() {
        return produccion;
    }

    public void setProduccion(double produccion) {
        this.produccion = produccion;
    }

    public static double getSALARIO() {
        return SALARIO;
    }
}
