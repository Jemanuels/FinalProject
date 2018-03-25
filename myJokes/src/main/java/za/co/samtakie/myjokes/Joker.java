package za.co.samtakie.myjokes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jurgen Emanuels
 * Jokes taken from http://www.short-funny.com/#ixzz5AMtKzmvT
 */
public class Joker {

    // For this example we want to stick to only 4 Jokes
    private final static int TOTAL_RECORDS = 4;
    // jokes is of the type List which hold String values
    private List<String> jokes;
    // we want to provide random jokes to the caller, in this case the server
    private Random randomJokes;

    @SuppressWarnings("unchecked")
    // Initiate instructor to set all my jokes
    public Joker() {
        jokes = new ArrayList<>(TOTAL_RECORDS);
        jokes.add("What is the difference between a snowman and a snowwoman?");
        jokes.add("Can a kangaroo jump higher than a house?");
        jokes.add("Woman to her husband while at it: \"Please say dirty things to me!\"");
        jokes.add("My wife suffers from a drinking problem");
        randomJokes = new Random();
    }

    /**
     *
     * @return a random joke to be viewed by the server
     */
    public String getMyJokes(){
        // get a random index from the total amount of the jokes (4)
        int index = randomJokes.nextInt(jokes.size());
        // based on the index set the value of joke
        String joke = jokes.get(index).toString();
        // return the joke back to the caller
        return joke;
    }
}