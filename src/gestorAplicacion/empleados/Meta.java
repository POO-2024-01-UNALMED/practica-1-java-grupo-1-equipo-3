package gestorAplicacion.empleados;

import java.io.Serializable;

public class Meta implements Serializable{
    //ATRIBUTOS
    // De instancia
    private static final long serialVersionUID = 1L; // Versión del serializado asociada a esta clase
    private String nivel;
    private double minimo;
    private double comision;


    // CONSTRUCTOR
    public Meta(String nivel, double minimo, double comision) {
       
        this.nivel = nivel;
        this.minimo = minimo;
        this.comision = comision;
    }


    //MÉTODOS
    // Método para determinar si se cumplió la meta esperada
    public boolean cumplioMeta(double valorAlcanzado) {
        
        return valorAlcanzado >= minimo;
    }

    // Método para calcular el porcentaje de cumplimiento de la meta
    public String porcentajeCumplimiento(double valorAlcanzado) {
        
        double porcentajeCumplido = (valorAlcanzado / minimo) * 100;
        String mensaje = "Porcentaje de cumplimiento: " + porcentajeCumplido + "%";
        
        if (porcentajeCumplido < 100){
            mensaje += "\nPorcentaje faltante: " + (100 - porcentajeCumplido) + "%";
            mensaje += "\nCantidad faltante del indice indicado: " + (minimo - valorAlcanzado); 
        }
        
        return mensaje;
    }

    // Método para calcular las comisiones que deben pagarsele al empleado
    public double pagoComisiones(double valorAlcanzado) {
        
        if (cumplioMeta(valorAlcanzado)) {
            return comision;
        } else {
            return 0.0; // No se paga comisión si no se cumplió la meta
        }
    }

    // Método para definir el mensaje que se mostrará al imprimir un objeto de esta clase
    public String toString(){
        
        return "\n"
        + "Minimo requerido:                 " + minimo + "\n"
		+ "Bonificación por cumplimiento:    " + comision + "\n";
    }


    // GETTERS Y SETTERS
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
