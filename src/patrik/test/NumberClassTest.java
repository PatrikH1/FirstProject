package patrik.test;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NumberClassTest {

    NumberClass numberClass = null;

    @Before
    public void init() {
        numberClass = new NumberClass(10L, 12L);
    }

    @Test
    public void getNum1() {
        assertEquals(10L, numberClass.getNum1().longValue());
    }

    @Test
    public void setNum1() {
        numberClass.setNum1(100L);
        assertEquals(100L, numberClass.getNum1().longValue());
    }

    @Test
    public void getNum2() {
        assertEquals(12L, numberClass.getNum2().longValue());
    }

    @Test
    public void setNum2() {
        numberClass.setNum2(200L);
        assertEquals(200L, numberClass.getNum2().longValue());
    }
}