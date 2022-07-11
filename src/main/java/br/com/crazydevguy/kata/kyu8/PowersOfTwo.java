package br.com.crazydevguy.kata.kyu8;

import org.junit.jupiter.api.Test;

import static java.util.stream.LongStream.rangeClosed;

import static org.junit.jupiter.api.Assertions.*;


public class PowersOfTwo {

    // Code from problem https://www.codewars.com/kata/57a083a57cb1f31db7000028

    // Complete the function that takes a non-negative integer n as input, and returns a list of all the powers of 2
    // with the exponent ranging from 0 to n ( inclusive ).
    @Test
    void codeToWork() {
        assertArrayEquals(new long[]{1}, powersOfTwo(0));
        assertArrayEquals(new long[]{1,2}, powersOfTwo(1));
        assertArrayEquals(new long[]{1,2,4,8,16}, powersOfTwo(4));
    }

    // FIRST SOLUTION
    public static long[] powersOfTwo(int n){
        long[] result = new long[n+1];
        for (int i = 0; i < n+1; i++) {
            result[i] = (long) Math.pow(2.0, i);
        }
        return result;
    }

    // BETTER SOLUTION
    public static long[] powersOfTwoBetterSolution(int n){
        return rangeClosed(0, n).map(i -> (long) Math.pow(2, i)).toArray();
    }

}
