package baseDatos;

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

public class Deserializador {
    
    public static Serializable deserializar(String strArchivo) throws IOException, ClassNotFoundException{

        FileInputStream fileInputStream;
        
        ObjectInputStream objectInputStream;

        fileInputStream = new FileInputStream(strArchivo);
            
        objectInputStream = new ObjectInputStream(fileInputStream);
        
        Serializable s = (Serializable) objectInputStream.readObject();
        
        objectInputStream.close();
      

        return s;
    }


    public static ArrayList<Factura> cargarFacturas() throws IOException, ClassNotFoundException{
        
        @SuppressWarnings("unchecked") // Para que no saque un error al hacer el .jar 
       
        ArrayList<Factura> facturas = (ArrayList<Factura>) deserializar("src/baseDatos/temp/facturas.txt");

        
        return facturas;
    }


    public static Fabrica cargarFabrica() throws IOException, ClassNotFoundException{

        Fabrica fabrica = (Fabrica) deserializar("src/baseDatos/temp/fabrica.txt");

        return fabrica;
    }


    public static ArrayList<Producto> cargarCatalogo() throws IOException, ClassNotFoundException{

        @SuppressWarnings("unchecked")
        
        ArrayList<Producto> catalogo = (ArrayList<Producto>) deserializar("src/baseDatos/temp/catalogo.txt");

        return catalogo;
    }


    public static ArrayList<Cliente> cargarClientes() throws IOException, ClassNotFoundException{

        @SuppressWarnings("unchecked")
        
        ArrayList<Cliente> clientes= (ArrayList<Cliente>) deserializar("src/baseDatos/temp/clientes.txt");

        return clientes;
    }


    public static ArrayList<Vendedor> cargarVendedores() throws IOException, ClassNotFoundException{

        @SuppressWarnings("unchecked")

        ArrayList<Vendedor> vendedores = (ArrayList<Vendedor>) deserializar("src/baseDatos/temp/vendedores.txt");

        return vendedores;
    }


    public static ArrayList<Tienda> cargarTiendas() throws IOException, ClassNotFoundException{

        @SuppressWarnings("unchecked")

        ArrayList<Tienda> tiendas = (ArrayList<Tienda>) deserializar("src/baseDatos/temp/tiendas.txt");

        return tiendas;
    }


    public static Transporte cargarTransporte() throws IOException, ClassNotFoundException{

        Transporte transporte = (Transporte) deserializar("src/baseDatos/temp/transporte.txt");

        return transporte;
    }


    public static ArrayList<Transportador> cargarTransportadores() throws IOException, ClassNotFoundException{

        @SuppressWarnings("unchecked")

        ArrayList<Transportador> transportadores = (ArrayList<Transportador>) deserializar("src/baseDatos/temp/transportadores.txt");

        return transportadores;
    }

    public static ArrayList<Parejas<String, Moda>> cargaAtributos() throws IOException, ClassNotFoundException{

        @SuppressWarnings("unchecked")

        ArrayList<Parejas<String, Moda>> infoAtributos = (ArrayList<Parejas<String, Moda>>) deserializar("src/baseDatos/temp/infoAtributos.txt");

        return infoAtributos;

    }
}
