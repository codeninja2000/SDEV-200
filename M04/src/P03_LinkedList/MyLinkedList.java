package P03_LinkedList;

import java.util.Arrays;

/**
 * MyLinkedList is a custom implementation of a doubly linked list.
 * It implements the MyList interface and provides methods to manipulate the list.
 * The list supports operations such as adding, removing, and accessing elements.
 *
 * @param <E> the type of elements in this list
 */
public class MyLinkedList<E> implements MyList<E> {
    protected Node<E> head, tail = null;
    protected int size = 0; // Number of elements in the list

    /** Create an empty list */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /** Create a list from an array of objects */
    public MyLinkedList(E[] objects) {
        this.addAll(Arrays.asList(objects));
    }

    /** Return the head element in the list */
    public E getFirst() {
        if (size == 0) {
            return null;
        }
        else {
            return head.element;
        }
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        }
        else {
            return tail.element;
        }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.previous = null;
        newNode.next = head; // link the new node with the head
        if (head != null) {
            head.previous = newNode;
        }
        head = newNode; // head points to the new node

        size++; // Increase list size

        if (tail == null) // the new node is the only node in list
            tail = head;
    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e); // Create a new for element e

        if (head == null) {
            head = newNode;
        }
        else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }

            // Set the next of last node to the new node
            current.next = newNode;

            // Set the prev of new node to the last node
            newNode.previous = current;
        }

        size++; // Increase size
    }

    @Override /** Add a new element at the specified index
     * in this list. The index of the head element is 0 */
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        }
        else if (index >= size) {
            addLast(e);
        }
        else {
            Node<E> newNode = new Node<>(e);
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            if (current == null) {
                return;
            }
            newNode.previous = current;
            newNode.next = current.next;
            current.next = newNode;
            if (newNode.next != null) {
                newNode.next.previous = newNode;
            }
            size++;
        }

    }

    /** Remove the head node and
     *  return the object that is contained in the removed node. */
    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        else {
            E temp = head.element;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            else {
                head.previous = null;
            }
            return temp;
        }
    }

    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
        if (size == 0) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        Node<E> current = head;

        while (current.next != null) {
            current = current.next;
        }
        Node<E> temp = current;
       if (current.previous != null) {
           current.previous.next = null;
       }
       else {
           head = null;
       }
       tail = current.previous;
       size--;
       return temp.element;
    }

    @Override /** Remove the element at the specified position in this
     *  list. Return the element that was removed from the list. */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        else if (index == 0) {
            return removeFirst();
        }
        else if (index == size - 1) {
            return removeLast();
        }
        else {
            Node<E> previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    @Override /** Override toString() to return elements in the list */
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            }
            else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    @Override /** Clear the list */
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override /** Return true if this list contains the element e */
    public boolean contains(Object e) {
        // Left as an exercise
        return true;
    }

    @Override /** Return the element at the specified index */
    public E get(int index) {
        // Left as an exercise
        return null;
    }

    @Override /** Return the index of the first matching element in
     *  this list. Return -1 if no match. */
    public int indexOf(Object e) {
        // Left as an exercise
        return 0;
    }

    @Override /** Return the index of the last matching element in
     *  this list. Return -1 if no match. */
    public int lastIndexOf(E e) {
        // Left as an exercise
        return 0;
    }

    @Override /** Replace the element at the specified position
     *  in this list with the specified element. */
    public E set(int index, E e) {
        // Left as an exercise
        return null;
    }

    @Override /** Override iterator() defined in Iterable */
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /** Returns an iterator for the elements in this list */
    private class LinkedListIterator
            implements java.util.Iterator<E> {
        private Node<E> current = head; // Current index

        @Override /** Check if there are more elements in the list */
        public boolean hasNext() {
            return (current != null);
        }

        @Override /** Get the current element and move to the next */
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        /** Remove the current element returned by next() */
        public void remove() {
            // Left as an exercise

            if (current == null) {
                throw new IllegalStateException();
            }
            if (current == head) {
                // If we're removing the first element
                head = current.next;
                if (head != null) {
                    head.previous = null;
                } else {
                    tail = null;
                }
            } else {
                // For elements in the middle or end
                current.previous.next = current.next;
                if (current.next != null) {
                    current.next.previous = current.previous;
                } else {
                    tail = current.previous;
                }
            }

            current = current.next;
            size--;


        }
    }
    /** Node class for doubly linked list */
    protected static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E element) {
            this.element = element;
        }
    }

    @Override /** Return the number of elements in this list */
    public int size() {
        return size;
    }
}