import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    //Complete the minimumLoss function below.
    static int minimumLoss(long[] prices) {
        int n = prices.length;
        HashMap<Long, Integer> pricesMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            pricesMap.put(prices[i], i);
        }
        Arrays.sort(prices);

        long result = Long.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            if (prices[i+1] - prices[i] < result) {
                if (pricesMap.get(prices[i+1]) < pricesMap.get(prices[i]))
                    result = prices[i+1] - prices[i];
            }
        }

        return (int)result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        int result = minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}