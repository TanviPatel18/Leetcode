public class leet152 {
    public static int maxProduct(int[] nums) {

        int n = nums.length;

        int max = nums[0];
        int min = nums[0];
        int product = nums[0];

        for (int i = 1; i < n; i++) {

            int current = nums[i];

            // If current number is negative swap max and min
            if (current < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(current, max * current);

            min = Math.min(current, min * current);

            product = Math.max(product, max);
        }

        return product;
    }


    public static void main(String[] args) {

        int[] nums = {2, 3, -2, 4};

        int answer = maxProduct(nums);

        System.out.println("Maximum Product = " + answer);
    }
}
