package leetcode.graph;

import java.util.*;

public class Problem1584 {
    public int minCostConnectPoints(int[][] points){
//        if(points.length<=1)
//            return 0;
//
//        int[][] dist=new int[points.length][points.length];
//        int min=Integer.MAX_VALUE;
//        int u=0,v=0;
//        for(int i=0;i<points.length;++i){
//            for (int j=0;j<points.length;++j){
//                dist[i][j]=calcDist(points,i,j);
//                if(i!=j&&dist[i][j]<min){
//                    min=dist[i][j];
//                    u=i;
//                    v=j;
//                }
//            }
//        }
//        List<Integer> node = new ArrayList<>();
//        boolean[] visited=new boolean[points.length];
//        visited[u]=true;
//        visited[v]=true;
//        int sum=min;
//        min=Integer.MAX_VALUE;
//        node.add(u);
//        node.add(v);
//        while(node.size()<points.length){
//            for(int i=0;i<node.size();++i){
//                for (int j=0;j<points.length;++j){
//                    int d=dist[node.get(i)][j];
//                    if(!visited[j]&&d<min){
//                        min=d;
//                        v=j;
//                    }
//                }
//            }
//            sum+=min;
//            node.add(v);
//            visited[v]=true;
//            min=Integer.MAX_VALUE;
//        }
        int i=0,e=0,min,n=0;
        int[] min_d=new int[points.length];
        int sum=0;
        while(++e<points.length){
            min=Integer.MAX_VALUE;
            min_d[i]=Integer.MAX_VALUE;
            for(int j=0;j<points.length;++j){
                if(min_d[j]!=Integer.MAX_VALUE){
                    min_d[j]=calcDist(points,i,j);
                    if(min_d[j]<min){
                        min=min_d[j];
                        n=j;
                    }
                }
            }
            sum+=min;
            i=n;
        }
        return sum;
    }

//    public int minCostConnectPoints(int[][] points) {
//        int[][] dist=new int[points.length][points.length];
//        int[] par=new int[points.length];
//        int[] rank=new int[points.length];
//        boolean[][] connected=new boolean[points.length][points.length];
//        List<Integer[]> edges = new ArrayList<>();
//        for(int i=0;i<points.length;++i){
//            for(int j=0;j<points.length;++j){
//                dist[i][j]=calcDist(points,i,j);
//            }
//        }
//        // floyd warshall algorithm
//        for(int k=0;k<points.length;k++){
//            for(int i=0;i<points.length;i++){
//                for(int j=0;j<points.length;j++){
////                    if(i==j||i==k||j==k)
////                        continue;
//                    int d=dist[i][k]+dist[k][j];
//                    if(dist[i][j]>d){
//                        dist[i][j]=d;
//                    }
//                }
//            }
//        }
//        for (int i=0;i<points.length;++i){
//            for(int j=0;j<points.length;++j){
//                if(i!=j){
//                    edges.add(new Integer[]{i,j,dist[i][j]});
//                }
//            }
//        }
//        Collections.sort(edges,(a,b)->a[2]-b[2]);
//        // init uf parent and rank of nodes to detect cycle point
//        for(int i=0;i<points.length;++i){
//            par[i]=i;
//            rank[i]=0;
//        }
//        int e=0,sum=0;
//        while (e<edges.size()){
//            int u = edges.get(0)[0];
//            int v = edges.get(0)[1];
//            int w = edges.get(0)[2];
//            if(!connected[u][v]&&!connected[v][u]&&par[u]!=par[v]){
//                union(u,v,par,rank);
//                connected[u][v]=true;
//                connected[v][u]=true;
//                sum+=w;
//            }
//            e++;
//        }
//        return sum;
//    }
        private int calcDist(int[][] arr,int i, int j){
            return Math.abs(arr[i][0]-arr[j][0])+Math.abs(arr[i][1]-arr[j][1]);
        }
    private void union(int u,int v,int[] par,int rank[]){
        int x=find(u,par);
        int y=find(v,par);
        if(x==y)
            return; //cycle detected
        if(rank[x]<rank[y]){
            par[x]=par[y];
        }else{
            if(rank[x]==rank[y])
                rank[x]+=1;
            par[y]=par[x];
        }
    }
    private int find(int u,int[] par){
        if(par[u]==u)
            return u;
        while(u!=par[u]){
            par[u]=par[par[u]];
            u=par[u];
        }
        return u;
    }
}
