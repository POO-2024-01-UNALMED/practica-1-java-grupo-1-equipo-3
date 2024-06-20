package gestorAplicacion.empleados;

import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.empresa.Fabrica;
import gestorAplicacion.externo.CuentaBancaria;
import gestorAplicacion.externo.Persona;
import gestorAplicacion.externo.Transporte;


public class Transportador extends Persona{
    // ATRIBUTOS
    // De clase
    private static ArrayList<Meta> metas = new ArrayList<Meta>(List.of(
        new Meta("Facil",4,10000),
        new Meta("intermedio",7,15000),
        new Meta("Dificil",10,20000))); //Crear una lista inmutable
	private static ArrayList<Transportador> listaTransportadores = new ArrayList<Transportador>();
    
    // De instancia
    private Transporte transporte;
	private Fabrica fabrica;

    
    // CONSTRUCTORES
	// Constructor que recibe todos los parametros
	public Transportador(String nombre, int edad, int identificacion, CuentaBancaria cuentaBancaria,Transporte transporte) {
		
		super(nombre, edad, identificacion, cuentaBancaria);
		this.transporte = transporte;
		listaTransportadores.add(this);
	}

	//Constructor sin parametros
	public Transportador() {}
	

    // MÉTODOS
    // Método sobreescrito de la clase Persona para realizar el pago de salario a un objeto de tipo transportador
    @Override
	public void recibirPagos(double pago) {
		
		fabrica.getCuentaBancaria().disminuirSaldo(pago);
		super.getCuentaBancaria().incrementarSaldo(pago);
	}
	

	@Override
	public String toString() {
		
		return "\n"
		+ "Nombre: 			" + getNombre() + "\n"
        + "Edad: 			" + getEdad() + "\n"
        + "Cedula:			" + getIdentificacion() + "\n"
		+ "Transporte:	    " + getTransporte().getTipo() + "\n";
		
	}
	
    
    // GETTERS Y SETTERS
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
