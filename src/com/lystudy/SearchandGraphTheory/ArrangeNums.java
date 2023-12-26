package com.lystudy.SearchandGraphTheory;

import java.io.IOException;
import java.util.Scanner;

public class ArrangeNums {
    public static int N = 10;
    public static int[] a = new int[N];
    public static boolean[] flag = new boolean[N];

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dfs(1, n);
    }

    public static void dfs(int u, int n) {

        if (u == n + 1) {
            for (int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (!flag[i]) {

                flag[i] = true;

                a[u] = i;

                dfs(u + 1, n);

                flag[i] = false;
                a[u] = 0;
            }
        }
    }
}
