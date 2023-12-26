package com.lystudy.SearchandGraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SpfaShortestPath {
    static int INF = 0x3f3f3f3f;
    static int N = 100010;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] h = new int[N];
    static int[] w = new int[N];
    static int idx = 1;
    static int[] d = new int[N];
    static boolean[] flag = new boolean[N];

    public static void add(int x, int y, int z) {
        e[idx] = y;
        w[idx] = z;
        ne[idx] = h[x];
        h[x] = idx++;
    }

    public static int spfa(int n) {
        Arrays.fill(d, INF);
        d[1] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        flag[1] = true;
        while (!q.isEmpty()) {
            int t = q.remove();
            flag[t] = false;
            for (int i = h[t]; i != 0; i = ne[i]) {
                int j = e[i];
                if (d[j] > d[t] + w[i]) {
                    d[j] = d[t] + w[i];
                    if (!flag[j]) {
                        q.add(j);
                        flag[j] = true;
                    }
                }
            }
        }
        return d[n];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        while (m-- > 0) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int z = Integer.parseInt(s[2]);
            add(x, y, z);
        }
        if (spfa(n) < INF / 2)
            System.out.println(d[n]);
        else
            System.out.println("impossible");
    }
}
