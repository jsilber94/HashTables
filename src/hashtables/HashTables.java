package hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
        int capacity1 = 101;
        int amountOfElements = 50;
        int amountOfElements1 = 150;
        //all the linear probing questions
//        System.out.println("\nLINEAR PROBING\n");
//        MapElement[] mp = createElements(amountOfElements1);
//        HashTable lph = new LinearProbeHash(capacity);
//        lph = populateHashTable(lph, mp);
//        runGet(lph, mp);
//        runRemove(lph, mp);
//        runGet(lph, mp);
        //all the quadratic probing methods
        System.out.println("\nQUADRATIC PROBING\n");
        MapElement[] mp2 = createElements(amountOfElements1);
        HashTable qph = new QuadraticProbeHash(capacity1);
        qph = populateHashTable(qph, mp2);
        runGet(qph, mp2);
        runRemove(qph, mp2);
        runGet(qph, mp2);
        //all the seperate chaining methods
//        System.out.println("\nSEPERATE CHAINING\n");
//        MapElement[] mp3 = createElements(amountOfElements1);
//        HashTable sch = new SeperateChainHash(capacity);
//        sch = populateHashTable(sch, mp3);
//        runGet(sch, mp3);
//        runRemove(sch, mp3);
//        runGet(sch, mp3);

    }

    public static MapElement[] createElements(int capacity) {
        int count = 0;
        List<Integer> keys = new ArrayList<>();

        MapElement[] mapElements = new MapElement[capacity];

        for (int i = 0; i < capacity; i++) {
            MapElement me = new MapElement("Value" + i);
            
            while (keys.contains(me.getKey())) {
                me = new MapElement("Value" + i);
            }

            keys.add(me.getKey());
            mapElements[i] = me;
            count++;
        }
        System.out.println("count: " + count);
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
        System.out.println("populate: " + count + "/"+mp.length);
        return ht;
    }

    public static void runGet(HashTable ht, MapElement[] mp) {
        int count = 0;
        for (MapElement mp1 : mp) {
            Object o = ht.get(mp1.getKey());
            if (o != null) {
//                System.out.println(o);
                count++;
            }
        }
        System.out.println("get: " + count + "/" + mp.length);
        //System.out.println(ht.toString());

    }

    public static void runRemove(HashTable ht, MapElement[] mp) {
        int count = 0;
        for (int i = 0; i < 25; i++) {
            Object o = ht.remove(mp[i].getKey());
//            System.out.println(o);
            if (o != null) {
                count++;
            }
        }
        System.out.println("remove: " + count + "/25");
    }

}
