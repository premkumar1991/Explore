package leetcode.graph;

public class Client {
    public static void main(String[] a){
        Problem1584 p = new Problem1584();
        int[][] arr = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(p.minCostConnectPoints(arr));
    }
}