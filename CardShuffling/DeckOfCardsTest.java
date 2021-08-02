//Author : Raashid Riaz - FA19_BSE_081
public class DeckOfCardsTest {

    private static DeckOfCards deck = new DeckOfCards();
    private static int numberOfTimesCardsShuflled = 0;
    private static boolean allAces = false;

    public static void main(String[] args) {

        while (!allAces) {
            shuffleCards();
            getResults();
        }
        printHorizontalLineOfEquals();
        printResults();
        printHorizontalLineOfEquals();
        addTwoLineBreaks();
        System.out.println("Cards Shuffled for " + numberOfTimesCardsShuflled + " times");
        printHorizontalLineOfEquals();

    }

    private static void getResults() {
        for (int i = 0; i < 13; i++) {

            int aces = 0;

            for (int j = 0; j < 4; j++) {
                Card currentCard = deck.dealCard();
                boolean faceIsAce = currentCard.getFcae().equals("Ace");
                if (faceIsAce) {
                    aces++;

                } else if (aces > 0) {

                    break;
                }
            }

            if (aces == 4) {
                allAces = true;
                aces = 0;
                deck.setCurrentCardNumber(0);
                break;

            } else if (aces > 0) {
                break;

            }
        }
    }

    private static void printResults() {
        for (int i = 1; i <= 52; i++) {
            System.out.printf("%-19s\t", deck.dealCard());
            if (i % 4 == 0) {
                addTwoLineBreaks();
            }

        }
    }

    private static void shuffleCards() {
        deck.shuffle();
        numberOfTimesCardsShuflled++;
    }

    private static void printHorizontalLineOfEquals() {
        System.out.print(
                "\n\n====================================================================================================================\n");
    }

    private static void addTwoLineBreaks() {
        System.out.print("\n\n");
    }
}