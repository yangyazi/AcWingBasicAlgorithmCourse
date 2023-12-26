package com.lystudy.BasicAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubseqDetermine {
    static int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            a[i] = Integer.parseInt(s[i - 1]);
        s = br.readLine().split(" ");
        for (int i = 1; i <= m; i++)
            b[i] = Integer.parseInt(s[i - 1]);
        int i = 1, j = 1;
        // determine if 'a' is a subsequence of 'b'
        // search for each character of 'a' in order from 'b'
        while (i <= n && j <= m) {
            if (a[i] == b[j])
                i++;
            j++;
        }
        if (i == n + 1)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
