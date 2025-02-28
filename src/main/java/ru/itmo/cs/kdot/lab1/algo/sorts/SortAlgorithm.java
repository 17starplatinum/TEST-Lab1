package ru.itmo.cs.kdot.lab1.algo.sorts;

import java.util.List;

public interface SortAlgorithm {
    int[] sort(int[] array);

    <K extends Comparable<? super K>, V> List<MapEntry<K, V>> sort(List<MapEntry<K, V>> map);
}
