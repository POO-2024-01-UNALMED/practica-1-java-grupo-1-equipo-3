/**
 * Este módulo pertenece al paquete 'baseDatos' y contiene la clase 'Serializador'.
 * Proporciona la funcionalidad para serializar objetos y guardar los datos en archivos.
 * 
 * Incluye métodos para guardar datos específicos como facturas, tiendas, fábrica, catálogo, clientes, vendedores, 
 * transporte y transportadores.
 * 
 * AUTORES: - Sebastian Estrada Villa
 *          - Valentina Luján Robledo
 *          - Santiago Ochoa Quintero
 */

package baseDatos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
 
 
/**
  * La clase 'Serializador' gestiona la serialización de objetos y su almacenamiento en archivos.
  */
 
public class Serializador {
 
 
    /**
      * Serializa un objeto y lo guarda en un archivo.
      * 
      * @param objeto El objeto a serializar.
      * 
      * @param strArchivo La ruta del archivo donde se guardará el objeto serializado.
      */
 
    public static void serializar(Serializable objeto, String strArchivo){
 
        ObjectOutputStream objectOutputStream;
         
        FileOutputStream fileOutputStream;
 
 
        try{
             
            fileOutputStream = new FileOutputStream(strArchivo);
    
            objectOutputStream = new ObjectOutputStream(fileOutputStream);       
    
            objectOutputStream.writeObject(objeto);
             
            objectOutputStream.flush();
             
            objectOutputStream.close();
    
 
            }catch(IOException e){
 
                System.out.println("ERROR: HA OCURRIDO UN ERROR EN LA SERIALIZACIÓN");
                 
                e.printStackTrace();
            }
    }
 
 
 
    /**
      * Guarda las facturas serializadas en un archivo.
      */
 
    public static void guardarFacturas(){
 
        serializar(Cargar.facturas, "src/baseDatos/temp/facturas.txt");
 
    }
 
 
 
    /**
      * Guarda las tiendas serializadas en un archivo.
      */
 
    public static void guardarTiendas(){
 
        serializar(Cargar.tiendas, "src/baseDatos/temp/tiendas.txt");
 
    }
 
 
 
    /**
      * Guarda la fábrica serializada en un archivo.
      */
 
    public static void guardarFabrica(){
 
        serializar(Cargar.fabrica, "src/baseDatos/temp/fabrica.txt");
    }
 
 
 
    /**
      * Guarda el catálogo serializado en un archivo.
      */
 
    public static void guardarCatalogo(){
 
        serializar(Cargar.catalogo, "src/baseDatos/temp/catalogo.txt");
    }
 
 
 
    /**
      * Guarda los clientes serializados en un archivo.
      */
     
    public static void guardarClientes(){
 
        serializar(Cargar.clientes, "src/baseDatos/temp/clientes.txt");
    }
 
 
 
    /**
      * Guarda los vendedores serializados en un archivo.
      */
 
    public static void guardarVendedores(){
            
        serializar(Cargar.vendedores, "src/baseDatos/temp/vendedores.txt");
    }
 
 
 
    /**
      * Guarda el transporte serializado en un archivo.
      */
 
    public static void guardarTransporte(){
 
        serializar(Cargar.transporteAbastecer, "src/baseDatos/temp/transporte.txt");
    }
 
 
 
    /**
      * Guarda los transportadores serializados en un archivo.
      */
 
    public static void guardarTransportadores(){
             
        serializar(Cargar.transportadores, "src/baseDatos/temp/transportadores.txt");
    }
 
 
 
    /**
      * Guarda los atributos serializados en un archivo.
      */
     
    public static void guardarAtributos(){
             
        serializar(Cargar.infoAtributos, "src/baseDatos/temp/infoAtributos.txt");
    }
}