import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Candidate[] candidates;
    static int[][] chart;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        candidates = new Candidate[N];
        chart = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                chart[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxIdx = -1;
        int secIdx = -1;
        int max = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if (chart[N - 1][i] > sec) {
                if (chart[N - 1][i] > max) {
                    max = chart[N - 1][i];
                    secIdx = maxIdx;
                    maxIdx = i;
                } else {
                    sec = chart[N - 1][i];
                    secIdx = i;
                }
            }
            
            candidates[i] = new Candidate(N - 1, chart[N-1][i]);
        }

        if (secIdx == -1)
            answer = chart[0][0];
        else 
            search(0, secIdx, maxIdx);

        System.out.println(answer);
    }

    public static void search(int count, int nextIdx, int currIdx) {
        if (count == N)
            return;

        // System.out.println(currIdx + " " + candidates[currIdx].value + " " + nextIdx + " " + candidates[nextIdx].value + " " + count);

        if (candidates[currIdx].value >= candidates[nextIdx].value) {
            answer = candidates[currIdx].value;
            if (candidates[currIdx].index == 0) {
                candidates[currIdx].value = Integer.MIN_VALUE;
                return;
            }
            candidates[currIdx].value = chart[--candidates[currIdx].index][currIdx];
            search(++count, nextIdx, currIdx);
        } else {
            int secIdx = findSecIdx(nextIdx);
            search(count, secIdx, nextIdx);
        }
    }

    public static int findSecIdx(int excludeIdx) {
        int maxIdx = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if (i == excludeIdx)
                continue;

            if (candidates[i].value > max) {
                max = candidates[i].value;
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}

class Candidate {
    int index;
    int value;

    Candidate (int idx, int val) {
        index = idx;
        value = val;
    }
}
