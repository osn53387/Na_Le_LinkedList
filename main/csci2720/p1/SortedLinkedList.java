package csci2720.p1;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;

    public SortedLinkedList() {
        this.head = null;
        this.currentPos = null;
    } // SortedLinkedList

    /**
     * Prints all the elements in the list.
     */
    public void printList() {
        System.out.print("[");
        while (this.currentPos != null) {
            if (this.currentPos.next == null) {
                System.out.print(this.currentPos.info.getValue());
            } else {
                System.out.print(this.currentPos.info.getValue() + ", ");
            } // if-else
            this.currentPos = this.currentPos.next;
        } // while
        System.out.println("]");
        currentPos = head;
    } // printList

    public int getLength() {
        int size = 0;
        while (currentPos != null) {
            size++;
            currentPos = currentPos.next;
        } // while
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
                        System.out.println("test");
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
                    } else if (currentPos.info.getValue()  {
                        NodeType temp = new NodeType();
                        temp.info = new ItemType(item.getValue());
                        temp.next = currentPos.next;
                        currentPos.next = temp;
                    }
                } // else
                currentPos = currentPos.next;
            } // while
        } // else
        currentPos = head;
    } // insertItem



    public void deleteItem(ItemType item) {
        if (head == null) {
            System.out.println("You cannot delete from an empty list");
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

    public int searchItem(ItemType item) {
        int index = 0;
        if (head == null) {
            System.out.println("Item not found");
            return 0;
        } // if
        while (currentPos != null) {
            if (currentPos.info.getValue() == item.getValue()) {
                return index;
            } else {
                index++;
                currentPos = currentPos.next;
                if (currentPos.next == null) {
                    System.out.println("Item not found");
                } // if
            } // else
        } // while
        return index;
    } // searchItem

    public ItemType getNextItem() {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        } else {
            if (currentPos.next == null) {
                System.out.println("The end of the list has been reached");
                return null;
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

    public void /* int? */ mergeList(SortedLinkedList list1, SortedLinkedList list2) {

        int length1 = list1.getLength();
        int length2 = list2.getLength();


    } // mergeList

} // class
