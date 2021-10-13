package Algorithm.а╤гу;

public class Main {
    public void combination(String order, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            String temp = "";
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    temp += order.charAt(i);
                }
            }
            System.out.println(temp);
        } else {
            for (int i = start; i < n; i++) {
                visited[i] = true;
                combination(order, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }
}
