package ru.itmo.cs.kdot.lab1.domain.persona;

import lombok.Getter;
import lombok.Setter;
import ru.itmo.cs.kdot.lab1.domain.confetti.Confetti;
import ru.itmo.cs.kdot.lab1.domain.space.Space;
import ru.itmo.cs.kdot.lab1.domain.space.SpaceObject;

@Getter
@Setter
public class Persona extends SpaceObject {
    private Location location;
    private Space space;

    public Persona(String name, Space space) {
        super(name);
        this.location = Location.IN_A_SPACESHIP;
        this.space = space;
    }

    public String eject() {
        this.location = Location.IN_OPEN_SPACE;
        return this.name + " в " + this.location + "\n" + Confetti.scatter(this);
    }
}
