public class leet3936 {

    public static int minimumSwaps(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left < right) {

            if (nums[left] != 0) {
                left++;
            }
            else if (nums[right] == 0) {
                right--;
            }
            else {

                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                count++;
                left++;
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        int ans = minimumSwaps(nums);

        System.out.println("Minimum swaps = " + ans);
    }
}


