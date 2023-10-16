package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

import timingtest.AList;


public class testThreeAddThreeRemove {

    @Test
    public void testThreeAddThreeRemove1() {
        AListNoResizing<Integer> al = new AListNoResizing<>();
        BuggyAList<Integer> bal = new BuggyAList<>();

        al.addLast(3);
        al.addLast(4);
        al.addLast(5);

        bal.addLast(3);
        bal.addLast(4);
        bal.addLast(5);

        assertEquals(al.removeLast(), bal.removeLast());
        assertEquals(al.removeLast(), bal.removeLast());
        assertEquals(al.removeLast(), bal.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> bl = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);

            if (operationNumber == 0) {               // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                bl.addLast(randVal);
            } else if (operationNumber == 1) {         // size
                assertEquals(L.size(), bl.size());
            } else if (L.size() <= 0) {
                continue;
            } else if (operationNumber == 2) {          // getlast
                assertEquals(L.getLast(), bl.getLast());
            } else if (operationNumber == 3) {          // removelast
                assertEquals(L.removeLast(), bl.removeLast());
            }
        }
    }
}
