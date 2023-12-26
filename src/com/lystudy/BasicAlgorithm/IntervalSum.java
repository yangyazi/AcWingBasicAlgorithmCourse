package com.lystudy.BasicAlgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class IntervalSum {
    static final int N = 100010;
    static int[] a = new int[3 * N];
    static int[] q = new int[3 * N];
    static int[][] adds = new int[N][2];
    static int[][] querys = new int[N][2];
    static int[] alls = new int[3 * N];

    public static int unique(int[] alls, int n) {
        // two pointers
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || alls[i] != alls[i - 1]) {
                alls[j] = alls[i];
                j++;
            }
        }
        return j;
    }

    public static int bsearch(int[] alls, int n, int x) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + high >> 1;
            if (alls[mid] > x)
                high = mid - 1;
            else if (alls[mid] < x)
                low = mid + 1;
            else
                return mid + 1;
        }
        return low;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        // index
        int idx = 0, idx1 = 0;
        // storage insertion
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            alls[idx++] = x;
            adds[i][0] = x;
            adds[i][1] = c;
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int l = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            alls[idx++] = l;
            alls[idx++] = r;
            querys[i][0] = l;
            querys[i][1] = r;
        }
        // alls(0, idx - 1) sort
        Arrays.sort(alls, 0, idx);
        // deduplication
        int end = unique(alls, idx);
        // add
        for (int i = 0; i < n; i++) {
            // binary search to find the index 
            int t = bsearch(alls, end, adds[i][0]);
            a[t] += adds[i][1];
        }
        // calculate the prefix sum
        for (int i = 1; i <= end; i++) {
            q[i] = q[i - 1] + a[i];
        }
        for (int i = 0; i < m; i++) {
            int l = bsearch(alls, end, querys[i][0]);
            int r = bsearch(alls, end, querys[i][1]);
            bw.write(q[r] - q[l - 1] + "\n");
        }
        bw.close();
        br.close();

    }

}