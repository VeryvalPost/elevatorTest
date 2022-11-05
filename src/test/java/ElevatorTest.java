import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class ElevatorTest {

    @BeforeAll
    static void init() {
        System.out.println("tests initialization");
    }

    @AfterAll
    static void stop() {
        System.out.println("tests complete");
    }


    @Test
    public void correctCalculate() {

        // given:
        String start = "3";//обозначение необходимого этажа
        Queue<Integer> stop = new LinkedList<>();   // необязательный параметр. Нужен, чтоб работал метод.
        stop.add(3);
        int expected = 25;

        // when:
        int result = Main.pressButton(start, stop);

        // then:
        assertEquals(expected, result);
    }

    @Test
    public void ifNotExist() {
        // в случае, если этаж не существует должно пройти сообщение об этом, но тест "упасть" не должен
        // given:
        String start = "33";//обозначение необходимого этажа
        Queue<Integer> stop = new LinkedList<>();   // необязательный параметр. Нужен, чтоб работал метод.
        stop.add(3);
        int expected = 0;

        // when:
        int result = Main.pressButton(start, stop);

        // then:
        assertEquals(expected, result);

    }

    @Test
    public void ifAlotOfTime() {

        // given:
        String start = "3";//Нужен, чтоб работал метод.
        Queue<Integer> stop = new LinkedList<>();  // Нужен, чтоб работал метод.
        stop.add(10);

        assertTimeout(Duration.ofMillis(50), () -> {
            Main.pressButton(start, stop);
        });
    }
}
