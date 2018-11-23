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
public class LinearProbeHash extends HashTable{
    private int collisions = 0;
    private int elements = 0;
    
    public LinearProbeHash(int size) {
        super(size);
    }
    
    private int hashcode(int k){
        return k+1;
    }
    @Override
    public Object put(int k, Object v){
        Object value = super.put(k, v);
        if(value !=null){
           collisions++;         
        }
        elements++;
        int attempts = 0; 
        for(int i = 1; i<super.size() && value!= null;i++){
            value = super.put(k+i, v);
            attempts++;    
        }
        if(value != null){
            throw new IndexOutOfBoundsException("No more room in the hashtable");
        }
        System.out.println("Size: "+super.size());
        System.out.println("Elements: "+elements);
        System.out.println("Collisions: "+(collisions));
        System.out.println("Attempts: "+attempts);
        return value;
    }

    @Override
    public Object remove(int k) {
        Object value = super.remove(k);
        if(value ==null){
           collisions++;         
        }
        elements--;
        int attempts = 0; 
        for(int i = (++k); i<super.size() && value!= null;i++){
            value = super.remove(k);
            attempts++;    
        }
        System.out.println("Size: "+super.size());
        System.out.println("Elements: "+elements);
        System.out.println("Collisions: "+(collisions));
        System.out.println("Attempts: "+attempts);
        return value;    
    }

    @Override
    public Object get(int k) {
        Object value = super.get(k);
        if(value ==null){
           collisions++;         
        }
        int attempts = 0; 
        for(int i = (++k); i<super.size() && value!= null;i++){
            value = super.get(k);
            attempts++;   
        }
        System.out.println("Size: "+super.size());
        System.out.println("Elements: "+elements);
        System.out.println("Collisions: "+(collisions));
        System.out.println("Attempts: "+attempts);
        return value; 
    }
    
    
    
}
