package ru.itmo.cs.kdot.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.itmo.cs.kdot.lab1.domain.air.Air;
import ru.itmo.cs.kdot.lab1.domain.confetti.Confetti;
import ru.itmo.cs.kdot.lab1.domain.engine.Engine;
import ru.itmo.cs.kdot.lab1.domain.persona.Location;
import ru.itmo.cs.kdot.lab1.domain.persona.Persona;
import ru.itmo.cs.kdot.lab1.domain.space.Color;
import ru.itmo.cs.kdot.lab1.domain.space.SkyObjects;
import ru.itmo.cs.kdot.lab1.domain.space.Space;

import static org.junit.jupiter.api.Assertions.*;

public class DomainTest {
    @Nested
    class TestCases {
        private Air air;
        private Confetti confetti;
        private Engine engine;
        private Persona p1;
        private Persona p2;
        private Space night;
        private Space moonlight;
        private Space dawn;
        private Space daylight;
        @BeforeEach
        void setUp() {
            night = new Space();
            air = new Air(night);
            engine = new Engine(false, air);
            p1 = new Persona("Форд", night);
            p2 = new Persona("Артур", night);
            moonlight = new Space("Пустота", Color.BLACK, SkyObjects.MOON);
            dawn = new Space("Пустота", Color.ORANGE, SkyObjects.SUN);
            daylight = new Space("Пустота", Color.BLUE, SkyObjects.SUN);
        }

        @Test
        @DisplayName("Domain Test 1: Air")
        void checkAirMovement(){
            assertAll(
                    () -> assertEquals("спокойный", air.getMovement()),
                    () -> assertEquals("Воздух ревёт\nЧёрная пустота с Яркими точками", air.rushOut())
            );
        }

        @Test
        @DisplayName("Domain Test 2: Confetti")
        void checkConfetti(){
            assertAll(
                    () -> assertEquals("Форд вылетел как конфетти.", Confetti.scatter(p1)),
                    () -> assertEquals("Артур вылетел как конфетти.", Confetti.scatter(p2))
            );
        }

        @Test
        @DisplayName("Domain Test 3: Engine")
        void checkEngine(){
            assertAll(
                    () -> assertEquals("Мотор", engine.getName()),
                    () -> assertFalse(engine.isState()),
                    () -> assertEquals("затих", engine.getSound())
            );
            engine.start();
            assertAll(
                    () -> assertEquals("Мотор", engine.getName()),
                    () -> assertTrue(engine.isState()),
                    () -> assertEquals("зажужжал", engine.getSound()),
                    () -> assertEquals("Мотор зажужжал", engine.start())
            );
        }

        @Test
        @DisplayName("Domain Test 4: Characters")
        void checkCharacters(){
            assertAll(
                    () -> assertEquals(Location.IN_A_SPACESHIP, p1.getLocation()),
                    () -> assertEquals(Location.IN_A_SPACESHIP, p2.getLocation()),
                    () -> assertEquals(Color.BLACK, p1.getSpace().getColor()),
                    () -> assertEquals(Color.BLACK, p2.getSpace().getColor())
            );
            p1.setLocation(Location.IN_OPEN_SPACE);
            p2.setLocation(Location.IN_OPEN_SPACE);
            assertAll(
                    () -> assertEquals(Location.IN_OPEN_SPACE, p1.getLocation()),
                    () -> assertEquals(Location.IN_OPEN_SPACE, p2.getLocation()),
                    () -> assertEquals(Color.BLACK, p1.getSpace().getColor()),
                    () -> assertEquals(Color.BLACK, p2.getSpace().getColor())
            );
            p1.setSpace(dawn);
            p2.setSpace(daylight);
            assertAll(
                    () -> assertEquals(Color.ORANGE, p1.getSpace().getColor()),
                    () -> assertEquals(Color.BLUE, p2.getSpace().getColor())
            );
        }

        @Test
        @DisplayName("Domain Test 5: Location")
        void checkLocation(){
            assertAll(
                    () -> assertEquals("Космическом корабле", Location.IN_A_SPACESHIP.getPlace()),
                    () -> assertEquals("Открытый космос", Location.IN_OPEN_SPACE.getPlace()),
                    () -> assertEquals(20, Location.IN_A_SPACESHIP.getOxygen()),
                    () -> assertEquals(0, Location.IN_OPEN_SPACE.getOxygen()),
                    () -> assertEquals(Location.IN_A_SPACESHIP, Location.findByValue("КОСМИЧЕСКОМ КОРАБЛЕ")),
                    () -> assertEquals(Location.IN_OPEN_SPACE, Location.findByValue("ОТКРЫТЫЙ КОСМОС"))
            );
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> Location.findByValue("Соледар"));
            assertEquals("Такого здесь нет.", exception.getMessage());
        }

        @Test
        @DisplayName("Domain Test 6: Color")
        void checkColor(){
            assertAll(
                    () -> assertEquals("Чёрная", Color.BLACK.getColorName()),
                    () -> assertEquals("Оранжевая", Color.ORANGE.getColorName()),
                    () -> assertEquals("Синяя", Color.BLUE.getColorName()),
                    () -> assertEquals(Color.BLACK, Color.findByValue("чёрная")),
                    () -> assertEquals(Color.ORANGE, Color.findByValue("ОрАнЖеВаЯ")),
                    () -> assertEquals(Color.BLUE, Color.findByValue("сИНЯЯ"))
            );
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> Color.findByValue("Пергидрольная блондинка"));
            assertEquals("Такого здесь нет.", exception.getMessage());
        }

        @Test
        @DisplayName("Domain Test 7: Celestial Objects")
        void checkCelestialObject(){
            assertAll(
                    () -> assertEquals("Солнцем", SkyObjects.SUN.getObject()),
                    () -> assertEquals("Луной", SkyObjects.MOON.getObject()),
                    () -> assertEquals("Яркими точками", SkyObjects.STARS.getObject()),
                    () -> assertEquals(SkyObjects.SUN, SkyObjects.findByValue("солнцеМ")),
                    () -> assertEquals(SkyObjects.MOON, SkyObjects.findByValue("лУНой")),
                    () -> assertEquals(SkyObjects.STARS, SkyObjects.findByValue("яркими ТОЧКАМИ"))
            );
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> SkyObjects.findByValue("Тёмный рыцарь"));
            assertEquals("Такого здесь нет.", exception.getMessage());
        }
        @Test
        @DisplayName("Domain Test 8: Space")
        void checkSpace(){
            assertAll(
                    () -> assertEquals("Пустота", night.getName()),
                    () -> assertEquals("Пустота", moonlight.getName()),
                    () -> assertEquals("Пустота", dawn.getName()),
                    () -> assertEquals("Пустота", daylight.getName()),
                    () -> assertEquals("Чёрная пустота с Яркими точками", night.describe()),
                    () -> {
                        night.setSkyObjects(SkyObjects.MOON);
                        assertEquals(SkyObjects.MOON, night.getSkyObjects());
                    },
                    () -> {
                        night.setColor(Color.ORANGE);
                        assertEquals(Color.ORANGE, night.getColor());
                    },
                    () -> assertEquals("Оранжевая пустота с Луной", night.describe())
            );
        }
    }
}
