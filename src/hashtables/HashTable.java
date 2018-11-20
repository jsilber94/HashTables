package hashtables;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 * @param <E>
 */
public abstract class HashTable<E>{
    private MapElement<E>[] hashTable;
    
    public HashTable(int size){
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

    public int hashcode(int k) {
        return k % size();
    }

    public E get(int k) {
        long startTime = System.currentTimeMillis();
        E e = hashTable[hashcode(k)].getValue();
        System.out.println(System.currentTimeMillis() - startTime);
        return e;
    }
    
    public E put (int k, E v){
        E data = hashTable[hashcode(k)].getValue();
        if (data != null){
            hashTable[hashcode(k)].setValue(v);
            return data;
        }
        else{
            hashTable[hashcode(k)].setValue(v);
            return null;
        }
    }

    public E remove(int k) {
        long startTime = System.currentTimeMillis();
        E data = hashTable[hashcode(k)].getValue();
        if(data != null){
            hashTable[hashcode(k)] = null;
            System.out.println(System.currentTimeMillis() - startTime);
            return data;
        } else {
            return null;
        }
    }
}