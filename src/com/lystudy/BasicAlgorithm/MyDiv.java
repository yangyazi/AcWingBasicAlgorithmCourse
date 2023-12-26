package com.lystudy.BasicAlgorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MyDiv {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sa = in.next();
        int la = sa.length();
        int[] a = new int[la];
        for (int i = 0, j = 0; i < la; i++, j++)
            a[i] = sa.charAt(j) - '0';
        int b = in.nextInt();
        Deque<Integer> c = new ArrayDeque<>();
        // Use c to store the quotient and return the remainder.
        int t = div(a, b, c);
        while (!c.isEmpty())
            System.out.print(c.pollFirst());
        System.out.print("\n" + t);
    }

    public static int div(int[] a, int b, Deque<Integer> c) {
        int t = 0;
        for (int i = 0; i < a.length; i++) {
            t = t * 10 + a[i];
            c.addLast(t / b);
            t = t % b;
        }
        while (c.size() > 1 && c.peekFirst() == 0)
            c.pollFirst();
        return t;
    }
}
