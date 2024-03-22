package gestorAplicacion.externo;

public class Persona {
     // Atributos de instancia
     protected String nombre;
     protected int edad;
     protected CuentaBancaria cuentaBancaria;
     protected int identificacion;
 
     // Constructor
     public Persona(String nombre, int edad, int numeroCuenta, int saldo, int identificacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.cuentaBancaria = new CuentaBancaria(numeroCuenta, saldo);
        this.identificacion = identificacion;
     }
 
     // Método para realizar pagos
     public void hacerPagos(int cantidad) {
         // Realizar el pago disminuyendo el saldo de la cuenta bancaria
         cuentaBancaria.disminuirSaldo(cantidad);
         System.out.println("Pago de " + cantidad + " realizado correctamente.");
     }
 
     // Getters y setters
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
 
     public CuentaBancaria getCuentaBancaria() {
         return cuentaBancaria;
     }
 
     public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
         this.cuentaBancaria = cuentaBancaria;
     }
 
     public int getIdentificacion() {
         return identificacion;
     }
 
     public void setIdentificacion(int identificacion) {
         this.identificacion = identificacion;
     }
}
