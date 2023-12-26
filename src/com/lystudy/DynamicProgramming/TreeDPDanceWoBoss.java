package com.lystudy.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TreeDPDanceWoBoss {
    static int N = 6010;
    static int[] happy = new int[N];
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int[][] f = new int[N][2];
    static int n;
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            happy[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int l = sc.nextInt();
            int k = sc.nextInt();
            st[l] = true;
            add(k, l);
        }
        for (int i = 1; i <= n; i++) {
            f[i][1] = happy[i];
        }
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                root = i;
                break;
            }
        }
        dfs(root);
        System.out.println(Math.max(f[root][0], f[root][1]));
    }

    static void dfs(int x) {
        List<Integer> list = map.get(x);
        if (list == null)
            return;
        for (int b : list) {
            dfs(b);
            f[x][1] += f[b][0];
            f[x][0] += Math.max(f[b][1], f[b][0]);
        }
    }

    static void add(int a, int b) {
        if (!map.containsKey(a))
            map.put(a, new ArrayList<>());
        map.get(a).add(b);
    }
}
