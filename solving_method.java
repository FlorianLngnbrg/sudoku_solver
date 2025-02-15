package Sudoku;

import java.util.ArrayList;
    /*
    q1: _ q2, q3, | q4, q7
    q2: _ q1, q3, | q5, q8
    q3: _ q1, q2, | q6, q9

    q4: _ q5, q6, | q1, q7
    q5: _ q4, q6, | q2, q8
    q6: _ q4, q5, | q3, q9

    q7: _ q8, q9, | q1, q4
    q8: _ q7, q9, | q2, q5
    q9: _ q7, q8, | q6, q3
     */

public class solving_method
{
    private unsolved_sudoku s;
    private auxiliaryLayer ax;

    public solving_method(unsolved_sudoku sudoku, auxiliaryLayer ax)
    {
        this.s = sudoku;
        this.ax = ax;
    }

    public void solvingMethod()
    {
        while(hasNull())
        {
            createAuxiliaryLayer();
            iqCompare();
        }
    }

    public void createAuxiliaryLayer()
    {
            for (int qN = 1; qN < 10; qN++) {
                for (int qNy = 0; qNy < 3; qNy++) {
                    for (int qNx = 0; qNx < 3; qNx++) {
                        if (pruefeNull(qN, qNy, qNx)) {
                            ArrayList<Integer>[][] axLQ = ax.getQn(qN);

                            axLQ[qNy][qNx] = auxiliaryNumbers(qN, qNy, qNx);

                            if (axLQ[qNy][qNx].size() == 1) {
                                int[][] opt = s.getQn(qN);

                                opt[qNy][qNx] = axLQ[qNy][qNx].getFirst();

                                s.setQn(opt, qN);
                                createAuxiliaryLayer();
                            }
                        }
                    }
                }
            }
    }

