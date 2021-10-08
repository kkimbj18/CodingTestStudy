import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        ArrayList<int[]> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();
            int[] temp = { startNode, endNode };
            edges.add(temp);
        }

        sc.close();

        
    }

    public static void dfs() {
        
    }
}
