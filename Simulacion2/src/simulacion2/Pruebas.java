/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion2;

import java.util.ArrayList;

/**
 *
 * @author VICTOR SERRANO
 */
public class Pruebas {
    public static void Promedio(ArrayList<Double> n) {
        System.out.println("\n*****Prueba de Promedios*****");
        double suma = 0.00;
        int cantidad = n.size();
        for (int i = 0; i < cantidad; i++) {
            suma = suma + n.get(i);
        }
        double media = suma / cantidad;
        double Z = ((media - 0.5) * Math.sqrt(cantidad)) / Math.sqrt(0.083333); 
        System.out.println("Media:  " + media);
        System.out.println("Zo: " + Z);
        if (Math.abs(Z) < 1.96) { 
            System.out.println("NO se rechaza la hipotesis de que los numeros pseudoaleatorios tienen un nivel esperado de aceptacion de 0.5\n");
        } else {
            System.out.println("Se rechaza  la hipotesis de que los numeros pseudoaleatorios tienen un nivel esperado de aceptacion de 0.5\n");
        }
    }

    public static void Frecuencia(ArrayList<Double> n) {
        System.out.println("\n*****Prueba de Frecuencias*****");
        int subintervalos = 5, cantidad = n.size(), frecuenciaE = cantidad / subintervalos, frecuenciaO[] = new int[subintervalos];
        double v[] = new double[subintervalos], est = 0.00;
        System.out.println("FE \t FO");
        for (int i = 0; i < subintervalos; i++) {
            int aux = 0;
            for (int j = 0; j < cantidad; j++) {
                v[i] = (double) (i + 1) / subintervalos;
                if (i == 0) {
                    if (n.get(j) < v[i]) {
                        aux++;
                        frecuenciaO[i] = aux;
                    }
                } else {
                    if ((n.get(j) < v[i]) && (n.get(j) >= v[i - 1])) {
                        aux++;
                        frecuenciaO[i] = aux;
                    }
                }
            }
            System.out.println(frecuenciaE + "\t" + frecuenciaO[i] + "  = " + v[i]);
            est = est + Math.pow((frecuenciaO[i] - frecuenciaE), 2);
        }
        double X = (double) est / frecuenciaE;

        System.out.println("n:   " + subintervalos);
        System.out.println("(Xo)^2: " + X);
        double chi_cuadrado = 9.49;
        if (X < chi_cuadrado) {
            System.out.println("NO se rechaza la hipotesis de que los numeros pseudoaleatorios provienen de una distribucion uniforme");
        } else {
            System.out.println("SE rechaza la hipotesis de que los numeros pseudoaleatorios provienen de una distribucion uniforme");
        }
    }
}
