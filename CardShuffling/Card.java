public class Card{

    private final String suit;
    private final String face;

    public Card(){
        suit = null;
        face = null;
    }
    public Card(String face, String suit){
        this.face = face;
        this.suit = suit;
    }

    public String toString(){
        return (face + " of " + suit);
    }
    public String getFcae(){
        return face;
    }
    
}