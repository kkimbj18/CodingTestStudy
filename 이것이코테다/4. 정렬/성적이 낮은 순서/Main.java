import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        TreeMap<Integer, String> students = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String student = sc.next();
            Integer score = sc.nextInt();

            students.put(score, student);
        }

        // students.descendingKeySet() -> 내림차순
        for (Integer key : students.keySet()) {
            System.out.println(students.get(key));
        }
    }
}
