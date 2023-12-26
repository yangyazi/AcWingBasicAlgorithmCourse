package com.lystudy.SearchandGraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrimMiniSpanTree {
    static final int INF = 0x3f3f3f3f;
    static final int N = 510;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] flag = new boolean[N];
    static int res = 0;

    public static int prim(int n) {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for (int i = 1; i <= n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!flag[j] && (t == -1 || dist[j] < dist[t]))
                    t = j;
            }
            flag[t] = true;
            if (dist[t] == INF)
                return INF;
            res += dist[t];
            for (int j = 1; j <= n; j++)
                dist[j] = Math.min(dist[j], g[t][j]);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], INF);
        }
        while (m-- > 0) {
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            g[u][v] = g[v][u] = Math.min(g[u][v], w);
        }
        if (prim(n) == INF)
            System.out.println("impossible");
        else
            System.out.println(res);

    }
}
