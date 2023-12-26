package com.lystudy.SearchandGraphTheory;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Maze {
    public static final int N = 110;
    public static int[][] a = new int[N][N];
    public static int[][] d = new int[N][N];
    public static int[] dy = { 0, -1, 0, 1 };
    public static int[] dx = { -1, 0, 1, 0 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = in.nextInt();
            }
        }
        d[1][1] = 1;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 1));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i], y = p.y + dy[i];
                if (x >= 1 && x <= n && y >= 1 && y <= m && a[x][y] == 0 && d[x][y] == 0) {
                    d[x][y] = d[p.x][p.y] + 1;
                    q.add(new Pair(x, y));
                }
            }
        }
        System.out.print(d[n][m] - 1);
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
