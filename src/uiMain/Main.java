package uiMain;

public class Main {
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
}
