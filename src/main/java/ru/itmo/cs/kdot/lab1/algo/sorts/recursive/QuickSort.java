package ru.itmo.cs.kdot.lab1.algo.sorts.recursive;

import ru.itmo.cs.kdot.lab1.algo.sorts.RecursiveSortAlgorithm;

public class QuickSort implements RecursiveSortAlgorithm {
    int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[j] ^ arr[i];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[j] ^ arr[i];
    }

    @Override
    public int[] sort(int[] array, int l, int r){
        if (l < r) {

            int pi = partition(array, l, r);

            sort(array, l, pi - 1);
            sort(array, pi + 1, r);
        }
        return array;
    }

}
