public class leet76 {
     public static String minWindow(String s, String t) {

        int[] count = new int[128];

        // Store required characters
        for(char ch : t.toCharArray()) {
            count[ch]++;
        }

        int left = 0;
        int required = t.length();

        int start = 0;
        int minLength = Integer.MAX_VALUE;


        for(int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Character is needed
            if(count[ch] > 0) {
                required--;
            }

            // Add character to window
            count[ch]--;


            // Valid window found
            while(required == 0) {

                // Update minimum window
                if(right - left + 1 < minLength) {

                    minLength = right - left + 1;
                    start = left;
                }


                // Remove left character
                char leftChar = s.charAt(left);

                count[leftChar]++;


                // Window is invalid now
                if(count[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }


        if(minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }


    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = minWindow(s, t);

        System.out.println("Minimum Window: " + result);
    }
}
