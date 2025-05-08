package br.com.crazydevguy.kata.kyu8;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HowGoodAreYouReally {

    /**
    Code from problem https://www.codewars.com/kata/5601409514fc93442500010b
    Get if number is >= average numbers in array (including itself)
    **/
    @Test
    void codeToWork() {
        assertEquals(true, betterThanAverage(new int[] {2, 3}, 5));
        assertEquals(true, betterThanAverage(new int[] {100, 40, 34, 57, 29, 72, 57, 88}, 75));
        assertEquals(true, betterThanAverage(new int[] {12, 23, 34, 45, 56, 67, 78, 89, 90}, 69));
        assertEquals(false, betterThanAverage(new int[] {100, 90}, 11));
    }

    // FIRST SOLUTION
    public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
        double accumulator = 0;
        for (int classPoint : classPoints) {
            accumulator += classPoint;
        }

        return yourPoints >= (accumulator + yourPoints) / (classPoints.length + 1);
    }

    //BETTER SOLUTION:
    static boolean betterThanAverageBetterSolution(final int[] classPoints, final int yourPoints) {
        return Arrays.stream(classPoints).average().orElse(0) < yourPoints;
    }
}
