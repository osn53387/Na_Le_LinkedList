package csci2720.p1;

public class LinkedListDriver {
    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        NodeType node = new NodeType();
        //list.head = new NodeType();
        //list.currentPos = head;
        node.info = new ItemType(10);
        list.insertItem(node.info);
        NodeType node2 = new NodeType();
        node2.info = new ItemType(5);
        list.insertItem(node2.info);
        //System.out.println(list.getLength());
        while(list.currentPos != null) {
            System.out.println(list.currentPos.info.getValue());
            list.currentPos = list.currentPos.next;
        } // while
    } // main
} // class
