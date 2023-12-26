package com.lystudy.BasicAlgorithm;

import java.util.Scanner;

public class PrefixSum {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        int n = Scanner.nextInt();
        int m = Scanner.nextInt();

        int[] a = new int[n];
        int[] p = new int[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = Scanner.nextInt();
            p[i + 1] = p[i] + a[i];
        }

        while (m > 0) {
            m--;
            int l = Scanner.nextInt();
            int r = Scanner.nextInt();
            System.out.println(p[r] - p[l - 1]);
        }
    }
}
