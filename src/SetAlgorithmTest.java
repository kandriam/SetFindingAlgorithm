import java.util.ArrayList;

public class SetAlgorithmTest {
    static ArrayList<Card> deck = new ArrayList<Card>();
    static Integer NUMBER_OF_TRAIT_VARIANTS = 3;


    public static void createDeck() {
        deck = new ArrayList<>();
        for (int color = 0; color < NUMBER_OF_TRAIT_VARIANTS; color++) {
            for (int number = 0; number < NUMBER_OF_TRAIT_VARIANTS; number++) {
                for (int shape = 0; shape < NUMBER_OF_TRAIT_VARIANTS; shape++) {
                    for (int fill = 0; fill < NUMBER_OF_TRAIT_VARIANTS; fill++) {
                        deck.add(new Card(color, number, shape, fill));
                    }
                }
            }
        }
    }
    


    public static void main(String[] args) {
        System.out.println("Testing...");
        createDeck();

        for (Card card : deck){
            System.out.println(card.getCard());
        }
    }
}
