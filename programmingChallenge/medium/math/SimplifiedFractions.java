package programmingChallenge.medium.math;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/simplified-fractions/
public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList();
        for(int i = 1; i <= n; i++){
            for(int j = i+1; j <= n; j++){
                if(gcd(i, j) == 1){
                    res.add(i + "/" + j);
                }
            }
        }
        return res;
    }

    int gcd(int i, int j){
        return i == 0 ? j : gcd(j%i, i);
    }
}
