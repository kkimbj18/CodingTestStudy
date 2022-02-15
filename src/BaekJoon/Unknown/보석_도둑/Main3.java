package BaekJoon.Unknown.보석_도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        long sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> pq = new PriorityQueue<>((a, b)->{
            return b.v - a.v;
        });

        List<Integer> bagList = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            pq.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < K; i++) {
            bagList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(bagList);

        loop1:
        while (!pq.isEmpty()) {
            Jewel j = pq.poll();

            int idx = -1;

            for (int i = 0; i < bagList.size(); i++) {
                if (j.w <= bagList.get(i)) {
                    idx = i;
                    break;
                }
            }

            if (idx != -1) {
                sum += j.v;
                bagList.remove(idx);

                if (bagList.isEmpty()) {
                    break loop1;
                }
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
