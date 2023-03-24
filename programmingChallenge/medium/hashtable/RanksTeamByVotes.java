package programmingChallenge.medium.hashtable;

import java.util.*;

// https://leetcode.com/problems/rank-teams-by-votes/
public class RanksTeamByVotes {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap();
        int n = votes[0].length();
        for(String vote: votes){
            for(int i = 0; i < n; i++){
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[n]);
                map.get(c)[i]++;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            for(int i = 0; i < n; i++){
                if(map.get(a)[i] != map.get(b)[i]) return map.get(b)[i] - map.get(a)[i];
            }
            return a-b;
        });

        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.append(c);
        }
        return sb.toString();
    }
}
