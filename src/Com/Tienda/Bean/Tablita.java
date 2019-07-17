/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.Tienda.Bean;

public class Tablita {
 private int id;
 private String nombre;
 private int cantidad;
 private double subtotal;
 private double precio;



    public Tablita(int id, String nombre, int cantidad, double precio,double subtotal) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.precio = precio;
       
        
    }

   
 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
 
    
}
