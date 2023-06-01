package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class intListTest {
    @Test
    public void testOf(){
        IntList lst = IntList.of(1, 2, 3);
        String actual = lst.toString();
        String expect = "1 -> 2 -> 3";
        assertEquals(expect, actual);
    }
}
