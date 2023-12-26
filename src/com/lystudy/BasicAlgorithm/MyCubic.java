package com.lystudy.BasicAlgorithm;

import java.io.*;

public class MyCubic {
    public static void main(String[] args) throws IOException {
        final double ACC = 1e-8;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double x = Double.parseDouble(in.readLine());
        double l = -100, r = 100;
        while (r - l > ACC) {
            double mid = (l + r) / 2;
            if (mid * mid * mid > x)
                r = mid;
            else
                l = mid;
        }
        System.out.printf("%.6f", l);
    }
}