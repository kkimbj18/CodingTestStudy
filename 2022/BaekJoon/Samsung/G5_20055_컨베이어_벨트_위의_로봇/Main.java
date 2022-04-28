import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int size = 2*N;

        int[] A = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int phase = 1;
        int upLoc = 0;
        int downLoc = N-1;
        int zeroCount = 0;

        List<Integer> robotList = new LinkedList<>();
        boolean[] isRobot = new boolean[size];

        while (true) {
            // 1. 벨트 회전
            upLoc = (upLoc-1) < 0 ? size-1 : upLoc-1;
            downLoc = (downLoc-1) < 0 ? size-1 : downLoc-1;

            if (isRobot[downLoc]) {
                robotList.remove((Integer)downLoc);
                isRobot[downLoc] = false;
            }

            // 2. 로봇 한칸 이동
            for (int i = 0; i < robotList.size(); i++) {
                int currIndex = robotList.get(i);
                int nextIndex = (currIndex+1)%size;

                if (A[nextIndex] > 0 && !isRobot[nextIndex]) {
                    if (--A[nextIndex] == 0) zeroCount++;
                    isRobot[currIndex] = false;
                    isRobot[nextIndex] = true;
                    if (nextIndex == downLoc) {
                        robotList.remove(i);
                        i--;
                        continue;
                    }
                    robotList.set(i, nextIndex);
                }
            }

            // 3. 로봇 올리기
            if (A[upLoc] > 0) {
                robotList.add(upLoc);
                isRobot[upLoc] = true;
                if (--A[upLoc] == 0) zeroCount++;
            }

            // System.out.println(phase + " " + upLoc + " " + downLoc + " " + Arrays.toString(A));

            // 4. 칸의 개수 확인
            if (zeroCount >= K) break;
            phase++;
        }

        System.out.println(phase);
    }
}
