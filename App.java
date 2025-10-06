import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<Double[]> change(double[] coins, double value) {
        List<Double[]> result = new ArrayList<>();
        value *= 100;
        double numOfCoins = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (value > coins[i]) {
                numOfCoins = Math.floor(value / coins[i]);
                value = value % coins[i];
                result.add(new Double[] { coins[i], numOfCoins });
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double[] coins = { 1, 5, 10, 25, 50, 100 };
        double value = 1.99;
        List<Double[]> result = change(coins, value);
        for (Double[] coin : result) {
            // number of each coin
            System.out.println("$" + coin[0] / 100 + " x" + coin[1]);
        }
    }
}
