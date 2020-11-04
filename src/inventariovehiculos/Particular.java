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
public class Particular extends Vehiculo {
    
    private final String color;
    
    public Particular(String velocidad, String pasajeros, String placa, String tipo, String color) {
        super(velocidad, pasajeros, placa, tipo);
        this.color = color;
    }
    
    @Override
    public String toString(){
        return super.toString() + '\n' + '\t' + "color: " + color +'\n';
    }
    
    
}
