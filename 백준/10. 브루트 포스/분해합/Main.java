import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        while (true) {
            if ((N / (int)Math.pow(10.0, count++)) == 0)
                break;
        }

        int min = N - count * 9;
        int max = N - count;

        for (int i = min; i <= max; i++) {
            int sum = i;
            int temp = i;
            for (int j = count - 1; j >= 0; j--) {
                int digit = (int) Math.pow(10, j);
                int tmp = temp / digit;
                temp -= tmp * digit;
                sum += tmp;
            }
            if (sum == N) {
                bw.write(i + "\n");
                bw.flush();
                bw.close();
                return;
            }
        }
        
        bw.write(0 + "\n");
        bw.flush();
        bw.close();
        return;
    }
}
