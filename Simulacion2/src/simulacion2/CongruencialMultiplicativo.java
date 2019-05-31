/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author VICTOR SERRANO
 */
public class CongruencialMultiplicativo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numero=0, d=0, modulo=0, semilla=0, cmultiplicativa=0, aux=0;
        double t=0;
        ArrayList<Double> numeros = new ArrayList<>();
        double n_uniformes = 0.00;
        String[] botones = {" Sistema Decimal", " Sistema Binario"};
        int sistema = JOptionPane.showOptionDialog(null, " Elgir Sistema", "Cita", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null/*icono*/, botones, botones[0]);
        switch (sistema) {
            case 0:
                d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de d","m = 10^d", JOptionPane.QUESTION_MESSAGE));
                modulo = (int) Math.pow(10, d);
                
                semilla =(int) primo_Cercano(modulo);

                int p[] = {3, 11, 13, 19, 21, 27, 29, 37, 53, 59, 61, 67, 69, 77, 83, 91};
                int numeroaleat = (int) (Math.random() * p.length) + 1;
                int p_seleccionado = p[numeroaleat];
                t = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese t","a = (200*t)+p", JOptionPane.QUESTION_MESSAGE));
                cmultiplicativa =(int)(200*t)+p_seleccionado;
                JOptionPane.showMessageDialog(null, "Semilla: "+semilla);
                
                System.out.printf("n" + "\t\t" + "Xn" + "\t\t" + "Numeros Uniformes" + " \n");
                int ax = semilla;

                for (int i = 0; i < modulo; i++) {
                    numero = (cmultiplicativa * semilla) % modulo;
                    n_uniformes = (double) numero / modulo;
                    System.out.printf(i + 1 + "\t\t" + numero + "\t\t" + n_uniformes + "\n");
                    semilla = numero;
                    numeros.add(n_uniformes);
                    if (ax == semilla) {
                        break;
                    }
                }
                Pruebas.Promedio(numeros);
                Pruebas.Frecuencia(numeros);
                break;
            case 1:
                d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de d","m = 2^d", JOptionPane.QUESTION_MESSAGE));
                modulo = (int) Math.pow(2, d);
                semilla = (int)primo_Cercano(modulo);
                
                t = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese t","a = (8*t)-3", JOptionPane.QUESTION_MESSAGE));
                int a =(int)(8*t)-3;
                aux = modulo / 4;
                System.out.printf("n" + "\t\t" + "Xn" + "\t\t" + "Numeros Uniformes" + " \n");

                for (int i = 0; i < aux; i++) {
                    numero = (a * semilla) % modulo;
                    n_uniformes = (double) numero / modulo;
                    System.out.printf(i + 1 + "\t\t" + numero + "\t\t" + n_uniformes +"\n");
                    semilla = numero;
                    numeros.add(n_uniformes);
                }
                Pruebas.Promedio(numeros);
                Pruebas.Frecuencia(numeros);
                break;

        }
    }

    public static double primo_Cercano(double n) {
        int aux = 2;
        boolean b = true;

        while ((b) && (aux != n)) {
            if (n % aux == 0) {
                b = false;
            }
            aux++;
        }

        if (b) {
            return n;
        } else {
            return primo_Cercano(n - 1);
        }

    }

}
