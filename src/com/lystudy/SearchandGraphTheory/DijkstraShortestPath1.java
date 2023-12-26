package com.lystudy.SearchandGraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DijkstraShortestPath1 {
    public static final int N = 510;
    public static final int INF = 0x3f3f3f3f;
    public static int[][] g = new int[N][N];
    public static int[] d = new int[N];
    public static boolean[] flag = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], INF);
        }
        Arrays.fill(d, INF);
        while (m-- > 0) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int z = Integer.parseInt(s[2]);
            g[x][y] = Math.min(g[x][y], z);
        }
        System.out.println(dijkstra(n));
    }

    public static int dijkstra(int n) {
        d[1] = 0;
        for (int i = 1; i <= n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!flag[j] && (t == -1 || d[t] > d[j]))
                    t = j;
            }
            flag[t] = true;
            for (int j = 1; j <= n; j++) {
                d[j] = Math.min(d[j], d[t] + g[t][j]);
            }
        }
        if (d[n] == 0x3f3f3f3f)
            return -1;
        return d[n];
    }
}
