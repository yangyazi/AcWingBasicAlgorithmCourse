package com.lystudy.BasicAlgorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MyMul {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sa = in.next();
        int la = sa.length();
        int[] a = new int[la];
        // Since b is relatively small, it can be stored using an int.
        int b = in.nextInt();
        for (int i = la - 1, j = 0; i >= 0; i--, j++)
            a[j] = sa.charAt(i) - '0';
        Deque<Integer> c = new ArrayDeque<>();
        mul(a, b, c);
        while (!c.isEmpty())
            System.out.print(c.pop());
    }

    public static void mul(int[] a, int b, Deque<Integer> c) {
        int t = 0;
        for (int i = 0; i < a.length; i++) {
            t = t + a[i] * b;
            c.push(t % 10);
            t = t / 10;
        }
        // Because t can be large, it's necessary to add t to c as well.
        while (t > 0) {
            c.push(t % 10);
            t /= 10;
        }
        // Remove leading zeros.
        while (c.size() > 1 && c.peek() == 0)
            c.pop();
    }
}
