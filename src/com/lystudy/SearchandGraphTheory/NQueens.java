package com.lystudy.SearchandGraphTheory;

import java.util.Scanner;

public class NQueens {
    public static int N = 15;

    public static char[][] res = new char[N][N];
    // 标记是否冲突，列，主对角线，副对角线
    // 因为是一行一行递归，所以行不会有冲突
    public static boolean[] col = new boolean[N];
    public static boolean[] dg = new boolean[2 * N];
    public static boolean[] sdg = new boolean[2 * N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = '.';
            }
        }
        // DFS 的是行，从第 0 行开始
        dfs(0, n);
    }

    public static void dfs(int u, int n) {
        // 如果已经遍历完所有行，输出答案
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(res[i][j]);
                System.out.println();
            }
            System.out.println();
            return;
        }
        // 遍历每一列，看是否可以放皇后
        for (int i = 0; i < n; i++) {
            // 主对角线和为定值,副对角线差为定值,防止差为负数,加个N
            if (!col[i] && !dg[u + i] && !sdg[u - i + N]) {
                col[i] = dg[u + i] = sdg[u - i + N] = true;
                res[u][i] = 'Q';
                dfs(u + 1, n);
                res[u][i] = '.';
                col[i] = dg[u + i] = sdg[u - i + N] = false;
            }
        }
    }
}
