package csci2720.p1;

public class ItemType {
    private int value;

    public ItemType(int value) {
        this.value = value;
    } // ItemType

    public int compareTo(ItemType item) {
        if (this.value < item.getValue()) return -1;
        else if (this.value == item.getValue()) return 0;
        else return 1;
    } // compareTo

    public int getValue() {
        return this.value;
    } // getValue
} // class
