import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String[] info = {
"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"
        };

        String[] query = {
"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"
        };

        int[] result = main.solution(info, query);

        for (int r : result) {
            System.out.println(r);
        }
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Arrays.fill(answer, 0);

        int index = -1;

        ArrayList<String[]> people = new ArrayList<>();

        for (String information : info) {
            String[] infoArr = information.split(" ");
            people.add(infoArr);
        }

        for (String q : query) {
            index++;

            String[] temp = q.split(" and ");
            String[] temp2 = temp[3].split(" ");
            String[] queryArr = new String[5];

            for (int i = 0; i < 3; i++) {
                queryArr[i] = temp[i];
            }
            queryArr[3] = temp2[0];
            queryArr[4] = temp2[1];

            for (String[] p : people) {
                if (!queryArr[0].equals("-")) {
                    if (queryArr[0].charAt(0) != p[0].charAt(0))
                        continue;
                }
                if (!queryArr[1].equals("-")) {
                    if (queryArr[1].charAt(0) != p[1].charAt(0))
                        continue;
                }
                if (!queryArr[2].equals("-")) {
                    if (queryArr[2].charAt(0) != p[2].charAt(0))
                        continue;
                }
                if (!queryArr[3].equals("-")) {
                    if (queryArr[3].charAt(0) != p[3].charAt(0))
                        continue;
                }
                if (Integer.parseInt(queryArr[4]) > Integer.parseInt(p[4]))
                    continue;

                answer[index]++;
            }
        }

        return answer;
    }
}