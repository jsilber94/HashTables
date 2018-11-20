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
public abstract class HashTable{
    private Integer[] hashTable;
    
    public HashTable(int size){
        hashTable = (Integer[]) new Integer[size];
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
    
    public Integer get(int k){
        return hashTable[hashcode(k)];
    }
    
    public Integer put (int k, Integer v){
        Integer data = hashTable[hashcode(k)];
        if (data != null){
            hashTable[hashcode(k)] = v;
            return data;
        }
        else{
            hashTable[hashcode(k)] = v;
            return null;
        }
    }
    public Integer remove(int k){
        Integer data = hashTable[hashcode(k)];
        if(data != null){
            hashTable[hashcode(k)] = null;
            return data;
        }
        else{
            return null;
        }
    }
}
