public class leet5 {
   int start = 0;
    int maxLen = 1;

    public String longestPalindrome(String s) {

        if (s.length() < 2)
            return s;

        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);       // Odd length palindrome
            expand(s, i, i + 1);   // Even length palindrome
        }

        return s.substring(start, start + maxLen);
    }

    public void expand(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                start = left;
            }

            left--;
            right++;
        }
    }

    public static void main(String[] args) {

        leet5 obj = new leet5();

        String s = "babad";

        String ans = obj.longestPalindrome(s);

        System.out.println("Input: " + s);
        System.out.println("Longest Palindrome: " + ans);
    } 
}
