public class Leet647 {

    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            count += extend(s, i, i);

            // Even length palindrome
            count += extend(s, i, i + 1);
        }

        return count;
    }

    public static int extend(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            count++;
            left--;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {

        String s = "anvbvna";

        int result = countSubstrings(s);

        System.out.println("Number of palindromic substrings: " + result);
    }
}