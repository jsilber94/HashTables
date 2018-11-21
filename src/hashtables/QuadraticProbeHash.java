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

    @Override
    public Object put(int k, Object v) {
        Object value = super.put(k, v);
        if (value != null) {
            collision++;
        }
        for (int i = (++k); i < super.size() && value != null; i++) {
            int newKey = (int) Math.pow(i, 2); //
            value = super.put(newKey, v); //if value is null, loop breaks
        }
        if (value != null) {
            throw new IndexOutOfBoundsException("No more room in the hashtable");
        }
        
        count ++;
        
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
            for (int i = (++k); i < super.size() && value == null; i++) { //quad probe
                int newKey = (int) Math.pow(i, 2);
                value = super.get(newKey);
            }
        }
        if(value == null){
            System.out.println("Value could not be found: " + k);
        }
        return value;
    }

}
