import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;

public class Main {
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        try {
            for (int count : course) {
                Map<String, Integer> tempMap = new HashMap<>();

                for (String order : orders) {
                    boolean[] visited = new boolean[order.length()];
                    Arrays.fill(visited, false);
                    char[] StringToChar = order.toCharArray();
                    Arrays.sort(StringToChar);
                    String sortedOrder = new String(StringToChar);

                    combination(sortedOrder, visited, 0, order.length(), count, tempMap);
                }

                if (tempMap.size() > 0) {
                    Integer maxValue = Collections.max(tempMap.values());
                    if (maxValue > 1) {
                        for (Entry<String, Integer> entry : tempMap.entrySet()) {
                            if (entry.getValue() == maxValue) {
                                answer.add(entry.getKey());
                            }
                        }
                    }
                } 
            }

            Collections.sort(answer);

            String[] result = answer.toArray(new String[0]);

            return result;
        } catch (Exception e) {
            System.out.println(e);

            return orders;
        }

    }

    public void combination(String order, boolean[] visited, int start, int n, int r, Map<String, Integer> tempMap) {
        if (r == 0) {
            String temp = "";
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    temp += order.charAt(i);
                }
            }
            Object tmp = tempMap.get(temp);
            tempMap.compute(temp, (k, v) -> (tmp == null) ? 1 : (v + 1));
        } else {
            for (int i = start; i < n; i++) {
                visited[i] = true;
                combination(order, visited, i + 1, n, r - 1, tempMap);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        String[] orders = { "ABT", "AB", "ABCYUHGWE", "ABC" };
        int[] course = { 2, 3 };

        String[] answer = main.solution(orders, course);
        for (String r : answer) {
            System.out.println(r);
        }
    }
}
