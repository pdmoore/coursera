import java.util.Iterator;
import java.util.NoSuchElementException;

public class Dequeue<Item> implements Iterable<Item>{

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    private class DequeueIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public Item next() {
            Item returnVal = current.item;
            current = current.next;
            return returnVal;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public Dequeue() {
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

        last = n;
        size++;

        if (first == null) first = last;
    }

    public Item removeFirst() {
        if (first == null) throw new NoSuchElementException();

        size--;

        Item returnVal = first.item;
        first = first.next;
        // need a test to update new first node's prev to first

        return returnVal;
    }

    public Item removeLast() {
        if (last == null) throw new NoSuchElementException();

        size--;

        Item returnVal = last.item;
        last = last.previous;
        // need a test to update new last node's next to null

        return returnVal;
    }

    public Iterator<Item> iterator() {
        return new DequeueIterator();
    }

    public static void main(String[] args) {
    }

}
