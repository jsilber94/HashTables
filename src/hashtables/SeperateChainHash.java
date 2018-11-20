package hashtables;

import java.util.LinkedList;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class SeperateChainHash extends HashTable {

    private int elementCounter = 0;
    private int collions = 0;

    public SeperateChainHash(int size) {
        super(size);
    }

    @Override
    public Object put(int k, Object v) {

        long startTime = System.currentTimeMillis();
        Object value = super.put(k, v); //ll is old list
        LinkedList<Object> ll = new LinkedList<>();
        if (value != null) { //collision
            collions++;
            LinkedList ll1 = (LinkedList<Object>)super.get(k);
            ll.add(ll1);
            return super.put(k, ll); //replace in ht
        } else {
            elementCounter++;
            System.out.println(size());
            System.out.println(elementCounter);
            System.out.println(ll.size());
            System.out.println(collions);
            System.out.println(System.currentTimeMillis() - startTime);
        }
        return value;
    }
}
