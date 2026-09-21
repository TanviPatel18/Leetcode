import java.util.*;

public class leet3731 {

    public static List<Integer> findMissingElements(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 4, 2, 5};

        List<Integer> ans = findMissingElements(nums);

        System.out.println(ans); // Output: [3]
    }
}
