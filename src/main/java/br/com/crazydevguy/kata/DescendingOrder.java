package br.com.crazydevguy.kata;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


public class DescendingOrder {

    @Test
    void codeToWork() {
        assertEquals(0, DescendingOrder.sortDesc(0));
        assertEquals(51, DescendingOrder.sortDesc(15));
        assertEquals(987654321, DescendingOrder.sortDesc(123456789));

        assertEquals(0, DescendingOrder.bestSortDesc01(0));
        assertEquals(51, DescendingOrder.bestSortDesc01(15));
        assertEquals(987654321, DescendingOrder.bestSortDesc01(123456789));

        assertEquals(0, DescendingOrder.bestSortDesc02(0));
        assertEquals(51, DescendingOrder.bestSortDesc02(15));
        assertEquals(987654321, DescendingOrder.bestSortDesc02(123456789));
    }

    public static int sortDesc(final int num) {
        Object[] chars = String.valueOf(num).chars().mapToObj(e -> (char)e).collect(Collectors.toList()).toArray();

        Arrays.sort(chars, Collections.reverseOrder());

        String convertedCharsToString = "";

        for (Object o : chars) {
            convertedCharsToString += o.toString();
        }


        return Integer.valueOf(convertedCharsToString);
    }

    public static int bestSortDesc01(final int num) {
        return Integer.parseInt(String.valueOf(num)
                .chars()
                .mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }

    public static int bestSortDesc02(final int num) {
        String[] array = String.valueOf(num).split("");
        Arrays.sort(array, Collections.reverseOrder());
        return Integer.parseInt(String.join("", array));
    }

}
