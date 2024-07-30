/**
 * Este módulo pertenece al paquete 'gestorAplicacion.externo' y contiene una enumeración para representar
 * los diferentes tipos de transporte y sus atributos. Incluye la clase 'TipoTransporte' que define los diferentes
 * tipos de transporte, sus capacidades y costos.
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo, 
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


package gestorAplicacion.externo;

import java.util.ArrayList;
import java.util.Random;
 
import gestorAplicacion.empleados.Transportador;
 
 
/**
  * La enumeración 'TipoTransporte' representa los diferentes tipos de transporte disponibles.
  * 
  * Contiene información sobre el costo de envío, la capacidad de carga y el nombre del transporte.
  * 
  * Proporciona métodos para gestionar estos atributos y seleccionar el transporte adecuado según la carga.
  * 
  * Funcionalidades en las que se usa:
  *      - Envio pedidos
  */
 
public enum TipoTransporte {
     
    //CONSTANTES -------------------------------------------------------------------------------------------------------------------
    CAMINANDO(1000, 5,"Caminando"),
    BICICLETA(2000,8,"Bicicleta"),
    MOTO(5000, 10, "Moto"),
    CARRO(10000,30,"Carro"),
    CAMION(50000, 100, "Camion"),
    AVION(500000, 1000,"Avion");
     
 
    // ATRIBUTOS -----------------------------------------------------------------------------------------------------------------------------
     
    // De instancia
    double precioEnvio_COP; //pesos colombianos
    double capacidad_KG; //kilogramos
    String nombre;
 
 
    // CONSTRUCTOR -----------------------------------------------------------------------------------------------------------------------------
     
    /**
      * Constructor que recibe los parámetros:
      * 
      * @param precioEnvio Costo de envío en pesos colombianos
      * 
      * @param capacidad Capacidad de carga en kilogramos
      * 
      * @param nombre Nombre del tipo de transporte
      */
 
    private TipoTransporte(int precioEnvio, double capacidad, String nombre) {
         
        // Constructor privado para que solo se tengan las constantes definidas anteriormente    
        this.precioEnvio_COP = precioEnvio;
        this.capacidad_KG = capacidad;
        this.nombre = nombre;
    }
 
 
 
    // MÉTODOS --------------------------------------------------------------------------------------------------------------------------------------
     
 
    /**
      * Verifica qué tipos de transporte son aptos según el peso de los productos a enviar.
      * 
      * @param PesoTotalProductos Peso total de los productos a enviar
      * 
      * @return Una lista de tipos de transporte que pueden manejar el peso total de los productos
      * 
      * Funcionalidades en las que se usa: Envio pedidos
      */
 
    public static ArrayList<TipoTransporte> transporteSegunCarga(int PesoTotalProductos){
         
        ArrayList<TipoTransporte> transportesPosibles = new ArrayList<TipoTransporte>();
         
        for(TipoTransporte tipoTransporte : TipoTransporte.values()) {
             
            if(tipoTransporte.getCapacidad_KG() >= PesoTotalProductos){
                transportesPosibles.add(tipoTransporte); 
            }
    }
 
    return transportesPosibles;
    }
 
 
     
    /**
      * Muestra los tipos de transporte disponibles según la carga.
      * 
      * @param transportesPosibles Lista de tipos de transporte posibles
      * 
      * @return Una cadena de texto con información sobre los tipos de transporte disponibles
      * 
      * Funcionalidades en las que se usa: Envio pedidos
      */
 
    public static String mostrarTransporteSegunCarga(ArrayList<TipoTransporte> transportesPosibles){
         
        String mensajeTransportesPosibles = "";
        int numero = 1;
         
        for(TipoTransporte tipoTransportes : transportesPosibles) {
            mensajeTransportesPosibles += numero + ". " + tipoTransportes.getNombre() + " $" + tipoTransportes.getPrecioEnvio_COP() + "\n";
            numero++;
        }
         
        return mensajeTransportesPosibles;
    }
 
 
 
    /**
      * Selecciona el transporte y le asigna un transportador aleatorio.
      * 
      * @param ListaFiltrada Lista de tipos de transporte filtrada según la carga
      * 
      * @param opcion Opción seleccionada por el usuario (1-based)
      * 
      * @return Un objeto Transporte con las características seleccionadas
      * 
      * Funcionalidades en las que se usa: Envio pedidos
      */
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
 
 
 
    /**
      * Genera una representación en cadena del tipo de transporte.
      * 
      * @return Una cadena de texto con el nombre del tipo de transporte
      */
 
    @Override
    public String toString() {
        return this.getNombre();
    }
 
 
 
    //GETTERS Y SETTERS ------------------------------------------------------------------------------------------------------------------------------
 
 
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
