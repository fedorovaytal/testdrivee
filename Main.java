package com.company.test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Начальная точка маршрута таксиста x: ");
        int drXA = in.nextInt();
        System.out.print("Начальная точка маршрута таксиста y: ");
        int drYA = in.nextInt();
        System.out.print("Конечная точка маршрута таксиста x: ");
        int drXB = in.nextInt();
        System.out.print("Конечная точка маршрута таксиста y: ");
        int drYB = in.nextInt();

        System.out.print("Сколько попудчиков: ");
        int size = in.nextInt();
        int e = 0;
        char xy;
        int[][] matrix = new int[size][2];
        for (int i = 0; i < matrix.length; i++) {
            e++;
            xy = 'x';
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Координаты начальной точки попудчика номер " + e + " "+ xy +": ");
                xy = 'y';
                matrix[i][j] = in.nextInt();
            }
        }

        int[][] matrix1 = new int[size][2];
        e = 0;
        for (int i = 0; i < matrix.length; i++) {
            e++;
            xy = 'x';
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Координаты конечной точки попудчика номер " + e + " "+ xy +": ");
                xy = 'y';
                matrix1[i][j] = in.nextInt();
            }
        }

        double[] matrix2 = new double[size];
        double[] matrix3 = new double[size];
        double[] matrix4 = new double[size];
        double[] matrix5 = new double[size];

        for (int i = 0; i < size; i++) {
                matrix2[i] = Math.sqrt(Math.pow((drXA-matrix[i][0]),2)+Math.pow((drYA-matrix[i][1]),2));
                matrix3[i] = Math.sqrt(Math.pow((matrix[i][0]-matrix1[i][0]),2)+Math.pow((matrix[i][1]-matrix1[i][1]),2));
                matrix4[i] = Math.sqrt(Math.pow((matrix1[i][0]-drXB),2)+Math.pow((matrix1[i][1]-drYB),2));
                matrix5[i] = matrix2[i] + matrix3[i] + matrix4[i];
            }
        double[] d = new double[size];
        int t = 0;
        for ( int i = 0; i < size; i++) {
            t++;
            d[i] = t;
        }

        double[][] arr = new double[d.length][2];
        for(int i = 0; i < d.length; i++){
            arr[i][0] = d[i];
            arr[i][1] = matrix5[i];

        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j][1] > arr[j+1][1]) {
                    double tmp = arr[j][1];
                    arr[j][1] = arr[j+1][1];
                    arr[j+1][1] = tmp;
                    tmp = arr[j][0];
                    arr[j][0] = arr[j+1][0];
                    arr[j+1][0] = tmp;
                }
            }
        }
        System.out.println("Вывод пассажиров по оптимальности:");
        for(int i = 0; i < arr.length; i++){
            System.out.print("Пассажир № " + arr[i][0] + " Длина дороги ");
            System.out.println(arr[i][1]);
        }
    }
}
