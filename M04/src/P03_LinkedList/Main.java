package P03_LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        list.add(0, 100);
        System.out.println(list);
        list.add(1, 200);
        System.out.println(list);
        list.addLast(420);
        System.out.println(list);
        list.addFirst(600);
        System.out.println(list);
        list.removeLast();
        list.removeFirst();
        System.out.println(list);
    }
}
