package programmingChallenge.medium.graph;

import java.util.*;

// https://leetcode.com/problems/accounts-merge/description/
public class AccountMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new LinkedList<>();
        if(accounts == null||accounts.size() == 0) return res;

        // email as key and index as value
        Map<String, Integer> graph = new HashMap();
        UnionFind unionFind = new UnionFind(accounts.size());
        for(int i = 0; i < accounts.size(); i++){
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++){
                String email = account.get(j);
                if(graph.containsKey(email)) unionFind.union(i, graph.get(email));
                else graph.put(email, i);
            }
        }

        Map<Integer, Set<String>> keys = new HashMap();
        for(int i = 0; i < accounts.size(); i++){
            // find root by index
            int root = unionFind.find(i);
            if(!keys.containsKey(root)) keys.put(root, new HashSet());

            List<String> emails = accounts.get(i).subList(1, accounts.get(i).size());
            keys.get(root).addAll(emails);
        }

        for(int key: keys.keySet()){
            List<String> wrapper = new LinkedList();
            wrapper.addAll(keys.get(key));
            Collections.sort(wrapper);

            // add name in the first array
            wrapper.add(0, accounts.get(key).get(0));
            res.add(wrapper);
        }

        return res;
    }

    class UnionFind{
        int[] data;

        UnionFind(int n){
            data = new int[n];
            for(int i = 0; i < n; i++){
                data[i] = i;
            }
        }

        public int find(int node) {
            if(node != data[node]) data[node] = find(data[node]);
            return data[node];
        }

        void union(int p, int q){
            int parentP = find(p);
            int parentQ = find(q);
            if(parentP == parentQ) return;
            data[parentQ] = parentP;
        }
    }
}
