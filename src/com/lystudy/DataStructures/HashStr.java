package com.lystudy.DataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HashStr {
    public static final int N = 100010;
    public static final int P = 131;
    public static long[] h = new long[N];
    public static long[] p = new long[N];
    public static long M = Long.MAX_VALUE;
    public static char[] sc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        sc = br.readLine().toCharArray();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + sc[i - 1];
            p[i] = p[i - 1] * P;
        }
        while (m-- > 0) {
            s = br.readLine().split(" ");
            int l1 = Integer.parseInt(s[0]);
            int r1 = Integer.parseInt(s[1]);
            int l2 = Integer.parseInt(s[2]);
            int r2 = Integer.parseInt(s[3]);
            if (query(l1, r1) == query(l2, r2))
                bw.write("Yes\n");
            else
                bw.write("No\n");
        }
        bw.close();
        br.close();
    }

    public static long query(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
