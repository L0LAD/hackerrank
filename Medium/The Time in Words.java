import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String linkWord = "";
        String minuteWord = " minutes";
        String result;

        //Hours only between 1 and 12
        HashMap<Integer, String> numbersMap = new HashMap<Integer, String>();
        numbersMap.put(1, "one"); numbersMap.put(2, "two"); numbersMap.put(3, "three");
        numbersMap.put(4, "four"); numbersMap.put(5, "five"); numbersMap.put(6, "six");
        numbersMap.put(7, "seven"); numbersMap.put(8, "eight"); numbersMap.put(9, "nine");
        numbersMap.put(10, "ten"); numbersMap.put(11, "eleven"); numbersMap.put(12, "twelve");
        numbersMap.put(13, "thirteen"); numbersMap.put(14, "fourteen"); numbersMap.put(15, "quarter");
        numbersMap.put(16, "sixteen"); numbersMap.put(17, "seventeen"); numbersMap.put(18, "eighteen");
        numbersMap.put(19, "nineteen"); numbersMap.put(20, "twenty"); numbersMap.put(30, "half");

        if (m == 1)
            minuteWord = " minute";

        if (m <= 30)
            linkWord = " past ";
        else {
            linkWord = " to ";
            m = 60-m;
            h = h+1;
        }

        if (m == 0)
            result = numbersMap.get(h) + " o' clock";
        else if (m == 15 || m == 30)
            result = numbersMap.get(m) + linkWord + numbersMap.get(h);
        else if (m > 20)
            result = numbersMap.get(20) + " " + numbersMap.get(m-20) + minuteWord + linkWord + numbersMap.get(h);
        else
            result = numbersMap.get(m) + minuteWord + linkWord + numbersMap.get(h);
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
