package br.com.crazydevguy.kata.kyu8;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfPositive {

    /**
    Code from problem https://www.codewars.com/kata/5715eaedb436cf5606000381

    Sum of only positive numbers from array
    **/
    @Test
    void codeToWork() {
        assertEquals(15, sum(new int[]{1,2,3,4,5}));
        assertEquals(13, sum(new int[]{1,-2,3,4,5}));
        assertEquals(0, sum(new int[]{}));
        assertEquals(0, sum(new int[]{-1,-2,-3,-4,-5}));
        assertEquals(9, sum(new int[]{-1,2,3,4,-5}));
    }

    // FIRST SOLUTION
    public static int sum(int[] arr){
        int acumulator = 0;
        for (int i : arr) {
            if (i > 0) {
                acumulator += i;
            }
        }
        return acumulator;
    }

    // BETTER SOLUTION:
    public static int sumBetterSolution(int[] arr){
        return Arrays.stream(arr).filter(v -> v > 0).sum();
    }
}
