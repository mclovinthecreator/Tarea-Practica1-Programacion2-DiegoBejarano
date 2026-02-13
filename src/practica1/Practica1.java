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
    static Recursividad rec = new Recursividad();
    static Inventario in = new Inventario();

    public static void main(String[] args) {
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        while (op != 3) {
            switch (op) {
                case 1:
                    in.menuinventario();
                    break;
                case 2:
                    rec.menurecursividad();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"FIN.........");
                    break;
            }
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        }

    }

    public static String menu() {
        String mensaje = "=========Menu Principal=========\n"
                + "1. Inventario de autos\n"
                + "2. Recursiva\n"
                + "3. Salir";
        return mensaje;
    }
}
