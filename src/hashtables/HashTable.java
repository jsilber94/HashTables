package hashtables;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public abstract class HashTable {

    protected final MapElement[] hashTable;

    public HashTable(int size) {
        hashTable = new MapElement[size];
    }

    public int size() {
        return hashTable.length;
    }

    public boolean isEmpty() {
        for (int i = 0; i < size(); i++) {
            if (hashTable[i] != null) {
                return false;
            }
        }
        return true;
    }

    public Object get(int k) {
        int hash = this.hashCode(k);
        //long startTime = System.currentTimeMillis();
        MapElement me = hashTable[hash];
        if (me == null) {
            return null;
        } else if (me.getKey() != k) {
            return null;
        }
//        System.out.println(System.currentTimeMillis() - startTime);
        return me.getValue();
    }

    public Object put(int k, Object v) {
        int hash = this.hashCode(k);
        MapElement me = hashTable[hash];
        if (me != null) {
            hashTable[hash] = new MapElement(k, v);
            return me.getValue();
        } else {
            hashTable[hash] = new MapElement(k, v);
            return null;
        }
    }

    public Object remove(int k) {
        int hash = this.hashCode(k);
        MapElement me = hashTable[hash];
        if (me == null) {
            return null;
        } else if (me.getKey() != k) {
            return null;
        }
        else {
            hashTable[hash] = null;
            return me.getValue();
        }
    }

    private int hashCode(int k) {
        return k % size();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
                for(MapElement me: hashTable){
                    if (me!=null)
                    sb.append(me.getKey()).append(",").append(me.getValue()).append("|");
                    else
                        sb.append("").append(",").append("").append("|");
                }
          sb.replace(sb.length()-1,sb.lastIndexOf("|"),"]");
        return sb.toString();
    }
}
