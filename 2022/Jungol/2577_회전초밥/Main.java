import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] count = new int[d+1];
        int diffCount = 0;
        int maxCount = 0;
        int[] sushis = new int[N];

        count[c]++;
        diffCount = 1;

        for (int i = 0; i < N; i++) {
            sushis[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            if (count[sushis[i]] == 0) diffCount++;
            count[sushis[i]]++;
        }

        maxCount = Math.max(diffCount, maxCount);
        // System.out.println("0: " + diffCount + " " + maxCount);
        // System.out.println(Arrays.toString(count));

        for (int i = 1; i < N; i++) {
            if(--count[sushis[i-1]] == 0) diffCount--;
            if(count[sushis[(i+k-1)%N]]++ == 0) diffCount++;

            maxCount = Math.max(diffCount, maxCount);
            // System.out.println(i + ": " + diffCount + " " + maxCount);
            // System.out.println(Arrays.toString(count));
        }

        System.out.println(maxCount);
    }
}