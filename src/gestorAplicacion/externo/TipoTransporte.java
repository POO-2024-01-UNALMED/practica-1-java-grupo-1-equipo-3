package gestorAplicacion.externo;

import java.util.ArrayList;
import java.util.Random;

import gestorAplicacion.empleados.Transportador;

public enum TipoTransporte {
    //CONSTANTES
    CAMINANDO(1000, 5,"Caminando"),
    BICICLETA(2000,8,"Bicicleta"),
    MOTO(5000, 10, "Moto"),
    CARRO(10000,30,"Carro"),
    CAMION(50000, 100, "Camion"),
    AVION(500000, 1000,"Avion");
    

    // ATRIBUTOS 
    // De instancia
    double precioEnvio_COP; //pesos colombianos
    double capacidad_KG; //kilogramos
    String nombre;


    // CONSTRUCTOR
    private TipoTransporte(int precioEnvio, double capacidad, String nombre) {
        
        this.precioEnvio_COP = precioEnvio;
        this.capacidad_KG = capacidad;
        this.nombre = nombre;
    }


    // MÉTODOS
    // Método para verificar que tipos de transporte son aptos según el peso de los productos a enviar
    public static ArrayList<TipoTransporte> transporteSegunCarga(int PesoTotalProductos){
		
        ArrayList<TipoTransporte> transportesPosibles = new ArrayList<TipoTransporte>();
		
        for(TipoTransporte tipoTransporte : TipoTransporte.values()) {
            
            if(tipoTransporte.getCapacidad_KG() >= PesoTotalProductos){
                transportesPosibles.add(tipoTransporte); 
            }
	}

    return transportesPosibles;
    }
    
    // Método para mostrar los tipos de transporte disponibles según la carga
    public static String mostrarTransporteSegunCarga(ArrayList<TipoTransporte> transportesPosibles){
		
        String mensajeTransportesPosibles = "";
        int numero = 1;
		
        for(TipoTransporte tipoTransportes : transportesPosibles) {
			mensajeTransportesPosibles += numero + ". " + tipoTransportes.getNombre() + " $" + tipoTransportes.getPrecioEnvio_COP() + "\n";
			numero++;
		}
        
        return  mensajeTransportesPosibles;
    }

    // Selecciona el transporte y le asigna un transportador aleatorio
    public static Transporte seleccionarTransporte(ArrayList<TipoTransporte> ListaFiltrada,int opcion){

        Random random = new Random();
        int indice = random.nextInt(Transportador.getListaTransportadores().size()); //se genera un nuero aleatorio con un maximo en el tamaño de la lista de transportadores 
        Transportador transportador = Transportador.getListaTransportadores().get(indice);
        TipoTransporte tipo = ListaFiltrada.get(opcion-1);
        Double capacidad= ListaFiltrada.get(opcion-1).getCapacidad_KG();
        Double precioEnvio = ListaFiltrada.get(opcion-1).getPrecioEnvio_COP();
        Transporte transporte = new Transporte(tipo,capacidad,precioEnvio,transportador); //Se crea un objeto de tipo Transporte con las caracteristicas requeridas
        transportador.setTransporte(transporte);

        return transporte;
    }

    // Método para definir el mensaje que se mostrará al imprimir un objeto de la clase
    @Override
    public String toString() {
        return this.getNombre();
    }


    //GETTERS Y SETTERS
    public double getPrecioEnvio_COP() {
        
        return precioEnvio_COP;
    }

    public void setPrecioEnvio_COP(double precioEnvio) {
        
        this.precioEnvio_COP = precioEnvio;
    }

    public double getCapacidad_KG() {
        
        return capacidad_KG;
    }

    public void setCapacidad_KG(double capacidad) {
        
        this.capacidad_KG = capacidad;
    }

    public String getNombre() {
        
        return nombre;
    }

    public void setNombre(String nombre) {
        
        this.nombre = nombre;
    }
}
