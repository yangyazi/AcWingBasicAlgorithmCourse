package com.lystudy.DynamicProgramming;

import java.util.Scanner;

public class CountDPIntegerPartition {
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n+1][n+1];
        long mod = (long)(1e9+7);
        dp[0][0] = 1;                       
        for(int i = 1;i <= n;++i){         
            for(int v = i;v <= n;++v){      
                dp[i][v] = (dp[i-1][v-1]+dp[i][v-i])%mod; 
            }
        }
        
        long res = 0;
        for(int i = 0; i <= n;++i){         
            res += dp[i][n]; res = res%mod;
        }
        System.out.println(res);
    }
}
