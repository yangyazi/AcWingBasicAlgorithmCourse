package com.lystudy.SearchandGraphTheory;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class DijkstraShortestPath2 {
    static int inf = 0x3f3f3f3f;

    static int dijkstra(Graph g, int src, int dest) {
        int n = g.n;
        boolean[] vis = new boolean[n];
        int[] dis = new int[n];
        Arrays.fill(dis, inf);
        dis[src] = 0;
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });
        q.add(new int[] { 0, src });

        while (!q.isEmpty()) {
            int t = q.poll()[1];
            if (vis[t])
                continue;
            vis[t] = true;

            for (int next = g.h[t]; next != -1; next = g.np[next]) {
                int id = g.ele[next], w = g.wgh[next];
                if (dis[id] > dis[t] + w) {
                    dis[id] = dis[t] + w;
                    q.offer(new int[] { dis[id], id });
                }

            }
        }

        return dis[dest];
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
        int dis = dijkstra(g, 0, n - 1);
        if (dis == inf)
            dis = -1;
        System.out.println(dis);

    }
}

class Graph1 {
    int[] ele;
    int[] np;
    int[] wgh;
    int[] h;
    int n, m;
    int idx = 0;

    Graph1(int n, int m) {
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
