
import java.util.*;

public class leet17 {

    static String[] phone = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void backtrack(String digits, int index,
                                 String current, ArrayList<String> ans) {

        // Base case
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        // Get letters for current digit
        String letters = phone[digits.charAt(index) - '0'];

        // Try every letter
        for (int i = 0; i < letters.length(); i++) {

            backtrack(
                digits,
                index + 1,
                current + letters.charAt(i),
                ans
            );
        }
    }

    public static ArrayList<String> letterCombinations(String digits) {

        ArrayList<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        backtrack(digits, 0, "", ans);

        return ans;
    }

    public static void main(String[] args) {

        String digits = "23";

        ArrayList<String> ans = letterCombinations(digits);

        System.out.println(ans);
    }
}

