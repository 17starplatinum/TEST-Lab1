package ru.itmo.cs.kdot.lab1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.itmo.cs.kdot.lab1.trig.functions.Sine;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TrigTest {
    Sine sine = new Sine();
    @ParameterizedTest(name = "sin({0})")
    @DisplayName("Trig Function Test 1: Zero Values")
    @ValueSource(doubles = {-PI, -0.5 * PI, 0, 0.5 * PI, PI})
    void checkPiValues(double param) {
        assertAll(
                () -> assertEquals(Math.sin(param), sine.calculate(param, 69), 0.001)
        );
    }

    @ParameterizedTest(name = "sin{0}")
    @DisplayName("Trig Function Test 2: Midway Values")
    @CsvFileSource(resources = "/table_values_sin.csv", numLinesToSkip = 1, delimiter = ',')
    void checkMidwayDots(double x, double y) {
        assertAll(
                () -> assertEquals(y, sine.calculate(x, 69), 0.001)
        );
    }
}
