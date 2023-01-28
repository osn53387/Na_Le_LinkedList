package csci2720.p1;

/**
 * This class is a structure of a sorted linked list.
 */
public class SortedLinkedList {

    private NodeType head; // head of the linked list
    private NodeType currentPos; // current position of the pointer (starts with head)

    /**
     * Construct a sorted linked list object.
     */
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

    /**
     * Returns the length of the list.
     * @return int length of the list
     */
    public int getLength() {
        int size = 0;
        while (currentPos != null) {
            size++;
            currentPos = currentPos.next;
        } // while
        currentPos = head;
        return size;
    } // getLength

    /**
     * Insert an item in the list and sort it accordingly in ascending order.
     * @param item the item to be inserted
     * @throws exception if there is a duplicate item
     */
    public void insertItem(ItemType item) throws Exception {
        if (head == null) { // no item in the list
            head = new NodeType();
            head.info = item;
            currentPos = head;
        } else {
            while (currentPos != null) {
                if (currentPos.next == null) { // only one item in the list
                    if (currentPos.info.getValue() == item.getValue()) {
                        currentPos = head;
                        throw new Exception();
                    } else if (currentPos.info.getValue() < item.getValue()) { // insert after item
                        NodeType temp = new NodeType();
                        temp.info = new ItemType(item.getValue());
                        currentPos.next = temp;
                        break;
                    } else { // insert before item
                        NodeType temp = new NodeType();
                        temp.info = new ItemType(item.getValue());
                        temp.next = currentPos;
                        head = temp;
                        break;
                    } // else
                } else if (currentPos.info.getValue() == item.getValue()) { // duplicate item
                    currentPos = head;
                    throw new Exception();
                } else {
                    if (head.info.getValue() == currentPos.info.getValue()
                    && currentPos.info.getValue() > item.getValue()) { // beginning of the list
                        NodeType temp = new NodeType();
                        temp.info = new ItemType(item.getValue());
                        temp.next = currentPos;
                        head = temp;
                        break;
                    } else if (currentPos.info.getValue() < item.getValue()
                    && currentPos.next.info.getValue() > item.getValue()) { // middle of the list
                        NodeType temp = new NodeType();
                        temp.info = new ItemType(item.getValue());
                        temp.next = currentPos.next;
                        currentPos.next = temp;
                        break;
                    } else { // increment currentPos if can't insert
                        currentPos = currentPos.next;
                    }
                } // else
            } // while
        } // else
        currentPos = head;
    } // insertItem

    /**
     * Delete the desired item in the list.
     * @param item the item to be deleted from the list
     */
    public void deleteItem(ItemType item) {
        if (head == null) { // delete from empty list case
            System.out.println("You cannot delete from an empty list");
        } else {
            while (currentPos != null) {
                if (currentPos.info.getValue() == head.info.getValue()
                && currentPos.info.getValue() == item.getValue()) { // delete first element
                    head = head.next;
                    break;
                } else if (currentPos.next == null) { // if at the end of list
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
                } else if (currentPos.next.info.getValue() == item.getValue()) { // last element
                    currentPos.next = currentPos.next.next;
                    break;
                } // else
            } // while
        } // else
        currentPos = head;
    } // deleteItem

    /**
     * Search for the desired item and return its index in the list.
     * @param item the item to be searced.
     * @return the index of the item
     */
    public int searchItem(ItemType item) {
        int index = 1;
        if (head == null) {
            System.out.println("Item not found");
            return -1; // placeholder for nonexisting item
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
        return -1; // placeholder for nonexisting item
    } // searchItem

    /**
     * Get the next item in the list. If the end of list is reached, points back to head.
     * @return the next item in the list
     */
    public ItemType getNextItem() {
        if (head == null) {
            System.out.println("The list is empty");
            return null;
        } else {
            if (currentPos == null) { // reset currentPos if end of list has been reached
                currentPos = head;
                ItemType temp = new ItemType(currentPos.info.getValue());
                currentPos = currentPos.next;
                System.out.println(temp.getValue());
                return temp;
            } else {
                ItemType temp = new ItemType(currentPos.info.getValue());
                currentPos = currentPos.next;
                System.out.println(temp.getValue());
                return temp;
            } // else
        } // else
    } // getNextItem

    /**
     * Reset the currentPos pointer back to head.
     */
    public void resetList() {
        currentPos = head;
    } // resetList

    /**
     * Merge two list together and return the merged list.
     * @param original the original list
     * @param list2 the second list
     * @return the merge list
     */
    public SortedLinkedList mergeList(SortedLinkedList original, SortedLinkedList list2) {
        while (original.currentPos != null) {
            try {
                list2.insertItem(original.currentPos.info);
            } catch (Exception e) {} // catch
            original.currentPos= original.currentPos.next;
        }
        currentPos = head;
        return list2;
    } // mergeList

    /**
     * Delete alternate nodes of the list and return the new list.
     * @param list delete the alternate nodes of the given list
     * @return the new list after deletion
     */
    public SortedLinkedList deleteAltNodes(SortedLinkedList list) {
        if (head == null) { // The empty list
            System.out.println("The list is empty");
            return new SortedLinkedList();
        } else {
            currentPos = head;
            SortedLinkedList outputList = new SortedLinkedList();
            try {
                if (currentPos.next == null) { // the only element in the list
                    outputList.insertItem(currentPos.info);
                } else if (currentPos.next.next == null) { // there are two elements in the list
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
        } // else
    } // deleteAtlNodes

    /**
     * Find the intersection of two lists and return the intersected list.
     * @param original the original list
     * @param list2 the second list
     * @return the intersected list of the two
     */
    public SortedLinkedList intersection(SortedLinkedList original, SortedLinkedList list2) {
        if (original.getLength() == 0 || list2.getLength() == 0) { // if either of lists are empty
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
    } // intersection
} // class
