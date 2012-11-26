/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Scanner;
import parallel.Util;

/**
 *
 * @author baha
 */
public class MatrixCalculation {

    public static Util util;
    public static long start = System.nanoTime();

    public static void main(String[] args) {

        util = new Util();
//        int randomRange = 3;
//        int rows = util.getRandomInt(randomRange);
//        int columns = util.getRandomInt(randomRange);

        //default
//        int a[][] = generateArrays(rows, columns);
//        int b[][] = generateArrays(columns, util.getRandomInt(randomRange));

//        multiply(a, b);
//        show(a, b, multiply(a, b));

//        System.out.println("***************FOR 2 D ***************");
//        rows = 2;
//        columns = 2;
//        a = generateArrays(rows, columns);
//        b = generateArrays(rows, columns);
//        start=System.nanoTime();
//        show(a, b, multiply(a, b));
//        start=System.nanoTime();
//        show(a, b, multiply2(a, b));
//       
//
//        System.out.println("***************FOR 5 D ***************");
//        rows = 5;
//        columns = 5;
//        a = generateArrays(rows, columns);
//        b = generateArrays(rows, columns);
//        start=System.nanoTime();
//        show(a, b, multiply(a, b));
//        start=System.nanoTime();
//        show(a, b, multiply5(a, b));

//        System.out.println("***************FOR 10 D ***************");
        int rows = 200;
        int columns = 200;
        
        int[][] a = generateArrays(rows, columns);
        int[][] b = generateArrays(rows, columns);
        
        start = System.nanoTime();
        multiply(a, b);
        long end = System.nanoTime();
        System.out.println((end - start));
        //====================
        start = System.nanoTime();
        multiply10(a, b);
        end = System.nanoTime();
        System.out.println((end - start));
        
        
//        show(a, b, multiply10(a, b));
//
//        System.out.println("***************FOR DFLT ***************");
//        randomRange = 10;
//        rows = util.getRandomInt(randomRange);
//        columns = util.getRandomInt(randomRange);
//        a = generateArrays(rows, columns);
//        b = generateArrays(columns, util.getRandomInt(randomRange));
//        start=System.nanoTime();
//        show(a, b, multiply(a, b));


    }

    public static void show(int a[][], int b[][], int c[][]) {
//        System.out.println("***************ARRAY[A]***************");
//        print(a);
//        System.out.println("***************ARRAY[B]***************");
//        print(b);
//        System.out.println("***************ARRAY[C]***************");
//        print(c);
//        System.out.println("***************THE TIME***************");
        clock();
        System.out.println("***************THE END ***************\n\n");
    }

    public static void print(int matrix[][]) {
        int n = matrix.length;
        int k = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void fillMatrixWithRandomInts(int[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = util.getRandomInt(5);
            }
        }
    }

    public static int[][] generateArrays(int rows, int columns) {
        int a[][] = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                a[i][j] = util.getRandomInt(5);
            }
        }
        return a;
    }

    public static void clock() {
        long end = System.nanoTime();
        System.out.println("[" + (end - start) + "*10^(-9)] sec");
    }

    public static int[][] multiply(int a[][], int b[][]) {
        int N = a.length;
        int c[][] = new int[N][N];
        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                c[i][j] = 0;
                for (k = 0; k < N; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static int[][] multiply2(int a[][], int b[][]) {
        int N = a.length;
        int N2 = b.length;
        int bColumnSize = b[0].length;
        int c[][] = new int[N][bColumnSize];
        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < bColumnSize; j++) {
                c[i][j] = 0;
                for (k = 0; k < N; k = k + 2) {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j] + a[i][k + 1] * b[k + 1][j];
                }
            }
        }
        return c;
    }

    public static int[][] multiply5(int a[][], int b[][]) {
        int N = a.length;
        int N2 = b.length;
        int bColumnSize = b[0].length;
        int c[][] = new int[N][bColumnSize];
        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < bColumnSize; j++) {
                c[i][j] = 0;
                for (k = 0; k < N; k = k + N) {
                    for (k = 0; k < N; k = k + 5) {
                        c[i][j] = c[i][j] + a[i][k] * b[k][j] + a[i][k + 1] * b[k + 1][j] + a[i][k + 2] * b[k + 2][j] + a[i][k + 3] * b[k + 3][j] + a[i][k + 4] * b[k + 4][j];
                    }
                }
            }
        }
        return c;
    }

    public static int[][] multiply10(int a[][], int b[][]) {
        int N = a.length;
        int c[][] = new int[N][N];
        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                c[i][j] = 0;
                for (k = 0; k < N; k=k+10) {
                    c[i][j] += a[i][k] * b[k][j] + a[i][k + 1] * b[k + 1][j] + a[i][k + 2] * b[k + 2][j] + a[i][k + 3] * b[k + 3][j] + a[i][k + 4] * b[k + 4][j] + a[i][k + 5] * b[k + 5][j] + a[i][k + 6] * b[k + 6][j] + a[i][k + 7] * b[k + 7][j] + a[i][k + 8] * b[k + 8][j] + a[i][k + 9] * b[k + 9][j];
                }
            }
        }
        return c;
    }
}

/*
 1,2,3  1,1 
 1,2,3  2 2
 *      3 3
 */
