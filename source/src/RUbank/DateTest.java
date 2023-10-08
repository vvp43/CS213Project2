package RUbank;

import static org.junit.Assert.*;

public class DateTest {

    @org.junit.Test
    public void isValid() {
        Date a = new Date(2011, 2, 29);
        assertFalse(a.isValid());

    }
}