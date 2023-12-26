package com.lystudy.DataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PointsNum {
    public static int N = 100010;
    public static int[] cnt = new int[N];
    public static int[] p = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            cnt[i] = 1;
        }
        int m = Integer.parseInt(s[1]);
        while (m-- > 0) {
            s = br.readLine().split(" ");
            if (s[0].equals("C")) {
                int a = Integer.parseInt(s[1]);
                int b = Integer.parseInt(s[2]);
                a = find(a);
                b = find(b);
                if (a != b) {
                    p[a] = b;
                    cnt[b] = cnt[a] + cnt[b];
                }
            } else if (s[0].equals("Q1")) {
                int a = Integer.parseInt(s[1]);
                int b = Integer.parseInt(s[2]);
                if (find(a) == find(b))
                    bw.write("Yes\n");
                else
                    bw.write("No\n");
            } else if (s[0].equals("Q2")) {
                int a = Integer.parseInt(s[1]);
                bw.write(cnt[find(a)] + "\n");
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }

    public static int find(int x) {
        if (p[x] != x)
            p[x] = find(p[x]);
        return p[x];
    }
}
