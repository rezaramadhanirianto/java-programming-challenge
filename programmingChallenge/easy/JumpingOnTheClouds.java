package programmingChallenge.easy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// TestCase
// 7
// 0 0 1 0 0 1 0
// Should Return -> 4
public class JumpingOnTheClouds {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int len = scanner.nextInt();
        Character[] chars = Arrays.stream(scanner2.nextLine().split(" "))
                .filter( a -> !a.equals(" "))
                .map(a -> a.charAt(0))
                .toArray(size -> new Character[size]);
        ArrayList<Integer> list = new ArrayList<>(len);
        for(char c: chars){
            list.add(c - '0');
        }
        System.out.println(jumpingOnClouds(list));
    }


    public static int jumpingOnClouds(List<Integer> c) {
        int step = 0;
        int len = c.size();
        int output = 0;
        System.out.println(c.toString());

        // why step + 1?
        // cuz we dont need the value of array
        // but we need to count how many movement pointer from 1 array to another
        // like 1 -> 2 -> 3 => 2 movement pointer
        while(step + 1 < len){
            if(step + 2 < len && c.get(step + 2) == 0){
                step +=2;
            }else{
                step +=1;
            }
            output++;
        }
        return output;
    }

}
