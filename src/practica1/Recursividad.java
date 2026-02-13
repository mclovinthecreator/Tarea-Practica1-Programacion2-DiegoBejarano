/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Recursividad {

    public void menurecursividad() {
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("MENU RECURSIVIDAD\n"
                    + "1. Decimales a Binarios"
                    + "\n2. MCD"
                    + "\n3. Fibonacci"
                    + "\n4. Busqueda Binaria"
                    + "\n 5. Salir"));
            switch (op) {
                case 1:
                    int decimal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero decimal: "));
                    String bin = "";
                    binario(decimal, bin);
                    break;
                case 2:
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero "));
                    int mcd = 0;
                    JOptionPane.showMessageDialog(null, mcd(a, b, mcd));
                    break;
                case 3:
                    int fib = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la secuencia fibonacci que desea imprimir"));
                    int n1 = 0,
                     n2 = 1,
                     i = 0,
                     suma = 0;
                    JOptionPane.showMessageDialog(null, fibonacci(fib, n1, n2, i, suma));
                    break;
                case 4:
                    int[] ar = {3,5,6,9,12,17,20,38,40,54};
                    int val = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor a buscar: "));
                    int pos = busquedaBinaria(ar, val, 0, ar.length - 1);
                    if (pos == -1) {
                        JOptionPane.showMessageDialog(null, "No encontrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Encontrado en posicion: " + pos);
                    }
                    break;
            }
        } while (op != 5);
    }

// recursiva para reordenar el string y mostrar el verdadero valor binario del decinmal
    public String stringAarreglo(String bin, int i) {
        if (i == bin.length()) {
            return "";
        }

        char caracter = bin.charAt(bin.length() - 1 - i);

        return caracter + stringAarreglo(bin, i + 1);
    }

    //Operacion para convertir decimal en binario;
    public String binario(int decimal, String bin) {
        if (decimal == 0) {
            int i = 0;
            JOptionPane.showMessageDialog(null, stringAarreglo(bin, i));

        } else {
            if (decimal % 2 == 0) {
                bin += "0";
            } else {
                bin += "1";
            }
            decimal = decimal / 2;
            binario(decimal, bin);
        }
        return bin;
    }

    //calculador del mcd
    public int mcd(int a, int b, int mcd) {
        if (a % b == 0) {
            return b;
        }
        mcd = a % b;
        a = b;
        b = mcd;
        return mcd(a, b, mcd);

    }

    public int fibonacci(int fib, int n1, int n2, int i, int suma) {
        if (fib == i + 1) {
            return n1;
        }
        suma = n1 + n2;
        n1 = n2;
        n2 = suma;
        i += 1;
        return fibonacci(fib, n1, n2, i, suma);
    }

    public int busquedaBinaria(int[] ar, int val, int inicio, int finall) {
        if (inicio > finall) {
            return -1;
        }
        int mid = (inicio + finall) / 2;
        if (ar[mid] == val) {
            return mid;
        }
        if (val < ar[mid]) {
            finall = mid - 1;
            return busquedaBinaria(ar, val, inicio, finall);
        }
        inicio = mid + 1;
        return busquedaBinaria(ar, val, inicio, finall);
    }
}
