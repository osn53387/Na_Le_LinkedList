package csci2720.p1;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;

    public SortedLinkedList() {
        this.head = null;
        this.currentPos = null;
    } // SortedLinkedList

    public int getLength() {
        int size = 0;
        while (currentPos != null) size++;
        return size;
    } // getLength

    public void insertItem(ItemType item) {
        if (head == null) {
            head.info = item;
            currentPos = head;
        } else {
            while (currentPos != null) {
                if (currentPos.next == null) {
                    if (currentPos.info.getValue() == item.getValue()) {
                        System.out.println("Sorry. You cannot insert the duplicate item.");
                        break;
                    } else if (currentPos.info.getValue() < item.getValue()) {
                        NodeType temp = new NodeType();
                        temp.info = new ItemType(item.getValue());
                        currentPos.next = temp;
                    } else {
                        NodeType temp = new NodeType();
                        temp.info = new ItemType(item.getValue());
                        temp.next = currentPos;
                        head = temp;
                    } // else
                } else if (currentPos.next.info.getValue() < item.getValue()) {
                    currentPos = currentPos.next;
                    if (currentPos.next == null) {
                        NodeType temp = new NodeType();
                        temp.info = new ItemType(item.getValue());
                        currentPos.next = temp;
                    }
                } else if (currentPos.info.getValue() == item.getValue()) {
                    System.out.println("Sorry. You cannot insert the duplicate item.");
                    break;
                } else {
                    if (head.info.getValue() == currentPos.info.getValue()) {
                        NodeType temp = new NodeType();
                        temp.info = new ItemType(item.getValue());
                        temp.next = currentPos;
                        head = temp;
                    } //
                    NodeType temp = new NodeType();
                    temp.info = new ItemType(item.getValue());
                    temp.next = currentPos.next;
                    currentPos.next = temp;
                }
            } // while
        } // else
        currentPos = head;
    } // insertItem
} // class
