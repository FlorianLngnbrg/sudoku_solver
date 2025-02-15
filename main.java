package Sudoku;

import java.util.Arrays;
import java.util.ArrayList;

public class main
{
    public static void main(String[] args)
    {
        unsolved_sudoku s = new unsolved_sudoku();
        auxiliaryLayer Aux = new auxiliaryLayer();

        solving_method solve = new solving_method(s, Aux);

        // System.out.println(solve.createAuxiliaryLayer());

        s.toString2();
        
        System.out.println(" ");
        System.out.println("------------------------------------------------");
        System.out.println(" ");

        solve.solvingMethod();

        System.out.println(" ");
        System.out.println("------------------------------------------------");
        System.out.println(" ");

        s.toString2();
    }
}
