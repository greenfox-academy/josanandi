
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aze on 2017.03.29..
 */
class CounterTest {

    Counter c = new Counter();

    @Test
    void addMore() {
        c.add(5);
        assertEquals(5, c.get());
    }

    @Test
    void addOne() {
        c.add();
        assertEquals(1, c.get());
    }

    @Test
    void getZero() {
        assertEquals(0, c.get());
    }

    @Test
    void getInit() {
        Counter c = new Counter();
        assertEquals(7, c.get());
    }

    @Test
    void resetToZero() {
        c.add();
        c.reset();
        assertEquals(0, c.get());
    }

    @Test
    void resetToInit() {
        Counter c = new Counter();
        c.add(5);
        c.reset();
        assertEquals(7, c.get());
    }

}