package graphlink;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListLinked<E> implements Iterable<E> {
    private Node<E> head;
    private int size;

    public ListLinked() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void delete(E element) {
        if (isEmpty()) {
            return;
        }

        if (head.data.equals(element)) {
            head = head.next;
            size--;
            return;
        }

        Node<E> current = head;
        Node<E> prev = null;
        while (current != null && !current.data.equals(element)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
            size--;
        }
    }

    public boolean contains(E element) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public Iterator<E> iterator() {
        return new ListIterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        return sb.toString();
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            next = null;
        }
    }

    private class ListIterator implements Iterator<E> {
        private Node<E> current;

        public ListIterator() {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
