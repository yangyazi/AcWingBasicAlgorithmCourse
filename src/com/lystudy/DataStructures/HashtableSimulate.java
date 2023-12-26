package com.lystudy.DataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HashtableSimulate {
    public static int N = 100003;
    public static int[] h = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] s;
        while (n-- > 0) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[1]);
            if (s[0].equals("I")) {
                insert(x);
            } else {
                boolean flag = query(x);
                if (flag)
                    bw.write("Yes\n");
                else
                    bw.write("No\n");
            }
        }
        bw.close();
        br.close();
    }

    public static void insert(int x) {
        int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx;
        idx++;
    }

    public static boolean query(int x) {
        int k = (x % N + N) % N;
        for (int i = h[k]; i != 0; i = ne[i]) {
            if (e[i] == x)
                return true;
        }
        return false;
    }
}