    public void iqCompare()
    {
        for (int qN = 1; qN < 10; qN++) {
            for (int qNy = 0; qNy < 3; qNy++) {
                for (int qNx = 0; qNx < 3; qNx++) {
                    if(!AUXpruefeNull(qN, qNy, qNx))
                    {
                        ArrayList<Integer>[][] axQn = ax.getQn(qN);

                        for(int i=0; i<axQn[qNy][qNx].size(); i++)
                        {
                            if(checkAuxiliaryNumber(qN, axQn[qNy][qNx].get(i), qNy, qNx))
                            {
                                int[][] opt = s.getQn(qN);

                                opt[qNy][qNx] = axQn[qNy][qNx].get(i);
                                axQn[qNy][qNx] = new ArrayList<>();

                                s.setQn(opt, qN);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean pruefeNull(int qN, int qNy, int qNx)
    {
        int[][] z = s.getQn(qN);

        return z[qNy][qNx] == 0;
    }

    public boolean AUXpruefeNull(int qN, int qNy, int qNx)
    {
        ArrayList<Integer>[][] z = ax.getQn(qN);

        return z[qNy][qNx].isEmpty();
    }

    public ArrayList<Integer> auxiliaryNumbers(int qN, int qNy, int qNx)
    {
        ArrayList<Integer> boxAuxiliaryNumbers = new ArrayList<>();

        for(int i = 1; i<10; i++)
        {
            boolean quad = checkQuadrant(qN, i);
            boolean line = checkLine(qN, qNy, i);
            boolean split = checkSplit(qN, qNx, i);

            if(!quad && !line && !split)
            {
                boxAuxiliaryNumbers.add(i);
            }
        }
        return boxAuxiliaryNumbers;
    }

    public boolean checkSplit(int quadrant, int x, int num)
    {
        if(quadrant == 1 || quadrant == 2 || quadrant == 3)
        {
            int[][] aa = s.getQn(quadrant + 3);
            int[][] ab = s.getQn(quadrant + 6);

            for(int a = 0; a<3; a++)
            {
                if((aa[a][x] == num) || (ab[a][x] == num))
                {
                    return true;
                }
            }
        }
        else if(quadrant == 4 || quadrant == 5 || quadrant == 6)
        {
            int[][] aa = s.getQn(quadrant - 3);
            int[][] ab = s.getQn(quadrant + 3);

            for(int a = 0; a<3; a++)
            {
                if((aa[a][x] == num) || (ab[a][x] == num))
                {
                    return true;
                }
            }
        }
        else if(quadrant == 7 || quadrant == 8 || quadrant == 9)
        {
            int[][] aa = s.getQn(quadrant - 3);
            int[][] ab = s.getQn(quadrant - 6);

            for(int a = 0; a<3; a++)
            {
                if((aa[a][x] == num) || (ab[a][x] == num))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkLine(int quadrant, int y, int num)
    {
        if(quadrant == 2 || quadrant == 5 || quadrant == 8)
        {
            int[][] aa = s.getQn(quadrant - 1);
            int[][] ab = s.getQn(quadrant + 1);

            for(int a = 0; a<3; a++)
            {
                if(aa[y][a] == num || ab[y][a] == num)
                {
                    return true;
                }
            }
        }
        else if(quadrant == 1 || quadrant == 4 || quadrant == 7)
        {
            int[][] aa = s.getQn(quadrant + 1);

            int[][] ab = s.getQn(quadrant + 2);

            for(int a = 0; a<3; a++)
            {
                if(aa[y][a] == num || ab[y][a] == num)
                {
                    return true;
                }
            }
        }
        else if(quadrant == 3 || quadrant == 6 || quadrant == 9)
        {
            int[][] aa = s.getQn(quadrant - 1);
            int[][] ab = s.getQn(quadrant - 2);

            for(int a = 0; a<3; a++)
            {
                if(aa[y][a] == num || ab[y][a] == num)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkQuadrant(int quadrant, int num)
    {
        int[][] qN = s.getQn(quadrant);

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(qN[i][j] == num)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkAuxiliaryNumber(int AuxQuadrant, int num, int axQy, int axQx)
    {
        if(!AXcompareCheckQuadrant(AuxQuadrant, num, axQy, axQx)) {return true;}
        if(!AXcompareCheckSplit(AuxQuadrant, axQx, num)) {return true;}
        if(!AXcompareCheckLine(AuxQuadrant, axQy, num)) {return true;}

        return false;
    }

    public boolean compareAuxiliaryBoxes(ArrayList<Integer> a1, int num) { return a1.contains(num); }

    public boolean AXcompareCheckQuadrant(int AuxQuadrant, int num, int axQy, int axQx)
    {
        // muss false sein
        ArrayList<Integer>[][] axN = ax.getQn(AuxQuadrant);

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(axQy == i && axQx == j) continue;
                if((!axN[i][j].isEmpty()))
                {
                    if(compareAuxiliaryBoxes(axN[i][j], num))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean AXcompareCheckSplit(int quadrant, int x, int num)
    {
        if(quadrant == 1 || quadrant == 2 || quadrant == 3)
        {
            ArrayList<Integer>[][] aa = ax.getQn(quadrant + 3);
            ArrayList<Integer>[][] ab = ax.getQn(quadrant + 6);

            for(int a = 0; a<3; a++)
            {
                if((compareAuxiliaryBoxes(aa[a][x], num)) || (compareAuxiliaryBoxes(ab[a][x], num)))
                {
                    return true;
                }
            }
        }
        else if(quadrant == 4 || quadrant == 5 || quadrant == 6)
        {
            ArrayList<Integer>[][] aa = ax.getQn(quadrant - 3);
            ArrayList<Integer>[][] ab = ax.getQn(quadrant + 3);

            for(int a = 0; a<3; a++)
            {
                if((compareAuxiliaryBoxes(aa[a][x], num)) || (compareAuxiliaryBoxes(ab[a][x], num)))
                {
                    return true;
                }
            }
        }
        else if(quadrant == 7 || quadrant == 8 || quadrant == 9)
        {
            ArrayList<Integer>[][] aa = ax.getQn(quadrant - 3);
            ArrayList<Integer>[][] ab = ax.getQn(quadrant - 6);

            for(int a = 0; a<3; a++)
            {
                if((compareAuxiliaryBoxes(aa[a][x], num)) || (compareAuxiliaryBoxes(ab[a][x], num)))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean AXcompareCheckLine(int quadrant, int y, int num)
    {
        if(quadrant == 2 || quadrant == 5 || quadrant == 8)
        {
            ArrayList<Integer>[][] aa = ax.getQn(quadrant - 1);
            ArrayList<Integer>[][] ab = ax.getQn(quadrant + 1);

            for(int a = 0; a<3; a++)
            {
                if((compareAuxiliaryBoxes(aa[y][a], num)) || (compareAuxiliaryBoxes(ab[y][a], num)))
                {
                    return true;
                }
            }
        }
        else if(quadrant == 1 || quadrant == 4 || quadrant == 7)
        {
            ArrayList<Integer>[][] aa = ax.getQn(quadrant + 1);

            ArrayList<Integer>[][] ab = ax.getQn(quadrant + 2);

            for(int a = 0; a<3; a++)
            {
                if((compareAuxiliaryBoxes(aa[y][a], num)) || (compareAuxiliaryBoxes(ab[y][a], num)))
                {
                    return true;
                }
            }
        }
        else if(quadrant == 3 || quadrant == 6 || quadrant == 9)
        {
            ArrayList<Integer>[][] aa = ax.getQn(quadrant - 1);
            ArrayList<Integer>[][] ab = ax.getQn(quadrant - 2);

            for(int a = 0; a<3; a++)
            {
                if((compareAuxiliaryBoxes(aa[y][a], num)) || (compareAuxiliaryBoxes(ab[y][a], num)))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public unsolved_sudoku getS() {
        return s;
    }

    public void setS(unsolved_sudoku s) {
        this.s = s;
    }

    public boolean hasNull()
    {
        boolean a = false;
        for(int qN=1; qN < 10; qN++)
        {
            for(int qNy=0; qNy < 3; qNy++)
            {
                for(int qNx=0; qNx < 3; qNx++)
                {
                    if(pruefeNull(qN, qNy, qNx))
                    {
                        a = true;
                        break;
                    }
                }
            }
        }
        return a;
    }
}