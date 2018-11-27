package hashtables;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class QuadraticProbeHash extends HashTable {

    int collisions = 0;
    int elements = 0;

    public QuadraticProbeHash(int size) {
        super(size);
    }


    protected int hash(int k) {
        return (int) (Math.pow(k, 2));
    }

    @Override
    public Object put(int k, Object v) {
        long startTime,endTime;
        //MapElement value;
        Object returnVal;
        int attempts = 0;
        startTime = System.currentTimeMillis();
        returnVal = hashTable[super.hashCode(k)];
        if(returnVal == null){
        returnVal = super.put(k, v);
        endTime = System.currentTimeMillis();
        }
        else{         
            startTime = System.currentTimeMillis();
            collisions++;
            for (int i = 1; i < super.size() && returnVal != null; i++) {
                attempts++;
                int hash = (k + hash(i)) % super.size();
                MapElement me = hashTable[hash];
                if (me == null) {
                    hashTable[hash] = new MapElement(k, v);
                    returnVal = null;
                }
            }
            endTime = System.currentTimeMillis();
        }
        
        elements++;
        if (returnVal != null) {
            throw new IndexOutOfBoundsException("No more room in the hashtable");
        }
        
        System.out.println("------PUT------");
        System.out.println(k+", "+v);
        System.out.println("Size: " + super.size());
        System.out.println("Elements: " + elements);
        System.out.println("Collisions: " + (collisions));
        System.out.println("Attempts: " + attempts);
        System.out.println("TIME: " + (endTime - startTime));
        return returnVal;
    }

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
