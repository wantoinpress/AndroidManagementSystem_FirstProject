package zdfwuy.newproject.Tool;

/**
 * Created by ASUS on 2021/3/20.
 */
import java.util.HashMap;
import java.util.Set;
public class tojson<K,V> extends HashMap<K,V> {
    public String toString() {
        Set<K> keys = super.keySet();
        StringBuilder bases = new StringBuilder("{");
        for (K k: keys) {
            bases.append("\""+k.toString()+"\":");
            bases.append("\""+super.get(k)+"\",");
        }
        bases.setCharAt(bases.length()-1,'}');
        return new String(bases);
    }
}
