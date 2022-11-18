package programmingChallenge.easy.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList();
        for(int i = 0; i < numRows; i++){
            ArrayList<Integer> row = new ArrayList();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    row.add(output.get(i-1).get(j-1) + output.get(i-1).get(j));
                }
            }
            output.add(row);
        }
        return output;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> output = new ArrayList();
        ArrayList<Integer> row = new ArrayList();

        for(int i = 0; i < numRows; i++){
            row.add(0, 1);
            for(int j = 1; j < row.size()-1; j++){
                row.set(j, row.get(j) + row.get(j+1));
            }
            output.add(new ArrayList(row));
        }
        return output;
    }
}
