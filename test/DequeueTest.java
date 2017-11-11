import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DequeueTest {

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

    @Test
    public void AddFirstTwiceThenRemoveThemBoth() {
        Dequeue<String> d = new Dequeue<>();
        d.addFirst("one");
        d.addFirst("two");
        d.removeFirst();
        String actual = d.removeFirst();
        assertEquals("one", actual, "second remove should return the first item");
    }

    @Test
    public void ValidateParamsToAddFirst() {
        Dequeue<Integer> d = new Dequeue<>();

        Executable addFirstCalledWithNull = () -> {
            d.addFirst(null);
        };
        assertThrows(IllegalArgumentException.class, addFirstCalledWithNull, "");
    }

    @Test
    public void ValidateCallsToRemoveFirst() {
        Dequeue<Integer> d = new Dequeue<>();
        Executable removeFirstCalledOnEmptyDequeue = () -> {
            d.removeFirst();
        };
        assertThrows(NoSuchElementException.class, removeFirstCalledOnEmptyDequeue, "");
    }

    @Test
    public void AddLast() {
        Dequeue<String> d = new Dequeue<>();
        d.addLast("last!");
        assertFalse(d.isEmpty(), "dequeue is not empty after adding an item at end");
    }

    @Test
    public void DequeueIsEmptyAfterRemoveLast() {
        Dequeue<String> d = new Dequeue<>();
        d.addLast("last");
        d.removeLast();
        assertTrue(d.isEmpty(), "dequeue should be empty after removing only item from end");
    }

    @Test
    public void AddAndRemoveFromEnd() {
        Dequeue<String> d = new Dequeue<>();
        d.addLast("lastOne");
        String actual = d.removeLast();
        assertEquals("lastOne", actual);
    }

    @Test
    public void AddLastTwiceThenRemoveThemBoth() {
        Dequeue<String> d = new Dequeue<>();
        d.addLast("lastOne");
        d.addLast("lastTwo");
        d.removeLast();
        String actual = d.removeLast();
        assertEquals("lastOne", actual);
    }

    @Test
    public void ValidateParamsToAddLast() {
        Dequeue<Integer> d = new Dequeue<>();

        Executable addLastCalledWithNull = () -> {
            d.addLast(null);
        };
        assertThrows(IllegalArgumentException.class, addLastCalledWithNull, "");
    }

    @Test
    public void ValidateCallsToRemoveLast() {
        Dequeue<Integer> d = new Dequeue<>();
        Executable removeLastCalledOnEmptyDequeue = () -> {
            d.removeLast();
        };
        assertThrows(NoSuchElementException.class, removeLastCalledOnEmptyDequeue, "No bueno to call removeLast on an empty dequeue");
    }

    @Test
    public void AddToFront_ThemRemoveFromEnd_ShouldBeEmpty() {
        Dequeue<Integer> d = new Dequeue<>();
        d.addFirst(1);
        d.removeLast();
        assertTrue(d.isEmpty(), "Add to front one item, removeLast that one item, dequeue should be empty");
    }

    @Test
    public void AddToEnd_ThenRemoveFromFront_ShouldBeEmpty() {
        Dequeue<Integer> d = new Dequeue<>();
        d.addLast(1);
        d.removeFirst();
        assertTrue(d.isEmpty());
    }

    @Test
    public void IteratorHasNext() {
        Dequeue<String> d = new Dequeue<>();
        d.addFirst("one");
        Iterator<String> i = d.iterator();
        assertTrue(i.hasNext());
    }

    @Test
    public void IteratorHasNext_MultipleItems() {
        Dequeue<String> d = new Dequeue<>();
        d.addLast("second");
        d.addFirst("first");
        Iterator<String> i = d.iterator();
        i.next();
        i.next();
        assertFalse(i.hasNext());
    }

    @Test
    public void AddFirst_AddLast_ShouldBeConnected() {
        Dequeue<String> d = new Dequeue<>();
        d.addFirst("first");
        d.addLast("last");
        d.removeFirst();
        String actual = d.removeFirst();
        assertEquals("last", actual);
    }

    @Test
    public void AddLast_AddFirst_ShouldBeConnected() {
        Dequeue<String> d = new Dequeue<>();
        d.addLast("last");
        d.addFirst("first");
        d.removeLast();
        String actual = d.removeLast();
        assertEquals("first", actual);
    }

    @Test
    public void IterateViaNext() {
        Dequeue<String> d = new Dequeue<>();
        d.addFirst("one");
        d.addLast("two");

        Iterator<String> i = d.iterator();
        assertEquals("one", i.next());
        assertEquals("two", i.next());
    }

    @Test
    public void Iterate_RemoveIsUnsupported() {
        Dequeue<String> d = new Dequeue<>();
        Iterator<String> i = d.iterator();

        Executable removeCalledOnIterator = () -> {
            i.remove();
        };
        assertThrows(UnsupportedOperationException.class, removeCalledOnIterator, "remove is not supported for dequeue");
    }

    @Test
    public void Iterate_NextThrowsExceptionWhenNoMoreElements() {
        Dequeue<String> d = new Dequeue<>();
        Iterator<String> i = d.iterator();

        Executable nextCalledWhenNoNextElement = () -> {
            i.next();
        };
        assertThrows(NoSuchElementException.class, nextCalledWhenNoNextElement, "next should throw when no next element");
    }

    // Remove First/Last needs to sever connections to prev/next!!!!

    @Disabled
    @Test
    public void Integration_ExerciseDequeueClass() {
        Dequeue<String> d = new Dequeue<>();
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
        assertTrue(d.isEmpty(), "dequeue should now be empty");
    }
}
