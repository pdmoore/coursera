import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;

public class RandomizedQueue<Item> {
    private int size;
    private Item[] items;

    public RandomizedQueue() {
        items = (Item[])new Object[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();

        if (size == items.length) resize(2 * items.length);

        items[size] = item;

        size++;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[])new Object[capacity];
        for (int i = 0; i < size; i++)
            copy[i] = items[i];
        items = copy;
    }

    public Item dequeue() {
        if (size == 0) throw new NoSuchElementException();

        Item returnVal = items[size - 1];

        size--;

        return returnVal;
    }

    public Item sample() {
        if (size == 0) throw new NoSuchElementException();

        return items[StdRandom.uniform(size)];
    }

    public static void main(String[] args) {

    }
}
