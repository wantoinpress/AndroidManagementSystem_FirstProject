package zdfwuy.newproject.data_collection;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 2021/5/11.
 */
public class SerialMap1 implements Serializable {

    private Map<String,NewCloectionInfo> map;

    public Map<String, NewCloectionInfo> getMap() {
        return map;
    }

    public void setMap(Map<String, NewCloectionInfo> map) {
        this.map = map;
    }
}