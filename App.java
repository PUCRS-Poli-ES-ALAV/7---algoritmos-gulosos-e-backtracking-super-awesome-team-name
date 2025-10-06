import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static double[] change(double[] coins, double value) {
        List<Double> result = new ArrayList<>();
        for (int i = coins.length - 1; i >= 0; i--) {
            while (value >= coins[i]) {
                value -= coins[i];
                value = Math.round(value * 100.0) / 100.0;
                result.add(coins[i]);
            }
        }
        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public static void main(String[] args) {
        double[] coins = { 0.01, 0.05, 0.10, 0.25, 0.50, 1.00 };
        double value = 1.99;
        double[] result = change(coins, value);
        for (double coin : result) {
            System.out.printf("$%.2f ", coin);
        }
    }
}
