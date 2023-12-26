package com.lystudy.practice;

import java.util.Scanner;

/**
 * @author luyoung
 * @since 2023-12-22 10:25
 * description
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int n = in.nextInt();
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = in.nextInt();
        }

        quickSort(q, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.println(q[i] + " ");
        }
        in.close();
    }

    public static void quickSort(int[] q, int l, int r){
        if(l >= r)
            return;
        int i = l -1, j = r + 1, x = q[l + r >> 1];
        while (i < j){
            do {
                i++;
            }while (q[i] < x);
            do {
                j--;
            }while (q[j] > x);
            if(i < j){
                swap(q, i, j);
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }

    private static void swap(int[]q, int i, int j){
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }
}
