package com.example;

/**
 * Simple Java application used to demonstrate an Apache Ant build
 * pulled and built by Jenkins.
 */
public class App {

    public String getGreeting() {
        return "Hello Jenkins, built with Ant!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
