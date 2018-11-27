/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtables;

/**
 *
 * @author Max Page-Slowik
 */
public class LinearProbeHash extends HashTable {

    private int collisions = 0;
    private int elements = 0;

    public LinearProbeHash(int size) {
        super(size);
    }

    @Override
    public Object put(int k, Object v) {
        Object value = super.put(k, v);
        elements++;
        int attempts = 1;
        if (value != null) {
            for (int i = 1; i < super.size() && value != null; i++) {
                collisions++;
                attempts++;
                int hash = (k + i) % size();
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
        System.out.println("Size: " + super.size());
        System.out.println("Elements: " + elements);
        System.out.println("Collisions: " + (collisions));
        System.out.println("Attempts: " + attempts);
        return value;
    }

    @Override
    public Object remove(int k) {
        Object value = super.remove(k);
        int attempts = 1;
        if (value == null) {
            elements--;
            for (int i = 1; i < super.size() && value == null; i++) {
                int hash = (k + i) % size();
                MapElement me = hashTable[hash];
                if (me == null) {
                    value = null;
                } else if (me.getKey() != k) {
                    value = null;
                } else {
                    hashTable[hash] = null;
                    value = me.getValue();
                }
                collisions++;
                attempts++;
            }
        }
        System.out.println("Size: " + super.size());
        System.out.println("Elements: " + elements);
        System.out.println("Collisions: " + (collisions));
        System.out.println("Attempts: " + attempts);
        return value;
    }

    @Override
    public Object get(int k) {
        Object value = super.get(k);
        int attempts = 1;
        if (value == null) { //means either no value in spot or wrong value in spot
            for (int i = 1; i < super.size() && value == null; i++) {
                collisions++;
                attempts++;
                int hash = (k + i) % size();
                MapElement me = hashTable[hash];
                if (me == null) {
                    value = null;
                } else if (me.getKey() != k) {
                    value = null;
                } else {
                    value = me.getValue();
                }
            }
        }
        System.out.println("Size: " + super.size());
        System.out.println("Elements: " + elements);
        System.out.println("Collisions: " + (collisions));
        System.out.println("Attempts: " + attempts);
        return value;
    }

}
