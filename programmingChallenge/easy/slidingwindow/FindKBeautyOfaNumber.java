package programmingChallenge.easy.slidingwindow;

// https://leetcode.com/problems/find-the-k-beauty-of-a-number/description/
public class FindKBeautyOfaNumber {
    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int n = str.length(), res = 0;
        for(int i = 0; i <= n - k; i++){
            String subs = str.substring(i, i+k);
            int sub = Integer.valueOf(subs);
            if(sub > 0 && num % sub == 0) res++;
        }
        return res;
    }
}
