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
        System.out.print("  ");
        while (this.currentPos != null) {
            System.out.print(this.currentPos.info.getValue() + " ");
            this.currentPos = this.currentPos.next;
        } // while
        currentPos = head;
        System.out.println();
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

    public void insertItem(ItemType item) throws Exception {
        if (head == null) {
            head = new NodeType();
            head.info = item;
            currentPos = head;
        } else {
            while (currentPos != null) {
                if (currentPos.next == null) {
                    if (currentPos.info.getValue() == item.getValue()) {
                        //System.out.println("Sorry. You cannot insert the duplicate item.");
                        currentPos = head;
                        throw new Exception();
                        //break;
                    } else if (currentPos.info.getValue() < item.getValue()) {
                        NodeType temp = new NodeType();
                        temp.info = new ItemType(item.getValue());
                        currentPos.next = temp;
                        break;
                    } else {
                        NodeType temp = new NodeType();
                        temp.info = new ItemType(item.getValue());
                        temp.next = currentPos;
                        head = temp;
                        break;
                    } // else
                } else if (currentPos.info.getValue() == item.getValue()) {
                    //System.out.println("Sorry. You cannot insert the duplicate item.");
                    currentPos = head;
                    throw new Exception();
                    //break;
                } else {
                    if (head.info.getValue() == currentPos.info.getValue()
                    && currentPos.info.getValue() > item.getValue()) {
                        NodeType temp = new NodeType();
                        temp.info = new ItemType(item.getValue());
                        temp.next = currentPos;
                        head = temp;
                        break;
                    } else if (currentPos.info.getValue() < item.getValue()
                    && currentPos.next.info.getValue() > item.getValue()) {
                        NodeType temp = new NodeType();
                        temp.info = new ItemType(item.getValue());
                        temp.next = currentPos.next;
                        currentPos.next = temp;
                        break;
                    } else {
                        currentPos = currentPos.next;
                    }
                } // else
            } // while
        } // else
        currentPos = head;
    } // insertItem

    public void deleteItem(ItemType item) {
        if (head == null) { // delete from empty list case
            System.out.println("You cannot delete from an empty list");
        } else {
            while (currentPos != null) {
                if (currentPos.info.getValue() == head.info.getValue()
                && currentPos.info.getValue() == item.getValue()) { // delete first element
                    head = head.next;
                    break;
                } else if (currentPos.next == null) {
                    if (currentPos.info.getValue() == item.getValue()) {
                        head = null;
                    } else {
                        System.out.println("Item not found");
                    }
                    break;
                } else if (currentPos.next.info.getValue() != item.getValue()) {
                    currentPos = currentPos.next;
                    if (currentPos.next == null) { // cannot find element
                        System.out.println("Item not found");
                        break;
                    }
                } else if (currentPos.next.info.getValue() == item.getValue()) { // last elem
                    currentPos.next = currentPos.next.next;
                    break;
                } // else
            } // while
        } // else
        currentPos = head;
    } // deleteItem

    public int searchItem(ItemType item) {
        int index = 0;
        if (head == null) {
            System.out.println("Item not found");
            return -1;
        } // if
        while (currentPos != null) {
            if (currentPos.info.getValue() == item.getValue()) {
                currentPos = head;
                return index;
            } else {
                index++;
                currentPos = currentPos.next;
            } // else
        } // while
        currentPos = head;
        return -1;
    } // searchItem

    public ItemType getNextItem() {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        } else {
            if (currentPos == null) {
                currentPos = head;
                ItemType temp = new ItemType(currentPos.info.getValue());
                currentPos = currentPos.next;
                return temp;
            } else {
                ItemType temp = new ItemType(currentPos.info.getValue());
                currentPos = currentPos.next;
                return temp;
            } // else
        } // else
    } // getNextItem

    public void resetList() {
        currentPos = head;
    } // resetList

    public SortedLinkedList mergeList(SortedLinkedList original, SortedLinkedList list2) {
        while (list2.head != null) {
            try {
                original.insertItem(list2.head.info);
            } catch (Exception e) {} // catch
            list2.head = list2.head.next;
        }
        head = original.head;
        return original;
    } // mergeList


    public SortedLinkedList deleteAltNodes(SortedLinkedList list) {
        if (head == null) {
            System.out.println("The list is empty");
            return null;
        } else {
            currentPos = head;
            SortedLinkedList outputList = new SortedLinkedList();
            try {
                if (currentPos.next == null) { // the only element in the list
                    outputList.insertItem(currentPos.info);
                } else if (currentPos.next.next == null) {
                    outputList.insertItem(currentPos.info);
                } else {
                    while (currentPos.next.next != null) {
                        outputList.insertItem(currentPos.info);
                        currentPos = currentPos.next.next;
                        if (currentPos.next == null) {
                            outputList.insertItem(currentPos.info);
                            break;
                        } else if (currentPos.next.next == null) {
                            outputList.insertItem(currentPos.info);
                            break;
                        } // if-else
                    } // while
                } // else
            } catch (Exception e) {
            } // catch
            head = outputList.head;
            currentPos = head;
            return outputList;
        }

    } // deleteAtlNodes



    public SortedLinkedList intersection(SortedLinkedList original, SortedLinkedList list2) {
        if (original.getLength() == 0 || list2.getLength() == 0) {
            return new SortedLinkedList();
        } else {
            SortedLinkedList intersectedList = new SortedLinkedList();
            SortedLinkedList temp = new SortedLinkedList();
            temp.head = list2.head;
            while (original.currentPos != null) {
                while(temp.head != null) {
                    if (original.currentPos.info.getValue() == temp.head.info.getValue()) {
                        try {
                            intersectedList.insertItem(new ItemType(temp.head.info.getValue()));
                        } catch (Exception e) {}
                    }
                    temp.head = temp.head.next;
                } // while
                temp.head = list2.head;
                original.currentPos = original.currentPos.next;
            } // while
            currentPos = head;
            return intersectedList;

        } // intersection
    }

} // class
