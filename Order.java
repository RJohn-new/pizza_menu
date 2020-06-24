import java.util.ArrayList;

/**
 *  Class for an instance of an order
 */
public class Order {
    private ArrayList<Pizza> pizzas;
    private ArrayList<Drink> drinks;
    private ArrayList<Side> sides;


    /**
     * Constructor for the order
     * @param pizzas list of pizzas
     * @param drinks list of drinks
     * @param sides list of sides
     */
    public Order(ArrayList<Pizza> pizzas, ArrayList<Drink> drinks, ArrayList<Side> sides) {
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.sides = sides;
    }

    /**
     * @return The list of pizzas
     */
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * @return The list of drinks
     */
    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    /**
     * @return The list of sides
     */
    public ArrayList<Side> getSides() {
        return sides;
    }

    /**
     * @param newPizza Pizza object to be added to the list of pizzas
     */
    public void addPizza(Pizza newPizza) {
        pizzas.add(newPizza);
    }

    /**
     * @param unPizza Pizza object to be removed from the list of pizzas
     */
    public void removePizza(Pizza unPizza) {
        pizzas.remove(unPizza);
    }

    /**
     * @param newDrink Drink object to be added to the list of drinks
     */
    public void addDrink(Drink newDrink) {
        for (Drink d: drinks) {
            if (d.getType().equals(newDrink.getType()) && d.getSize().equals(newDrink.getSize())) {
                d.setCount(d.getCount() + 1);
                return;
            }
        }
        drinks.add(newDrink);
    }

    /**
     * @param unDrink Drink object to be removed from the list of drinks
     */
    public void removeDrink(Drink unDrink) {
        int index = drinks.indexOf(unDrink);
        if (drinks.get(index).getCount() > 1)
            drinks.get(index).setCount(unDrink.getCount()-1);
        else {
            drinks.remove(unDrink);
        }
    }

    /**
     * @param newSide Side object to be added to the list of sides
     */
    public void addSide(Side newSide) {
        for (Side s: sides) {
            if (s.getType().equals(newSide.getType())) {
                s.setCount(s.getCount() + 1);
                return;
            }
        }
        sides.add(newSide);
    }

    /**
     * @param unSide Side object to be removed from the list of sides
     */
    public void removeSide(Side unSide) {
        int index = sides.indexOf(unSide);
        if (sides.get(index).getCount() > 1)
            sides.get(index).setCount(unSide.getCount()-1);
        else
            sides.remove(unSide);
    }

    /**
     * @return Price of all pizzas + drinks + sides
     */
    public double getSubTotal() {
        double total = 0;

        for (Pizza p: pizzas) {
            total += p.calculatePrice();
        }
        for (Drink d: drinks) {
            total += d.price * d.getCount();
        }
        for (Side s: sides) {
            total += s.getPrice();
        }
        return total;
    }

    /**
     * @return Subtotal plus tax
     */
    public double getFinalPrice() {
        return getSubTotal() * 1.06;
    }

}
