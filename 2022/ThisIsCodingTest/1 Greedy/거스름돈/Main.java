public class Main {
    public static void main(String[] args) {
        int change = 1260;
        int count = 0;
        int[] units = { 500, 100, 50, 10 };

        for (int i = 0; i < units.length; i++) {
            int coin = units[i];
            count += change / coin;
            change %= coin;
        }

        System.out.println(count);
    }
}