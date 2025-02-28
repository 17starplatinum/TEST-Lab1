package ru.itmo.cs.kdot.lab1.domain.space;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum SkyObjects {
    SUN("Солнцем"),
    MOON("Луной"),
    STARS("Яркими точками");
    private final String object;
    private static Map<String, String> enumMap;

    public static SkyObjects findByValue(String value) {
        SkyObjects result;
        for (SkyObjects l : values()) {
            if (l.getObject().equalsIgnoreCase(value)) {
                result = l;
                return result;
            }
        }
        throw new IllegalArgumentException("Такого здесь нет.");
    }
}
