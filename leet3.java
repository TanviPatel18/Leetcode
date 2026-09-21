import java.util.HashSet;
public class leet3 {
    public static int lengthOfLongestSubstring(String s) {

        // Store last seen index of every character
        int[] last = new int[128];

        int left = 0;
        int max = 0;


        // Right pointer moves through string
        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);


            // Move left pointer after duplicate character
            // Math.max prevents left from moving backward
            left = Math.max(left, last[ch]);


            // Current window length
            max = Math.max(max, i - left + 1);


            // Store current character position
            // i+1 because 0 means character not visited
            last[ch] = i + 1;
        }


        return max;
    }


    public static void main(String[] args) {

        String s = "abcabcbb";

        int result = lengthOfLongestSubstring(s);

        System.out.println("Longest substring length: " + result);
    }
}
