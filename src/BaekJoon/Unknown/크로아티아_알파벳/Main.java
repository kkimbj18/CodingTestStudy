package BaekJoon.Unknown.크로아티아_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    
    static List<String> targetList = Arrays.asList(new String[]{ "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int start = 0;
        int curr = 0;
        int count = 0;

        String subInput = null;

        for (curr = 1; curr <= input.length(); curr++) {
            boolean isAvailable = false;
            boolean isEqual = false;

            while(true) {
                subInput = input.substring(start, curr);
            
                for (String t: targetList) {
                    if (t.startsWith(subInput)) {
                        isAvailable = true;
                        if (t.equals(subInput)) {
                            isEqual = true;
                            break;
                        }
                    }
                }

                if (!isAvailable) {
                    count++;
                    start++;
                } else if (isEqual) {
                    count++;
                    start = curr;
                }

                // System.out.println(subInput + " " + count);

                if (isAvailable) break;
            }
            
        }

        subInput = input.substring(start, input.length());

        // System.out.println("last: " + subInput);

        count += subInput.length();

        System.out.println(count);

    }
}
