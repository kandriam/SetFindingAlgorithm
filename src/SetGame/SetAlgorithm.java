package SetGame;

import java.util.ArrayList;

public class SetAlgorithm {
    ArrayList<ArrayList<Card>> detectSets(ArrayList<Card> board){
        ArrayList<ArrayList<Card>> solList = new ArrayList<ArrayList<Card>>();
        for (int i = 0; i < board.size(); i++) {
            for (int j = i+1; j <board.size(); j++) {
                Card k = generate3rdCard(board.get(i), board.get(j));
                if (board.contains(k)){
                    ArrayList<Card> currSet = new ArrayList<Card>();
                    currSet.add(board.get(i));
                    currSet.add(board.get(j));
                    currSet.add(k);
                    solList.add(currSet);
                }
            }

        }
        return solList;
    }
    
    Card generate3rdCard(Card c1, Card c2){
        int t1 = generateTrait(c1, c2, 0);
        int t2 = generateTrait(c1, c2, 1);
        int t3 = generateTrait(c1, c2, 2);
        int t4 = generateTrait(c1, c2, 3);
        Card c3 = new Card(t1, t2, t3, t4); 
        return c3;
    }

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

