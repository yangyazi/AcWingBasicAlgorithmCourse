package com.lystudy.DataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class KMPStr {
    public static void main(String[] args) throws IOException{
        int N = 100010;
        int M = 1000010;
        int[] ne = new int[N];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n = Integer.parseInt(br.readLine());
        String sp = " " + br.readLine();
        Integer m = Integer.parseInt(br.readLine());
        String ss = " " + br.readLine();
        char[] p = sp.toCharArray();
        char[] s = ss.toCharArray();
        
        for(int i = 2, j = 0; i <= n; i++) {
            while(j != 0 && p[i] != p[j + 1]) j = ne[j];
            if(p[i] == p[j + 1]) j++;
            ne[i] = j;
        }
        for(int i = 1, j = 0; i <= m; i++) {
            while(j != 0 && s[i] != p[j + 1]) j = ne[j];
            if(s[i] == p[j + 1]) j++;
            if(j == n) {
                bw.write(i - n + " ");
                j = ne[j];
            }
        }
        bw.close();
        br.close();
    }
}
