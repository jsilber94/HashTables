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
        MapElement[] mp = createElements(50);
        HashTable lph = populateHashTable(new LinearProbeHash(capacity), mp);

//        runGet(lph);
//        runRemove(lph);
//        runGet(lph);
    }

    public static MapElement[] createElements(int capacity) {
        MapElement[] mapElements = new MapElement[capacity];
        for (int i = 0; i < capacity; i++) {
            mapElements[0] = new MapElement("Value");
        }
        return mapElements;
    }

    public static HashTable populateHashTable(HashTable ht, MapElement[] mp) {
        for (int i = 0; i < mp.length; i++) {
            ht.put(mp[0].getKey(), mp[0].getValue());
        }
        return ht;
    }

    public static void runGet(HashTable ht) {
        for (int i = 0; i < 50; i++) {

        }
    }

    public static void runRemove(HashTable ht) {
        for (int i = 0; i < 25; i++) {

        }
    }

}
