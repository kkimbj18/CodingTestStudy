package BaekJoon.Unknown.문자열_폭발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String target = br.readLine();

        int T = target.length();

        Stack<Character> s = new Stack<>();

        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));

            int t = T;
            while(!s.isEmpty() && target.charAt(t-1) == s.peek()) {
                temp = temp.append(s.pop());

                if (t-- == 1) {
                    temp.setLength(0);
                    break;
                }
            }

            for (int j = temp.length() - 1; j >= 0; j--) {
                s.push(temp.charAt(j));
            }
            temp.setLength(0);
        }

        if (s.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();

            for (char c: s) {
                sb.append(c);
            }

            System.out.println(sb);
        }
    }
}
