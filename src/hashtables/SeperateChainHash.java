package hashtables;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class SeperateChainHash extends HashTable {

    private int elements = 0;
    private int collisions = 0;

    public SeperateChainHash(int size) {
        super(size);
    }

    /**
     * Gets the value for the associated key, if the key matches, otherwise
     * checks the next value
     *
     * @param k key
     * @return the value or null
     */
    @Override
    public Object get(int k) {
        long startTime = System.currentTimeMillis();
        Object value = super.get(k);
        long endTime = System.currentTimeMillis();
        if (value == null) { //no such entry or key is invalid
            startTime = System.currentTimeMillis();
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
            endTime = System.currentTimeMillis();
        }
        System.out.println("------GET------");
        System.out.println("TIME: " + (endTime - startTime));
        return value;
    }

    /**
     * Puts the value in the location or in the "next" spot
     *
     * @param k key
     * @param v value
     * @return null
     */
    @Override
    public Object put(int k, Object v) {
        long startTime = System.currentTimeMillis();
        int hash = super.hashCode(k);
        MapElement me = hashTable[hash];
        int attempts = 0;
        if (me == null) {
            hashTable[hash] = new MapElement(k, v);
        } else { //not null means collusions
            collisions++;
            while (me.getNext() != null) {
                attempts++;
                me = me.getNext();
            }
            MapElement originalME = new MapElement(k, v);
            me.setNext(originalME);
        }
        long endTime = System.currentTimeMillis();
        elements++;
        System.out.println("------PUT------");
        System.out.println("Size: " + super.size());
        System.out.println("Elements: " + elements);
        System.out.println("Collisions: " + (collisions));
        System.out.println("Attempts: " + attempts);
        System.out.println("TIME: " + (endTime - startTime));

        return null;
    }

    /**
     * removes a key value pair only if the key matches a key in the hash table,
     * otherwise looks for the 'next' value
     *
     * @param k key
     * @return the value or null
     */
    @Override
    public Object remove(int k) {
        long startTime = System.currentTimeMillis();
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
                        elements--;
                        break;
                    }
                    me = next;
                    next = me.getNext();
                }

            } else { //k is right
                hashTable[hash] = me.getNext();
                elements--;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("------REMOVE------");
        System.out.println("TIME: " + (endTime - startTime));
        return value;
    }
}
