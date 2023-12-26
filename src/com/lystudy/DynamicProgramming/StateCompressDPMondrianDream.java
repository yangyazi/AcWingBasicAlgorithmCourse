package com.lystudy.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StateCompressDPMondrianDream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (!line.equals("0 0")) {
            String[] sc = line.split(" ");
            int n = Integer.parseInt(sc[0]);
            int m = Integer.parseInt(sc[1]);
            System.out.println(fixSquare(n, m));
            line = br.readLine();
        }
        br.close();
    }

    private static long fixSquare(int n, int m) {
        long[][] dp = new long[12][1 << 12];
        boolean[] st = new boolean[1 << 12];
        for (int i = 0; i < (1 << n); ++i) {
            st[i] = true;
            int cnt = 0;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 1) {
                    if ((cnt & 1) == 1) {
                        st[i] = false;
                        break;
                    }
                    cnt = 0;
                } else
                    cnt++;
            }
            if ((cnt & 1) == 1)
                st[i] = false;
        }

        dp[0][0] = 1;
        for (int i = 1; i <= m; i++)
            for (int j = 0; j < (1 << n); ++j)
                for (int k = 0; k < (1 << n); ++k)
                    if ((j & k) == 0 && st[j | k])
                        dp[i][j] += dp[i - 1][k];
        return dp[m][0];
    }

}
