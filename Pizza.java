/**
 * Class for instances of pizzas
 */
public class Pizza {
    private CRUST crustType;
    private SIZE size;
    private boolean[] toppings;
    private String[] topType = {"peperoni", "sausage", "ham", "cheese", "green pepper", "onion", "tomato", "mushroom",
            "pineapple"};

    /**
     * Constructor for a pizza
     * @param size Small, Medium, Large, or Extra Large
     * @param crustType Thin, Regular, Pan
     * @param toppings Boolean array to represent which toppings were chosen
     */
    public Pizza(SIZE size, CRUST crustType, boolean[] toppings) {
        this.size = size;
        this.crustType = crustType;
        this.toppings = toppings;
    }

    public int getCount() {
        return 1;
    }

    /**
     * @return Price based on size and toppings
     */
    public double calculatePrice(){
        double basePrice;
        double pricePerTopping;
        int count = 0;

        if (size.equals(SIZE.SMALL)) {
            basePrice = 4;
            pricePerTopping = 0.5;
        } else if (size.equals(SIZE.MEDIUM)) {
            basePrice = 6;
            pricePerTopping = 0.75;
        } else if (size.equals(SIZE.LARGE)) {
            basePrice = 8;
            pricePerTopping = 1;
        } else {
            basePrice = 10;
            pricePerTopping = 1.25;
        }

        for (boolean b: toppings)
            if (b)
                ++count;

        if (count >0) return basePrice + (pricePerTopping * (count-1));
        else return basePrice;
    }

    /**
     * @return size + crustType + \"crust\" + toppings as a string
     */
    public String toString() {
        String s1 = "";
        String size1, crust1;

        if (size.equals(SIZE.SMALL))
            size1 = "Small";
        else if (size.equals(SIZE.MEDIUM))
            size1 = "Medium";
        else if (size.equals(SIZE.LARGE))
            size1 = "Large";
        else
            size1 = "Extra Large";

        if (crustType.equals(CRUST.THIN))
            crust1 = "thin";
        else if (crustType.equals(CRUST.REGULAR))
            crust1 = "regular";
        else
            crust1 = "pan";

        s1 += size1 + " " + crust1 + " crust ";
        int count = 0;
        for (byte i = 0; i < toppings.length; ++i) {
            if (toppings[i]) {
                s1 += " " + topType[i] + ",";
                ++count;
            }
            if (count == 2 || count == 5)
                s1 += "\n";
        }

        return s1.substring(0,s1.length()-1);
    }
}
