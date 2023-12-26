package com.lystudy.DataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HeapSort {
    public static final int N = 100010;
    public static int[] h = new int[N];
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            h[i] = Integer.parseInt(s[i - 1]);
        cnt = n;
        for (int i = n / 2; i > 0; i--)
            down(i);
        while (m-- > 0) {
            bw.write(h[1] + " ");
            h[1] = h[cnt];
            cnt--;
            down(1);
        }
        bw.close();
        br.close();
    }

    public static void down(int u) {
        int t = u;
        if (2 * u <= cnt && h[2 * u] < h[t])
            t = 2 * u;
        if (2 * u + 1 <= cnt && h[2 * u + 1] < h[t])
            t = 2 * u + 1;
        if (u != t) {
            swap(u, t);
            down(t);
        }
    }

    public static void swap(int u, int t) {
        int temp = h[u];
        h[u] = h[t];
        h[t] = temp;
    }
}
