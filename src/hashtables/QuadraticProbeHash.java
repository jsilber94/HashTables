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

    private int hashCode(int k) {
        return (int) (Math.pow(k, 2));
    }

    @Override
    public Object put(int k, Object v) {
        Object value = super.put(k, v);
        elements++;
        int attempts = 1;
        if (value != null) {
            for (int i = 1; i < super.size() && value != null; i++) {
                collisions++;
                attempts++;
                int hash = (k + hashCode(i)) % super.size();
                MapElement me = hashTable[hash];
                if (me == null) {
                    hashTable[hash] = new MapElement(k, v);
                    value = null;
                }
            }

        }
        if (value != null) {
            throw new IndexOutOfBoundsException("No more room in the hashtable");
        }
        System.out.println("------PUT------");
        System.out.println("Size: " + super.size());
        System.out.println("Elements: " + elements);
        System.out.println("Collisions: " + (collisions));
        System.out.println("Attempts: " + attempts);
        return value;
    }

    @Override
    public Object remove(int k) {
        Object value = super.remove(k);
        elements--;
        int attempts = 1;
        if (value == null) { //means either no value in spot or wrong value in spot
            for (int i = 1; i < super.size() && value == null; i++) {
                collisions++;
                attempts++;
                int hash = (k + hashCode(i)) % super.size();
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
        }
        if (value == null) {
            System.out.println("Value could not be found: " + k + ", " + value);

        }
        System.out.println("------REMOVE------");
        System.out.println("Size: " + super.size());
        System.out.println("Elements: " + elements);
        System.out.println("Collisions: " + (collisions));
        System.out.println("Attempts: " + attempts);
        return value;

    }

    @Override
    public Object get(int k) {
        Object value = super.get(k);//k is the original key, value is either null or right value
        int attempts = 1;
        if (value == null) { //means either no value in spot or wrong value in spot
            for (int i = 1; i < super.size() && value == null; i++) {
                collisions++;
                attempts++;
                int hash = (k + hashCode(i)) % super.size();
                MapElement me = hashTable[hash];
                if (me == null) {
                    value = null;
                } else if (me.getKey() != k) {
                    value = null;
                } else {
                    value = me.getValue();
                }
            }
        }
        if (value == null) {
            System.out.println("Value could not be found: " + k + ", " + value);

        }
        System.out.println("------GET------");
        System.out.println("Size: " + super.size());
        System.out.println("Elements: " + elements);
        System.out.println("Collisions: " + (collisions));
        System.out.println("Attempts: " + attempts);
        return value;
    }
    

}
