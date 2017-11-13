import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DequeTest {

    @Test
    public void NewDequeueIsEmpty() {
        Deque<String> d = new Deque<>();
        assertTrue(d.isEmpty());
    }

    @Test
    public void AddFirst() {
        Deque<String> d = new Deque<>();
        d.addFirst("frist!");
        assertFalse(d.isEmpty(), "dequeue is not empty after adding an item up front");
    }

    @Test
    public void DequeueIsEmptyAfterRemoveFirst() {
        Deque<String> d = new Deque<>();
        d.addFirst("firstItem");
        String actual = d.removeFirst();
        assertTrue(d.isEmpty(), "dequeue should be empty after removing only item");
    }

    @Test
    public void AddAndRemoveFromFront() {
        Deque<String> d = new Deque<>();
        d.addFirst("firstItem");
        String actual = d.removeFirst();
        assertEquals("firstItem", actual);
    }

    @Test
    public void SizeAfterAddingFromFront() {
        Deque<Integer> d = new Deque<>();
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        assertEquals(3, d.size(), "size should report number of items in Deque");
    }

    @Test
    public void AddFirstTwiceThenRemoveThemBoth() {
        Deque<String> d = new Deque<>();
        d.addFirst("one");
        d.addFirst("two");
        d.removeFirst();
        String actual = d.removeFirst();
        assertEquals("one", actual, "second remove should return the first item");
    }

    @Test
    public void ValidateParamsToAddFirst() {
        Deque<Integer> d = new Deque<>();

        Executable addFirstCalledWithNull = () -> {
            d.addFirst(null);
        };
        assertThrows(IllegalArgumentException.class, addFirstCalledWithNull, "");
    }

    @Test
    public void ValidateCallsToRemoveFirst() {
        Deque<Integer> d = new Deque<>();
        Executable removeFirstCalledOnEmptyDequeue = () -> {
            d.removeFirst();
        };
        assertThrows(NoSuchElementException.class, removeFirstCalledOnEmptyDequeue, "");
    }

    @Test
    public void AddLast() {
        Deque<String> d = new Deque<>();
        d.addLast("last!");
        assertFalse(d.isEmpty(), "dequeue is not empty after adding an item at end");
    }

    @Test
    public void DequeueIsEmptyAfterRemoveLast() {
        Deque<String> d = new Deque<>();
        d.addLast("last");
        d.removeLast();
        assertTrue(d.isEmpty(), "dequeue should be empty after removing only item from end");
    }

    @Test
    public void AddAndRemoveFromEnd() {
        Deque<String> d = new Deque<>();
        d.addLast("lastOne");
        String actual = d.removeLast();
        assertEquals("lastOne", actual);
    }

    @Test
    public void AddLastTwiceThenRemoveThemBoth() {
        Deque<String> d = new Deque<>();
        d.addLast("lastOne");
        d.addLast("lastTwo");
        d.removeLast();
        String actual = d.removeLast();
        assertEquals("lastOne", actual);
    }

    @Test
    public void ValidateParamsToAddLast() {
        Deque<Integer> d = new Deque<>();

        Executable addLastCalledWithNull = () -> {
            d.addLast(null);
        };
        assertThrows(IllegalArgumentException.class, addLastCalledWithNull, "");
    }

    @Test
    public void ValidateCallsToRemoveLast() {
        Deque<Integer> d = new Deque<>();
        Executable removeLastCalledOnEmptyDequeue = () -> {
            d.removeLast();
        };
        assertThrows(NoSuchElementException.class, removeLastCalledOnEmptyDequeue, "No bueno to call removeLast on an empty dequeue");
    }

    @Test
    public void AddToFront_ThemRemoveFromEnd_ShouldBeEmpty() {
        Deque<Integer> d = new Deque<>();
        d.addFirst(1);
        d.removeLast();
        assertTrue(d.isEmpty(), "Add to front one item, removeLast that one item, dequeue should be empty");
    }

    @Test
    public void AddToEnd_ThenRemoveFromFront_ShouldBeEmpty() {
        Deque<Integer> d = new Deque<>();
        d.addLast(1);
        d.removeFirst();
        assertTrue(d.isEmpty());
    }

    @Test
    public void IteratorHasNext() {
        Deque<String> d = new Deque<>();
        d.addFirst("one");
        Iterator<String> i = d.iterator();
        assertTrue(i.hasNext());
    }

    @Test
    public void IteratorHasNext_MultipleItems() {
        Deque<String> d = new Deque<>();
        d.addLast("second");
        d.addFirst("first");
        Iterator<String> i = d.iterator();
        i.next();
        i.next();
        assertFalse(i.hasNext());
    }

    @Test
    public void AddFirst_AddLast_ShouldBeConnected() {
        Deque<String> d = new Deque<>();
        d.addFirst("first");
        d.addLast("last");
        d.removeFirst();
        String actual = d.removeFirst();
        assertEquals("last", actual);
    }

    @Test
    public void AddLast_AddFirst_ShouldBeConnected() {
        Deque<String> d = new Deque<>();
        d.addLast("last");
        d.addFirst("first");
        d.removeLast();
        String actual = d.removeLast();
        assertEquals("first", actual);
    }

    @Test
    public void IterateViaNext() {
        Deque<String> d = new Deque<>();
        d.addFirst("one");
        d.addLast("two");

        Iterator<String> i = d.iterator();
        assertEquals("one", i.next());
        assertEquals("two", i.next());
    }

    @Test
    public void Iterate_RemoveIsUnsupported() {
        Deque<String> d = new Deque<>();
        Iterator<String> i = d.iterator();

        Executable removeCalledOnIterator = () -> {
            i.remove();
        };
        assertThrows(UnsupportedOperationException.class, removeCalledOnIterator, "remove is not supported for deque");
    }

    @Test
    public void Iterate_NextThrowsExceptionWhenNoMoreElements() {
        Deque<String> d = new Deque<>();
        Iterator<String> i = d.iterator();

        Executable nextCalledWhenNoNextElement = () -> {
            i.next();
        };
        assertThrows(NoSuchElementException.class, nextCalledWhenNoNextElement, "next should throw when no next element");
    }

    @Test
    public void removeLastShouldSeverNextLink() {
        Deque<String> d = new Deque<>();
        d.addFirst("first");
        d.addLast("last");
        d.removeLast();
        Iterator<String> i = d.iterator();
        i.next();
        assertFalse(i.hasNext(), "deque has a single element, iterator should not hasNext after next() call");
    }

    // Not a similar issue with removeFirst since there isn't a reverse iterator to manage cleaning up Node.previous

    @Test
    public void Integration_ExerciseDequeClass() {
        Deque<String> d = new Deque<>();
        d.addFirst("Middle");
        d.addLast("last");
        d.addFirst("first");
        assertEquals(3, d.size());
        d.removeFirst();
        d.removeLast();
        Iterator<String> i = d.iterator();
        String actual = i.next();
        assertEquals("Middle", actual);
        assertFalse(i.hasNext(), "iterator shouldn't have anything");
        d.removeLast();
        assertTrue(d.isEmpty(), "deque should now be empty");
    }
}
