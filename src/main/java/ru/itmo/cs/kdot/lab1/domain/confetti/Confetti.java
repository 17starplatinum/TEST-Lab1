package ru.itmo.cs.kdot.lab1.domain.confetti;

import lombok.Getter;
import lombok.Setter;
import ru.itmo.cs.kdot.lab1.domain.persona.Persona;

@Getter
@Setter
public class Confetti {
    private Confetti() {
        throw new IllegalStateException("Пошёл нах)))");
    }
    public static String scatter(Persona persona) {
        return persona.getName() + " вылетел как конфетти.";
    }
}
