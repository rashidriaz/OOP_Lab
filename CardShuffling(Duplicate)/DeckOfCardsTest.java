public class DeckOfCardsTest {

    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        int count = 0;
        boolean ace = false;
        String[] result = new String[52];
        while (!ace) {
            myDeckOfCards.shuffle();
            count++;
            for (int i = 0; i < 13; i++) {

                int aces = 0;

                for (int j = 0; j < 4; j++) {
                    result[i + j] = myDeckOfCards.dealCard().toString();
                    if (myDeckOfCards.getFace().equals("Ace")) {
                        aces++;

                    } else if (aces > 0) {

                        break;
                    }
                }

                if (aces == 4) {
                    ace = true;
                    aces = 0;

                } else if (aces > 0) {
                    break;

                }
            }
        }
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-19s ", result[i+j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.printf("The Sequence Came After %d Shuffles", count);
    }
}