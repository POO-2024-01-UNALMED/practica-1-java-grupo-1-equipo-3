package baseDatos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import gestorAplicacion.empleados.Operario;
import gestorAplicacion.empleados.Transportador;
import gestorAplicacion.empleados.Vendedor;
import gestorAplicacion.empresa.Fabrica;
import gestorAplicacion.empresa.Factura;
import gestorAplicacion.empresa.Moda;
import gestorAplicacion.empresa.Producto;
import gestorAplicacion.empresa.Tienda;
import gestorAplicacion.externo.Cliente;
import gestorAplicacion.externo.CuentaBancaria;
import gestorAplicacion.externo.TipoTransporte;
import gestorAplicacion.externo.Transporte;

public class Cargar {

    public static ArrayList<Producto> catalogo = new ArrayList<Producto>();
    public static ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
    public static ArrayList<Factura> facturas = new ArrayList<Factura>();
    public static ArrayList<Transportador> transportadores = new ArrayList<Transportador>();
    public static HashMap<String, Moda> infoAtributos = new HashMap<String,Moda>();
    public static Fabrica fabrica;
    public static Transporte transporteAbastecer;

    // Para la creación de los objetos a usar
    public static void cargarPorDefecto(){

        // CREACIÓN DE PRODUCTOS
        //Frutas y verduras
        Producto producto1 = new Producto("Manzana","Paquete de 10 manzanas", 8000, 2.5, 20,3000,"frutas y verduras");
        Producto producto2 = new Producto("Zanahoria", "Paquete de 5 zanahorias", 7000, 2, 15, 2000, "frutas y verduras");
        Producto producto3 = new Producto("Pepino","Pepino fresco", 1500, 0.5, 8,500,"frutas y verduras");
        Producto producto4 = new Producto("Limon", "1 kilo de limones", 2000, 1, 15, 800, "frutas y verduras");
        Producto producto5 = new Producto("Piña","Piña fresca", 10000, 3, 20,3500,"frutas y verduras");
        Producto producto6 = new Producto("Pera","Paquete de 10 peras", 10000, 2.5, 20,4000,"frutas y verduras");
        Producto producto7 = new Producto("Tomate", "Paquete de 5 tomates", 6000, 2, 10, 1500, "frutas y verduras");
        Producto producto8 = new Producto("Frambuesa","Cajita de frambuesas", 15000, 1, 15,6000,"frutas y verduras");
        Producto producto9 = new Producto("Lechuga", "Lechuga fresca", 2000, 1.5, 8, 500, "frutas y verduras");
        Producto producto10 = new Producto("Sandia","Sandia fresca", 12000, 5, 20,4000,"frutas y verduras");
      
        // Panaderia
        Producto producto11 = new Producto("Pan", "Pan integral sin gluten", 5000, 1.5, 30, 1500, "panaderia");
        Producto producto12 = new Producto("Sanduche","Sanduche de pollo, queso y verduras", 8000, 1.5, 20,2500,"panaderia");
        Producto producto13 = new Producto("Pandebono","Pandebono fresco", 2000, 0.5, 10,500,"panaderia");
        Producto producto14 = new Producto("Pan hojaldrado","Pan hojaldrado fresco", 2500, 0.5, 15,800,"panaderia");
        Producto producto15 = new Producto("Galletas","Galletas de avena", 1500, 1.5, 15,400,"panaderia");
        Producto producto16 = new Producto("Palito de queso", "Palito de queso fresco", 2500, 0.5, 10, 500, "panaderia");
        Producto producto17 = new Producto("Tostada","Paquete de tostadas integrales", 9000, 1, 20,3500,"panaderia");
        Producto producto18 = new Producto("Ponque","Ponque Ramo tradicional", 6000, 1.5, 15,1500,"panaderia");
        Producto producto19 = new Producto("Pan tajado","Pan tajado artesanal", 8500, 1.5, 20,2000,"panaderia");
        Producto producto20 = new Producto("Almojabana","Almojabana fresca", 5000, 0.5, 5,1500,"panaderia");
        
        // Salsas y mermeladas
        Producto producto21 = new Producto("Mermelada de frambuesa","Mermelada de frambuesa fresca", 10000, 1.5, 15,3500,"salsas y mermeladas");
        Producto producto22 = new Producto("Mermelada de piña","Mermelada de piña fresca", 9000, 1.2, 13,3000,"salsas y mermeladas");
        Producto producto23 = new Producto("Mermelada de mora","Mermelada de mora fresca", 7000, 0.8, 8,2000,"salsas y mermeladas");
        Producto producto24 = new Producto("Mayonesa","Mayonesa baja en grasa", 15000, 2.5, 20,6000,"salsas y mermeladas");
        Producto producto25 = new Producto("Salsa de tomate","Salsa de tomate natural", 8000, 1.5, 10,2000,"salsas y mermeladas");
        Producto producto26 = new Producto("Mermelada de fresa","Mermelada de fresa fresca", 12000, 2, 15,4500,"salsas y mermeladas");
        Producto producto27 = new Producto("Mermelada de kiwi","Mermelada de kiwi fresca", 15000, 2, 15,5000,"salsas y mermeladas");
        Producto producto28 = new Producto("Mermelada de frutos rojos","Mermelada de frutos rojos", 14000, 1.5, 12,4000,"salsas y mermeladas");
        Producto producto29 = new Producto("Salsa BBQ","Salsa BBQ baja en grasa", 9000, 1.5, 15,3000,"salsas y mermeladas");
        Producto producto30 = new Producto("Salsa de soya","Salsa de soya baja en grasa", 6000, 1, 10,1500,"salsas y mermeladas");
        
        // Bebidas
        Producto producto31 = new Producto("Te verde","Hojas de te verde", 3000, 0.5, 10,300,"bebidas");
        Producto producto32 = new Producto("Jugo de naranja","Jugo de naranja natural", 3000, 2, 20,1000,"bebidas");
        Producto producto33 = new Producto("Leche de almendras", "Leche de almendras endulzada", 10000, 1.5, 18, 4000, "bebidas");
        Producto producto34 = new Producto("Leche de avena", "Leche de avena con sabor a vainilla", 15000, 2, 25, 6000, "bebidas");
        Producto producto35 = new Producto("Yogur de soya", "Yogur hecho en base de leche de soya", 12000, 1.5, 18, 4500, "bebidas");
        Producto producto36 = new Producto("Cafe instantaneo","Frasco de cafe instantaneo", 20000, 3, 15,7000,"bebidas");
        Producto producto37 = new Producto("Bebida achocolatada","Bebida achocolatada en polvo", 30000, 2, 15,10000,"bebidas");
        Producto producto38 = new Producto("Leche de coco", "Leche de coco endulzada", 15000, 1.5, 20, 6000, "bebidas");
        Producto producto39 = new Producto("Bebida hidratante", "Bebida hidratante sabor manzana verde", 5000, 0.5, 15, 1500, "bebidas");
        Producto producto40 = new Producto("Jugo de mora", "Jugo de mora natural", 4000, 2, 20, 1500, "bebidas");
        
        //se agregan los productos creados al catalogo
        catalogo.add(producto1);
        catalogo.add(producto2);
        catalogo.add(producto3);
        catalogo.add(producto4);
        catalogo.add(producto5);
        catalogo.add(producto6);
        catalogo.add(producto7);
        catalogo.add(producto8);
        catalogo.add(producto9);
        catalogo.add(producto10);
        catalogo.add(producto11);
        catalogo.add(producto12);
        catalogo.add(producto13);
        catalogo.add(producto14);
        catalogo.add(producto15);
        catalogo.add(producto16);
        catalogo.add(producto17);
        catalogo.add(producto18);
        catalogo.add(producto19);
        catalogo.add(producto20);
        catalogo.add(producto21);
        catalogo.add(producto22);
        catalogo.add(producto23);
        catalogo.add(producto24);
        catalogo.add(producto25);
        catalogo.add(producto26);
        catalogo.add(producto27);
        catalogo.add(producto28);
        catalogo.add(producto29);
        catalogo.add(producto30);
        catalogo.add(producto31);
        catalogo.add(producto32);
        catalogo.add(producto33);
        catalogo.add(producto34);
        catalogo.add(producto35);
        catalogo.add(producto36);
        catalogo.add(producto37);
        catalogo.add(producto38);
        catalogo.add(producto39);
        catalogo.add(producto40);
    

        // CREACIÓN DE LAS CUENTAS BANCARIAS
        // Cuenta de la empresa
        CuentaBancaria cuentaEmpresa = new CuentaBancaria(123456789, 100000000);

        // Cuentas para los empleados - cada uno con 500.000 pesos
        // Operario
        CuentaBancaria cuentaOperario1 = new CuentaBancaria(111111, 500000);

        // Vendedores
        CuentaBancaria cuentaVendedor1 = new CuentaBancaria(22222, 500000); 
        CuentaBancaria cuentaVendedor2 = new CuentaBancaria(33333, 500000);
        CuentaBancaria cuentaVendedor3 = new CuentaBancaria(44444, 500000);

        // Transportadores
        CuentaBancaria cuentaTransportador1 = new CuentaBancaria(55555, 500000); 
        CuentaBancaria cuentaTransportador2 = new CuentaBancaria(666666, 500000); 
        CuentaBancaria cuentaTransportador3 = new CuentaBancaria(77777, 500000); 


        // CREACIÓN DE LOS EMPLEADOS
        // Operario
        Operario operario1 = new Operario("Mateo Lopez",22,11111111,cuentaOperario1,null);
        
        // Vendedores
        Vendedor vendedor1 = new Vendedor("Isabella Restrepo",19,2222222,cuentaVendedor1,null);
        Vendedor vendedor2 = new Vendedor("Karen Ardila",23,3333333,cuentaVendedor2,null);
        Vendedor vendedor3 = new Vendedor("Carlos Escobar",21,4444444,cuentaVendedor3,null);
        
        //Transportadores
        Transportador transportador1 = new Transportador("Kevin Castaño", 35, 555555555, cuentaTransportador1,null);
        Transportador transportador2 = new Transportador("Cristian Toro", 42, 66666666, cuentaTransportador2,null);
        Transportador transportador3 = new Transportador("Andres Salcedo", 29, 777777777, cuentaTransportador3,null);
        

        // CREACIÓN TIENDAS
        // Misma cuenta bancaria de la empresa
        ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
        Tienda tienda1 = new Tienda("Delicia Fresca Norte",vendedor1,cuentaEmpresa); // 25 productos
        Tienda tienda2 = new Tienda("Delicia Fresca Sur",vendedor2,cuentaEmpresa); // 25 productos
        Tienda tienda3 = new Tienda("Delicia Fresca Centro",vendedor3,cuentaEmpresa); // 30 productos

        //agregar productos a tiendas 
        tienda1.setListaProductos(new ArrayList<>(Arrays.asList(producto1,producto2,producto3,producto4,producto5,producto6,
                                                                producto11,producto12,producto13,producto14,producto15,producto16,
                                                                producto21,producto22,producto23,producto24,producto25,producto26,
                                                                producto31,producto32,producto33,producto34,producto35,producto36,
                                                                producto40)));
        tienda2.setListaProductos(new ArrayList<>(Arrays.asList(producto6,producto7,producto8,producto9,producto10,producto11,
                                                                producto16,producto17,producto18,producto19,producto20,producto21,
                                                                producto26,producto27,producto28,producto29,producto30,producto31,
                                                                producto36,producto37,producto38,producto39,producto40,producto3,
                                                                producto32)));
        tienda3.setListaProductos(new ArrayList<>(Arrays.asList(producto1, producto2, producto4, producto5, producto7, producto8, 
                                                                producto9, producto10, producto12, producto13, producto14, producto15, 
                                                                producto17, producto18, producto19, producto20, producto22, producto23, 
                                                                producto24, producto25, producto27, producto28, producto29, producto30, 
                                                                producto33, producto34, producto35, producto37, producto38, producto39)));
      
        
        for(int i=0;i<3;i++){
            // Agregar a tienda 1
            tienda1.getListaProductos().add(producto1);
            tienda1.getListaProductos().add(producto2);
            tienda1.getListaProductos().add(producto3);
            tienda1.getListaProductos().add(producto4);
            tienda1.getListaProductos().add(producto5);
            tienda1.getListaProductos().add(producto6);
            tienda1.getListaProductos().add(producto11);
            tienda1.getListaProductos().add(producto12);
            tienda1.getListaProductos().add(producto13);
            tienda1.getListaProductos().add(producto14);
            tienda1.getListaProductos().add(producto15);
            tienda1.getListaProductos().add(producto16);
            tienda1.getListaProductos().add(producto21);
            tienda1.getListaProductos().add(producto22);
            tienda1.getListaProductos().add(producto23);
            tienda1.getListaProductos().add(producto24);
            tienda1.getListaProductos().add(producto25);
            tienda1.getListaProductos().add(producto26);
            tienda1.getListaProductos().add(producto31);
            tienda1.getListaProductos().add(producto32);
            tienda1.getListaProductos().add(producto33);
            tienda1.getListaProductos().add(producto34);
            tienda1.getListaProductos().add(producto35);
            tienda1.getListaProductos().add(producto36);
            tienda1.getListaProductos().add(producto40);

            // Agregar a tienda 2
            tienda2.getListaProductos().add(producto6);
            tienda2.getListaProductos().add(producto7);
            tienda2.getListaProductos().add(producto8);
            tienda2.getListaProductos().add(producto9);
            tienda2.getListaProductos().add(producto10);
            tienda2.getListaProductos().add(producto11);
            tienda2.getListaProductos().add(producto16);
            tienda2.getListaProductos().add(producto17);
            tienda2.getListaProductos().add(producto18);
            tienda2.getListaProductos().add(producto19);
            tienda2.getListaProductos().add(producto20);
            tienda2.getListaProductos().add(producto21);
            tienda2.getListaProductos().add(producto26);
            tienda2.getListaProductos().add(producto27);
            tienda2.getListaProductos().add(producto28);
            tienda2.getListaProductos().add(producto29);
            tienda2.getListaProductos().add(producto30);
            tienda2.getListaProductos().add(producto31);
            tienda2.getListaProductos().add(producto36);
            tienda2.getListaProductos().add(producto37);
            tienda2.getListaProductos().add(producto38);
            tienda2.getListaProductos().add(producto39);
            tienda2.getListaProductos().add(producto40);
            tienda2.getListaProductos().add(producto3);
            tienda2.getListaProductos().add(producto32);

            //Agregar a tienda 3
            tienda3.getListaProductos().add(producto1);
            tienda3.getListaProductos().add(producto2);
            tienda3.getListaProductos().add(producto4);
            tienda3.getListaProductos().add(producto5);
            tienda3.getListaProductos().add(producto7);
            tienda3.getListaProductos().add(producto8);
            tienda3.getListaProductos().add(producto9);
            tienda3.getListaProductos().add(producto10);
            tienda3.getListaProductos().add(producto12);
            tienda3.getListaProductos().add(producto13);
            tienda3.getListaProductos().add(producto14);
            tienda3.getListaProductos().add(producto15);
            tienda3.getListaProductos().add(producto17);
            tienda3.getListaProductos().add(producto18);
            tienda3.getListaProductos().add(producto19);
            tienda3.getListaProductos().add(producto20);
            tienda3.getListaProductos().add(producto22);
            tienda3.getListaProductos().add(producto23);
            tienda3.getListaProductos().add(producto24);
            tienda3.getListaProductos().add(producto25);
            tienda3.getListaProductos().add(producto27);
            tienda3.getListaProductos().add(producto28);
            tienda3.getListaProductos().add(producto29);
            tienda3.getListaProductos().add(producto30);
            tienda3.getListaProductos().add(producto33);
            tienda3.getListaProductos().add(producto34);
            tienda3.getListaProductos().add(producto35);
            tienda3.getListaProductos().add(producto37);
            tienda3.getListaProductos().add(producto38);
            tienda3.getListaProductos().add(producto39);
        }

        // Agregar objetos de tienda a la lista de tiendas
        tiendas.add(tienda1);
        tiendas.add(tienda2);
        tiendas.add(tienda3);

        // Se le asigna la tienda a cada vendedor:
        vendedor1.setTienda(tienda1);
        vendedor2.setTienda(tienda2);
        vendedor3.setTienda(tienda3);

        
        // CREACION FABRICA
        // Con la misma cuenta bancaria de la empresa
        fabrica = new Fabrica(catalogo, tiendas, cuentaEmpresa,operario1);

        // Agregar a los trabajadores la fabrica
        operario1.setFabrica(fabrica);
        transportador1.setFabrica(fabrica);
        transportador2.setFabrica(fabrica);
        transportador3.setFabrica(fabrica);


        //CREAR TRANSPORTE PARA ABASTECER
        transporteAbastecer = new Transporte(TipoTransporte.CAMION, TipoTransporte.CAMION.getCapacidad_KG(),TipoTransporte.CAMION.getCapacidad_KG(),transportador1);
        transportador1.setTransporte(transporteAbastecer);
        

        // CREAR CLIENTES
        CuentaBancaria cuentaCliente1 = new CuentaBancaria(842348, 1000000);
        Cliente cliente1 = new Cliente("Esteban Carrillo", "Calle 64 # 20", cuentaCliente1);

        CuentaBancaria cuentaCliente2 = new CuentaBancaria(8376483, 2000000);
        Cliente cliente2 = new Cliente("Tiffany Mendoza", "Carrera 89 # 17", cuentaCliente2);

        CuentaBancaria cuentaCliente3 = new CuentaBancaria(472539,500000);
        Cliente cliente3 = new Cliente("Santiago Perez", "Avenida 35 # 21", cuentaCliente3);

        CuentaBancaria cuentaCliente4 = new CuentaBancaria(28935,2500000);
        Cliente cliente4 = new Cliente("Mariana Lopera", "Carrera 23 # 56", cuentaCliente4);

        CuentaBancaria cuentaCliente5 = new CuentaBancaria(3984394,200000);
        Cliente cliente5 = new Cliente("Jose Manuel Vergara", "Calle 65 # 21", cuentaCliente5);

        CuentaBancaria cuentaCliente6 = new CuentaBancaria(387465,3000000);
        Cliente cliente6 = new Cliente("Camila Zapata", "Avenida 12 # 56", cuentaCliente6);

        CuentaBancaria cuentaCliente7 = new CuentaBancaria(826393,700000);
        Cliente cliente7 = new Cliente("Miguel Acosta", "Carrera 37 # 67", cuentaCliente7);

        CuentaBancaria cuentaCliente8 = new CuentaBancaria(88849433,5000000);
        Cliente cliente8 = new Cliente("Martin Berrio", "Calle 45 # 45", cuentaCliente8);

        
        // Agregar los objetos de Cliente a la lista de clientes
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);
        clientes.add(cliente6);
        clientes.add(cliente7);
        clientes.add(cliente8);

