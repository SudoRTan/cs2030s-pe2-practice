# Additional Exercises for Functional Programming
Provided as is, I (probably) won't release 'model' answers.


For each Task, an accompanying Test is avaiable and can be run similar 
to your labs/exs. For example, to test Task1, run
```
java -cp test.jar:. Test1
``` 
Remember to compile all java files first.

**Functional Programming classes provided in cs2030s are identical to the ones provided by the labs**
**HOWEVER, IT DOES NOT HAVE `InfiniteList::append()` You can complete everything without it, but it bothers you go ahead and copy your ex7 into here**
**`InfiniteList::append()` is not included as it may not be part of the PE2 API, hence some more complex questions may not appear in your test. IDK** 


> You are a Chef managing a *special* kitchen, and decided *for some reason* to 
> model your ingredients using Java. Solve the following tasks below.

## Task 1
> You've created the initial Ingredient class when you first learnt 
> how to code. Since then, you've discovered a new concept known as 
> 'Immutability'. You want to implement this in your old base class, 
> and might as well fix any issues along the way.

Make `Ingredient` **Immutable** and update it's String representation to the following:

For `Ingredient("Apple", 1)`
    return "[Apple: 1]"

For `Ingredient("Pineapple", 5).prepare()`
    return "{Pineapple | 5}"

Note that you **ARE NOT ALLOWED** to create additional constructors.

## Task 2
> To make your future code more flexible, you decided to make it possible for 
> future methods to use your Ingredient class in various ways using a 
> ... panda? That sounds wrong, but you're going to try using it anyway.

Create a Functional Interface `IngredientPanda`, with the method `run()` that takes in an instance of 
`Ingredient` and returns an `Ingredient`.

## Task 3

> In your old code, you managed your Ingredients in a massive array.
> However, your best friend, Nishikawa, who had taken 
> Dr Adi Yoga Sidi PRABAWA's Fantastic CS2030S course, wanted to give
> you a challenge and gave you the InfiniteList class used in the course
> the course for you to use. You decide to use this to implement
> a Basket to store all your ingredients.

Implement the class `Basket` using InfiniteList. 
A rough class has been provided.

It should have the following:

- `Basket(InfiniteList<???>) and Basket(List<???>)`
    - Constructors to create a `Basket` from a InfiniteList/List of `Ingredient`
- `getList()`
    - Returns an InfiniteList of the 'Ingredient'
- `releaseThePanda(IngredientPanda)`
    - Executes the `IngredientPanda` on all `Ingredient` in your `Basket`, 
      and updates the InfiniteList within the `Basket`, and returns the 
      new Basket with the modified InfiniteList.
- `toString()`
    - Returns the list of Ingredient in the format: 
    - `\ ^ Ingredient1 ^ Ingredient2 ^ ... ^ Ingredient# ^ /`
    - For example, a Basket with \
    `Ingredient("Apple", 1).prepare(), Ingredient("Banana", 5).prepare(), Ingredient("Pear", 10)` should return \
    - `\ ^ [Apple: 1] ^ [Banana: 5] ^ {Pear | 10} ^ /`
- `equal()`
    - Returns true if and only if for two `Basket`s `A` and `B`
        - For each `Ingredient` in `A`, `A` and `B` both the same amount, as directed by `Ingredient::equals` \
        For example:
        `\ ^ [Apple: 1] ^ [Apple: 4] ^ /` and ``\ ^ {Apple | 10} ^ {Apple | 5} ^ /` is equal, but \
        `\ ^ [Apple: 1] ^ [Apple: 4] ^ /` and ``\ ^ {Pear | 10} ^ {Apple | 10} ^ {Apple | 5} ^ /` is not


Note that it does not need to be functional (yet), but functional solutions may be avaliable.


## Task 4
> Your head chef, Alice, realised an issue with your current setup: 
> There can only be whole counts of Ingredients. However, your Ingredients
> sometimes come in parts, such as 3.6 Kg of beef or 3.9 L of Worcestershire > sauce. 

Modify your code to allow `Ingredient`'s weight to be represented with a `float`


# For the following Tasks, they are to be completed in functiional-style in Task#.java

##### Yes this is kinda violating OOP principles but we're not testing that here. :)

## Task 5 
> Dinner rush is starting soon, and its time to prepare for it.

Implement Task5:
Given a `Basket`, prepare all the `Ingredient`s in it that have not already been prepared, and return the updated basket containing only the newly prepared `Ingredient`s.

For example, if the `Basket` contains
- `\ ^ [Apple: 1.0] ^ [Banana: 5.0] ^ {Pear | 10.0} ^ {Orange | 20.0} ^ /`
Return only
- `\ ^ [Pear: 10.0] ^ [Orange: 20.0] ^ /`


## Task 6
> Your Sous Chef, Bob, has requested a means of calculating the total weight of Ingredients in a given Basket.

Implement Task6:
Given a `Basket`, return the total weight of the `Ingredients`.

