/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import static practica1.Practica1.menu;

/**
 *
 * @author diego
 */
public class Inventario {

    public static ArrayList<Vehiculo> auto = new ArrayList<>();

    public void menuinventario() {
                int op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
                 while (op != 8) {
            switch (op) {
                case 1:
                    agregar();
                    
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    modificar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    masantiguo();
                    break;
                case 6:
                    vehiculosrojos();
                    break;
                case 7:
                    diferenciaanios();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
                    break;
            }
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        }
    }
    public String menu(){
        String menu ="INVENTARIO\n"
                + "1. Agregar\n"
                + "2. Listar\n"
                + "3. Modificar\n"
                + "4. Eliminar\n"
                + "5. vehiculo mas antiguo\n"
                + "6. vehiculos rojos\n"
                + "7. Diferencia entre 2 vehiculos\n"
                + "8. Sallir";
                return menu;
    }
    public void agregar(){
        if(auto.size()>=50){
            JOptionPane.showMessageDialog(null, "INVENTARIO LLENO!!!");
            return;
        }
         String matricula = JOptionPane.showInputDialog("Ingrese la matricula del vehiculo: ");
        matricula = matricula.toUpperCase();
        while (matricula.length() != 8) {
            JOptionPane.showMessageDialog(null, "Error: La matricula debe tener 8 digitos");
            matricula = JOptionPane.showInputDialog("Ingrese la matricula del vehiculo: ");
            matricula = matricula.toUpperCase();
        }
        String marcas = "===MARCAS===\n" + "1. Toyota\n2. Nissan\n3. Ford\n4. Mitsubishi\n5. Otro\n Elige la marca de tu carro";
        int op = Integer.parseInt(JOptionPane.showInputDialog(marcas));
        String marca = "";
        String modelo = "";
        String modelos = "";
        switch (op) {
            case 1:
                marca = "Toyota";
                modelos = "===Modelos===\n" + "1. Tacoma\n2. Supra\n3. Otro\n Elige el modelo de tu carro";
                int op1 = Integer.parseInt(JOptionPane.showInputDialog(modelos));
                switch (op1) {
                    case 1:
                        modelo = "Tacoma";
                        break;
                    case 2:
                        modelo = "Supra";
                        break;
                    case 3:
                        modelo = "Corolla";
                        break;

                }
                break;
            case 2:
                marca = "Nissan";
                modelos = "===Modelos===\n" + "1. GTR\n2. Sentra\n3. Otro\n Elige el modelo de tu carro";
                int op2 = Integer.parseInt(JOptionPane.showInputDialog(modelos));
                switch (op2) {
                    case 1:
                        modelo = "GTR";
                        break;
                    case 2:
                        modelo = "Sentra";
                        break;
                    case 3:
                        modelo = "Frontier";
                        break;

                }
                break;
            case 3:
                marca = "Ford";
                modelos = "===Modelos===\n" + "1. Raptor\n2. Mustang\n3. Otro\n Elige el modelo de tu carro";
                int op3 = Integer.parseInt(JOptionPane.showInputDialog(modelos));
                switch (op3) {
                    case 1:
                        modelo = "Raptor";
                        break;
                    case 2:
                        modelo = "Mustang";
                        break;
                    case 3:
                        modelo = "F-150";
                        break;

                }
                break;
            case 4:
                marca = "Mitsubishi";
                modelos = "===Modelos===\n" + "1. L200\n2. Xpander\n3. Otro\n Elige el modelo de tu carro";
                int op4 = Integer.parseInt(JOptionPane.showInputDialog(modelos));
                switch (op4) {
                    case 1:
                        modelo = "Raptor";
                        break;
                    case 2:
                        modelo = "Xpander";
                        break;
                    case 3:
                        modelo = "L-200";
                        break;

                }
                break;
            case 5:
                marca = "Otro";
                modelo = "Otro";
                break;

        }
        String colores = "===Colores===\n1.Negro\n2.Blanco\n3.Rojo\n4.Azul\nElige el color de tu vehiculo";
        int color = Integer.parseInt(JOptionPane.showInputDialog(colores));
        String escolor = "";
        switch (color) {
            case 1:
                escolor = "Negro";
            case 2:
                escolor = "Blanco";
            case 3:
                escolor = "Rojo";
            case 4:
                escolor = "Azul";
        }
        int fabricacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el anho de fabricacion de su auto (1885-2026)"));
        while (fabricacion < 1885 || fabricacion > 2026) {
            JOptionPane.showMessageDialog(null, "Error: La fecha debe estar entre 1885 y 2026");
            fabricacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el anho de fabricacion de su auto (1885-2026)"));
        }
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del vehiculo este debe ser mayor a 0"));
        while (precio < 0) {
            JOptionPane.showMessageDialog(null, "Error: El precio debe ser mayor a 0");
            precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del vehiculo este debe ser mayor a 0"));
        }
       Vehiculo v = new Vehiculo(matricula,marca,modelo,escolor,fabricacion,precio);
        auto.add(v);
    }
    public void listar(){
        if(auto.isEmpty()){
            JOptionPane.showMessageDialog(null, "El inventario esta vacio");
            return;
        }
        for (int i = 0; i < auto.size()-1; i++) {
            for (int j = 0; j < auto.size()-i-1; j++) {
                if(auto.get(j).getMarca().compareToIgnoreCase(auto.get(j+1).getMarca())>0);
                Vehiculo temp = auto.get(i);
                auto.set(j,auto.get(j+1));
                auto.set(j+1,temp);
            }
        }
        String mensaje = "LISTA POR MARCAS:";
        for (int i = 0; i < auto.size(); i++) {
            mensaje += auto.get(i).toString() + "\n";
        }
        JOptionPane.showMessageDialog(null,mensaje);
    }    
    public void modificar(){
        listar();
        String buscar = JOptionPane.showInputDialog("Matricula a modificar: ");
        buscar = buscar.toUpperCase();
        Vehiculo v =null;
        for (int i = 0; i < auto.size(); i++) {
            if(auto.get(i).getMatricula().equalsIgnoreCase(buscar)){
                v = auto.get(i);
            }
        }
        if(v==null){
            JOptionPane.showMessageDialog(null,"No encontrado");
            return;
        }
        int op = 0;
        while(op != 6){
            String menu = "EDITAR"+ v.getMatricula() + "\n"
                    + "1. Marca\n"
                    + "2. Modelo\n"
                    + "3. Color\n"
                    + "4. Anio\n"
                    + "5. Precio\n"
                    + "6. Salir";
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(op){
                case 1:
                    v.setMarca(elegirMarca());
                    break;
                case 2:
                    v.setModelo(elegirmodelo(v.getMarca()));
                    break;
                case 3:
                    v.setColor(seleccionarColor());
                    break;
                case 4:
                    int anio = Integer.parseInt(JOptionPane.showInputDialog("Nuevo anio: "));
                    v.setFabricacion(anio);
                    break;
                case 5:
                    double precionew = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio: "));
                    v.setPrecio(precionew);
                    break;
            }
        }
    }
    private String elegirMarca(){
        String menu = "===MARCAS===\n" + "1. Toyota\n2. Nissan\n3. Ford\n4. Mitsubishi\n5. Otro\n Elige la marca de tu carro";
        String marca = "";
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(op){
            case 1:
                marca = "Toyota";
                break;
                   case 2:
                marca = "Nissan";
                break;
                   case 3:
                marca = "Ford";
                break;
                   case 4:
                marca = "Mitsubishi";
                break;
                   default:
                       marca = "Otro";
                       break;
        }
        return marca;
    }
    private String elegirmodelo(String marca){
        String menu = "Seleccione el modelo de su auto\n";
        String modelo = "";
        if(marca.equals("Toyora")){
            menu+="1.Tacoma\n2. Supra\n3. Corolla";
        }
        else if(marca.equals("Nissan")){
            menu+="1.GTR\n2. Sentra\n3. Frontier";
        }
        else if(marca.equals("Ford")){
            menu+="1.F-150\n2. Raptor\n3. Mustang";
        }
        else if(marca.equals("Mitsubishi")){
            menu+="1.L-200\n2. X-pander\n3. Raptor";
        }
        else{
            return "Otro";
        }
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(op){
            case 1:
                if(marca.equals("Toyora")){
                    modelo = "Tacoma";
                }
                if(marca.equals("Nissan")){
                    modelo = "GTR";
                }
                if(marca.equals("Ford")){
                    modelo = "F-150";
                }
                if(marca.equals("Mitsubishi")){
                    modelo = "L-200";
                }
                break;
                case 2:
                if(marca.equals("Toyora")){
                    modelo = "Supra";
                }
                if(marca.equals("Nissan")){
                    modelo = "Sentra";
                }
                if(marca.equals("Ford")){
                    modelo = "Raptor";
                }
                if(marca.equals("Mitsubishi")){
                    modelo = "Xpander";
                }
                break;
                case 3:
                if(marca.equals("Toyora")){
                    modelo = "Corolla";
                }
                if(marca.equals("Nissan")){
                    modelo = "Frontier";
                }
                if(marca.equals("Ford")){
                    modelo = "Mustang";
                }
                if(marca.equals("Mitsubishi")){
                    modelo = "Raptor";
                }
                break;
                default:
                    modelo = "Otro";
                    break;
        }
        return modelo;
    }
    private String seleccionarColor(){
        String menu = "Seleccione el color de su auto\n"
                + "1. Negro\n"
                + "2. Blanco\n"
                + "3. Rojo\n"
                + "4. Azul";
        String color="";
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch(op){
            case 1: 
                color = "Negro";
                break;
                case 2: 
                color = "Blanco";
                break;
                case 3: 
                color = "Rojo";
                break;
                case 4: 
                color = "Azul";
                break;
                default:
                    color = "Plateado";
                        break;
        }
        return color;
    }
    public void eliminar(){
        String mat = JOptionPane.showInputDialog("Matricula a eliminar").toUpperCase();
        for (int i = 0; i < auto.size(); i++) {
            if(auto.get(i).getMatricula().equals(mat)){
                auto.remove(i);
                JOptionPane.showMessageDialog(null, "ELIMINADO");
                return;
            }
            
        }
         JOptionPane.showMessageDialog(null, "NO ENCONTRADO");
    }
    public void masantiguo(){
        if(auto.isEmpty()){
            return;
        }
        Vehiculo v = auto.get(0);
        for (int i = 0; i < auto.size(); i++) {
            if(auto.get(i).getFabricacion()<v.getFabricacion()){
                v = auto.get(i);
            }
        }
         JOptionPane.showMessageDialog(null, "Mas Antiguo"+v.toString());   
    }
    public void vehiculosrojos(){
        String ro = "Rojos:\n";
        boolean hay = false;
        for (int i = 0; i < auto.size(); i++) {
            if(auto.get(i).getColor().equalsIgnoreCase("Rojo")){
                ro += auto.get(i).toString() + "\n";
                hay = true;
            }
        }
        if(hay == true){
            JOptionPane.showMessageDialog(null, ro);
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay vehiculos rojos registrados");
        }
    }
    public void diferenciaanios(){
        String mat1 = JOptionPane.showInputDialog("Matricula 1;").toUpperCase();
         String mat2 = JOptionPane.showInputDialog("Matricula 2;").toUpperCase();
         Vehiculo v = null, v1 = null;
         
         for (int i = 0; i < auto.size(); i++) {
            if(auto.get(i).getMatricula().equals(mat1)){
                v = auto.get(i);
            }
            if(auto.get(i).getMatricula().equals(mat2)){
                v1 = auto.get(i);
            }
        }
         if(v != null && v1 != null){
             int anio1 = v.getFabricacion();
             int anio2 = v1.getFabricacion();
             int diferencia = anio1 - anio2;
             
             if(diferencia < 0){
                 diferencia = diferencia * -1;
             }
             JOptionPane.showMessageDialog(null, "La diferencia de anios es de: "+diferencia);
             
         }
         else{
              JOptionPane.showMessageDialog(null, "Error");
         }
    }
}
