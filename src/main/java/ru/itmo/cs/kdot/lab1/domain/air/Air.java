package ru.itmo.cs.kdot.lab1.domain.air;

import lombok.Getter;
import lombok.Setter;
import ru.itmo.cs.kdot.lab1.domain.space.Space;
import ru.itmo.cs.kdot.lab1.domain.space.SpaceObject;

@Getter
@Setter
public class Air extends SpaceObject {
    private String movement;
    private Space space;

    public Air(Space space) {
        super("Воздух");
        this.movement = "спокойный";
        this.space = space;
    }
    public String rushOut() {
        this.movement = "ревёт";
        return "Воздух " + this.movement + "\n" + space.describe();
    }
}
