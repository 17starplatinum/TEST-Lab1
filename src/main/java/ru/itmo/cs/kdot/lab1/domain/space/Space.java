package ru.itmo.cs.kdot.lab1.domain.space;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Space extends SpaceObject{
    private Color color;
    private SkyObjects skyObjects;

    public Space() {
        super("Пустота");
        this.color = Color.BLACK;
        this.skyObjects = SkyObjects.STARS;
    }

    public Space(String name, Color color, SkyObjects skyObjects) {
        super(name);
        this.color = color;
        this.skyObjects = skyObjects;
    }

    public String describe() {
        return color.getColorName() + " пустота с " + skyObjects.getObject();
    }
}
