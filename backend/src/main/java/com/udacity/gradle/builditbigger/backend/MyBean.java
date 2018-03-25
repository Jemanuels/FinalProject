package com.udacity.gradle.builditbigger.backend;

import za.co.samtakie.myjokes.Joker;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    // create a variable myJokes from the object Joker (Java Lib myJokes)
    private Joker myJokes;

    // Create a public method that will a new Joker
    public MyBean() {
        myJokes = new Joker();
    }

    //public method to return the joke
    public String getMyJokes() {
        return myJokes.getMyJokes();
    }

}