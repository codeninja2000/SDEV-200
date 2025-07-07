package P03_LinkedList;

// Look for WRITE YOUR CODE to write your code

import java.util.*;

public class Exercise24_03 {
    public static void main(String[] args) {
        new Exercise24_03();
    }

    public Exercise24_03() {
        TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();
        System.out.print("Enter five numbers: ");
        Scanner input = new Scanner(System.in);
        double[] v = new double[5];
        for (int i = 0; i < 5; i++)
            v[i] = input.nextDouble();

        list.add(v[1]);
        list.add(v[2]);
        list.add(v[3]);
        list.add(v[4]);
        list.add(0, v[0]);
        list.add(2, 10.55);
        list.remove(3);

        java.util.ListIterator<Double> iterator1 = list.listIterator();
        System.out.print("The list in forward order: ");
        while (iterator1.hasNext())
            System.out.print(iterator1.next() + " ");

        java.util.ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
        System.out.print("\nThe list in backward order: ");
        while (iterator2.hasPrevious())
            System.out.print(iterator2.previous() + " ");
    }
}

interface MyList<E> extends java.util.Collection<E> {
    /**
     * Add a new element at the specified index in this list
     */
    public void add(int index, E e);

    /**
     * Return the element from this list at the specified index
     */
    public E get(int index);

    /**
     * Return the index of the first matching element in this list.
     * Return -1 if no match.
     */
    public int indexOf(Object e);

    /**
     * Return the index of the last matching element in this list
     * Return -1 if no match.
     */
    public int lastIndexOf(E e);

    /**
     * Remove the element at the specified position in this list
     * Shift any subsequent elements to the left.
     * Return the element that was removed from the list.
     */
    public E remove(int index);

    /**
     * Replace the element at the specified position in this list
     * with the specified element and returns the new set.
     */
    public E set(int index, E e);

