import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RandomizedQueueTest {

/*
    public class RandomizedQueue<Item> implements Iterable<Item> {
        public RandomizedQueue()                 // construct an empty randomized queue
        public boolean isEmpty()                 // is the randomized queue empty?
        public int size()                        // return the number of items on the randomized queue
        public void enqueue(Item item)           // add the item
        public Item dequeue()                    // remove and return a random item
        public Item sample()                     // return a random item (but do not remove it)
        public Iterator<Item> iterator()         // return an independent iterator over items in random order
        public static void main(String[] args)   // unit testing (optional)
 */

//    Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
//    Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator.


    @Test
    public void RandomizedQueueStartsOffEmpty() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        assertTrue(rq.isEmpty(), "newly constructed queue starts off empty");
    }

    @Test
    public void RandomizedQueueStartsWithSize_0() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        assertEquals(0, rq.size(), "newly constructed queue starts off with size zero");
    }

    @Test
    public void ValidateParamToEnqueue() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        Executable enqueueCalledWithNull = () -> {
            rq.enqueue(null);
        };
        assertThrows(IllegalArgumentException.class, enqueueCalledWithNull, "enqueue expects non-null argument");
    }

    @Test
    public void EnqueueAnItem_RandomizedQueueIsNoLongerEmpty() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(1);
        assertFalse(rq.isEmpty(), "randomized queue should not be empty after adding smething");
    }

    @Test
    public void EnqueueManyItems_ConfirmSizeIsCorrect() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("one");
        rq.enqueue("two");
        rq.enqueue("three");
        assertEquals(3, rq.size());
    }

    @Test
    public void EnqueueThenDequeue_ConfirmIsEmpty() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("foo");
        rq.dequeue();
        assertTrue(rq.isEmpty(), "randomized queue should be empty after removing last item");
    }

    @Test
    public void EnqueueThenDequeue_ConfirmSizeIsZero() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("foo");
        rq.dequeue();
        assertEquals(0, rq.size(), "randomized queue should have size 0 after removing last item");
    }

    @Test
    public void ValidateParamsOnDequeue() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        Executable dequeueCalledOnEmptyRandomizedQueue = () -> {
            rq.dequeue();
        };
        assertThrows(NoSuchElementException.class, dequeueCalledOnEmptyRandomizedQueue,
                "should throw when trying to dequeue an empty randomized queue");
    }

    @Test
    public void EnqueueThenDequeue_ShouldBeSameItemWhenOnlyOneItem() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("only");
        String actual = rq.dequeue();
        assertEquals("only", actual);
    }

    @Test
    public void EnqueueMultipleItems_DequeueSameNumber_VerifyEachReturnedOnlyOnce() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("a one");
        rq.enqueue("b two");
        rq.enqueue("c three");

        List actual = new ArrayList();
        actual.add(rq.dequeue());
        actual.add(rq.dequeue());
        actual.add(rq.dequeue());
        Collections.sort(actual);
        String[] expected = new String[] { "a one", "b two", "c three" };
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void SampleWithOneItemReturnsThatOneItem() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        rq.enqueue("one");
        assertEquals("one", rq.sample());
    }

    @Test
    public void Sample_DoesNotAlterSize() {
        RandomizedQueue rq = new RandomizedQueue();
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        int sizeBefore = rq.size();
        rq.sample();
        assertEquals(sizeBefore, rq.size());
    }

    @Test
    public void ValidateParamsOnSample() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        Executable sampleCalledOnEmptyRandomizedQueue = () -> {
            rq.sample();
        };
        assertThrows(NoSuchElementException.class, sampleCalledOnEmptyRandomizedQueue,
                "should throw when trying to sample an empty randomized queue");
    }


    // sample item with multiple - how to test randomness?
    // dequeue is random - how to test randomness?


    // iterator tests -- WHICH ONES?
    // also impl the param validation as at top of this file
}
