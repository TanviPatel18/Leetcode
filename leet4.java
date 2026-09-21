public class leet4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int first = nums1.length;
        int second = nums2.length;

        int[] ans = new int[first + second];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first && j < second) {

            if (nums1[i] < nums2[j]) {
                ans[k] = nums1[i];
                i++;
            } else {
                ans[k] = nums2[j];
                j++;
            }

            k++;
        }

        while (i < first) {
            ans[k] = nums1[i];
            i++;
            k++;
        }

        while (j < second) {
            ans[k] = nums2[j];
            j++;
            k++;
        }

        int n = ans.length;

        if (n % 2 != 0) {
            return ans[n / 2];
        }

        int mid1 = ans[n / 2 - 1];
        int mid2 = ans[n / 2];

        return (mid1 + mid2) / 2.0;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        double result = findMedianSortedArrays(nums1, nums2);

        System.out.println("Median = " + result);
    }
}