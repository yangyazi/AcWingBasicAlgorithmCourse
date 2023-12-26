package com.lystudy.DynamicProgramming;

import java.util.Scanner;

public class KnapsackUnbounded {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int V = scan.nextInt();

        int[] v = new int[N + 10];
        int[] w = new int[N + 10];
        for (int i = 1; i <= N; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }
        scan.close();
        int[][] dp = new int[N + 10][V + 10];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i])
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[N][V]);
    }
}
