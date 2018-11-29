package hashtables;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class LinearProbeHash extends HashTable {

    private int collisions = 0;
    private int elements = 0;

    public LinearProbeHash(int size) {
        super(size);
    }

    protected void setNewSize(int size) {
        hashTable = new MapElement[size];
        elements = 0;
        collisions = 0;
    }

    private void reSize() {
        if (elements >= super.size() / 2) {
            MapElement mapElements[] = new MapElement[super.size()];
            int newSize = super.size() * 2;
            for (int i = 0; i < mapElements.length; i++) {
                mapElements[i] = hashTable[i];
            }
            reHash(newSize, mapElements);
        }

    }

    private boolean reHash(int newSize, MapElement mapElements[]) {
        if (mapElements != null && mapElements.length != 0) {
            setNewSize(newSize);

            for (MapElement mp : mapElements) {
                if (mp != null) {
                    this.put(mp.getKey(), mp.getValue());
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Puts the value in the location or the next available location
     *
     * @param k key
     * @param v value
     * @return null or value of element in the table
     */
    @Override
    public Object put(int k, Object v) {
        long startTime, endTime;
        int attempts = 0;
        startTime = System.currentTimeMillis();
        Object value = hashTable[super.hashCode(k)];
        if (value == null) {
            value = super.put(k, v);
            endTime = System.currentTimeMillis();
        } else {
            startTime = System.currentTimeMillis();
            collisions++;
            for (int i = 1; i < super.size() && value != null; i++) {
                attempts++;
                int hash = (k + i) % size();
                MapElement me = hashTable[hash];
                if (me == null) {
                    hashTable[hash] = new MapElement(k, v);
                    value = null;
                }
            }
            endTime = System.currentTimeMillis();
        }
        elements++;
        if (value != null) {
            System.out.println("HASHTABLE IS FULL");
        }
        System.out.println("------PUT------");
        System.out.println("Size: " + super.size());
        System.out.println("Elements: " + elements);
        System.out.println("Collisions: " + (collisions));
        System.out.println("Attempts: " + attempts);
        System.out.println("TIME: " + (endTime - startTime));
        reSize();
        return value;
    }

    /**
     * removes a key value pair only if the key matches a key in the hash table,
     * otherwise looks linearly for the matching key
     *
     * @param k key
     * @return null or the value removed
     */
    @Override
    public Object remove(int k) {
        long startTime = System.currentTimeMillis();
        Object value = super.remove(k);
        long endTime = System.currentTimeMillis();
        if (value == null) {
            elements--;
            startTime = System.currentTimeMillis();
            for (int i = 1; i < super.size() && value == null; i++) {
                int hash = (k + i) % size();
                MapElement me = hashTable[hash];
                if (me == null) {
                    value = null;
                } else if (me.getKey() != k) {
                    value = null;
                } else {
                    hashTable[hash] = null;
                    value = me.getValue();
                }
            }
            endTime = System.currentTimeMillis();
        }
        System.out.println("------REMOVE------");
        System.out.println("TIME: " + (endTime - startTime));
        return value;
    }

    /**
     * Gets the value for the associated key, if the key matches, otherwise
     * tries to find it linearly
     *
     * @param k key
     * @return value or null if it is not there
     */
    @Override
    public Object get(int k) {
        long startTime = System.currentTimeMillis();
        Object value = super.get(k);
        long endTime = System.currentTimeMillis();
        if (value == null) { //means either no value in spot or wrong value in spot
            startTime = System.currentTimeMillis();
            for (int i = 1; i < super.size() && value == null; i++) {
                int hash = (k + i) % size();
                MapElement me = hashTable[hash];
                if (me == null) {
                    value = null;
                } else if (me.getKey() != k) {
                    value = null;
                } else {
                    value = me.getValue();
                }
            }
            endTime = System.currentTimeMillis();
        }
        if (value == null) {
            System.out.println("Value could not be found: " + k + ", " + value);
        }
        System.out.println("------GET------");
        System.out.println("TIME: " + (endTime - startTime));
        return value;
    }

}
