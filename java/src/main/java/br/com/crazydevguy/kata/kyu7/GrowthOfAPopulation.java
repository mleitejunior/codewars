package br.com.crazydevguy.kata.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrowthOfAPopulation {

    /**
     Code from problem https://www.codewars.com/kata/563b662a59afc2b5120000c6

     In a small town the population is p0 = 1000 at the beginning of a year. The population regularly increases by 2
     percent per year and moreover 50 new inhabitants per year come to live in the town. How many years does the town
     need to see its population greater or equal to p = 1200 inhabitants?
    **/

    @Test
    void codeToWork() {
        System.out.println("Fixed Tests: nbYear");
        assertEquals(nbYear(1500, 5, 100, 5000),15);
        assertEquals(nbYear(1500000, 2.5, 10000, 2000000), 10);
        assertEquals(nbYear(1500000, 0.25, 1000, 2000000), 94);
    }

    // FIRST SOLUTION
    public static int nbYear(int p0, double percent, int aug, int p) {
        int count = 0;
        int population = p0;

        do {
            count ++;
            population = (int)(population + population * percent / 100 + aug);
        } while (population < p);
        return count;
    }

    // BETTER SOLUTION
    public static int nbYearBetterSolution(int p0, double percent, int aug, int p) {
        if (p0>=p) return 0;
        else return nbYearBetterSolution((int) (p0+aug+p0*(percent/100)), percent, aug, p) + 1;
    }

    // BALANCED SOLUTION
    public static int nbYearBalancedSolution(int p0, double percent, int aug, int p) {
        int years = 0;
        while (p0 < p) {
            p0 += p0 * percent / 100 + aug;
            years++;
        }
        return years;
    }


}
