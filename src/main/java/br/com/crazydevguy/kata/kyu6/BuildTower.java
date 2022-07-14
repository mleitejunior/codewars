package br.com.crazydevguy.kata.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BuildTower {

    /**
     Code from problem https://www.codewars.com/kata/576757b1df89ecf5bd00073b

     Build a pyramid-shaped tower given a positive integer number of floors. A tower block is represented with "*" character.

     For example, a tower with 3 floors looks like this:

     [
     "  *  ",
     " *** ",
     "*****"
     ]
     **/
    @Test
    void codeToWork() {
        assertEquals(String.join(",", "*"), String.join(",", towerBuilder(1)));
        assertEquals(String.join(",", " * ", "***"), String.join(",", towerBuilder(2)));
        assertEquals(String.join(",", "  *  ", " *** ", "*****"), String.join(",", towerBuilder(3)));
    }

    // FIRST SOLUTION
    public static String[] towerBuilder(int nFloors) {
        String[] array = new String[nFloors];
        IntStream.rangeClosed(1, nFloors).forEach(i -> array[i-1] = String.join("", Collections.nCopies(i * 2 - 1, "*")));
        for (int i = 0; i < array.length; i++) {
            while (array[i].length() < nFloors * 2 - 1) {
                array[i] = " " + array[i] + " ";
            }
        }

        return array;
    }

    // BETTER SOLUTION
    public static String[] towerBuilderBetterSolution(int f) {
        return range(0, f).mapToObj(i -> String.format("%1$s%2$s%1$s", " ".repeat(f - i - 1), "*".repeat(2 * i + 1))).toArray(String[]::new);
    }

    // BALANCED SOLUTION
    public static String[] towerBuilderBalancedSolution(int n) {

        String t[] = new String[n], e;

        for (int i = 0; i < n; i++)
            t[i] = (e = " ".repeat(n-i-1)) + "*".repeat(i+i+1) + e;

        return t;
    }
}
