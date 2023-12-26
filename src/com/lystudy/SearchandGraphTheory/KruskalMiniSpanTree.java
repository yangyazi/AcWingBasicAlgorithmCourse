package com.lystudy.SearchandGraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KruskalMiniSpanTree {
    static final int N = 100010;
    static final int INF = 0x3f3f3f3f;
    static int[] p = new int[N];
    static int res = 0;

    static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static int kruskal(int n, int m, Edge[] edges) {
        Arrays.sort(edges, (Edge e1, Edge e2) -> e1.w - e2.w);
        for (int i = 1; i <= n; i++)
            p[i] = i;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int u = edges[i].u, v = edges[i].v, w = edges[i].w;
            u = find(u);
            v = find(v);
            if (u != v) {
                p[u] = v;
                res += w;
                cnt++;
            }
        }
        if (cnt < n - 1)
            return INF;
        else
            return res;
    }

    public static int find(int x) {
        if (p[x] != x)
            p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            edges[i] = new Edge(u, v, w);
        }

        int t = kruskal(n, m, edges);
        if (t == INF)
            System.out.println("impossible");
        else
            System.out.println(res);
    }
}
