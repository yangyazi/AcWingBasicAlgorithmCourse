package com.lystudy.BasicAlgorithm;

import java.util.Scanner;

public class Diff1D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            int c = in.nextInt();
            // 插入 c
            insert(a, i, i, c);
        }
        while (m > 0) {
            m--;

            int l = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            insert(a, l, r, c);
        }
        for (int i = 1; i <= n; i++) {
            a[i] += a[i - 1];
            System.out.print(a[i] + " ");
        }
    }

    public static void insert(int[] a, int l, int r, int c) {
        a[l] += c;
        a[r + 1] -= c;
    }
}