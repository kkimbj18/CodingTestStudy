package BaekJoon.Unknown.크로스워드_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int i = -1;
        int j = -1;

        for (i = 0; i < A.length(); i++) {
            char c = A.charAt(i);

            j = B.indexOf(c);
            if (j != -1) break;
        }

        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < B.length(); y++) {
            for (int x = 0; x < A.length(); x++) {
                if (y == j) {
                    sb.append(A.charAt(x));
                } else if (x == i) {
                    sb.append(B.charAt(y));
                } else {
                    sb.append(".");
                }
            }

            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
