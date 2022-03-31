import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] temp = new int[N];

        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int sum = 0;

        for (int i = 0; i < K; i++) {
            sum += temp[i];
        }

        int l = 0;

        ArrayList<Integer> list = new ArrayList<>();

        list.add(sum);

        while (l + K < N) {
            sum += temp[l + K];
            sum -= temp[l++];

            list.add(sum);
        }

        int answer = Collections.max(list);

        System.out.println(answer);
    }
}
