package com.lystudy.BasicAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LongestSubstriWoRepChar {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        int[] a = new int[n + 10];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int[] q = new int[100010];
        int res = 0;

        for (int i = 0, j = 0; j < n; j++) {
            q[a[j]]++;
            while (i < j && q[a[j]] > 1) {
                q[a[i]]--;
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        out.write(String.valueOf(res));
        out.flush();
    }
}
