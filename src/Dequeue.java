public class Dequeue<Item> {

    public Item removeFirst() {
        size--;

        Item returnVal = first.item;

        return returnVal;
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

    public static void main(String[] args) {
    }

    public void addFirst(Item item) {

        Node n = new Node();
        n.item = item;
        n.next = first;
        n.previous = null;

        first = n;
        size++;
    }
}
