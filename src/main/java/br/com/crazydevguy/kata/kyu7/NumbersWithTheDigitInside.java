package br.com.crazydevguy.kata.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.LongStream;

import static java.util.stream.LongStream.of;
import static java.util.stream.LongStream.rangeClosed;
import static org.junit.jupiter.api.Assertions.*;


public class NumbersWithTheDigitInside {

    // Code from problem https://www.codewars.com/kata/57ad85bb7cb1f3ae7c000039

    // You have to search all numbers from inclusive 1 to inclusive a given number x, that have the given digit d in it.
    // You have to return as an array:
    //
    //  - the count of these numbers,
    //  - their sum
    //  - and their product.
    @Test
    void codeToWork() {
        assertArrayEquals(new long[] { 0, 0, 0 }, numbersWithDigitInside(5, 6));
        assertArrayEquals(new long[] { 1, 6, 6 }, numbersWithDigitInside(7, 6));
        assertArrayEquals(new long[] { 3, 22, 110 }, numbersWithDigitInside(11, 1));
        assertArrayEquals(new long[] { 2, 30, 200 }, numbersWithDigitInside(20, 0));
        assertArrayEquals(new long[] { 9, 286, 5955146588160L }, numbersWithDigitInside(44, 4));
    }

    // FIRST SOLUTION
    public static long[] numbersWithDigitInside(long x, long d) {
        long[] array = {0L, 0L, 1L};
        long count = 0;

        String valueToCompare = String.valueOf(d);

        for (int i = 1; i <= x; i++) {
            if (String.valueOf(i).contains(valueToCompare)) {
                array[0] = ++count;
                array[1] += i;
                array[2] *= i;
            }
        }

        if (array[0] == 0L) {
            array[2] = 0L;
        }
        return array;
    }

    // BETTER SOLUTION
    static long[] numbersWithDigitInsideBetterSolution(long x, long d) {
        long[] nums = rangeClosed(1, x).filter(i -> ("" + i).contains("" + d)).toArray();
        return new long[] {nums.length, of(nums).sum(), of(nums).reduce((a, b) -> a * b).orElse(0L)};
    }

    // BALANCED SOLUTION
    public static long[] NumbersWithDigitInside(long x, long d) {
        long[] list = LongStream.range(1, x+1).filter(l -> String.valueOf(l).contains(String.valueOf(d))).toArray();
        if(list.length == 0) return new long[]{0, 0, 0};
        LongStream longStream = Arrays.stream(list);
        return new long[]{list.length, longStream.sum(), Arrays.stream(list).reduce(1, (a, b) -> a * b)};
    }

}
