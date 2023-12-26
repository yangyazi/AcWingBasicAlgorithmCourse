package com.lystudy.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StateCompressDPShortestHamiltonPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];
        String[] nums = null;
        for (int r = 0; r < n; ++r) {
            nums = br.readLine().split(" ");
            for (int c = 0; c < n; ++c)
                a[r][c] = Integer.parseInt(nums[c]);
        }
        br.close();
        System.out.println(shortestHamiltonDistance(a));
    }

    private static int shortestHamiltonDistance(int[][] mat) {
        int n = mat.length;
        int[][] dp = new int[1 << n][n];
        for (int i = 0; i < (1 << n); ++i)
            for (int j = 0; j < n; ++j)
                dp[i][j] = Integer.MAX_VALUE >>> 1;
        dp[1][0] = 0; 
        // DP
        for (int i = 0; i < (1 << n); ++i)
            for (int j = 0; j < n; ++j)
                if ((i >> j & 1) == 1)
                    for (int k = 0; k < n; ++k)
                        if (((i - (1 << j)) >> k & 1) == 1)
                            dp[i][j] = Math.min(dp[i][j], dp[i - (1 << j)][k] + mat[k][j]);
        return dp[(1 << n) - 1][n - 1];
    }
}
