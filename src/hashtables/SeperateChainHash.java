package hashtables;

import java.util.LinkedList;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class SeperateChainHash extends HashTable {

    private int elementCounter = 0;
    private int collusions = 0;

    public SeperateChainHash(int size) {
        super(size);
    }

    @Override
    public Object get(int k) {
        //        long startTime = System.currentTimeMillis();

        Object value = super.get(k);
        if (value == null) { //no such entry or key is invalid
            MapElement me = hashTable[super.hashCode(k)];
            if (me == null) {//no such entry, return null
                value = null;
            } else {//check furthur
                while (me.getNext() != null) {
                    if (me.getNext().getKey() == k) {
                        value = me.getValue();
                        break;
                    }
                    me = me.getNext();
                }
            }

        }
//            System.out.println(System.currentTimeMillis() - startTime);
        return value;
    }

    @Override
    public Object put(int k, Object v) {

//        long startTime = System.currentTimeMillis();
        Object value = super.put(k, v);

        if (value != null) { //not null means collusions
            collusions++;
            MapElement me = hashTable[super.hashCode(k)]; //first me in the table
            while (me.getNext() != null) {
                me = me.getNext();
            }
            MapElement newME = new MapElement(k, v);
            me.setNext(newME);
        }
        elementCounter++;
//            System.out.println(size());
//            System.out.println(elementCounter);
//            System.out.println(ll.size());
//            System.out.println(collions);
//            System.out.println(System.currentTimeMillis() - startTime);   
        return null;
    }

    @Override
    public Object remove(int k) {
        //        long startTime = System.currentTimeMillis();
        Object value = super.remove(k);
        if (value == null) {
            MapElement me = hashTable[super.hashCode(k)];
            MapElement next = me.getNext();
            
            while (next.getNext() != null) {
                if (next.getKey() == k) {
                    value = next.getValue();
                    me.setNext(next.getNext());
                    break;
                }
                me = next;
                next = me.getNext();
            }
        }

        // System.out.println(System.currentTimeMillis() - startTime);
        return value;
    }

}
