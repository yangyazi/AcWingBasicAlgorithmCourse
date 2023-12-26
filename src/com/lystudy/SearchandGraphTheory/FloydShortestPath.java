package com.lystudy.SearchandGraphTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FloydShortestPath {
    static final int N = 210;
    static final int INF = 0x3f3f3f3f;
    static int[][] g = new int[N][N];

    public static void floyd(int n) {
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (i == j)
                    g[i][j] = 0;
                else
                    g[i][j] = INF;
        while (m-- > 0) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int z = Integer.parseInt(s[2]);
            g[x][y] = Math.min(g[x][y], z);
        }
        floyd(n);
        while (k-- > 0) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            if (g[x][y] > INF / 2)
                bw.write("impossible\n");
            else
                bw.write(g[x][y] + "\n");
        }
        bw.close();
        br.close();
    }
}
