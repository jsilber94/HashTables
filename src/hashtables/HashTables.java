package hashtables;

/**
 *
 * @author Jesse Silber
 */
public class HashTables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int capacity = 100;
        int amountOfElements = 50;
        MapElement[] mp = createElements(amountOfElements);
        HashTable lph = new LinearProbeHash(capacity);
        lph = populateHashTable(lph, mp);

//        runGet(lph, mp);
//      runRemove(lph, mp);
    }

    public static MapElement[] createElements(int capacity) {
        MapElement[] mapElements = new MapElement[capacity];
        for (int i = 0; i < capacity; i++) {
            mapElements[i] = new MapElement("Value");
        }
        return mapElements;
    }

    public static HashTable populateHashTable(HashTable ht, MapElement[] mp) {
        for (int i = 0; i < mp.length; i++) {
            ht.put(mp[i].getKey(), mp[i].getValue());
        }
        return ht;
    }

    public static void runGet(HashTable ht, MapElement[] mp) {
        for (int i = 0; i < 50; i++) {
            ht.get(mp[i].getKey());
        }
    }

    public static void runRemove(HashTable ht, MapElement[] mp) {
        for (int i = 0; i < 25; i++) {
            ht.remove(mp[i].getKey());
        }
    }

}
