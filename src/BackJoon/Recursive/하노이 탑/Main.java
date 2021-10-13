import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write((int)(Math.pow(2, N) - 1) + "\n");

        hanoi(N, 1, 3, 2, bw);

        bw.flush();
        bw.close();
    }
    
    public static void hanoi(int N, int start, int end, int pass, BufferedWriter bw) throws IOException {

        if (N == 1) {
            bw.write(start + " " + end + "\n");
        }
        else {
            hanoi(N - 1, start, pass, end, bw);
            bw.write(start + " " + end + "\n");
            hanoi(N - 1, pass, end, start, bw);
        }
        
    }
}
