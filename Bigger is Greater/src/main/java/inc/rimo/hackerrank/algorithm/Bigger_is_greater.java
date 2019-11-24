package inc.rimo.hackerrank.algorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Bigger_is_greater
{

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w)
    {
        char[] charArray = w.toCharArray();
        int n = charArray.length;
        int endIndex = 0;

        // Start from the right most character and find the first character that is smaller than previous character.
        for (endIndex = n - 1; endIndex > 0; endIndex--) {
            if (charArray[endIndex] > charArray[endIndex - 1]) {
                break;
            }
        }

        if (endIndex == 0) {
            return "no answer";
        }
        else {
            int firstSmallChar = charArray[endIndex - 1];
            int nextSmallChar = endIndex;

            // Find the smallest character on right side of (endIndex - 1)'th character that is greater than charArray[endIndex - 1]
            for (int startIndex = endIndex + 1; startIndex < n; startIndex++) {
                if (charArray[startIndex] > firstSmallChar && charArray[startIndex] < charArray[nextSmallChar]) {
                    nextSmallChar = startIndex;
                }
            }

            // Swap the above found next smallest character with charArray[endIndex - 1]
            swap(charArray, endIndex - 1, nextSmallChar);

            // Sort the charArray after (endIndex - 1)in ascending order
            Arrays.sort(charArray, endIndex, n);
        }
        return new String(charArray);
    }

    static void swap(char[] charArray, int i, int j)
    {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public static void main(String[] args)
            throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
