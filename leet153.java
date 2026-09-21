public class leet153 {
    public static int findMin(int[] nums) {
        int n= nums.length;
        int right=n-1;
        int left=0;
        int min = nums[0];
        for (int x : nums) 
        {
             min = Math.min(min, x);
        }
        return min;
    }
     public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int result = findMin(nums);

        System.out.println("Minimum element: " + result);
    }
}

