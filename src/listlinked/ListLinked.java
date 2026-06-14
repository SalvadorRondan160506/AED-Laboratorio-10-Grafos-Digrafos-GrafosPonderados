package listlinked;

public class ListLinked<E> {
    private Node<E> first;
    private int size;

    public ListLinked() {
        first = null;
        size = 0;
    }

    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);

        if (first == null) {
            first = newNode;
        } else {
            Node<E> current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }

        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<E> current = first;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    public boolean remove(E data) {
        if (first == null) return false;

        if (first.getData().equals(data)) {
            first = first.getNext();
            size--;
            return true;
        }

        Node<E> current = first;

        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                size--;
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    public int size() {
        return size;
    }
}