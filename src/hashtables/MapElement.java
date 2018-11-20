package hashtables;

import java.util.Objects;

/**
 *
 * @author Jesse
 */
public class MapElement {

    int key = 0;
    String value = "";

    public MapElement(String value) {
        this.value = value;
        key = (int) Math.random();
    }

    @Override
    public int hashCode() {
        int sLength = value.length();
        int hash = 0;
        for (int i = 0; i < sLength; i++) {
            hash = 11 * hash + value.charAt(i);
        }
        return hash;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
