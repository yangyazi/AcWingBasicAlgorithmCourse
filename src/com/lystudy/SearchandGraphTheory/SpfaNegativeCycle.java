package com.lystudy.SearchandGraphTheory;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class SpfaNegativeCycle {
    static int inf = 0x3f3f3f3f;

    static boolean checkNegativeLoop(Graph g) {
        int n = g.n;
        boolean[] vis = new boolean[n];
        int[] dis = new int[n];
        int[] cnt = new int[n];

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            q.add(i);
            vis[i] = true;

        }

        while (!q.isEmpty()) {
            int a = q.poll();
            vis[a] = false;
            for (int next = g.h[a]; next != -1; next = g.np[next]) {
                int b = g.ele[next];
                int w = g.wgh[next];
                if (dis[b] > dis[a] + w) {
                    dis[b] = dis[a] + w;
                    cnt[b] = cnt[a] + 1;
                    if (cnt[b] >= n)
                        return true;
                    if (!vis[b]) {
                        q.offer(b);
                        vis[b] = true;
                    }

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Graph g = new Graph(n, m);
        for (int i = 0; i < m; ++i) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int w = sc.nextInt();
            if (a != b) {
                g.add(a, b, w);
            }
        }
        boolean res = checkNegativeLoop(g);
        if (res)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}

class Graph {
    int[] ele;
    int[] np;
    int[] wgh;
    int[] h;
    int n, m;
    int idx = 0;

    /* 节点数，边数 */
    Graph(int n, int m) {
        this.n = n;
        this.m = m;
        int N = m * 2 + 10;
        ele = new int[N];
        np = new int[N];
        wgh = new int[N];
        h = new int[n];
        Arrays.fill(h, -1);
    }

    void add(int a, int b, int w) {
        ele[idx] = b;
        wgh[idx] = w;
        np[idx] = h[a];
        h[a] = idx;
        ++idx;
    }
}
