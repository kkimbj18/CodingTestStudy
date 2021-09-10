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

        ArrayList<Person> people = new ArrayList<>();

        for (String information : info) {
            String[] infoArr = information.split(" ");
            people.add(new Person(infoArr));
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

            Query tempQ = new Query(queryArr);

            for (Person p : people) {
                if (!tempQ.lang.equals("-")) {
                    if (!tempQ.lang.equals(p.lang))
                        continue;
                }
                if (!tempQ.job.equals("-")) {
                    if (!tempQ.job.equals(p.job))
                        continue;
                }
                if (!tempQ.career.equals("-")) {
                    if (!tempQ.career.equals(p.career))
                        continue;
                }
                if (!tempQ.food.equals("-")) {
                    if (!tempQ.food.equals(p.food))
                        continue;
                }
                if (tempQ.score > p.score)
                    continue;

                answer[index]++;
            }
        }

        return answer;
    }
}

class Person {
    public String lang;
    public String job;
    public String career;
    public String food;
    public int score;

    public Person(String[] infoArr) {
        this.lang = infoArr[0];
        this.job = infoArr[1];
        this.career = infoArr[2];
        this.food = infoArr[3];
        this.score = Integer.parseInt(infoArr[4]);
    }
}

class Query {
    public String lang;
    public String job;
    public String career;
    public String food;
    public int score;

    public Query(String[] queryArr) {
        this.lang = queryArr[0];
        this.job = queryArr[1];
        this.career = queryArr[2];
        this.food = queryArr[3];
        this.score = Integer.parseInt(queryArr[4]);
    }
}
