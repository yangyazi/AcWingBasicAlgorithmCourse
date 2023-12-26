package com.lystudy.DynamicProgramming;

import java.util.Scanner;

public class DigitCountDP {
    static Scanner in = new Scanner(System.in);
    static long dp[];
    static long mi[];
    static long ans1[];
    static long ans2[];

    public static void main(String[] args) {
        while (in.hasNext()) {
            dp = new long[11];
            mi = new long[11];
            ans1 = new long[11];
            ans2 = new long[11];
            int n = in.nextInt();
            int m = in.nextInt();
            int l = Math.min(n, m);
            int r = Math.max(n, m);
            if (l == 0 && r == 0)
                return;
            dp[1] = 1;
            mi[0] = 1L;
            for (int i = 1; i <= 10; i++) {
                dp[i] = dp[i - 1] * 10 + mi[i - 1];
                mi[i] = mi[i - 1] * 10;
            }

            solve(r, ans1);
            solve(l - 1, ans2);

            for (int i = 0; i <= 9; i++) {
                System.out.print(ans1[i] - ans2[i] + " ");
            }
            System.out.println();

        }
    }

    static void solve(int n, long ans[]) {
        int tmp = n;
        int num[] = new int[11];
        int len = 0;
        while (n > 0) {
            num[++len] = n % 10;
            n /= 10;
        }

        for (int i = len; i > 0; i--) {
            for (int j = 0; j < 10; j++) {
                ans[j] += dp[i - 1] * num[i];
            }
            for (int j = 0; j < num[i]; j++) {
                ans[j] += mi[i - 1];
            }
            tmp -= mi[i - 1] * num[i];
            ans[num[i]] += tmp + 1;

            ans[0] -= mi[i - 1];
        }
    }
}