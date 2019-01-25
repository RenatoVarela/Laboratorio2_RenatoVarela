/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labortorio2_renatovarela;

import java.awt.Color;

/**
 *
 * @author Asus Pc
 */
public class Casas {

   
    
     int numero_casas , numero_bloque, pisos, banos,cuartos;
    String nombre_dueno, color, estado , ocupada ,nombre_ingeniero;
    double ancho,largo;
    
    
    public Casas(){
        
    }

    public Casas(int numero_casas, int numero_bloque, int pisos, int banos, int cuartos, String nombre_dueno, String color, String estado, double ancho, double largo, String ocupada, String nombre_ingeniero) {
        this.numero_casas = numero_casas;
        this.numero_bloque = numero_bloque;
        this.pisos = pisos;
        this.banos = banos;
        this.cuartos = cuartos;
        this.nombre_dueno = nombre_dueno;
        this.color = color;
        this.estado = estado;
        this.ancho = ancho;
        this.largo = largo;
        this.ocupada = ocupada;
        this.nombre_ingeniero = nombre_ingeniero;
    }

    public int getNumero_casas() {
        return numero_casas;
    }

    public void setNumero_casas(int numero_casas) {
        this.numero_casas = numero_casas;
    }

    public int getNumero_bloque() {
        return numero_bloque;
    }

    public void setNumero_bloque(int numero_bloque) {
        this.numero_bloque = numero_bloque;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public int getBanos() {
        return banos;
    }

    public void setBanos(int banos) {
        this.banos = banos;
    }

    public int getCuartos() {
        return cuartos;
    }

    public void setCuartos(int cuartos) {
        this.cuartos = cuartos;
    }

    public String getNombre_dueno() {
        return nombre_dueno;
    }

    public void setNombre_dueno(String nombre_dueno) {
        this.nombre_dueno = nombre_dueno;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }
    
     public String getOcupada() {
        return ocupada;
    }

    public void setOcupada(String ocupada) {
        this.ocupada = ocupada;
    }
    
    
     public String getIngeniero() {
        return nombre_ingeniero;
    }

    public void setIngeniero(String nombre_ingeniero) {
        this.nombre_ingeniero = nombre_ingeniero;
    }
    
    
     @Override
    public String toString() {
        return "1)Numero de casa: " + numero_casas + "\n2)Bloque de la casa: " + numero_bloque + "\n3)Numero de pisos: " + pisos + "\n4)Numero de banos: " + banos + "\n5)Numero de cuartos: " + cuartos + "\n6)Nombre del Propietario: " + nombre_dueno + "\n7)Color de la casa: " + color + "\n8)Estado actual: " + estado + "\n9)Ocupada: " + ocupada + "\n10)Ancho de la casa: " + ancho 
                + "\n11)Largo de la casa: " + largo + "\n12)Nombre del Ingeniero: " + nombre_ingeniero + "\n";
    }
    
   
    
    
    
    
    
    
    
}
