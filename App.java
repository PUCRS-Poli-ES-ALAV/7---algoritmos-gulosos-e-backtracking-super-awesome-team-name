import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static int iterations = 0;

    public static List<Double[]> change(double[] coins, double value) {
        List<Double[]> result = new ArrayList<>();
        value *= 100;
        double numOfCoins = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            iterations++;
            if (value > coins[i]) {
                numOfCoins = Math.floor(value / coins[i]);
                value = value % coins[i];
                result.add(new Double[] { coins[i], numOfCoins });
            }
        }
        if (value > 0) {
            System.out.println("Sem moeda compatível. Sobrou: " + value);
        }
        return result;
    }

    public static List<int[]> sdm(List<int[]> intervals) {
        intervals.sort(Comparator.comparingDouble(o -> o[1]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            System.out.println("Testando: " + intervals.get(i)[0] + ", " + intervals.get(i)[1]);
            System.out.println("Contra: " + intervals.get(i - 1)[0] + ", " + intervals.get(i - 1)[1]);
            if (result.getLast()[1] < intervals.get(i)[0]) {
                result.add(intervals.get(i));
            }
        }
        return result;
    }

    public static void testeTroco(double value) {
        double[] coins = { 2, 5, 10, 25, 50, 100 };
        List<Double[]> result = change(coins, value);
        for (Double[] coin : result) {
            // number of each coin
            System.out.println("$" + coin[0] / 100 + " x" + coin[1]);
        }
        System.out.println("Iterações: " + iterations);
    }

    public static void main(String[] args) {
        iterations = 0;
        testeTroco(1.98);
        iterations = 0;
        List<int[]> result = sdm(Arrays.asList(new int[][] {
                { 1, 4 }, { 2, 5 }, { 5, 7 }, { 5, 6 }, { 7, 10 }, { 4, 8 }, { 7, 9 }, { 10, 11 }
        }));
        for (int[] a : result) {
            System.out.println(a[0] + " " + a[1]);
        }

    }
}
