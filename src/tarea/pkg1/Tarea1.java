

package tarea.pkg1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tarea1 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Vector vecVen = new Vector();
        File miFile;
        Vector vector = new Vector();
        Vector vecVentas = new Vector();
        File miFileV;
        File Ventas;
        Producto prd;
        Producto prAux;
        Producto pr2, prVendido;
        ObjectOutputStream oos;
        ObjectInputStream ois;
        
        miFile = new File("DATOS");
        Ventas = new File("Ventas");        
        int opc=0;
        Scanner reader = new Scanner(System.in);
        while(opc!=11){
        System.out.println("Menu");
        System.out.println("1.- Dar de alta producto");
        System.out.println("2.- Dar de baja producto");
        System.out.println("3.- Cambiar informacion de producto");
        System.out.println("4.- Mostrar inventario");
        System.out.println("5.- Hacer Venta");
        System.out.println("6.- Mostrar ventas");
        System.out.println("7.- Mostrar IVA trasladado");
        System.out.println("8.- Mostrar reporte de ventas entre fechas");
        System.out.println("9.- Mostrar ganancia total sin iva ni gastos");
        System.out.println("10.- Inventario total");
        System.out.println("11.- Salir");
        System.out.println("Escribir opcion:");
        opc = reader.nextInt();
        switch(opc){
            case 1:{
                String nombre;
                String descripcion;
                String unidad;
                int cantidad;
                int costo;
                int id;
                System.out.println("Dar de alta nuevo producto");
                System.out.println("Ingresar nombre");
                nombre = reader.nextLine();
                nombre = reader.nextLine();
                System.out.println("Ingresar el numero de id del producto");
                id = reader.nextInt();
                System.out.println("Ingresar descripcion");
                descripcion = reader.nextLine();
                descripcion = reader.nextLine();
                System.out.println("Ingresar tipo de unidad");
                unidad = reader.nextLine();
                System.out.println("Ingresar la cantidad de producto");
                cantidad = reader.nextInt();
                System.out.println("Ingresar el costo");
                costo = reader.nextInt();
                prd = new Producto(nombre,id,descripcion,unidad,cantidad,costo);
                vector.add(prd);
                try{
                    oos = new ObjectOutputStream (new FileOutputStream(miFile));
                    oos.writeObject(vector);
                    oos.close();
                }catch(IOException e){
                    
                }
                break;
            }
            case 2:{
                Vector vector2 = new Vector();
                System.out.println("Ingresar el id a dar de baja");
                int elim = reader.nextInt();
                try{
                ois = new ObjectInputStream (new FileInputStream (miFile));
                vector = (Vector)ois.readObject();
                }catch (ClassNotFoundException ex){
                    String msg = null;
                    Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE,msg);
                }
                int total=vector.size();
                try{
                File archivo = new File("miFile");
                boolean estatus = archivo.delete();
                }catch(Exception e){
                    System.out.println(e);
                }
                for(int i=0;i<total;i++){
                    prAux=(Producto)vector.get(i);
                    if(prAux.getId()!=elim){
                       prd = new Producto(prAux.getNombre(),prAux.getId(),prAux.getDescripcion(),prAux.getUnidad(),prAux.getCantidad(),prAux.getCosto());
                       vector2.add(prd); 
                    }
                }
                try{
                    oos = new ObjectOutputStream (new FileOutputStream(miFile));
                    oos.writeObject(vector2);
                    oos.close();
                }catch(IOException e){
                    
                }
                break;
            }
            case 3:{
                Vector vector2 = new Vector();
                System.out.println("Ingresar el id a cambiar");
                int elim = reader.nextInt();
                
                try{
                ois = new ObjectInputStream (new FileInputStream (miFile));
                vector = (Vector)ois.readObject();
                }catch (ClassNotFoundException ex){
                    String msg = null;
                    Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE,msg);
                }
                int total=vector.size();
                try{
                File archivo = new File("miFile");
                boolean estatus = archivo.delete();
                }catch(Exception e){
                    System.out.println(e);
                }
                
                for(int i=0;i<total;i++){
                    prAux=(Producto)vector.get(i);
                    if(prAux.getId()!=elim){
                     
                       prd = new Producto(prAux.getNombre(),prAux.getId(),prAux.getDescripcion(),prAux.getUnidad(),prAux.getCantidad(),prAux.getCosto());
                       vector2.add(prd); 
                    }else{
                        System.out.println("Que desea cambiar?");
                        System.out.println("1.- Nombre");
                        System.out.println("2.- Descripcion");
                        System.out.println("3.- Tipo de unidad");
                        System.out.println("4.- Agregar cantidad");
                        System.out.println("5.- Cambiar costo");
                        int cambio_opc = reader.nextInt();
                        switch(cambio_opc){
                            case 1:{
                                System.out.println("Ingresar nuevo nombre");
                                String nombre = reader.nextLine();
                                prd = new Producto(nombre,prAux.getId(),prAux.getDescripcion(),prAux.getUnidad(),prAux.getCantidad(),prAux.getCosto());
                                vector2.add(prd);
                                break;
                            }
                            case 2:{
                                System.out.println("Ingresar nueva descripcion");
                                String descripcion = reader.nextLine();
                                prd = new Producto(prAux.getNombre(),prAux.getId(),descripcion,prAux.getUnidad(),prAux.getCantidad(),prAux.getCosto());
                                vector2.add(prd);
                                break;
                            }
                            case 3:{
                                System.out.println("Ingresar nuevo tipo de unidad");
                                String unidad = reader.nextLine();
                                prd = new Producto(prAux.getNombre(),prAux.getId(),prAux.getDescripcion(),unidad,prAux.getCantidad(),prAux.getCosto());
                                vector2.add(prd);
                                break;
                            }
                            case 4:{
                                System.out.println("Ingresar la nueva cantidad de producto");
                                int cantidad = reader.nextInt();
                                System.out.println("Ingresar el costo de la nueva cantidad");
                                int nuevoCosto = reader.nextInt();
                                int arriba = (nuevoCosto*cantidad)+(prAux.getCantidad()*prAux.getCosto());
                                int abajo = cantidad + prAux.getCantidad();
                                int nuevoPrecio = arriba/abajo;
                                prd = new Producto(prAux.getNombre(),prAux.getId(),prAux.getDescripcion(),prAux.getUnidad(),abajo,nuevoPrecio);
                                vector2.add(prd);
                                break;
                            }
                            case 5:{
                                System.out.println("Ingresar el nuevo costo");
                                int costo = reader.nextInt();
                                prd = new Producto(prAux.getNombre(),prAux.getId(),prAux.getDescripcion(),prAux.getUnidad(),prAux.getCantidad(),costo);
                                vector2.add(prd);
                                break;
                            }
                        }
                    }
                }
                try{
                    oos = new ObjectOutputStream (new FileOutputStream(miFile));
                    oos.writeObject(vector2);
                    oos.close();
                }catch(IOException e){
                    
                }
                
                break;
            }

            case 4:{
                System.out.println("INVENTARIO:");
                System.out.println("________________________");
                try{
                ois = new ObjectInputStream (new FileInputStream (miFile));
                vector = (Vector)ois.readObject();
                }catch (ClassNotFoundException ex){
                    String msg = null;
                    Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE,msg);
                }
                int total=vector.size();
                for(int i=0;i<total;i++){
                    prAux=(Producto)vector.get(i);
                    System.out.println("id:            " + prAux.getId());
                    System.out.println("Nombre:        " + prAux.getNombre());
                    System.out.println("Descripcion:   " + prAux.getDescripcion());
                    System.out.println("Unidad:        " + prAux.getUnidad());
                    System.out.println("Cantidad:      " + prAux.getCantidad());
                    System.out.println("Costo:         $" + prAux.getCosto());
                    System.out.println("Precio:        $" + prAux.getCosto()*2);
                    System.out.println("------------------------");
                }
                break;
            }
            case 5:{
                Vector vec3 = new Vector();
                Vector vec4 = new Vector();
                
                String [] nombres = new String[20];
                int otro=0, numPro=0, total=0;
                int [] cantidad = new int[20];
                int [] ganancia = new int [20];
                System.out.println("      VENTA      ");
                System.out.println("-----------------");
                Date fecha = new java.util.Date();
                System.out.println("Fecha de venta: " + fecha);
                
                while(otro==0){
                    
                    System.out.println("Ingrese id de producto");
                    int id = reader.nextInt();
                    System.out.println("Ingrese cantidad de producto");
                    int cant = reader.nextInt();
                    try{
                        ois = new ObjectInputStream (new FileInputStream (miFile));
                        vec3 = (Vector)ois.readObject();
                    }catch (ClassNotFoundException ex){
                        String msg = null;
                        Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE,msg);
                    }
                    int numTo=vec3.size();
                    try{
                        File archivo = new File("miFile");
                        boolean estatus = archivo.delete();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    for(int i=0;i<numTo;i++){
                        prVendido=(Producto)vec3.get(i);
                        if(prVendido.getId()!=id){
                            prd = new Producto(prVendido.getNombre(),prVendido.getId(),prVendido.getDescripcion(),prVendido.getUnidad(),prVendido.getCantidad(),prVendido.getCosto());
                            vec4.add(prd);
                        }else{
                            if(prVendido.getCantidad()>=cant){
                                nombres[numPro] = prVendido.getNombre();
                                cantidad[numPro] = cant;
                                ganancia[numPro] = cant * prVendido.getCosto();
                                total=ganancia[numPro]+total;
                                System.out.println("````````````````````````````````");
                                System.out.println("Precio: $" +cant*prVendido.getCosto()/1.16);
                                System.out.println("IVA:    $" +cant*prVendido.getCosto()/1.16*.16);
                                System.out.println("TOTAL:  $" + prVendido.getCosto()*cant);
                                numPro++;
                                prd = new Producto(prVendido.getNombre(),prVendido.getId(),prVendido.getDescripcion(),prVendido.getUnidad(),prVendido.getCantidad()-cant,prVendido.getCosto());    
                                vec4.add(prd);
                            }else{
                                System.out.println("No hay suficiente producto en stock!!!!!!");
                            }
                        }
                    }   
                    try{
                        oos = new ObjectOutputStream (new FileOutputStream(miFile));
                        oos.writeObject(vec4);
                        oos.close();
                    }catch(IOException e){
                    
                    }
                    vec3.removeAllElements();
                    vec4.removeAllElements();
                    System.out.println("Desea un nuevo producto? SI(0) o NO(1)");
                    otro = reader.nextInt();
                    
                }
                
                //guardado de ventas
                double iva = total/1.16;
                Venta venta = new Venta(fecha,nombres,cantidad,ganancia,total,iva*.16, numPro);
                vecVen.add(venta);
                try{
                        oos = new ObjectOutputStream (new FileOutputStream(Ventas));
                        oos.writeObject(vecVen);
                        oos.close();
                    }catch(IOException e){
                    
                    }
             
                break;
            }
            
            case 6:{
                System.out.println("Todas las ventas:");
                System.out.println("-----------------");
                try{
                ois = new ObjectInputStream (new FileInputStream (Ventas));
                vecVen = (Vector)ois.readObject();
                }catch (ClassNotFoundException ex){
                    String msg = null;
                    Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE,msg);
                }
                Venta ven;
                int total=vecVen.size();
                for(int i=0;i<total;i++){
                    ven=(Venta)vecVen.get(i);
                    System.out.println("______________________________________");
                    System.out.println("Fecha: " + ven.getFecha());
                    int n = ven.getVendidos();
                    int [] cant = ven.getCantidad();
                    int [] gana = ven.getGanancia();
                    String [] nom = ven.getNombreP();
                    System.out.println("Producto\t\t\tCantidad\t\t\tIngreso");
                    for(int j=0;j<n;j++){    
                    System.out.println(nom[j]+"\t\t\t\t" + cant[j]+ "\t\t\t\t$" +gana[j]);
                    }
                    System.out.println("IVA: $" + ven.getIva());
                    System.out.println("GRAN TOTAL: $" + ven.getTotal());
                }
                
                break;
            }
            case 7:{
                System.out.println("IVA trasladado de todas las ventas: ");
                double iva=0;
                try{
                ois = new ObjectInputStream (new FileInputStream (Ventas));
                vecVen = (Vector)ois.readObject();
                }catch (ClassNotFoundException ex){
                    String msg = null;
                    Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE,msg);
                }
                Venta ven;
                int total=vecVen.size();
                for(int i=0;i<total;i++){
                    ven = (Venta)vecVen.get(i);
                    iva = iva + ven.getIva();
                }
                System.out.println("$"+iva);
                break;
            }
            
            case 8:{
                System.out.println("Reporte de ventas en lapso de tiempo");
                System.out.println("Ingresar fecha de inicio");
                System.out.println("Ingrese dia en numero");
                int dia = reader.nextInt();
                System.out.println("Ingrese mes en numero");
                int mes = reader.nextInt();
                System.out.println("Ingrese anno en numero");
                int anno = reader.nextInt();
                System.out.println("Ingresar fecha de fin");
                System.out.println("Ingrese dia en numero");
                int diaFin = reader.nextInt();
                System.out.println("Ingrese mes en numero");
                int mesFin = reader.nextInt();
                System.out.println("Ingrese anno en numero");
                int annoFin = reader.nextInt();
                Date fechaInicio = new Date(anno-1900,mes-1,dia);
                Date fechaFin = new Date(annoFin-1900,mesFin-1,diaFin);
                try{
                ois = new ObjectInputStream (new FileInputStream (Ventas));
                vecVen = (Vector)ois.readObject();
                }catch (ClassNotFoundException ex){
                    String msg = null;
                    Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE,msg);
                }
                Venta ven;
                double ivaEntreFechas=0;
                int total=vecVen.size();
                System.out.println("Las ventas entre " +fechaInicio+ " y " +fechaFin +" son:");
                for(int i=0;i<total;i++){
                    ven = (Venta)vecVen.get(i);
                    if(fechaInicio.compareTo(ven.getFecha())<= 0 && fechaFin.compareTo(ven.getFecha())>=0){
                        System.out.println("id      : " + i);
                        System.out.println("fecha   : " + ven.getFecha());
                        System.out.println("dinero  : $" + ven.getTotal());
                        System.out.println("::::::::::::::::::::::::::::::::::::::");
                        ivaEntreFechas = ivaEntreFechas + ven.getIva();
                    }
                }
                
                System.out.println("El IVA trasladado de entre estas fechas es de: $" + ivaEntreFechas);
                
                break;
            }
            case 9:{
                System.out.println("Ingreso total de todas las ventas: ");
                double ganancia=0;
                try{
                ois = new ObjectInputStream (new FileInputStream (Ventas));
                vecVen = (Vector)ois.readObject();
                }catch (ClassNotFoundException ex){
                    String msg = null;
                    Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE,msg);
                }
                Venta ven;
                int total=vecVen.size();
                for(int i=0;i<total;i++){
                    ven = (Venta)vecVen.get(i);
                    ganancia = ganancia + ven.getTotal();
                }
                double ivaAux = ganancia/1.16;
                double iva = ivaAux*.16;
                double granTotal = ganancia-iva;
                double invertido = ganancia/2;
                double bolsa = ganancia - iva - invertido;
                
                System.out.println("$" + bolsa);
                
                break;
            }
            
            case 10:{
                System.out.println("TOTAL DE INVENTARIO GLOBAL");
                try{
                ois = new ObjectInputStream (new FileInputStream (miFile));
                vector = (Vector)ois.readObject();
                }catch (ClassNotFoundException ex){
                    String msg = null;
                    Logger.getLogger(Tarea1.class.getName()).log(Level.SEVERE,msg);
                }
                int totalInventario = 0;
                int total=vector.size();
                for(int i=0;i<total;i++){
                    prAux=(Producto)vector.get(i);
                    totalInventario = (prAux.getCosto()*prAux.getCantidad())+totalInventario;
                }
                System.out.println("El total de inventario actualmente es de: $" + totalInventario);
                
                break;
            }
            
            case 11:{
                System.out.println("Ha salido del sistema");
                break;
            }
        }
        }
    }
}
//git-scm.com
//UDACITY
//How to use git and github?