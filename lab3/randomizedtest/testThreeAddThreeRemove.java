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

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);

            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                bl.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int bsize = bl.size();
//                System.out.println("size: " + size);
//                System.out.println("blsize: " + bsize);

                assertEquals(size, bsize);
            } else if (operationNumber == 2) {
                if (L.size() == 0)
                    continue;
                else {
                    int last = L.getLast();
                    int blast = bl.getLast();
                    assertEquals(last, blast);
                }
            } else if (operationNumber == 3) {
                if (L.size() == 0)
                    continue;
                else {
                    int rmv = L.removeLast();
                    int brmv = bl.removeLast();
                    assertEquals(rmv, brmv);
                }
            }


        }
    }
}
