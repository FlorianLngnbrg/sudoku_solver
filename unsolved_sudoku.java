package Sudoku;

import java.util.Arrays;

public class unsolved_sudoku
{
        /*
    q1, q2, q3
    q4, q5, q6
    q7, q8, q9
     */

    private int[][] q1 =    {
            {6, 0, 0},
            {0, 0, 2},
            {0, 0, 0}};

    private int[][] q2 =
            {{0, 0, 3},
            {8, 4, 0},
            {0, 2, 9}};

    private int[][] q3 =
            {{0, 0, 0},
            {1, 7, 0},
            {8, 0, 3}};

    private int[][] q4 =
            {{4, 6, 0},
            {0, 0, 0},
            {0, 7, 3}};

    private int[][] q5 =
            {{0, 0, 0},
            {0, 1, 0},
            {0, 0, 4}};

    private int[][] q6 =
            {{9, 3, 0},
            {0, 0, 7},
            {0, 0, 0}};

    private int[][] q7 =
            {{0, 3, 8},
            {9, 0, 0},
            {1, 2, 6}};

    private int[][] q8 =
            {{4, 0, 2},
            {8, 0, 1},
            {7, 0, 5}};

    private int[][] q9 =
            {{5, 1, 9},
            {0, 0, 0},
            {3, 0, 4}};

    public int[][] getQn(int quadrant)
    {
        return switch (quadrant) {
            case 1 -> q1;
            case 2 -> q2;
            case 3 -> q3;
            case 4 -> q4;
            case 5 -> q5;
            case 6 -> q6;
            case 7 -> q7;
            case 8 -> q8;
            case 9 -> q9;
            default -> throw new RuntimeException("Ungültiger Quadrant");
        };
    }

    public int[][] setQn(int[][] quadrant, int num)
    {
        return switch (num) {
            case 1 -> this.q1 = quadrant;
            case 2 -> this.q2 = quadrant;
            case 3 -> this.q3 = quadrant;
            case 4 -> this.q4 = quadrant;
            case 5 -> this.q5 = quadrant;
            case 6 -> this.q6 = quadrant;
            case 7 -> this.q7 = quadrant;
            case 8 -> this.q8 = quadrant;
            case 9 -> this.q9 = quadrant;
            default -> throw new RuntimeException("Ungültiger Quadrant");
        };
    }

    public void toString2()
    {
        System.out.print(q1[0][0] + "  " + q1[0][1] + "  " + q1[0][2] + "     " + q2[0][0] + "  " + q2[0][1] + "  " + q2[0][2] + "     " + q3[0][0] + "  " + q3[0][1] + "  " + q3[0][2]);
        System.out.println(" ");
        System.out.print(q1[1][0] + "  " + q1[1][1] + "  " + q1[1][2] + "     " + q2[1][0] + "  " + q2[1][1] + "  " + q2[1][2] + "     " + q3[1][0] + "  " + q3[1][1] + "  " + q3[1][2]);
        System.out.println(" ");
        System.out.print(q1[2][0] + "  " + q1[2][1] + "  " + q1[2][2] + "     " + q2[2][0] + "  " + q2[2][1] + "  " + q2[2][2] + "     " + q3[2][0] + "  " + q3[2][1] + "  " + q3[2][2]);

        System.out.println(" ");
        System.out.println(" ");

        System.out.print(q4[0][0] + "  " + q4[0][1] + "  " + q4[0][2] + "     " + q5[0][0] + "  " + q5[0][1] + "  " + q5[0][2] + "     " + q6[0][0] + "  " + q6[0][1] + "  " + q6[0][2]);
        System.out.println(" ");
        System.out.print(q4[1][0] + "  " + q4[1][1] + "  " + q4[1][2] + "     " + q5[1][0] + "  " + q5[1][1] + "  " + q5[1][2] + "     " + q6[1][0] + "  " + q6[1][1] + "  " + q6[1][2]);
        System.out.println(" ");
        System.out.print(q4[2][0] + "  " + q4[2][1] + "  " + q4[2][2] + "     " + q5[2][0] + "  " + q5[2][1] + "  " + q5[2][2] + "     " + q6[2][0] + "  " + q6[2][1] + "  " + q6[2][2]);

        System.out.println(" ");
        System.out.println(" ");

        System.out.print(q7[0][0] + "  " + q7[0][1] + "  " + q7[0][2] + "     " + q8[0][0] + "  " + q8[0][1] + "  " + q8[0][2] + "     " + q9[0][0] + "  " + q9[0][1] + "  " + q9[0][2]);
        System.out.println(" ");
        System.out.print(q7[1][0] + "  " + q7[1][1] + "  " + q7[1][2] + "     " + q8[1][0] + "  " + q8[1][1] + "  " + q8[1][2] + "     " + q9[1][0] + "  " + q9[1][1] + "  " + q9[1][2]);
        System.out.println(" ");
        System.out.print(q7[2][0] + "  " + q7[2][1] + "  " + q7[2][2] + "     " + q8[2][0] + "  " + q8[2][1] + "  " + q8[2][2] + "     " + q9[2][0] + "  " + q9[2][1] + "  " + q9[2][2]);
    }
}