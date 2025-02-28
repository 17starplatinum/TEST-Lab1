package ru.itmo.cs.kdot.lab1.domain.engine;

import lombok.Getter;
import ru.itmo.cs.kdot.lab1.domain.air.Air;
import ru.itmo.cs.kdot.lab1.domain.space.SpaceObject;

@Getter
public class Engine extends SpaceObject {
    private boolean state;
    private String sound;
    private Air air;

    public Engine(boolean state, Air air) {
        super("Мотор");
        this.state = state;
        this.sound = (state) ? "зажужжал" : "затих";
        this.air = air;
    }
    public String start() {
        this.state = true;
        this.sound = "зажужжал";
        air.rushOut();
        return "Мотор " + this.sound;
    }
}
