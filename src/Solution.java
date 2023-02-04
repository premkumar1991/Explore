import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    int minBus=0;
    Map<String,Boolean> vis=new HashMap<>();
    Map<Integer, List<Integer>> stopToBus=new HashMap<>();
    public int numBusesToDestination(int[][] routes, int source, int target) {
        minBus=routes.length+1;
        if(source==target)
            return 1;
        for(int i=0;i<routes.length;++i){
            for(int j=0;j<routes[i].length;++j){
                if(!stopToBus.containsKey(routes[i][j])){
                    stopToBus.put(routes[i][j],new ArrayList<>());
                }
                stopToBus.get(routes[i][j]).add(i);
            }
        }
        if(!stopToBus.containsKey(source) || !stopToBus.containsKey(target))
            return -1;
        dfs(source,stopToBus.get(source).get(0),source,source,target,1,routes);
        return minBus==routes.length+1?-1:minBus;

    }
    public void dfs(int currStop,int bus,int prevStop,int source,int target,int busesTaken,int[][] routes){
        if(currStop==target){
            minBus=Math.min(minBus,busesTaken);
            return;
        }
        String key = "" + currStop + bus + prevStop ;
        if(vis.containsKey(key))
            return;
        vis.put(key,true);
        List<Integer> currStopBuses = stopToBus.get(currStop);
        for(int buses:currStopBuses){
            for(int stop:routes[buses]){
                if((stop==currStop||stop==prevStop)&&buses==bus)
                    continue;
                int nextCost=bus!=buses?busesTaken+1:busesTaken;
                dfs(stop,buses,currStop,source,target,nextCost,routes);
            }
        }
    }
}