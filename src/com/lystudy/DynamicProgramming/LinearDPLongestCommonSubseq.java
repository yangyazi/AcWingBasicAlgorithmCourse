package com.lystudy.DynamicProgramming;

import java.util.Scanner;

public class LinearDPLongestCommonSubseq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        int[][] dp = new int[N + 10][M + 10];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        System.out.println(dp[N][M]);
    }
}
