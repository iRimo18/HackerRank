package in.rimo.hackerrank.algo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bigger_is_greater
{
    private static final Scanner scanner = new Scanner(System.in);

    static String biggerIsGreater(String word)
    {
        int lastIndex = word.length() - 1;
        String ans = permute(word, lastIndex, word.charAt(lastIndex), "");
        if (ans.equals(word)) {
            return "no answer";
        }
        return ans;
    }

    private static String permute(String str, int index, char ch, String sub)
    {
        // the first letter is used for comparison, so end here
        if (index == 0) {
            return str + sub;
        }
        // from last to first check if the previous letter is larger then replace, ans is obtained
        for (int i = index; i > 0; i--) {
            if (str.charAt(i - 1) < ch) {
                return str.substring(0, i - 1) + ch + sub + str.substring(i - 1, index);
            }
        }
        // no larger is found, so take the before letter and do the same in recursion
        return permute(str.substring(0, index), index - 1, str.charAt(index - 1), ch + sub);
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

