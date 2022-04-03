import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int xdiff = Math.abs(x1-x2);
            int ydiff = Math.abs(y1-y2);

            int xydiff = Math.abs(xdiff - ydiff);

            int step = 0;

            step = xdiff + ydiff + xydiff / 2 * 2;

            sb.append("#").append(t).append(" ").append(step).append("\n");
        }
        
        System.out.print(sb);
    }
}
