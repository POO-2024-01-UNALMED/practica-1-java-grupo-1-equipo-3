package gestorAplicacion.empresa;

import java.util.ArrayList;

import gestorAplicacion.empleados.Operario;
import gestorAplicacion.externo.CuentaBancaria;

public class Fabrica {
    // Atributos
    private Operario operario;
    private CuentaBancaria cuentaBancaria;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Tienda> listaTienda;

    // Constructor - Si el Operario ya existe
    public Fabrica(Operario operario, int numeroCuenta, int saldo) {
        this.operario = operario;
        this.cuentaBancaria = new CuentaBancaria(numeroCuenta, saldo);
        this.listaProductos = new ArrayList<>();
        this.listaTienda = new ArrayList<>();
    }

    // Constructor - Si el operario NO existe
    public Fabrica(int numeroCuenta, int saldo) {
        this.cuentaBancaria = new CuentaBancaria(numeroCuenta, saldo);
        this.listaProductos = new ArrayList<>();
        this.listaTienda = new ArrayList<>();
    }

    // Métodos
    public void mostrarProductos() {
        System.out.println("Lista de productos disponibles:");
        for (Producto producto : listaProductos) {
            System.out.println(producto.getNombre());
        }
    }

    public void mostrarTienda() {
        System.out.println("Lista de tiendas existentes:");
        for (Tienda tienda : listaTienda) {
            System.out.println(tienda.getNombre());
        }
    }

    public Tienda seleccionarTienda(int indice) {
        if (indice >= 0 && indice < listaTienda.size()) {
            return listaTienda.get(indice);
        } else {
            System.out.println("Índice de tienda no válido.");
            return null;
        }
    }

    public void mostrarEmpleados() {
        System.out.println("Empleados:");
        System.out.println("Nombre: " + operario.getNombre());
    }

    public ArrayList<Producto> cantidadProductos(Producto producto, int cantidad) {
        ArrayList<Producto> productosRequeridos = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            productosRequeridos.add(producto);
        }
        return productosRequeridos;
    }

    // Getters y setters
    public Operario getOperario() {
        return operario;
    }

    public void setOperario(Operario operario) {
        this.operario = operario;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Tienda> getListaTienda() {
        return listaTienda;
    }

    public void setListaTienda(ArrayList<Tienda> listaTienda) {
        this.listaTienda = listaTienda;
    }
}
