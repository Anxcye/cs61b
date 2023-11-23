package deque;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {

    private class IntegerComparator implements java.util.Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return a-b;
        }
    }
    @Test
    public void testMax(){
        MaxArrayDeque<Integer> mad1 = new MaxArrayDeque<Integer>(new IntegerComparator());
        mad1.addFirst(1);
        mad1.addFirst(2);
        mad1.addFirst(3);
        mad1.addFirst(4);
        mad1.addFirst(5);
        assertEquals(5, (long)mad1.max());
        assertEquals(5, (long)mad1.max(new IntegerComparator()));
    }

}
