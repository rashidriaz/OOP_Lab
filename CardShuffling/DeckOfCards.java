import java.security.SecureRandom;

public class DeckOfCards {

    private static final int numberOfCards = 52;
    private Card[] deck = new Card[numberOfCards];
    private int currentCardNumber = 0;
    private static final SecureRandom randomNumber = new SecureRandom();

    public DeckOfCards() {
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
                "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(faces[i % 13], suits[i / 13]);
        }
    }

    public void setCurrentCardNumber(int number) {
        currentCardNumber = number;
    }

    public void shuffle() {
        currentCardNumber = 0;
        for (int i = 0; i < deck.length; i++) {
            int second = randomNumber.nextInt(numberOfCards);

            Card temporary = deck[i];
            deck[i] = deck[second];
            deck[second] = temporary;
        }

    }

    public Card dealCard() {
        if (currentCardNumber < deck.length) {
            return deck[currentCardNumber++];
        }
        return null;
    }
}