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
            try {
            list.insertItem(node.info);
            } catch (Exception e) {}
        } // for
        System.out.print("Enter a command: ");
        char command = stdIn.nextLine().charAt(0);
        ItemType itemtype = new ItemType(0);
        while (!(command == ('q'))) {
            switch (command) {
            case 'p':
                System.out.print("The list is: ");
                list.printList();
                break;
            case 'i':
                System.out.print("Enter a number to insert: ");
                int item = Integer.parseInt(stdIn.nextLine());
                itemtype = new ItemType(item);
                System.out.print("Original list: ");
                list.printList();
                try {
                    list.insertItem(itemtype);
                } catch (Exception e) {
                    System.out.println("Sorry. You cannot insert the duplicate item");
                } // catch
                System.out.print("New list: ");
                list.printList();
                break;
            case 'd':
                System.out.print("Enter a number to delete: ");
                itemtype = new ItemType(Integer.parseInt(stdIn.nextLine()));
                System.out.print("Original list: ");
                list.printList();
                list.deleteItem(itemtype);
                System.out.print("New list: ");
                list.printList();
                break;
            case 'l':
                System.out.print("The length of the list is " + list.getLength() + "\n");
                break;
            case 's':
                System.out.print("Enter a number to search: ");
                itemtype = new ItemType(Integer.parseInt(stdIn.nextLine()));
                System.out.print("Original list: ");
                list.printList();
                if (list.searchItem(itemtype) == -1) {
                    System.out.println("Item is not in the list");
                } else {
                    System.out.println("The item is present at index " + list.searchItem(itemtype));
                } // else
                break;
            case 'n':
                System.out.println(list.getNextItem().getValue());
                break;
            case 'r':
                list.resetList();
                System.out.println("Iterator is reset");
                break;
            case 'a':
                System.out.print("Original list: ");
                list.printList();
                SortedLinkedList tempList = list.deleteAltNodes(list);
                System.out.print("Modified list: ");
                tempList.printList();
                break;
            case 'm':
                System.out.print("Enter the length of the new list: ");
                int length = stdIn.nextInt();
                System.out.print("Enter the numbers: ");
                SortedLinkedList list2 = new SortedLinkedList();
                for (int i = 0; i < length; i++) {
                    try {
                        list2.insertItem(new ItemType(stdIn.nextInt()));
                    } catch (Exception e ) {}
                } // for
                System.out.print("The list 1: ");
                list.printList();
                System.out.print("The list 2: ");
                list2.printList();
                list = list.mergeList(list, list2);
                System.out.print("Merged list: ");
                list.printList();
                stdIn.nextLine();
                break;
            default:
                break;
            } //switch
            System.out.print("Enter a command: ");
            command = stdIn.nextLine().charAt(0);
        } // while
    } // main
} // class
