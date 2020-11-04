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
public class Comercial extends Vehiculo {
    
    private final String cargaMaxima;
    
    public Comercial(String velocidad, String pasajeros, String placa, String tipo, String carMax) {
        super(velocidad, pasajeros, placa, tipo);
        this.cargaMaxima = carMax + "Kg";
    }


    
    @Override
    public String toString(){
        return super.toString() + '\n' + '\t' + "Carga máxima: " + cargaMaxima + '\n';
    }
    
}
