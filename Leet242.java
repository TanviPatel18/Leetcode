import java.util.Arrays;
import java.util.Scanner;

public class Leet242 {

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        boolean result = isAnagram(s, t);

        if (result) {
            System.out.println("String are Anagram");
        } else {
            System.out.println("String are not Anagram");
        }

        sc.close();
    }
}

