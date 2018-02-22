package tarea.pkg1;

import java.io.Serializable;
import java.util.Date;


public class Venta implements Serializable {
    Date fecha;
    String [] nombreP;
    int [] cantidad;
    int [] ganancia;
    int total;
    double iva;
    int vendidos;

    public Venta(Date fecha, String[] producto, int[] cantidad, int [] ganancia, int total, double iva, int vendidos) {
        this.fecha = fecha;
        this.nombreP = producto;
        this.cantidad = cantidad;
        this.ganancia = ganancia;
        this.total = total;
        this.iva = iva;
        this.vendidos = vendidos;
    }

    public String[] getNombreP() {
        return nombreP;
    }

    public void setNombreP(String[] nombreP) {
        this.nombreP = nombreP;
    }

    public int getVendidos() {
        return vendidos;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String[] getProducto() {
        return nombreP;
    }

    public void setProducto(String[] producto) {
        this.nombreP = producto;
    }

    public int[] getCantidad() {
        return cantidad;
    }

    public void setCantidad(int[] cantidad) {
        this.cantidad = cantidad;
    }

    public int [] getGanancia() {
        return ganancia;
    }

    public void setGanancia(int [] ganancia) {
        this.ganancia = ganancia;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }
    
    
}
