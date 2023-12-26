package com.lystudy.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MemoizationSearchSkating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), col = sc.nextInt();
        int[][] mat = new int[row][col];
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                mat[r][c] = sc.nextInt();
            }
        }

        int[][] dp = new int[row][col];
        for (int r = 0; r < row; ++r)
            Arrays.fill(dp[r], -1);
        int res = 0;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                res = Math.max(res, dfs(r, c, dp, mat));
            }
        }
        System.out.println(res);

    }

    static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    static int dfs(int r, int c, int[][] dp, int[][] mat) {
        int row = mat.length, col = mat[0].length;
        if (dp[r][c] != -1)
            return dp[r][c];
        int tmp = 0;
        for (int[] d : dir) {
            int rr = r + d[0], cc = c + d[1];
            if (rr >= 0 && rr < row && cc >= 0 && cc < col && mat[rr][cc] < mat[r][c]) {
                tmp = Math.max(dfs(rr, cc, dp, mat), tmp);
            }
        }
        dp[r][c] = 1 + tmp;
        return dp[r][c];
    }
}
