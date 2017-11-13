import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>{

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();

            Item returnVal = current.item;
            current = current.next;
            return returnVal;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public Deque() {
        first = null;
        last  = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();

        Node n = new Node();
        n.item = item;
        n.next = first;
        n.previous = null;

        if (n.next != null) n.next.previous = n;

        first = n;
        size++;

        if (last == null) last = first;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();

        Node n = new Node();
        n.item = item;
        n.next = null;
        n.previous = last;

        if (n.previous != null) n.previous.next = n;

        last = n;
        size++;

        if (first == null) first = last;
    }

    public Item removeFirst() {
        if (first == null) throw new NoSuchElementException();

        size--;

        Item returnVal = first.item;
        first = first.next;
        if (first == null) last = null;

        return returnVal;
    }

    public Item removeLast() {
        if (last == null) throw new NoSuchElementException();

        size--;

        Item returnVal = last.item;
        if (last.previous != null) last.previous.next = null;

        last = last.previous;
        if (last == null) first = null;

        return returnVal;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    public static void main(String[] args) {
    }
}
