package gestorAplicacion.empleados;

import gestorAplicacion.externo.CuentaBancaria;
import gestorAplicacion.externo.Persona;
import gestorAplicacion.empresa.Tienda;
import java.util.ArrayList;
import java.util.List;


public class Vendedor extends Persona {
    // ATRIBUTOS
    // De clase
    private static ArrayList<Meta> metas = new ArrayList<Meta>(List.of(
        new Meta("Facil",6,12000),
        new Meta("intermedio",9,18000),
        new Meta("Dificil",12,25000))); //Crear una lista inmutable 
    
    // De instancia
    private Tienda tienda;


    //CONSTRUCTORES
    // Constructor que recibe todos los parametros
    public Vendedor(String nombre, int edad, int identificacion, CuentaBancaria cuentaBancaria,Tienda tienda) {
		
        super(nombre, edad, identificacion, cuentaBancaria);
		this.tienda=tienda;
	}
	
	// Constructor que no recibe parametros
	public Vendedor() {}


    // MÉTODOS
    // Método sobreescrito de la clase Persona para realizar el pago de salario a un objeto de tipo vendedor
    @Override
    public void recibirPagos(double pago){

        tienda.getCuentaBancaria().disminuirSaldo(pago);
        super.getCuentaBancaria().incrementarSaldo(pago);
    }

    //Método para definir el mensaje que se mostrará al imprimir un objeto de la clase
    @Override
	public String toString() {

		return "\n"
        + "Nombre:             " + getNombre() + "\n"
		+ "Edad:               " + getEdad() + "\n"
		+ "Cedula:             " + getIdentificacion() + "\n"
		+ "Tienda:             " + getTienda().getNombre() + "\n";
	}


    //GETTERS Y SETTERS
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
