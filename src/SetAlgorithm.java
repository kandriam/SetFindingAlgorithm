

import java.util.ArrayList;

public class SetAlgorithm {
    public SetAlgorithm(){
        

    }

    /**
     * @param board     Takes in a a list of cards
     * @return solList  Returns a list containing each set within the board
     */
    ArrayList<ArrayList<Card>> detectSets(ArrayList<Card> board){
        ArrayList<ArrayList<Card>> solList = new ArrayList<ArrayList<Card>>();

        // Iterates each 0 < i < n for the first card in a possible set
        // Iterates each i < j < n for the second card in a possible set

        for (int i = 0; i < board.size(); i++) {
            for (int j = i+1; j <board.size(); j++) {
                // Generates the third card k to complete the set with card1 and card2
                Card k = generate3rdCard(board.get(i), board.get(j));

                // If the board contains k, adds the set of i, j, k to the solution list
                if (board.contains(k)){
                    ArrayList<Card> currSet = new ArrayList<Card>();

                    currSet.add(board.get(i));
                    currSet.add(board.get(j));
                    currSet.add(k);

                    solList.add(currSet);
                }
            }

        }
        // Return solution list, list of all present sets (could be none)
        return solList;
    }
    
    /**
     * @param c1     Takes in the first card in some set
     * @param c2     Takes in the second card in some set
     * @return c3    Returns the third card that would complete the set with c1 and c2
     */
    Card generate3rdCard(Card c1, Card c2){
        int t1 = generateTrait(c1, c2, 0);
        int t2 = generateTrait(c1, c2, 1);
        int t3 = generateTrait(c1, c2, 2);
        int t4 = generateTrait(c1, c2, 3);
        Card c3 = new Card(t1, t2, t3, t4); 
        return c3;
    }


    /**
     * @param c1     Takes in the first card in some set
     * @param c2     Takes in the second card in some set
     * @param t      Takes in what kind of trait the caller wants (color, number, shape or shading)
     * @return       The value of the respective trait that woulld complete the set  
     */
    int generateTrait(Card c1, Card c2, int t){
        if (c1.getTrait(t) == c2.getTrait(t)){
            return c1.getTrait(t);
        }
        else {
            int r = 0;
            if (c1.getTrait(t) == 0 && c2.getTrait(t) == 1){
                r = 2;
            }
            else if (c1.getTrait(t) == 2 && c2.getTrait(t) == 0){
                r = 1;
            }
            else {
                r = 0;
            }
            return r;
        }
    }
    
    /**
     * For the desired trait, check if they values are all the same or all different.
     * If one of the two, return yes. Otherwise, false.
     * @param cardA     First card selected
     * @param cardB     Second card selected
     * @param cardC     Third card selected
     * @param t         The trait to be checked
     * @return          Whether the trait passes as valid for a set of cards.
     */
    boolean checkTrait(Card cardA, Card cardB, Card cardC, Integer t) {
        if ((cardA.getTrait(t) == cardB.getTrait(t)) && (cardA.getTrait(t) == cardC.getTrait(t))) {
            return true;
        }
        else if (!(cardA.getTrait(t) == cardB.getTrait(t)) &&
                 !(cardA.getTrait(t) == cardC.getTrait(t)) &&
                 !(cardB.getTrait(t) == cardC.getTrait(t))) {
            return true;
        } else {
            return false;
        }
    }
}

