package ru.itmo.cs.kdot.lab1.domain.space;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum Color {
    BLACK("Чёрная"),
    BLUE("Синяя"),
    ORANGE("Оранжевая");

    private final String colorName;
    private static Map<String, String> enumMap;

    public static Color findByValue(String value) {
        Color result;
        for (Color l : values()) {
            if (l.getColorName().equalsIgnoreCase(value)) {
                result = l;
                return result;
            }
        }
        throw new IllegalArgumentException("Такого здесь нет.");
    }
}
