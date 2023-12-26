package com.lystudy.SearchandGraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigraphColoring {
    static final int N = 100010;
    static int[] e = new int[2 * N];
    static int[] ne = new int[2 * N];
    static int[] h = new int[N];
    static int idx = 1;
    static int[] color = new int[N];

    public static void add(int u, int v) {
        e[idx] = v;
        ne[idx] = h[u];
        h[u] = idx++;
    }

    public static boolean dfs(int u, int c) {
        color[u] = c;
        for (int i = h[u]; i != 0; i = ne[i]) {
            int j = e[i];
            if (color[j] == 0) {
                if (!dfs(j, 3 - c))
                    return false;
            } else if (color[j] == c)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        while (m-- > 0) {
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            add(u, v);
            add(v, u);
        }
        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
