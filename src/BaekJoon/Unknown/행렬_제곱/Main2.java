package BaekJoon.Unknown.행렬_제곱;
import java.util.Scanner;

public class Main2 {
    
    static int[][] matrix;
    static int[][] newMatrix;
    static int[][] tempMatrix;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        long B = sc.nextLong();

        matrix = new int[N][N];
        newMatrix = new int[N][N];
        tempMatrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
                newMatrix[i][j] = matrix[i][j];
            }
        }

        sc.close();

        for (long b = 1; b <= B/2; b++) {
            pow(newMatrix, newMatrix);
        }

        if (B % 2 == 1) {
            pow(newMatrix, matrix);
        }

        print();
    }

    public static void pow(int[][] matrix, int[][] oMatrix) {

        for (int z = 0; z < N; z++) {
            for (int j = 0; j < N; j++) {
                long sum = 0;

                for (int i = 0; i < N; i++) {
                    sum += (long)matrix[z][i] * oMatrix[i][j];
                }

                tempMatrix[z][j] = (int)(sum % 1000);
            }
        }

        for (int i = 0; i < N; i++) {
            newMatrix[i] = tempMatrix[i].clone();
        }
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
