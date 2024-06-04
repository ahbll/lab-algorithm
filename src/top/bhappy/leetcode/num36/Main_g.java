package top.bhappy.leetcode.num36;

/**
 * @Author: liu lei
 * @Date: 2024/5/30 09:48
 * @Description:
 */
public class Main_g {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        // row[i][j] 记录第i行出现过j这个数
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] subBox = new int[3][3][9];
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                char c = board[i][j];
                if (c != '.') {
                    int v = c - '1';
                    if (row[i][v] != 0) {
                        return false;
                    } else {
                        row[i][v] = 1;
                    }
                    if (col[j][v] != 0) {
                        return false;
                    } else {
                        col[j][v] = 1;
                    }
                    if (subBox[i / 3][j / 3][v] != 0) {
                        return false;
                    } else {
                        subBox[i / 3][j / 3][v] = 1;
                    }
                }

            }
        }
        return true;
    }

}
