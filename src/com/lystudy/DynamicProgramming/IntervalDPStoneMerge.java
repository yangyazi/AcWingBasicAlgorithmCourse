package com.lystudy.DynamicProgramming;

import java.util.Scanner;

public class IntervalDPStoneMerge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int INF = 0x3f3f3f3f;
        int[] a = new int[N + 10];
        for (int i = 1; i <= N; i++)
            a[i] = sc.nextInt();
        int[][] dp = new int[N + 10][N + 10];
        int[] s = new int[N + 10];
        for (int i = 1; i <= N; i++)
            s[i] = s[i - 1] + a[i];
        for (int len = 2; len <= N; len++) {
            for (int i = 1; i + len - 1 <= N; i++) {
                int j = i + len - 1;
                dp[i][j] = INF;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + s[j] - s[i - 1]);
                }
            }
        }
        System.out.println(dp[1][N]);
    }
}
