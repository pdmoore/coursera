import org.junit.jupiter.api.Test;

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

    // addFirst, isEmpty, and size
    // addLast, isEmpty, size
    // addFirst, removeFirst, isEmpty
    // addLast, removeLast, isEmpty
    // maybe addFirst, removeLast, isEmpty
    // iterator and iterate
}
