

import java.util.ArrayList;

public class SetAlgorithmList {
    public SetAlgorithmList(){


    }
    
    ArrayList<Integer> createCard(Integer t1, Integer t2, Integer t3, Integer t4){
        ArrayList<Integer> card = new ArrayList<Integer>();
        card.add(t1);
        card.add(t2);
        card.add(t3);
        card.add(t4);
        return card;
    }

    /**
     * @param board     Takes in a a list of cards
     * @return solList  Returns a list containing each set within the board
     */
    ArrayList<ArrayList<ArrayList<Integer>>> detectSets(ArrayList<ArrayList<Integer>> board){
        ArrayList<ArrayList<ArrayList<Integer>>> solList = new ArrayList<ArrayList<ArrayList<Integer>>>();
        System.out.println(board);

        // Iterates each 0 < i < n for the first card in a possible set
        // Iterates each i < j < n for the second card in a possible set

        for (int i = 0; i < board.size(); i++) {
            System.out.println("c1: " + board.get(i));
            for (int j = i+1; j <board.size(); j++) {
            System.out.println("c2: " + board.get(j));

                // Generates the third card k to complete the set with card1 and card2
                ArrayList<Integer> k = generate3rdCard(board.get(i), board.get(j));
                System.out.println("k: " + k);

                // If the board contains k, adds the set of i, j, k to the solution list
                if (board.subList(j, board.size()).contains(k)){
                    System.out.println("k is present");
                    ArrayList<ArrayList<Integer>> currSet = new ArrayList<ArrayList<Integer>>();

                    currSet.add(board.get(i));
                    currSet.add(board.get(j));
                    currSet.add(k);

                    solList.add(currSet);
                    System.out.println("Added a Set!");
                }
                System.out.println("----");
            }

        }
        // Return solution list, list of all present sets (could be none)
        System.out.println("SolList" + solList);
        return solList;
    }
    
    /**
     * @param c1     Takes in the first card in some set
     * @param c2     Takes in the second card in some set
     * @return c3    Returns the third card that would complete the set with c1 and c2
     */
    ArrayList<Integer> generate3rdCard(ArrayList<Integer> c1, ArrayList<Integer> c2){
        ArrayList<Integer> c3 = new ArrayList<Integer>();
        int t1 = generateTrait(c1, c2, 0);
        int t2 = generateTrait(c1, c2, 1);
        int t3 = generateTrait(c1, c2, 2);
        int t4 = generateTrait(c1, c2, 3);
        c3.add(t1);
        c3.add(t2);
        c3.add(t3);
        c3.add(t4);

        return c3;
    }


    /**
     * @param c1     Takes in the first card in some set
     * @param c2     Takes in the second card in some set
     * @param t      Takes in what kind of trait the caller wants (color, number, shape or shading)
     * @return       The value of the respective trait that woulld complete the set  
     */
    int generateTrait(ArrayList<Integer> c1, ArrayList<Integer> c2, int t){
        if (c1.get(t) == c2.get(t)){
            return c1.get(t);
        }
        else {
            if (c1.get(t) == 0 && c2.get(t) == 1){
                return 2;
            }
            else if (c1.get(t) == 2 && c2.get(t) == 0){
                return 1;
            }
            else {
                return 0;
            }
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

