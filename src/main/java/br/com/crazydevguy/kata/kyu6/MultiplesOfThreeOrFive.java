package br.com.crazydevguy.kata.kyu6;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


public class MultiplesOfThreeOrFive {

    // Code from problem https://www.codewars.com/kata/514b92a657cdc65150000006

    // Sum of all the multiples of 3 or 5 below the number passed in (if negative, return 0)
    @Test
    void codeToWork() {
        assertEquals(23, solution(10));
        assertEquals(23, solutionBetterSolution(10));
    }

    // FIRST SOLUTION
    public int solution(int number) {
        int sum = 0;
        List<Integer> numsToCheckDivisor = List.of(3, 5);

        for (int i = 1; i < number; i++) {
            for (Integer n : numsToCheckDivisor) {
                if (i >= n && i % n == 0) {
                    sum += i;
                    break;
                }
            }
        }

        return sum;
    }

    // BETTER SOLUTION
    public int solutionBetterSolution(int number) {
        return IntStream.range(0, number)
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .sum();
    }
}
