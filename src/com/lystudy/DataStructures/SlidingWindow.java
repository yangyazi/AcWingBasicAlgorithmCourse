package com.lystudy.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SlidingWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        // The array 'a' holds the original data
        int[] a = new int[n + 10];
        // The array 'q' stores the indices of strictly monotonically increasing queue
        // elements after each sliding window processing

        int[] q = new int[n + 10];
        s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        // Find the minimum value of the sliding window.
        // hh represents the front of the queue, and tt represents the rear of the
        // queue. Insert at the rear, pop from the front
        // hh and tt are initialized as 0 and -1 respectively, ensuring that when the
        // sliding window is empty, tt < hh.
        int hh = 0, tt = -1;
        for (int i = 0; i < n; i++) {

            if (hh <= tt && i - q[hh] > k - 1)
                hh++;

            while (hh <= tt && a[q[tt]] >= a[i])
                tt--;

            tt++;
            q[tt] = i;

            if (i >= k - 1)
                System.out.print(a[q[hh]] + " ");
        }
        System.out.println();
        // Find the maximum value of the sliding window
        hh = 0;
        tt = -1;
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i - q[hh] > k - 1)
                hh++;
            while (hh <= tt && a[q[tt]] <= a[i])
                tt--;
            tt++;
            q[tt] = i;
            if (i >= k - 1)
                System.out.print(a[q[hh]] + " ");
        }
        System.out.println();
    }
}
