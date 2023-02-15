import leetcode.Problem227;
import leetcode.Problem547;
import leetcode.Problem56;
import leetcode.Problem947;

import java.io.IOException;

import java.util.HashSet;
import java.util.Stack;

public class Main {

    public static void main(String[] args)  {
        Problem947 p = new Problem947();
        p.removeStones(new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}});
        
    }

    public static void print(int[][] ans){
        System.out.println();
        for (int[] a:ans){
            System.out.print(a[0]+","+a[1]+" ");
        }
    }



    public static void printPossibleStrings(String[] str){
        if(str.length==0)
            return;
        int k = str[0].length();
        int n = str.length;
        StringBuilder sb = new StringBuilder();

        // key - input string idx
        // value is - which character idx in input string idx
        HashSet<Integer> map = new HashSet<>();
        helper(str,"", str.length, map);
    }

    // char index 0 -> from 0 to n-1 of str - char position
    // char index 1 -> from 0 to n-1 of str - char position

    public static void helper(String[] str, String sb, int n, HashSet<Integer> map){
        if(sb.length()==n){
            System.out.println(sb);
            return;
        }
        for(int i=0;i<str.length;++i){
            for(int j=0;j<str[i].length();++j){
                //String memo = ""+i+j;
                if(map.contains(i))
                    continue;
                sb += str[i].charAt(j);
                map.add(i);
                helper(str,sb,n,map);
                sb = sb.substring(0,sb.length()-1);
                map.remove(i);
            }
        }
    }


}

