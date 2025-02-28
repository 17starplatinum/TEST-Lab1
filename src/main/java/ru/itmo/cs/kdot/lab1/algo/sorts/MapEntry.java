package ru.itmo.cs.kdot.lab1.algo.sorts;

import java.util.Objects;

public class MapEntry<K extends Comparable<? super K>, V> implements Comparable<MapEntry<K, V>> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
    public void setKey(K key) {
       this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
    public MapEntry(K key, V value) {
        this.key = Objects.requireNonNull(key);
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public int compareTo(MapEntry<K, V> o) {
        return this.key.compareTo(o.key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapEntry<?, ?> that = (MapEntry<?, ?>) o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }
}
