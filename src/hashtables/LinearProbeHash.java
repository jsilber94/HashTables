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
    
    public LinearProbeHash(int size) {
        super(size);
    }
    
    @Override
    public Object put(int k, Object v){
        Object value = super.put(k, v);
        for(int i = (++k); i<super.size() && value!= null;i++){
            value = super.put(i, v);
        }
        if(value != null){
            throw new IndexOutOfBoundsException("No more room in the hashtable");
        }
        return value;
    }
    
    
}
