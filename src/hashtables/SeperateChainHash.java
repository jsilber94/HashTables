package hashtables;

import java.util.LinkedList;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class SeperateChainHash extends HashTable {

    public int elementCounter = 0;
    public int collusions = 0;

    public SeperateChainHash(int size) {
        super(size);
    }

    @Override
    public Object get(int k) {
        //        long startTime = System.currentTimeMillis();
        
        Object value = super.get(k);
        if (value == null) { //no such entry or key is invalid
            MapElement me = hashTable[super.hashCode(k)]; //get the me
            if (me == null) {//no such entry, return null
                value = null;
            } else {//key is invalid
                while (me.getNext() != null) {
                    if (me.getNext().getKey() == k) {
                        value = me.getNext().getValue();
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

        int hash = super.hashCode(k);
        MapElement me = hashTable[hash];

        if (me == null) {
            hashTable[hash] = new MapElement(k, v);
        } else { //not null means collusions
            collusions++;
            while (me.getNext() != null) {
                me = me.getNext();
            }
            MapElement originalME = new MapElement(k, v);
            me.setNext(originalME);
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
        //Object value = super.remove(k);
        Object value = null;
        int hash = super.hashCode(k);
        MapElement me = hashTable[hash];
        if (me != null) {
            value = me.getValue();

            if (me.getKey() != k) { //k isnt right

                MapElement next = me.getNext(); //second element

                while (next != null) {
                    if (next.getKey() == k) {
                        value = next.getValue();
                        me.setNext(next.getNext());
                        elementCounter--;
                        break;
                    }
                    me = next;
                    next = me.getNext();
                }

            } else { //k is right
                hashTable[hash] = me.getNext();
                elementCounter--;
            }
        }
        // System.out.println(System.currentTimeMillis() - startTime);
        return value;
    }
}
