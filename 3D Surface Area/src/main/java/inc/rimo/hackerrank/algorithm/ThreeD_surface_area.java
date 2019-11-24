package inc.rimo.hackerrank.algorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ThreeD_surface_area
{
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] A, int H, int W)
    {
        // Regardless of the configuration, the toy has always a fixed "top surface" and "bottom surface"
        int result = 2 * H * W;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {

                // We initially add the surface of the four lateral areas of the current cube...
                result += (A[i][j]) * 4;

                //... and then we remove the unnecessary areas, according the height of the adjacent cubes
                // already considered
                if (i != 0) {
                    result -= 2 * Math.min(A[i - 1][j], A[i][j]);
                }
                if (j != 0) {
                    result -= 2 * Math.min(A[i][j], A[i][j - 1]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
            throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A, H, W);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
