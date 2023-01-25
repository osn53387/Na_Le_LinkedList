package csci2720.p1;

public class LinkedListDriver {
    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        NodeType node = new NodeType();
        node.info = new ItemType(10);
        list.insertItem(node.info);
        list.printList();
        NodeType node2 = new NodeType();
        node2.info = new ItemType(5);
        list.insertItem(node2.info);
        list.printList();
        System.out.println(list.getLength());

        NodeType node3 = new NodeType();
        NodeType node4 = new NodeType();
        //NodeType node5 = new NodeType();
        node3.info = new ItemType(4);
        node4.info = new ItemType(9);
        //node5.info = new ItemType(7);
        list.insertItem(node3.info);
        //list.printList();
        list.insertItem(node4.info);
        //list.insertItem(node5.info);
        list.printList();
                //System.out.println(list.getLength());
        //list.printList();
    } // main
} // class
