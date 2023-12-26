package com.lystudy.BasicAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TargetSum {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);
        int[] a = new int[n + 10];
        int[] b = new int[m + 10];
        s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        s = in.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(s[i]);
        }
        // A 数组正序遍历
        // B 数组倒序遍历
        for (int i = 0, j = m - 1; i < n; i++) {
            while (j > 0 && a[i] + b[j] > x)
                j--;
            if (a[i] + b[j] == x) {
                System.out.println(i + " " + j);
            }
        }

    }
}
