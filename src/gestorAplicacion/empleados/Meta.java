package gestorAplicacion.empleados;

public class Meta {
    //Atributos de instancia
    protected double minimo;
    protected double valorEsperado;
    protected double porcentajeCumplido;
    protected double comision;

    // Constructor
    public Meta(double minimo, double valorEsperado, double comision) {
        this.minimo = minimo;
        this.valorEsperado = valorEsperado;
        this.comision = comision;
        this.porcentajeCumplido = 0.0; // Porcentaje inicialmente 0
    }

    // Método para determinar si se cumplió la meta esperada
    public boolean cumplioMeta(double valorAlcanzado) {
        return valorAlcanzado >= minimo;
    }

    // Método para calcular el porcentaje de cumplimiento de la meta
    public double porcentajeCumplimiento(double valorAlcanzado) {
        porcentajeCumplido = (valorAlcanzado / valorEsperado) * 100;
        return porcentajeCumplido;
    }

    // Método para calcular las comisiones que deben pagarsele al empleado
    public double pagoComisiones(double valorAlcanzado) {
        if (cumplioMeta(valorAlcanzado)) {
            return comision;
        } else {
            return 0.0; // No se paga comisión si no se cumplió la meta
        }
    }

    // Getters y setters 
    public double getMinimo() {
        return minimo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public double getValorEsperado() {
        return valorEsperado;
    }

    public void setValorEsperado(double valorEsperado) {
        this.valorEsperado = valorEsperado;
    }

    public double getPorcentajeCumplido() {
        return porcentajeCumplido;
    }

    public void setPorcentajeCumplido(double porcentajeCumplido) {
        this.porcentajeCumplido = porcentajeCumplido;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
}
