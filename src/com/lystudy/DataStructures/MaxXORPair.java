package com.lystudy.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxXORPair {
    static final int N = 100010;
    static final int M = 31 * N;
    static int[][] son = new int[M][2];
    static int[] a = new int[N];
    static int idx = 0;

    public static void insert(int x) {
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int t = x >> i & 1;
            if (son[p][t] == 0)
                son[p][t] = ++idx;
            p = son[p][t];
        }
    }

    public static int query(int x) {
        int res = 0;
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int t = x >> i & 1;
            if (son[p][t ^ 1] != 0) {
                p = son[p][t ^ 1];
                res = res * 2 + (t ^ 1);
            } else {
                p = son[p][t];
                res = res * 2 + t;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        int res = 0;
        for (int i = 0; i < n; i++) {
            insert(a[i]);
            int t = query(a[i]);
            res = Math.max(res, a[i] ^ t);
        }
        System.out.println(res);
    }
}
