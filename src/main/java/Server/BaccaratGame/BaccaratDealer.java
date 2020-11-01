package Server.BaccaratGame;

import java.util.ArrayList;
import java.util.Random;

import Server.BaccaratGame.Card;

public class BaccaratDealer {
    public ArrayList<Card> deck;
    private String[] suits;

    public BaccaratDealer() {
        this.deck = new ArrayList<>();
        this.suits = new String[] { "clubs", "diamonds", "hearts", "spades" };
    }

    public static void main(String[] args) {
        BaccaratDealer b = new BaccaratDealer();
        b.generateDeck();
        System.out.println(b.deck);
    }

    public void generateDeck() {
        this.generateRandomDeck(52);
    }

    private void generateRandomDeck(int size) {
        final int paramSuits = (suits.length - 1) + 1;
        final int paramVals = (13 - 1) + 1;

        for (int i = 0; i < size; i++) {
            boolean contains = true;
            Card c = null;

            while (contains) {
                Random rand = new Random();
                String suit = this.suits[rand.nextInt(paramSuits)];
                int val = rand.nextInt(paramVals) + 1;

                c = new Card(suit, val);
                contains = this.deck.contains(c);
            }
            this.deck.add(c);
        }
    }

    public ArrayList<Card> dealHand() {
        return null;
    }

    public Card drawOne() {
        Random rand = new Random();
        int i = rand.nextInt(this.deck.size());
        return this.deck.remove(i);
    }

    public void shuffleDeck() {
        this.generateRandomDeck(this.deck.size());
    }

    public int deckSize() {
        return this.deck.size();
    }
}