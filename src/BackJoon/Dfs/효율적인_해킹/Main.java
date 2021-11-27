import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.*;

public class Main {
    static int N, M;
    static int[] max;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        max = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            arr[a].add(b);
        }

        br.close();

        for (int i = 0; i < N; i++) {
            boolean[] checked = new boolean[N];
            checked[i] = true;
            dfs(i, checked);
        }

        printMax();
    }

    public static void dfs(int curr, boolean[] checked) {
        for (int node : arr[curr]) {
            if (!checked[node]) {
                checked[node] = true;
                max[node]++;
                dfs(node, checked);
            }
        }
    }

    public static void printMax() throws IOException {
        int maxValue = Arrays.stream(max).max().getAsInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (max[i] == maxValue)
                sb.append(i + 1 + " ");
        }
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
