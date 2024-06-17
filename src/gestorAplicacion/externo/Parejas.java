package gestorAplicacion.externo;

import java.io.Serializable;

// Clase para reemplazar los diccionarios 
public class Parejas<Clave, Valor> implements Serializable {
    
    private static final long serialVersionUID = 1L; // Versión del serializado asociada a esta clase
    
    // Atributos que representan las claves y valores de un diccionario
    private Clave key;
    private Valor value;
    

    // CONSTRUCTORES
    // Constructor que recibe los parametros
    public Parejas(Clave key, Valor value) {
        
        this.key = key;
        this.value = value;
    }

    //Constructor vacio
    public Parejas(){}


    // GETTERS Y SETTERS
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
