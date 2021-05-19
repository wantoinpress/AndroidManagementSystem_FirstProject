package zdfwuy.newproject.data_safeguard;

import com.alibaba.fastjson.JSONArray;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2021/5/9.
 */
public class SerializableMap implements Serializable {

    private Map<String,JSONArray> map;

    public Map<String, JSONArray> getMap() {
        return map;
    }

    public void setMap(HashMap<String, JSONArray> map) {
        this.map = map;
    }
}

