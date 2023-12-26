package com.lystudy.DynamicProgramming;

import java.util.Scanner;

public class LinearDPEditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] s = new String[n + 10];
        String[] q = new String[m + 10];
        int[] num = new int[m + 10];
        for (int i = 1; i <= n; i++)
            s[i] = sc.next();
        for (int i = 1; i <= m; i++) {
            q[i] = sc.next();
            num[i] = sc.nextInt();
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (find(s[j], q[i]) <= num[i])
                    cnt++;
            }
            System.out.println(cnt);
        }
    }

    public static int find(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n + 10][m + 10];
        for (int i = 0; i <= n; i++)
            dp[i][0] = i;
        for (int j = 0; j <= m; j++)
            dp[0][j] = j;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                else
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp[n][m];
    }
}
