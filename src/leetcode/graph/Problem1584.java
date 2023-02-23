package leetcode.graph;

import java.util.*;

public class Problem1584 {
    public int minCostConnectPoints(int[][] points) {
        int[] dist=new int[points.length];
        int[] parent=new int[points.length];
        PriorityQueue<Integer> pq=new PriorityQueue<>((v1, v2) -> dist[v1] - dist[v2]);
        //graph prep
        Map<Integer, List<Integer>> adjList=new HashMap<>();
        for(int i=0;i<points.length;++i){
            for(int j=0;j<points.length;++j){
                adjList.put(i,adjList.getOrDefault(i,new ArrayList<>()));
                adjList.put(j,adjList.getOrDefault(j,new ArrayList<>()));
                adjList.get(i).add(j);
                adjList.get(j).add(i);
            }
        }
        boolean[] visited=new boolean[points.length];
        int i=0;
        int minPath=Integer.MAX_VALUE;
        while(i<points.length){
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[i]=0;
            for(int w=0;w<points.length;w++){
                pq.add(w);
                visited[w]=false;
                parent[w]=0;
            }
            while (!pq.isEmpty()){
                int u=pq.poll();
                visited[u]=true;
                for(int v=0;v<adjList.get(u).size();++v) {
                    if (!visited[v]) {
                        int d1 = dist[u] + Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                        if (dist[v] > d1) {
                            dist[v] = d1;
                            parent[v] = u;
                        }
                    }
                }
            }
            //calc minpath sum
            int sum=0;
            int x=0;
            while(x<dist.length){
                sum+=dist[x]-dist[parent[x]];
            }
            minPath=Math.min(sum,minPath);
            ++i;
        }
        return minPath;
    }
}
