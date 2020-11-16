/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariovehiculos;

/**
 *
 * @author fausto.gomez
 */
public class Vehiculo {
    
    protected final String velocidad;
    protected final String pasajeros;
    protected final String placa;
    protected final String tipo;

    public String getVelocidad() {
        return velocidad;
    }

    public String getPasajeros() {
        return pasajeros;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }
    

    public Vehiculo(String velocidad, String pasajeros, String placa, String tipo) {
        this.velocidad = velocidad + " Km/h";
        this.pasajeros = pasajeros;
        this.placa = placa;
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return  '\t' + "Vehículo " + tipo +  " - " + "Placa: " + placa
                + '\n' + '\t' + "Velocidad: " + velocidad  
                + '\n' + '\t' + "Pasajeros: " + pasajeros;
    }
    
}
