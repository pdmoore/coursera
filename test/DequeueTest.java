import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DequeueTest {

    /*
    public class Deque<Item> implements Iterable<Item> {
   public Deque()                           // construct an empty deque
   public boolean isEmpty()                 // is the deque empty?
   public int size()                        // return the number of items on the deque
   public void addFirst(Item item)          // add the item to the front
   public void addLast(Item item)           // add the item to the end
   public Item removeFirst()                // remove and return the item from the front
   public Item removeLast()                 // remove and return the item from the end
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
   public static void main(String[] args)   // unit testing (optional)
    */

    @Test
    public void NewDequeueIsEmpty() {
        Dequeue<String> d = new Dequeue<>();
        assertTrue(d.isEmpty());
    }

    @Test
    public void AddFirst() {
        Dequeue<String> d = new Dequeue<>();
        d.addFirst("frist!");
        assertFalse(d.isEmpty(), "dequeue is not empty after adding an item up front");
    }

    @Test
    public void DequeueIsEmptyAfterRemoveFirst() {
        Dequeue<String> d = new Dequeue<>();
        d.addFirst("firstItem");
        String actual = d.removeFirst();
        assertTrue(d.isEmpty(), "dequeue should be empty after removing only item");
    }

    @Test
    public void AddAndRemoveFromFront() {
        Dequeue<String> d = new Dequeue<>();
        d.addFirst("firstItem");
        String actual = d.removeFirst();
        assertEquals("firstItem", actual);
    }

    @Test
    public void SizeAfterAddingFromFront() {
        Dequeue<Integer> d = new Dequeue<>();
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        assertEquals(3, d.size(), "size should report number of items in Dequeue");
    }

    // two removeFirst in a row (current impl doesn't update head"

    /*
    Throw a java.lang.IllegalArgumentException if the client calls either addFirst() or addLast() with a null argument.
Throw a java.util.NoSuchElementException if the client calls either removeFirst() or removeLast when the deque is empty.
Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator.
     */


    // size after adding to front and back
    // addLast, isEmpty, size
    // addFirst, addFirst, removeFirst, isEmpty
    // addLast, removeLast, isEmpty
    // maybe addFirst, removeLast, isEmpty
    // iterator and iterate, via next
}
