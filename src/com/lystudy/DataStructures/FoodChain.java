package com.lystudy.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FoodChain {
    static final int N = 50010;
    static int[] p = new int[N];
    static int[] dist = new int[N];

    public static int find(int x) {
        if (p[x] != x) {
            int t = p[x];
            p[x] = find(p[x]);
            dist[x] = dist[t] + dist[x];
        }
        return p[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        for (int i = 1; i <= n; i++)
            p[i] = i;
        int res = 0;
        while (k-- > 0) {
            s = br.readLine().split(" ");
            int d = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);
            int y = Integer.parseInt(s[2]);
            if (x > n || y > n)
                res++;
            else {
                int px = find(x), py = find(y);
                if (d == 1) {
                    if (px == py && (dist[x] - dist[y]) % 3 != 0)
                        res++;
                    else if (px != py) {
                        p[px] = py;
                        dist[px] = dist[y] - dist[x];
                    }
                } else if (d == 2) {
                    if (x == y)
                        res++;
                    else if (px == py && (dist[x] - dist[y] - 1) % 3 != 0)
                        res++;
                    else if (px != py) {
                        p[px] = p[y];
                        dist[px] = dist[y] + 1 - dist[x];
                    }
                }
            }
        }
        System.out.println(res);
    }

}
