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
    public Integer put(int k, Integer v) {
        Integer value = super.put(k, v);

        for(int i = (++k); i<super.size() && value!= null;i++){
            int newKey = (int)Math.pow(i,2);
                value = super.put(newKey, v);  
        }
        if(value == null){
            throw new IndexOutOfBoundsException("No more room in the hashtable");
        }
        return value;
    }

}
