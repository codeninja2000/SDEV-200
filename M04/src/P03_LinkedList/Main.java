//package P03_LinkedList;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        MyLinkedList<Integer> list = new MyLinkedList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//        System.out.println(list);
//        list.add(0, 100);
//        System.out.println(list);
//        list.add(1, 200);
//        System.out.println(list);
//        list.addLast(420);
//        System.out.println(list);
//        list.addFirst(600);
//        System.out.println(list);
//        list.removeLast();
//        list.removeFirst();
//        System.out.println(list);
//    }
//    public void Exercise24_03() {
//        MyLinkedList<Double> list = new MyLinkedList<>();
//        System.out.print("Enter five numbers: ");
//        Scanner input = new Scanner(System.in);
//        double[] v = new double[5];
//        for (int i = 0; i < 5; i++)
//            v[i] = input.nextDouble();
//
//        list.add(v[1]);
//        list.add(v[2]);
//        list.add(v[3]);
//        list.add(v[4]);
//        list.add(0, v[0]);
//        list.add(2, 10.55);
//        list.remove(3);
//
//        java.util.ListIterator<Double> iterator1 = list.listIterator();
//        System.out.print("The list in forward order: ");
//        while (iterator1.hasNext())
//            System.out.print(iterator1.next() + " ");
//
//        java.util.ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
//        System.out.print("\nThe list in backward order: ");
//        while (iterator2.hasPrevious())
//            System.out.print(iterator2.previous() + " ");
//    }
//}
