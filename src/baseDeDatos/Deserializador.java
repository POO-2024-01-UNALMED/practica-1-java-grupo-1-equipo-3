/**
 * Este módulo pertenece al paquete 'baseDatos' y contiene la clase 'Deserializador'.
 * Proporciona la funcionalidad para deserializar objetos desde archivos.
 * 
 * Incluye métodos para cargar datos específicos como facturas, tiendas, fábrica, catálogo, clientes, 
 * vendedores, transporte y transportadores.
 * 
 * AUTORES: - Sebastian Estrada Villa
 *          - Valentina Luján Robledo
 *          - Santiago Ochoa Quintero
 */

package baseDeDatos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.empleados.Transportador;
import gestorAplicacion.empleados.Vendedor;
import gestorAplicacion.empresa.Fabrica;
import gestorAplicacion.empresa.Factura;
import gestorAplicacion.empresa.Moda;
import gestorAplicacion.empresa.Producto;
import gestorAplicacion.empresa.Tienda;
import gestorAplicacion.externo.Cliente;
import gestorAplicacion.externo.Parejas;
import gestorAplicacion.externo.Transporte;


/**
 * La clase 'Deserializador' gestiona la deserialización de objetos desde archivos.
 */

public class Deserializador {
    

    /**
     * Deserializa un objeto desde un archivo.
     * 
     * @param strArchivo La ruta del archivo desde donde se deserializará el objeto.
     * 
     * @return El objeto deserializado.
     * 
     * @throws IOException Si ocurre un error de entrada/salida.
     * 
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra.
     */

    public static Serializable deserializar(String strArchivo) throws IOException, ClassNotFoundException{

        FileInputStream fileInputStream;
        
        ObjectInputStream objectInputStream;

        fileInputStream = new FileInputStream(strArchivo);
            
        objectInputStream = new ObjectInputStream(fileInputStream);
        
        Serializable s = (Serializable) objectInputStream.readObject();
        
        objectInputStream.close();
      

        return s;
    }



    /**
     * Carga las facturas deserializadas desde un archivo.
     * 
     * @return Una lista de objetos 'Factura'.
     * 
     * @throws IOException Si ocurre un error de entrada/salida.
     * 
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra.
     */

    public static ArrayList<Factura> cargarFacturas() throws IOException, ClassNotFoundException{
        
        @SuppressWarnings("unchecked") // Para que no saque un error al hacer el .jar 
       
        ArrayList<Factura> facturas = (ArrayList<Factura>) deserializar("src/baseDeDatos/temp/facturas.txt");

        
        return facturas;
    }



    /**
     * Carga la fábrica deserializada desde un archivo.
     * 
     * @return Un objeto 'Fabrica'.
     * 
     * @throws IOException Si ocurre un error de entrada/salida.
     * 
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra.
     */

    public static Fabrica cargarFabrica() throws IOException, ClassNotFoundException{

        Fabrica fabrica = (Fabrica) deserializar("src/baseDeDatos/temp/fabrica.txt");

        return fabrica;
    }



    /**
     * Carga el catálogo deserializado desde un archivo.
     * 
     * @return Una lista de objetos 'Producto'.
     * 
     * @throws IOException Si ocurre un error de entrada/salida.
     * 
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra.
     */

    public static ArrayList<Producto> cargarCatalogo() throws IOException, ClassNotFoundException{

        @SuppressWarnings("unchecked")
        
        ArrayList<Producto> catalogo = (ArrayList<Producto>) deserializar("src/baseDeDatos/temp/catalogo.txt");

        return catalogo;
    }



    /**
     * Carga los clientes deserializados desde un archivo.
     * 
     * @return Una lista de objetos 'Cliente'.
     * 
     * @throws IOException Si ocurre un error de entrada/salida.
     * 
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra.
     */

    public static ArrayList<Cliente> cargarClientes() throws IOException, ClassNotFoundException{

        @SuppressWarnings("unchecked")
        
        ArrayList<Cliente> clientes= (ArrayList<Cliente>) deserializar("src/baseDeDatos/temp/clientes.txt");

        return clientes;
    }



    /**
     * Carga los vendedores deserializados desde un archivo.
     * 
     * @return Una lista de objetos 'Vendedor'.
     * 
     * @throws IOException Si ocurre un error de entrada/salida.
     * 
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra.
     */

    public static ArrayList<Vendedor> cargarVendedores() throws IOException, ClassNotFoundException{

        @SuppressWarnings("unchecked")

        ArrayList<Vendedor> vendedores = (ArrayList<Vendedor>) deserializar("src/baseDeDatos/temp/vendedores.txt");

        return vendedores;
    }



    /**
     * Carga las tiendas deserializadas desde un archivo.
     * 
     * @return Una lista de objetos 'Tienda'.
     * 
     * @throws IOException Si ocurre un error de entrada/salida.
     *
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra.
     */

    public static ArrayList<Tienda> cargarTiendas() throws IOException, ClassNotFoundException{

        @SuppressWarnings("unchecked")

        ArrayList<Tienda> tiendas = (ArrayList<Tienda>) deserializar("src/baseDeDatos/temp/tiendas.txt");

        return tiendas;
    }



    /**
     * Carga el transporte deserializado desde un archivo.
     * 
     * @return Un objeto 'Transporte'.
     * 
     * @throws IOException Si ocurre un error de entrada/salida.
     * 
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra.
     */

    public static Transporte cargarTransporte() throws IOException, ClassNotFoundException{

        Transporte transporte = (Transporte) deserializar("src/baseDeDatos/temp/transporte.txt");

        return transporte;
    }



    /**
     * Carga los transportadores deserializados desde un archivo.
     * 
     * @return Una lista de objetos 'Transportador'.
     * 
     * @throws IOException Si ocurre un error de entrada/salida.
     * 
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra.
     */

    public static ArrayList<Transportador> cargarTransportadores() throws IOException, ClassNotFoundException{

        @SuppressWarnings("unchecked")

        ArrayList<Transportador> transportadores = (ArrayList<Transportador>) deserializar("src/baseDeDatos/temp/transportadores.txt");

        return transportadores;
    }



    /**
     * Carga los atributos deserializados desde un archivo.
     * 
     * @return Una lista de objetos 'Parejas<String, Moda>'.
     * 
     * @throws IOException Si ocurre un error de entrada/salida.
     * 
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra.
     */
    
    public static ArrayList<Parejas<String, Moda>> cargaAtributos() throws IOException, ClassNotFoundException{

        @SuppressWarnings("unchecked")

        ArrayList<Parejas<String, Moda>> infoAtributos = (ArrayList<Parejas<String, Moda>>) deserializar("src/baseDeDatos/temp/infoAtributos.txt");

        return infoAtributos;

    }
}

