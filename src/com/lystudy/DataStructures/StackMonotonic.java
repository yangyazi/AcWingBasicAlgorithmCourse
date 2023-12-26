package com.lystudy.DataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StackMonotonic {
    static final int N = 100010;
    static int[] a = new int[N];
    static int[] stk = new int[N];
    static int hh = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        // output the first number smaller than it on its left side
        // monotonically increasing stack
        for (int i = 0; i < n; i++) {
            while (hh > 0 && a[stk[hh]] >= a[i])
                hh--;
            if (hh == 0)
                bw.write("-1 ");
            else
                bw.write(a[stk[hh]] + " ");
            hh++;
            stk[hh] = i;
        }
        bw.close();
        br.close();
    }
}
