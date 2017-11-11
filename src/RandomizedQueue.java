import java.util.NoSuchElementException;

public class RandomizedQueue<Item> {
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();

        size++;
    }

    public Item dequeue() {
        if (size == 0) throw new NoSuchElementException();

        size--;

        return null;
    }


    public static void main(String[] args) {

    }
}
