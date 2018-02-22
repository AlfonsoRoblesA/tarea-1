
package tarea.pkg1;

import java.io.Serializable;

public class Producto implements Serializable{
    String nombre;
    int id;
    String descripcion;
    String unidad;
    int cantidad;
    int costo;

    public Producto(String nombre, int id, String descripcion, String unidad, int cantidad, int costo) {
        this.nombre = nombre;
        this.id = id;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public Producto() {
        this.nombre = " ";
        this.id = 0;
        this.descripcion = " ";
        this.unidad = " ";
        this.cantidad = 0;
        this.costo = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
    
   
}
