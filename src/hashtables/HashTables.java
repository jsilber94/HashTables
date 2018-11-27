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

//       MapElement[] mp = createElements(amountOfElements);
//       HashTable lph = new LinearProbeHash(capacity);
//       lph = populateHashTable(lph, mp);
        MapElement[] mp3 = createElements(amountOfElements);
        HashTable sch = new SeperateChainHash(capacity);
        sch = populateHashTable(sch, mp3);
        runGet(sch, mp3);
        runRemove(sch, mp3);

//        MapElement[] mp2 = createElements(amountOfElements);
//        HashTable qph = new QuadraticProbeHash(capacity);
//        qph = populateHashTable(qph, mp2);
//        runGet(qph, mp2);
//        runRemove(qph, mp2);
    }

    public static MapElement[] createElements(int capacity) {
        MapElement[] mapElements = new MapElement[capacity];
        for (int i = 0; i < capacity; i++) {
            mapElements[i] = new MapElement("Value" + i);
        }
        return mapElements;
    }

    public static HashTable populateHashTable(HashTable ht, MapElement[] mp) {
        int count = 0;
        for (MapElement mp1 : mp) {
            Object o = ht.put(mp1.getKey(), mp1.getValue());
            if (o == null) {
                count++;
            }
        }
        System.out.println("count: " + count);
        return ht;
    }

    public static void runGet(HashTable ht, MapElement[] mp) {
        int count = 0;
        for (int i = 0; i < 50; i++) {
            Object o = ht.get((mp[i].getKey()));
            if (o != null) {
                count++;
            }
        }
        System.out.println("count: " + count);
//        System.out.println(ht.toString());
    }

    public static void runRemove(HashTable ht, MapElement[] mp) {
        int count = 0;
        for (int i = 0; i < 25; i++) {
            Object o = ht.remove(mp[i].getKey());
            if (o != null) {
                count++;
            }
        }
        System.out.println("count: " + count);
    }

}
