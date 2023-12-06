/**
 ** Class that creates a hashtable for Set cards, stores 
 ** that table, and creates a hashing function for the cards.
 
 ** Note: This assumes Set cards have 4 traits with 3 options each

 * @author Nicholas Duncan
 */
public class HashFunction {

    private int[] hashTable = new int[27*2+9*2+3*2+1*2]; //0-80
    // Note: the hashTable is in base-3 to save space.

    public HashFunction(){
        // Do we need this?
    }

    // public int[] getHashTable(){
    //     return hashTable;
    // }

    /**
     * @param card
     * @return an ntegerbetween 0 and 80, inclusive
     */
    public int returnHash(int[] card){
        //* Should this be private?
        return card[0] * 1 + card[1] * 3 + 
               card[2] * 9 + card[3] * 27;
    }

    // public void hash(int[] card) {
    //     hashTable[returnHash(card)] = 1;
    // }

    /**
     * @param card
     * @return the integer (1 or 0) indicating if the 
     * hashtable has the given card or not
     */
    public int atSpot(int[] card) {
        return hashTable[returnHash(card)];
    }

    /**
     * Removes the given card from the hashtable
     * @param card
     */
    public void removeCard(int[] card) {
        hashTable[returnHash(card)] = 0;
    }

    /**
     * Adds the given card to the hashtable
     * @param card
     */
    public void addCard(int[] card) {
        hashTable[returnHash(card)] = 1;
    }
}
