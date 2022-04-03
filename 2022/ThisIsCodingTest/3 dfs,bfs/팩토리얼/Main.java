public class Main {
    public static void main(String args[]) {
        Main main = new Main();
        int result1 = main.factorial_recursive(5);
        int result2 = main.factorial_iterative(5);

        System.out.println(result1);
        System.out.println(result2);
    }
    
    public int factorial_recursive(int n) {
        if (n == 1)
            return 1;

        return n * factorial_recursive(n - 1);
    }

    public int factorial_iterative(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
