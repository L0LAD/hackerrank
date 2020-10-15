import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] Pawns) {

        //Initialization of Pawns in all possible directions
        int rPawnT, rPawnTR, rPawnR, rPawnBR, rPawnB, rPawnBL, rPawnL, rPawnTL;
        rPawnT = rPawnTR = rPawnR = rPawnBR = rPawnB = rPawnBL = rPawnL = rPawnTL = -1;
        int cPawnT, cPawnTR, cPawnR, cPawnBR, cPawnB, cPawnBL, cPawnL, cPawnTL;
        cPawnT = cPawnTR = cPawnR = cPawnBR = cPawnB = cPawnBL = cPawnL = cPawnTL = -1;

        for (int[] Pawn:Pawns) {
            boolean isDiagonal = (Math.abs(Pawn[0]-r_q) == Math.abs(Pawn[1]-c_q));

            //Find the closest Pawns
            //Top
            if (Pawn[1] == c_q && Pawn[0] > r_q && (Pawn[0] < rPawnT || rPawnT == -1)) {
                rPawnT = Pawn[0];
                cPawnT = Pawn[1];
            }

            //Top right
            if (isDiagonal && Pawn[0] > r_q  && Pawn[1] > c_q && (Pawn[0] < rPawnTR || rPawnTR == -1)) {
                rPawnTR = Pawn[0];
                cPawnTR = Pawn[1];
            }

            //Right
            if (Pawn[0] == r_q && Pawn[1] > c_q && (Pawn[0] < cPawnR || rPawnR == -1)) {
                rPawnR = Pawn[0];
                cPawnR = Pawn[1];
            } 

            //Bottom right
            if (isDiagonal && Pawn[0] < r_q  && Pawn[1] > c_q && (Pawn[0] > rPawnBR || rPawnBR == -1)) {
                rPawnBR = Pawn[0];
                cPawnBR = Pawn[1];
            }

            //Bottom
            if (Pawn[1] == c_q && Pawn[0] < r_q && (Pawn[0] > rPawnB || rPawnB == -1)) {
                rPawnB = Pawn[0];
                cPawnB = Pawn[1];
            }

            //Bottom left
            if (isDiagonal && Pawn[0] < r_q  && Pawn[1] < c_q && (Pawn[0] > rPawnBL || rPawnBL == -1)) {
                rPawnBL = Pawn[0];
                cPawnBL = Pawn[1];
            }

            //Left
            if (Pawn[0] == r_q && Pawn[1] < c_q && (Pawn[0] > cPawnL || rPawnL == -1)) {
                rPawnL = Pawn[0];
                cPawnL = Pawn[1];
            } 

            //Top left
            if (isDiagonal && Pawn[0] > r_q  && Pawn[1] < c_q && (Pawn[0] < rPawnTL || rPawnTL == -1)) {
                rPawnTL = Pawn[0];
                cPawnTL = Pawn[1];
            }
        }

        //Number of reachable cases
        int result = 0;

        //Top, right, bottom, left
        result += (rPawnT == -1) ? (n-r_q) : (rPawnT-r_q-1);
        result += (rPawnR == -1) ? (n-c_q) : (cPawnR-c_q-1);
        result += (rPawnB == -1) ? (r_q-1) : (r_q-rPawnB-1);
        result += (rPawnL == -1) ? (c_q-1) : (c_q-cPawnL-1);

        //Top right, bottom right, bottom left, top left
        result += (rPawnTR == -1) ? Math.min(n-r_q, n-c_q) : (rPawnTR-r_q-1);
        result += (rPawnBR == -1) ? Math.min(r_q-1, n-c_q) : (r_q-rPawnBR-1);
        result += (rPawnBL == -1) ? Math.min(r_q-1, c_q-1) : (r_q-rPawnBL-1);
        result += (rPawnTL == -1) ? Math.min(n-r_q, c_q-1) : (rPawnTL-r_q-1);

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] Pawns = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] PawnsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int PawnsItem = Integer.parseInt(PawnsRowItems[j]);
                Pawns[i][j] = PawnsItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, Pawns);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
