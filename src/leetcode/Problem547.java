package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem547 {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinces=0;
        for(int i=0;i<isConnected.length;++i){
            if(!visited[i]){
                bfs(i,isConnected,visited);
                provinces++;
            }
        }
        return provinces;
    }
    public void bfs(int v,int[][] graph,boolean[] visited){
        Deque<Integer> q=new ArrayDeque<>();
        q.addLast(v);
        visited[v]=true;
        while(!q.isEmpty()){
            int idx=q.removeFirst();
            for(int i=0;i<graph[idx].length;++i){
                if(idx==i||visited[idx]||graph[idx][i]==0)
                    continue;
                q.addLast(i);
                visited[i]=true;
            }
        }
    }
}
