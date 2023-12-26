package com.lystudy.BasicAlgorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class MySub {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String a = in.nextLine();
        String b = in.nextLine();

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--)
            x.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; i--)
            y.add(b.charAt(i) - '0');

        Deque<Integer> c = new ArrayDeque<>();
        if (cmp(x, y))
            c = sub(x, y);
        else {
            System.out.print("-");
            c = sub(y, x);
        }
        while (!c.isEmpty()) {
            System.out.print(c.pop());
        }
    }

    public static boolean cmp(List<Integer> x, List<Integer> y) {
        if (x.size() != y.size())
            return x.size() > y.size();
        for (int i = x.size() - 1; i >= 0; i--) {
            if (x.get(i) != y.get(i))
                return x.get(i) > y.get(i);
        }
        return true;
    }

    public static Deque<Integer> sub(List<Integer> x, List<Integer> y) {
        Deque<Integer> c = new ArrayDeque<>();
        // t records borrowing.
        int t = 0;
        for (int i = 0; i < x.size(); i++) {
            t = x.get(i) - t;
            if (i < y.size())
                t = t - y.get(i);
            c.push((t + 10) % 10);
            // If t is negative
            t = t < 0 ? 1 : 0;
        }
        // Remove leading zeros.
        while (c.size() > 1 && c.peek() == 0)
            c.pop();
        return c;
    }
}
