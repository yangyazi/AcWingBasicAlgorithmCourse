package com.lystudy.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SinglyLinkedList {
    public static int N = 100010;
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int head = 0;
    public static int idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(in.readLine());
        while (m > 0) {
            m--;
            String[] s = in.readLine().split(" ");
            if (s[0].equals("H")) {
                int x = Integer.parseInt(s[1]);
                addHead(x);
            } else if (s[0].equals("D")) {
                int k = Integer.parseInt(s[1]);
                remove(k);
            } else {
                int k = Integer.parseInt(s[1]);
                int x = Integer.parseInt(s[2]);
                add(k, x);
            }
        }
        for (int i = head; i != 0; i = ne[i])
            System.out.print(e[i] + " ");

    }

    public static void addHead(int x) {
        // recode index
        // idx points to the node pointed to by the head node
        // the head node points to the idx
        // idx plus 1
        e[idx] = x;
        ne[idx] = head;
        head = idx;
        idx++;
    }

    public static void remove(int k) {
        // if k == 0 then delete head node
        if (k == 0)
            head = ne[head];
        // the k-th node points to the node after the 'next' node
        else
            ne[k] = ne[ne[k]];
    }

    public static void add(int k, int x) {
        // recode index
        // idx points to the node pointed to by the k-th node
        // the k-th node points to the idx
        // idx plus 1
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }
}
