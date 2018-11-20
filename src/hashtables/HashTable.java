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
public abstract class HashTable <E>{
    private E[] backingData;
    
    public HashTable(int size){
        backingData = (E[]) new Object[size];
    }
    
    public int size(){
        return backingData.length;
    }
    
    public boolean isEmpty(){
        for (int i = 0; i<size();i++){
            if(backingData[i]!=null){
                return false;
            }
        }
        return true;
    }
    
    public int hashcode(int key){
        return key % size();
    }
    
    public E get(int k){
        return backingData[hashcode(k)];
    }
    public E put (int k, E v){
        E data = backingData[hashcode(k)];
        if (data != null){
            backingData[hashcode(k)] = v;
            return data;
        }
        else{
            backingData[hashcode(k)] = v;
            return null;
        }
    }
    public E remove(int k){
        E data = backingData[hashcode(k)];
        if(data != null){
            backingData[hashcode(k)] = null;
            return data;
        }
        else{
            return null;
        }
    }
}
