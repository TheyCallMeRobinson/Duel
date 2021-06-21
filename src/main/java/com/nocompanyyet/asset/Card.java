package com.nocompanyyet.asset;

public class Card {
    private Integer value;

    public Card(Integer value) {
        this.value = value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;

        Card card = (Card) o;

        return card.getValue().equals(value);
    }

    @Override
    public int hashCode() {
        int result = 12;
        result = 2 * result + value;
        return result;
    }
}
