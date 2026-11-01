import cs2030s.fp.*;
import java.util.List;
 
public class Basket {
    /**
     * Public constructor for Basket.
     * 
     * @param infList InfiniteList of Ingredient
     */
    public Basket(InfiniteList<Object> infList) {

    }

    /**
     * Public constructor for Basket.
     * 
     * @param list List of Ingredient
     */
    public Basket(List<Object> list) {

    }

    /**
     * Get the Ingredients as a InfiniteLiszt.
     * 
     * @return The Ingredients as InfiniteList.
     */
    public InfiniteList<Object> getList() {
        return null;
    }


    /**
     * Runs the lambda on all elements of the InfiniteList
     * 
     * @param ingredientPanda   The lambda to be run on all 
     *                          Ingredients in the basket
     * 
     * @return                  The Basket with the modified InfiniteList 
     */
    public Basket releaseThePanda(Object ingredientPanda) {
        return this;
    }

    /**
     * Returns the string representation of the class
     * 
     */
    public String toString() {
        return "This Is A Bucket";
    }

    public boolean equals(Object obj) {
        if (obj instanceof Basket other) {
            return true;
        }
        return false;
    } 
}