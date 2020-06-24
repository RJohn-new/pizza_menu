/**
 * Class for drinks
 */
public class Drink {
    private String type;
    private int count;
    private SIZE size;
    /**
     * All drinks are $1.00
     */
    public final double price = 1.00;

    /**
     * Constructor for a drink
     * @param type name of the drink
     * @param size small, medium, or large
     * @param count number of drinks of this size and type
     */
    public Drink(String type, SIZE size, int count) {
        this.type = type;
        this.size = size;
        this.count = count;
    }

    /**
     * @return the type of drink
     */
    public String getType() {
        return type;
    }

    /**
     * @return small, medium, or large
     */
    public SIZE getSize() {
        return size;
    }

    /**
     * @return The number of this type and size of drink
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the number of this drink in the order
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return The size and type of the drink
     */
    public String toString() {
        String size1;
        if (size.equals(SIZE.SMALL))
            size1 = "Small";
        else if (size.equals(SIZE.MEDIUM))
            size1 = "Medium";
        else
            size1 = "Large";
        return size1 + " " +type + " ";
    }
}
