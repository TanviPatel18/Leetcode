public class leet424 {

    public static int characterReplacement(String s, int k) {

        int[] count = new int[26];

        int left = 0;
        int ans = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {

            count[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq,
                    count[s.charAt(right) - 'A']);

            int length = right - left + 1;

            while (length - maxFreq > k) {

                count[s.charAt(left) - 'A']--;
                left++;

                length = right - left + 1;
            }

            ans = Math.max(ans, length);
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        int result = characterReplacement(s, k);

        System.out.println(result);
    }
}