package com.lystudy.DynamicProgramming;

import java.util.Scanner;

public class KnapsackMultiple2 {
    static int M = 11010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int M = 11 * N + 10;
        int[] v = new int[M];
        int[] w = new int[M];
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int s = sc.nextInt();
            int k = 1;
            while (k <= s) {
                idx++;
                v[idx] = k * a;
                w[idx] = k * b;
                s -= k;
                k = k << 1;
            }
            if (s > 0) {
                idx++;
                v[idx] = s * a;
                w[idx] = s * b;
            }
        }
        int[] dp = new int[V + 10];
        for (int i = 1; i <= idx; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[V]);
    }
}
