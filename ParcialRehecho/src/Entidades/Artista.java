/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Fabri
 */
public class Artista {
    private String apellido;
    private String nombre;

    public Artista(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
    public static boolean sonIguales(Artista a1, Artista a2){
        boolean esIgual = false;
        if(a1.getNombreApellido().equals(a2.getNombreApellido()))
        {
            esIgual = true;
        }
        return esIgual;
    }
    
    public String getNombreApellido(){
        return nombre + " - " + apellido;
        
    }
}
