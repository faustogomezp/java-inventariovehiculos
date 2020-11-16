/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariovehiculos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author fausto.gomez
 */
public class Inventario {

    /*
    private static ArrayList<Comercial> vehiculoComercial = new ArrayList();
    private static ArrayList<Particular> vehiculoParticular = new ArrayList(); */
    private static ArrayList<Vehiculo> vehiculos = new ArrayList();
    private static HashMap stock = new HashMap();

    /**
     * @param args the command line arguments
     */

    public static void incializarStock(String tipoVehiculo, int cantStock) {
        stock.put(tipoVehiculo, cantStock);
    }

    public static void actualizarStock(String tipoVehiculo, int cantVenta) {
        stock.replace(tipoVehiculo, Integer.parseInt(stock.get(tipoVehiculo).toString())- cantVenta);
    }

    public static void agregarVehiculo(String[] cmd) {
        String[] comando = cmd;
        if (comando[1].equals("Comercial")) {
            vehiculos.add(new Comercial(comando[3], comando[2], comando[4], comando[1], comando[5]));
        } else {
            vehiculos.add(new Particular(comando[3], comando[2], comando[4], comando[1], comando[5]));
        }
    }

    /*
    public static void agregarVehiculo(String[] cmd) {
        //1&Comercial&numeroPasajeros&velocidadMaxima&placa&peso_maximo
        String[] comando = cmd;
        if (comando[1].equals("Comercial")) {
            Comercial newVehiculo = new Comercial(comando[3], comando[2], comando[4], comando[1], comando[5]);
            vehiculoComercial.add(newVehiculo);
        } else {
            Particular newVehiculo = new Particular(comando[3], comando[2], comando[4], comando[1], comando[5]);
            vehiculoParticular.add(newVehiculo);
        }
    }*/
    public static void listarVehiculos() {
        System.out.println("***Inventario de vehículos***");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.print(vehiculos.get(i).toString());
        }
    }

    public static double calculoIva(int cant, double valorCompra) {
        double iva = 21;
        double valorIva = 0;
        iva = iva - cant;
        if (iva > 0) {
            valorIva = (iva * valorCompra) / 100;
        }
        return valorIva;
    }

    public static void facturarCompra(String[] cmd) {
        double valorCompra = 0;
        int cantVehiculos = 0;
        double valorIva = 0;
        if (Integer.parseInt(stock.get(cmd[1]).toString()) <= Integer.parseInt(cmd[2]) || Integer.parseInt(stock.get(cmd[3]).toString()) <= Integer.parseInt(cmd[4])) {
            System.out.println("Lo sentimos no tenemos stock suficiente");
            System.out.println("---");
        } else {
            System.out.println("CONCESIONARIO UNCAR");
            System.out.println("UNCAR - UNIVA");
            System.out.println("NIT: 899.999.063");
            System.out.println("Cliente: " + cmd[5]);
            System.out.println("Vehículo Cant Precio");
            System.out.println(cmd[1] + " x" + cmd[2] + " $30000000");
            System.out.println(cmd[3] + " x" + cmd[4] + " $40000000");
            actualizarStock(cmd[1],Integer.parseInt(cmd[2]));
            actualizarStock(cmd[3],Integer.parseInt(cmd[4]));
            cantVehiculos = Integer.parseInt(cmd[2]) + Integer.parseInt(cmd[4]);
            valorCompra = (Integer.parseInt(cmd[2]) * 30000000) + (Integer.parseInt(cmd[4]) * 40000000);
            valorIva = calculoIva(cantVehiculos, valorCompra);
            System.out.println("Iva: $" + (int) valorIva);
            System.out.println("Total: $" + (long) (Math.ceil(valorCompra + valorIva)));
            System.out.println("---");
        }

    }
    
    public static void imprimirStock() {
        for( Iterator it = stock.keySet().iterator(); it.hasNext();) { 
            String tipoVehiculo = (String)it.next();
            String cant = stock.get(tipoVehiculo).toString();
            System.out.println(tipoVehiculo + ": " + cant);
	}
    }
    
    public static boolean procesarComandos(String[] comando) {
        boolean salir = false;
        if (comando[0].equals("1")) {
            agregarVehiculo(comando);
        }
        if (comando[0].equals("2")) {
            listarVehiculos();
        }
        if (comando[0].equals("3")) {
            facturarCompra(comando);
        }
        if (comando[0].equals("4")) {
            imprimirStock();
        }
        if (comando[0].equals("5")) {
            salir = true;
        }
        return salir;
    }

    /*
    
    public static void listarVehiculos(){
        System.out.println("***Inventario de vehículos***"); 
        for (int i = 0; i < vehiculoParticular.size(); i++){
            System.out.print(vehiculoParticular.get(i).toString());
        }
        for (int i = 0; i < vehiculoComercial.size(); i++){
            System.out.print(vehiculoComercial.get(i).toString());
        }
    }*/
    public static void main(String[] args) {
        // TODO code application logic here
        incializarStock("Comercial", 100);
        incializarStock("Particular", 100);
        Scanner sc = new Scanner(System.in);
        String[] cmd = sc.nextLine().split("&");
        boolean salir = procesarComandos(cmd);
        while (!salir) {
            cmd = sc.nextLine().split("&");
            salir = procesarComandos(cmd);
        }

    }

}
