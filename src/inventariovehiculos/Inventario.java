/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariovehiculos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fausto.gomez
 */
public class Inventario {
    private static ArrayList<Comercial> vehiculoComercial = new ArrayList();
    private static ArrayList<Particular> vehiculoParticular = new ArrayList();
    /**
     * @param args the command line arguments
     */
    
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
    }
    
    public static void listarVehiculos(){
        System.out.println("***Inventario de vehículos***"); 
        for (int i = 0; i < vehiculoParticular.size(); i++){
            System.out.print(vehiculoParticular.get(i).toString());
        }
        for (int i = 0; i < vehiculoComercial.size(); i++){
            System.out.print(vehiculoComercial.get(i).toString());
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String[] cmd = sc.nextLine().split("&");
        while (!cmd[0].equals("3")){
            if (cmd[0].equals("1")) {
                agregarVehiculo(cmd);
            }
            if (cmd[0].equals("2")) {
                listarVehiculos();
            }
            cmd = sc.nextLine().split("&");
        }
        
    }
    
}
