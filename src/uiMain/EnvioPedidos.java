package uiMain;
import gestorAplicacion.empresa.Fabrica;
import gestorAplicacion.empresa.Tienda;
import gestorAplicacion.externo.Cliente;
import gestorAplicacion.externo.Transporte;
import gestorAplicacion.empresa.Producto;
import java.util.Scanner;

public class EnvioPedidos  {
      int indiceCliente;
      int indiceTienda;
      //Metodo para la primera Funcion
      public static void EnviarPedidos(){
            //Mostramos el listado de todos los clientes
           System.out.print(Cliente.mostrarClientes());
           //Seleccionamos el cliente
           Scanner myObj = new Scanner(System.in);  // Create a Scanner object
           System.out.println("Ingresa el indice del cliente a seleccionar");
           int  indiceCliente = myObj.nextInt();  // Read user input 
           Cliente clienteElegido = Cliente.seleccionarCliente(indiceCliente); //Usamos el metodo para seleccionar el cliente guardamos en clienteElgido el objeto de tipo cliente

           System.out.print(Fabrica.mostrarTienda());
           //Seleccionamos la tienda
           System.out.println("Ingresa el indice de la tienda a seleccionar");
           int  indiceTienda = myObj.nextInt();  // Read user input 
           Tienda tiendaElegida = Fabrica.seleccionarTienda(indiceTienda); //Usamos el metodo para seleccionar el cliente guardamos en clienteElgido el objeto de tipo cliente 

           // Leemos la cantidad de productos del cliente 
           System.out.print("Estos son los productos disponibles");
           System.out.print(tiendaElegida.cantidadProductos());//Imprimimos la cantidad de productos de la tienda
           System.out.print("Digite la cantidad de productos que desea llevar: ");
           int  cantidadProductos = myObj.nextInt();  // Read user input 
           double peso = 0;
           //Mostramos los productos, y seleccionamos cantidad y sumamos la cantidad de pesos por cada una de los productos que indica el cliente 
           for(int i = 0; i <= cantidadProductos; i = i + 1){
                  System.out.print(Tienda.mostrarProductos());
                  int indiceProducto = myObj.nextInt();//Leemos el producto
                  Producto Producto = Tienda.seleccionarProducto(indiceProducto);
                  Tienda.cantidadProductos.put(Producto, i)(Producto);
                  peso = peso + Producto.peso;


            }
           
            System.out.print(Transporte.TipoTransporte());
            System.out.print(Transporte.transporteSegunCarga());
            Transporte transporteElegido = Transporte.seleccionarTransporte;



            


            
      }


      public static void main(String[] args) {
          EnviarPedidos();
      }

    
}
