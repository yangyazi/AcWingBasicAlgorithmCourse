package com.lystudy.BasicAlgorithm;

import java.util.*;

class mystr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        Set<String> resultSet = new HashSet<>(); // 用于记录已生成的排列
        dfs(0, chars.length, new char[chars.length], new boolean[chars.length], chars, resultSet);
        for (String s : resultSet) {
            System.out.println(s);
        }
    }

    static void dfs(int n, int num, char[] res, boolean[] flag, char[] chars, Set<String> resultSet) {
        if (n == num) {
            resultSet.add(new String(res));
            return;
        }
        for (int i = 0; i < num; ++i) {
            if (flag[i]) continue;
            res[n] = chars[i];
            flag[i] = true;
            dfs(n + 1, num, res, flag, chars, resultSet);
            flag[i] = false;
        }
    }
}
