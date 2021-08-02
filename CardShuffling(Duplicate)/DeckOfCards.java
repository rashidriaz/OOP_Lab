import java.security.SecureRandom;

public class DeckOfCards {

    private static final int NUMBER_OF_CARDS = 52;
    private Card[] deck = new Card[NUMBER_OF_CARDS];
    private int currentCard;
    private static final SecureRandom rand = new SecureRandom();

    public DeckOfCards() {
        currentCard = 0;
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
                "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(faces[i % 13], suits[i / 13]);
        }
    }

    public void shuffle(){
        currentCard = 0;
        for (int first = 0; first < deck.length; first++) {
            int second = rand.nextInt(NUMBER_OF_CARDS);
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }

    }

    public String getFace(){
        return deck[(currentCard - 1)].getFcae();
    }

    public Card dealCard(){
        if (currentCard < deck.length) {
            return deck[currentCard++];
        }
        return null;
    }
}