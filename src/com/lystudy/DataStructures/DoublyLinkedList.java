package com.lystudy.DataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DoublyLinkedList {
    static final int N = 100010;
    static int[] e = new int[N];
    static int[] l = new int[N];
    static int[] r = new int[N];
    static int idx = 1;
    static int R = 100005;
    static int L = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        // connect the two sentinel nodes
        l[R] = L;
        r[L] = R;
        while (m > 0) {
            m--;
            s = br.readLine().split(" ");
            if (s[0].equals("L")) {
                int x = Integer.parseInt(s[1]);
                // the far left end of the linked list is equivalent to the far right end at 0
                add(0, x);
            } else if (s[0].equals("R")) {
                int x = Integer.parseInt(s[1]);
                // the far right end of the linked list is equivalent to the far right end at l[R].
                add(l[R], x);
            } else if (s[0].equals("D")) {
                int k = Integer.parseInt(s[1]);
                delete(k);
            } else if (s[0].equals("IL")) {
                int k = Integer.parseInt(s[1]);
                int x = Integer.parseInt(s[2]);
                // the left side of k is equivalent of the right side of l[k]
                add(l[k], x);
            } else if (s[0].equals("IR")) {
                int k = Integer.parseInt(s[1]);
                int x = Integer.parseInt(s[2]);
                
                add(k, x);
            }
        }
        // System.out.println(e[1]);
        for (int i = r[L]; i != R; i = r[i])
            bw.write(e[i] + " ");
        bw.close();
    }

    public static void add(int k, int x) {
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = l[r[k]];
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }

    public static void delete(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }
}
