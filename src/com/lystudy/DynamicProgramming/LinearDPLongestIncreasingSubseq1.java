package com.lystudy.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LinearDPLongestIncreasingSubseq1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N + 10];
        int[] dp = new int[N + 10];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= N; i++) {
            a[i] = sc.nextInt();
            for (int j = 1; j <= i; j++) {
                if (a[j] < a[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 1;
        for (int d : dp)
            res = Math.max(res, d);
        System.out.println(res);
    }
}
