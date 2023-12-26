package com.lystudy.BasicAlgorithm;
// ���еĵ�kС��

import java.util.*;

class QuickSortPra {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = in.nextInt();
        }
        // ʹ���±�Աȵ�ʱ��Ҫ��ȥ1(k-1)
        System.out.println(quickSort(nums, 0, n - 1, k - 1));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* ˫ָ��˼�룺ȷ��<=pivot��Ԫ������ߣ�>= pivot��Ԫ�����ұ� */
    static int quickSort(int[] arr, int left, int right, int k) {
        if (left >= right && right == k)
            return arr[k];
        int pivot = arr[left + right >> 1]; // ���м��׼�����ң�
        int i = left - 1, j = right + 1;
        while (i < j) {
            do
                i++;
            while (arr[i] < pivot);
            do
                j--;
            while (arr[j] > pivot);
            if (i < j)
                swap(arr, i, j);
        }

        return k <= j ? quickSort(arr, left, j, k) : quickSort(arr, j + 1, right, k);
    }
}
