package com.lystudy.BasicAlgorithm;

import java.util.*;
import java.io.*;

class MergeSortPra {
    static int N = 100010;
    static long res = 0;
    static int[] q = new int[N];
    static int[] temp = new int[N];

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            q[i] = in.nextInt();
        }

        mergeSort(0, n - 1);
        System.out.println(res);
    }

    public static void mergeSort(int l, int r) {
        if (l >= r)
            return;
        int mid = l + r >> 1;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j])
                temp[k++] = q[i++];
            else {
                res += mid - i + 1;
                temp[k++] = q[j++];
            }
        }
        while (i <= mid)
            temp[k++] = q[i++];
        while (j <= r)
            temp[k++] = q[j++];
        for (i = l, j = 0; i <= r; i++, j++)
            q[i] = temp[j];
    }
}