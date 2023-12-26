package com.lystudy.BasicAlgorithm;
/**
Given a length-n integer array sorted in ascending order, and q queries.
For each query, return the starting and ending positions of an element k (counting positions from 0).
If the element does not exist in the array, return -1 -1.
 */

import java.io.*;

public class bresearch {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]);
        s = in.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        for (int i = 0; i < q; i++) {
            int k = Integer.parseInt(in.readLine());
            // low begin，high end
            int low = 0, high = 0;
            // Find the first element equal to the given value
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = l + r >> 1;
                if (a[mid] > k)
                    r = mid - 1;
                else if (a[mid] < k)
                    l = mid + 1;
                else {
                    if (mid == 0 || a[mid - 1] != k) {
                        low = mid;
                        break;
                    } else
                        r = mid - 1;
                }
            }
            if (a[low] != k) {
                System.out.println("-1 -1");
            } else {
                // Find the last element equal to the given value
                l = 0;
                r = n - 1;
                while (l <= r) {
                    int mid = l + r >> 1;
                    if (a[mid] > k)
                        r = mid - 1;
                    else if (a[mid] < k)
                        l = mid + 1;
                    else {
                        if (mid == n - 1 || a[mid + 1] != k) {
                            high = mid;
                            break;
                        } else {
                            l = mid + 1;
                        }
                    }
                }
                System.out.println(low + " " + high);
            }
        }
    }
}