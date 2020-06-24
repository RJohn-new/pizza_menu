/**
 * Class for the offered sides
 */
public class Side {
    private SIDE_TYPE type;
    private int count;

    /**
     * Constructor for a Side order
     * @param type enumeration of the side_types
     * @param count number of this type of side
     */
    public Side(SIDE_TYPE type, int count) {
        this.type = type;
        this.count = count;
    }

    /**
     * @return the type of side
     */
    public SIDE_TYPE getType() {
        return type;
    }

    /**
     * @param count the number of this type ordered
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the number of this type in the order
     */
    public int getCount() {
        return count;
    }
    /**
     * @return Price of the side * number of the item (count)
     */
    public double getPrice() {
        if (type.equals(SIDE_TYPE.BREAD_STICKS))
            return 2*getCount();
        if (type.equals(SIDE_TYPE.BREAD_BITES))
            return 2*getCount();
        else
            return 4*getCount();

    }

    /**
     * @return string of the type of side
     */
    public String toString() {
        if (type.equals(SIDE_TYPE.BREAD_STICKS))
            return "Bread Sticks";
        else if (type.equals(SIDE_TYPE.BREAD_BITES))
            return "Bread Bites";
        else
            return "Chocolate Chip Cookie";
    }
}
