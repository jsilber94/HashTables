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
    public Integer put(int k, Integer v){
        Integer value = super.put(k, v);
        for(int i = (++k); i<super.size() && value!= null;i++){
            value = super.put(i, v);
            if(i == super.size()-1){
                i = 0;
            }
            if(i ==k){
                new IndexOutOfBoundsException("");
            }
        }
        return value;
    }
    
    
}
