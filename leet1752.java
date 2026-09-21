import java.util.Scanner;

public class leet1752 {

    static boolean check(int[] arr) {

        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            if (arr[i] > arr[(i + 1) % n]) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean ans = check(arr);

        System.out.println("Result: " + ans);

        sc.close();
    }
}