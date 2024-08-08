/**
 * Este módulo pertenece al paquete 'gestorAplicacion.empresa' y contiene La interfaz 'Moda' que 
 * representa un tipo de dato que define un nombre. Es utilizada para obtener el nombre de los 
 * elementos que se desean analizar y encontrar la moda entre un conjunto de datos.
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo, 
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


package gestorAplicacion.empresa;


 /**
  * 'Moda' representa una interfaz que permite seleccionar objetos para poder encontrar la moda en 
  * la funcionalidad de evaluación operación. Esta interfaz tiene un único método llamado 'getNombre'.
  */
 
public abstract interface Moda {
 
     // MÉTODOS ------------------------------------------------------------------------------------------------------------------------------------------
     
     
     /**
      * Obtiene el nombre del elemento.
      *
      * @return el nombre del elemento como un String.
      * 
      * Funcionalidades en las que se usa: Evaluacion operacion
      */
 
    public abstract String getNombre(); 
     
}