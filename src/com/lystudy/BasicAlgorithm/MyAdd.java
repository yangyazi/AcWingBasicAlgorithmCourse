package com.lystudy.BasicAlgorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class MyAdd {
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
        c = add(x, y);
        while (!c.isEmpty()) {
            System.out.print(c.pop());
        }
    }

    public static Deque<Integer> add(List<Integer> x, List<Integer> y) {
        if (x.size() < y.size())
            return add(y, x);
        Deque<Integer> c = new ArrayDeque<>();
        // t recoder carry
        int t = 0;
        for (int i = 0; i < x.size(); i++) {
            t += x.get(i);
            if (i < y.size())
                t += y.get(i);
            c.push(t % 10);
            t = t / 10;
        }
        // Do not overlook the final carry
        if (t > 0) {
            c.push(t);
        }
        return c;
    }

}