package com.lystudy.BasicAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Num1Bits {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(s[i]);
            int res = 0;
            while (x > 0) {
                // lowbit 操作
                x = x - (x & -x);
                // t &= (t - 1);
                res++;
            }
            out.write(res + " ");
            out.flush();
            // System.out.print(res + " ");
        }

    }
}
