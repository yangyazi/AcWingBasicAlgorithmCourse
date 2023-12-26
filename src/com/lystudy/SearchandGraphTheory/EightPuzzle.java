package com.lystudy.SearchandGraphTheory;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class EightPuzzle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder state = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            state.append(in.next());
        }
        System.out.println(bfs(state));
    }

    public static int bfs(StringBuilder state) {
        String end = "12345678x";
        Queue<StringBuilder> q = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        map.put(state.toString(), 0);
        q.add(state);

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        while (!q.isEmpty()) {
            StringBuilder t = q.poll();
            if (t.toString().equals(end)) {
                return map.get(t.toString());
            }
            int dist = map.get(t.toString());
            int idx = t.indexOf("x");
            int x = idx / 3;
            int y = idx % 3;
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < 3 && b >= 0 && b < 3) {
                    swap(t, a * 3 + b, x * 3 + y);
                    if (!map.containsKey(t.toString())) {
                        map.put(t.toString(), dist + 1);
                        q.add(new StringBuilder(t));
                    }
                    swap(t, a * 3 + b, x * 3 + y);
                }
            }
        }
        return -1;
    }

    public static void swap(StringBuilder t, int m, int n) {
        char c = t.charAt(m);
        t.setCharAt(m, t.charAt(n));
        t.setCharAt(n, c);
    }
}
