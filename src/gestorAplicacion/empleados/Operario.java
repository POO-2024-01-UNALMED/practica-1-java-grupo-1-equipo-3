package gestorAplicacion.empleados;

import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.empresa.Fabrica;
import gestorAplicacion.externo.CuentaBancaria;
import gestorAplicacion.externo.Persona;


public class Operario extends Persona {
    // ATRIBUTOS
    // De clase
    private static ArrayList<Meta> meta = new ArrayList<Meta>(List.of(
        new Meta("Facil",4,30000),
        new Meta("intermedio",7,50000),
        new Meta("Dificil",10,70000))); //Crear una lista inmutable 
    
    //De instancia
    private Fabrica fabrica;


    //CONSTRUCTORES
    // Constructor para cuando la fabrica ya existe
    public Operario(String nombre, int edad, int identificacion, CuentaBancaria cuentaBancaria, Fabrica fabrica) {
       
        super(nombre, edad, identificacion, cuentaBancaria);
        this.fabrica = fabrica;
    }

    // Constructor para cuando la fabrica NO existe
    public Operario(String nombre, int edad, int identificacion, CuentaBancaria cuentaBancaria) {
        
        super(nombre, edad, identificacion, cuentaBancaria);
    }

    // Constructor que no recibe parametros
    public Operario(){}


    // MÉTODOS
    // Método sobreescrito de la clase Persona para realizar el pago de salario a un objeto de tipo operario
    @Override
    public void recibirPagos(double pago) {
        
        fabrica.getCuentaBancaria().disminuirSaldo(pago);
		this.getCuentaBancaria().incrementarSaldo(pago);
        
    }

    // Método para definir el mensaje que se mostrará al imprimir un objeto de esta clase
    @Override
	public String toString() {
		
        return "\n" 
        + "Nombre:              " + getNombre() + "\n"
        + "Edad:                " + getEdad() + "\n"
        + "Identificación:      " + getIdentificacion() + "\n"
		+ "Fabrica:             " + getFabrica() + "\n";
	}


    // GETTERS Y SETTERS
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

