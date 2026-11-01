public class Ingredient {
    String kind;
    int weight;
    boolean prepared;
    
    Ingredient(String kind, int weight) {
        this.kind = kind;
        this.weight = weight;
        this.prepared = false;
    }

    /**
     * Get the kind of Ingredient.
     * 
     * @return The kind of Ingredient.
     */
    String getKind() {
        return kind;
    }

    /**
     * Get the weight of Ingredients.
     * 
     * @return The weight of Ingredients
     */
    int getWeight() {
        return weight;
    }

    /**
     * Checks to see if the Ingredient are prepared
     * 
     * @return  True if the ingredient is prepared
     *          False otherwise
     */
    boolean isPrepared() {
        return prepared;
    }

    /**
     * Consume the Ingredients. Returns the
     * Ingredient with the remaining amount left.
     * 
     * @param amount    The amount of ingredient to consume.
     * @return          The Ingredient with the remaining amount.
     */
    Ingredient consume(int consume) {
        this.weight -= consume;
        return this;
    }

    /**
     * Prepares the Ingredient. 
     * 
     * @return  The prepared Ingredient.
     */
    Ingredient prepare() {
        prepared = true;
        return this;
    }

    /**
     * Return a String representation of Ingredient.
     * 
     * @return A String representation of a Ingredient.
     */
    public String toString() {
        return this.kind;
    } 

    /**
     * Check if two Ingredient are equal.  Two Ingredient
     * are equal if they are the same kind regardless
     * of the amount or if the Ingredients are prepared.
     * 
     * YOU DO NOT NEED TO MODIFY THIS
     * 
     * @param obj The other Ingredient to be compared.
     * @return    True if the two Ingredient are equal.
     *            Return false otherwise.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Ingredient) {
            Ingredient ingredient = (Ingredient) obj;
            return this.kind == ingredient.kind;
        }

        return false;
    }
}   