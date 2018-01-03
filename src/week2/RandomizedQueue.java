//package week2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item>  {
    private int size;
    private Item[] items;

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int currentIndex;
        private final int[] indices;

        public RandomizedQueueIterator() {
            this.currentIndex = 0;
            indices = new int[size];
            for (int i=0; i < indices.length; i++) {
                indices[i] = i;
            }
            StdRandom.shuffle(indices);
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();

            return items[indices[currentIndex++]];
        }
    }

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

    public Item dequeue() {
        if (size == 0) throw new NoSuchElementException();

        int index = StdRandom.uniform(size);
        Item returnVal = items[index];
        items[index] = items[--size];
        items[size] = null;

        if (size > 0 && size == items.length/4) resize(items.length/2);

        return returnVal;
    }

    public Item sample() {
        if (size == 0) throw new NoSuchElementException();

        return items[StdRandom.uniform(size)];
    }

    private void resize(int capacity) {
        Item[] copy = (Item[])new Object[capacity];
        for (int i = 0; i < size; i++)
            copy[i] = items[i];
        items = copy;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    public static void main(String[] args) {
        // method required by grading system
    }
}
