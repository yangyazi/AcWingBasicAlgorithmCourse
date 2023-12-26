package com.lystudy.BasicAlgorithm;// import java.util.*;

// class QuickSort {
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         int n = in.nextInt();
//         int[] nums = new int[n];
//         for (int i = 0; i < n; ++i) {
//             nums[i] = in.nextInt();
//         }
//         quickSort(nums, 0, n - 1);
//         for (int i = 0; i < n; ++i) {
//             System.out.printf("%d ", nums[i]);
//         }
//     }

//     static void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }

//     /*
//      * ˫ָ��˼�룺ʵ�� <= pivot��ֵ��һ�ߣ�>pivot��ֵ����һ��
//      * ע�⣺ָ��������ʱ�򣬻����i == j, i > j,j < i ���������
//      */
//     static void quickSort(int[] nums, int left, int right) {
//         if (left >= right)
//             return;
//         // int pivot = nums[(right-left)/2+left]; // ������ȼ�
//         int pivot = nums[left + right >> 1]; // ѡȡ�м�ڵ���Ϊ��׼
//         int i = left - 1, j = right + 1;
//         while (i < j) {
//             do
//                 i++;
//             while (nums[i] < pivot);
//             do
//                 j--;
//             while (nums[j] > pivot);
//             if (i < j)
//                 swap(nums, i, j);
//         }
//         quickSort(nums, left, j);
//         quickSort(nums, j + 1, right);
//     }
// }

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = in.nextInt();
        }
        quickSort(q, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(q[i] + " ");
        }

        in.close();
    }

    private static void swap(int[] q, int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }

    public static void quickSort(int[] q, int l, int r) {
        if (l >= r)
            return;
        int i = l - 1, j = r + 1, x = q[l + r >> 1];
        while (i < j) {
            do
                i++;
            while (q[i] < x);
            do
                j--;
            while (q[j] > x);
            if (i < j) {
                swap(q, i, j);
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }
}
