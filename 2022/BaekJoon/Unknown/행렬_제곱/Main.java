package BaekJoon.Unknown.행렬_제곱;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Map<Long, int[][]> matrixDP;
    static int[][] unitMatrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] matrix = new int[N][N];
        unitMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            unitMatrix[i][i] = 1;
        }
        matrixDP = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = pow(matrix, B);

        print(result);
    }

    private static void print(int[][] result) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] pow(int[][] matrix, long b) {
        if (b == 1) return mul(matrix, unitMatrix);

        if (matrixDP.get(b) != null) return matrixDP.get(b);

        int[][] newMatrix = (b % 2 == 0) ? mul(pow(matrix, b/2), pow(matrix, b/2)) : mul(mul(pow(matrix, b/2), pow(matrix, b/2)), matrix);

        matrixDP.put(b, newMatrix);
        return newMatrix;
    }

    private static int[][] mul(int[][] m1, int[][] m2) {
        int[][] newMatrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += m1[i][k] * m2[k][j];
                }
                sum %= 1000;
                newMatrix[i][j] = sum;
            }
        }

        return newMatrix;
    }
}

