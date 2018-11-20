package hashtables;

import java.util.Objects;

/**
 *
 * @author Jesse Silber
 */
public class MapElement<E> {

    int key = 0;
    E value;

    public MapElement(E value) {
        this.value = value;
        this.key = (int) (Math.random() * 100);
    }

    @Override
    public int hashCode() {
        return  key % 11; 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MapElement other = (MapElement) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

}
