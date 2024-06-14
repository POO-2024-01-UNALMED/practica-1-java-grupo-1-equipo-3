package baseDatos;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializador {

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


    public static void guardarFacturas(){

        serializar(Cargar.facturas, "src/baseDatos/temp/facturas.txt");

    }


    public static void guardarTiendas(){

        serializar(Cargar.tiendas, "src/baseDatos/temp/tiendas.txt");

    }


    public static void guardarFabrica(){

        serializar(Cargar.fabrica, "src/baseDatos/temp/fabrica.txt");
    }


    public static void guardarCatalogo(){

        serializar(Cargar.catalogo, "src/baseDatos/temp/catalogo.txt");
    }


    public static void guardarClientes(){

        serializar(Cargar.clientes, "src/baseDatos/temp/clientes.txt");
    }


    public static void guardarVendedores(){
           
        serializar(Cargar.vendedores, "src/baseDatos/temp/vendedores.txt");
    }


    public static void guardarTransporte(){

        serializar(Cargar.transporteAbastecer, "src/baseDatos/temp/transporte.txt");
    }


    public static void guardarTransportadores(){
            
        serializar(Cargar.transportadores, "src/baseDatos/temp/transportadores.txt");
    }

        
    public static void guardarAtributos(){
            
        serializar(Cargar.infoAtributos, "src/baseDatos/temp/infoAtributos.txt");
    }
}
