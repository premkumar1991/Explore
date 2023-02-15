package leetcode;

import java.util.*;

public class Problem947 {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> rowList=new HashMap<>();
        Map<Integer,List<Integer>> colList=new HashMap<>();
        Set<Integer> rowVisited=new HashSet<>();
        Set<Integer> colVisited=new HashSet<>();
        // prepare graph
        for(int i=0;i<stones.length;++i){
            if(!rowList.containsKey(stones[i][0]))
                rowList.put(stones[i][0],new ArrayList<>());
            rowList.get(stones[i][0]).add(stones[i][1]);
            if(!colList.containsKey(stones[i][1]))
                colList.put(stones[i][1],new ArrayList<>());
            colList.get(stones[i][1]).add(stones[i][0]);
        }
        int sum=0;
        for(Map.Entry<Integer,List<Integer>> e: rowList.entrySet()){
            int v = dfs(rowList,e.getKey(),colList,rowVisited,colVisited);
            sum+=Math.max(0,v-1);
        }
        return sum;
    }
    public int dfs(Map<Integer,List<Integer>> rowList,int row,Map<Integer,List<Integer>> colList,Set<Integer> rowVisited,Set<Integer> colVisited){
        if(rowVisited.contains(row))
            return 0;
        rowVisited.add(row);
        int count=1;
        List<Integer> cols=rowList.get(row);
        for(int i=0;i<cols.size();++i){
            if(colVisited.contains(cols.get(i)))
                continue;
            count+=1;
            colVisited.add(cols.get(i));
            List<Integer> rows=colList.get(cols.get(i));
            for(int j=0;j<rows.size();++j){
                if(rowVisited.contains(rows.get(j)))
                    continue;
                count+=dfs(rowList,rows.get(j),colList,rowVisited,colVisited);
            }
        }
        return count;
    }
}
