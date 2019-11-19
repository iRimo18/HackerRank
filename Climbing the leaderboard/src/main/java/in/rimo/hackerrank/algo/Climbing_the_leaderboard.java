package in.rimo.hackerrank.algo;

import java.io.*;
import java.util.*;

public class Climbing_the_leaderboard
{
    private static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] aliceRank = new int[alice.length];
        int numScores = scores.length;
        // get the maximum rank possible among all
        int maxRank = 1;
        for (int i = 1; i < numScores; i++) {
            if (scores[i] != scores[i - 1]) {
                maxRank++;
            }
        }
        // take the worst rank that alice can get
        int rank = maxRank + 1;
        // point to the last, iterate from last to first
        int itr = numScores - 1;
        for (int i = 0; i < alice.length; i++) {
            // iterate till first index is reached, or alice score is less than some score
            while (itr >= 0 && alice[i] >= scores[itr]) {
                // is it a repeat value? first time it will be false, so decrease the rank
                boolean repeatVal = false;
                do {
                    itr--;
                    if (!repeatVal) {
                        // possible that first index is reached, and you get rank 0
                        rank = Math.max(1, rank - 1);
                        repeatVal = true;
                    }
                } while (itr > 0 && scores[itr + 1] == scores[itr]); // if repeat value, consume the index but dont decrease rank
            }

            aliceRank[i] = rank;
        }
        return aliceRank;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

