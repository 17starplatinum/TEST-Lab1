package ru.itmo.cs.kdot.lab1.algo.sorts.comparisons;

import ru.itmo.cs.kdot.lab1.algo.sorts.MapEntry;
import ru.itmo.cs.kdot.lab1.algo.sorts.SortAlgorithm;

import java.util.List;

public class InsertionSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Зачем хочешь сортировать пустой массив, лошара?)");
        }
        for(int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > key){
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

    public <K extends Comparable<? super K>, V> List<MapEntry<K, V>> sort(List<MapEntry<K, V>> map) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("Зачем хочешь сортировать пустую словарь, лошара?)");
        }
        for(int i = 1; i < map.size(); i++) {
            MapEntry<K, V> index = map.get(i);
            int j = i - 1;

            while(j >= 0 && map.get(j).getKey().compareTo(index.getKey()) > 0) {
                map.set(j + 1, map.get(j));
                j = j - 1;
            }
            map.set(j + 1, index);
        }
        return map;
    }
}
