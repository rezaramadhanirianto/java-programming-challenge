package programmingChallenge.medium.greedy;

//https://leetcode.com/problems/gas-station/description/
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        for(int i = 0; i < n; i++){
            total += gas[i] - cost[i];
        }
        if(total < 0 ) return -1;

        int tank = 0;
        int start = 0;
        for(int i = 0; i < n; i++){
            tank += gas[i] - cost[i];
            if(tank < 0){
                tank = 0;
                start = i +1;
            }
        }
        return start;
    }
}
