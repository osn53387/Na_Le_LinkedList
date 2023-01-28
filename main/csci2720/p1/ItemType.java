package csci2720.p1;

/**
 * This ItemType class represents the data of a node.
 */
public class ItemType {

    private int value;

    /**
     * Contructor of ItemType.
     * @param value the value of ItemType
     */
    public ItemType(int value) {
        this.value = value;
    } // ItemType

    /**
     * Compares the current ItemType's value to another ItemType's value.
     * @param item the ItemType to compare
     * @return int returns -1 if current item is less than the other item,
     * 0 if equals, and 1 if greater
     */
    public int compareTo(ItemType item) {
        if (this.value < item.getValue()) return -1;
        else if (this.value == item.getValue()) return 0;
        else return 1;
    } // compareTo

    /**
     * Return the value of current ItemType
     * @return int value of ItemType
     */
    public int getValue() {
        return this.value;
    } // getValue
} // class
