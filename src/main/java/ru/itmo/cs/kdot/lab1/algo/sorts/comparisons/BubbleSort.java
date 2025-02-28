package ru.itmo.cs.kdot.lab1.algo.sorts.comparisons;

import ru.itmo.cs.kdot.lab1.algo.sorts.MapEntry;
import ru.itmo.cs.kdot.lab1.algo.sorts.SortAlgorithm;

import java.util.List;

public class BubbleSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] array) {
        int i, j, tmp;
        boolean swap;
        for (i = 0; i < array.length - 1; i++) {
            swap = false;
            for (j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return array;
    }

    @Override
    public <K extends Comparable<? super K>, V> List<MapEntry<K, V>> sort(List<MapEntry<K, V>> map) {
        return List.of();
    }
}
