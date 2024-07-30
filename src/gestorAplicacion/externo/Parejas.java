/**
 * Este módulo pertenece al 'paquete gestorAplicacion.externo' y contiene una clase genérica para representar
 * pares de valores, similar a un diccionario. Incluye la clase 'Parejas' que permite almacenar pares de valores
 * <clave, valor> y proporciona métodos para gestionar estos pares.
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo, 
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


 package gestorAplicacion.externo;

 import java.io.Serializable;
 
 
 /**
  * La clase 'Parejas' representa un par de valores <clave, valor>.
  * 
  * Permite almacenar y gestionar pares de valores de cualquier tipo, similar a un diccionario.
  * 
  * Proporciona métodos para obtener y establecer la clave y el valor.
  * 
  * @param <Clave> Tipo de la clave
  * 
  * @param <Valor> Tipo del valor
  */ 
 
 public class Parejas<Clave, Valor> implements Serializable {
     
     // ATRIBUTOS ----------------------------------------------------------------------------------------------------------------------------------------------------
     
     // De clase 
     private static final long serialVersionUID = 1L; // Versión del serializado asociada a esta clase
     
     // De instancia
     // Representan las claves y valores de un diccionario
     private Clave key;
     private Valor value;
     
 
     // CONSTRUCTORES -----------------------------------------------------------------------------------------------------------------------
     
     /**
      * Constructor que recibe los parámetros.
      * 
      * @param key Clave del par
      * 
      * @param value Valor del par
      */
 
     public Parejas(Clave key, Valor value) {
         
         this.key = key;
         this.value = value;
     }
 
 
     /**
      * Constructor vacío.
      */
 
     public Parejas(){}
 
 
 
     // GETTERS Y SETTERS --------------------------------------------------------------------------------------------------------------------
     
     
     public Clave getKey() {
         
         return key;
     }
 
     
     public void setKey(Clave key) {
         
         this.key = key;
     }
 
     
     public Valor getValue() {
         
         return value;
     }
 
     
     public void setValue(Valor value) {
         
         this.value = value;
     }
 }
