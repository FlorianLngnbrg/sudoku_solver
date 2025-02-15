package Sudoku;

import java.util.ArrayList;

public class auxiliaryLayer
{
        /*
    q1, q2, q3
    q4, q5, q6
    q7, q8, q9
     */

    private ArrayList<Integer>[][] q1 = new ArrayList[3][3];
    private ArrayList<Integer>[][] q2 = new ArrayList[3][3];
    private ArrayList<Integer>[][] q3 = new ArrayList[3][3];
    private ArrayList<Integer>[][] q4 = new ArrayList[3][3];
    private ArrayList<Integer>[][] q5 = new ArrayList[3][3];
    private ArrayList<Integer>[][] q6 = new ArrayList[3][3];
    private ArrayList<Integer>[][] q7 = new ArrayList[3][3];
    private ArrayList<Integer>[][] q8 = new ArrayList[3][3];
    private ArrayList<Integer>[][] q9 = new ArrayList[3][3];

    public auxiliaryLayer()
    {
        for (int i = 0; i < q1.length; i++) {
            for (int j = 0; j < q1[i].length; j++) {
                q1[i][j] = new ArrayList<>();
                q2[i][j] = new ArrayList<>();
                q3[i][j] = new ArrayList<>();
                q4[i][j] = new ArrayList<>();
                q5[i][j] = new ArrayList<>();
                q6[i][j] = new ArrayList<>();
                q7[i][j] = new ArrayList<>();
                q8[i][j] = new ArrayList<>();
                q9[i][j] = new ArrayList<>();
            }
        }
    }


        public ArrayList<Integer>[][] getQn(int auxiliaryQuadrant)
        {
            return switch (auxiliaryQuadrant) {
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

        public ArrayList<Integer>[][] setQn(ArrayList<Integer>[][] quadrant, int num)
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
