public class Insertion {
    public static void main(String[] args) {
        int[] data = { 1, 10, 7, 4, 6, 5, 2, 3, 11 };

        insertionSort(data);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i-1;
            int target = arr[i];

            while (true) {
                if (j < 0 || target > arr[j])
                    break;

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j+1] = target;

            // printArr(arr);
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
