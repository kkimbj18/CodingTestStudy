import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String value = sc.next();

        String result = solution(value);

        sc.close();
    }
    public static String solution(String new_id) {
        String answer;

        answer = new_id.toLowerCase();
        System.out.println(answer);
        answer = answer.replaceAll("[^0-9a-z-_.]", "");
        System.out.println(answer);
        answer = answer.replaceAll("[.]{2,}", ".");
        System.out.println(answer);
        answer = answer.replaceAll("^[.]|[.]$", "");
        System.out.println(answer);
        if (answer.isEmpty()) {
            answer += "a";
        }
        System.out.println(answer);
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
        }
        System.out.println(answer);
        answer = answer.replaceAll("[.]$", "");
        System.out.println(answer);
        if (answer.length() < 3) {
            for (int i = answer.length(); i < 3; i++) {
                answer += answer.substring(answer.length() - 1);
            }
        }
        System.out.println(answer);

        return answer;
    }
}