package csci2720.p1;

import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        Scanner stdIn = new Scanner(System.in);
        for (int i = 0; i < args.length; i++) {
            int temp = Integer.parseInt(args[i]);
            NodeType node = new NodeType();
            node.info = new ItemType(temp);
            list.insertItem(node.info);
        } // for
        list.printList();
        char command = stdIn.next();
        while (!command == ('q')) {
            if (command == 'p') {
                list.printList();
            } // if

        } // while
    } // main
} // class
