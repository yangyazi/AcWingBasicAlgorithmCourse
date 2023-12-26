package com.lystudy.BasicAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntervalMerge {
    static final int N = 100010;
    static int[][] a = new int[N][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            a[i][0] = Integer.parseInt(s[0]);
            a[i][1] = Integer.parseInt(s[1]);
        }
        // sorted by left endpoint
        // sorted according to the first element of the two-dimensional data
        Arrays.sort(a, 0, n, (x1, x2) -> x1[0] - x2[0]);
        // Initialize 'res' to 1, and then increment by 1 for each additional interval.
        int res = 1;
        int l = a[0][0], r = a[0][1];
        for (int i = 1; i < n; i++) {
            // If the previous time's 'r' is smaller than the current 'l', it indicates that
            // merging is not possible
            if (r < a[i][0]) {
                res++;
            }
            // Update 'r' by selecting the larger of the two values
            r = Math.max(a[i][1], r);
        }
        System.out.println(res);
    }
}
