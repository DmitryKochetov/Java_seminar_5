// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

package DZ;

import java.util.concurrent.ThreadLocalRandom;

public class task4 {
    public static void main(String[] args) {
        int[][] board = new int[8][8];

        // for (int i = 0; i < 8; i++) {
        // for (int j = 0; j < 8; j++) {
        // System.out.print(" " + board[i][j]);
        // }
        // System.out.println();
        // }

        int queensCount = 1;
        int viciousCircle = 0;

        while (queensCount < 9) {
            viciousCircle++;
            int randomX = ThreadLocalRandom.current().nextInt(0, 8);
            int randomY = ThreadLocalRandom.current().nextInt(0, 8);
            if ((!isunderHit(board, randomX, randomY)) && (board[randomX][randomY] != 1)) {
                board[randomX][randomY] = queensCount;
                queensCount++;
            }
            if (viciousCircle > 10000) {
                System.out.println("Vicious circle ");
                break;
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isunderHit(int[][] table, int x, int y) {

        for (int i = 0; i < 8; i++) {
            if (table[i][y] > 0) {
                return true;
            }
            if (table[x][i] > 0) {
                return true;
            }
        }

        for (int i = 0; (i <= x) && (y - i >= 0); i++) {
            if (table[x - i][y - i] > 0)
                return true;
        }
        for (int i = 0; (x + i < 8) && (y + i < 8); i++) {
            if (table[x + i][y + i] > 0)
                return true;
        }
        for (int i = 0; (x + i < 8) && (y - i >= 0); i++) {
            if (table[x + i][y - i] > 0)
                return true;
        }
        for (int i = 0; (x - i >= 0) && (y + i < 8); i++) {
            if (table[x - i][y + i] > 0)
                return true;
        }

        return false;

    }
}