    @Override
    /** Add a new element at the end of this list */
    public default boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override
    /** Return true if this list contains no elements */
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    /** Remove the first occurrence of the element e
     *  from this list. Shift any subsequent elements to the left.
     *  Return true if the element is removed. */
    public default boolean remove(Object e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else
            return false;
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
        // Left as an exercise
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public default boolean addAll(Collection<? extends E> c) {
        // Left as an exercise
        for (E e : c) {
            if (!add(e)) {
                return false; // If any element fails to add, return false
            }
        }
        return true;
    }

    @Override
    public default boolean removeAll(Collection<?> c) {
        // Left as an exercise
        boolean modified = false;
        for (Object e : c) {
            if (contains(e)) {
                remove(e);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public default boolean retainAll(Collection<?> c) {
        // Left as an exercise
        boolean modified = false;


        for (int i = size() - 1; i >= 0; i--) {
            if (!c.contains(get(i))) {
                remove(i);
                modified = true;
            }
        }
        return true;
    }

    @Override
    public default Object[] toArray() {
        // Left as an exercise
        Object[] res = new Object[size()];
        return toArray(res);
    }

    @Override
    public default <T> T[] toArray(T[] array) {
        // Left as an exercise
        int size = size();
        T[] res;
        if (array.length < size) {
            res = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
        } else {
            res = array;
        }
        int i = 0;
        for (E e : this) {
            res[i++] = (T) e; // Cast to T and assign
        }
        return res;
    }

}

class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size;

    /**
     * Create a default list
     */
    public TwoWayLinkedList() {
        size = 0;
        head = tail = null; // Initialize head and tail to null
    }


    /**
     * Create a list from an array of objects
     */
    public TwoWayLinkedList(E[] objects) {
        this.addAll(Arrays.asList(objects));
    }

    /**
     * Return the head element in the list
     */
    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    /**
     * Return the last element in the list
     */
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    /**
     * Clear the list
     */
    public void clear() {
        head = tail = null;
        size = 0; // Reset size to 0
    }

    /**
     * Return true if this list contains the element o
     */
    public boolean contains(Object e) {
        Node<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) {
                return true; // Element found
            }
            current = current.next; // Move to the next node
        }
        return false;
    }

    /**
     * Return the element from this list at the specified index
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // Traverse to the node at the specified index
        }
        return current.element; // Return the element at the specified index
    }

    /**
     * Return the index of the head matching element in this list. Return -1 if
     * no match.
     */
    public int indexOf(Object e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                return i; // Return the index if element matches
            }
            current = current.next; // Move to the next node
        }
        return 0;
    }

    /**
     * Return the index of the last matching element in this list Return -1 if
     * no match.
     */
    public int lastIndexOf(Object e) {
        Node<E> current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.element.equals(e)) {
                return i; // Return the index if element matches
            }
            current = current.previous; // Move to the previous node
        }
        return -1; // Return -1 if no match found
    }

    /**
     * Replace the element at the specified position in this list with the
     * specified element.
     */
    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // Traverse to the node at the specified index
        }
        E oldElement = current.element; // Store the old element
        current.element = e; // Replace the element at the specified index
        return oldElement; // Return the old element
    }

    private class LinkedListIterator implements java.util.ListIterator<E> {
        private Node<E> current = head; // Current index

        public LinkedListIterator() {
            // Start at the head of the list
            current = head;
        }

        public LinkedListIterator(int index) {
            if (index < 0 || index >= size)
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
                        + size);
            for (int nextIndex = 0; nextIndex < index; nextIndex++)
                current = current.next;
        }

        public void setLast() {
            current = tail;
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        public void remove() {
            if (current == null) {
                throw new IllegalStateException("No current element to remove");
            }
            if (current.previous != null) {
                current.previous.next = current.next;
            } else {
                head = current.next; // Update head if removing the first element
            }
            if (current.next != null) {
                current.next.previous = current.previous;
            } else {
                tail = current.previous; // Update tail if removing the last element
            }
            size--;
            current = current.previous; // Move back to the previous node after removal
        }

        @Override
        public void add(E e) {
            Node<E> newNode = new Node<>(e);
            // Case 1: If the list is empty
            if (head == null) {
                head = newNode;
                tail = newNode;
            }
            // Case 2: If adding at the end of the list
            else if (current == null) {
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
            }
            // Case 3: If adding at the beginning of the list
            else if (current == head) {
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
            }
            // Case 4: If adding in the middle of the list
            else {
                newNode.previous = current.previous;
                newNode.next = current;
                current.previous.next = newNode;
                current.previous = newNode;
            }
        }

        @Override
        public boolean hasPrevious() {
            return current != null;
        }

        @Override
        public int nextIndex() {
            System.out.println("Implementation left as an exercise");
            return 0;
        }

        @Override
        public E previous() {
            E e = current.element;
            current = current.previous;
            return e;
        }

        @Override
        public int previousIndex() {
            System.out.println("Implementation left as an exercise");
            return 0;
        }

        @Override
        public void set(E e) {
            current.element = e; // TODO Auto-generated method stub
        }
    }

    private class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E o) {
            element = o;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    public ListIterator<E> listIterator(int index) {
        return new LinkedListIterator(index);
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new LinkedListIterator();

    }

    /**
     * Add an element to the beginning of the list
     */
    public void addFirst(E e) {
        // WRITE YOUR CODE HERE
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.previous = null;
        newNode.next = head;
        if (head != null) {
            head.previous = newNode;
        }
        head = newNode;
        size++; // Increase list size
        if (tail == null) // the new node is the only node in list
            tail = head;
    }

    /**
     * Add an element to the end of the list
     */
    public void addLast(E e) {
        // WRITE YOUR CODE HERE
        Node<E> newNode = new Node<>(e); // Create a new node for element e
        // Update tail to the new node
        if (head == null) {
            head = newNode; // If the list is empty, set head to new node
        } else {
            tail.next = newNode; // Link the last node's next to the new node
            newNode.previous = tail; // Set the previous of new node to current tail
        }
        tail = newNode; // Set tail to new node as well
    }

    /**
     * Add a new element at the specified index in this list The index of the
     * head element is 0
     */
    public void add(int index, E e) {
        // WRITE YOUR CODE HERE
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
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

    /**
     * Remove the head node and return the object that is contained in the
     * removed node.
     */
    public E removeFirst() {
        // Write your code here
        if (size == 0) {
            return null; // List is empty
        } else {
            E temp = head.element;
            head = head.next; // Move head to the next node
            size--;
            if (head == null) {
                tail = null;
            } else {
                head.previous = null; // Set the previous of new head to null
            }
            return temp;
        }
    }

    /**
     * Remove the last node and return the object that is contained in the
     * removed node.
     */
    public E removeLast() {
        // WRITE YOUR CODE HERE
        if (size == 0) {
            return null; // List is empty
        }

        if (head.next == null) {
            E temp = head.element; // Only one element in the list
            head = tail = null; // Clear the list
            size--;
            return temp;
        }
        Node<E> current = head;
        while (current.next != null) {
            current = current.next; // Traverse to the last node
        }
        Node<E> temp = current;
        if (current.previous != null) {
            current.previous.next = null; // Set the next of the previous node to null
        } else {
            head = null; // If there is no previous, set head to null
        }
        tail = current.previous; // Update tail to the previous node
        size--; // Decrease the size of the list
        return temp.element; // Return the element of the removed node
    }

    /**
     * Remove the element at the specified position in this list. Return the
     * element that was removed from the list.
     */
    public E remove(int index) {
        // WRITE YOUR CODE HERE
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 0; i < index; i++) {
                previous = previous.next; // Traverse to the node at the specified index
            }
            Node<E> current = previous.next;
            previous.next = current.next; // Bypass the current node
            if (current.next != null) {
                current.next.previous = previous; // Set the previous of the next node
            }
            size--;
            return current.element; // Return the element of the removed node
        }
    }
}
