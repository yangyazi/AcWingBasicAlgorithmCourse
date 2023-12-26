package com.lystudy.SearchandGraphTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOfVerticesInAGraph {
    public static final int N = 100010;
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int[] h = new int[N];
    public static int idx = 1;
    public static int[] dist = new int[N];
    public static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        while (m-- > 0) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            add(a, b);
        }
        bfs();
        System.out.println(dist[n] - 1);
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx;
        idx++;
    }

    public static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        dist[1] = 1;

        while (!q.isEmpty()) {
            int t = q.remove();
            for (int i = h[t]; i != 0; i = ne[i]) {
                int j = e[i];

                if (dist[j] == 0) {
                    q.add(j);
                    dist[j] = dist[t] + 1;
                }
            }
        }
    }
}
