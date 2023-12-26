package com.lystudy.DynamicProgramming;

import java.util.Scanner;

public class LinearDPNumTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int INF = 0x3f3f3f3f;
        int[][] a = new int[n + 10][n + 10];
        int[] dp = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                a[i][j] = sc.nextInt();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                dp[j] = Math.max(dp[j], dp[j + 1]) + a[i][j];
        }
        System.out.println(dp[1]);
    }
}