## Task 7
> During your dinner rush, due to a lack of manpower, you had no choice 
> but to ask your Kitchen Porter Mallory to handle your baskets. 
> Unfortunately, he has no idea what hes doing, and somehow managed to 
> fabricate negative-weight and zero-weight Ingredients. 

Implement Task7:
Given a `Basket`, remove all negative and zero weight `Ingredients`, 
and return the updated Basket

## Task 8
> You have went on a grocery run, and are now carrying multiple `Basket`. 
> However, these belong to the store, so you have to transfer them to your
> Truck of Holding (which is essentially a infintely sized `Basket`)

Implement Task8:
Given a InfiniteList of Baskets, return a single Basket 

## Task 9
> Your restaruant is special, and houses a secret - The *Superposition Cheese*, given to you from from Dr Erwin. 
> Once produced, this cheese can exist simultanously in all places, until 
> it's state changes

Implement Task9:
Given a side-effect free, pure Producer that returns an Ingredient, return it's memoized Producer


## Task 10:
> Dr Erwin has returned with more variations of Cheese. You now need to handle the differnt types

Implement Task10:
Given a `InfiniteList<Pair<String, Producer>>` pairs and a `InfiniteList<String>` containing the required types, return a `Basket` containing the `Ingredient` lazily produced by the Producer.

For example, 
If `InfiniteList<String>` contains ["Gouda", "Gouda", "Cheddar"], the final Basket should contain 2 Guodas and 1 Cheddar
If `InfiniteList<String>` contains [], the final basket should be empty.

You are guranteed that for a given `String` in `InfiniteList<String>`, a matching pair exists in `InfiniteList<Pair<String, Producer>>`

The order does not matter. The correctness is evaluated using `Basket::equals`

## Task 11:
> While checking your stock, you realised that your basket's have multiple `Ingredients` of the same name but 
> packaged seperately. You decide to collate a list of unique `Ingredient` 
> names to label the box with.

Implement Task11:
Given a `Basket`, return an `InfiniteList<String>` containing the unique kinds of the `Ingredient` within. Note that they are to appear in order they appear within the `Basket`

For example:
- `\ ^ {Banana | 3.0} ^ {Apple | 2.0} ^ {Pear | 10.0} ^ {Orange | 20.0} ^ /` \ 
Should appear as ["Banana", "Apple", "Pear", "Orange"]


## Task 12:
> Alongside your *Superposition Cheeses*, your restaurant's also has a
> contract with a resident of *Punklorde*, giving you the ability to
> revert your `Ingredient` back to it's nprepared state via
> *Aether Editing*. You've decided to merge all matching `Ingredient`s 
> within a `Basket` into a single `Ingredient`. You find it simplier
> to revert a prepared `Ingredient` to its unprepared state rather than 
> prepare the rest of the unprepared ingredients.

Implement Task12:
Given a `Basket`, merge duplicate `Ingredients` into a single unique `Ingredient`, with its weight being the total sum of the `Ingredients`. 
Additonally, if any `Ingredient` is not prepared, the new combined `Ingredient` should not be prepared as well. 

Return the `Basket` with the updated `InfiniteList` 

For example: \
`\ ^ [Egg: 2.0] ^ {Egg | 2.0} ^ [Rice: 2.0] ^ {Oil | 1.0} ^ /` \
Should be merged into \
`\ ^ {Egg | 4.0} ^ [Rice: 2.0] ^ {Oil | 1.0} ^ /` \

Note that similar to Task 11, the order of the `Ingredients` should be the same order that they appear in the `InfiniteList`


## Task 13
> It is a big day, and you have a special guest from America, Mr S. Silence, 
> who has booked your entire restaruant and brought along his *entire* 
> extended family. 
> Naturally, all hands are on deck. Unsurprisingly, Mallory messed up again (why haven't you fired him yet?). 
> During the dinner rush, he had somehow. Created even more negative and zero 
> weight ingredients, transferred prepared and unprepared `Ingredients` 
> between baskets, and generally caused a huge pain for everyone in the 
> restaurant. After dinner service, you and the team collectively got 
> together to account for your stocks. 

Implement Task13:
Given an InfiniteList of `Baskets`, alongside an `IngredientPanda` dinnerService.

Remove all invalid `Ingrediants`, combine them into Unique `Ingrediants`, and consolidate them into a single `Basket` after completing dinner service.

Note that the order matters, and the baskets will need to be merged in the order that it appears within the `InfiniteList<Basket>`

For example, 
[
    new Basket(List.of(
        new Ingredient("Apple", 1), 
        new Ingredient("Orange", 4), 
        new Ingredient("Pear", 4).prepare(), 
    )),
    new Basket(List.of(
        new Ingredient("Pear", 8), 
        new Ingredient("Apple", 10).prepare(), 
    )),
],
DinnerService: ing -> ing.consume(2)
Should be have a final output of 
`\ ^ {Orange | 2.0} ^ {Pear | 8.0} ^ [Apple: 8.0] ^ /`