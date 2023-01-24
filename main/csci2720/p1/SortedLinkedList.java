package csci2720.p1;

public class SortedLinkedList {
    public NodeType head;
    public NodeType currentPos;

    public SortedLinkedList() {
        this.head = null;
        this.currentPos = null;
    } // SortedLinkedList

    public int getLength() {
        int size = 0;
        while (currentPos != null) {
            size++;
            currentPos = currentPos.next;
        }
        currentPos = head;
        return size;
    } // getLength

    public void insertItem(ItemType item) {
        if (head == null) {
            head = new NodeType();
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
                currentPos = currentPos.next;
            } // while
        } // else
        currentPos = head;
    } // insertItem
} // class
