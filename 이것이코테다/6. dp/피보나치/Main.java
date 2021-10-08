import java.util.Arrays;

public class Main {
    private static long[] dp = new long[100]; 

    public static void main(String[] args) {
        
        Arrays.fill(dp, 0);

        long result = fibo(50);

        System.out.println(result);
    }
    
    public static long fibo(int x) {
        if (x == 1 || x == 2)
            return 1;
        
        if (dp[x] == 0)
            dp[x] = fibo(x - 1) + fibo(x - 2);

        return dp[x];
    }
}
