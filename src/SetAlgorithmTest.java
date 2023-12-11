import java.util.ArrayList;


public class SetAlgorithmTest {
    static ArrayList<Card> deck = new ArrayList<Card>();
    static Integer NUMBER_OF_TRAIT_VARIANTS = 3;
    static SetAlgorithm algorithm = new SetAlgorithm();



    public static void createDeck() {
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

    public static ArrayList<ArrayList<Card>>  test1(){
        ArrayList<Card> startHand = new ArrayList<Card>();
        startHand.add(new Card(0, 0, 0, 0));
        startHand.add(new Card(0, 0, 0, 1));
        startHand.add(new Card(0, 0, 0, 2));
        startHand.add(new Card(1, 0, 0, 0));
        startHand.add(new Card(1, 1, 0, 0));     
        startHand.add(new Card(1, 2, 0, 0));

        System.out.println(startHand);

        ArrayList<ArrayList<Card>> solved = algorithm.detectSets(startHand);
        System.out.println(solved);
        return solved;
    }
    


    public static void main(String[] args) {
        System.out.println("Testing...");

        test1();
        // createDeck();
        // for (Card card : deck){
        //     System.out.println(card.getCard());
        // }
    }
}
