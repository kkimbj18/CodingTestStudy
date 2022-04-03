import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        Arrays.fill(arr, 0);


        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(arr));

        for (int num : nums) {
            arr[num]++;
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < 10; i++) {
            while (arr[i] > 0) {
                System.out.print(i + " ");
                arr[i]--;
            }
        }
        
        System.out.println();
    }
}
