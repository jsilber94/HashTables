package hashtables;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class QuadraticProbeHash extends HashTable {

    int collision = 0;
    int count = 0;

    public QuadraticProbeHash(int size) {
        super(size);
    }
    
    protected int hashCode(int k) {
        return (int) (Math.pow(k, 2)) % size();
    }

    @Override
    public Object put(int k, Object v) {
        Object value = super.put(k, v);
        if (value != null) {
            for (int i = 1; i < super.size() && value != null; i++) {
                collision++;
                int hash = hashCode(k+i);
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
        count++;
        return value;
    }

    @Override
    public Object remove(int k) {
        Object o = super.remove(k);
        if (o == null) {
            return null;
        } else {

            return null;
        }
    }

    @Override
    public Object get(int k) {
        Object value = super.get(k);//k is the original key, value is either null or right value
        if (value == null) { //means either no value in spot or wrong value in spot
            for (int i = 1; i < super.size() && value != null; i++) {
                collision++;
                int hash = hashCode(k+i);
                MapElement me = hashTable[hash];
                if(me == null){
                    value = null;
                }
                else if (me.getKey() != k) {
                    value = null;
                }
                else{
                   value = me.getValue();
                }
            }
        }
        if (value == null) {
            System.out.println("Value could not be found: " + k + ", " + value);

        }
        return value;
    }

}
