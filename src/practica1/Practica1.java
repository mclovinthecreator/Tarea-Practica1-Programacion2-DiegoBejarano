/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author diego
 */
public class Practica1 {

    public static ArrayList<Inventario> auto = new ArrayList<>();
    Recursividad rev = new Recursividad();

    public static void main(String[] args) {
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        int decimal = 23/2;
        System.out.println(decimal);
        while (op != 8) {
            switch (op) {
                case 1:
                    agregar();
                    JOptionPane.showMessageDialog(null, "Agregado exitosamente!");
                    break;
                case 2:

                    JOptionPane.showMessageDialog(null, lista(auto));
            }
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        }

    }

    public static String menu() {
        String mensaje = "=========Menu=========\n"
                + "1. Agregar\n"
                + "2. Listar\n"
                + "3. Modificar\n"
                + "4. Eliminar\n"
                + "5. Vehiculo\n"
                + "6. Vehiculos de color rojo\n"
                + "7. Diferencia entre 2 vehiculos\n"
                + "8. Salir";
        return mensaje;
    }

    public static void agregar() {
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
                        modelo = "Otro";
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
                        modelo = "Otro";
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
                        modelo = "Otro";
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
                        modelo = "Otro";
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
        Inventario in = new Inventario(modelo, matricula, marca, escolor, fabricacion, precio);
        auto.add(in);
    }

    public static String lista(ArrayList<Inventario> auto) {
        String[] marc = {"Toyota", "Nissan", "Ford", "Mitsubishi", "Otro"};
        String lista = "";
        for (int i = 0; i < auto.size(); i++) {

        }
        return lista;
    }

    public static void modificar(String matricula) {
        matricula = matricula.toUpperCase();
        Inventario in = null;
        String mensaje = "Ingrese el aspecto a cambiar del vehiculo\n1. Marca y Modelo\n 2. Color\n 3. Fabricacion\n 4. Precio\n 5. Salir";
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
        
        while (op != 5) {
            for (int i = 0; i < auto.size(); i++) {
                if (matricula.equals(in.getMatricula())) {
                    switch (op) {
                        case 1:
                            
                            in.setMarca();           
                            in.setModelo();
                            break;
                        case 2:
                            in.setColor();
                            break;
                        case 3:
                            in.getFabricacion();
                            break;
                        case 4:
                            in.setPrecio();
                            break;
                        case 5:
                            op = 5;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"ERROR"+JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                }
            }
        }

    }
    public void marcaymodelo(){
        
    }
}
