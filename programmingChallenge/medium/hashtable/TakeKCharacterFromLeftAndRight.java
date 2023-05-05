package programmingChallenge.medium.hashtable;

// https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/description/
public class TakeKCharacterFromLeftAndRight {
    public int takeCharacters(String s, int k) {
        int[] arr=new int[3];
        for(char ch:s.toCharArray()) arr[ch-'a']++;

        if(arr[0] < k || arr[1] < k || arr[2] < k) return -1;
        int res = arr[0] + arr[1] + arr[2];
        int start = 0;
        int window = 0;
        for(char ch: s.toCharArray()){
            arr[ch-'a']--;
            window++;

            while(arr[0] < k || arr[1] < k || arr[2] < k){
                arr[s.charAt(start++)-'a']++;
                window--;
            }

            res = Math.min(res, s.length() - window);
        }
        return res;
    }
}
