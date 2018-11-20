package hashtables;

import java.util.LinkedList;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class SeperateChainHash extends HashTable<LinkedList<Integer>> {

    private int elementCounter = 0;
    private int collions = 0;

    public SeperateChainHash(int size) {
        super(size);
    }

    @Override
    public LinkedList<Integer> remove(int k) {
        return super.remove(k); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<Integer> get(int k) {
        return super.get(k); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<Integer> put(int k, LinkedList<Integer> v) {
        long startTime = System.currentTimeMillis();
        LinkedList<Integer> ll = super.put(k, v); //ll is old list
        if (ll != null) { //collision
            collions++;
            ll.add(super.get(k).get(0));//ad new element to list
            return super.put(k, ll); //replace in ht
        } else {
            elementCounter++;
            System.out.println(size());
            System.out.println(elementCounter);
            System.out.println(v.size());
            System.out.println(collions);
            System.out.println(System.currentTimeMillis() - startTime);
        }
        return ll;
    }
}
