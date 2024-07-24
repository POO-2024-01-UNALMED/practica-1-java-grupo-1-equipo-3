/**
 * Este módulo pertenece al paquete 'gestorAplicacion.empleados' y contiene la clase 'Meta', que define las 
 * características y comportamientos de las diferentes metas que se les pueden dar a los empleados, estas metas
 * permiten verificar el cumplimiento de estas metas y dar bonificaciones por su cumplimiento.
 * 
 * AUTORES: Sebastian Estrada Villa, Valentina Luján Robledo,
 * Luis David Ramirez Gonzales, Santiago Ochoa Quintero
 */


 package gestorAplicacion.empleados;

 import java.io.Serializable;
 
 
 /**
  * La clase 'Meta' representa una meta de rendimiento para los empleados, incluyendo el nivel de la meta, 
  * el valor mínimo a alcanzar y la comisión por cumplir la meta.
  * 
  * Funcionalidades en las que se usa: 
  *      - Pago de nomina
  */
 
 public class Meta implements Serializable{
     
     //ATRIBUTOS--------------------------------------------------------------------------------------------------------------------------------------
     
     // De instancia
     private static final long serialVersionUID = 1L; // Versión del serializado asociada a esta clase
     private String nivel;
     private double minimo;
     private double comision;
 
 
     // CONSTRUCTOR-------------------------------------------------------------------------------------------------------------------------------------
 
      /**
      * Constructor de la clase Meta.
      * 
      * @param nivel Nivel de la meta (Por ejemplo: "Facil", "Intermedio", "Dificil")
      * 
      * @param minimo Valor mínimo a alcanzar para cumplir la meta
      * 
      * @param comision Comisión por cumplir la meta
      */
 
     public Meta(String nivel, double minimo, double comision) {
        
         this.nivel = nivel;
         this.minimo = minimo;
         this.comision = comision;
     }
 
 
 
     //MÉTODOS----------------------------------------------------------------------------------------------------------
 
 
     /**
      * Determina si se cumplió la meta esperada. 
      * 
      * @param valorAlcanzado Valor alcanzado por el empleado
      * 
      * @return true si el valor alcanzado es mayor o igual al mínimo, false en caso contrario
      * 
      * Funcionalidades en las que se usa: Pago de nomina
      */
     
     public boolean cumplioMeta(double valorAlcanzado) {
         
         return valorAlcanzado >= minimo;
     }
 
 
 
     /**
      * Calcula el porcentaje de cumplimiento de la meta.
      * 
      * @param valorAlcanzado Valor alcanzado por el empleado
      * 
      * @return Una cadena de texto que indica el porcentaje de cumplimiento de la meta. 
      *         Si no se alcanzó el 100%, también incluye el porcentaje faltante y la cantidad faltante del valor mínimo.
      * 
      * Funcionalidades en las que se usa: Pago de nomina
      */
 
     public String porcentajeCumplimiento(double valorAlcanzado) {
         
         double porcentajeCumplido = (valorAlcanzado / minimo) * 100;
         String mensaje = "Porcentaje de cumplimiento: " + porcentajeCumplido + "%";
         
         if (porcentajeCumplido < 100){
             mensaje += "\nPorcentaje faltante: " + (100 - porcentajeCumplido) + "%";
             mensaje += "\nCantidad faltante del indice indicado: " + (minimo - valorAlcanzado); 
         }
         
         return mensaje;
     }
 
 
 
     /**
      * Devuelve una representación en cadena del objeto Meta.
      * 
      * @return Cadena de texto con información sobre la meta
      */
     
     public String toString(){
         
         return "\n"
         + "Minimo requerido:                 " + minimo + "\n"
         + "Bonificación por cumplimiento:    " + comision + "\n";
     }
 
 
 
     // GETTERS Y SETTERS---------------------------------------------------------------------------------------------------------
     
 
     public String getNivel() {
         
         return this.nivel;
     }
 
 
     public void setNivel(String nivel) {
         
         this.nivel = nivel;
     }
     
 
     public double getMinimo() {
         
         return minimo;
     }
 
 
     public void setMinimo(double minimo) {
 
         this.minimo = minimo;
     }
 
 
     public double getComision() {
         
         return comision;
     }
 
 
     public void setComision(double comision) {
         
         this.comision = comision;
     }
 }
