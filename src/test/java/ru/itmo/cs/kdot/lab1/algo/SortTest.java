package ru.itmo.cs.kdot.lab1.algo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itmo.cs.kdot.lab1.algo.sorts.MapEntry;
import ru.itmo.cs.kdot.lab1.algo.sorts.comparisons.InsertionSort;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    InsertionSort insertionSort = new InsertionSort();
    public static class ArraysForTest {
        final int[] arr;
        final int[] sorted;

        public ArraysForTest(int[] arr, int[] sorted) {
            this.arr = arr;
            this.sorted = sorted;
        }
    }

    public static ArraysForTest sortRandomArray(int len, boolean pos) {
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = (pos) ? random.nextInt(100) : -random.nextInt(100);
        }
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        return new ArraysForTest(arr, sorted);
    }

    @Test
    @DisplayName("Test for a random array consisting of positive values")
    void checkRandomSorting() {
        ArraysForTest arraysForTest = sortRandomArray(10, true);
        assertAll(
                () -> assertArrayEquals(arraysForTest.sorted, insertionSort.sort(arraysForTest.arr))
        );
    }

    @Test
    @DisplayName("Test for a random array consisting of hardcoded values")
    void checkRandomHardcodedSorting() {
        assertAll(
                () -> assertArrayEquals(new int[]{2, 7, 16, 21}, insertionSort.sort(new int[]{16, 21, 2, 7})),
                () -> assertArrayEquals(new int[]{1, 5, 6, 9, 12, 16, 17, 36, 46, 49}, insertionSort.sort(new int[]{1, 12, 49, 5, 6, 16, 46, 17, 36, 9})),
                () -> assertArrayEquals(new int[]{1, 3, 5, 9, 12, 14, 15, 16, 18, 20, 21, 22, 25, 27, 28, 29, 36, 37, 38, 40, 41, 46, 47, 48, 49, 51, 53, 54, 58, 59, 60, 61, 64, 67, 68, 70, 73, 80, 81, 82, 83, 85, 86, 87, 91, 92, 94, 95, 96, 99}, insertionSort.sort(new int[]{3, 70, 28, 29, 36, 37, 1, 38, 5, 9, 12, 14, 15, 16, 99, 40, 41, 46, 54, 58, 59, 73, 94, 95, 96, 81, 82, 83, 85, 86, 87, 80, 47, 48, 49, 64, 67, 68, 91, 92, 21, 22, 25, 27, 51, 53, 18, 20, 60, 61}))
        );
    }

    @Test
    @DisplayName("Test for an array consisting of zeroes")
    void checkZeroSorting() {
        assertAll(
                () -> assertArrayEquals(new int[]{0, 0, 0, 0, 0}, insertionSort.sort(new int[]{0, 0, 0, 0, 0}))
        );
    }

    @Test
    @DisplayName("Test for a random array consisting of non-positive random values")
    void checkRandomNonPositiveSorting() {
        ArraysForTest arraysForTest = sortRandomArray(10, false);
        assertAll(
                 () -> assertArrayEquals(arraysForTest.sorted, insertionSort.sort(arraysForTest.arr))
        );
    }

    @Test
    @DisplayName("Test for a random array consisting of non-positive random hardcoded values")
    void checkRandomNonPositiveHardcodedSorting() {
        assertAll(
                () -> assertArrayEquals(new int[]{-97, -80, -66, -51, -46, -38, -35, -34, -17, -6}, insertionSort.sort(new int[]{-97, -80, -51, -6, -17, -34, -46, -66, -38, -35})),
                () -> assertArrayEquals(new int[]{-297, -256, -243, -230, -228, -207, -205, -199, -197, -169, -156, -146, -101, -98, -87,-45, -21, -20, -10, -3}, insertionSort.sort(new int[]{-297, -197, -228, -230, -199, -20, -45, -256, -10, -146, -101, -3, -243, -87, -207, -21, -205, -169, -156, -98})),
                () -> assertArrayEquals(new int[]{-299, -296, -285, -284, -260, -250, -245, -227, -223, -207, -181, -163, -155, -142, -128, -121, -111, -106, -94, -91, -79, -63, -51, -47, -43, -29, -27, -21, -20, -3}, insertionSort.sort(new int[]{-121, -21, -20, -284, -260, -250, -245, -299, -227, -223, -207, -181, -163, -155, -43, -296, -285, -142, -128, -63, -51, -47, -29, -27, -3, -111, -106, -94, -91, -79}))
        );
    }

    @Test
    @DisplayName("Test for empty arrays")
    void checkEmptyArrays() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> insertionSort.sort(new int[]{})),
                () -> assertThrows(IllegalArgumentException.class, () -> insertionSort.sort((int[]) null))
        );
    }

    @Test
    @DisplayName("Test for sorting stability")
    void checkSortingStability() {
        InsertionSort sort = new InsertionSort();
        Random rand = new Random();
        List<MapEntry<Integer, String>> list = new ArrayList<>(10);
        list.add(new MapEntry<>(69, String.valueOf((char)('a' + rand.nextInt(26)))));
        for(int i = 0; i < 7; i++) {
            char randomLetter = (char)('a' + rand.nextInt(26));
            list.add(new MapEntry<>(rand.nextInt(100), String.valueOf(randomLetter)));
        }
        list.add(new MapEntry<>(69, String.valueOf((char)('a' + rand.nextInt(26)))));
        list.add(new MapEntry<>(69, String.valueOf((char)('a' + rand.nextInt(26)))));

        List<MapEntry<Integer, String>> sortedList = sort.sort(list);
        Collections.sort(list);

        assertEquals(sortedList, list);
    }
}
