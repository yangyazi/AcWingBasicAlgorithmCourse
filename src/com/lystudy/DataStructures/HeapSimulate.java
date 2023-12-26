package com.lystudy.DataStructures;

import java.util.Scanner;

public class HeapSimulate {
    static int N = 100001;
    static int[] insertToHeap = new int[N];
    static int[] heapToinsert = new int[N];
    static int[] data = new int[N];
    static int size = 0;
    static int insertNum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; ++i) {
            String tmp = sc.nextLine();
            String[] strs = tmp.split(" ");
            if (strs[0].equals("I")) {
                ++size;
                ++insertNum;
                data[size] = Integer.parseInt(strs[1]);
                insertToHeap[insertNum] = size;
                heapToinsert[size] = insertNum;
                up(size);
            } else if (strs[0].equals("PM")) {
                System.out.println(data[1]);
            } else if (strs[0].equals("DM")) {
                heapSwap(1, size);
                --size;
                down(1);
            } else if (strs[0].equals("D")) {
                int insertId = Integer.parseInt(strs[1]);
                int heapIndex = insertToHeap[insertId];
                heapSwap(heapIndex, size);
                --size;
                up(heapIndex);
                down(heapIndex);
            } else if (strs[0].equals("C")) {
                int insertId = Integer.parseInt(strs[1]);
                int value = Integer.parseInt(strs[2]);
                int heapIndex = insertToHeap[insertId];
                data[heapIndex] = value;
                up(heapIndex);
                down(heapIndex);
            }
        }

    }

    /* 向下调整 */
    static void down(int src) {
        int target = src;
        if (src * 2 <= size && data[target] > data[src * 2])
            target = src * 2;
        if (src * 2 + 1 <= size && data[target] > data[src * 2 + 1])
            target = src * 2 + 1;
        if (src != target) {
            heapSwap(src, target);
            down(target);
        }
    }

    /* 向上调整 */
    static void up(int src) {
        while (src / 2 > 0 && data[src] < data[src / 2]) {
            heapSwap(src, src / 2);
            src = src / 2;
        }
    }

    static void heapSwap(int i, int j) {
        swap(insertToHeap, heapToinsert[i], heapToinsert[j]);
        swap(data, i, j);
        swap(heapToinsert, i, j);
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
