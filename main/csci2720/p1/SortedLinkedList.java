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
        currentPos = head;
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
                    } // if
                    NodeType temp = new NodeType();
                    temp.info = new ItemType(item.getValue());
                    temp.next = currentPos.next;
                    currentPos.next = temp;
                } // else
            } // while
        } // else
        currentPos = head;
    } // insertItem

    public void deleteItem(Itemtype item) {
        if (head == null) {
            System.out,println("You cannot delete from an empty list");
            break;
        } else {
            while (currentPos != null) {
                if (head.info.getValue() == item.getValue()) {
                    head = head.next;
                    // currentPos = head; ?
                } else if (currentPos.next.info.getValue() != item.getValue()) {
                    currentPos = currentPos.next;
                    if (currentPos.next == null) {
                        System.out.println("Item not found");
                        break;
                    } // if
                } else {
                    currentPos.next = currentPos.next.next;
                } // else
            } // while
        } // else
        currentPos = head;
    } // deleteItem

    public int searchItem(Itemtype item) {
        int index = 0;
        if (head == null) {
            System.out.println("Item not found");
            break;
        } // if
        while (currentPos != null) {
            if (currentPos.info.getValue() == item.getValue()) {
                return index;
            } else {
                index++;
                currentPos = currentPos.next;
                if (currentPos.next == null) {
                    Systme.out.println("Item not found");
                } // if
            } // else
        } // while
    } // searchItem

    public Itemtype getNextItem() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            if (currentPos.next == null) {
                System.out.println("The end of the list has been reached");
            } else {
                currentPos = currentPos.next;
                return currentPos.info;
            } // else
        } // else
    } // getNextItem

    public void resetList() {
        currentPos = head;
        System.out.println("Iterator is reset");
    } // resetList
} // class
