package programmingChallenge.easy.twopointer;

// https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    // solution without inbuilt function
    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        char[] chars = s.toCharArray();
        while(low < high){
            if(!Character.isLetterOrDigit(chars[low])){
                low++;
                continue;
            }else if (!Character.isLetterOrDigit(chars[high])){
                high--;
                continue;
            }

            chars[low] = Character.toLowerCase(chars[low]);
            chars[high] = Character.toLowerCase(chars[high]);
            if(chars[low] != chars[high]) return false;

            low++;
            high--;
        }
        return true;
    }

    // solution with inbuilt function
    public boolean isPalindrome2(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(s);
        int low = 0, high = s.length() - 1;
        while(low < high){
            if(s.charAt(low) != s.charAt(high)) return false;

            low++;
            high--;
        }
        return true;
    }
}
