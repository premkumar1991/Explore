package leetcode.graph;

import java.util.*;

// Thought process thing email vs index matrix
// prepare matrix kind of graph
// row is email, column is index
// do dfs on row email, get connected emails from iterating column(ie. index list)
// sort the email, put it into the list of name,followed by email
// add it to result
// https://leetcode.com/problems/accounts-merge/discuss/3213752/Matrix-Graph-visualisation-gives-you-an-idea-for-dfs
// Time - O(NK^2 + NKLOGNK) => O(NKLOGNK) Space - O(NK)
public class Problem721 {
    Set<String> ev=new HashSet<>();
    Set<Integer> iv=new HashSet<>();
    List<List<String>> res=new ArrayList<>();
    Map<String,Set<Integer>> email=new HashMap<>();
    List<List<String>> accounts;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        this.accounts=accounts;
        for(int i=0;i<accounts.size();++i){
            if(accounts.get(i).size()<=1) //no email skip
                continue;
            for(int j=1;j<accounts.get(i).size();j++){
                //prepare graph
                email.put(accounts.get(i).get(j),email.getOrDefault(accounts.get(i).get(j),new HashSet<>()));
                email.get(accounts.get(i).get(j)).add(i);
            }
        }

        for(Map.Entry<String,Set<Integer>> e:email.entrySet()){
            if(!ev.contains(e.getKey())){
                Set<String> emails = dfs(e.getKey(),new HashSet<>());
                List<String> sortedEmails = sortEmails(emails);
                List<String> out = new ArrayList<>();
                String name = accounts.get(e.getValue().iterator().next()).get(0);
                out.add(name);
                out.addAll(sortedEmails);
                res.add(out);
            }
        }
        return res;
    }
    public Set<String> dfs(String e,Set<String> res){
        if(ev.contains(e))
            return new HashSet<>();
        ev.add(e);
        res.add(e);
        Set<Integer> idx=email.get(e);
        for(Integer i:idx){
            if(!iv.contains(i)){
                iv.add(i);
                for(int j=1;j<accounts.get(i).size();++j){
                    dfs(accounts.get(i).get(j),res);
                }
            }
        }
        return res;
    }
    public List<String> sortEmails(Set<String> emails){
        List<String> list = new ArrayList<>(emails);
        Collections.sort(list);
        return list;
    }
}