        // Agregar los objetos de vendedor a la lista de vendedores
        vendedores.add(vendedor1);
        vendedores.add(vendedor2);
        vendedores.add(vendedor3);

        // Agregar los objetos de transportador a la lista de transportadores
        transportadores.add(transportador1);
        transportadores.add(transportador2);
        transportadores.add(transportador3);

        //inicializar el map de los productos
        tienda1.cantidadProductosVentas();
        tienda2.cantidadProductosVentas();
        tienda3.cantidadProductosVentas();

    }

    public static void guardar(){

        facturas = Factura.getListaFacturas();
        
        clientes = Cliente.getListaClientes();
        
        catalogo = Producto.getListaProductos();
        
        transportadores = Transportador.getListaTransportadores();
        
        infoAtributos = Factura.getInfoAtributos();
  

        Serializador.guardarTiendas();
        
        Serializador.guardarCatalogo();
        
        Serializador.guardarFabrica();
        
        Serializador.guardarFacturas();
        
        Serializador.guardarTransporte();
        
        Serializador.guardarVendedores();
        
        Serializador.guardarClientes();
        
        Serializador.guardarTransportadores();
        
        Serializador.guardarAtributos();
    }
  

    public static void cargar(){
  
        try{
  
        tiendas =  Deserializador.cargarTiendas();
        
        catalogo = Deserializador.cargarCatalogo();
        
        fabrica = Deserializador.cargarFabrica();
        
        clientes = Deserializador.cargarClientes();
        
        transporteAbastecer = Deserializador.cargarTransporte();
        
        vendedores =  Deserializador.cargarVendedores();
        
        facturas =  Deserializador.cargarFacturas();
        
        transportadores = Deserializador.cargarTransportadores();
         
        infoAtributos = Deserializador.cargaAtributos();
  

        Factura.setListaFacturas(facturas);
        
        Cliente.setListaClientes(clientes);
        
        Producto.setListaProductos(catalogo);
        
        Transportador.setListaTransportadores(transportadores);
        
        Factura.setInfoAtributos(infoAtributos);
  

        }catch(Exception e){
          
            System.out.println("Ha ocurrido un error en la deserialización");
            
            e.printStackTrace();
        }
      }
      
    public static void main(String[] args){
        Cargar.cargarPorDefecto();
        Serializador.guardarTiendas();
        Serializador.guardarAtributos();
        Serializador.guardarCatalogo();
        Serializador.guardarClientes();
        Serializador.guardarFabrica();
        Serializador.guardarFacturas();
        Serializador.guardarTransportadores();
        Serializador.guardarTransporte();
        Serializador.guardarVendedores();

    }
}
