import java.util.NoSuchElementException;

public class Dequeue<Item> {

    public Item removeFirst() {
        if (first == null) throw new NoSuchElementException();

        size--;

        Item returnVal = first.item;
        first = first.next;
        // need a test to update first node's prev to first

        return returnVal;
    }

    public Item removeLast() {
        size--;
        
        return null;
    }

    private class Node {
        Item item;
        Node next;
        Node previous;
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
    }

    public void addLast(Item s) {
        size++;
    }


    public static void main(String[] args) {
    }
}
