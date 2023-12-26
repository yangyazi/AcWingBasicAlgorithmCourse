package com.lystudy.DynamicProgramming;

import java.util.Scanner;

public class KnapsackGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] dp = new int[V + 10];
        for (int i = 1; i <= N; i++) {
            int s = sc.nextInt();
            int[] v = new int[s];
            int[] w = new int[s];
            for (int k = 0; k < s; k++) {
                v[k] = sc.nextInt();
                w[k] = sc.nextInt();
            }
            for (int j = V; j >= 0; j--) {
                for (int k = 0; k < s; k++) {
                    if (j >= v[k])
                        dp[j] = Math.max(dp[j], dp[j - v[k]] + w[k]);
                }
            }
        }
        sc.close();
        System.out.println(dp[V]);
    }

}
