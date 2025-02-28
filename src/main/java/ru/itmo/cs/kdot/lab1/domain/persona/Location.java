package ru.itmo.cs.kdot.lab1.domain.persona;

import lombok.Getter;

import java.util.Map;
import java.util.Objects;

@Getter
public enum Location {
    IN_A_SPACESHIP("Космическом корабле"),
    IN_OPEN_SPACE("Открытый космос");
    private final String place;
    private final int oxygen;
    private static Map<String, String> enumMap;

    Location(String place) {
        this.place = place;
        if(Objects.equals(place, "Космическом корабле")){
            this.oxygen = 20;
        } else {
            this.oxygen = 0;
        }
    }

    public static Location findByValue(String value) {
        Location result;
        for (Location l : values()) {
            if (l.getPlace().equalsIgnoreCase(value)) {
                result = l;
                return result;
            }
        }
        throw new IllegalArgumentException("Такого здесь нет.");
    }
}
