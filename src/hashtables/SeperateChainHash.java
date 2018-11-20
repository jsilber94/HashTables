package hashtables;

import java.util.LinkedList;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class SeperateChainHash extends HashTable<LinkedList<Integer>> {

    public SeperateChainHash(int size) {
        super(size);
    }

    @Override
    public LinkedList<Integer> put(int k, LinkedList<Integer> v) {
        LinkedList<Integer> ll = super.put(k, v); //ll is old list
        if (ll != null) { //collision
            ll.add(super.get(k).get(0));//ad new element to list
            return super.put(k, ll); //replace in ht
        }
        return ll;
    }
}
