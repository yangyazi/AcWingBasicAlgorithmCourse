package com.lystudy.DataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TrieStrCount {
    public static int N = 100010;
    public static int idx = 0;
    public static int[] cnt = new int[N];
    public static int[][] trie = new int[N][26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] s;
        while (n-- > 0) {
            s = br.readLine().split(" ");
            if (s[0].equals("I")) {
                insert(s[1]);
            } else {
                int res = query(s[1]);
                bw.write(res + "\n");
            }
        }
        bw.close();
        br.close();
    }

    public static void insert(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int t = s.charAt(i) - 'a';
            if (trie[p][t] == 0) {
                idx++;
                trie[p][t] = idx;
            }
            p = trie[p][t];
        }
        cnt[p]++;
    }

    public static int query(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int t = s.charAt(i) - 'a';
            if (trie[p][t] == 0)
                return 0;
            p = trie[p][t];
        }
        return cnt[p];
    }
}
