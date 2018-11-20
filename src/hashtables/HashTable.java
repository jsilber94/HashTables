/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtables;

/**
 *
 * @author Max Page-Slowik
 * @param <E>
 */
public abstract class HashTable<E>{
    private MapElement<E>[] hashTable;
    
    public HashTable(int size){
        hashTable = new MapElement[size];
    }
    
    public int size(){
        return hashTable.length;
    }
    
    public boolean isEmpty(){
        for (int i = 0; i<size();i++){
            if(hashTable[i]!=null){
                return false;
            }
        }
        return true;
    }
    
    public int hashcode(int k){
        return k % size();
    }
    
    public E get(int k){
        return hashTable[hashcode(k)].getValue();
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
    public E remove(int k){
        E data = hashTable[hashcode(k)].getValue();
        if(data != null){
            hashTable[hashcode(k)] = null;
            return data;
        }
        else{
            return null;
        }
    }
}
