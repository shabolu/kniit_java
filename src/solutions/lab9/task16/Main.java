package solutions.lab9.task16;

import java.util.ArrayList;
import java.util.List;

enum Suit {
    SPADES("Пики"),
    HEARTS("Черви"),
    DIAMONDS("Бубны"),
    CLUBS("Трефы");

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// 2. Enum для значений (Rank)
enum Rank {
    TWO("2"), THREE("3"), FOUR("4"), FIVE("5"),
    SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
    JACK("Валет"), QUEEN("Дама"), KING("Король"), ACE("Туз");

    private final String displayName;

    Rank(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " " + suit;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }

        System.out.println("Сгенерированная колода (" + deck.size() + " карт):");
        int counter = 0;
        for (Card card : deck) {
            System.out.print(card + ", ");
            counter++;
            if (counter % 13 == 0) {
                System.out.println();
            }
        }
    }
}