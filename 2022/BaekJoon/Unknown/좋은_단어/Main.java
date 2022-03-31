import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        String[] strArr = new String[N];

        for (int i = 0; i < N; i++) {
            strArr[i] = br.readLine();
        }


        for (String str : strArr) {
            Stack s = new Stack();
            char[] arr = str.toCharArray();

            for (char letter : arr) {

                if (s.empty())
                    s.push(letter);
                else {
                    char prevLetter = (char)s.peek();
                    if (prevLetter == letter)
                        s.pop();
                    else
                        s.push(letter);
                }
            }

            if (s.empty())
                answer++;
        }

        System.out.println(answer);
    }
}
