package hashtables;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class QuadraticProbeHash extends HashTable {

    private int collisions = 0;
    private int elements = 0;

    public QuadraticProbeHash(int size) {
        super(size);
    }

    /**
     * input to the power of 2
     * @param k key
     * @return hash 
     */
    protected int hash(int k) {
        return (int) (Math.pow(k, 2));
    }
    /**
     * tries to put the value in hashed position otherwise looks for a new position
     * that is the key plus a linear increment squared until an available position is found
     * @param k key
     * @param v value
     * @return  null if empty or value in the spot
     */
    @Override
    public Object put(int k, Object v) {
        long startTime,endTime;
        int attempts = 0;
        startTime = System.currentTimeMillis();
        Object value = hashTable[super.hashCode(k)];
        if(value == null){
        value = super.put(k, v);
        endTime = System.currentTimeMillis();
        }
        else{         
            startTime = System.currentTimeMillis();
            collisions++;
            for (int i = 1; i < super.size() && value != null; i++) {
                attempts++;
                int hash = (k + hash(i)) % super.size();
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
        return value;
    }
    /**
     * removes the key value pair associated with the given key
     * @param k key
     * @return null or the value that was removed
     */
    @Override
    public Object remove(int k) {
        long startTime = System.currentTimeMillis();
        Object value = super.remove(k);
        long endTime = System.currentTimeMillis();
        elements--;

        if (value == null) { //means either no value in spot or wrong value in spot
            startTime = System.currentTimeMillis();
            for (int i = 1; i < super.size() && value == null; i++) {

                int hash = (k + hash(i)) % super.size();
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
        if (value == null) {
            System.out.println("Value could not be found: " + k + ", " + value);

        }
        System.out.println("------REMOVE------");
        System.out.println("TIME: " + (endTime - startTime));
        return value;

    }
    /**
     * Gets the value associated with the key
     * @param k key
     * @return null or the value in the spot
     */
    @Override
    public Object get(int k) {
        long startTime = System.currentTimeMillis();
        Object value = super.get(k);//k is the original key, value is either null or right value
        long endTime = System.currentTimeMillis();

        if (value == null) { //means either no value in spot or wrong value in spot
            startTime = System.currentTimeMillis();
            for (int i = 1; i < super.size() && value == null; i++) {
                int hash = (k + hash(i)) % super.size();
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
