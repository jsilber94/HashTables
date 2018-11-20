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
public class QuadraticProbeHash extends HashTable<Integer> {
    
    public QuadraticProbeHash(int size) {
        super(size);
    }
    
     @Override
    public Integer put(int k, Integer v){
        Integer value = super.put(k, v);
        for(int i = (++k); i<super.size() && value!= null;i++){
            int newKey = (int)Math.pow(i,2);
            if (newKey > super.size()){
                i = 0;
            }
            else{
                value = super.put(newKey, v);  
            }
        }
        return value;
    }
    
}
