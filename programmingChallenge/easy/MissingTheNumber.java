package programmingChallenge.easy;

public class MissingTheNumber {

    public static void main(String[] args){
        solution(new int[]{1,2,3,4,5,6,8,9});
    }

    public static void solution(int[] arr){
        int n = arr.length;
        int total = n + 1;
        for(int i = 1; i <= n; i++){
            total += i;
            total -= arr[i-1];
        }

        System.out.println(total);
    }
}
