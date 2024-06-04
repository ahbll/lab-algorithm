package top.bhappy.leetcode.num56;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liu lei
 * @Date: 2024/5/30 14:31
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }));
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int iMin = 1;
        int iMax = matrix.length - 1;
        int jMin = 0;
        int jMax = matrix[0].length - 1;

        int i = 0;
        int j = 0;
        int iIncre = 0;
        int jIncre = 1;
        while (result.size() < matrix.length * matrix[0].length) {
            result.add(matrix[i][j]);
            if (jIncre == 1 && j == jMax) {
                jIncre = 0;
                iIncre = 1;
                jMax = jMax - 1;
            } else if (iIncre == 1 && i == iMax) {
                iIncre = 0;
                jIncre = -1;
                iMax = iMax - 1;
            } else if (jIncre == -1 && j == jMin) {
                jIncre = 0;
                iIncre = -1;
                jMin = jMin + 1;
            } else if (iIncre == -1 && i == iMin) {
                iIncre = 0;
                jIncre = 1;
                iMin = iMin + 1;
            }
            i = i + iIncre;
            j = j + jIncre;
        }
        return result;
    }

}
