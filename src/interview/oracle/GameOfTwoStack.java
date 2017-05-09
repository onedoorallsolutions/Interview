package interview.oracle;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GameOfTwoStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for(int b_i=0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
            }
            gameOfTwoStack(a,b,n,m,x);
            //System.out.println("4");
            // your code goes here
        }
    }
    public static void gameOfTwoStack(int []stacka,int []stackb,int a,int b,int x) {
        int i = 0;
        int temp_sum = 0;
        while(i<a && temp_sum+stacka[i] <= x) {
            temp_sum += stacka[i];
            i++;
        }
        int ans = i;
        int j =0;
        while(j<b && i>=0) {
            temp_sum+=stackb[j];
            j++;
            while(temp_sum > x && i>0) {
                i--;
                temp_sum -= stacka[i];   
            }
            if(temp_sum <= x && ans < i+j)
                ans = i+j; 
        }
        System.out.println(ans);
    }
}
