package hashtables;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class QuadraticProbeHash extends HashTable {

    public QuadraticProbeHash(int size) {
        super(size);
    }

    @Override
    public Object put(int k, Object v) {
        Object value = super.put(k, v);

        for (int i = (++k); i < super.size() && value != null; i++) {
            int newKey = (int) Math.pow(i, 2);
            value = super.put(newKey, v);
        }
        if (value != null) {
            throw new IndexOutOfBoundsException("No more room in the hashtable");
        }
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
        Object o = super.get(k);//k is the original key, o may or may not be the right value
        if(o == null){
            //do quad stuff
        }
        MapElement mp = new MapElement(k, o);
        int hash = mp.hashCode();

        return null;
    }

}
