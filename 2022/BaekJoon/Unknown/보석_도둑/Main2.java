package BaekJoon.Unknown.보석_도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        long sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> list = new LinkedList<>();
        int[] bag = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            list.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        list.sort((a, b) -> {
            int wd = a.w - b.w;

            if (wd == 0) {
                return b.v - a.v;
            }

            return wd;
        });

        for (int b: bag) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            int prevW = -1;

            for (int i = 0; i < list.size(); i++) {
                Jewel l = list.get(i);

                if (l.w != prevW) {
                    prevW = l.w;

                    if (l.w < b) {
                        if (max < l.v) {
                            max = l.v;
                            maxIndex = i;
                        }
                    } else if (l.w == b) {
                        if (max < l.v) {
                            max = l.v;
                            maxIndex = i;
                        }
                        break;
                    } else break;
                }
            }

            if (maxIndex != -1) {
                sum += max;
                list.remove(maxIndex);
            }
        }

        System.out.println(sum);
    }
}

class Jewel {
    int w;
    int v;

    Jewel(int w, int v) {
        this.w = w;
        this.v = v;
    }
}
