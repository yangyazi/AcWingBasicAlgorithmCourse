package com.lystudy.DynamicProgramming;

import java.util.Scanner;

public class LinearDPLongestIncreasingSubseq2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N + 10];
        int[] q = new int[N + 10];
        int len = 0;
        for (int i = 1; i <= N; i++) {
            a[i] = sc.nextInt();
            int idx = bsearch(q, len, a[i]);
            if (idx == len) {
                len++;
                q[len] = a[i];
            } else {
                if (q[idx + 1] > a[i])
                    q[idx + 1] = a[i];
            }
        }
        System.out.println(len);

    }

    public static int bsearch(int[] q, int n, int x) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (q[mid] < x) {
                if (mid == n || q[mid + 1] >= x)
                    return mid;
                else
                    low = mid + 1;
            } else
                high = mid - 1;
        }
        return 0;
    }
}
