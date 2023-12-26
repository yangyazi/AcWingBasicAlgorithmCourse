package com.lystudy.SearchandGraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopologicalOrderOfADirectedGraph {
    public static final int N = 100010;
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int[] h = new int[N];
    public static int idx = 1;
    public static int[] q = new int[N];
    public static int[] d = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        while (m-- > 0) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            add(a, b);
            d[b]++;
        }
        if (topsort(n)) {
            for (int i = 0; i < n; i++) {
                System.out.print(q[i] + " ");
            }
        } else
            System.out.println(-1);
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx;
        idx++;
    }

    public static boolean topsort(int n) {
        int hh = 0, tt = -1;
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                q[++tt] = i;
            }
        }
        while (hh <= tt) {
            int t = q[hh++];
            for (int i = h[t]; i != 0; i = ne[i]) {
                int j = e[i];
                if (--d[j] == 0)
                    q[++tt] = j;
            }
        }
        return tt == n - 1;
    }
}
