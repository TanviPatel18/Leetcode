import java.util.Arrays;

public class leet3016 {

    public static int minimumPushes(String word) {

        // Store frequency of each lowercase letter
        // Index 0 -> a, 1 -> b, .... 25 -> z
        int[] freq = new int[26];


        // Count how many times each character appears
        for(char ch : word.toCharArray()) {

            // Convert character to array index
            // Example:
            // 'a' - 'a' = 0
            // 'b' - 'a' = 1
            // 'z' - 'a' = 25
            freq[ch - 'a']++;
        }


        // Sort frequencies in ascending order
        // Highest frequencies will come at the end
        Arrays.sort(freq);


        int push = 0;  // total pushes required
        int count = 0; // number of letters assigned


        // Start from highest frequency letter
        for(int i = 25; i >= 0; i--) {


            // No more characters
            if(freq[i] == 0)
                break;


            /*
              Assign push cost:

              First 8 letters  -> 1 push
              Next 8 letters   -> 2 pushes
              Next 8 letters   -> 3 pushes
              Remaining       -> 4 pushes

              count/8 + 1 gives the push number
            */
            push += freq[i] * (count / 8 + 1);


            // One more letter assigned
            count++;
        }


        return push;
    }



    public static void main(String[] args) {


        String word = "abbcccdddd";


        int result = minimumPushes(word);


        System.out.println("Minimum pushes: " + result);
    }
}