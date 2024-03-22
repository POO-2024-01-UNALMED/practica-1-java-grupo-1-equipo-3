package gestorAplicacion.externo;
import gestorAplicacion.empleados.Operario;
import gestorAplicacion.empleados.Transportador;
import gestorAplicacion.empleados.Vendedor;

public class CuentaBancaria {
        // Atributos de instancia
        private int numeroCuenta;
        private int saldo;
    
        // Constructor
        public CuentaBancaria(int numeroCuenta, int saldo) {
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldo;
        }
    
        // Método para incrementar el saldo de la cuenta
        public void incrementarSaldo(int cantidad) {
            saldo += cantidad;
        }
    
        // Método para disminuir el saldo de la cuenta
        public void disminuirSaldo(int cantidad) {
            saldo -= cantidad;
        }
    
        // Método estático para calcular el pago de un Operario
        public static int calcularPago(Operario persona, double comision) {
            return (int) (Operario.getSALARIO() + comision);
        }

        // Método estático para calcular el pago de un Transportador
        public static int calcularPago(Transportador persona, double comision) {
            return (int) (Transportador.getSALARIO() + comision);
        }

        // Método estático para calcular el pago de un Vendedor
        public static int calcularPago(Vendedor persona, double comision) {
            return (int) (Vendedor.getSALARIO() + comision);
        }
    
        // Getters y setters
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
