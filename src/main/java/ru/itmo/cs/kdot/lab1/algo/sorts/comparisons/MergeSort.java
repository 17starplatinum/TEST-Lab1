package ru.itmo.cs.kdot.lab1.algo.sorts.comparisons;

import ru.itmo.cs.kdot.lab1.algo.sorts.MapEntry;
import ru.itmo.cs.kdot.lab1.algo.sorts.RecursiveSortAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements RecursiveSortAlgorithm {

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        System.arraycopy(arr, l, left, 0, n1);
        for (int j = 0; j < n2; ++j) {
            right[j] = arr[m + 1 + j];
        }

        int i = 0;
        int j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    private <K extends Comparable<? super K>, V> void merge(List<MapEntry<K, V>> map, int l, int m, int r) {
        List<MapEntry<K, V>> left = new ArrayList<>(map.subList(l, m + 1));
        List<MapEntry<K, V>> right = new ArrayList<>(map.subList(m + 1, r + 1));

        int i = 0;
        int j = 0;
        int k = l;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getKey().compareTo(right.get(j).getKey()) <= 0) {
                map.set(k++, left.get(i++));
            } else {
                map.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            map.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            map.set(k++, right.get(j++));
        }
    }

    @Override
    public int[] sort(int[] array, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(array, l, m);
            sort(array, m + 1, r);

            merge(array, l, m, r);
        }
        return array;
    }

    @Override
    public <K extends Comparable<? super K>, V> List<MapEntry<K, V>> sort(List<MapEntry<K, V>> map, int l, int r) {
        if(l > r) {
            int m = l + (r - l) / 2;

            sort(map, l, m);
            sort(map, m + 1, r);

            merge(map, l, m, r);
        }
        return map;
    }
}
