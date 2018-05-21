package treeSet;

import java.util.Objects;

/*----------------------------------------------------------------
 *  Author:        Zhang Xuan
 *  Written:       2018/5/16
 *  Last updated:  2018/5/16
 *  Compilation:   javac Item.java
 *  Execution:     java HelloWorld
 *  Description: 
 *
 *----------------------------------------------------------------*/
public class Item implements Comparable<Item>{

    private String description;
    private int partNumber;

    /**
     * Constructs an item
     * @param description The item's description
     * @param partNumber  the item's partNumber
     */
    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (partNumber != item.partNumber) return false;
        return description != null ? description.equals(item.description) : item.description == null;
    }

    @Override
    public int hashCode() {
       return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(partNumber, o.partNumber);

        return diff != 0 ? diff : description.compareTo(o.description);
    }
}
