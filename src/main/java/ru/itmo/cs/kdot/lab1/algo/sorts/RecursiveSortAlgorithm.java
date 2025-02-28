package ru.itmo.cs.kdot.lab1.algo.sorts;

import java.util.List;

public interface RecursiveSortAlgorithm {

    int[] sort(int[] array, int l, int r);

    default <K extends Comparable<? super K>, V> List<MapEntry<K, V>> sort(List<MapEntry<K, V>> map, int l, int r){
        throw new UnsupportedOperationException("Нет, не всегда.");
    }
}
