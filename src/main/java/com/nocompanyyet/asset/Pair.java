package com.nocompanyyet.asset;

// supporting simple class for pair of elements, allows not to use inconvenient Set or List in our case for our game
public class Pair<T> {
    private T first, second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public Pair() {}

    public void setFirst(T first) {
        this.first = first;
    }
    public void setSecond(T second) {
        this.second = second;
    }
    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }
}