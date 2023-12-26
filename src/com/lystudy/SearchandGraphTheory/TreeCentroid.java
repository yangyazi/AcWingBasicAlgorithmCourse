package com.lystudy.SearchandGraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeCentroid {
    public static final int N = 100010;
    public static int[] e = new int[N * 2];
    public static int[] ne = new int[N * 2];
    public static int[] h = new int[N * 2];
    public static int idx = 1;
    public static boolean[] flag = new boolean[N];
    public static int ans = N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s;
        for (int i = 1; i <= n - 1; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            add(a, b);
            add(b, a);
        }
        dfs(1, n);
        System.out.println(ans);
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx;
        idx++;
    }

    public static int dfs(int u, int n) {
        flag[u] = true;
        int size = 0, sum = 0;
        for (int i = h[u]; i != 0; i = ne[i]) {
            int j = e[i];
            if (flag[j])
                continue;
            int s = dfs(j, n);
            size = Math.max(size, s);
            sum += s;
        }
        size = Math.max(size, n - sum - 1);
        ans = Math.min(ans, size);
        return sum + 1;
    }
}
