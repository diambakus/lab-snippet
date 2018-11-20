import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ShuttleCards {

    List<Card> listOfCards = new ArrayList<>();

    public ShuttleCards() {

        Card[] cards = new Card[52];
        int count = 0;

        for (Card.Suit suit: Card.Suit.values()) {
            for (Card.Face face: Card.Face.values()) {
                cards[count++] = new Card(face, suit);
            }
        }

        listOfCards = Arrays.asList(cards);
        Collections.shuffle(listOfCards);
    }

    public void printCards() {
        for (int i = 0; i < listOfCards.size(); i++) {
            System.out.printf("%-19s%s", listOfCards.get(i),
            ((((i+1)%4) == 0) ? "%n" : ""));
        }
    }
    
    public static void main(String[] args) {
        ShuttleCards shuttleCards = new ShuttleCards();
        shuttleCards.printCards();
    }
}