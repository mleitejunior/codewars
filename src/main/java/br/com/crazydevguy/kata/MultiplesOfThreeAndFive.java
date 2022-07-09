package br.com.crazydevguy.kata;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


public class MultiplesOfThreeAndFive {

    @Test
    void codeToWork() {
        assertEquals(23, solution(10));
        assertEquals(23, bestSolution(10));
    }

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

    public int bestSolution(int number) {
        return IntStream.range(0, number)
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .sum();
    }
}
