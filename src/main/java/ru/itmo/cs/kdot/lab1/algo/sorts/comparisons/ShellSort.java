package ru.itmo.cs.kdot.lab1.algo.sorts.comparisons;

import ru.itmo.cs.kdot.lab1.algo.sorts.MapEntry;
import ru.itmo.cs.kdot.lab1.algo.sorts.SortAlgorithm;

import java.util.List;

public class ShellSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] array) {
        for(int gap = array.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < array.length; i++) {
                int tmp = array[i], j;
                for(j = i - gap; j >= 0; j -= gap) {
                    if(tmp < array[j]) {
                        array[j + gap] = array[j];
                    }
                }
                array[j + gap] = tmp;
            }
        }
        return array;
    }

    @Override
    public <K extends Comparable<? super K>, V> List<MapEntry<K, V>> sort(List<MapEntry<K, V>> map) {
        return List.of();
    }
}
