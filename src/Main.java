import leetcode.Problem76;

public class Main {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        Problem76 p=new Problem76();
        System.out.println(p.minWindow(s,t));
        System.out.println(p.minWindow("a","a"));
        System.out.println(p.minWindow("a","aa"));
    }


}