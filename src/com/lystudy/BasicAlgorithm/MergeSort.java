package com.lystudy.BasicAlgorithm;

import java.util.*;
import java.io.*;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] q = new int[n];
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            q[i] = in.nextInt();
        }
        mergeSort(q, 0, n - 1, temp);
        for (int num : q) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] q, int l, int r, int[] temp) {
        if (l >= r)
            return;
        int mid = l + r >> 1;
        mergeSort(q, l, mid, temp);
        mergeSort(q, mid + 1, r, temp);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j])
                temp[k++] = q[i++];
            else
                temp[k++] = q[j++];
        }
        while (i <= mid)
            temp[k++] = q[i++];
        while (j <= r)
            temp[k++] = q[j++];
        for (i = l, j = 0; i <= r; i++, j++)
            q[i] = temp[j];
    }
}